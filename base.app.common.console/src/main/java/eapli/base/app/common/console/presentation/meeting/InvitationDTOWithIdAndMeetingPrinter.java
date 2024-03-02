package eapli.base.app.common.console.presentation.meeting;

import eapli.base.invitationmanagement.dto.InvitationDTOWithIdAndMeeting;
import eapli.framework.visitor.Visitor;

public class InvitationDTOWithIdAndMeetingPrinter implements Visitor<InvitationDTOWithIdAndMeeting> {
    @Override
    public void visit(InvitationDTOWithIdAndMeeting visitee) {
        System.out.printf("%-5d | %-5d | %-20s", visitee.invitationId, visitee.meetingId, visitee.meetingDate);
    }
}
