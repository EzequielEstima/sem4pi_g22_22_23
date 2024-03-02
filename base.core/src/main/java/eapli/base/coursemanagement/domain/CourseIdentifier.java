package eapli.base.coursemanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;
import eapli.framework.validations.Preconditions;

import java.util.Objects;

public class CourseIdentifier implements Comparable<CourseIdentifier>, ValueObject {
    private String course_Id;

    public CourseIdentifier(String courseId) {
        if(validateCourseIdString(courseId)){
            this.course_Id = courseId;
        }
    }

    private boolean validateCourseIdString(String courseId) {
        return ensureCourseIdIsNotNull(courseId) &&
                ensureCourseIdIsNotEmpty(courseId) &&
                ensureCourseIdIsNotBlank(courseId);
    }

    private boolean ensureCourseIdIsNotNull(String courseId) {
        if (courseId == null){
            throw new IllegalArgumentException("Course identifier cannot be null");
        }
        return true;
    }

    private boolean ensureCourseIdIsNotEmpty(String courseId) {
        if (courseId.isEmpty()){
            throw new IllegalArgumentException("Course identifier cannot be empty");
        }
        return true;
    }

    private boolean ensureCourseIdIsNotBlank(String courseId) {
        if (courseId.isBlank()){
            throw new IllegalArgumentException("Course identifier cannot be blank");
        }
        return true;
    }

    protected CourseIdentifier() {
        //only for ORM
    }

    @Override
    public int compareTo(CourseIdentifier o) {
        return course_Id.compareTo(o.course_Id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseIdentifier that = (CourseIdentifier) o;
        return Objects.equals(course_Id, that.course_Id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(course_Id);
    }

    public String returnCourseIdentifierString(){
        return course_Id;
    }
}
