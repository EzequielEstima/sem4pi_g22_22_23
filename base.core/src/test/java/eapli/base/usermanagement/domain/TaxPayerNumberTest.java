package eapli.base.usermanagement.domain;

import static org.junit.Assert.*;
import org.junit.Test;
public class TaxPayerNumberTest {


    @Test(expected = IllegalArgumentException.class)
    public void ensureTaxPayerNumberIsValid() {
        TaxPayerNumber numb = new TaxPayerNumber(12345678);
    }

    @Test
    public void ensureTaxPayerNumberEquals() {
        TaxPayerNumber test = new TaxPayerNumber(123456789);
        TaxPayerNumber test2 = new TaxPayerNumber(123456789);
        TaxPayerNumber test3 = new TaxPayerNumber(111222333);

        assertTrue(test.equals(test2));
        assertFalse(test2.equals(test3));
    }

    @Test
    public void ensureTaxPayerNumberCompareTO() {
        TaxPayerNumber test = new TaxPayerNumber(111111111);
        TaxPayerNumber test2 = new TaxPayerNumber(222222222);
        TaxPayerNumber test3 = new TaxPayerNumber(333333333);

        assertEquals(test.compareTo(test2),-1);
        assertEquals(test3.compareTo(test2),1);
        assertEquals(test2.compareTo(test2),0);
    }
}