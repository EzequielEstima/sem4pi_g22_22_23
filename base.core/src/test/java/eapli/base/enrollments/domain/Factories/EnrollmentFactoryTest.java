package eapli.base.enrollments.domain.Factories;

import eapli.base.coursemanagement.domain.Course;
import eapli.base.coursemanagement.domain.Factories.CourseFactory;
import eapli.base.enrollments.domain.Enrollment;
import eapli.base.enrollments.domain.EnrollmentStatus;
import eapli.base.usermanagement.domain.Student;
import eapli.base.usermanagement.domain.builder.StudentBuilder;
import eapli.base.utils.CsvReader;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.*;

public class EnrollmentFactoryTest {

    final Course dummyCourse = new CourseFactory().buildCourse("Id1","Title1","Name1","Desc1",40,20);
    final Student dummyStudent = new StudentBuilder().withMecanographicNumber(1,"2000")
            .withDateOfBirth(new Date(100,10,2))
            .withTaxPayerNumber(111111111).build();


    @Test
    public void ensureEnrollmentStatusIsPending() {
        EnrollmentFactory fac = new EnrollmentFactory();
        Enrollment instance = fac.buildEnrollment((long) 1,dummyCourse,dummyStudent);
        assertEquals("Pending",instance.returnEnrollmentStatusString());
    }

    @Test
    public void ensureEnrollmentStatusIsAcceptedInEnrollInBulk() {
        EnrollmentFactory fac = new EnrollmentFactory();
        Enrollment instance = fac.buildEnrollmentFromEnrollInBulk((long) 1,dummyCourse,dummyStudent);
        assertEquals("Accepted",instance.returnEnrollmentStatusString());
    }



}