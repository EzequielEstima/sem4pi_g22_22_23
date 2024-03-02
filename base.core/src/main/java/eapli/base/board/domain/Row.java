package eapli.base.board.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.util.Objects;
@Embeddable
class Row implements Comparable<Row>, ValueObject {

    private RowIdentifier rowIdentifier;
    private RowTitle rowTitle;

    protected Row(RowIdentifier rowIdentifier){

            if (rowIdentifier == null) {
                throw new IllegalArgumentException("The row cannot be created with null row id");
            }
            this.rowIdentifier = rowIdentifier;

    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Row row = (Row) o;
        return Objects.equals(rowIdentifier, row.rowIdentifier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rowIdentifier);
    }

    protected Row(){
        // Only for ORM 
    }

    @Override
    public int compareTo(Row o) {
        return 0;
    }

    public String returnRowTitleString(){
        if (rowTitle == null)return "";
        return rowTitle.toString();
    }

    public String returnRowIdentifierString(){
        return rowIdentifier.toString();
    }
}
