package eapli.base.invitationmanagement.domain;

import eapli.base.usermanagement.domain.Person;

public class InvitationFactory {
    public Invitation build(long idInvitation, Person person) {
        return new Invitation(new InvitationIdentifier(idInvitation), new ResponseStatus(ResponseStatusValue.PENDING), person);
    }
    public Invitation buildAccepted(long idInvitation, Person person) {
        return new Invitation(new InvitationIdentifier(idInvitation), new ResponseStatus(ResponseStatusValue.ACCEPTED), person);
    }
}
