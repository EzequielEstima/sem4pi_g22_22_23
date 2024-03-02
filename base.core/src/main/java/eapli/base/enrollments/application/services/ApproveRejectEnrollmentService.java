package eapli.base.enrollments.application.services;

import eapli.base.coursemanagement.domain.Course;
import eapli.base.coursemanagement.domain.CourseIdentifier;
import eapli.base.coursemanagement.dto.CourseDTOWithIdTitle;
import eapli.base.coursemanagement.dto.CourseMapper;
import eapli.base.coursemanagement.repositories.CourseRepository;
import eapli.base.enrollments.domain.Enrollment;
import eapli.base.enrollments.repositories.EnrollmentRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.infrastructure.persistence.RepositoryFactory;
import eapli.base.usermanagement.domain.MecanographicNumber;
import eapli.base.usermanagement.domain.Student;
import eapli.base.usermanagement.dto.StudentDTOWithMechNumber;
import eapli.base.usermanagement.dto.StudentMapper;

import java.util.ArrayList;
import java.util.List;

public class ApproveRejectEnrollmentService {
    RepositoryFactory repositoryFactory = PersistenceContext.repositories();
    private final EnrollmentRepository enrollmentRepository = repositoryFactory.enrollmentRepository();
    private final CourseRepository courseRepository = repositoryFactory.courseRepository();

    public List<CourseDTOWithIdTitle> listCoursesWithEnrollments(){
        List<Course> courseList = enrollmentRepository.listCoursesWithEnrollments();
        List <CourseDTOWithIdTitle> courseDTOList = new ArrayList<>();
        for(Course course : courseList){
            courseDTOList.add(CourseMapper.toDTOWithIdTitle(course));
        }
        return courseDTOList;
    }
    public List<StudentDTOWithMechNumber>listStudentsPendingInCourse(CourseDTOWithIdTitle courseDTO){
        List<Student> studentList = enrollmentRepository.listStudentsPendingInCourse(new CourseIdentifier(courseDTO.courseIdentifier));
        List<StudentDTOWithMechNumber> studentDtoList = new ArrayList<>();
        for(Student student : studentList){
            studentDtoList.add(StudentMapper.toDTOWithMechNumber(student));
        }
        return studentDtoList;
    }

    public void changeEnrollmentStatus(CourseDTOWithIdTitle courseDTO, StudentDTOWithMechNumber studentDTO, String newStatus){
        Enrollment enrollment = enrollmentRepository.findEnrollmentByCourseIDAndMechNumber(new CourseIdentifier(courseDTO.courseIdentifier), new MecanographicNumber(studentDTO.mechanographicNumber)).get();
        enrollment.changeStatus(newStatus);
        enrollmentRepository.save(enrollment);
    }

    public void verifyIfWillExceedEnrollmentLimits(CourseDTOWithIdTitle courseDTO){
        Course course = courseRepository.ofIdentity(new CourseIdentifier(courseDTO.courseIdentifier)).get();
        int enrollmentsAccepted = enrollmentRepository.getNumberOfEnrollmentsAcceptedByCourse(course);
        course.verifyIfWillExceedEnrollmentLimits(enrollmentsAccepted, 1);
    }
}
