package eapli.base.board.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class RowTitleTest {
    private final String VALID_ROW_TITLE = "row";

    @Test(expected = IllegalArgumentException.class)
    public void ensureRowTitleIsNotNull(){
        RowTitle instance = new RowTitle(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureRowTitleIsNotBlank(){
        RowTitle instance = new RowTitle("       ");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureRowTitleIsNotEmpty(){
        RowTitle instance = new RowTitle("");
    }

    @Test
    public void ensureSameRowTitleAreEqual(){
        RowTitle instance1 = new RowTitle(VALID_ROW_TITLE);
        RowTitle instance2 = new RowTitle(VALID_ROW_TITLE);
        assertEquals(instance1, instance2);
    }

    @Test
    public void ensureDiffRowTitleAreNotEqual(){
        RowTitle instance1 = new RowTitle(VALID_ROW_TITLE);
        RowTitle instance2 = new RowTitle("rwo");
        assertNotEquals(instance1, instance2);
    }

}