package eapli.base.board.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.util.Objects;
@Embeddable
public class BoardStatus implements ValueObject {
    private boolean isActive;

    protected BoardStatus(boolean isActive){
        this.isActive = isActive;
    }

    protected BoardStatus(){
        //Only for ORM
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BoardStatus)) return false;
        BoardStatus that = (BoardStatus) o;
        return isActive == that.isActive;
    }

    @Override
    public int hashCode() {
        return Objects.hash(isActive);
    }
}
