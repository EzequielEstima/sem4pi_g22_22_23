package eapli.base.enrollments.domain;

import org.junit.Test;

public class EnrollmentIdTest {
    @Test(expected = IllegalArgumentException.class)
    public void ensureEnrollmentIdCannotBeNegative(){
        EnrollmentId instance = new EnrollmentId( (long) -1 );
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureEnrollmentIdCannotBeZero(){
        EnrollmentId instance = new EnrollmentId( (long) 0);
    }
}