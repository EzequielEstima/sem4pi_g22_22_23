package eapli.base.coursemanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class EnrollmentLimits implements ValueObject {
    private int minEnrollments;
    private int maxEnrollments;

    public EnrollmentLimits(int minEnrollments, int maxEnrollments) {
        if(verifyEnrollmentLimits(minEnrollments,maxEnrollments)){
            this.minEnrollments = minEnrollments;
            this.maxEnrollments = maxEnrollments;
        }
    }

    private boolean verifyEnrollmentLimits(int minEnrollments, int maxEnrollments) {
        return ensureLimitIsGreaterThanZero(minEnrollments) &&
                ensureLimitIsGreaterThanZero(maxEnrollments) &&
                ensureMaxLimitIsGraterThanMinLimit(minEnrollments,maxEnrollments);
    }

    private boolean ensureLimitIsGreaterThanZero(int limit){
        if(limit < 1){
            throw new IllegalArgumentException("Any enrollment limit must be greater than 0");
        }
        return true;
    }

    private boolean ensureMaxLimitIsGraterThanMinLimit(int minLimit, int maxLimit){
        if(minLimit > maxLimit){
            throw new IllegalArgumentException("Maximum number of course enrollments must be greater or equal to the minimum number of course enrollments");
        }
        return true;
    }

    protected EnrollmentLimits() {
        //only for ORM
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EnrollmentLimits that = (EnrollmentLimits) o;
        return minEnrollments == that.minEnrollments && maxEnrollments == that.maxEnrollments;
    }

    @Override
    public int hashCode() {
        return Objects.hash(minEnrollments, maxEnrollments);
    }

    public boolean verifyIfWillExceedEnrollmentLimits(int numberOfAcceptedEnrollments, int numberOfNewEnrollments){
        if((numberOfAcceptedEnrollments + numberOfNewEnrollments) < maxEnrollments){
            return false;
        }
        throw new IllegalStateException("Maximum number of enrollments has been reached already!");
    }
}
