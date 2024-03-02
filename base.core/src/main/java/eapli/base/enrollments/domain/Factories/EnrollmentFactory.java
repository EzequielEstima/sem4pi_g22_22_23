package eapli.base.enrollments.domain.Factories;

import eapli.base.coursemanagement.domain.Course;
import eapli.base.enrollments.domain.Enrollment;
import eapli.base.enrollments.domain.EnrollmentId;
import eapli.base.enrollments.domain.EnrollmentStatus;
import eapli.base.enrollments.domain.EnrollmentStatusValue;
import eapli.base.usermanagement.domain.Student;

public class EnrollmentFactory {

    public Enrollment buildEnrollment(Long enrollmentId, Course course, Student student){
        EnrollmentId id = new EnrollmentId(enrollmentId);
        EnrollmentStatus status = new EnrollmentStatus(EnrollmentStatusValue.PENDING);
        return new Enrollment(id,status,course,student);
    }

    public Enrollment buildEnrollmentFromEnrollInBulk(Long enrollmentId, Course course, Student student){
        EnrollmentId id = new EnrollmentId(enrollmentId);
        EnrollmentStatus status = new EnrollmentStatus(EnrollmentStatusValue.ACCEPTED);
        return new Enrollment(id,status,course,student);
    }
}
