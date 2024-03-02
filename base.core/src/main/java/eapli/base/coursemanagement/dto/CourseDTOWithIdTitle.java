package eapli.base.coursemanagement.dto;

public class CourseDTOWithIdTitle {
    public String courseTitle;
    public String courseIdentifier;
    public CourseDTOWithIdTitle(String courseIdentifier, String courseTitle) {
        this.courseTitle = courseTitle;
        this.courseIdentifier = courseIdentifier;
    }

    @Override
    public String toString() {
        return courseTitle + " - " + courseIdentifier;
    }
}
