package eapli.base.usermanagement.domain;

import eapli.base.usermanagement.domain.builder.TeacherBuilder;
import eapli.framework.infrastructure.authz.domain.model.*;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class TeacherTest {

    public static SystemUser dummyUser(final String username, final Role... roles) {
        SystemUserBuilder userBuilder = new SystemUserBuilder(new NilPasswordPolicy(), new PlainTextEncoder());
        return userBuilder.with(username, "duMMy1", "dummy", "dummy", "a@b.ro").withRoles(roles).build();
    }

    private SystemUser getNewDummyUser() {
        return dummyUser("dummy", BaseRoles.MANAGER);
    }
    @Test
    public void ensureTeacherEqualsPassesForTheSameAcronym() {

        Teacher aTeacher = new TeacherBuilder().withAcronym("BCC")
                .withDateOfBirth(new Date(100,10,2)).withTaxPayerNumber(111111111).build();

        Teacher anotherTeacher = new TeacherBuilder().withAcronym("BCC")
                .withDateOfBirth(new Date(100,10,2)).withTaxPayerNumber(111111111).build();

        boolean expected = aTeacher.equals(anotherTeacher);

        assertTrue(expected);
    }

    @Test
    public void ensureTeacherEqualsFailsForDifferenteAcronym(){

        Teacher aTeacher = new TeacherBuilder().withAcronym("BCC")
                .withDateOfBirth(new Date(100,10,2)).withTaxPayerNumber(111111111).build();

        Teacher anotherTeacher = new TeacherBuilder().withAcronym("CLM")
                .withDateOfBirth(new Date(100,10,2)).withTaxPayerNumber(111111111).build();

        boolean expected = aTeacher.equals(anotherTeacher);


        assertFalse(expected);
    }

    @Test
    public void ensureTeacherEqualsAreTheSameForTheSameInstance() {
        Teacher aTeacher = new Teacher();

        boolean expected = aTeacher.equals(aTeacher);

        assertTrue(expected);
    }

    @Test
    public void ensureTeacherEqualsFailsForDifferenteObjectTypes() {
        Teacher aTeacher = new Teacher();

        boolean expected = aTeacher.equals(getNewDummyUser());

        assertFalse(expected);
    }

    @Test
    public void ensureTeacherIsTheSameAsItsInstance() {
        Teacher aTeacher = new TeacherBuilder().withAcronym("BCC")
                .withDateOfBirth(new Date(100,10,2)).withTaxPayerNumber(111111111).build();

        boolean expected = aTeacher.sameAs(aTeacher);

        assertTrue(expected);
    }

    @Test
    public void ensureTwoTeacherWithDifferentAcronymAreNotTheSame() {

        Teacher aTeacher = new TeacherBuilder().withAcronym("BCC")
                .withDateOfBirth(new Date(100,10,2)).withTaxPayerNumber(111111111).build();

        Teacher anotherTeacher = new TeacherBuilder().withAcronym("CLM")
                .withDateOfBirth(new Date(100,10,2)).withTaxPayerNumber(111111111).build();

        boolean expected = aTeacher.sameAs(anotherTeacher);

        assertFalse(expected);
    }

}