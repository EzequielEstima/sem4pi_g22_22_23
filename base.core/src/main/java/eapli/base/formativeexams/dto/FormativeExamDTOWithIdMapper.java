package eapli.base.formativeexams.dto;

import eapli.base.formativeexams.domain.FormativeExam;

public class FormativeExamDTOWithIdMapper {

    public FormativeExamDTOWithId toDto(FormativeExam formativeExam){
        FormativeExamDTOWithBuilder formativeExamDTOWithBuilder = new FormativeExamDTOWithBuilder();
        return formativeExamDTOWithBuilder.withFormativeExamId(formativeExam.returnFormativeExamId())
                .build();
    }
}
