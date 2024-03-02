package eapli.base.courseclasses.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Calendar;
import java.util.Objects;

public class Date implements ValueObject {

    @Temporal(TemporalType.DATE)
    private java.util.Date date_time;

    public Date(java.util.Date date_time) {
        if(date_time.before(new java.util.Date())){
            throw new IllegalArgumentException("Class date must be after today");
        }
        this.date_time = date_time;
    }

    protected Date() {
        //Only for ORM
    }

    public boolean compareDayOfTheWeekAndTime(Date date){
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date_time);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date.date_time);

        // get day of the week
        int dayOfWeek1 = cal1.get(Calendar.DAY_OF_WEEK);
        int dayOfWeek2 = cal2.get(Calendar.DAY_OF_WEEK);
        // get time
        int hour1 = cal1.get(Calendar.HOUR_OF_DAY);
        int minute1 = cal1.get(Calendar.MINUTE);
        int hour2 = cal2.get(Calendar.HOUR_OF_DAY);
        int minute2 = cal2.get(Calendar.MINUTE);
        return hour1 == hour2 && minute1 == minute2 && dayOfWeek1 == dayOfWeek2;
    }

    public java.util.Date returnDate(){
        return date_time;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Date date = (Date) o;
        return Objects.equals(date_time, date.date_time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date_time);
    }
}
