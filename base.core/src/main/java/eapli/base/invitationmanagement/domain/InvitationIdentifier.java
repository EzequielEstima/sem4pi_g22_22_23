package eapli.base.invitationmanagement.domain;

import eapli.framework.domain.model.ValueObject;

import java.util.Objects;

public class InvitationIdentifier implements Comparable<InvitationIdentifier>, ValueObject {

    private long invitationId;

    public InvitationIdentifier(long invitationId) {
        if (invitationId <= 0) {
            throw new IllegalArgumentException("Invitation identifier cannot be negative or zero");
        }
        this.invitationId = invitationId;
    }

    protected InvitationIdentifier() {
        // for ORM
    }

    @Override
    public int compareTo(InvitationIdentifier o) {
        return Long.compare(invitationId, o.invitationId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvitationIdentifier that = (InvitationIdentifier) o;
        return Objects.equals(invitationId, that.invitationId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(invitationId);
    }

    public Long returnInvitationIdentifier(){
        return invitationId;
    }

}

