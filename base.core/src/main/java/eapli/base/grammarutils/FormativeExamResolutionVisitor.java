package eapli.base.grammarutils;

import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FormativeExamResolutionVisitor extends FormativeExamGrammarBaseVisitor<String>{

    private Double grade;
    private Integer questionNumber;
    private List<String> feedback = new ArrayList<>();

    public FormativeExamResolutionVisitor(){
        this.grade = 0.0;
        this.questionNumber = 0;
    }

    @Override
    public String visitMatching_type_question(FormativeExamGrammarParser.Matching_type_questionContext ctx) {
        questionNumber++;
        int points = Integer.parseInt(ctx.points().INT().getText());

        List<String> solutions = new ArrayList<>();
        List<FormativeExamGrammarParser.PhraseContext> solutionPhrases = ctx.matching_type_solution().phrase();
        for (int i = 0; i < solutionPhrases.size(); i = i+2){

            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(solutionPhrases.get(i).getText());
            stringBuilder.append("-");
            stringBuilder.append(solutionPhrases.get(i+1).getText());

            solutions.add(stringBuilder.toString());
        }

        List<String> answers = new ArrayList<>();
        try {
            List<FormativeExamGrammarParser.PhraseContext> answerPhrases = ctx.matching_type_answer().phrase();
            for (int i = 0; i < answerPhrases.size(); i = i+2) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(answerPhrases.get(i).getText());
                stringBuilder.append("-");
                stringBuilder.append(answerPhrases.get(i+1).getText());

                answers.add(stringBuilder.toString());
            }
        } catch (Exception ignored) {

        }

        double pointsByAnswer = (double) points / solutions.size();

        for (int i = 0; i < Integer.min(answers.size(), solutions.size()); i++){
            if(solutions.contains(answers.get(i))){
                this.grade += pointsByAnswer;
            }
        }

        visitFeedback(ctx.feedback());

        return null;
    }

    @Override
    public String visitSelect_missing_words(FormativeExamGrammarParser.Select_missing_wordsContext ctx) {
        questionNumber++;
        int points = Integer.parseInt(ctx.points().INT().getText());

        List<String> solutions = new ArrayList<>();
        List<FormativeExamGrammarParser.PhraseContext> solutionPhrases = ctx.missing_word_solution().list_phrases().phrase();
        for (FormativeExamGrammarParser.PhraseContext phraseContext : solutionPhrases){
            solutions.add(phraseContext.getText());
        }

        List<String> answers = new ArrayList<>();
        try {
            List<FormativeExamGrammarParser.PhraseContext> answerPhrases = ctx.missing_word_answer().list_phrases().phrase();
            for (FormativeExamGrammarParser.PhraseContext phraseContext : answerPhrases){
                answers.add(phraseContext.getText());
            }
        } catch (Exception ignored) {

        }

        double pointsByAnswer = (double) points / solutions.size();

        for (int i = 0; i < Integer.min(answers.size(), solutions.size()); i++){
            if(answers.get(i).equalsIgnoreCase(solutions.get(i))){
                this.grade += pointsByAnswer;
            }
        }

        visitFeedback(ctx.feedback());

        return null;
    }

    @Override
    public String visitShort_answer_question(FormativeExamGrammarParser.Short_answer_questionContext ctx) {
        questionNumber++;
        int points = Integer.parseInt(ctx.points().INT().getText());
        String answer;
        try {
            answer = ctx.short_answer_answer().phrase().getText();
        } catch (Exception e) {
            answer = "";
        }
        String solution = ctx.short_answer_solution().phrase().getText();

        if ((answer.trim()).equalsIgnoreCase(solution.trim())){
            this.grade += points;
        }

        visitFeedback(ctx.feedback());

        return null;
    }

    @Override
    public String visitTrue_false_question(FormativeExamGrammarParser.True_false_questionContext ctx) {
        questionNumber++;
        String answer;

        try {
            answer = ctx.true_false_answer().TRUE_FALSE_RESPONSES().getText();
        } catch (Exception e) {
            answer = "";
        }
        int points = Integer.parseInt(ctx.points().INT().getText());
        String solution = ctx.true_false_solution().TRUE_FALSE_RESPONSES().getText();

        if((answer.trim()).equalsIgnoreCase(solution.trim())){
            grade += points;
        }

        visitFeedback(ctx.feedback());

        return null;

    }

    @Override
    public String visitNumerical_question(FormativeExamGrammarParser.Numerical_questionContext ctx) {
        questionNumber++;
        double points = Double.parseDouble(ctx.points().INT().getText());
        String answerInt = "";
        String answerNumericalValue = "";
        String solutionInt = "";
        String solutionNumericalValue = "";

        try{
            answerInt = ctx.numerical_answer().INT().getText();




        }catch (Exception e){

        }

        try{
            answerNumericalValue = ctx.numerical_answer().NUMERICAL_VALUE().getText();

        }catch(Exception e){

        }

        try{
            solutionInt = ctx.numerical_solution().INT().getText();

        }catch(Exception e){

        }

        try{
            solutionNumericalValue = ctx.numerical_solution().NUMERICAL_VALUE().getText();

        }catch(Exception e){

        }


        String finalAnswer = "";
        String finalSolution = "";

        if(answerInt.isEmpty()){
            finalAnswer = answerNumericalValue;
        }else {
            finalAnswer = answerInt;
        }

        if(solutionInt.isEmpty()){
            finalSolution = solutionNumericalValue;
        }else {
            finalSolution = solutionInt;
        }

        if(finalAnswer.equals(finalSolution)){
            grade += points;
        }

        visitFeedback(ctx.feedback());

        return null;
    }

    @Override
    public String visitMultiple_choice_question(FormativeExamGrammarParser.Multiple_choice_questionContext ctx) {
        questionNumber++;
        List<String> answerList;
        List<String> solutionList;

        String answerText = "";
        String solutionText = "";

        try{
            answerText = ctx.multiple_choice_answer().list_phrases().getText();
            solutionText = ctx.multiple_choice_solution().list_phrases().getText();
        }catch(Exception e){

        }

        answerList = Arrays.asList(answerText.split(","));
        solutionList = Arrays.asList(solutionText.split(","));

        double points = Double.parseDouble(ctx.points().INT().getText());
        double valueByAnswer = points/solutionList.size();
        double questionGrade = 0;

        for (String answer : answerList) {

            if(solutionList.contains(answer)){
                questionGrade += valueByAnswer;
            }else{
                questionGrade -= valueByAnswer;
            }

        }

        if(questionGrade > 0){
            grade += questionGrade;
        }

        visitFeedback(ctx.feedback());

        return null;
    }

    @Override
    public String visitFeedback(FormativeExamGrammarParser.FeedbackContext ctx) {


        try {
            FormativeExamGrammarParser.PhraseContext phraseContext = ctx.phrase();
            StringBuilder stringBuilder = new StringBuilder();

            stringBuilder.append("Question "+ questionNumber + " : ");
            for (FormativeExamGrammarParser.Phrase_wordContext phrase_wordContext : phraseContext.phrase_word()){
                stringBuilder.append(phrase_wordContext.getText());
                stringBuilder.append(" ");
            }

            feedback.add(stringBuilder.toString());
        } catch (Exception ignored) {

        }

        return null;
    }



    public Double grade(){
        return (double) Math.round(this.grade * 100) / 100;
    }

    public List<String> feedback(){
        return this.feedback;
    }
}
