package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.invitationmanagement.domain.Invitation;
import eapli.base.invitationmanagement.domain.InvitationIdentifier;
import eapli.base.invitationmanagement.repositories.InvitationRepository;
import eapli.base.usermanagement.domain.Person;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.TypedQuery;
import java.util.List;

public class JpaInvitationRepository extends JpaAutoTxRepository<Invitation, InvitationIdentifier, InvitationIdentifier>  implements InvitationRepository {
    public JpaInvitationRepository(final TransactionalContext autoTx) {
        super(autoTx, "idInvitation");
    }
    public JpaInvitationRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(),
                "idInvitation");
    }

    @Override
    public List<Invitation> getInvitationWithIdMeeting(long meetingId) {
        TypedQuery<Invitation> query = createQuery(
                "SELECT i FROM Meeting m JOIN m.invitation i WHERE m.idMeeting.idMeeting = :meetingId",
                Invitation.class);
        query.setParameter("meetingId", meetingId);
        return query.getResultList();
    }

    @Override
    public List<Invitation> getPersonPendingInvitations(Person person) {
        TypedQuery<Invitation> query = createQuery(
                "SELECT i FROM Invitation i WHERE i.person = :person AND i.status.status = 'PENDING'",
                Invitation.class);
        query.setParameter("person", person);
        return query.getResultList();
    }
}
