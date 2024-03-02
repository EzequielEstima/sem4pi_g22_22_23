package eapli.base.courseclasses.application.services;

import eapli.base.courseclasses.domain.Class;
import eapli.base.courseclasses.domain.builder.ClassBuilder;
import eapli.base.courseclasses.repositories.ClassRepository;
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

import java.util.Date;
import java.util.List;

public class CreateClassService {

    private CourseRepository courseRepository = PersistenceContext.repositories().courseRepository();
    private ClassRepository classRepository = PersistenceContext.repositories().classRepository();
    private TeacherRepository teacherRepository = PersistenceContext.repositories().teacherRepository();


    public boolean createClass(String title, Date startingDateWithTime, int numberOfRecurrence, int duration, CourseDTOWithIdTitle courseDTO){

        Course course = courseRepository.ofIdentity(new CourseIdentifier(courseDTO.courseIdentifier)).get();


        Long numberOfClasses = classRepository.count();
        AuthorizationService authz = AuthzRegistry.authorizationService();
        SystemUser systemUser = authz.session().get().authenticatedUser();
        Teacher teacher = teacherRepository.findTeacherBySystemUser(systemUser);
        ClassBuilder builder= new ClassBuilder();
        builder.withTitleDateWithTimeNumberOfClassDurationID(title,startingDateWithTime,numberOfRecurrence,duration,numberOfClasses+1,teacher);
        Class courseClass = builder.build();
        classRepository.save(courseClass);
        course.addClass(courseClass);
        courseRepository.save(course);
        return true;
    }

}
