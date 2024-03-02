package eapli.base.usermanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;
@Embeddable
public class TaxPayerNumber implements ValueObject, Comparable<TaxPayerNumber>{

    @Column(nullable = true)
    private int taxPayerNumber;

    public TaxPayerNumber(int taxPayerNumber) {
        if (taxPayerNumber > 999999999 || taxPayerNumber < 100000000 ) {
            throw new IllegalArgumentException(
                    "Tax Payer number should have 9 digits");
        }
        this.taxPayerNumber = taxPayerNumber;
    }

    protected TaxPayerNumber() {
        // for ORM
    }

    public static TaxPayerNumber valueOf(final int taxPayerNumber) {
        return new TaxPayerNumber(taxPayerNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaxPayerNumber that = (TaxPayerNumber) o;
        return taxPayerNumber == that.taxPayerNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(taxPayerNumber);
    }

    @Override
    public String toString() {
        return "TaxPayerNumber{" +
                "number=" + taxPayerNumber +
                '}';
    }


    @Override
    public int compareTo(TaxPayerNumber o) {
        if (taxPayerNumber > o.taxPayerNumber){
            return 1;
        } else if (taxPayerNumber < o.taxPayerNumber) {
            return -1;
        }else{
            return 0;
        }
    }
}
