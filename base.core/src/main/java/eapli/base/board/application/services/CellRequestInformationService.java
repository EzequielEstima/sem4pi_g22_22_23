package eapli.base.board.application.services;

import eapli.base.board.domain.Board;
import eapli.base.board.repositories.BoardRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

public class CellRequestInformationService {
    BoardRepository boardRepository = PersistenceContext.repositories().boardRepository();

    public int getMaxColumn(String boardTittle) {
        Board board = boardRepository.findBoardByTitle(boardTittle);
        return board.maxColumn();
    }

    public int getMaxRow(String boardTittle) {
        Board board = boardRepository.findBoardByTitle(boardTittle);
        return board.maxRow();
    }
}
