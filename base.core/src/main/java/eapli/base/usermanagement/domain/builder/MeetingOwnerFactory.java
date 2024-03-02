package eapli.base.usermanagement.domain.builder;

import eapli.base.meetingmanagement.domain.Meeting;
import eapli.base.usermanagement.domain.MeetingOwner;
import eapli.base.usermanagement.domain.MeetingOwnerIdentifier;
import eapli.base.usermanagement.domain.Person;

import java.util.List;

public class MeetingOwnerFactory {
    public MeetingOwner build(long id_MeetingOwner , List<Meeting> meetingList, Person person){

        if (meetingList==null){
            throw new IllegalArgumentException("Parameters cannot be null");
        }
        if(meetingList.isEmpty()){
            throw new IllegalArgumentException("Meeting Owner cannot have no meeting associated");
        }
        if(person == null){
            throw new IllegalArgumentException("Parameters can't be null");
        }
        if (id_MeetingOwner<=0){
            throw new IllegalArgumentException("The id must be greater than 0");
        }

       return new MeetingOwner(new MeetingOwnerIdentifier(id_MeetingOwner), person);
    }
}
