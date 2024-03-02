package eapli.base.coursemanagement.application.services;

import eapli.base.coursemanagement.domain.Course;
import eapli.base.coursemanagement.domain.CourseIdentifier;
import eapli.base.coursemanagement.domain.Factories.CourseFactory;
import eapli.base.coursemanagement.repositories.CourseRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

public class CreateCourseService {
    public boolean createCourse(String courseId, String courseTitle, String courseName, String description, int maxEnrollments, int minEnrollments){
        CourseRepository courseRepo = PersistenceContext.repositories().courseRepository();
        if (courseRepo.ofIdentity(new CourseIdentifier(courseId)).isPresent()){
            throw new IllegalArgumentException("There already exists a course with that identifier");
        }
        CourseFactory factory = new CourseFactory();
        Course newCourse = factory.buildCourse(courseId,courseTitle,courseName,description,maxEnrollments,minEnrollments);
        courseRepo.save(newCourse);
        return true;
    }
}
