package eapli.base.enrollments.domain;

import eapli.framework.domain.model.ValueObject;


import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Objects;

@Embeddable
public class EnrollmentStatus implements ValueObject {

    @Enumerated(EnumType.STRING)
    private EnrollmentStatusValue enrollmentStatusValue;

    public EnrollmentStatus(EnrollmentStatusValue enrollmentStatusValue) {
        this.enrollmentStatusValue = enrollmentStatusValue;
    }
    
    public EnrollmentStatus() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EnrollmentStatus that = (EnrollmentStatus) o;
        return enrollmentStatusValue == that.enrollmentStatusValue;
    }

    @Override
    public int hashCode() {
        return Objects.hash(enrollmentStatusValue);
    }

    public String returnEnrollmentStatusString(){
        return enrollmentStatusValue.toString();
    }
}
