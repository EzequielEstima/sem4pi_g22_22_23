package eapli.base.courseclasses.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Objects;

@Embeddable
public class ScheduledDate implements ValueObject {

    private Duration duration;
    private Date date;

    public ScheduledDate(Duration duration, Date date) {
        this.duration = duration;
        this.date = date;
    }

    protected ScheduledDate() {
        //Only for ORM
    }

    public boolean verifyIfExistAtTheCurrentTime(java.util.Date startingDateWithTime, int duration){
        int thisDuration = this.duration.returnMinutes();
        java.util.Date date_time = date.returnDate();

        Calendar thisDate = Calendar.getInstance();
        thisDate.setTime(date_time);

        Calendar otherDate = Calendar.getInstance();
        otherDate.setTime(startingDateWithTime);

        Calendar thisDateWithDuration = Calendar.getInstance();
        thisDateWithDuration.setTime(date_time);
        thisDateWithDuration.add(Calendar.MINUTE, thisDuration);

        Calendar otherDateWithDuration = Calendar.getInstance();
        otherDateWithDuration.setTime(startingDateWithTime);
        otherDateWithDuration.add(Calendar.MINUTE, duration);

        if(thisDate.get(Calendar.DAY_OF_WEEK) == otherDate.get(Calendar.DAY_OF_WEEK) && thisDate.get(Calendar.MONTH) == otherDate.get(Calendar.MONTH) && thisDate.get(Calendar.YEAR) == otherDate.get(Calendar.YEAR)){
            return (thisDate.before(otherDateWithDuration) && otherDate.before(thisDateWithDuration));
        }
        return false;
    }

    public boolean compareIfScheduleClassIsOneWeekAfter(ScheduledDate scheduledDate){
        return scheduledDate.duration.equals(duration) && scheduledDate.date.compareDayOfTheWeekAndTime(date);
    }

    public java.util.Date returnDate() {
        return date.returnDate();
    }

    public Integer returnDuration() {
        return duration.returnMinutes();
    }

    public String returnDateString(){
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return dateFormat.format(this.date.returnDate());
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScheduledDate that = (ScheduledDate) o;
        return Objects.equals(duration, that.duration) && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(duration, date);
    }
}
