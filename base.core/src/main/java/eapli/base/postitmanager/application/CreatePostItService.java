package eapli.base.postitmanager.application;

import eapli.base.board.domain.Board;
import eapli.base.board.domain.Notification;
import eapli.base.board.repositories.BoardRepository;
import eapli.base.boardhistory.domain.OperationValue;
import eapli.base.boardhistory.domain.TaskBuilder;
import eapli.base.boardhistory.repositories.BoardHistoryRepository;
import eapli.base.boardparticipantmanagement.domain.BoardParticipant;
import eapli.base.boardparticipantmanagement.repositories.BoardParticipantRepository;
import eapli.base.exceptions.*;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.postitmanager.domain.PostIt;
import eapli.base.postitmanager.domain.PostItFactory;
import eapli.base.postitmanager.repositories.PostItRepository;
import eapli.base.usermanagement.domain.BoardOwner;
import eapli.base.usermanagement.domain.Person;
import eapli.base.usermanagement.repositories.PersonRepository;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

public class CreatePostItService {
    PostItRepository postItRepository = PersistenceContext.repositories().postItRepository();
    BoardRepository boardRepository = PersistenceContext.repositories().boardRepository();
    BoardHistoryRepository boardHistoryRepository = PersistenceContext.repositories().boardHistoryRepository();
    PersonRepository personRepository = PersistenceContext.repositories().personRepository();
    BoardParticipantRepository boardParticipantRepository = PersistenceContext.repositories().boardParticipantRepository();


    public boolean createPostIt(String boardTittle, String content, int column, int row) throws CellOccupiedException,
            ZeroParameterException, NegativeParameterException, ParameterNullBlankException,
            InvalidContentSizeForAPostItException {

        //create postIt
        PostItFactory postItFactory = new PostItFactory();
        PostIt postIt = postItFactory.build(content,postItRepository.count()+1);

        //get the board and add the postIt to it
        Board board = boardRepository.findBoardByTitle(boardTittle);
        board.addPostIt(postIt, column, row);

        //get person with session
        AuthorizationService authz = AuthzRegistry.authorizationService();
        SystemUser systemUser;
        if (authz.session().isPresent()) {
            systemUser = authz.session().get().authenticatedUser();
        }
        else {
            throw new IllegalStateException("Session must exist to create a board");
        }
        Person person = personRepository.findPersonBySystemUser(systemUser);

        //create task and save it
        TaskBuilder taskBuilder = new TaskBuilder();
        if (person.isBoardOwner(board)) {
            BoardOwner boardOwner = personRepository.findBoardOwnerByPerson(person);
            board.addTaskToHistory(taskBuilder.withBoardOwner(boardOwner).withPostIt(postIt).
                    withTaskId(boardHistoryRepository.getLastTaskId()+1).withOperation(OperationValue.ADD).build());

            board.addNotification(new Notification("A new post it was added in "+board.returnBoardTitleString()
                    +" on column "+column+" and row "+row+ "by "+person.returnFullNameString()));
            postItRepository.save(postIt);
            boardRepository.save(board);
        }
        else if (person.isBoardParticipant(board)) {
            BoardParticipant boardParticipant =boardParticipantRepository.findBoardParticipantByPerson(person);
            board.addTaskToHistory(taskBuilder.withBoardParticipant(boardParticipant).withPostIt(postIt).
                    withTaskId(boardHistoryRepository.getLastTaskId()+1).withOperation(OperationValue.ADD).build());
            board.addNotification(new Notification("A new post it was added in "+board.returnBoardTitleString()
                    +" on column "+column+" and row "+row+ "by "+person.returnFullNameString()));
            postItRepository.save(postIt);
            boardRepository.save(board);
        }

        return true;
    }
}
