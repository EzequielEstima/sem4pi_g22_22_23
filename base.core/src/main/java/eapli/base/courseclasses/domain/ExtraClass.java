package eapli.base.courseclasses.domain;

import eapli.base.usermanagement.domain.Student;
import eapli.base.usermanagement.domain.Teacher;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class ExtraClass implements AggregateRoot<ExtraClassId> {
    @Id
    private ExtraClassId extraClassId;

    private ScheduledDate scheduledDate;

    @OneToMany
    private List<Student> participatingStudents;

    @ManyToOne(cascade = CascadeType.REFRESH)
    private Teacher extraClassTeacher;

    ExtraClass(ExtraClassId extraClassId, ScheduledDate scheduledDate, List<Student> participatingStudents, Teacher teacher) {
        this.extraClassId = extraClassId;
        this.scheduledDate = scheduledDate;
        this.participatingStudents = participatingStudents;
        this.extraClassTeacher = teacher;
    }

    protected ExtraClass() {
        //only for ORM
    }

    public boolean verifyIfExistAnExtraClassAtTheTime(Date startingDateWithTime, int duration){
        return scheduledDate.verifyIfExistAtTheCurrentTime(startingDateWithTime,duration);
    }
    @Override
    public boolean sameAs(Object other) {
        if (!(other instanceof ExtraClass)) {
            return false;
        }

        final ExtraClass that = (ExtraClass) other;

        return extraClassId.equals(that.extraClassId) && scheduledDate.equals(that.scheduledDate)
                && participatingStudents.equals(that.participatingStudents) && extraClassTeacher.equals(that.extraClassTeacher);
    }

    @Override
    public ExtraClassId identity() {
        return extraClassId;
    }


}
