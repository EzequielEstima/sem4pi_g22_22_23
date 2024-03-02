package eapli.base.board.domain;

import eapli.base.AppSettings;
import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.util.Objects;
@Embeddable
class RowIdentifier implements Comparable<RowIdentifier>, ValueObject {

    private Integer rowIdentifier;

    protected RowIdentifier(int rowIdentifier){

        if(rowIdentifier <= 0){
            throw new IllegalArgumentException("The row id cannot be 0 or less.");
        }
        if(rowIdentifier > new AppSettings().getRowLimit()){
            throw new IllegalArgumentException("The row id cannot be more than " + new AppSettings().getRowLimit() + ".");
        }
        this.rowIdentifier = rowIdentifier;
    }

    protected RowIdentifier(){
        // Only for ORM
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RowIdentifier that = (RowIdentifier) o;
        return Objects.equals(rowIdentifier, that.rowIdentifier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rowIdentifier);
    }

    @Override
    public int compareTo(RowIdentifier o) {
        return rowIdentifier.compareTo(o.rowIdentifier);
    }

    @Override
    public String toString() {
        return ""+ rowIdentifier;
    }
}
