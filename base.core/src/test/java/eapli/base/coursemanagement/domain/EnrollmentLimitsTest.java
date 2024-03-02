package eapli.base.coursemanagement.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class EnrollmentLimitsTest {

    @Test(expected = IllegalArgumentException.class)
    public void ensureMinEnrollmentsIsGreaterThanZero(){
        EnrollmentLimits instance = new EnrollmentLimits(-1,10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureMaxEnrollmentsIsGreaterThanMinEnrollments(){
        EnrollmentLimits instance = new EnrollmentLimits(12,10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureMaxEnrollmentsAndMinEnrollmentsMustBePositive(){
        EnrollmentLimits instance = new EnrollmentLimits(-4,-1);
    }

    @Test
    public void ensureSameLimitsAreEqual(){
        EnrollmentLimits instance1 = new EnrollmentLimits(1,10);
        EnrollmentLimits instance2 = new EnrollmentLimits(1,10);
        assertEquals(instance1,instance2);
    }

    @Test
    public void ensureLimitsWithDiffMaxLimitsAreNotEqual(){
        EnrollmentLimits instance1 = new EnrollmentLimits(1,10);
        EnrollmentLimits instance2 = new EnrollmentLimits(1,20);
        assertNotEquals(instance1,instance2);
    }

    @Test
    public void ensureLimitsWithDiffMinLimitsAreNotEqual(){
        EnrollmentLimits instance1 = new EnrollmentLimits(1,10);
        EnrollmentLimits instance2 = new EnrollmentLimits(5,10);
        assertNotEquals(instance1,instance2);
    }

    @Test
    public void ensureLimitsWithDiffMinAndMaxLimitsAreNotEqual(){
        EnrollmentLimits instance1 = new EnrollmentLimits(1,10);
        EnrollmentLimits instance2 = new EnrollmentLimits(5,20);
        assertNotEquals(instance1,instance2);
    }
}