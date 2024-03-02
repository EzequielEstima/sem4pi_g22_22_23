package eapli.base.usermanagement.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class ID_PersonTest {

    @Test(expected = IllegalArgumentException.class)
    public void ensureID_PersonIsValid() {
        ID_Person id = new ID_Person(0);
    }

    @Test
    public void ensureID_PersonEquals() {
        ID_Person id = new ID_Person(2);
        ID_Person id2 = new ID_Person(2);
        assertTrue(id.equals(id2));
    }

}