package eapli.base.meetingmanagement.application;

import eapli.base.meetingmanagement.application.service.ScheduleMeetingService;

import java.util.Date;
import java.util.List;

public class ScheduleMeetingController {

    ScheduleMeetingService theService = new ScheduleMeetingService();

    public boolean scheduledMeeting(List<String> emails, Date date, int duration) {
        // TODO
        return theService.scheduledMeeting(emails, date, duration);
    }
}
