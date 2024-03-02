package eapli.base.courseclasses.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class DurationTest {

    @Test(expected = IllegalArgumentException.class)
    public void ensureThatDurationWithNegativeNumberWillFail() {
        Duration test= new Duration(-3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureThatDurationWithZeroWillFail() {
        Duration test= new Duration(0);
    }


    @Test
    public void ensureDurationEquals() {
        Duration test1= new Duration(1);
        Duration test2= new Duration(1);
        Duration test3= new Duration(2);

        assertTrue(test1.equals(test2));
        assertFalse(test2.equals(test3));
    }


}