package eapli.base.questionmanagement.domain;

import eapli.framework.domain.model.ValueObject;

import java.util.Objects;

public class QuestionIdentifier implements ValueObject, Comparable<QuestionIdentifier> {
    private Long question_Id;

    public QuestionIdentifier(Long question_Id) {
        if(question_Id < 1){
            throw new IllegalArgumentException("Question Id cannot be lower than 1");
        }
        this.question_Id = question_Id;
    }

    public QuestionIdentifier(){}

    @Override
    public int compareTo(QuestionIdentifier o) {
        return Long.compare(this.question_Id, o.question_Id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof QuestionIdentifier)) return false;
        QuestionIdentifier that = (QuestionIdentifier) o;
        return Objects.equals(question_Id, that.question_Id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(question_Id);
    }

    public long returnQuestionId() {
        return question_Id;
    }
}
