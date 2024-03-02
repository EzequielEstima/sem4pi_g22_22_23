package eapli.base.persistence.impl.inmemory;

import eapli.base.coursemanagement.domain.Course;
import eapli.base.coursemanagement.domain.CourseIdentifier;
import eapli.base.enrollments.repositories.EnrollmentRepository;
import eapli.base.enrollments.domain.Enrollment;
import eapli.base.enrollments.domain.EnrollmentId;
import eapli.base.usermanagement.domain.MecanographicNumber;
import eapli.base.usermanagement.domain.Student;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.util.List;
import java.util.Optional;

public class inMemoryEnrollmentRepository extends InMemoryDomainRepository<Enrollment, EnrollmentId> implements EnrollmentRepository {
    @Override
    public List<Course> listCoursesWithEnrollments() {
        return null;
    }

    @Override
    public int getNumberOfEnrollmentsAcceptedByCourse(Course course) {
        return 0;
    }

    @Override
    public List<Student> listStudentsPendingInCourse(CourseIdentifier courseId) {
        return null;
    }

    @Override
    public Optional<Enrollment> findEnrollmentByCourseIDAndMechNumber(CourseIdentifier courseId, MecanographicNumber mechNumber) {
        return null;
    }
}
