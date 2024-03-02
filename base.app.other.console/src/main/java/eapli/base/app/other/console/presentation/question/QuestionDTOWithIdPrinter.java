package eapli.base.app.other.console.presentation.question;

import eapli.base.questionmanagement.dto.QuestionDTOWithId;
import eapli.framework.visitor.Visitor;

public class QuestionDTOWithIdPrinter implements Visitor<QuestionDTOWithId> {
    @Override
    public void visit(QuestionDTOWithId visitee) {
        System.out.printf("%s\n",visitee.questionIdentifier);
    }
}
