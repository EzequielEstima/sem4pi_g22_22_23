package eapli.base.usermanagement.domain;
import org.junit.Test;
import org.springframework.util.Assert;

import static org.junit.Assert.*;

public class BoardOwnerIdTest {

    private static final long VALID_ID = 1;
    private static final long INVALID_ID = -1;

    @Test(expected = IllegalArgumentException.class)
    public void ensureBoardIdIsAboveZero() {
        BoardOwnerId boardOwnerId = new BoardOwnerId(INVALID_ID);
    }


    @Test
    public void ensureBoardIdAreEqual(){
        BoardOwnerId instance1 = new BoardOwnerId(VALID_ID);
        BoardOwnerId instance2 = new BoardOwnerId(VALID_ID);
        assertTrue(instance1.equals(instance2));
    }

    @Test
    public void ensureBoardOwnerIdAreNotEqual(){
        BoardOwnerId instance1 = new BoardOwnerId(VALID_ID);
        BoardOwnerId instance2 = new BoardOwnerId(2);
        assertNotEquals(instance1, instance2);
    }



}