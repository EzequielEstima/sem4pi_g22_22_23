package eapli.base.questionmanagement.domain;

import eapli.base.coursemanagement.domain.Course;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Question implements AggregateRoot<QuestionIdentifier> {
    @EmbeddedId
    private QuestionIdentifier questionId;
    private Structure structure;

    protected Question(QuestionIdentifier question_Id, Structure structure){
        this.questionId = question_Id;
        this.structure = structure;
    }

    protected Question(){}
    @Override
    public boolean sameAs(Object other) {
        if (!(other instanceof Question)) {
            return false;
        }
        final Question that = (Question) other;

        return questionId.equals(that.questionId) && structure.equals(that.structure);
    }

    @Override
    public QuestionIdentifier identity() {
        return questionId;
    }

    public long returnQuestionIdentifier(){
        return questionId.returnQuestionId();
    }
    public void changeQuestion(Structure structure){
        this.structure = structure;
    }
    public String returnStructureToString(){
        return structure.toString();
    }
}
