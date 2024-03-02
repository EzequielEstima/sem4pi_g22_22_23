package eapli.base.meetingmanagement.repositories;

import eapli.base.invitationmanagement.domain.Invitation;
import eapli.base.meetingmanagement.domain.Meeting;
import eapli.base.meetingmanagement.domain.MeetingIdentifier;
import eapli.base.usermanagement.domain.MeetingOwner;
import eapli.base.usermanagement.domain.Person;
import eapli.framework.domain.repositories.DomainRepository;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;


import java.util.List;
import java.util.Optional;

public interface MeetingRepository extends DomainRepository<MeetingIdentifier, Meeting> {
    public List<Meeting> findAllMeetingsWhoMatch(List<Person> person);
    public long findTotalNumberOfMeetings();
    public List<MeetingOwner> findIfPersonIsAMeetingOwner(Person person);
    public List<Meeting> findAllOwnerMeetings(SystemUser systemUser);

    long countNumberOfOwners();

    List<Meeting> findAllMeetingsIParticipate(SystemUser user);

    Optional<Meeting> findMeetingContainingInvitation(Invitation invitation);
}
