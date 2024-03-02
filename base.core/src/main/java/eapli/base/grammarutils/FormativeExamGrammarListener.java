// Generated from C:/Users/windows/Documents/sem4pi-22-23-24/base.core/src/main/antlr4\FormativeExamGrammar.g4 by ANTLR 4.12.0
package eapli.base.grammarutils;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link FormativeExamGrammarParser}.
 */
public interface FormativeExamGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link FormativeExamGrammarParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(FormativeExamGrammarParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormativeExamGrammarParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(FormativeExamGrammarParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormativeExamGrammarParser#multiple_choice_question}.
	 * @param ctx the parse tree
	 */
	void enterMultiple_choice_question(FormativeExamGrammarParser.Multiple_choice_questionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormativeExamGrammarParser#multiple_choice_question}.
	 * @param ctx the parse tree
	 */
	void exitMultiple_choice_question(FormativeExamGrammarParser.Multiple_choice_questionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormativeExamGrammarParser#multiple_choice_answer}.
	 * @param ctx the parse tree
	 */
	void enterMultiple_choice_answer(FormativeExamGrammarParser.Multiple_choice_answerContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormativeExamGrammarParser#multiple_choice_answer}.
	 * @param ctx the parse tree
	 */
	void exitMultiple_choice_answer(FormativeExamGrammarParser.Multiple_choice_answerContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormativeExamGrammarParser#multiple_choice_solution}.
	 * @param ctx the parse tree
	 */
	void enterMultiple_choice_solution(FormativeExamGrammarParser.Multiple_choice_solutionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormativeExamGrammarParser#multiple_choice_solution}.
	 * @param ctx the parse tree
	 */
	void exitMultiple_choice_solution(FormativeExamGrammarParser.Multiple_choice_solutionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormativeExamGrammarParser#matching_type_question}.
	 * @param ctx the parse tree
	 */
	void enterMatching_type_question(FormativeExamGrammarParser.Matching_type_questionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormativeExamGrammarParser#matching_type_question}.
	 * @param ctx the parse tree
	 */
	void exitMatching_type_question(FormativeExamGrammarParser.Matching_type_questionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormativeExamGrammarParser#matching_type_answer}.
	 * @param ctx the parse tree
	 */
	void enterMatching_type_answer(FormativeExamGrammarParser.Matching_type_answerContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormativeExamGrammarParser#matching_type_answer}.
	 * @param ctx the parse tree
	 */
	void exitMatching_type_answer(FormativeExamGrammarParser.Matching_type_answerContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormativeExamGrammarParser#matching_type_solution}.
	 * @param ctx the parse tree
	 */
	void enterMatching_type_solution(FormativeExamGrammarParser.Matching_type_solutionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormativeExamGrammarParser#matching_type_solution}.
	 * @param ctx the parse tree
	 */
	void exitMatching_type_solution(FormativeExamGrammarParser.Matching_type_solutionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormativeExamGrammarParser#true_false_question}.
	 * @param ctx the parse tree
	 */
	void enterTrue_false_question(FormativeExamGrammarParser.True_false_questionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormativeExamGrammarParser#true_false_question}.
	 * @param ctx the parse tree
	 */
	void exitTrue_false_question(FormativeExamGrammarParser.True_false_questionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormativeExamGrammarParser#true_false_answer}.
	 * @param ctx the parse tree
	 */
	void enterTrue_false_answer(FormativeExamGrammarParser.True_false_answerContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormativeExamGrammarParser#true_false_answer}.
	 * @param ctx the parse tree
	 */
	void exitTrue_false_answer(FormativeExamGrammarParser.True_false_answerContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormativeExamGrammarParser#true_false_solution}.
	 * @param ctx the parse tree
	 */
	void enterTrue_false_solution(FormativeExamGrammarParser.True_false_solutionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormativeExamGrammarParser#true_false_solution}.
	 * @param ctx the parse tree
	 */
	void exitTrue_false_solution(FormativeExamGrammarParser.True_false_solutionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormativeExamGrammarParser#select_missing_words}.
	 * @param ctx the parse tree
	 */
	void enterSelect_missing_words(FormativeExamGrammarParser.Select_missing_wordsContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormativeExamGrammarParser#select_missing_words}.
	 * @param ctx the parse tree
	 */
	void exitSelect_missing_words(FormativeExamGrammarParser.Select_missing_wordsContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormativeExamGrammarParser#missing_word_phrase}.
	 * @param ctx the parse tree
	 */
	void enterMissing_word_phrase(FormativeExamGrammarParser.Missing_word_phraseContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormativeExamGrammarParser#missing_word_phrase}.
	 * @param ctx the parse tree
	 */
	void exitMissing_word_phrase(FormativeExamGrammarParser.Missing_word_phraseContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormativeExamGrammarParser#missing_word_answer}.
	 * @param ctx the parse tree
	 */
	void enterMissing_word_answer(FormativeExamGrammarParser.Missing_word_answerContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormativeExamGrammarParser#missing_word_answer}.
	 * @param ctx the parse tree
	 */
	void exitMissing_word_answer(FormativeExamGrammarParser.Missing_word_answerContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormativeExamGrammarParser#missing_word_solution}.
	 * @param ctx the parse tree
	 */
	void enterMissing_word_solution(FormativeExamGrammarParser.Missing_word_solutionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormativeExamGrammarParser#missing_word_solution}.
	 * @param ctx the parse tree
	 */
	void exitMissing_word_solution(FormativeExamGrammarParser.Missing_word_solutionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormativeExamGrammarParser#list_phrases}.
	 * @param ctx the parse tree
	 */
	void enterList_phrases(FormativeExamGrammarParser.List_phrasesContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormativeExamGrammarParser#list_phrases}.
	 * @param ctx the parse tree
	 */
	void exitList_phrases(FormativeExamGrammarParser.List_phrasesContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormativeExamGrammarParser#short_answer_question}.
	 * @param ctx the parse tree
	 */
	void enterShort_answer_question(FormativeExamGrammarParser.Short_answer_questionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormativeExamGrammarParser#short_answer_question}.
	 * @param ctx the parse tree
	 */
	void exitShort_answer_question(FormativeExamGrammarParser.Short_answer_questionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormativeExamGrammarParser#short_answer_answer}.
	 * @param ctx the parse tree
	 */
	void enterShort_answer_answer(FormativeExamGrammarParser.Short_answer_answerContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormativeExamGrammarParser#short_answer_answer}.
	 * @param ctx the parse tree
	 */
	void exitShort_answer_answer(FormativeExamGrammarParser.Short_answer_answerContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormativeExamGrammarParser#short_answer_solution}.
	 * @param ctx the parse tree
	 */
	void enterShort_answer_solution(FormativeExamGrammarParser.Short_answer_solutionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormativeExamGrammarParser#short_answer_solution}.
	 * @param ctx the parse tree
	 */
	void exitShort_answer_solution(FormativeExamGrammarParser.Short_answer_solutionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormativeExamGrammarParser#numerical_question}.
	 * @param ctx the parse tree
	 */
	void enterNumerical_question(FormativeExamGrammarParser.Numerical_questionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormativeExamGrammarParser#numerical_question}.
	 * @param ctx the parse tree
	 */
	void exitNumerical_question(FormativeExamGrammarParser.Numerical_questionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormativeExamGrammarParser#numerical_answer}.
	 * @param ctx the parse tree
	 */
	void enterNumerical_answer(FormativeExamGrammarParser.Numerical_answerContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormativeExamGrammarParser#numerical_answer}.
	 * @param ctx the parse tree
	 */
	void exitNumerical_answer(FormativeExamGrammarParser.Numerical_answerContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormativeExamGrammarParser#numerical_solution}.
	 * @param ctx the parse tree
	 */
	void enterNumerical_solution(FormativeExamGrammarParser.Numerical_solutionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormativeExamGrammarParser#numerical_solution}.
	 * @param ctx the parse tree
	 */
	void exitNumerical_solution(FormativeExamGrammarParser.Numerical_solutionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormativeExamGrammarParser#question}.
	 * @param ctx the parse tree
	 */
	void enterQuestion(FormativeExamGrammarParser.QuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormativeExamGrammarParser#question}.
	 * @param ctx the parse tree
	 */
	void exitQuestion(FormativeExamGrammarParser.QuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormativeExamGrammarParser#points}.
	 * @param ctx the parse tree
	 */
	void enterPoints(FormativeExamGrammarParser.PointsContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormativeExamGrammarParser#points}.
	 * @param ctx the parse tree
	 */
	void exitPoints(FormativeExamGrammarParser.PointsContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormativeExamGrammarParser#feedback}.
	 * @param ctx the parse tree
	 */
	void enterFeedback(FormativeExamGrammarParser.FeedbackContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormativeExamGrammarParser#feedback}.
	 * @param ctx the parse tree
	 */
	void exitFeedback(FormativeExamGrammarParser.FeedbackContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormativeExamGrammarParser#phrase}.
	 * @param ctx the parse tree
	 */
	void enterPhrase(FormativeExamGrammarParser.PhraseContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormativeExamGrammarParser#phrase}.
	 * @param ctx the parse tree
	 */
	void exitPhrase(FormativeExamGrammarParser.PhraseContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormativeExamGrammarParser#phrase_word}.
	 * @param ctx the parse tree
	 */
	void enterPhrase_word(FormativeExamGrammarParser.Phrase_wordContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormativeExamGrammarParser#phrase_word}.
	 * @param ctx the parse tree
	 */
	void exitPhrase_word(FormativeExamGrammarParser.Phrase_wordContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormativeExamGrammarParser#list_with_title}.
	 * @param ctx the parse tree
	 */
	void enterList_with_title(FormativeExamGrammarParser.List_with_titleContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormativeExamGrammarParser#list_with_title}.
	 * @param ctx the parse tree
	 */
	void exitList_with_title(FormativeExamGrammarParser.List_with_titleContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormativeExamGrammarParser#title_list}.
	 * @param ctx the parse tree
	 */
	void enterTitle_list(FormativeExamGrammarParser.Title_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormativeExamGrammarParser#title_list}.
	 * @param ctx the parse tree
	 */
	void exitTitle_list(FormativeExamGrammarParser.Title_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormativeExamGrammarParser#list}.
	 * @param ctx the parse tree
	 */
	void enterList(FormativeExamGrammarParser.ListContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormativeExamGrammarParser#list}.
	 * @param ctx the parse tree
	 */
	void exitList(FormativeExamGrammarParser.ListContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormativeExamGrammarParser#topic_list}.
	 * @param ctx the parse tree
	 */
	void enterTopic_list(FormativeExamGrammarParser.Topic_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormativeExamGrammarParser#topic_list}.
	 * @param ctx the parse tree
	 */
	void exitTopic_list(FormativeExamGrammarParser.Topic_listContext ctx);
}