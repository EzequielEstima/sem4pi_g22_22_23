package eapli.base.exams.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class ExamSpecification implements ValueObject {

    @Column(length = 10000)
    private String specification;

    public ExamSpecification(String specification) {
        if(StringPredicates.isNullOrEmpty(specification)){
            throw new IllegalArgumentException("Exam specification cannot be null or empty");
        }
        if(specification.isBlank()){
            throw new IllegalArgumentException("Exam specification cannot be blank");
        }
        this.specification = specification;
    }

    protected ExamSpecification() {
        //only for ORM
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExamSpecification that = (ExamSpecification) o;
        return Objects.equals(specification, that.specification);
    }

    @Override
    public int hashCode() {
        return Objects.hash(specification);
    }

    public String returnSpecification(){
        return this.specification;
    }
}
