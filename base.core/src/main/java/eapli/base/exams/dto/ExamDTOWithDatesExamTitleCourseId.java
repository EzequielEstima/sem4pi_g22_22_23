package eapli.base.exams.dto;

public class ExamDTOWithDatesExamTitleCourseId {

    public String initialDate;
    public String finalDate;
    public String examTitle;
    public String courseId;

    public ExamDTOWithDatesExamTitleCourseId(String initialDate, String finalDate, String examTitle , String courseId) {
        this.initialDate = initialDate;
        this.finalDate = finalDate;
        this.examTitle = examTitle;
        this.courseId = courseId;
    }
}
