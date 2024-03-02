package eapli.base.usermanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.util.Date;
import java.util.Objects;

@Embeddable
public class DateOfBirth implements ValueObject, Comparable<DateOfBirth>{

    private Date date;

    public DateOfBirth(Date date) {
        if(date.after(new Date())){
            throw new IllegalArgumentException(
                    "The Date is in a future time");
        }
        this.date = date;
    }

    public static DateOfBirth valueOf(final Date date) {
        return new DateOfBirth(date);
    }


    protected DateOfBirth() {
        // for ORM
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DateOfBirth that = (DateOfBirth) o;
        return Objects.equals(date, that.date);
    }

    @Override
    public String toString() {
        return "DateOfBirth{" +
                "date=" + date +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(date);
    }

    @Override
    public int compareTo(DateOfBirth o) {
        return this.date.compareTo(o.date);
    }
}
