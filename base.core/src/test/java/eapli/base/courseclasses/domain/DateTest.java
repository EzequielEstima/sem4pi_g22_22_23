package eapli.base.courseclasses.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class DateTest {



    @Test(expected = IllegalArgumentException.class)
    public void ensureDateCannotBeInThePast() {
        Date test =  new Date(new java.util.Date(0,10,2));
    }
    @Test
    public void compareDayOfTheWeekAndTime() {
        Date test1 =  new Date(new java.util.Date(1000,10,2,10,10,10));
        Date test2 =  new Date(new java.util.Date(1000,10,9,10,10,10));
        assertTrue(test1.compareDayOfTheWeekAndTime(test2));
    }

    @Test
    public void ensureDateEquals() {
        Date test1 =  new Date(new java.util.Date(1000,10,2,10,10,10));
        Date test2 =  new Date(new java.util.Date(1000,10,9,10,10,10));
        assertTrue(test1.equals(test1));
        assertFalse(test1.equals(test2));
    }
}