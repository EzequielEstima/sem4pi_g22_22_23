package eapli.base.app.common.console.presentation.meeting;

import eapli.framework.visitor.Visitor;

public class AcceptRejectOptionPrinter implements Visitor<String> {
    @Override
    public void visit(String visitee) {
        System.out.print(visitee);
    }
}
