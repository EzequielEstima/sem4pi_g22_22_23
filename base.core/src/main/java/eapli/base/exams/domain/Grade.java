package eapli.base.exams.domain;

import eapli.base.exceptions.NegativeParameterException;
import eapli.framework.domain.model.ValueObject;

import java.util.Objects;

public class Grade implements ValueObject {

    private Double grade_value;

    public Grade(Double grade_value) throws NegativeParameterException {
        if (validateGradeValue(grade_value)) {
            this.grade_value = grade_value;
        }
    }

    private boolean validateGradeValue(Double grade_value) throws NegativeParameterException {
        return ensureGradeValueIsNotNegative(grade_value);
    }

    private boolean ensureGradeValueIsNotNegative(Double grade_value) throws NegativeParameterException {
        if(grade_value < 0){
            throw new NegativeParameterException("The grade cannot have a negative value.");
        }
        return true;
    }

    protected Grade() {
        //Only for ORM
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Grade grade = (Grade) o;
        return Objects.equals(grade_value, grade.grade_value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(grade_value);
    }

    @Override
    public String toString() {
        return "" + grade_value;
    }
}
