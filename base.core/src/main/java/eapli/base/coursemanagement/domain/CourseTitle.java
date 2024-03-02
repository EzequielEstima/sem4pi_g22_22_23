package eapli.base.coursemanagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;
import java.util.Objects;
@Embeddable
public class CourseTitle implements ValueObject {
    private String course_Title;

    public CourseTitle(String courseTitle) {
        if(validateCourseTitleString(courseTitle)){
            this.course_Title = courseTitle;
        }
    }

    private boolean validateCourseTitleString(String courseTitle) {
        return ensureCourseTitleIsNotNull(courseTitle) &&
                ensureCourseTitleIsNotEmpty(courseTitle) &&
                ensureCourseTitleIsNotBlank(courseTitle);
    }

    private boolean ensureCourseTitleIsNotNull(String courseTitle) {
        if (courseTitle == null){
            throw new IllegalArgumentException("Course title cannot be null");
        }
        return true;
    }

    private boolean ensureCourseTitleIsNotEmpty(String courseTitle) {
        if (courseTitle.isEmpty()){
            throw new IllegalArgumentException("Course title cannot be empty");
        }
        return true;
    }

    private boolean ensureCourseTitleIsNotBlank(String courseTitle) {
        if (courseTitle.isBlank()){
            throw new IllegalArgumentException("Course title cannot be blank");
        }
        return true;
    }

    protected CourseTitle() {
        //only for ORM
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseTitle that = (CourseTitle) o;
        return Objects.equals(course_Title, that.course_Title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(course_Title);
    }

    public String returnCourseTitleString(){
        return course_Title;
    }
}
