package eapli.base.coursemanagement.application.services;

import eapli.base.coursemanagement.domain.Course;
import eapli.base.coursemanagement.domain.CourseIdentifier;
import eapli.base.coursemanagement.dto.CourseDTOWithIdTitleStatus;
import eapli.base.coursemanagement.dto.CourseMapper;
import eapli.base.coursemanagement.repositories.CourseRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

public class OpenCloseCourseEnrollmentsService {
    private final CourseRepository courseRepository = PersistenceContext.repositories().courseRepository();
    public List<CourseDTOWithIdTitleStatus> listAllOpenCloseEnrollmentsAvailableCourses(){
        List<CourseDTOWithIdTitleStatus> courseDTOWithIdTitleStatusList = new ArrayList<>();

        for (Course course : courseRepository.listAllOpenCLoseEnrollmentsAvailableCourses()) {
            courseDTOWithIdTitleStatusList.add(CourseMapper.toDTOWithIdTitleStatus(course));
        }

        return courseDTOWithIdTitleStatusList;
    }

    public void changeStatus(CourseDTOWithIdTitleStatus selectedCourseDTO, String newStatus){
        Course course = CourseMapper.toCourse(new CourseIdentifier(selectedCourseDTO.courseIdentifier), courseRepository);
        course.changeStatus(newStatus);
        courseRepository.save(course);
    }
}
