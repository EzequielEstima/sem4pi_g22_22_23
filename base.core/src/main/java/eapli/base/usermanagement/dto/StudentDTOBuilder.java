package eapli.base.usermanagement.dto;

import eapli.base.coursemanagement.dto.CourseDTOBuilder;
import eapli.base.coursemanagement.dto.CourseDTOWithIdTitle;
import eapli.base.coursemanagement.dto.CourseDTOWithIdTitleStatus;

import java.util.List;

public class StudentDTOBuilder {
    private String mechanographicNumber;
    private String dateOfBirth;
    private String taxPayerNumber;

    public StudentDTOBuilder withMechanographicNumber(final String mechanographicNumber){
        this.mechanographicNumber = mechanographicNumber;
        return this;
    }

    public StudentDTOBuilder withDateOfBirth(final String dateOfBirth){
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    public StudentDTOBuilder withTaxPayerNumber(final String taxPayerNumber){
        this.taxPayerNumber = taxPayerNumber;
        return this;
    }

    public StudentDTOWithMechNumber buildWithMechNumber(){
        return new StudentDTOWithMechNumber(this.mechanographicNumber);
    }

}
