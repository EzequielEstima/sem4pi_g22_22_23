package eapli.base.meetingmanagement.dto;

public class MeetingDTOWithIdDate {
    public long meetingId;
    public String date;

    public MeetingDTOWithIdDate(long meetingId, String date){
        this.meetingId = meetingId;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Meeting Id: "+meetingId+"  Date: "+date;
    }
}
