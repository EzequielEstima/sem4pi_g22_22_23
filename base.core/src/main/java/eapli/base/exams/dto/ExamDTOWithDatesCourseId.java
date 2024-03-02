package eapli.base.exams.dto;

public class ExamDTOWithDatesCourseId {
    public String initialDate;
    public String finalDate;
    public String courseId;

    public ExamDTOWithDatesCourseId(String initialDate, String finalDate, String courseId) {
        this.initialDate = initialDate;
        this.finalDate = finalDate;
        this.courseId = courseId;
    }
}
