package eapli.base.meetingmanagement.application.service;

import eapli.base.courseclasses.application.services.VerifyIfExistAClassForThatPersonAtThisTimeService;
import eapli.base.courseclasses.application.services.VerifyIfExistAExtraClassForThatPersonAtThisTimeService;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.meetingmanagement.domain.MeetingFactory;
import eapli.base.meetingmanagement.domain.Meeting;
import eapli.base.invitationmanagement.repositories.InvitationRepository;
import eapli.base.meetingmanagement.repositories.MeetingRepository;
import eapli.base.usermanagement.application.services.ListPersonService;
import eapli.base.usermanagement.domain.Person;
import eapli.base.usermanagement.repositories.PersonRepository;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ScheduleMeetingService {

    private final VerifyIfExistAClassForThatPersonAtThisTimeService classService =
            new VerifyIfExistAClassForThatPersonAtThisTimeService();

    private final VerifyIfExistAExtraClassForThatPersonAtThisTimeService extraClassService =
            new VerifyIfExistAExtraClassForThatPersonAtThisTimeService();
    private final ListPersonService listPersonService = new ListPersonService();
    private final ListMeetingService listMeetingService = new ListMeetingService();

    private final MeetingRepository meetingRepository = PersistenceContext.repositories().meetingRepository();
  private final InvitationRepository invitationRepository = PersistenceContext.repositories().invitationRepository();
  private final PersonRepository personRepository = PersistenceContext.repositories().personRepository();
    public boolean verifyMeeting(List<String> emails, Date date, int duration) {
        // TODO
        List<Person> people = listPersonService.getPersonsByEmail(emails);
        List<Boolean> areAvailable = new ArrayList<>();
        areAvailable.add(listMeetingService.verifyIfExistAMeeting(people,date, duration));
        areAvailable.add(classService.verifyIfExistAClass(people,date, duration));
        areAvailable.add(extraClassService.verifyIfExistAExtraClass(people,date, duration));

        for (Boolean available : areAvailable) {
            if (available) {
                return false;
            }
        }
        return true;
    }
    public boolean scheduledMeeting(List<String> emails, Date date, int duration) {
        // TODO
        MeetingFactory factory = new MeetingFactory();
        AuthorizationService authz = AuthzRegistry.authorizationService();
        SystemUser user = authz.session().orElseThrow().authenticatedUser();
        Person personOwner = personRepository.findPersonBySystemUser(user);
        List<EmailAddress> emailAddresses = new ArrayList<>();
        for (String email : emails) {
            emailAddresses.add(EmailAddress.valueOf(email));
        }
        List<Person> invitatedPerson = personRepository.findAllPersonsWhoMatch(emailAddresses);
        List<Long> longsId = new ArrayList<>();
        longsId.add(invitationRepository.count()+1);
        for (int i=0 ; i<invitatedPerson.size() ; i++) {
            longsId.add(longsId.get(i)+1);
        }
        Meeting meeting= factory.build(meetingRepository.count()+1, personOwner,
                meetingRepository.countNumberOfOwners()+1, invitatedPerson,longsId,duration,date);
        return meetingRepository.save(meeting) != null;
    }

}
