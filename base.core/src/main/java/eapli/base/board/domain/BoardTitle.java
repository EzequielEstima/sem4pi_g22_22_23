package eapli.base.board.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;

import java.util.Objects;

public class BoardTitle implements Comparable<BoardTitle>, ValueObject{

    private String boardTitle;

    public BoardTitle(String boardTitle){
        if(StringPredicates.isNullOrEmpty(boardTitle)){
            throw new IllegalArgumentException("The board title cannot be null");
        }
        if(boardTitle.isBlank()){
            throw new IllegalArgumentException("The board title cannot be blank");
        }
        this.boardTitle = boardTitle;
    }

    protected BoardTitle(){
        //ORM use only
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoardTitle that = (BoardTitle) o;
        return Objects.equals(boardTitle, that.boardTitle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(boardTitle);
    }

    @Override
    public int compareTo(BoardTitle o) {
        return boardTitle.compareTo(o.boardTitle);
    }

    @Override
    public String toString() {
        return boardTitle;
    }
}
