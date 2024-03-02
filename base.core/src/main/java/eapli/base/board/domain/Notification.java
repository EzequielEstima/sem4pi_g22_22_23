package eapli.base.board.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Embeddable
public class Notification implements ValueObject {
    private String message;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    public Notification(String message){
        this.message = message;
        this.date = new Date();
    }

    public Notification() {
        //for ORM
    }

    @Override
    public String toString() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return dateFormat.format(this.date)+" - "+message;
    }
}
