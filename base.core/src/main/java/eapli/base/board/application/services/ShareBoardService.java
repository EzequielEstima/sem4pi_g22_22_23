package eapli.base.board.application.services;

import eapli.base.board.domain.Board;
import eapli.base.board.domain.Notification;
import eapli.base.board.repositories.BoardRepository;
import eapli.base.boardhistory.domain.OperationValue;
import eapli.base.boardhistory.domain.Task;
import eapli.base.boardhistory.domain.TaskBuilder;
import eapli.base.boardhistory.repositories.BoardHistoryRepository;
import eapli.base.boardparticipantmanagement.domain.BoardParticipant;
import eapli.base.boardparticipantmanagement.domain.BoardParticipantFactory;
import eapli.base.boardparticipantmanagement.repositories.BoardParticipantRepository;

import eapli.base.exceptions.DuplicateCreationException;
import eapli.base.exceptions.ParameterNullBlankException;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.infrastructure.persistence.RepositoryFactory;
import eapli.base.usermanagement.domain.Person;
import eapli.base.usermanagement.repositories.BoardOwnerRepository;
import eapli.base.usermanagement.repositories.PersonRepository;

public class ShareBoardService {
        RepositoryFactory repositoryFactory = PersistenceContext.repositories();
        BoardParticipantRepository boardParticipantRepository = repositoryFactory.boardParticipantRepository();
        BoardRepository boardRepository = repositoryFactory.boardRepository();
        PersonRepository personRepository = repositoryFactory.personRepository();
    public boolean shareBoard(String boardTitle, String email, boolean permission) throws ParameterNullBlankException, DuplicateCreationException {
        Board board = boardRepository.findBoardByTitle(boardTitle);
        BoardParticipantFactory factory = new BoardParticipantFactory();
        BoardParticipant boardParticipant = factory.buildBoardParticipant(boardParticipantRepository.findMaxId() + 1, permission, board);
        Person person = personRepository.findPersonByEmail(email);
        person.addBoardParticipant(boardParticipant);
        boardParticipantRepository.save(boardParticipant);
        personRepository.save(person);

        new AddNotificationService().addNotification("The board " + boardTitle +" was shared with " + person.returnFullNameString(), boardTitle);
        new AddTaskToBoardHistoryService().addShareBoardTaskToHistory(boardTitle, boardParticipant);
        return true;
    }
}
