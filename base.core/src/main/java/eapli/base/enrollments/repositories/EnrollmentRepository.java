package eapli.base.enrollments.repositories;

import eapli.base.coursemanagement.domain.Course;
import eapli.base.coursemanagement.domain.CourseIdentifier;
import eapli.base.enrollments.domain.Enrollment;
import eapli.base.enrollments.domain.EnrollmentId;
import eapli.base.usermanagement.domain.MecanographicNumber;
import eapli.base.usermanagement.domain.Student;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.List;
import java.util.Optional;

public interface EnrollmentRepository extends DomainRepository<EnrollmentId, Enrollment> {
    public List<Course> listCoursesWithEnrollments();

    public int getNumberOfEnrollmentsAcceptedByCourse(Course course);

    public List<Student> listStudentsPendingInCourse(CourseIdentifier courseId);

    public Optional<Enrollment> findEnrollmentByCourseIDAndMechNumber(CourseIdentifier courseId, MecanographicNumber mechNumber);
}
