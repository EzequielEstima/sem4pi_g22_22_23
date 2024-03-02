package eapli.base.exams.domain;

import eapli.base.grammarutils.ExamGrammarLexer;
import eapli.base.grammarutils.ExamGrammarParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class VerifyExamSpecificationService {

    public boolean verifyExamSpecification(String questionString){
        ExamGrammarLexer lexer;
        lexer = new ExamGrammarLexer(CharStreams.fromString(questionString));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ExamGrammarParser parser = new ExamGrammarParser(tokens);
        ParseTree parseTree = parser.prog();
        if(parser.getNumberOfSyntaxErrors() == 0){
            return true;
        }else{
            throw new IllegalArgumentException("The specification of exam is incorrect");
        }
    }
}
