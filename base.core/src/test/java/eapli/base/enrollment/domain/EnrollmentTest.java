package eapli.base.enrollment.domain;

import eapli.base.coursemanagement.domain.*;
import eapli.base.enrollments.domain.Enrollment;
import eapli.base.enrollments.domain.EnrollmentId;
import eapli.base.enrollments.domain.EnrollmentStatus;
import eapli.base.enrollments.domain.EnrollmentStatusValue;
import eapli.base.usermanagement.domain.Student;
import eapli.base.usermanagement.domain.Teacher;
import org.junit.Test;
import static org.junit.Assert.*;

public class EnrollmentTest {
    @Test
    public void changeToACorrectStatusTest(){
        Enrollment enrollment = new Enrollment(new EnrollmentId(), new EnrollmentStatus(EnrollmentStatusValue.PENDING),new Course(new CourseIdentifier("id"),new CourseTitle("title"), new CourseName("name"), new Description("desc"),new EnrollmentLimits(1,2),new CourseStatus("OPEN"), new Teacher()),new Student());
        assertTrue(enrollment.changeStatus("ACCEPTED"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void changeToAIncorrectStatusTest(){
        Enrollment enrollment = new Enrollment(new EnrollmentId(), new EnrollmentStatus(EnrollmentStatusValue.ACCEPTED),new Course(new CourseIdentifier("id"),new CourseTitle("title"), new CourseName("name"), new Description("desc"),new EnrollmentLimits(1,2),new CourseStatus("OPEN"), new Teacher()),new Student());
        enrollment.changeStatus("PENDING");
    }

    @Test(expected = IllegalArgumentException.class)
    public void changeToPendingStatusTest(){
        Enrollment enrollment = new Enrollment(new EnrollmentId(), new EnrollmentStatus(EnrollmentStatusValue.ACCEPTED),new Course(new CourseIdentifier("id"),new CourseTitle("title"), new CourseName("name"), new Description("desc"),new EnrollmentLimits(1,2),new CourseStatus("OPEN"), new Teacher()),new Student());
        enrollment.changeStatus("PENDING");
    }
    @Test(expected = IllegalArgumentException.class)

    public void changeToSameStatusTest(){
        Enrollment enrollment = new Enrollment(new EnrollmentId(), new EnrollmentStatus(EnrollmentStatusValue.ACCEPTED),new Course(new CourseIdentifier("id"),new CourseTitle("title"), new CourseName("name"), new Description("desc"),new EnrollmentLimits(1,2),new CourseStatus("OPEN"), new Teacher()),new Student());
        enrollment.changeStatus("ACCEPTED");
    }
}
