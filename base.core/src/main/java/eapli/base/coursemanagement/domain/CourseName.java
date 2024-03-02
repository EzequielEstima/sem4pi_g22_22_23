package eapli.base.coursemanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;

import javax.persistence.Embeddable;
import java.util.Objects;
@Embeddable
public class CourseName implements ValueObject {
    private String course_Name;

    public CourseName(String courseName) {
        if(validateCourseNameString(courseName)){
            this.course_Name = courseName;
        }
    }

    private boolean validateCourseNameString(String courseName) {
        return ensureCourseNameIsNotNull(courseName) &&
                ensureCourseNameIsNotEmpty(courseName) &&
                ensureCourseNameIsNotBlank(courseName);
    }

    private boolean ensureCourseNameIsNotNull(String courseName) {
        if (courseName == null){
            throw new IllegalArgumentException("Course name cannot be null");
        }
        return true;
    }

    private boolean ensureCourseNameIsNotEmpty(String courseName) {
        if (courseName.isEmpty()){
            throw new IllegalArgumentException("Course name cannot be empty");
        }
        return true;
    }

    private boolean ensureCourseNameIsNotBlank(String courseName) {
        if (courseName.isBlank()){
            throw new IllegalArgumentException("Course name cannot be blank");
        }
        return true;
    }

    protected CourseName() {
        //only for ORM
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseName that = (CourseName) o;
        return Objects.equals(course_Name, that.course_Name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(course_Name);
    }
}
