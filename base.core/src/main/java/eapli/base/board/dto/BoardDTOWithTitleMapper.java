package eapli.base.board.dto;


import eapli.base.board.domain.Board;

public class BoardDTOWithTitleMapper {
    public static BoardDTOWithTitle doDTO(Board board){
        BoardDTOWithTitleBuilder builder = new BoardDTOWithTitleBuilder();
        return builder.withTitle(board.returnBoardTitleString()).build();
    }
}
