package eapli.base.usermanagement.domain.builder;

import eapli.base.usermanagement.domain.*;
import eapli.framework.domain.model.DomainFactory;

import java.util.Date;

public class StudentBuilder implements DomainFactory<Student> {

    private MecanographicNumber mecanographicNumber;

    private DateOfBirth dateOfBirth;

    private TaxPayerNumber taxPayerNumber;

    public StudentBuilder with(Date dateOfBirth, int taxPayerNumber) {
        withDateOfBirth(dateOfBirth);
        withTaxPayerNumber(taxPayerNumber);

        return this;
    }


    public StudentBuilder withMecanographicNumber(final int number,final String year) {
        this.mecanographicNumber = new MecanographicNumber(number,year);
        return this;
    }

    public StudentBuilder withDateOfBirth(final Date date) {
        this.dateOfBirth = new DateOfBirth(date);
        return this;
    }

    public StudentBuilder withTaxPayerNumber(final int taxPayerNumber) {
        this.taxPayerNumber = new TaxPayerNumber(taxPayerNumber);
        return this;
    }

    @Override
    public Student build() {
        // since the factory knows that all the parts are needed it could throw
        // an exception. however, we will leave that to the constructor
        return new Student(mecanographicNumber, dateOfBirth, taxPayerNumber);
    }

}