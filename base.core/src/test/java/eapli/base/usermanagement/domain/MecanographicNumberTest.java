package eapli.base.usermanagement.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class MecanographicNumberTest {

    @Test(expected = IllegalArgumentException.class)
    public void ensureMecanographicNumberCanNotBeCreatedWith10Digits() {
        MecanographicNumber test =  new MecanographicNumber("2222000011");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureMecanographicNumberCanNotBeCreatedWith8Digits() {
        MecanographicNumber test =  new MecanographicNumber("22220008");
    }

    @Test
    public void ensureMecanographicNumberEqualsTrue() {
        MecanographicNumber test =  new MecanographicNumber("202300001");
        MecanographicNumber expected = new MecanographicNumber("202300001");

        assertTrue(test.equals(expected));
    }

    @Test
    public void ensureMecanographicNumberCompareYear() {
        MecanographicNumber test =  new MecanographicNumber(1,"2023");

        assertTrue(test.compareYear("2023"));
    }
    @Test
    public void ensureMecanographicNumberCanBeCreatedWithYearAndNumber() {
        MecanographicNumber test =  new MecanographicNumber(1,"2023");
        MecanographicNumber expected = new MecanographicNumber("202300001");

        assertTrue(test.equals(expected));
    }
}