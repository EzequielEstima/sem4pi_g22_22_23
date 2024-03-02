package eapli.base.invitationmanagement.application;


import eapli.base.invitationmanagement.application.service.ListAllInvitationsFromMeetingService;
import eapli.base.invitationmanagement.dto.InvitationDTOWithStatusAndPersonName;
import eapli.base.meetingmanagement.dto.MeetingDTOWithIdDate;

import java.util.List;

public class ListAllInvitationsFromMeetingController {

    public List<InvitationDTOWithStatusAndPersonName> ListAllInvitationsFromMeeting(MeetingDTOWithIdDate meetingDTO){
        return  new ListAllInvitationsFromMeetingService().ListAllInvitationsFromMeeting(meetingDTO);
    }
}
