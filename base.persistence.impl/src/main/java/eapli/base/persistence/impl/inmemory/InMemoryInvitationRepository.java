package eapli.base.persistence.impl.inmemory;

import eapli.base.invitationmanagement.domain.Invitation;
import eapli.base.invitationmanagement.domain.InvitationIdentifier;

import eapli.base.invitationmanagement.repositories.InvitationRepository;
import eapli.base.usermanagement.domain.Person;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.util.List;

public class InMemoryInvitationRepository extends InMemoryDomainRepository<Invitation, InvitationIdentifier> implements InvitationRepository {

    @Override
    public List<Invitation> getInvitationWithIdMeeting(long meetingId) {
        return null;
    }

    @Override
    public List<Invitation> getPersonPendingInvitations(Person person) {
        return null;
    }
}
