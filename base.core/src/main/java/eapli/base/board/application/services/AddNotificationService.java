package eapli.base.board.application.services;

import eapli.base.board.domain.Board;
import eapli.base.board.domain.Notification;
import eapli.base.board.repositories.BoardRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

public class AddNotificationService {
    public boolean addNotification(String message, String boardTitle){
        BoardRepository boardRepository = PersistenceContext.repositories().boardRepository();
        Board board = boardRepository.findBoardByTitle(boardTitle);
        board.addNotification(new Notification(message));
        boardRepository.save(board);
        return true;
    }
}
