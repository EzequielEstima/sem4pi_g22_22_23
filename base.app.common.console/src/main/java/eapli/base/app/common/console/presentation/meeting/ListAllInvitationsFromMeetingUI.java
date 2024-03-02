package eapli.base.app.common.console.presentation.meeting;

import eapli.base.invitationmanagement.application.ListAllInvitationsFromMeetingController;
import eapli.base.invitationmanagement.dto.InvitationDTOWithStatusAndPersonName;
import eapli.base.meetingmanagement.application.ListActiveMeetingsIParticipateController;
import eapli.base.meetingmanagement.dto.MeetingDTOWithIdDate;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

import java.util.List;

public class ListAllInvitationsFromMeetingUI extends AbstractUI {
    @Override
    protected boolean doShow() {
        ListActiveMeetingsIParticipateController listActiveMeetingsIParticipateController = new ListActiveMeetingsIParticipateController();
        List<MeetingDTOWithIdDate> meetingDTOList = listActiveMeetingsIParticipateController.listActiveMeetingsIParticipate();
        try {
            if (!meetingDTOList.isEmpty()) {
                SelectWidget<MeetingDTOWithIdDate> selected = new SelectWidget<>("Select a meeting to cancel.", meetingDTOList, new MeetingDTOWithIdDatePrinter());
                selected.show();
                MeetingDTOWithIdDate meetingDTO = selected.selectedElement();
                if (meetingDTO == null) return true;
                ListAllInvitationsFromMeetingController listInvitationsController = new ListAllInvitationsFromMeetingController();
                List<InvitationDTOWithStatusAndPersonName> listInvitationDTO = listInvitationsController.ListAllInvitationsFromMeeting(meetingDTO);
                System.out.println("\nStatus | Person Name");
                System.out.println("---------------------");
                for (InvitationDTOWithStatusAndPersonName dto: listInvitationDTO) {
                    System.out.println(dto.status + " | " + dto.personName);
                }
            } else {
                System.out.println("You don't own any meetings!");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return true;
    }

    @Override
    public String headline() {
        return "List all Invitation";
    }
}
