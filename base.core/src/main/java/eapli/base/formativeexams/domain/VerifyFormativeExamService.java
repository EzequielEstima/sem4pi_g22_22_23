package eapli.base.formativeexams.domain;

import eapli.base.grammarutils.ExamGrammarLexer;
import eapli.base.grammarutils.ExamGrammarParser;
import eapli.base.grammarutils.FormativeExamGrammarLexer;
import eapli.base.grammarutils.FormativeExamGrammarParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class VerifyFormativeExamService {

    public boolean verifyFormativeExamSpecification(String specification){

        FormativeExamGrammarLexer lexer = new FormativeExamGrammarLexer(CharStreams.fromString(specification));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        FormativeExamGrammarParser parser = new FormativeExamGrammarParser(tokens);
        ParseTree parseTree = parser.prog();

        if(parser.getNumberOfSyntaxErrors() == 0){
            return true;
        }else{
            throw new IllegalArgumentException("The specification of the formative exam is incorrect");
        }

    }

}
