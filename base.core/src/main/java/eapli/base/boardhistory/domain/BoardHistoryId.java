package eapli.base.boardhistory.domain;

import eapli.framework.domain.model.ValueObject;

import java.util.Objects;

public class BoardHistoryId implements Comparable<BoardHistoryId>, ValueObject {

    private long boardHistory_Id;

    protected BoardHistoryId(long boardHistoryId){
        if(boardHistoryId<=0){
            throw new IllegalArgumentException("The board history id cannot be 0 or less.");
        }
        this.boardHistory_Id = boardHistoryId;
    }

    protected BoardHistoryId(){
        // for ORM
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoardHistoryId that = (BoardHistoryId) o;
        return boardHistory_Id == that.boardHistory_Id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(boardHistory_Id);
    }

    @Override
    public int compareTo(BoardHistoryId o) {
        return (int)(boardHistory_Id-o.boardHistory_Id);
    }
}
