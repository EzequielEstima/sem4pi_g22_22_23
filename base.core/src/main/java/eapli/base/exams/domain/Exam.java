package eapli.base.exams.domain;

import eapli.base.usermanagement.domain.Teacher;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;
import java.util.*;

@Entity
public class Exam implements AggregateRoot<ExamTitle>  {

    @EmbeddedId
    private ExamTitle examTitle;

    private DateInterval dateInterval;

    private ExamSpecification examSpecification;

    @ManyToOne(cascade = CascadeType.REFRESH)
    private Teacher examTeacher;

    @OneToMany(cascade = CascadeType.ALL)
    private List<ExamResolution> examResolutions = new ArrayList<>();

    protected Exam(ExamTitle examTitle, DateInterval dateInterval, ExamSpecification examSpecification, Teacher examTeacher) {
        if (examTitle == null || dateInterval == null || examSpecification == null || examTeacher == null ) throw new IllegalArgumentException("Exam cannot be created with null parameters");

        this.examTitle = examTitle;
        this.dateInterval = dateInterval;
        this.examSpecification = examSpecification;
        this.examTeacher = examTeacher;
    }

    protected Exam() {
        //Only for ORM
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Exam exam = (Exam) o;
        return Objects.equals(examTitle, exam.examTitle) && Objects.equals(dateInterval, exam.dateInterval)
                && Objects.equals(examSpecification, exam.examSpecification) && Objects.equals(examTeacher, exam.examTeacher)
                && Objects.equals(examResolutions,exam.examResolutions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(examTitle, dateInterval, examSpecification, examTeacher, examResolutions);
    }

    @Override
    public boolean sameAs(Object other) {
        if (!(other instanceof Exam)) {
            return false;
        }

        final Exam that = (Exam) other;

        return examTitle.equals(that.examTitle) && dateInterval.equals(that.dateInterval) && examSpecification.equals(that.examSpecification)
                && examTeacher.equals(that.examTeacher) && examResolutions.equals(that.examResolutions);
    }

    @Override
    public int compareTo(ExamTitle other) {
        return AggregateRoot.super.compareTo(other);
    }

    @Override
    public ExamTitle identity() {
        return examTitle;
    }

    @Override
    public boolean hasIdentity(ExamTitle id) {
        return AggregateRoot.super.hasIdentity(id);
    }

    public String returnInitialDateString(){
        return dateInterval.toStringInitialDate();
    }
    public String returnFinalDateString(){
        return dateInterval.toStringFinalDate();
    }
    public String returnExamTitleString(){return examTitle.toString();}

    public boolean updateExamSpecification(ExamSpecification specification){
        this.examSpecification = specification;
        return true;
    }

    public boolean updateDateInterval(DateInterval dateInterval){
        this.dateInterval = dateInterval;
        return true;
    }

    public String returnFullExamSpecificationString(){
        return examSpecification.returnSpecification();
    }

    public String returnStudentViewOfExamSpecification(){
        StringBuilder stringBuilder = new StringBuilder();

        List<String> specificationLines = Arrays.asList(this.examSpecification.returnSpecification().split("\n"));

        for (String str : specificationLines){
            if (!str.contains("#Solution:") && !str.contains("#Feedback:")){
                stringBuilder.append(str);
                stringBuilder.append("\n");
            }
        }

        return stringBuilder.toString();
    }

    public boolean addExamResolution(ExamResolution newExamResolution){
        return examResolutions.add(newExamResolution);
    }

    public boolean cannotBeTaken(Date currDate) {
        return currDate.before(dateInterval.initialDate()) || currDate.after(dateInterval.finalDate());
    }
}
