package eapli.base.postitmanager.application;

import eapli.base.board.application.services.AddNotificationService;
import eapli.base.board.domain.Board;
import eapli.base.board.repositories.BoardRepository;
import eapli.base.boardhistory.domain.OperationValue;
import eapli.base.boardhistory.domain.Task;
import eapli.base.boardhistory.domain.TaskBuilder;
import eapli.base.boardhistory.repositories.BoardHistoryRepository;
import eapli.base.boardparticipantmanagement.domain.BoardParticipant;
import eapli.base.boardparticipantmanagement.repositories.BoardParticipantRepository;
import eapli.base.exceptions.CellDoesNotExistException;
import eapli.base.exceptions.CellIsEmptyException;
import eapli.base.exceptions.CellOccupiedException;
import eapli.base.exceptions.UserDidNotCreatePostItException;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.postitmanager.domain.PostIt;
import eapli.base.postitmanager.repositories.PostItRepository;
import eapli.base.usermanagement.domain.BoardOwner;
import eapli.base.usermanagement.domain.Person;
import eapli.base.usermanagement.repositories.PersonRepository;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import javax.persistence.NoResultException;

public class UndoLastChangePostItService {
    PostItRepository postItRepository = PersistenceContext.repositories().postItRepository();
    BoardRepository boardRepository = PersistenceContext.repositories().boardRepository();
    BoardHistoryRepository boardHistoryRepository = PersistenceContext.repositories().boardHistoryRepository();
    PersonRepository personRepository = PersistenceContext.repositories().personRepository();
    BoardParticipantRepository boardParticipantRepository = PersistenceContext.repositories().boardParticipantRepository();

    public void undoLastChangePostIt(String boardTittle, int column, int row) throws CellDoesNotExistException, CellIsEmptyException, UserDidNotCreatePostItException, CellOccupiedException {

        Board board = boardRepository.findBoardByTitle(boardTittle);

        Person person = getAuthenticatedPerson();

        BoardParticipant boardParticipant = person.boardParticipantOfBoard(board);
        BoardOwner boardOwner = person.boardOwnerOfBoard(board);

        PostIt postIt = board.verifyPostItCanBeUpdated(row, column, boardParticipant, boardOwner);

        PostIt lastVersionOfPostIt = getLastPostIt(postIt);

        undoLastChange(column, row, board, person, postIt, lastVersionOfPostIt);

    }

    private void undoLastChange(int column, int row, Board board, Person person,
                                PostIt postIt, PostIt lastVersionOfPostIt) throws CellOccupiedException {
        Task task = getTask(postIt,lastVersionOfPostIt);
        if(task.verifyIfTaskWasMovePostIt()){
                int[] cell = task.getLastPosition();
                board.removePostItFromCell(row, column);
                lastVersionOfPostIt.updateVersion();
                lastVersionOfPostIt.updateVersion();
                board.addPostIt(lastVersionOfPostIt, cell[1], cell[0]);
                save(person, board, postIt, lastVersionOfPostIt, column, row, OperationValue.CHANGE_POST_IT_POSITION);
            } else{
                lastVersionOfPostIt.updateVersion();
                lastVersionOfPostIt.updateVersion();
                board.updateCell(lastVersionOfPostIt, column, row);
                save(person, board, postIt, lastVersionOfPostIt, column, row, OperationValue.CHANGE_POST_IT_CONTENT);
            }
    }

    private Task getTask(PostIt postIt,PostIt lastVersionOfPostIt) {
        try {
            return boardHistoryRepository.getLastTaskForPostIt(postIt);
        } catch (NoResultException e) {
            return boardHistoryRepository.getLastTaskForPostIt(lastVersionOfPostIt);
        }
    }

    private PostIt getLastPostIt(PostIt postIt) {
        int version = postIt.returnPostItVersion();
        long id = postIt.returnPostItIdentifier();
        version--;
        return postItRepository.getLastVersionOfPostIt(version, id);
    }

    private Person getAuthenticatedPerson() {
        AuthorizationService authz = AuthzRegistry.authorizationService();
        SystemUser systemUser;
        if (authz.session().isPresent()) {
            systemUser = authz.session().get().authenticatedUser();
        } else {
            throw new IllegalStateException("Session must exist to create a board");
        }
        return personRepository.findPersonBySystemUser(systemUser);
    }

    private void save(Person person, Board board,
                      PostIt postIt, PostIt lastVersionOfPostIt,
                      int column, int row, OperationValue operationValue) {
        
        TaskBuilder taskBuilder = new TaskBuilder();
        
        //Check if the person is the board owner
        if (person.isBoardOwner(board)) {
            BoardOwner boardOwner = personRepository.findBoardOwnerByPerson(person);
            board.addTaskToHistory(taskBuilder.withBoardOwner(boardOwner).withPostIt(postIt).
                    withTaskId(boardHistoryRepository.getLastTaskId() + 1).withOperation(operationValue).build());

            new AddNotificationService().addNotification("The last change was removed in " + board.returnBoardTitleString()
                    + " on column " + column + " and row " + row + "by " + person.returnFullNameString(), board.returnBoardTitleString());
            postItRepository.save(lastVersionOfPostIt);
            boardRepository.save(board);
            
        }
        // Check if the person is a board participant
        else if (person.isBoardParticipant(board)) {
            BoardParticipant boardParticipant = boardParticipantRepository.findBoardParticipantByPerson(person);
            board.addTaskToHistory(taskBuilder.withBoardParticipant(boardParticipant).withPostIt(postIt).
                    withTaskId(boardHistoryRepository.getLastTaskId() + 1).withOperation(operationValue).build());
            new AddNotificationService().addNotification("The last change was removed in " + board.returnBoardTitleString()
                    + " on column " + column + " and row " + row + "by " + person.returnFullNameString(), board.returnBoardTitleString());
            postItRepository.save(lastVersionOfPostIt);
            boardRepository.save(board);
        }
        
    }
}
