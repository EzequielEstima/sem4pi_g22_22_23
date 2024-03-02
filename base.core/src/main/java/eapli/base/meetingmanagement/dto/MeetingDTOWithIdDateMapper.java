package eapli.base.meetingmanagement.dto;

import eapli.base.meetingmanagement.domain.Meeting;

public class MeetingDTOWithIdDateMapper {
    public static MeetingDTOWithIdDate toDTO(Meeting meeting){
        MeetingDTOWithIdDateBuilder builder = new MeetingDTOWithIdDateBuilder();
        return builder.withId(meeting.returnMeetingIdentifier()).withDate(meeting.returnScheduledDateString()).build();
    }
}
