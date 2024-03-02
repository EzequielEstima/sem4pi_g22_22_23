package eapli.base.board.domain;

import eapli.base.AppSettings;
import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.util.Objects;
@Embeddable
class ColumnIdentifier implements Comparable<ColumnIdentifier>, ValueObject {

    private Integer columnIdentifier;

    protected ColumnIdentifier(Integer columnIdentifier){

        if(columnIdentifier <= 0){
            throw new IllegalArgumentException("The column id cannot be 0 or less.");
        }
        if(columnIdentifier > new AppSettings().getColumnLimit()){
            throw new IllegalArgumentException("The column id cannot be more than " + new AppSettings().getColumnLimit() + ".");
        }
        this.columnIdentifier = columnIdentifier;
    }

    protected ColumnIdentifier(){
        // Only for ORM
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ColumnIdentifier that = (ColumnIdentifier) o;
        return Objects.equals(columnIdentifier, that.columnIdentifier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(columnIdentifier);
    }

    @Override
    public int compareTo(ColumnIdentifier o) {
        return columnIdentifier.compareTo(o.columnIdentifier);
    }

    @Override
    public String toString() {
        return ""+columnIdentifier;
    }
}
