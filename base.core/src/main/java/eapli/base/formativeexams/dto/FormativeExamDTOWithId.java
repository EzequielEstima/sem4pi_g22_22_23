package eapli.base.formativeexams.dto;

public class FormativeExamDTOWithId {

    public String formativeExamId;

    protected FormativeExamDTOWithId(String formativeExamId){
        this.formativeExamId = formativeExamId;
    }

    @Override
    public String toString() {
        return formativeExamId;
    }
}
