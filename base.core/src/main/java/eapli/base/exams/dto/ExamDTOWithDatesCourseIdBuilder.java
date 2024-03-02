package eapli.base.exams.dto;

public class ExamDTOWithDatesCourseIdBuilder {
    private String initialDate;
    private String finalDate;

    private String courseIdentifier;

    public ExamDTOWithDatesCourseIdBuilder withInitialDate(final String initialDate){
        this.initialDate = initialDate;
        return this;
    }

    public ExamDTOWithDatesCourseIdBuilder withFinalDate(final String finalDate){
        this.finalDate = finalDate;
        return this;
    }

    public ExamDTOWithDatesCourseIdBuilder withCourseIdentifier (final String courseIdentifier){
        this.courseIdentifier = courseIdentifier;
        return this;
    }

    public ExamDTOWithDatesCourseId build(){
        return new ExamDTOWithDatesCourseId(initialDate, finalDate, courseIdentifier);
    }
}
