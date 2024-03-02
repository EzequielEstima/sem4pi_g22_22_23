package eapli.base.board.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;

import java.util.Objects;

class RowTitle implements Comparable<RowTitle>, ValueObject {
    private String rowTitle;

    protected RowTitle(String rowTitle){
        if(StringPredicates.isNullOrEmpty(rowTitle)){
            throw new IllegalArgumentException("The row title cannot be null");
        }
        if(rowTitle.isBlank()){
            throw new IllegalArgumentException("The row title cannot be blank");
        }
        this.rowTitle = rowTitle;
    }

    protected RowTitle(){
        //ORM use only
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RowTitle that = (RowTitle) o;
        return Objects.equals(rowTitle, that.rowTitle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rowTitle);
    }

    @Override
    public int compareTo(RowTitle o) {
        return rowTitle.compareTo(o.rowTitle);
    }

    @Override
    public String toString() {
        return rowTitle;
    }


}
