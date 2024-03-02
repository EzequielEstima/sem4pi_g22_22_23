package eapli.base.board.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class RowIdentifierTest {
    private final static int VALID_ROW_IDENTIFIER = 1;
    private final static int INVALID_ROW_IDENTIFIER_NEG = -1;
    private final static int INVALID_ROW_IDENTIFIER_ABOVE_LIMIT = 21;

    @Test(expected = IllegalArgumentException.class)
    public void ensureRowIdentifierIsAboveZero(){
        RowIdentifier RowIdentifier = new RowIdentifier(INVALID_ROW_IDENTIFIER_NEG);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureRowIdentifierIsAboveLimit(){
        RowIdentifier RowIdentifier = new RowIdentifier(INVALID_ROW_IDENTIFIER_ABOVE_LIMIT);
    }

    @Test
    public void ensureSameRowIdentifierAreEqual(){
        RowIdentifier instance1 = new RowIdentifier(VALID_ROW_IDENTIFIER);
        RowIdentifier instance2 = new RowIdentifier(VALID_ROW_IDENTIFIER);
        assertEquals(instance1, instance2);
    }

    @Test
    public void ensureDiffRowIdentifierAreNotEqual(){
        RowIdentifier instance1 = new RowIdentifier(VALID_ROW_IDENTIFIER);
        RowIdentifier instance2 = new RowIdentifier(2);
        assertNotEquals(instance1, instance2);
    }
}
