package eapli.base.exams.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

@Embeddable
public class DateInterval implements ValueObject {

    @Temporal(TemporalType.TIMESTAMP)
    private Date initialDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date finalDate;

    public DateInterval(Date initialDate, Date finalDate) {
        if (initialDate == null || finalDate == null) {
            throw new IllegalArgumentException(
                    "Dates cannot be null");
        }
        if (initialDate.after(finalDate)){
            throw new IllegalArgumentException(
                    "Final date mus be greater than initial date");
        }
        if (initialDate.before(new Date())){
            throw new IllegalArgumentException(
                    "Dates must be in the future");
        }

        this.initialDate = initialDate;
        this.finalDate = finalDate;
    }

    protected DateInterval() {
        //Only for ORM
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DateInterval that = (DateInterval) o;
        return Objects.equals(initialDate, that.initialDate) && Objects.equals(finalDate, that.finalDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(initialDate, finalDate);
    }

    public String toStringInitialDate(){
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return dateFormat.format(this.initialDate);
    }

    public String toStringFinalDate(){
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return dateFormat.format(this.finalDate);
    }

    public Date initialDate() {
        return this.initialDate;
    }

    public Date finalDate() {
        return this.finalDate;
    }
}
