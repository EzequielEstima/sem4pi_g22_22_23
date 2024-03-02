package eapli.base.formativeexams.dto;

public class FormativeExamDTOWithBuilder {

    private String formativeExamId;

    public FormativeExamDTOWithBuilder withFormativeExamId(String string){
        this.formativeExamId = formativeExamId;
        return this;
    }

    public FormativeExamDTOWithId build(){
        return new FormativeExamDTOWithId(this.formativeExamId);
    }
}
