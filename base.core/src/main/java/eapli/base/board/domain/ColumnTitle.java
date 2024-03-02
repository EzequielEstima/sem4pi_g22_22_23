package eapli.base.board.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;

import java.util.Objects;

class ColumnTitle implements Comparable<ColumnTitle>, ValueObject {
    private String columnTitle;

    protected ColumnTitle(String columnTitle){
        if(StringPredicates.isNullOrEmpty(columnTitle)){
            throw new IllegalArgumentException("The column title cannot be null");
        }
        if(columnTitle.isBlank()){
            throw new IllegalArgumentException("The column title cannot be blank");
        }
        this.columnTitle = columnTitle;
    }

    protected ColumnTitle(){
        //ORM use only
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ColumnTitle that = (ColumnTitle) o;
        return Objects.equals(columnTitle, that.columnTitle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(columnTitle);
    }

    @Override
    public int compareTo(ColumnTitle o) {
        return columnTitle.compareTo(o.columnTitle);
    }

    @Override
    public String toString() {
        return columnTitle;
    }
}
