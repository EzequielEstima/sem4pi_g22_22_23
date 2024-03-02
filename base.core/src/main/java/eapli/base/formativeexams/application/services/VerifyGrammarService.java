package eapli.base.formativeexams.application.services;

import eapli.base.grammarutils.FormativeExamGrammarLexer;
import eapli.base.grammarutils.FormativeExamGrammarParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class VerifyGrammarService {
    public boolean verifyGrammar(String questions){
        FormativeExamGrammarLexer lexer;
        lexer = new FormativeExamGrammarLexer(CharStreams.fromString(questions));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        FormativeExamGrammarParser parser = new FormativeExamGrammarParser(tokens);
        ParseTree parseTree = parser.prog();
        if(parser.getNumberOfSyntaxErrors() == 0){
            return true;
        }else{
            throw new IllegalArgumentException("The question you have submitted doesn't follow any type of question.");
        }
    }

}
