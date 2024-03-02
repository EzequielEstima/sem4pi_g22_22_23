package eapli.base.board.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class ColumnIdentifierTest {
    
    private final static int VALID_COLUMN_IDENTIFIER = 1;
    private final static int INVALID_COLUMN_IDENTIFIER_NEG = -1;
    private final static int INVALID_COLUMN_IDENTIFIER_ABOVE_LIMIT = 11;

    @Test(expected = IllegalArgumentException.class)
    public void ensureColumnIdentifierIsAboveZero(){
        ColumnIdentifier ColumnIdentifier = new ColumnIdentifier(INVALID_COLUMN_IDENTIFIER_NEG);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureColumnIdentifierIsAboveLimit(){
        ColumnIdentifier ColumnIdentifier = new ColumnIdentifier(INVALID_COLUMN_IDENTIFIER_ABOVE_LIMIT);
    }

    @Test
    public void ensureSameColumnIdentifierAreEqual(){
        ColumnIdentifier instance1 = new ColumnIdentifier(VALID_COLUMN_IDENTIFIER);
        ColumnIdentifier instance2 = new ColumnIdentifier(VALID_COLUMN_IDENTIFIER);
        assertEquals(instance1, instance2);
    }

    @Test
    public void ensureDiffColumnIdentifierAreNotEqual(){
        ColumnIdentifier instance1 = new ColumnIdentifier(VALID_COLUMN_IDENTIFIER);
        ColumnIdentifier instance2 = new ColumnIdentifier(2);
        assertNotEquals(instance1, instance2);
    }
}
