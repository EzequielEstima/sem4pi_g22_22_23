package eapli.base.usermanagement.domain;

import eapli.base.usermanagement.domain.builder.StudentBuilder;

import eapli.framework.infrastructure.authz.domain.model.*;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class StudentTest {

    public static SystemUser dummyUser(final String username, final Role... roles) {
        SystemUserBuilder userBuilder = new SystemUserBuilder(new NilPasswordPolicy(), new PlainTextEncoder());
        return userBuilder.with(username, "duMMy1", "dummy", "dummy", "a@b.ro").withRoles(roles).build();
    }

    private SystemUser getNewDummyUser() {
        return dummyUser("dummy", BaseRoles.MANAGER);
    }
    @Test
    public void ensureStudentEqualsPassesForTheSameMecanographicNumber() {

        Student aStudent = new StudentBuilder().withMecanographicNumber(1,"2000")
                .withDateOfBirth(new Date(100,10,2)).withTaxPayerNumber(111111111).build();

        Student anotherStudent = new StudentBuilder().withMecanographicNumber(1,"2000")
                .withDateOfBirth(new Date(100,10,2)).withTaxPayerNumber(111111111).build();

        boolean expected = aStudent.equals(anotherStudent);

        assertTrue(expected);
    }

    @Test
    public void ensureStudentEqualsFailsForDifferenteMecanographicNumber() {

        Student aStudent = new StudentBuilder().withMecanographicNumber(2,"2000")
                .withDateOfBirth(new Date(100,10,2)).withTaxPayerNumber(111111111).build();

        Student anotherStudent = new StudentBuilder().withMecanographicNumber(1,"2000")
                .withDateOfBirth(new Date(100,10,2)).withTaxPayerNumber(111111111).build();

        boolean expected = aStudent.equals(anotherStudent);


        assertFalse(expected);
    }

    @Test
    public void ensureStudentrEqualsAreTheSameForTheSameInstance()  {
        Student aStudent = new Student();

        boolean expected = aStudent.equals(aStudent);

        assertTrue(expected);
    }

    @Test
    public void ensureStudentEqualsFailsForDifferenteObjectTypes()  {
        Student aStudent = new Student();

        boolean expected = aStudent.equals(getNewDummyUser());

        assertFalse(expected);
    }

    @Test
    public void ensureStudentIsTheSameAsItsInstance()  {
        Student aStudent = new StudentBuilder().withMecanographicNumber(2,"2000")
                .withDateOfBirth(new Date(100,10,2)).withTaxPayerNumber(111111111).build();



        boolean expected = aStudent.sameAs(aStudent);

        assertTrue(expected);
    }

    @Test
    public void ensureTwoStudentWithDifferentMecanographicNumberAreNotTheSame()  {

        Student aStudent = new StudentBuilder().withMecanographicNumber(2,"2000")
                .withDateOfBirth(new Date(100,10,2)).withTaxPayerNumber(111111111).build();

        Student anotherStudent = new StudentBuilder().withMecanographicNumber(1,"2000")
                .withDateOfBirth(new Date(100,10,2)).withTaxPayerNumber(111111111).build();


        boolean expected = aStudent.sameAs(anotherStudent);

        assertFalse(expected);
    }
    @Test
    public void ensureCompareYearMecanographicNumberPassesForTheSameYear() {

        Student aStudent = new StudentBuilder().withMecanographicNumber(2,"2000")
                .withDateOfBirth(new Date(100,10,2)).withTaxPayerNumber(111111111).build();

        boolean expected = aStudent.compareYearMecanographicNumber("2000");

        assertTrue(expected);
    }

    @Test
    public void ensureCompareYearMecanographicNumberFailsForDifferentYears() {

        Student aStudent = new StudentBuilder().withMecanographicNumber(2,"2000")
                .withDateOfBirth(new Date(100,10,2)).withTaxPayerNumber(111111111).build();

        boolean expected = aStudent.compareYearMecanographicNumber("2001");

        assertFalse(expected);
    }
}