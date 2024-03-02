package eapli.base.questionmanagement.domain;

import eapli.base.grammarutils.QuestionGrammarLexer;
import eapli.base.grammarutils.QuestionGrammarParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class VerifyQuestionService {

    public boolean verifyQuestion(String questionString){
        QuestionGrammarLexer lexer;
        lexer = new QuestionGrammarLexer(CharStreams.fromString(questionString));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        QuestionGrammarParser parser = new QuestionGrammarParser(tokens);
        ParseTree parseTree = parser.prog();
        if(parser.getNumberOfSyntaxErrors() == 0){
            return true;
        }else{
            throw new IllegalArgumentException("The question you have submitted doesn't follow any type of question.");
        }
    }
}
