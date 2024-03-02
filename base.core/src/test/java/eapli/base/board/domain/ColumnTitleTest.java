package eapli.base.board.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class ColumnTitleTest {
    private final String VALID_COLUMN_TITLE = "column";

    @Test(expected = IllegalArgumentException.class)
    public void ensureColumnTitleIsNotNull(){
        ColumnTitle instance = new ColumnTitle(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureColumnTitleIsNotBlank(){
        ColumnTitle instance = new ColumnTitle("       ");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureColumnTitleIsNotEmpty(){
        ColumnTitle instance = new ColumnTitle("");
    }

    @Test
    public void ensureSameColumnTitleAreEqual(){
        ColumnTitle instance1 = new ColumnTitle(VALID_COLUMN_TITLE);
        ColumnTitle instance2 = new ColumnTitle(VALID_COLUMN_TITLE);
        assertEquals(instance1, instance2);
    }

    @Test
    public void ensureDiffColumnTitleAreNotEqual(){
        ColumnTitle instance1 = new ColumnTitle(VALID_COLUMN_TITLE);
        ColumnTitle instance2 = new ColumnTitle("colum");
        assertNotEquals(instance1, instance2);
    }

}