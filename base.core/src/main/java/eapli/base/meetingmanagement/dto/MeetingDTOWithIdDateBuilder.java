package eapli.base.meetingmanagement.dto;

public class MeetingDTOWithIdDateBuilder {
    private long meetingId;
    private String date;

    public MeetingDTOWithIdDateBuilder withId(long meetingId){
        this.meetingId = meetingId;
        return this;
    }

    public MeetingDTOWithIdDateBuilder withDate(String date){
        this.date = date;
        return this;
    }

    public MeetingDTOWithIdDate build(){
        return new MeetingDTOWithIdDate(meetingId, date);
    }
}
