package eapli.base.invitation.management;

import eapli.base.invitationmanagement.domain.Invitation;
import eapli.base.invitationmanagement.domain.InvitationFactory;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.base.usermanagement.domain.Person;
import eapli.base.usermanagement.domain.builder.PersonBuilder;
import eapli.framework.infrastructure.authz.domain.model.*;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InvitationTest {

    public static SystemUser dummyUser(final String username, final Role... roles) {
        SystemUserBuilder userBuilder = new SystemUserBuilder(new NilPasswordPolicy(), new PlainTextEncoder());
        return userBuilder.with(username, "duMMy1", "dummy", "dummy", "a@b.ro").withRoles(roles).build();
    }

    private SystemUser getNewDummyUser() {
        return dummyUser("dummy", BaseRoles.MANAGER);
    }

    @Test(expected = IllegalArgumentException.class)
    public void verifyInvitationWithNullValues() {
        InvitationFactory invitationFactory = new InvitationFactory();
        invitationFactory.build(0, null);
    }

    @Test
    public void verifySameAs_WithEqualId() {

        Person botDiff = new PersonBuilder().withID(1)
                .withSystemUser(getNewDummyUser()).withfullName("Caitlyn").build();

        Person kingOfAces = new PersonBuilder().withID(1)
                .withSystemUser(getNewDummyUser()).withfullName("Aurelion").build();

        InvitationFactory invitationFactory = new InvitationFactory();

        Invitation invitationA = invitationFactory.build(1, botDiff);
        Invitation invitationB = invitationFactory.build(1, kingOfAces);

        assertFalse(invitationA.sameAs(invitationB)); //cause the invitation is the same but the person is different
    }

    @Test
    public void verifySameAs_WithEqualIdAndEqualPerson() {

        Person midDiff = new PersonBuilder().withID(1)
                .withSystemUser(getNewDummyUser()).withfullName("Sylas").build();

        InvitationFactory invitationFactory = new InvitationFactory();

        Invitation invitationA = invitationFactory.build(1, midDiff);
        Invitation invitationB = invitationFactory.build(1, midDiff);

        invitationB.updateResponseStatus("REJECTED");

        assertFalse(invitationA.sameAs(invitationB)); //cause the invitation and the person is the same but the response is different
    }

    @Test
    public void verifySameAs_WithEqualIdEqualPersonAndEqualResponse() {


        Person mestreDaCulinaria = new PersonBuilder().withID(1)
                .withSystemUser(getNewDummyUser()).withfullName("Blitzcrank").build();

        InvitationFactory invitationFactory = new InvitationFactory();

        Invitation invitationA = invitationFactory.build(1, mestreDaCulinaria);
        Invitation invitationB = invitationFactory.build(1, mestreDaCulinaria);

        assertTrue(invitationA.sameAs(invitationB));
    }

    @Test
    public void verifySameAs_WithEqualInstances() {

        Person pentaKiller = new PersonBuilder().withID(1)
                .withSystemUser(getNewDummyUser()).withfullName("Broly").build();

        InvitationFactory invitationFactory = new InvitationFactory();

        Invitation invitationA = invitationFactory.build(1, pentaKiller);

        assertTrue(invitationA.sameAs(invitationA));
    }

    @Test
    public void verifySameAs_WithDifferentObjectTypes() {

        Person man = new PersonBuilder().withID(1)
                .withSystemUser(getNewDummyUser()).withfullName("man").build();

        InvitationFactory invitationFactory = new InvitationFactory();

        Invitation invitationA = invitationFactory.build(1,man);

        assertFalse(invitationA.sameAs(man));
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureCannotUpdateAcceptedInvitation(){
        Person person1 = new PersonBuilder().withID(1)
                .withSystemUser(getNewDummyUser()).withfullName("Broly").build();

        InvitationFactory invitationFactory = new InvitationFactory();

        Invitation instance = invitationFactory.build(1, person1);

        instance.updateResponseStatus("ACCEPTED");

        instance.updateResponseStatus("ACCEPTED");

    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureCannotUpdateRejectedInvitation(){
        Person person1 = new PersonBuilder().withID(1)
                .withSystemUser(getNewDummyUser()).withfullName("Broly").build();

        InvitationFactory invitationFactory = new InvitationFactory();

        Invitation instance = invitationFactory.build(1, person1);

        instance.updateResponseStatus("REJECTED");

        instance.updateResponseStatus("REJECTED");

    }

    @Test
    public void ensureInvitationIsRejected(){
        Person person1 = new PersonBuilder().withID(1)
                .withSystemUser(getNewDummyUser()).withfullName("Broly").build();

        InvitationFactory invitationFactory = new InvitationFactory();

        Invitation instance = invitationFactory.build(1, person1);

        instance.updateResponseStatus("REJECTED");

        String expected = "Rejected";
        assertEquals(expected,instance.returnResponseStatusString());
    }

    @Test
    public void ensureInvitationIsAccepted(){
        Person person1 = new PersonBuilder().withID(1)
                .withSystemUser(getNewDummyUser()).withfullName("Broly").build();

        InvitationFactory invitationFactory = new InvitationFactory();

        Invitation instance = invitationFactory.build(1, person1);

        instance.updateResponseStatus("ACCEPTED");

        String expected = "Accepted";
        assertEquals(expected,instance.returnResponseStatusString());
    }
}