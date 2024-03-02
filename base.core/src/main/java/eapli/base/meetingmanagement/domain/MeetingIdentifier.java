package eapli.base.meetingmanagement.domain;

import eapli.framework.domain.model.ValueObject;

import java.util.Objects;

public class MeetingIdentifier implements Comparable<MeetingIdentifier>, ValueObject {

    long idMeeting;

    public MeetingIdentifier(long idMeeting) {
        if (idMeeting <= 0) {
            throw new IllegalArgumentException("Invitation identifier cannot be negative or zero");
        }
        this.idMeeting = idMeeting;
    }

    protected MeetingIdentifier() {
        // for ORM
    }

    @Override
    public int compareTo(MeetingIdentifier o) {
        return Long.compare(idMeeting, o.idMeeting);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MeetingIdentifier that = (MeetingIdentifier) o;
        return Objects.equals(idMeeting, that.idMeeting);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMeeting);
    }

    public Long returnCourseIdentifierString(){
        return idMeeting;
    }
}
