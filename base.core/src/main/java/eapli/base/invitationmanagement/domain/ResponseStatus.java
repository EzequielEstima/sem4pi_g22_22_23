package eapli.base.invitationmanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Objects;

@Embeddable
public class ResponseStatus implements ValueObject {
    @Enumerated(EnumType.STRING)
    private ResponseStatusValue status;

    public ResponseStatus(ResponseStatusValue status) {
        this.status = status;
    }

    public ResponseStatus(String status) {
        if (status == null || status.isEmpty()) {
            throw new IllegalArgumentException("Status cannot be null or empty");
        }
        this.status = ResponseStatusValue.valueOf(status);
    }
    protected ResponseStatus() {
        //for ORM
    }

    public String returnResponseStatus() {
        return status.toString();
    }
    public int returnResponseStatusInt(){
        return status.getState();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResponseStatus that = (ResponseStatus) o;
        return Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status);
    }
}
