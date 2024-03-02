package eapli.base.board.application.services;

import eapli.base.board.domain.Board;
import eapli.base.board.repositories.BoardRepository;
import eapli.base.exceptions.AlreadyDeactivatedException;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.infrastructure.persistence.RepositoryFactory;

public class ArchiveBoardService {
    public boolean archiveBoard(String boardTitle) throws AlreadyDeactivatedException {
        RepositoryFactory factory = PersistenceContext.repositories();
        BoardRepository boardRepository = factory.boardRepository();
        Board board = boardRepository.findBoardByTitle(boardTitle);
        board.archiveBoard();
        boardRepository.save(board);

        new AddNotificationService().addNotification("The board " + boardTitle +" was archived.", boardTitle);
        new AddTaskToBoardHistoryService().addArchiveBoardTaskToHistory(boardTitle);
        return true;
    }
}
