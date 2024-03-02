package eapli.base.meetingmanagement.application;

import eapli.base.meetingmanagement.application.service.CancelMeetingService;
import eapli.base.meetingmanagement.dto.MeetingDTOWithIdDate;

public class CancelMeetingController {
    public void cancelMeeting(MeetingDTOWithIdDate meetingDTO){
        CancelMeetingService service = new CancelMeetingService();
        service.cancelMeeting(meetingDTO);
    }
}
