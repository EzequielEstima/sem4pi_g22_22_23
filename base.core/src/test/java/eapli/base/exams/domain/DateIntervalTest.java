package eapli.base.exams.domain;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class DateIntervalTest {

    @Test(expected = IllegalArgumentException.class)
    public void ensureThatDateIntervalCannotBeCreateWithInitialDateBiggerThanFinalDate() {
        DateInterval test= new DateInterval(new Date(1000,1,10),new Date (1000,1,9));
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureThatDateIntervalCannotBeCreateWithNullValues() {
        DateInterval test= new DateInterval(null,null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureThatDateHasToBeInTheFuture() {
        DateInterval test= new DateInterval(new Date(0,1,9),new Date (0,1,10));
    }

    @Test
    public void ensureEqualsDateInterval(){
        DateInterval test1= new DateInterval(new Date(1000,1,9),new Date (1000,1,10));
        DateInterval test2= new DateInterval(new Date(1000,1,10),new Date (1000,1,11));
        assertTrue(test1.equals(test1));
        assertFalse(test1.equals(test2));
    }

}