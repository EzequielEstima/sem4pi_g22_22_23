
package eapli.base.coursemanagement.application.services;

import eapli.base.coursemanagement.domain.CourseIdentifier;
import eapli.base.coursemanagement.dto.CourseDTOWithIdTitleStatus;
import eapli.base.coursemanagement.dto.CourseMapper;
import eapli.base.coursemanagement.domain.Course;
import eapli.base.coursemanagement.repositories.CourseRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

import java.util.ArrayList;
import java.util.List;


public class OpenCloseCourseService {
    private final CourseRepository courseRepository = PersistenceContext.repositories().courseRepository();
    public List<CourseDTOWithIdTitleStatus> listOpenableClosableCourses(){
        List<Course> courseList = courseRepository.listOpenableClosableCourses();
        List<CourseDTOWithIdTitleStatus> courseDTOList = new ArrayList<>();
        for(Course course : courseList) {
            courseDTOList.add(CourseMapper.toDTOWithIdTitleStatus(course));
        }
        return courseDTOList;
    }

    public void changeCourseStatus(CourseDTOWithIdTitleStatus courseDTO, String newStatus){
        Course course = courseRepository.ofIdentity(new CourseIdentifier(courseDTO.courseIdentifier)).get();
        course.changeStatus(newStatus);
        courseRepository.save(course);
    }
}