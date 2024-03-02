package eapli.base.courseclasses.domain.builder;

import eapli.base.courseclasses.domain.*;
import eapli.base.courseclasses.domain.Class;
import eapli.base.usermanagement.domain.Teacher;
import eapli.framework.domain.model.DomainFactory;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class ClassBuilder implements  DomainFactory<Class>{

    private ClassId classId;

    private ClassTitle classTitle;

    private WeeklyDate weeklyDate;

    private Teacher teacher;


    public ClassBuilder withTitleDateWithTimeNumberOfClassDurationID(String title,Date startingDateWithTime,int numberOfRecurrence,int duration,Long id, Teacher teacher){
        withClassTitle(title);
        withClassId(id);
        withWeeklyDate(startingDateWithTime,duration, numberOfRecurrence);
        withTeacher(teacher);
        return this;
    }

    public ClassBuilder withClassId(Long classId){
        this.classId = new ClassId(classId);
        return this;
    }

    public ClassBuilder withClassTitle(String classTitle){
        this.classTitle = new ClassTitle(classTitle);
        return this;
    }

    public ClassBuilder withWeeklyDate(java.util.Date date, int duration, int numberOfOccurrences){
        Duration duration1 = new Duration(duration);
        ArrayList<ScheduledDate> listSchedule = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        listSchedule.add(new ScheduledDate(duration1,new eapli.base.courseclasses.domain.Date(calendar.getTime())));
        for (int i = 1; i <= numberOfOccurrences -1 ; i++) {
            calendar.add(Calendar.WEEK_OF_YEAR, 1); // Add one week
            listSchedule.add(new ScheduledDate(duration1,new eapli.base.courseclasses.domain.Date(calendar.getTime()))) ;
        }
        this.weeklyDate = new WeeklyDate(listSchedule,true);

        return this;
    }

    public ClassBuilder withTeacher(Teacher teacher){
        this.teacher = teacher;
        return this;
    }

    @Override
    public Class build() {
        return new Class(classTitle,weeklyDate, classId,teacher);
    }

}
