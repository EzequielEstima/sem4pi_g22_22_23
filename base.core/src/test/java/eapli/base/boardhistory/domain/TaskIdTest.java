package eapli.base.boardhistory.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class TaskIdTest {

    private final static long VALID_ID = 1;
    private final static long INVALID_ID = -1;


    @Test(expected = IllegalArgumentException.class)
    public void ensureTaskIdIsAboveZero(){
        TaskId taskId = new TaskId(INVALID_ID);
    }

    @Test
    public void ensureSameTaskIdAreEqual(){
        TaskId instance1 = new TaskId(VALID_ID);
        TaskId instance2 = new TaskId(VALID_ID);
        assertEquals(instance1, instance2);
    }

    @Test
    public void ensureTaskIdAreNotEqual(){
        TaskId instance1 = new TaskId(VALID_ID);
        TaskId instance2 = new TaskId(2);
        assertNotEquals(instance1, instance2);
    }

}