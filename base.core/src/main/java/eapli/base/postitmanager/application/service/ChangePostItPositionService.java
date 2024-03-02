package eapli.base.postitmanager.application.service;

import eapli.base.board.application.services.AddNotificationService;
import eapli.base.board.application.services.AddTaskToBoardHistoryService;
import eapli.base.board.domain.Board;
import eapli.base.board.repositories.BoardRepository;
import eapli.base.boardparticipantmanagement.domain.BoardParticipant;
import eapli.base.exceptions.*;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.postitmanager.domain.PostIt;
import eapli.base.usermanagement.domain.BoardOwner;
import eapli.base.usermanagement.domain.Person;
import eapli.base.usermanagement.repositories.PersonRepository;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

public class ChangePostItPositionService {
    public boolean changePostItPosition(String boardTitle, Integer oldRow, Integer oldColumn, Integer newRow, Integer newColumn) throws ZeroParameterException, ParameterNullBlankException, NegativeParameterException, InvalidContentSizeForAPostItException, CellDoesNotExistException, CellIsEmptyException, UserDidNotCreatePostItException {
        BoardRepository boardRepo = PersistenceContext.repositories().boardRepository();
        PersonRepository personRepo = PersistenceContext.repositories().personRepository();

        Board board = boardRepo.findBoardByTitle(boardTitle);

        SystemUser systemUser = AuthzRegistry.authorizationService().session().get().authenticatedUser();
        Person person = personRepo.findPersonBySystemUser(systemUser);

        BoardParticipant boardParticipant = person.boardParticipantOfBoard(board);
        BoardOwner boardOwner = person.boardOwnerOfBoard(board);

        PostIt postIt = board.verifyPostItCanBeUpdated(oldRow, oldColumn, boardParticipant, boardOwner);

        if(board.verifyIfCellIsAvailable(newRow,newColumn)){
            board.updateCell(null, oldRow, oldColumn);
            board.updateCell(postIt, newRow, newColumn);

            boardRepo.save(board);

            new AddNotificationService().addNotification("The post-it in row " + oldRow +" and column " + oldColumn + " was moved to row " + newRow + " and column " + newColumn, boardTitle);
            new AddTaskToBoardHistoryService().addChangePostItPositionTaskToHistory(boardTitle,boardParticipant,boardOwner,postIt,oldRow,oldColumn,newRow,newColumn);
        }
        return true;
    }
}
