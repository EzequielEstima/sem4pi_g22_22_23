package eapli.base.meetingmanagement.application;

import eapli.base.meetingmanagement.application.service.ListActiveMeetingsIOwnService;
import eapli.base.meetingmanagement.dto.MeetingDTOWithIdDate;

import java.util.List;

public class ListActiveMeetingsIOwnController {
    public List<MeetingDTOWithIdDate> listActiveMeetingsIOwn(){
        ListActiveMeetingsIOwnService service = new ListActiveMeetingsIOwnService();
        return service.listActiveMeetingsIOwn();
    }
}
