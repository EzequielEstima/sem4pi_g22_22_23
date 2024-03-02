package eapli.base.coursemanagement.dto;

import java.util.List;

public class CourseDTOBuilder {
    private String courseIdentifier;
    private String courseTitle;
    private String courseName;
    private String courseDescription;
    private List<Integer> enrollmentLimits;
    private String courseStatus;
    private String teacherInCharge;

    public CourseDTOBuilder withCourseIdentifier(final String courseIdentifier){
        this.courseIdentifier = courseIdentifier;
        return this;
    }

    public CourseDTOBuilder withCourseTitle(final String courseTitle){
        this.courseTitle = courseTitle;
        return this;
    }

    public CourseDTOBuilder withCourseName(final String courseName){
        this.courseName = courseName;
        return this;
    }

    public CourseDTOBuilder withCourseDescription(final String courseDescription){
        this.courseDescription = courseDescription;
        return this;
    }

    public CourseDTOBuilder withEnrollmentLimits(final List<Integer> enrollmentLimits){
        this.enrollmentLimits = enrollmentLimits;
        return this;
    }

    public CourseDTOBuilder withCourseStatus(final String courseStatus){
        this.courseStatus = courseStatus;
        return this;
    }

    public CourseDTOBuilder withTeacherInCharge(final String teacherInCharge){
        this.teacherInCharge = teacherInCharge;
        return this;
    }

    public CourseDTOWithIdTitleStatus buildWithIdTitleStatus(){
        return new CourseDTOWithIdTitleStatus(this.courseIdentifier, this.courseTitle, this.courseStatus);
    }

    public CourseDTOWithIdTitle buildWithIdTitle(){
        return new CourseDTOWithIdTitle(this.courseIdentifier, this.courseTitle);
    }

}
