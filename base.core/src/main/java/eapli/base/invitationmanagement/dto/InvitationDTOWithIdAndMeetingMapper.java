package eapli.base.invitationmanagement.dto;

import eapli.base.invitationmanagement.domain.Invitation;
import eapli.base.meetingmanagement.domain.Meeting;

public class InvitationDTOWithIdAndMeetingMapper {

    public static InvitationDTOWithIdAndMeeting toDTO(Invitation invitation, Meeting meeting){
        InvitationDTOWithIdAndMeetingBuilder builder = new InvitationDTOWithIdAndMeetingBuilder();
        return builder.withAll(invitation.identity().returnInvitationIdentifier(), meeting.returnMeetingIdentifier(), meeting.returnScheduledDateString()).build();
    }
}
