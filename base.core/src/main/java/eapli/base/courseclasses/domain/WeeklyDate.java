package eapli.base.courseclasses.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import java.util.*;
import java.util.Date;

@Embeddable
public class WeeklyDate implements ValueObject {

    @ElementCollection
    private List<ScheduledDate> scheduledDates;

    /**
     * Constructor of WeeklyDate
     * @param scheduledDates list of scheduled dates
     * @param flag if true, verifies if the dates are in the same day of the week and at the same time
     */

    public WeeklyDate(List<ScheduledDate>  scheduledDates, boolean flag) {
        if(scheduledDates == null) {
            throw new IllegalArgumentException("Schedules list cannot be null");
        }else if (scheduledDates.isEmpty()){
            throw new IllegalArgumentException("Schedules list cannot be empty");
        }
        if (flag) {
            for(int i = 0; i < scheduledDates.size()-1;i++){
                if (!scheduledDates.get(i).compareIfScheduleClassIsOneWeekAfter(scheduledDates.get(i+1))){
                    throw new IllegalArgumentException("Schedules dates have to be in the same day of the week and at the same time");
                }
            }
        }
        this.scheduledDates = scheduledDates;
    }

    protected WeeklyDate() {
        //only for ORM
    }

    public boolean verifyIfAClassAtTheTime(Date startingDateWithTime, int duration){
        for (ScheduledDate scheduledDate : scheduledDates ){
            if (scheduledDate.verifyIfExistAtTheCurrentTime(startingDateWithTime,duration)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WeeklyDate that = (WeeklyDate) o;
        return Objects.equals(scheduledDates, that.scheduledDates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(scheduledDates);
    }

    public List<Date> returnDates() {
        List<Date> dates = new ArrayList<>();
        for (ScheduledDate scheduledDate : scheduledDates){
            dates.add(scheduledDate.returnDate());
        }
        return dates;
    }

    public List<Integer> returnDuration() {
        List<Integer> durations = new ArrayList<>();
        for (ScheduledDate scheduledDate : scheduledDates){
            durations.add(scheduledDate.returnDuration());
        }
        return durations;
    }
}
