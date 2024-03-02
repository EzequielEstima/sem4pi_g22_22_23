package eapli.base.invitationmanagement.dto;

public class InvitationDTOWithIdAndMeetingBuilder {
    private Long invitationId;
    private Long meetingId;
    private String meetingDate;

    public InvitationDTOWithIdAndMeetingBuilder withAll(Long invitationId,Long meetingId,String meetingDate){
        withInvitationId(invitationId);
        withMeetingId(meetingId);
        withMeetingDate(meetingDate);
        return this;
    }

    public InvitationDTOWithIdAndMeetingBuilder withMeetingDate(String meetingDate) {
        this.meetingDate = meetingDate;
        return this;
    }

    private InvitationDTOWithIdAndMeetingBuilder withMeetingId(Long meetingId) {
        this.meetingId = meetingId;
        return this;
    }

    public InvitationDTOWithIdAndMeetingBuilder withInvitationId(Long invitationId){
        this.invitationId = invitationId;
        return this;
    }

    public InvitationDTOWithIdAndMeeting build(){
        return new InvitationDTOWithIdAndMeeting(invitationId,meetingId,meetingDate);
    }
}
