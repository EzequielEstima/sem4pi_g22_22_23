package eapli.base.courseclasses.domain;

import eapli.base.usermanagement.domain.Teacher;
import eapli.framework.domain.model.AggregateRoot;
import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;


@Entity
public class Class implements AggregateRoot<ClassId> {
    @EmbeddedId
    private ClassId classId;

    private ClassTitle classTitle;

    private WeeklyDate weeklyDate;

    @ManyToOne
    private Teacher classTeacher;


    public Class( ClassTitle classTitle, WeeklyDate weeklyDate, ClassId classId,Teacher teacher) {
        if (classId == null || classTitle == null || weeklyDate == null || teacher == null) {
            throw new IllegalArgumentException("Class cannot be created with null Objects");
        }
        this.classId = classId;
        this.classTitle = classTitle;
        this.weeklyDate = weeklyDate;
        this.classTeacher=teacher;
    }

    protected Class() {
        //only for ORM
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Class aClass = (Class) o;
        return Objects.equals(classId, aClass.classId) && Objects.equals(classTitle, aClass.classTitle) && Objects.equals(weeklyDate, aClass.weeklyDate) && Objects.equals(classTeacher, aClass.classTeacher);
    }

    @Override
    public int hashCode() {
        return Objects.hash(classId, classTitle, weeklyDate);
    }

    public boolean verifyIfAClassAtTheTime(Date startingDateWithTime, int duration){
        return weeklyDate.verifyIfAClassAtTheTime(startingDateWithTime,duration);
    }

    @Override
    public boolean sameAs(Object other) {
        if (!(other instanceof Class)) {
            return false;
        }

        final Class that = (Class) other;

        return classId.equals(that.classId) && classTitle.equals(that.classTitle) && weeklyDate.equals(that.weeklyDate) && classTeacher.equals(that.classTeacher);
    }

    @Override
    public ClassId identity() {
        return classId;
    }

    public List<Date> returnDates(){
        return weeklyDate.returnDates();
    }


    public List<Integer> returnDuration() {
        return weeklyDate.returnDuration();
    }

    public long returnId() {
        return classId.returnId();
    }

    public String returnTittle() {
        return classTitle.returnTittle();
    }

    public boolean reschedule(WeeklyDate weeklyDate) {
        this.weeklyDate = weeklyDate;
        return true;
    }
    public boolean verifyIfWeeklyDateIsTheSame(WeeklyDate weeklyDate){
        return this.weeklyDate.equals(weeklyDate);
    }
}
