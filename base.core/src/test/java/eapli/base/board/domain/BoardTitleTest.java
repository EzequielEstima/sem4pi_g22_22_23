package eapli.base.board.domain;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class BoardTitleTest {

    private final String VALID_BOARD_TITLE = "board";

    @Test(expected = IllegalArgumentException.class)
    public void ensureBoardTitleIsNotNull(){
        BoardTitle instance = new BoardTitle(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureBoardTitleIsNotBlank(){
        BoardTitle instance = new BoardTitle("       ");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureBoardTitleIsNotEmpty(){
        BoardTitle instance = new BoardTitle("");
    }

    @Test
    public void ensureSameBoardTitleAreEqual(){
        BoardTitle instance1 = new BoardTitle(VALID_BOARD_TITLE);
        BoardTitle instance2 = new BoardTitle(VALID_BOARD_TITLE);
        assertEquals(instance1, instance2);
    }

    @Test
    public void ensureDiffBoardTitleAreNotEqual(){
        BoardTitle instance1 = new BoardTitle(VALID_BOARD_TITLE);
        BoardTitle instance2 = new BoardTitle("borda");
        assertNotEquals(instance1, instance2);
    }
}
