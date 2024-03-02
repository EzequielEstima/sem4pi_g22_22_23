package eapli.base.courseclasses.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class ClassIdTest {

    @Test(expected = IllegalArgumentException.class)
    public void ensureClassIsValid() {
        ClassId id = new ClassId(0L);
    }

    @Test
    public void ensureClassIDEquals() {
        ClassId test1 = new ClassId(1L);
        ClassId test2 = new ClassId(2L);
        assertTrue(test1.equals(test1));
        assertFalse(test1.equals(test2));
    }


}