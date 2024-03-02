package eapli.base.usermanagement.domain.builder;

import eapli.base.usermanagement.domain.*;
import eapli.framework.domain.model.DomainFactory;

import java.util.Date;

public class TeacherBuilder implements DomainFactory<Teacher> {


    private Acronym acronym;

    private DateOfBirth dateOfBirth;

    private TaxPayerNumber taxPayerNumber;

    public TeacherBuilder with(String acronym,Date dateOfBirth,int taxPayerNumber){
        withAcronym(acronym);
        withDateOfBirth(dateOfBirth);
        withTaxPayerNumber(taxPayerNumber);

        return this;
    }

    public TeacherBuilder withAcronym(final String acronym) {
        this.acronym = new Acronym(acronym);
        return this;
    }

    public TeacherBuilder withDateOfBirth(final Date date) {
        this.dateOfBirth = new DateOfBirth(date);
        return this;
    }

    public TeacherBuilder withTaxPayerNumber(final int taxPayerNumber){
        this.taxPayerNumber = new TaxPayerNumber(taxPayerNumber);
        return this;
    }
    @Override
    public Teacher build() {
        // since the factory knows that all the parts are needed it could throw
        // an exception. however, we will leave that to the constructor
        return new Teacher(acronym,dateOfBirth,taxPayerNumber);
    }
}
