package eapli.base.usermanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.EmbeddedId;
import java.util.Objects;

public class MeetingOwnerIdentifier implements Comparable<MeetingOwnerIdentifier>, ValueObject {
    long idMeetingOwner;

    public MeetingOwnerIdentifier(long idMeetingOwner) {
        if (idMeetingOwner <= 0) {
            throw new IllegalArgumentException("Meeting Owner identifier cannot be negative or zero");
        }
        this.idMeetingOwner = idMeetingOwner;
    }

    protected MeetingOwnerIdentifier() {
        // for ORM
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MeetingOwnerIdentifier that = (MeetingOwnerIdentifier) o;
        return Objects.equals(idMeetingOwner, that.idMeetingOwner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMeetingOwner);
    }

    @Override
    public int compareTo(MeetingOwnerIdentifier o) {
        return Long.compare(idMeetingOwner, o.idMeetingOwner);
    }
}
