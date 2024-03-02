package eapli.base.courseclasses.domain;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class WeeklyDateTest {

    @Test(expected = IllegalArgumentException.class)
    public void ensuresThatWeeklyDateFailsForDifferentDaysOfTheWeek() {
        ScheduledDate scheduledDate1 = new ScheduledDate(new Duration(60),new Date(new java.util.Date(1000,10,2,10,0,0)));
        ScheduledDate scheduledDate2 = new ScheduledDate(new Duration(60),new Date(new java.util.Date(1000,10,3,10,0,0)));
        List<ScheduledDate> list = new ArrayList<>();
        list.add(scheduledDate1);
        list.add(scheduledDate2);
        WeeklyDate weeklyDate = new WeeklyDate(list,true);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensuresThatWeeklyDateFailsForDifferentDuration() {
        ScheduledDate scheduledDate1 = new ScheduledDate(new Duration(30),new Date(new java.util.Date(1000,10,2,10,0,0)));
        ScheduledDate scheduledDate2 = new ScheduledDate(new Duration(60),new Date(new java.util.Date(1000,10,9,10,0,0)));
        List<ScheduledDate> list = new ArrayList<>();
        list.add(scheduledDate1);
        list.add(scheduledDate2);
        WeeklyDate weeklyDate = new WeeklyDate(list,true);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensuresThatWeeklyDateFailsForDifferentTimes() {
        ScheduledDate scheduledDate1 = new ScheduledDate(new Duration(60),new Date(new java.util.Date(1000,10,2,10,0,0)));
        ScheduledDate scheduledDate2 = new ScheduledDate(new Duration(60),new Date(new java.util.Date(1000,10,9,10,10,0)));
        List<ScheduledDate> list = new ArrayList<>();
        list.add(scheduledDate1);
        list.add(scheduledDate2);
        WeeklyDate weeklyDate = new WeeklyDate(list,true);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensuresThatWeeklyDateCannotBeNull() {
        WeeklyDate weeklyDate = new WeeklyDate(null,true);
    }


    @Test
    public void verifyIfAClassAtTheTime() {
        ScheduledDate scheduledDate1 = new ScheduledDate(new Duration(60),new Date(new java.util.Date(1000,10,2,10,0,0)));
        ScheduledDate scheduledDate2 = new ScheduledDate(new Duration(60),new Date(new java.util.Date(1000,10,9,10,0,0)));
        List<ScheduledDate> list = new ArrayList<>();
        list.add(scheduledDate1);
        list.add(scheduledDate2);
        WeeklyDate weeklyDate = new WeeklyDate(list,true);

        java.util.Date testData1 = new java.util.Date(1000,10,9,10,10,0);
        assertTrue(weeklyDate.verifyIfAClassAtTheTime(testData1,30));

        java.util.Date testData2 = new java.util.Date(1000,10,9,11,30,0);
        assertFalse(weeklyDate.verifyIfAClassAtTheTime(testData2,30));
    }
}