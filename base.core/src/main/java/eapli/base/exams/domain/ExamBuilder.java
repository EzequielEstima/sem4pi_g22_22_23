package eapli.base.exams.domain;

import eapli.base.usermanagement.domain.Teacher;

import java.util.Date;

public class ExamBuilder {

    private DateInterval dateInterval;

    private ExamTitle examTitle;

    private ExamSpecification specification;

    private Teacher teacher;



    public ExamBuilder withExamSpecification(String structure){
        this.specification = new ExamSpecification(structure);
        new VerifyExamSpecificationService().verifyExamSpecification(structure);
        String[] lines = structure.split("\r\n");
        String[] title = lines[0].split(":");
        this.examTitle = new ExamTitle(title[1].trim());
        return this;
    }

    public ExamBuilder withDateInterval(Date initialDate, Date finalDate){
        this.dateInterval = new DateInterval(initialDate,finalDate);
        return this;
    }

    public ExamBuilder withTeacher(Teacher teacher){
        this.teacher = teacher;
        return this;
    }

    public Exam build(){
        return new Exam(examTitle, dateInterval,specification,teacher);
    }


}
