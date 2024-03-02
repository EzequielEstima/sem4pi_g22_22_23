package eapli.base.questionmanagement.domain;

public class QuestionBuilder {
    private QuestionIdentifier question_id;
    private Structure structure;
    public QuestionBuilder withIdentifier(long question_id){
        this.question_id = new QuestionIdentifier(question_id);
        return this;
    }

    public QuestionBuilder withStructure(String structure){
        this.structure = new Structure(structure);
        VerifyQuestionService verifyQuestionService = new VerifyQuestionService();
        verifyQuestionService.verifyQuestion(structure);
        return this;
    }

    public Question build(){
        return new Question(question_id, structure);
    }
}
