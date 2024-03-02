package eapli.base.boardhistory.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Objects;
@Embeddable
public class Operation implements ValueObject {

@Enumerated(EnumType.STRING)
    private OperationValue operationValue;
    protected Operation(OperationValue operationValue){
        this.operationValue = operationValue;
    }

    protected Operation(){

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operation operation = (Operation) o;
        return operationValue == operation.operationValue;
    }

    @Override
    public int hashCode() {
        return Objects.hash(operationValue);
    }

    @Override
    public String toString() {
        return operationValue.toString();
    }

    public OperationValue operationValue() {
        return this.operationValue;
    }
}
