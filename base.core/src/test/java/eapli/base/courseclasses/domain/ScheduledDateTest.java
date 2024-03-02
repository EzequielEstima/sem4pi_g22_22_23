package eapli.base.courseclasses.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class ScheduledDateTest {

    @Test
    public void verifyIfExistAtTheCurrentTime() {
        ScheduledDate test1 = new ScheduledDate(new Duration(60),new Date(new java.util.Date(1000,10,2,10,0,0)));

        java.util.Date testData1 = new java.util.Date(1000,10,2,10,0,0);
        assertTrue(test1.verifyIfExistAtTheCurrentTime(testData1,60));

        java.util.Date testData2 = new java.util.Date(1000,10,2,9,30,0);
        assertTrue(test1.verifyIfExistAtTheCurrentTime(testData2,60));
        assertTrue(test1.verifyIfExistAtTheCurrentTime(testData2,120));
        assertFalse(test1.verifyIfExistAtTheCurrentTime(testData2,1));

        java.util.Date testData3 = new java.util.Date(1000,10,2,10,30,0);
        assertTrue(test1.verifyIfExistAtTheCurrentTime(testData3,30));
        assertTrue(test1.verifyIfExistAtTheCurrentTime(testData3,30));
        assertTrue(test1.verifyIfExistAtTheCurrentTime(testData3,10));

        java.util.Date testData4 = new java.util.Date(1000,10,2,11,30,0);
        assertFalse(test1.verifyIfExistAtTheCurrentTime(testData4,1));

        java.util.Date testData5 = new java.util.Date(1000,10,3,10,0,0);
        assertFalse(test1.verifyIfExistAtTheCurrentTime(testData5,60));
    }

    @Test
    public void compareIfScheduleClassIsOneWeekAfter() {

        ScheduledDate test1 = new ScheduledDate(new Duration(60),new Date(new java.util.Date(1000,10,2,10,0,0)));
        ScheduledDate test2 = new ScheduledDate(new Duration(30),new Date(new java.util.Date(1000,10,9,10,0,0)));
        ScheduledDate test3 = new ScheduledDate(new Duration(60),new Date(new java.util.Date(1000,10,9,10,0,0)));

        assertFalse(test1.compareIfScheduleClassIsOneWeekAfter(test2));
        assertTrue(test1.compareIfScheduleClassIsOneWeekAfter(test3));
    }

    @Test
    public void ensureScheduledDatesEquals() {

        ScheduledDate test1 = new ScheduledDate(new Duration(60),new Date(new java.util.Date(1000,10,2,10,0,0)));
        ScheduledDate test2 = new ScheduledDate(new Duration(30),new Date(new java.util.Date(1000,10,2,10,0,0)));

        assertTrue(test1.compareIfScheduleClassIsOneWeekAfter(test1));
        assertFalse(test1.compareIfScheduleClassIsOneWeekAfter(test2));
    }
}