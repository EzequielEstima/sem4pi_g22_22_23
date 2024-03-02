package eapli.base.exams.dto;

public class ExamDTOWithExamTitleDateInterval {

    public String examTitle;
    public String initialDate;
    public String finalDate;

    protected ExamDTOWithExamTitleDateInterval(String examTitle, String initialDate, String finalDate){
        this.examTitle = examTitle;
        this.initialDate = initialDate;
        this.finalDate = finalDate;
    }

    @Override
    public String toString() {
        return examTitle +
                initialDate +
                finalDate;
    }
}
