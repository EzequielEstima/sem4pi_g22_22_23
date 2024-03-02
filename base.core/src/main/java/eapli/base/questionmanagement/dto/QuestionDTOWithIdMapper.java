package eapli.base.questionmanagement.dto;

import eapli.base.questionmanagement.domain.Question;

public class QuestionDTOWithIdMapper {
    public static QuestionDTOWithId toDTO(Question question){
        QuestionWithIdDTOBuilder builder = new QuestionWithIdDTOBuilder();
        return builder.withQuestionIdentifier(question.returnQuestionIdentifier()).build();
    }
}
