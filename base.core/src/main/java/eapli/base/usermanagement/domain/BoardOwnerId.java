package eapli.base.usermanagement.domain;

import eapli.framework.domain.model.ValueObject;

import java.util.Objects;

public class BoardOwnerId implements Comparable<BoardOwnerId>, ValueObject {

    private Long boardOwner_Id;

    public BoardOwnerId(long boardOwnerId){
        if(boardOwnerId<=0){
            throw new IllegalArgumentException("The board owner id cannot be 0 or less.");
        }
        this.boardOwner_Id = boardOwnerId;
    }

    protected BoardOwnerId(){
        // for ORM
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoardOwnerId boardOwnerId1 = (BoardOwnerId) o;
        return Objects.equals(boardOwner_Id, boardOwnerId1.boardOwner_Id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(boardOwner_Id);
    }

    @Override
    public int compareTo(BoardOwnerId o){
        return (int)(boardOwner_Id-o.boardOwner_Id);
    }

    @Override
    public String toString() {
        return boardOwner_Id.toString();
    }
}
