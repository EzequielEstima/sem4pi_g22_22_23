package eapli.base.formativeexams.domain;

import eapli.framework.domain.model.ValueObject;

import java.util.Objects;

public class FormativeExamID implements Comparable<FormativeExamID>, ValueObject {

    long formativeExam_Id;

    public FormativeExamID(long formativeExam_Id) {
        if (formativeExam_Id <= 0 ) {
            throw new IllegalArgumentException(
                    "ID number must be greater than 0");
        }
        this.formativeExam_Id = formativeExam_Id;
    }

    protected FormativeExamID() {
        //only for ORM
    }

    @Override
    public int compareTo(FormativeExamID o) {
        return Long.compare(formativeExam_Id, o.formativeExam_Id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(formativeExam_Id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        FormativeExamID that = (FormativeExamID) obj;
        return Objects.equals(formativeExam_Id, that.formativeExam_Id);
    }

    @Override
    public String toString() {
        return "formativeExam_Id=" + formativeExam_Id;
    }
}
