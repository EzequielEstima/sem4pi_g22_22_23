package eapli.base.exams.domain;

import eapli.base.exceptions.NegativeParameterException;
import org.junit.Test;

import static org.junit.Assert.*;

public class GradeTest {

    @Test(expected = NegativeParameterException.class)
    public void ensureGradeCannotBeNegative() throws NegativeParameterException {
        Grade instance = new Grade((double) -1);
    }

    @Test
    public void ensureEqualGradesAreEqual() throws NegativeParameterException {
        Grade instance1 = new Grade((double) 40);
        Grade instance2 = new Grade((double) 40);
        assertEquals(instance1, instance2);
    }

    @Test
    public void ensureDifferentGradesAreNotEqual() throws NegativeParameterException {
        Grade instance1 = new Grade((double) 40);
        Grade instance2 = new Grade((double) 30);
        assertNotEquals(instance1, instance2);
    }
}