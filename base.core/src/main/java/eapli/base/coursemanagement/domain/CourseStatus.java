package eapli.base.coursemanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Objects;
@Embeddable
public class CourseStatus implements ValueObject {

    @Enumerated(EnumType.STRING)
    private CourseStatusValue courseStatusValue;


    public CourseStatus(CourseStatusValue courseStatusValue) {
        if (validateCourseStatusValue(courseStatusValue)){
            this.courseStatusValue = courseStatusValue;
        }
    }

    public CourseStatus(String status) {
        if (validateCourseStatusValueString(status)){
            this.courseStatusValue = CourseStatusValue.valueOf(status);
        }
    }

    private boolean validateCourseStatusValue(CourseStatusValue courseStatusValue) {
        return ensureCourseStatusValueIsNotNull(courseStatusValue);
    }

    private boolean validateCourseStatusValueString(String status) {
        return ensureCourseStatusValueIsValidOption(status);
    }

    private boolean ensureCourseStatusValueIsNotNull(CourseStatusValue courseStatusValue) {
        if(courseStatusValue == null){
            throw new IllegalArgumentException("Course status value cannot be null");
        }
        return true;
    }

    private boolean ensureCourseStatusValueIsValidOption(String status) {
        if(!status.equals("CLOSE") && !status.equals("OPEN") && !status.equals("OPEN_ENROLLMENTS") && !status.equals("CLOSED_ENROLLMENTS") && !status.equals("CLOSED")){
            throw new IllegalArgumentException("The course status must be one of the predefined options");
        }
        return true;
    }


    public CourseStatus() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseStatus that = (CourseStatus) o;
        return courseStatusValue == that.courseStatusValue;
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseStatusValue);
    }

    public String returnCourseStatusString(){
        return courseStatusValue.toString();
    }

    public int returnCourseStatusInt(){
        return courseStatusValue.getStateNumber();
    }
}
