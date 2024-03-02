package eapli.base.courseclasses.domain;

import eapli.base.usermanagement.domain.Student;
import eapli.base.usermanagement.domain.Teacher;

import java.util.List;

public class ExtraClassFactory {

    public ExtraClass buildExtraClass(Long extraClassId, java.util.Date dateWithTime, int duration, List<Student> studentList, Teacher teacher) {
        ExtraClassId id = new ExtraClassId(extraClassId);
        ScheduledDate scheduledDate = new ScheduledDate(new Duration(duration),new Date(dateWithTime));
        return new ExtraClass(id, scheduledDate, studentList, teacher);
    }
}
