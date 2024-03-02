package eapli.base.formativeexams.domain;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FormativeExamIDTest {

    @Test(expected = IllegalArgumentException.class)
    public void ensureIdIsNotZero() {
          new FormativeExamID(0L);
    }
    @Test(expected = IllegalArgumentException.class)
    public void ensureIdIsLessThanZero() {
        new FormativeExamID(-1L);
    }

    @Test
    public void ensureClassIDEquals() {
        FormativeExamID test1 = new FormativeExamID(1L);
        FormativeExamID test2 = new FormativeExamID(2L);
        assertTrue(test1.equals(test1));
        assertFalse(test1.equals(test2));
    }

}