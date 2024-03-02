package eapli.base.usermanagement.domain;


import com.sun.jdi.request.DuplicateRequestException;
import eapli.base.board.domain.Board;
import eapli.base.board.domain.BoardBuilder;
import eapli.base.boardparticipantmanagement.domain.BoardParticipant;
import eapli.base.boardparticipantmanagement.domain.BoardParticipantFactory;
import eapli.base.exceptions.DuplicateCreationException;
import eapli.base.exceptions.ParameterNullBlankException;
import eapli.base.usermanagement.domain.builder.PersonBuilder;
import eapli.framework.infrastructure.authz.domain.model.*;
import org.junit.Test;



import static org.junit.Assert.*;

public class PersonTest {

    public static SystemUser dummyUser(final String username, final Role... roles) {
        SystemUserBuilder userBuilder = new SystemUserBuilder(new NilPasswordPolicy(), new PlainTextEncoder());
        return userBuilder.with(username, "duMMy1", "dummy", "dummy", "a@b.ro").withRoles(roles).build();
    }
    public static Board dummyBoard1(){
        BoardBuilder boardBuilder = new BoardBuilder();
        return boardBuilder.withCellList(1, 2,3).withBoardTitle("DummyBoard1").build();
    }

    public static Board dummyBoard2(){
        BoardBuilder boardBuilder = new BoardBuilder();
        return boardBuilder.withCellList(1, 2,3).withBoardTitle("DummyBoard2").build();
    }


    public static Person dummyPerson(){
        return new PersonBuilder().withID(1).withSystemUser(getNewDummyUser()).withfullName("Dummy Person").build();
    }

    private static SystemUser getNewDummyUser() {
        return dummyUser("dummy", BaseRoles.MANAGER);
    }
    @Test
    public void ensurePersonEqualsPassesForTheSameID() {

        Person aPerson = new PersonBuilder().withID(1)
                .withSystemUser(getNewDummyUser()).withfullName("Joao Miguel").build();

        Person anotherPerson = new PersonBuilder().withID(1)
                .withSystemUser(getNewDummyUser()).withfullName("Joao Miguel").build();

        boolean expected = aPerson.equals(anotherPerson);

        assertTrue(expected);
    }

    @Test
    public void ensurePersonEqualsFailsForDifferenteID()  {

        Person aPerson = new PersonBuilder().withID(1)
                .withSystemUser(getNewDummyUser()).withfullName("Joao Miguel").build();

        Person anotherPerson = new PersonBuilder().withID(2)
                .withSystemUser(getNewDummyUser()).withfullName("Joao Miguel").build();

        boolean expected = aPerson.equals(anotherPerson);


        assertFalse(expected);
    }

    @Test
    public void ensurePersonEqualsAreTheSameForTheSameInstance() {
        Person aPerson = new Person();

        boolean expected = aPerson.equals(aPerson);

        assertTrue(expected);
    }

    @Test
    public void ensurePersonEqualsFailsForDifferenteObjectTypes(){
        Person aPerson = new Person();

        boolean expected = aPerson.equals(getNewDummyUser());

        assertFalse(expected);
    }

    @Test
    public void ensurePersonIsTheSameAsItsInstance() {
        Person aPerson = new PersonBuilder().withID(1)
                .withSystemUser(getNewDummyUser()).withfullName("Joao Miguel").build();

        boolean expected = aPerson.sameAs(aPerson);

        assertTrue(expected);
    }

    @Test
    public void ensureTwoPersonWithDifferentIDAreNotTheSame()  {

        Person aPerson = new PersonBuilder().withID(1)
                .withSystemUser(getNewDummyUser()).withfullName("Joao Miguel").build();

        Person anotherPerson = new PersonBuilder().withID(2)
                .withSystemUser(getNewDummyUser()).withfullName("Joao Miguel").build();

        boolean expected = aPerson.sameAs(anotherPerson);

        assertFalse(expected);
    }

    @Test(expected = DuplicateCreationException.class)
    public void ensureAddingTheSamePersonTwiceInBoardDoesntHappen() throws ParameterNullBlankException, DuplicateCreationException {
        Person person = dummyPerson();
        Board board = dummyBoard1();
        BoardParticipant boardParticipant1 = new BoardParticipantFactory().buildBoardParticipant(1L,true, board);
        BoardParticipant boardParticipant2 = new BoardParticipantFactory().buildBoardParticipant(2L,true, board);

        assertTrue(person.addBoardParticipant(boardParticipant1));
        person.addBoardParticipant(boardParticipant2);
    }

    @Test
    public void ensureAddingTheSamePersonInDifferentBoardsSucceeds() throws ParameterNullBlankException, DuplicateCreationException {
        Person person = dummyPerson();
        Board board1 = dummyBoard1();
        Board board2 = dummyBoard2();
        BoardParticipant boardParticipant1 = new BoardParticipantFactory().buildBoardParticipant(1L,true, board1);
        BoardParticipant boardParticipant2 = new BoardParticipantFactory().buildBoardParticipant(2L,true, board2);

        assertTrue(person.addBoardParticipant(boardParticipant1));
        assertTrue(person.addBoardParticipant(boardParticipant2));
    }
}