package eapli.base.usermanagement.domain;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class DateOfBirthTest {

    @Test(expected = IllegalArgumentException.class)
        public void ensureDateOfBirthCanNotBeInTheFuture() {
        DateOfBirth test =  new DateOfBirth(new Date(1000,10,2));
    }

    @Test
    public void ensureDateOfBirthEquals() {
        DateOfBirth test =  new DateOfBirth(new Date(100,10,2));
        DateOfBirth test2 =  new DateOfBirth(new Date(100,10,2));
        DateOfBirth test3 =  new DateOfBirth(new Date(101,10,2));

        assertTrue(test.equals(test2));
        assertFalse(test.equals(test3));
    }

}