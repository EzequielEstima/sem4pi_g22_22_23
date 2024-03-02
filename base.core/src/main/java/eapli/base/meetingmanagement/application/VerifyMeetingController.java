package eapli.base.meetingmanagement.application;

import eapli.base.meetingmanagement.application.service.ScheduleMeetingService;

import java.util.Date;
import java.util.List;

public class VerifyMeetingController {
    ScheduleMeetingService theService = new ScheduleMeetingService();
    public boolean verifyMeeting(List<String> emails, Date date, int duration) {
        // TODO
        return theService.verifyMeeting(emails, date, duration);

    }
}
