package eapli.base.postitmanager.application.service;


import eapli.base.board.application.services.AddNotificationService;
import eapli.base.board.application.services.AddTaskToBoardHistoryService;
import eapli.base.board.domain.Board;
import eapli.base.board.repositories.BoardRepository;
import eapli.base.boardparticipantmanagement.domain.BoardParticipant;
import eapli.base.exceptions.*;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.postitmanager.domain.PostIt;
import eapli.base.postitmanager.domain.PostItFactory;
import eapli.base.postitmanager.repositories.PostItRepository;
import eapli.base.usermanagement.domain.BoardOwner;
import eapli.base.usermanagement.domain.Person;
import eapli.base.usermanagement.repositories.PersonRepository;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

public class ChangePostItContentService {

    public boolean changePostItContent(String boardTitle, Integer row, Integer column, String content) throws ZeroParameterException, ParameterNullBlankException, NegativeParameterException, InvalidContentSizeForAPostItException, CellDoesNotExistException, CellIsEmptyException, UserDidNotCreatePostItException {
        BoardRepository boardRepo = PersistenceContext.repositories().boardRepository();
        PersonRepository personRepo = PersistenceContext.repositories().personRepository();
        PostItRepository postItRepo = PersistenceContext.repositories().postItRepository();

        Board board = boardRepo.findBoardByTitle(boardTitle);

        SystemUser systemUser = AuthzRegistry.authorizationService().session().get().authenticatedUser();
        Person person = personRepo.findPersonBySystemUser(systemUser);

        BoardParticipant boardParticipant = person.boardParticipantOfBoard(board);
        BoardOwner boardOwner = person.boardOwnerOfBoard(board);

        PostIt oldPostIt = board.verifyPostItCanBeUpdated(row, column, boardParticipant, boardOwner);
        long id = oldPostIt.identity().returnPostItIdentifier();
        int ver = oldPostIt.identity().returnPostItVersion();

        PostIt newPostIt = new PostItFactory().buildFromExistingPostIt(content, id, ver);

        postItRepo.save(newPostIt);

        board.updateCell(newPostIt,row,column);
        boardRepo.save(board);

        new AddNotificationService().addNotification("The post-it in row " + row +" and column " + column + " was updated" , boardTitle);
        new AddTaskToBoardHistoryService().addChangePostItContentTaskToHistory(boardTitle,boardParticipant,boardOwner,oldPostIt);

        return false;
    }
}
