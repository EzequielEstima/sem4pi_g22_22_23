package eapli.base.exams.domain;


import eapli.base.exceptions.InvalidIdException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class ExamResolutionIdTest {
    @Test(expected = InvalidIdException.class)
    public void ensureIdCannotBeNegative() throws InvalidIdException {
        ExamResolutionId instance = new ExamResolutionId((long) -1);
    }

    @Test(expected = InvalidIdException.class)
    public void ensureIdCannotBeZero() throws InvalidIdException {
        ExamResolutionId instance = new ExamResolutionId((long) 0);
    }

    @Test
    public void ensureEqualIdsAreEqual() throws InvalidIdException {
        ExamResolutionId instance1 = new ExamResolutionId((long) 1);
        ExamResolutionId instance2 = new ExamResolutionId((long) 1);
        assertEquals(instance1, instance2);
    }

    @Test
    public void ensureDifferentIdsAreNotEqual() throws InvalidIdException {
        ExamResolutionId instance1 = new ExamResolutionId((long) 1);
        ExamResolutionId instance2 = new ExamResolutionId((long) 4);
        assertNotEquals(instance1, instance2);
    }
}