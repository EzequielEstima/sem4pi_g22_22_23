package eapli.base.postitmanager.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.text.SimpleDateFormat;
import java.util.Objects;
@Embeddable
public class PostItDate implements ValueObject {
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date date_time;

    public PostItDate(java.util.Date date_time) {
        this.date_time = date_time;
    }
    protected PostItDate() {
        //Only for ORM
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostItDate date = (PostItDate) o;
        return Objects.equals(date_time, date.date_time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date_time);
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        return dateFormat.format(this.date_time);
    }
}
