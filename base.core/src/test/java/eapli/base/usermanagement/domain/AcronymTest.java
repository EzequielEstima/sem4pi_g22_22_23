package eapli.base.usermanagement.domain;


import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class AcronymTest {

    @Test(expected = IllegalArgumentException.class)
    public void ensureAcronymCanNotBeCreatedWith4Letters() {
        Acronym test =  new Acronym("ABCD");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureAcronymCanNotBeCreatedWithLowerCaseNumber() {
        Acronym test =  new Acronym("aBC");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureAcronymCanNotBeCreatedWithNullValues(){
        Acronym test =  new Acronym(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureAcronymCanNotBeCreatedWithEmptyString(){
        Acronym test =  new Acronym("");
    }

    @Test
    public void ensureAcronymEqualsTrue(){
        Acronym test =  new Acronym("ABC");
        Acronym expected = new Acronym("ABC");
        assertTrue(test.equals(expected));
    }

    @Test
    public void ensureAcronymEqualsFalse(){
        Acronym test =  new Acronym("ABC");
        Acronym expected = new Acronym("ACB");
        assertFalse(test.equals(expected));
    }
}