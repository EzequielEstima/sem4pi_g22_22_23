package eapli.base.meetingmanagement.application;

import eapli.base.meetingmanagement.application.service.ListActiveMeetingsIParticipateService;
import eapli.base.meetingmanagement.dto.MeetingDTOWithIdDate;

import java.util.List;

public class ListActiveMeetingsIParticipateController {

    public List<MeetingDTOWithIdDate> listActiveMeetingsIParticipate(){
        ListActiveMeetingsIParticipateService service = new ListActiveMeetingsIParticipateService();
        return service.listActiveMeetingsIParticipate();
    }
}
