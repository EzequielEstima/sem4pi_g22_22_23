package eapli.base.exams.dto;

public class ExamDTOWithExamTitleDateIntervalBuilder {

    private String examId;
    private String initialDate;
    private String finalDate;

    public ExamDTOWithExamTitleDateIntervalBuilder withExamId(String examId){
        this.examId = examId;
        return this;
    }

    public ExamDTOWithExamTitleDateIntervalBuilder withInitialDate(String initialDate){
        this.initialDate = initialDate;
        return this;
    }

    public ExamDTOWithExamTitleDateIntervalBuilder withFinalDate(String finalDate){
        this.finalDate = finalDate;
        return this;
    }

    public ExamDTOWithExamTitleDateInterval build(){
        return new ExamDTOWithExamTitleDateInterval(this.examId, this.initialDate, this.finalDate);
    }
}
