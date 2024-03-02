package eapli.base.board.domain;

import eapli.base.exceptions.AlreadyDeactivatedException;
import org.junit.Test;
import static org.junit.Assert.*;


public class BoardTest {
    public static Board dummyBoard(){
        BoardBuilder boardBuilder = new BoardBuilder();
        return boardBuilder.withCellList(1, 2,3).withBoardTitle("DummyBoard").build();
    }
    @Test(expected = AlreadyDeactivatedException.class)
    public void ensureArchiveAnArchivedBoardFail() throws AlreadyDeactivatedException {
        Board board = dummyBoard();
        board.archiveBoard();
        board.archiveBoard();
    }

    @Test
    public void ensureCanArchiveActiveBoard() throws AlreadyDeactivatedException {
        Board board = dummyBoard();
        assertTrue(board.archiveBoard());
    }
}
