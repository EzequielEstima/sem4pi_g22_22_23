package eapli.base.exams.domain;

import eapli.base.exceptions.InvalidIdException;
import eapli.framework.domain.model.ValueObject;

import java.util.Objects;

public class ExamResolutionId implements Comparable<ExamResolutionId>, ValueObject {
    private Long examResolution_id;

    public ExamResolutionId(Long examResolution_id) throws InvalidIdException {
        if(validateExamResolutionId(examResolution_id)){
            this.examResolution_id = examResolution_id;
        }

    }

    private boolean validateExamResolutionId(Long examResolution_id) throws InvalidIdException {
        return ensureIdIsGreaterThanZero(examResolution_id);
    }

    private boolean ensureIdIsGreaterThanZero(Long examResolution_id) throws InvalidIdException {
        if (examResolution_id < 1 ){
            throw new InvalidIdException("The exam resolution id must be greater than zero.");
        }
        return true;
    }

    protected ExamResolutionId() {
        //Only for ORM
    }

    @Override
    public int compareTo(ExamResolutionId o) {
        return Long.compare(this.examResolution_id,o.examResolution_id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExamResolutionId that = (ExamResolutionId) o;
        return Objects.equals(examResolution_id, that.examResolution_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(examResolution_id);
    }
}
