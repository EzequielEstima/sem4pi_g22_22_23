package eapli.base.app.common.console.presentation.meeting;


import eapli.base.meetingmanagement.application.ScheduleMeetingController;
import eapli.base.meetingmanagement.application.VerifyMeetingController;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ScheduleMeetingUI extends AbstractUI {
    private final ScheduleMeetingController scheduleMeetingController = new ScheduleMeetingController();
    private final VerifyMeetingController verifyMeetingController = new VerifyMeetingController();
    @Override
    protected boolean doShow() {
        // TODO
        try {
            boolean conf = true;
            List<String> emails = new ArrayList<>();
            while (conf) {
                String email = Console.readLine("Email of the invited user:");
                emails.add(email);
                conf = Console.readBoolean("Want to invite someone else?(y/n)");
            }

            Date date = Console.readDate("Date to be scheduled (yyyy/MM/dd HH:mm):", "yyyy/MM/dd HH:mm");

            int duration = Console.readInteger("Duration of the meeting in minutes:");

            System.out.print("\n\n");

            if (verifyMeetingController.verifyMeeting(emails, date, duration)) {
                boolean op = Console.readBoolean("Do you want to schedule the meeting?(y/n)");
                return schedule(emails, date, duration, op);
            } else {
                boolean op = Console.readBoolean("One or more persons are not available, " +
                        "do you want to schedule the meeting anyway?(y/n)");
                return schedule(emails, date, duration, op);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    return false;
    }

    private boolean schedule(List<String> emails, Date date, int duration, boolean op) {
        if (op) {
            boolean ret = scheduleMeetingController.scheduledMeeting(emails, date, duration);
            if (ret) {
                System.out.println("Meeting scheduled with success!");
            } else {
                System.out.println("Something went wrong, please try again!");
            }
            return ret;
        } else {
            return false;
        }
    }

    @Override
    public String headline() {
        return "Schedule a meeting";
    }
}
