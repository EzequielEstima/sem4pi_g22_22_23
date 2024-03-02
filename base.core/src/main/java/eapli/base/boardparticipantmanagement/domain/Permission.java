package eapli.base.boardparticipantmanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.util.Objects;
@Embeddable
public class Permission implements ValueObject {
    private boolean hasWritePermission;

    protected Permission(boolean hasWritePermission){
        this.hasWritePermission = hasWritePermission;
    }
    protected Permission(){
        //Only for ORM
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Permission)) return false;
        Permission that = (Permission) o;
        return hasWritePermission == that.hasWritePermission;
    }

    @Override
    public int hashCode() {
        return Objects.hash(hasWritePermission);
    }

    public boolean hasWritePermission() {
        return hasWritePermission;
    }
}
