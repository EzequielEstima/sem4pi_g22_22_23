package eapli.base.boardparticipant.domain;

import eapli.base.board.domain.Board;
import eapli.base.board.domain.BoardBuilder;
import eapli.base.boardparticipantmanagement.domain.BoardParticipantFactory;
import eapli.base.exceptions.ParameterNullBlankException;
import org.junit.Test;

public class BoardParticipantTest {

    public static Board dummyBoard(){
        BoardBuilder boardBuilder = new BoardBuilder();
        return boardBuilder.withCellList(1, 2,3).withBoardTitle("DummyBoard1").build();
    }
    @Test(expected = ParameterNullBlankException.class)
    public void verifyBoardParticipantIdNull() throws ParameterNullBlankException {
        BoardParticipantFactory factory = new BoardParticipantFactory();
        factory.buildBoardParticipant(null, true, dummyBoard());
    }

    @Test(expected = ParameterNullBlankException.class)
    public void verifyBoardParticipantBoardNull() throws ParameterNullBlankException {
        BoardParticipantFactory factory = new BoardParticipantFactory();
        factory.buildBoardParticipant(null, true, dummyBoard());
    }
}
