package eapli.base.enrollments.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.util.Objects;

//@Embeddable
public class EnrollmentId implements ValueObject, Comparable<EnrollmentId> {
    private Long enrollment_Id;

    public EnrollmentId(Long enrollmentId) {
        if(enrollmentId <= 0){
            throw new IllegalArgumentException("Enrollment Identifier cannot be 0 or less");
        }
        this.enrollment_Id = enrollmentId;
    }

    public EnrollmentId() {
    }

    @Override
    public int compareTo(EnrollmentId o) {
        return Long.compare(this.enrollment_Id, o.enrollment_Id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EnrollmentId that = (EnrollmentId) o;
        return Objects.equals(enrollment_Id, that.enrollment_Id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(enrollment_Id);
    }
}
