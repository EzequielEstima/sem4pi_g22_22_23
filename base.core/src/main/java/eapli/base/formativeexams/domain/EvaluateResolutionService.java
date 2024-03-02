package eapli.base.formativeexams.domain;

import eapli.base.grammarutils.FormativeExamGrammarLexer;
import eapli.base.grammarutils.FormativeExamGrammarParser;
import eapli.base.grammarutils.FormativeExamResolutionVisitor;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class EvaluateResolutionService {

    public FormativeExamResolutionVisitor takeFormativeExam(String specification){
         FormativeExamGrammarLexer lexer = new FormativeExamGrammarLexer(CharStreams.fromString(specification));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        FormativeExamGrammarParser parser = new FormativeExamGrammarParser(tokens);
        ParseTree parseTree = parser.prog();
        FormativeExamResolutionVisitor visitor = new FormativeExamResolutionVisitor();
        visitor.visit(parseTree);
        return visitor;
    }

}
