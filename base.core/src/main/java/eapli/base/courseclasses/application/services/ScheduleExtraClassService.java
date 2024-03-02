package eapli.base.courseclasses.application.services;


import eapli.base.courseclasses.domain.ExtraClass;
import eapli.base.courseclasses.domain.ExtraClassFactory;
import eapli.base.courseclasses.repositories.ExtraClassRepository;
import eapli.base.coursemanagement.domain.Course;
import eapli.base.coursemanagement.domain.CourseIdentifier;
import eapli.base.coursemanagement.dto.CourseDTOWithIdTitle;
import eapli.base.coursemanagement.repositories.CourseRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.domain.MecanographicNumber;
import eapli.base.usermanagement.domain.Student;
import eapli.base.usermanagement.domain.Teacher;
import eapli.base.usermanagement.repositories.StudentRepository;
import eapli.base.usermanagement.repositories.TeacherRepository;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.ArrayList;
import java.util.List;

public class ScheduleExtraClassService {

    public boolean createExtraClass(java.util.Date dateWithTime, int duration ,CourseDTOWithIdTitle courseDTO, List<String> studentMechNumList){
        CourseRepository courseRepo = PersistenceContext.repositories().courseRepository();
        StudentRepository studentRepo = PersistenceContext.repositories().studentRepository();
        ExtraClassRepository extraClassRepo = PersistenceContext.repositories().extraClassRepository();
        TeacherRepository teacherRepo = PersistenceContext.repositories().teacherRepository();
        Teacher teacher = teacherRepo.findTeacherBySystemUser(AuthzRegistry.authorizationService().session().get().authenticatedUser());


        List<Student> studentList = new ArrayList<>();

        for (String mecNumString : studentMechNumList){
            studentList.add(studentRepo.ofIdentity(new MecanographicNumber(mecNumString)).get());
        }

        ExtraClass newExtraClass = new ExtraClassFactory().buildExtraClass(extraClassRepo.count()+1,dateWithTime,duration,studentList,teacher);

        CourseIdentifier courseId = new CourseIdentifier(courseDTO.courseIdentifier);
        Course course = courseRepo.ofIdentity(courseId).get();
        course.addExtraClass(newExtraClass);
        courseRepo.save(course);
        return true;
    }
}
