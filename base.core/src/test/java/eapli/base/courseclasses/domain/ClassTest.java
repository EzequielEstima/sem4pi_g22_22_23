package eapli.base.courseclasses.domain;

import eapli.base.courseclasses.domain.builder.ClassBuilder;
import eapli.base.usermanagement.domain.Teacher;
import eapli.base.usermanagement.domain.builder.TeacherBuilder;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class ClassTest {

    @Test(expected = IllegalArgumentException.class)
    public void ensureClassCannotBeCreatedWithNullValues() {
        Class courseClass = new ClassBuilder().build();
    }

    @Test
    public void ensureClassEqualsPassesForTheSameID() {
        Teacher aTeacher = new TeacherBuilder().withAcronym("BCC")
                .withDateOfBirth(new Date(100,10,2)).withTaxPayerNumber(111111111).build();
        Class courseClass = new ClassBuilder().withTitleDateWithTimeNumberOfClassDurationID("title",new java.util.Date(1000,10,2,10,0,0),30,3,1L,aTeacher).build();
        Class anotherCourseClass = new ClassBuilder().withTitleDateWithTimeNumberOfClassDurationID("title",new java.util.Date(1000,10,2,10,0,0),30,3,1L,aTeacher).build();

        assertTrue(courseClass.equals(anotherCourseClass));
    }

    @Test
    public void ensureClassEqualsFailsForDifferenteID()  {
        Teacher aTeacher = new TeacherBuilder().withAcronym("BCC")
                .withDateOfBirth(new Date(100,10,2)).withTaxPayerNumber(111111111).build();
        Class courseClass = new ClassBuilder().withTitleDateWithTimeNumberOfClassDurationID("title",new java.util.Date(1000,10,2,10,0,0),30,3,1L,aTeacher).build();
        Class anotherCourseClass = new ClassBuilder().withTitleDateWithTimeNumberOfClassDurationID("title",new java.util.Date(1000,10,2,10,0,0),30,3,2L,aTeacher).build();

        assertFalse(courseClass.equals(anotherCourseClass));
    }

    @Test
    public void ensureClassEqualsAreTheSameForTheSameInstance() {
        Class courseClass = new Class();

        assertTrue(courseClass.equals(courseClass));
    }

    @Test
    public void ensureClassEqualsFailsForDifferenteObjectTypes(){
        Class courseClass = new Class();
        ExtraClass extraClass = new ExtraClass();
        assertFalse(courseClass.equals(extraClass));
    }

    @Test
    public void ensureClassIsTheSameAsItsInstance() {
        Teacher aTeacher = new TeacherBuilder().withAcronym("BCC")
                .withDateOfBirth(new Date(100,10,2)).withTaxPayerNumber(111111111).build();
        Class courseClass = new ClassBuilder().withTitleDateWithTimeNumberOfClassDurationID("title",new java.util.Date(1000,10,2,10,0,0),30,3,1L,aTeacher).build();

        assertTrue(courseClass.sameAs(courseClass));
    }

    @Test
    public void ensureTwoClassWithDifferentIDAreNotTheSame()  {
        Teacher aTeacher = new TeacherBuilder().withAcronym("BCC")
                .withDateOfBirth(new Date(100,10,2)).withTaxPayerNumber(111111111).build();
        Class courseClass = new ClassBuilder().withTitleDateWithTimeNumberOfClassDurationID("title",new java.util.Date(1000,10,2,10,0,0),30,3,1L,aTeacher).build();
        Class anotherCourseClass = new ClassBuilder().withTitleDateWithTimeNumberOfClassDurationID("title",new java.util.Date(1000,10,2,10,0,0),30,3,2L,aTeacher).build();

        assertFalse(courseClass.sameAs(anotherCourseClass));
    }

    @Test
    public void verifyIfAClassAtTheTime()  {
        Teacher aTeacher = new TeacherBuilder().withAcronym("BCC")
                .withDateOfBirth(new Date(100,10,2)).withTaxPayerNumber(111111111).build();
        Class courseClass = new ClassBuilder().withTitleDateWithTimeNumberOfClassDurationID("title",new java.util.Date(1000,10,2,10,0,0),3,30,1L,aTeacher).build();

        java.util.Date testData1 = new java.util.Date(1000,10,9,10,10,0);
        assertTrue(courseClass.verifyIfAClassAtTheTime(testData1,30));

        java.util.Date testData2 = new java.util.Date(1000,10,9,11,30,0);
        assertFalse(courseClass.verifyIfAClassAtTheTime(testData2,30));

    }

    @Test
    public void verifyIfWeeklyDateWasUpdated(){
        Teacher aTeacher = new TeacherBuilder().withAcronym("BCC")
                .withDateOfBirth(new Date(100,10,2)).withTaxPayerNumber(111111111).build();
        Class courseClass = new ClassBuilder().withTitleDateWithTimeNumberOfClassDurationID("title",
                new java.util.Date(1000,10,2,10,0,0),3,30,1L,aTeacher).build();

        ScheduledDate scheduledDate1 = new ScheduledDate(new Duration(60),new eapli.base.courseclasses.domain.Date(new java.util.Date(1100,10,2,10,0,0)));
        ScheduledDate scheduledDate2 = new ScheduledDate(new Duration(60),new eapli.base.courseclasses.domain.Date(new java.util.Date(1200,10,9,10,0,0)));
        List<ScheduledDate> list = new ArrayList<>();
        list.add(scheduledDate1);
        list.add(scheduledDate2);
        WeeklyDate weeklyDate = new WeeklyDate(list,false);
        courseClass.reschedule(weeklyDate);
        assertTrue(courseClass.verifyIfWeeklyDateIsTheSame(weeklyDate));
    }
}