package eapli.base.app.common.console.presentation.meeting;

import eapli.base.meetingmanagement.dto.MeetingDTOWithIdDate;
import eapli.framework.visitor.Visitor;

public class MeetingDTOWithIdDatePrinter implements Visitor<MeetingDTOWithIdDate>{
    @Override
    public void visit(MeetingDTOWithIdDate visitee) {
        System.out.printf("%s", visitee.toString());
    }
}
