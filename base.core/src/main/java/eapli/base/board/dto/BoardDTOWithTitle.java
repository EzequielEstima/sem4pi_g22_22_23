package eapli.base.board.dto;

import eapli.base.board.domain.BoardTitle;

public class BoardDTOWithTitle {
    public String boardTitle;
    protected BoardDTOWithTitle(String boardTitle){
        this.boardTitle = boardTitle;
    }

    @Override
    public String toString() {
        return boardTitle;
    }
}
