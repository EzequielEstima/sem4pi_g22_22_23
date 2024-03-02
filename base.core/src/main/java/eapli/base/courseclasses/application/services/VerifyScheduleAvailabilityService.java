package eapli.base.courseclasses.application.services;

import eapli.base.coursemanagement.domain.Course;
import eapli.base.coursemanagement.domain.CourseIdentifier;
import eapli.base.coursemanagement.dto.CourseDTOWithIdTitle;
import eapli.base.coursemanagement.repositories.CourseRepository;
import eapli.base.enrollments.domain.Enrollment;
import eapli.base.enrollments.repositories.EnrollmentRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.domain.MecanographicNumber;
import eapli.base.usermanagement.domain.Student;
import eapli.base.usermanagement.domain.Teacher;
import eapli.base.usermanagement.repositories.StudentRepository;
import eapli.base.usermanagement.repositories.TeacherRepository;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class VerifyScheduleAvailabilityService {
    public boolean verifyScheduleAvailability(java.util.Date dateWithTime, int  duration, CourseDTOWithIdTitle courseDTO, List<String> studentMechNumList){
        CourseRepository courseRepo = PersistenceContext.repositories().courseRepository();
        EnrollmentRepository enrollmentRepo = PersistenceContext.repositories().enrollmentRepository();
        StudentRepository studentRepo = PersistenceContext.repositories().studentRepository();
        TeacherRepository teacherRepo = PersistenceContext.repositories().teacherRepository();
        Teacher teacher = teacherRepo.findTeacherBySystemUser(AuthzRegistry.authorizationService().session().get().authenticatedUser());


        CourseIdentifier courseId = new CourseIdentifier(courseDTO.courseIdentifier);
        Course course = courseRepo.ofIdentity(courseId).get();
        List<Student> studentList = new ArrayList<>();

        for (String mecNumString : studentMechNumList){
            MecanographicNumber mecNum =  new MecanographicNumber(mecNumString);

            if (!studentRepo.containsOfIdentity(mecNum)){
                throw new IllegalArgumentException(String.format("Mecanographic number %s does not match any of the existing students",mecNumString));
            }

            Optional<Enrollment> enrollmentOptional = enrollmentRepo.findEnrollmentByCourseIDAndMechNumber(courseId,mecNum);
            if (enrollmentOptional.isEmpty() || !enrollmentOptional.get().returnEnrollmentStatusString().equals("Accepted")){
                throw new IllegalArgumentException(String.format("Student %s is not enrolled in this Course",mecNumString));
            }
            studentList.add(studentRepo.ofIdentity(mecNum).get());
        }

        if(course.verifyIfExistAClassAtTheTime(dateWithTime,duration)){
            throw new IllegalArgumentException("There already exists a class scheduled for this time");
        }

        if(course.verifyIfExistAnExtraClassAtTheTime(dateWithTime,duration)){
            throw new IllegalArgumentException("There already exists an extra class scheduled for this time");
        }
        List<Teacher> teacherList = new ArrayList<>();
        teacherList.add(teacher);

        for (Course c: courseRepo.findAllCourseRelatedWithTheMembersOfAGivenCourse(studentList,teacherList)) {
            if (c.verifyIfExistAClassAtTheTime(dateWithTime,duration)){
                return false;
            }
            if (c.verifyIfExistAnExtraClassAtTheTime(dateWithTime,duration)){
                return false;
            }
        }
        return true;
    }
}
