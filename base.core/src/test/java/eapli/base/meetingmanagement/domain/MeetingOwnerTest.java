package eapli.base.meetingmanagement.domain;

import eapli.base.courseclasses.domain.Date;
import eapli.base.courseclasses.domain.Duration;
import eapli.base.courseclasses.domain.ScheduledDate;
import eapli.base.invitationmanagement.domain.Invitation;
import eapli.base.invitationmanagement.domain.InvitationFactory;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.base.usermanagement.domain.MeetingOwner;
import eapli.base.usermanagement.domain.MeetingOwnerIdentifier;
import eapli.base.usermanagement.domain.Person;
import eapli.base.usermanagement.domain.builder.MeetingOwnerFactory;
import eapli.base.usermanagement.domain.builder.PersonBuilder;
import eapli.framework.infrastructure.authz.domain.model.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MeetingOwnerTest {

    public static SystemUser dummyUser(final String username, final Role... roles) {
        SystemUserBuilder userBuilder = new SystemUserBuilder(new NilPasswordPolicy(), new PlainTextEncoder());
        return userBuilder.with(username, "duMMy1", "dummy", "dummy", "a@b.ro").withRoles(roles).build();
    }

    private SystemUser getNewDummyUser() {
        return dummyUser("dummy", BaseRoles.MANAGER);
    }

    @Test(expected = IllegalArgumentException.class)
    public void verifyMeetingWithNullValues() {
        new MeetingOwnerFactory().build(1, null, null);
    }

    @Test
    public void verifySameAs_WithEqualId() {

        Person platinum = new PersonBuilder().withID(1)
                .withSystemUser(getNewDummyUser()).withfullName("Brimstone").build();

        Person gold = new PersonBuilder().withID(1)
                .withSystemUser(getNewDummyUser()).withfullName("Breach").build();

        MeetingOwner meetingOwner = new MeetingOwner(new MeetingOwnerIdentifier(1),platinum);
        MeetingOwner meetingOwner2 = new MeetingOwner(new MeetingOwnerIdentifier(1),gold);

        assertFalse(meetingOwner.sameAs(meetingOwner2));//cause the person is different
    }


    @Test
    public void verifySameAs_WithEqualIdAndEqualPerson() {

        Person silver = new PersonBuilder().withID(1)
                .withSystemUser(getNewDummyUser()).withfullName("Yoru").build();

        MeetingOwner meetingOwner = new MeetingOwner(new MeetingOwnerIdentifier(1),silver);
        MeetingOwner meetingOwner2 = new MeetingOwner(new MeetingOwnerIdentifier(1),silver);

        assertTrue(meetingOwner.sameAs(meetingOwner2));
    }

    @Test
    public void verifySameAs_WithDifferentId() {

        Person bronze = new PersonBuilder().withID(1)
                .withSystemUser(getNewDummyUser()).withfullName("Neon").build();

        Person iron = new PersonBuilder().withID(1)
                .withSystemUser(getNewDummyUser()).withfullName("Astra").build();

        MeetingOwner meetingOwner = new MeetingOwner(new MeetingOwnerIdentifier(1),bronze);
        MeetingOwner meetingOwner2 = new MeetingOwner(new MeetingOwnerIdentifier(2),iron);

        assertFalse(meetingOwner.sameAs(meetingOwner2));//cause the id is different
    }

    @Test
    public void verifySameAs_WithEqualInstances() {
        Person jgDiff = new PersonBuilder().withID(1)
                .withSystemUser(getNewDummyUser()).withfullName("Warwick").build();

        MeetingOwner meetingOwner = new MeetingOwner(new MeetingOwnerIdentifier(1),jgDiff);

        assertTrue(meetingOwner.sameAs(meetingOwner));
    }

    @Test
    public void verifySameAs_WithDifferentObjectTypes() {
        Person supDiff = new PersonBuilder().withID(1)
                .withSystemUser(getNewDummyUser()).withfullName("Lux").build();

        MeetingOwner meetingOwner = new MeetingOwner(new MeetingOwnerIdentifier(1),supDiff);

        assertFalse(meetingOwner.sameAs(supDiff));
    }

    @Test
    public void verifyIfAddMeeting() {
        Person topDiff = new PersonBuilder().withID(1)
                .withSystemUser(getNewDummyUser()).withfullName("Lux").build();

        MeetingOwner meetingOwner = new MeetingOwner(new MeetingOwnerIdentifier(1),topDiff);

        InvitationFactory invitationFactory = new InvitationFactory();

        List<Invitation> invitationA = new ArrayList<>();
        invitationA.add(invitationFactory.build(1,topDiff));

        Meeting meeting = new Meeting(new MeetingIdentifier(100),
                new ScheduledDate(new Duration(10), new Date(new java.util.Date())),meetingOwner,invitationA);

        assertTrue(meeting.isMeetingOwner(meetingOwner));
    }
}