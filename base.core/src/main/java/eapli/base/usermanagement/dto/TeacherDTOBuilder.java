package eapli.base.usermanagement.dto;

public class TeacherDTOBuilder {

    private String acronym;

    private String date;

    private String taxPayerNumber;

    public TeacherDTOBuilder withAcronym(String acronym){
        this.acronym = acronym;
        return this;
    }

    public TeacherDTOBuilder withDateOfBirth(String date){
        this.date = date;
        return this;
    }

    public TeacherDTOBuilder withTaxPayerNumber(String taxPayerNumber){
        this.taxPayerNumber = taxPayerNumber;
        return this;
    }

    public TeacherDTOWithAcronym buildWithAcronym(){
        return new TeacherDTOWithAcronym(this.acronym);
    }
}
