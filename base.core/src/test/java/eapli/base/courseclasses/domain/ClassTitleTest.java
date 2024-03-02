package eapli.base.courseclasses.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class ClassTitleTest {


    @Test(expected = IllegalArgumentException.class)
    public void ensureClassTitleCannotBeEmpty() {
        ClassTitle test =  new ClassTitle("");
    }


    @Test(expected = IllegalArgumentException.class)
    public void ensureClassTitleCannotBeNull() {
        ClassTitle test =  new ClassTitle(null);
    }

    @Test
    public void ensureDurationEquals() {
        ClassTitle test1 =  new ClassTitle("Title1");
        ClassTitle test2 =  new ClassTitle("Title2");

        assertTrue(test1.equals(test1));
        assertFalse(test2.equals(test1));
    }
}