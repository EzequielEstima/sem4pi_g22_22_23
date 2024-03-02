package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.coursemanagement.domain.Course;
import eapli.base.invitationmanagement.domain.Invitation;
import eapli.base.meetingmanagement.domain.Meeting;
import eapli.base.meetingmanagement.domain.MeetingIdentifier;
import eapli.base.usermanagement.domain.MeetingOwner;
import eapli.base.meetingmanagement.repositories.MeetingRepository;
import eapli.base.usermanagement.domain.Person;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class JpaMeetingRepository extends JpaAutoTxRepository<Meeting, MeetingIdentifier,MeetingIdentifier> implements MeetingRepository {

    public JpaMeetingRepository(final TransactionalContext autoTx) {
        super(autoTx, "idMeeting");
    }
    public JpaMeetingRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(),
                "idMeeting");
    }

    @Override
    public List<Meeting> findAllMeetingsWhoMatch(List<Person> people) {
        return createQuery("SELECT m FROM Meeting m JOIN m.invitation inv WHERE inv.person IN ( :people ) ",
                 Meeting.class)
                .setParameter("people", people).getResultList();
    }

    @Override
    public long findTotalNumberOfMeetings() {
        return count();
    }

    @Override
    public List<MeetingOwner> findIfPersonIsAMeetingOwner(Person person) {
        return createQuery("SELECT m FROM MeetingOwner m " +
                "WHERE m.person = :person", MeetingOwner.class)
                .setParameter("person", person).getResultList();
    }

    @Override
    public List<Meeting> findAllOwnerMeetings(SystemUser systemUser){
        return createQuery("SELECT m FROM Meeting m where m.meetingOwner.person IN (SELECT p FROM Person p WHERE p.systemUser = :systemUser) AND m.meetingState.isActive = TRUE", Meeting.class)
                .setParameter("systemUser", systemUser).getResultList();
    }

    @Override
    public long countNumberOfOwners() {
        return createQuery("SELECT COUNT(m) FROM MeetingOwner m", Long.class).getSingleResult();
    }

    @Override
    public List<Meeting> findAllMeetingsIParticipate(SystemUser user) {
        return createQuery("SELECT DISTINCT m FROM Meeting m where (m.meetingOwner.person IN (SELECT p FROM Person p WHERE p.systemUser = :systemUser)" +
                "OR :systemUser IN (SELECT p.systemUser FROM m.invitation i JOIN Person p ON i.person = p where i.status.status = 'ACCEPTED'))" +
                "AND m.meetingState.isActive = TRUE", Meeting.class)
                .setParameter("systemUser", user).getResultList();
    }

    @Override
    public Optional<Meeting> findMeetingContainingInvitation(Invitation invitation) {
        TypedQuery<Meeting> query = createQuery(
                "SELECT m FROM Meeting m JOIN m.invitation i WHERE i = :invitation", Meeting.class);
        query.setParameter("invitation", invitation);
        return Optional.of(query.getSingleResult());
    }
}
