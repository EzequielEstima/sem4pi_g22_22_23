package eapli.base.enrollments.application.services;

import eapli.base.coursemanagement.domain.Course;
import eapli.base.coursemanagement.domain.CourseIdentifier;
import eapli.base.coursemanagement.dto.CourseDTOWithIdTitle;
import eapli.base.coursemanagement.dto.CourseMapper;
import eapli.base.coursemanagement.repositories.CourseRepository;
import eapli.base.enrollments.repositories.EnrollmentRepository;
import eapli.base.enrollments.domain.Enrollment;
import eapli.base.enrollments.domain.Factories.EnrollmentFactory;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.domain.Student;
import eapli.base.usermanagement.repositories.StudentRepository;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RequestEnrollmentService {

    private CourseRepository courseRepo = PersistenceContext.repositories().courseRepository();

    public List<CourseDTOWithIdTitle> listAllStudentAvailableCourses(){
        ArrayList<CourseDTOWithIdTitle> courseDTOList = new ArrayList<>();

        for (Course course : courseRepo.listAllCoursesOpenToEnrollments()) {
            courseDTOList.add(CourseMapper.toDTOWithIdTitle(course));
        }

        return courseDTOList;
    }

    public boolean createEnrollment(CourseDTOWithIdTitle courseDTO){
        EnrollmentRepository enrollmentRepo = PersistenceContext.repositories().enrollmentRepository();
        StudentRepository studentRepo = PersistenceContext.repositories().studentRepository();

        AuthorizationService authz = AuthzRegistry.authorizationService();
        SystemUser systemUser = authz.session().get().authenticatedUser();

        Student student = studentRepo.findStudentBySystemUser(systemUser);

        CourseIdentifier courseId = new CourseIdentifier(courseDTO.courseIdentifier);
        Course course = courseRepo.ofIdentity(courseId).get();

        if(enrollmentRepo.findEnrollmentByCourseIDAndMechNumber(courseId,student.identity()).isPresent()){
            throw new IllegalArgumentException("Couldn't create enrollment. You already have requested an enrollment for this course");
        }

        long totalEnrollments = enrollmentRepo.count();

        Enrollment newEnrollment = new EnrollmentFactory().buildEnrollment(totalEnrollments+1,course,student);

        enrollmentRepo.save(newEnrollment);

        course.addEnrollment(newEnrollment);
        courseRepo.save(course);

        student.addEnrollment(newEnrollment);
        studentRepo.save(student);

        return true;
    }
}
