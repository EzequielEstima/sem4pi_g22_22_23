package eapli.base.usermanagement.domain;

import eapli.base.board.domain.Board;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
@Entity
public class BoardOwner implements AggregateRoot<BoardOwnerId> {

    @EmbeddedId
    private BoardOwnerId boardOwnerId;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Board> boardList = new ArrayList<>();

    protected BoardOwner(BoardOwnerId boardOwnerId, Board board){
        if(boardOwnerId == null){
            throw new IllegalArgumentException("Board Owner cannot be created with null Value Objects");
        }
        this.boardOwnerId = boardOwnerId;
        addBoard(board);
    }

    protected BoardOwner(){
        //ORM use only
    }

    @Override
    public boolean sameAs(Object other) {
        if (!(other instanceof BoardOwner)) {
            return false;
        }

        final BoardOwner that = (BoardOwner) other;

        return this.boardOwnerId.equals(that.boardOwnerId);
    }

    @Override
    public BoardOwnerId identity() {
        return boardOwnerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoardOwner that = (BoardOwner) o;
        return Objects.equals(boardOwnerId, that.boardOwnerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(boardOwnerId);
    }

    public boolean addBoard(Board board){
        if(boardList.contains(board)){
            throw new IllegalArgumentException("The Board is already associated with this BoardOwner");
        }
        boardList.add(board);
        return true;
    }

    public boolean isBoardOwner(Board board) {
        if(boardList.contains(board)){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return boardOwnerId.toString();
    }
}