package eapli.base.invitationmanagement.domain;

import eapli.base.usermanagement.domain.Person;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Invitation implements AggregateRoot<InvitationIdentifier> {

    private ResponseStatus status;
    @EmbeddedId
    private InvitationIdentifier idInvitation;

    @ManyToOne(cascade = CascadeType.ALL)
    private Person person;

    protected Invitation(InvitationIdentifier idInvitation, ResponseStatus status, Person person) {
        if (idInvitation == null || status == null || person == null) {
            throw new IllegalArgumentException("Parameters can't be null");
        }
        this.idInvitation = idInvitation;
        this.status = status;
        this.person = person;
    }

    protected Invitation() {
        //for ORM
    }
    public ResponseStatus returnResponseStatus() {
        return status;
    }

    public String returnResponseStatusString(){
        return status.returnResponseStatus();
    }

    public String returnPersonNameString(){
        return person.returnFullNameString();
    }

    public boolean updateResponseStatus(String newStatus){
        if(status.returnResponseStatusInt() != 1) {
            throw new IllegalArgumentException("Only pending invitations can have its response status updated");
        }
        status = new ResponseStatus(newStatus);
        return true;
    }
    @Override
    public boolean sameAs(Object other) {
        if (!(other instanceof Invitation)) {
            return false;
        }
        final Invitation that = (Invitation) other;

        return idInvitation.equals(that.idInvitation) && status.equals(that.status) && person.equals(that.person);
    }

    @Override
    public int compareTo(InvitationIdentifier other) {
        return AggregateRoot.super.compareTo(other);
    }

    @Override
    public InvitationIdentifier identity() {
        return idInvitation;
    }

    @Override
    public boolean hasIdentity(InvitationIdentifier id) {
        return AggregateRoot.super.hasIdentity(id);
    }

}
