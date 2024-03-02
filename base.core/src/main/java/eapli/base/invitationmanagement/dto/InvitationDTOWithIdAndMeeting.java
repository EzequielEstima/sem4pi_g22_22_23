package eapli.base.invitationmanagement.dto;

public class InvitationDTOWithIdAndMeeting {
    public Long invitationId;
    public Long meetingId;
    public String meetingDate;

    public InvitationDTOWithIdAndMeeting(Long invitationId, Long meetingId, String meetingDate) {
        this.invitationId = invitationId;
        this.meetingId = meetingId;
        this.meetingDate = meetingDate;
    }
}
