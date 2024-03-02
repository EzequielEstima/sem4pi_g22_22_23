package eapli.base.board.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.util.Objects;
@Embeddable
class Column implements Comparable<Column>, ValueObject {

    private ColumnIdentifier columnIdentifier;
    private ColumnTitle columnTitle;

    protected Column(ColumnIdentifier columnIdentifier) {
        if (columnTitle == null) {
            if (columnIdentifier == null) {
                throw new IllegalArgumentException("The column cannot be created with null column id");
            }
            this.columnIdentifier = columnIdentifier;
        }
    }

    protected Column(){
        // Only for ORM
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Column column = (Column) o;
        return Objects.equals(columnIdentifier, column.columnIdentifier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(columnIdentifier);
    }

    @Override
    public int compareTo(Column o) {
        return columnIdentifier.compareTo(o.columnIdentifier);
    }


    public String returnColumnTitleString(){
        if (columnTitle == null)return "";
        return columnTitle.toString();
    }

    public String returnColumnIdentifierString(){
        return columnIdentifier.toString();
    }
}
