package eapli.base.invitation.management;

import eapli.base.invitationmanagement.domain.InvitationIdentifier;
import org.junit.Test;

import static org.junit.Assert.*;

public class InvitationIdentifierTest {

    @Test(expected = IllegalArgumentException.class)
    public void ensureIdCannotBeZero() {
        new InvitationIdentifier(0L);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureIdCannotBeLessThanZero() {
        new InvitationIdentifier(-1L);
    }

    @Test
    public void ensureIdAreEquals() {
        InvitationIdentifier test1 = new InvitationIdentifier(1L);
        InvitationIdentifier test2 = new InvitationIdentifier(2L);
        assertEquals(test1, test1);
        assertNotEquals(test1, test2);
    }

}