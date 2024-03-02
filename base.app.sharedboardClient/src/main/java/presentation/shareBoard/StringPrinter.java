package presentation.shareBoard;

import eapli.framework.visitor.Visitor;

public class StringPrinter implements Visitor<String> {
    @Override
    public void visit(String visitee) {
        System.out.printf("%s",visitee);
    }
}
