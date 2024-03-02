package eapli.base.meetingmanagement.domain;

import eapli.base.usermanagement.domain.MeetingOwnerIdentifier;
import org.junit.Test;

import static org.junit.Assert.*;

public class MeetingOwnerIdentifierTest {
    @Test(expected = IllegalArgumentException.class)
    public void ensureIdCannotBeZero() {
        new MeetingOwnerIdentifier(0L);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureIdCannotBeLessThanZero() {
        new MeetingOwnerIdentifier(-1L);
    }

    @Test
    public void ensureClassIDEquals() {
        MeetingOwnerIdentifier test1 = new MeetingOwnerIdentifier(1L);
        MeetingOwnerIdentifier test2 = new MeetingOwnerIdentifier(2L);
        assertEquals(test1, test1);
        assertNotEquals(test1, test2);
    }
}