package eapli.base.exams.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;

import java.util.Objects;

public class ExamTitle implements ValueObject, Comparable<ExamTitle>{

    private String examTitle;

    public ExamTitle(String title) {
        if(StringPredicates.isNullOrEmpty(title)){
            throw new IllegalArgumentException("Exam title cannot be null or empty");
        }
        if(title.isBlank()){
            throw new IllegalArgumentException("Exam title cannot be blank");
        }
        this.examTitle = title;
    }

    protected ExamTitle() {
        //only for ORM
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExamTitle examTitle1 = (ExamTitle) o;
        return Objects.equals(examTitle, examTitle1.examTitle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(examTitle);
    }

    @Override
    public String toString() {
        return examTitle;
    }

    @Override
    public int compareTo(ExamTitle o) {
        return examTitle.compareTo(o.examTitle);
    }
}
