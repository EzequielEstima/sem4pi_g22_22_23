package eapli.base.board.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class CellIdTest {

    private final static long VALID_CELL_ID = 1;
    private final static long INVALID_CELL_ID = -1;

    @Test(expected = IllegalArgumentException.class)
    public void ensureCellIdIsAboveZero(){
        CellId cellId = new CellId(INVALID_CELL_ID);
    }

    @Test
    public void ensureSameCellIdAreEqual(){
        CellId instance1 = new CellId(VALID_CELL_ID);
        CellId instance2 = new CellId(VALID_CELL_ID);
        assertEquals(instance1, instance2);
    }

    @Test
    public void ensureDiffCellIdAreNotEqual(){
        CellId instance1 = new CellId(VALID_CELL_ID);
        CellId instance2 = new CellId(2);
        assertNotEquals(instance1, instance2);
    }

}
