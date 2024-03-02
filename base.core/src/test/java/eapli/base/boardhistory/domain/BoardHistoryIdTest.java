package eapli.base.boardhistory.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class BoardHistoryIdTest {

    private final static long VALID_ID = 1;
    private final static long INVALID_ID = -1;


    @Test(expected = IllegalArgumentException.class)
    public void ensureBoardHistoryIdIsAboveZero(){
        BoardHistoryId boardHistoryId = new BoardHistoryId(INVALID_ID);
    }

    @Test
    public void ensureSameBoardHistoryIdAreEqual(){
        BoardHistoryId instance1 = new BoardHistoryId(VALID_ID);
        BoardHistoryId instance2 = new BoardHistoryId(VALID_ID);
        assertEquals(instance1, instance2);
    }

    @Test
    public void ensureBoardHistoryIdAreNotEqual(){
        BoardHistoryId instance1 = new BoardHistoryId(VALID_ID);
        BoardHistoryId instance2 = new BoardHistoryId(2);
        assertNotEquals(instance1, instance2);
    }

}