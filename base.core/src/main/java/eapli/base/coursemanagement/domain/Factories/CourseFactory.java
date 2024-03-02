package eapli.base.coursemanagement.domain.Factories;

import eapli.base.coursemanagement.domain.*;

public class CourseFactory {
    public Course buildCourse(String courseId, String courseTitle, String courseName, String description, int maxEnrollments, int minEnrollments){
        CourseIdentifier id = new CourseIdentifier(courseId);
        CourseTitle title = new CourseTitle(courseTitle);
        CourseName name = new CourseName(courseName);
        Description desc = new Description(description);
        EnrollmentLimits limits = new EnrollmentLimits(minEnrollments,maxEnrollments);
        CourseStatus status = new CourseStatus("CLOSE");

        return new Course(id,title,name,desc,limits,status,null);
    }
}
