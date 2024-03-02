package eapli.base.exams.dto;

public class ExamDTOWithDatesExamTitleCourseIdBuilder {

    public String initialDate;
    public String finalDate;
    public String examTitle;
    public String courseId;

    public ExamDTOWithDatesExamTitleCourseIdBuilder withDatesExamIdCourseId(String initialDate, String finalDate, String examId, String courseId){
        withInitialDate(initialDate);
        withFinalDate(finalDate);
        withExamId(examId);
        withCourseIdentifier(courseId);
        return this;
    }

    public ExamDTOWithDatesExamTitleCourseIdBuilder withInitialDate(final String initialDate){
        this.initialDate = initialDate;
        return this;
    }

    public ExamDTOWithDatesExamTitleCourseIdBuilder withFinalDate(final String finalDate){
        this.finalDate = finalDate;
        return this;
    }

    public ExamDTOWithDatesExamTitleCourseIdBuilder withExamId (final String examTitle){
        this.examTitle = examTitle;
        return this;
    }

    public ExamDTOWithDatesExamTitleCourseIdBuilder withCourseIdentifier (final String courseIdentifier){
        this.courseId = courseIdentifier;
        return this;
    }

    public ExamDTOWithDatesExamTitleCourseId build(){
        return new ExamDTOWithDatesExamTitleCourseId(initialDate, finalDate, examTitle,courseId);
    }



}
