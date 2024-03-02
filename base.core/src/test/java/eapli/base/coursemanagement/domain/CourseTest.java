package eapli.base.coursemanagement.domain;

import eapli.base.usermanagement.domain.Acronym;
import eapli.base.usermanagement.domain.DateOfBirth;
import eapli.base.usermanagement.domain.TaxPayerNumber;
import eapli.base.usermanagement.domain.Teacher;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class CourseTest {

    private final String OPEN_STATUS = "OPEN";
    private final String OPEN_ENROLLMENTS_STATUS = "OPEN_ENROLLMENTS";
    private final String CLOSED_ENROLLMENTS_STATUS = "CLOSED_ENROLLMENTS";
    private final String CLOSED_STATUS = "CLOSED";
    private final String CLOSE_STATUS = "CLOSE";
    private final Course COURSE_OPEN_ENROLLMENTS = new Course(new CourseIdentifier("Id"),
            new CourseTitle("Title"), new CourseName("Name"), new Description("Desciption"),
            new EnrollmentLimits(1,5), new CourseStatus(CourseStatusValue.OPEN_ENROLLMENTS), new Teacher());
    private final Course COURSE_CLOSED_ENROLLMENTS = new Course
            (new CourseIdentifier("Id"), new CourseTitle("Title"), new CourseName("Name"),
                    new Description("Desciption"), new EnrollmentLimits(1,5),
                    new CourseStatus(CourseStatusValue.CLOSED_ENROLLMENTS), new Teacher());

    @Test(expected = IllegalArgumentException.class)
    public void ensureThatCourseStatusCannotChangeToAWrongState(){
        Course course = new Course(new CourseIdentifier("Id1"),
                new CourseTitle("Title1"), new CourseName("Name1"),
                new Description("Desciption1"), new EnrollmentLimits(1,5),
                new CourseStatus(CourseStatusValue.CLOSE), new Teacher());
        course.changeStatus("CLOSED");
    }

    @Test
    public void ensureThatCourseStatusCanChangeToNextState(){
        Course course = new Course(new CourseIdentifier("Id1"), new CourseTitle("Title1"),
                new CourseName("Name1"), new Description("Desciption1"), new EnrollmentLimits(1,5),
                new CourseStatus(CourseStatusValue.CLOSE), new Teacher());
        assertTrue(course.changeStatus("OPEN"));
    }

    @Test
    public void ensureThatCourseStatusCanChangeFromOpenEnrollmentsToClosedEnrollments(){
        Assert.assertTrue(COURSE_OPEN_ENROLLMENTS.changeStatus(CLOSED_ENROLLMENTS_STATUS));
    }

    @Test
    public void ensureThatCourseStatusCanChangeFromClosedEnrollmentsToClosed(){
        Assert.assertTrue(COURSE_CLOSED_ENROLLMENTS.changeStatus(CLOSED_STATUS));
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureThatCourseStatusCannotChangeFromOpenEnrollmentsToClosed(){
        COURSE_OPEN_ENROLLMENTS.changeStatus(CLOSED_STATUS);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureThatCourseStatusCannotChangeFromOpenEnrollmentsToOpen(){
        COURSE_OPEN_ENROLLMENTS.changeStatus(OPEN_STATUS);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureThatCourseStatusCannotChangeFromClosedEnrollmentsToOpenEnrollments(){
        COURSE_CLOSED_ENROLLMENTS.changeStatus(OPEN_ENROLLMENTS_STATUS);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureThatCourseStatusCannotChangeFromClosedEnrollmentsToOpen(){
        COURSE_CLOSED_ENROLLMENTS.changeStatus(OPEN_STATUS);
    }

    @Test(expected = IllegalStateException.class)
    public void ensureEnrollmentsAboveMaxNotAllowed(){
        Course course = new Course(new CourseIdentifier("Id1"), new CourseTitle("Title1"),
                new CourseName("Name1"), new Description("Desciption1"), new EnrollmentLimits(1,5),
                new CourseStatus(CourseStatusValue.CLOSE), new Teacher());
        course.verifyIfWillExceedEnrollmentLimits(7,1);
    }
    @Test
    public void ensureEnrollmentsBelowMaxAreAllowed(){
        Course course = new Course(new CourseIdentifier("Id1"), new CourseTitle("Title1"),
                new CourseName("Name1"), new Description("Desciption1"), new EnrollmentLimits(1,5),
                new CourseStatus(CourseStatusValue.CLOSE), new Teacher());
        assertFalse(course.verifyIfWillExceedEnrollmentLimits   (3,1));
    }

    @Test(expected = IllegalStateException.class)
    public void ensureEnrollmentsAtMaxAreNotwAllowed(){
        Course course = new Course(new CourseIdentifier("Id1"), new CourseTitle("Title1"),
                new CourseName("Name1"), new Description("Desciption1"), new EnrollmentLimits(1,3),
                new CourseStatus(CourseStatusValue.CLOSE), new Teacher());
        assertFalse(course.verifyIfWillExceedEnrollmentLimits(3,1));
    }

    @Test
    public void ensureAdditionOfTeacherInACourse() {
        Course course = new Course(new CourseIdentifier("Id1"), new CourseTitle("Title1"),
                new CourseName("Name1"), new Description("Desciption1"), new EnrollmentLimits(1,5),
                new CourseStatus(CourseStatusValue.CLOSE), new Teacher(new Acronym("LOL"),new DateOfBirth(new Date()),new TaxPayerNumber(100002000)));
        List<Teacher> teacherList = new ArrayList<>();
        teacherList.add(new Teacher(new Acronym("LOL"),new DateOfBirth(new Date()),new TaxPayerNumber(100002000)));
        teacherList.add(new Teacher(new Acronym("WOW"),new DateOfBirth(new Date()),new TaxPayerNumber(100002200)));
        course.addTeachersToList(teacherList);
        assertTrue(course.hasTeacherInList(teacherList));
    }

    @Test
    public void ensureNotAdditionOfTeacherInACourse() {
        Course course = new Course(new CourseIdentifier("Id1"), new CourseTitle("Title1"),
                new CourseName("Name1"), new Description("Desciption1"), new EnrollmentLimits(1,5),
                new CourseStatus(CourseStatusValue.CLOSE), new Teacher(new Acronym("LOL"),new DateOfBirth(new Date()),new TaxPayerNumber(100002000)));
        List<Teacher> teacherList = new ArrayList<>();
        teacherList.add(new Teacher(new Acronym("LOL"),new DateOfBirth(new Date()),new TaxPayerNumber(100002000)));
        teacherList.add(new Teacher(new Acronym("WOW"),new DateOfBirth(new Date()),new TaxPayerNumber(100002200)));
        course.addTeachersToList(teacherList);
        teacherList.add(new Teacher(new Acronym("GEN"),new DateOfBirth(new Date()),new TaxPayerNumber(100002300)));
        assertFalse(course.hasTeacherInList(teacherList));
    }

    @Test
    public void ensureAdditionTeacherInCharge(){
        Course course = new Course(new CourseIdentifier("Id1"), new CourseTitle("Title1"),
                new CourseName("Name1"), new Description("Desciption1"), new EnrollmentLimits(1,5),
                new CourseStatus(CourseStatusValue.CLOSE), new Teacher(new Acronym("LOL"),new DateOfBirth(new Date()),new TaxPayerNumber(100002000)));
        Teacher teacher = new Teacher(new Acronym("WOW"),new DateOfBirth(new Date()),new TaxPayerNumber(100002200));
        course.addTeacherInCharge(teacher);
        assertTrue(course.hasThisTeacherInCharge(teacher));
    }

    @Test
    public void ensureNotAdditionTeacherInCharge(){
        Course course = new Course(new CourseIdentifier("Id1"), new CourseTitle("Title1"),
                new CourseName("Name1"), new Description("Desciption1"), new EnrollmentLimits(1,5),
                new CourseStatus(CourseStatusValue.CLOSE), new Teacher(new Acronym("LOL"),new DateOfBirth(new Date()),new TaxPayerNumber(100002000)));
        Teacher teacher = new Teacher(new Acronym("WOW"),new DateOfBirth(new Date()),new TaxPayerNumber(100002200));
        course.addTeacherInCharge(new Teacher(new Acronym("LOL"),new DateOfBirth(new Date()),new TaxPayerNumber(100002300)));
        assertFalse(course.hasThisTeacherInCharge(teacher));
    }

}
