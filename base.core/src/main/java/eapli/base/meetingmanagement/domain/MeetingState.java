package eapli.base.meetingmanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.util.Objects;
@Embeddable
public class MeetingState implements ValueObject {
    private boolean isActive;
    MeetingState(boolean isActive){
        this.isActive = isActive;
    }

    protected MeetingState() {
        //for ORM
    }

    @Override
    public String toString(){
        if(isActive){
            return "Active";
        }else{
            return "Canceled";
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MeetingState)) return false;
        MeetingState that = (MeetingState) o;
        return isActive == that.isActive;
    }

    @Override
    public int hashCode() {
        return Objects.hash(isActive);
    }
}
