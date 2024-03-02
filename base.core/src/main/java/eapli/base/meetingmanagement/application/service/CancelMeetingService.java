package eapli.base.meetingmanagement.application.service;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.meetingmanagement.domain.Meeting;
import eapli.base.meetingmanagement.domain.MeetingIdentifier;
import eapli.base.meetingmanagement.dto.MeetingDTOWithIdDate;
import eapli.base.meetingmanagement.repositories.MeetingRepository;

public class CancelMeetingService {
    public void cancelMeeting(MeetingDTOWithIdDate meetingDTO){
        MeetingRepository meetingRepository = PersistenceContext.repositories().meetingRepository();
        Meeting meeting = meetingRepository.ofIdentity(new MeetingIdentifier(meetingDTO.meetingId)).get();
        meeting.cancelMeeting();
        meetingRepository.save(meeting);
    }
}
