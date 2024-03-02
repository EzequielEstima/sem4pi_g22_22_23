package eapli.base.app.common.console.presentation.meeting;

import eapli.base.meetingmanagement.application.CancelMeetingController;
import eapli.base.meetingmanagement.application.ListActiveMeetingsIOwnController;
import eapli.base.meetingmanagement.dto.MeetingDTOWithIdDate;
import eapli.base.questionmanagement.dto.QuestionDTOWithId;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

import java.util.List;
import java.util.Scanner;

public class CancelMeetingUI extends AbstractUI {

    @Override
    protected boolean doShow() {
        ListActiveMeetingsIOwnController listActiveMeetingsIOwnController = new ListActiveMeetingsIOwnController();
        List<MeetingDTOWithIdDate> meetingDTOList = listActiveMeetingsIOwnController.listActiveMeetingsIOwn();
        if(!meetingDTOList.isEmpty()){
            SelectWidget<MeetingDTOWithIdDate> selected = new SelectWidget<>("Select a meeting to cancel.", meetingDTOList, new MeetingDTOWithIdDatePrinter());
            selected.show();
            MeetingDTOWithIdDate meetingDTO = selected.selectedElement();
            System.out.println("Are you sure you want to cancel this meeting? (y/n)");
            Scanner read = new Scanner(System.in);
            String value;
            boolean hasEntered = false;
            do{
                if(hasEntered) System.out.println("Please insert y or n!");
             value = read.nextLine();
             hasEntered = true;
            }while (!value.equalsIgnoreCase("Y") && !value.equalsIgnoreCase("N"));
            if(value.equalsIgnoreCase("Y")){
                CancelMeetingController cancelMeetingController = new CancelMeetingController();
                cancelMeetingController.cancelMeeting(meetingDTO);
                System.out.println("The operation has succeeded!");
            }else{
                System.out.println("The operation was aborted!");
            }
        }else{
            System.out.println("You don't own any meetings!");
        }
        return true;
    }

    @Override
    public String headline() {
        return "Cancel Meeting";
    }
}
