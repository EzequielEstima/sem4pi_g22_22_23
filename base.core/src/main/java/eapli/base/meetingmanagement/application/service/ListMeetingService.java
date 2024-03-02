package eapli.base.meetingmanagement.application.service;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.meetingmanagement.domain.Meeting;
import eapli.base.meetingmanagement.repositories.MeetingRepository;
import eapli.base.usermanagement.domain.Person;

import java.util.List;

public class ListMeetingService {
    private final MeetingRepository meetingRepository = PersistenceContext.repositories().meetingRepository();

    public boolean verifyIfExistAMeeting(List<Person> people, java.util.Date utilDate, int duration) {
        // TODO
        List<Meeting> meetings = meetingRepository.findAllMeetingsWhoMatch(people);

        if (meetings.isEmpty()){
            return false;
        }

        for (Meeting meeting : meetings){
            if (meeting.verifyIfIsTheMeetingDate(utilDate,duration)) {
                return true;
            }
        }

        return false;
    }
}
