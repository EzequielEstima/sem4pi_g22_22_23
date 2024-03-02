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
import eapli.base.usermanagement.domain.builder.PersonBuilder;
import eapli.framework.infrastructure.authz.domain.model.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MeetingTest {

    public static SystemUser dummyUser(final String username, final Role... roles) {
        SystemUserBuilder userBuilder = new SystemUserBuilder(new NilPasswordPolicy(), new PlainTextEncoder());
        return userBuilder.with(username, "duMMy1", "dummy",
                "dummy", "a@b.ro").withRoles(roles).build();
    }

    private SystemUser getNewDummyUser() {
        return dummyUser("dummy", BaseRoles.MANAGER);
    }
    private Meeting dummyMeeting(){
        Person diamond = new PersonBuilder().withID(1)
                .withSystemUser(getNewDummyUser()).withfullName("Viper").build();
        List<Long> invitations = new ArrayList<>();
        invitations.add(1L);
        invitations.add(2L);
        java.util.Date date = new java.util.Date(1000, Calendar.NOVEMBER,9,10,10,10);
        MeetingFactory factory = new MeetingFactory();
        List<Person> peopleList = new ArrayList<>();
        peopleList.add(diamond);
        return factory.build(777, diamond, 1,peopleList ,invitations,1,date);
    }
    public Meeting getNewDummyMeeting(){
        return dummyMeeting();
    }

    @Test(expected = IllegalArgumentException.class)
    public void verifyMeetingOwnerWithNullValues() {
        new MeetingFactory().build(1, null,0, null,
                null,0 , null);
    }

    @Test
    public void verifySameAs_WithEqualId() {

        Person challenger = new PersonBuilder().withID(1)
                .withSystemUser(getNewDummyUser()).withfullName("Reyna").build();

        Person radiant = new PersonBuilder().withID(1)
                .withSystemUser(getNewDummyUser()).withfullName("Phoenix").build();

        MeetingOwner meetingOwner = new MeetingOwner(new MeetingOwnerIdentifier(1),challenger);
        MeetingOwner meetingOwner2 = new MeetingOwner(new MeetingOwnerIdentifier(1),radiant);

        InvitationFactory invitationFactory = new InvitationFactory();

        List<Invitation> invitationA = new ArrayList<>();
        invitationA.add(invitationFactory.build(1,challenger));
        List<Invitation> invitationB = new ArrayList<>();
        invitationB.add(invitationFactory.build(2,radiant));

        Meeting meeting = new Meeting(new MeetingIdentifier(100),
                new ScheduledDate(new Duration(10),
                        new Date(new java.util.Date())),meetingOwner ,invitationA);
        Meeting meeting2 = new Meeting(new MeetingIdentifier(100),
                new ScheduledDate(new Duration(25),
                        new Date(new java.util.Date())),meetingOwner2 ,invitationB);

        assertTrue(meeting.sameAs(meeting2));
    }

    @Test
    public void verifySameAs_WithDifferentId() {

        Person grandMaster = new PersonBuilder().withID(1)
                .withSystemUser(getNewDummyUser()).withfullName("Jett").build();

        Person inmortal = new PersonBuilder().withID(1)
                .withSystemUser(getNewDummyUser()).withfullName("Sage").build();

        MeetingOwner meetingOwner = new MeetingOwner(new MeetingOwnerIdentifier(1),grandMaster);
        MeetingOwner meetingOwner2 = new MeetingOwner(new MeetingOwnerIdentifier(1),inmortal);

        InvitationFactory invitationFactory = new InvitationFactory();

        List<Invitation> invitationA = new ArrayList<>();
        invitationA.add(invitationFactory.build(1,grandMaster));
        List<Invitation> invitationB = new ArrayList<>();
        invitationB.add(invitationFactory.build(2,inmortal));

        Meeting meeting = new Meeting(new MeetingIdentifier(777),
                new ScheduledDate(new Duration(10),
                        new Date(new java.util.Date())),meetingOwner ,invitationA);
        Meeting meeting2 = new Meeting(new MeetingIdentifier(666),
                new ScheduledDate(new Duration(25),
                        new Date(new java.util.Date())),meetingOwner2 ,invitationB);

        assertFalse(meeting.sameAs(meeting2));
    }

    @Test
    public void verifySameAs_WithEqualInstances() {
        Person master = new PersonBuilder().withID(1)
                .withSystemUser(getNewDummyUser()).withfullName("Sova").build();

        MeetingOwner meetingOwner = new MeetingOwner(new MeetingOwnerIdentifier(1),master);

        InvitationFactory invitationFactory = new InvitationFactory();

        List<Invitation> invitationA = new ArrayList<>();
        invitationA.add(invitationFactory.build(1,master));

        Meeting meeting = new Meeting(new MeetingIdentifier(777),
                new ScheduledDate(new Duration(10),
                        new Date(new java.util.Date())), meetingOwner ,invitationA);

        assertTrue(meeting.sameAs(meeting));
    }

    @Test
    public void verifySameAs_WithDifferentObjectTypes() {
        Person ascendant = new PersonBuilder().withID(1)
                .withSystemUser(getNewDummyUser()).withfullName("Gekko").build();

        MeetingOwner meetingOwner = new MeetingOwner(new MeetingOwnerIdentifier(1),ascendant);

        InvitationFactory invitationFactory = new InvitationFactory();

        List<Invitation> invitationA = new ArrayList<>();
        invitationA.add(invitationFactory.build(1,ascendant));

        Meeting meeting = new Meeting(new MeetingIdentifier(777),
                new ScheduledDate(new Duration(10), new Date(new java.util.Date())),meetingOwner ,invitationA);

        assertFalse(meeting.sameAs(ascendant));
    }

    @Test
    public void verifyIfIsTheMeetingDateTrue() {
        Person immortal = new PersonBuilder().withID(1)
                .withSystemUser(getNewDummyUser()).withfullName("Skye").build();

        MeetingOwner meetingOwner = new MeetingOwner(new MeetingOwnerIdentifier(1),immortal);

        InvitationFactory invitationFactory = new InvitationFactory();

        List<Invitation> invitationA = new ArrayList<>();
        invitationA.add(invitationFactory.build(1,immortal));

        java.util.Date date = new java.util.Date(1000, Calendar.NOVEMBER,9,10,10,10);

        Meeting meeting = new Meeting(new MeetingIdentifier(777),
                new ScheduledDate(new Duration(10), new Date(date)),meetingOwner ,invitationA);
        boolean b = meeting.verifyIfIsTheMeetingDate(date, 10);
        assertTrue(b);
    }

    @Test
    public void verifyIfIsTheMeetingDateFalse() {
        Person diamond = new PersonBuilder().withID(1)
                .withSystemUser(getNewDummyUser()).withfullName("Viper").build();

        MeetingOwner meetingOwner = new MeetingOwner(new MeetingOwnerIdentifier(1),diamond);

        InvitationFactory invitationFactory = new InvitationFactory();

        List<Invitation> invitationA = new ArrayList<>();
        invitationA.add(invitationFactory.build(1,diamond));

        java.util.Date date = new java.util.Date(1000, Calendar.NOVEMBER,9,10,10,10);

        Meeting meeting = new Meeting(new MeetingIdentifier(777),
                new ScheduledDate(new Duration(10), new Date(date)),meetingOwner ,invitationA);

        boolean b = meeting.verifyIfIsTheMeetingDate(
                new java.util.Date(1001, Calendar.NOVEMBER,9,10,10,10), 10);

        assertFalse(b);
    }

    @Test
    public void verifyIfWasCanceled(){
        Meeting meeting = getNewDummyMeeting();
        assertTrue(meeting.cancelMeeting());
    }
}