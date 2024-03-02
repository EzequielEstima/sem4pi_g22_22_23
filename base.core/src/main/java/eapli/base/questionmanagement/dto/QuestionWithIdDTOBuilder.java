package eapli.base.questionmanagement.dto;

public class QuestionWithIdDTOBuilder {
    private Long questionIdentifier;
    public QuestionWithIdDTOBuilder withQuestionIdentifier(Long questionId){
        this.questionIdentifier = questionId;
        return this;
    }

    public QuestionDTOWithId build(){
        return new QuestionDTOWithId(questionIdentifier);
    }
}
