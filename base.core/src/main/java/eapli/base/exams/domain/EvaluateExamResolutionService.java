package eapli.base.exams.domain;

import eapli.base.grammarutils.ExamGrammarLexer;
import eapli.base.grammarutils.ExamGrammarParser;
import eapli.base.grammarutils.ExamResolutionVisitor;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class EvaluateExamResolutionService {

    public ExamResolutionVisitor takeExam(String resolution){
        ExamGrammarLexer lexer = new ExamGrammarLexer(CharStreams.fromString(resolution));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ExamGrammarParser parser = new ExamGrammarParser(tokens);
        ExamResolutionVisitor visitor = new ExamResolutionVisitor();
        ParseTree parseTree = parser.prog();
        visitor.visit(parseTree);
        return visitor;
    }
}
