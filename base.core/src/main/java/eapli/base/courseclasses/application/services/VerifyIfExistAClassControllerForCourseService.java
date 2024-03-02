package eapli.base.courseclasses.application.services;

import eapli.base.coursemanagement.domain.Course;
import eapli.base.coursemanagement.domain.CourseIdentifier;
import eapli.base.coursemanagement.dto.CourseDTOWithIdTitle;
import eapli.base.coursemanagement.repositories.CourseRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.domain.Student;
import eapli.base.usermanagement.domain.Teacher;
import eapli.base.usermanagement.repositories.TeacherRepository;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VerifyIfExistAClassControllerForCourseService {

    public boolean verifyIfExistAClassAtTheTime(Date startingDateWithTime, int duration, CourseDTOWithIdTitle courseDTO) {

        CourseRepository courseRepository = PersistenceContext.repositories().courseRepository();

        Course course = courseRepository.ofIdentity(new CourseIdentifier(courseDTO.courseIdentifier)).get();
        if (course.verifyIfExistAClassAtTheTime(startingDateWithTime,duration)){
            throw new IllegalArgumentException("Exist already a class during that time in this Course");
        }
        if (course.verifyIfExistAnExtraClassAtTheTime(startingDateWithTime,duration)){
            throw new IllegalArgumentException("Exist already an extra class during that time in this Course");
        }

        TeacherRepository teacherRepository = PersistenceContext.repositories().teacherRepository();

        AuthorizationService authz = AuthzRegistry.authorizationService();
        SystemUser systemUser = authz.session().get().authenticatedUser();
        Teacher teacher = teacherRepository.findTeacherBySystemUser(systemUser);



        List<Teacher> listTeacher = new ArrayList<>();
        listTeacher.add(teacher);
        List<Student> listStudent = PersistenceContext.repositories().studentRepository().findStudentsInACourse(course);

        List<Course> listCourse;
        listCourse = courseRepository.findAllCourseRelatedWithTheMembersOfAGivenCourse(listStudent,listTeacher);
        for (Course c: listCourse) {
            if (c.verifyIfExistAClassAtTheTime(startingDateWithTime,duration)){
                return true;
            }
            if (c.verifyIfExistAnExtraClassAtTheTime(startingDateWithTime,duration)){
                return true;
            }
        }

        return false;
    }
}
