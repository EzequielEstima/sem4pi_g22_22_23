package eapli.base.usermanagement.domain;

import eapli.base.board.domain.Board;

public class BoardOwnerBuilder {

    private BoardOwnerId boardOwnerId;
    private Board board;

    public BoardOwnerBuilder withBoardOwnerId(BoardOwnerId boardOwnerId){
        this.boardOwnerId = boardOwnerId;
        return this;
    }

    public BoardOwnerBuilder withBoard(Board board){
        this.board = board;
        return this;
    }

    public BoardOwner build(){
        return new BoardOwner(this.boardOwnerId, this.board);
    }
}
