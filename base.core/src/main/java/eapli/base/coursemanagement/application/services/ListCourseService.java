package eapli.base.coursemanagement.application.services;

import eapli.base.coursemanagement.domain.Course;
import eapli.base.coursemanagement.dto.CourseDTOWithIdTitle;
import eapli.base.coursemanagement.dto.CourseMapper;
import eapli.base.coursemanagement.repositories.CourseRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.util.ArrayList;
import java.util.List;

public class ListCourseService {

    public ArrayList<CourseDTOWithIdTitle> listCourse(){

        AuthorizationService authz = AuthzRegistry.authorizationService();
        SystemUser user = authz.session().get().authenticatedUser();
        CourseRepository courseRepository = PersistenceContext.repositories().courseRepository();
        Iterable<Course> listCourse;
        if (user.hasAny(BaseRoles.MANAGER)){
            listCourse = courseRepository.findAll();
        }else{
            if (user.hasAny(BaseRoles.TEACHER)){
                List<Course> listCourseList = new ArrayList<>();
                listCourseList.addAll(courseRepository.findTeacherInChargeCourses(user)) ;
                listCourseList.addAll(courseRepository.findTeacherLecturesCourses(user)) ;
                listCourse = listCourseList;
            }else{
                listCourse = courseRepository.findStudentCourses(user);
            }
        }
        ArrayList<CourseDTOWithIdTitle> listCourseDto = new ArrayList<>();
        if (listCourse != null) {
            for (Course course : listCourse) {
                listCourseDto.add(CourseMapper.toDTOWithIdTitle(course));
            }
        }

        return listCourseDto;
    }

}
