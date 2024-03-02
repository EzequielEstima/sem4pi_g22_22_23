package eapli.base.exams.dto;

public class ExamResolutionDTOExamTitleGradeBuilder {

    private String examTitle;
    private String grade;

    public ExamResolutionDTOExamTitleGradeBuilder withExamTitleGrade(String examTitle,String grade){
        withExamTitle(examTitle);
        withGrade(grade);
        return this;
    }

    public ExamResolutionDTOExamTitleGradeBuilder withExamTitle(String examTitle){
        this.examTitle = examTitle;
        return this;
    }


    public ExamResolutionDTOExamTitleGradeBuilder withGrade(String grade){
        this.grade = grade;
        return this;
    }

    public ExamResolutionDTOExamTitleGrade build(){
        return new ExamResolutionDTOExamTitleGrade(examTitle,grade);
    }
}
