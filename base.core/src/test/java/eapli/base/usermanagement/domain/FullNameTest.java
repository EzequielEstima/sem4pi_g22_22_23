package eapli.base.usermanagement.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class FullNameTest {

    @Test(expected = IllegalArgumentException.class)
    public void ensureFullNameCanNotBeEmpty() {
        FullName test =  new FullName("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureFullNameCanNotBeNull() {
        FullName test =  new FullName(null);
    }

    @Test
    public void ensureFullNameEquals() {
        FullName test =  new FullName("DUMMY DUMMY");
        FullName test2 =  new FullName("DUMMY DUMMY");
        FullName test3 =  new FullName("DUMMY");

        assertTrue(test.equals(test2));
        assertFalse(test2.equals(test3));
    }
}