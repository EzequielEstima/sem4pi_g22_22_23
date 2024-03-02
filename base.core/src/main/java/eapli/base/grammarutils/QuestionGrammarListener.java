// Generated from C:/Users/windows/Documents/sem4pi-22-23-24/base.core/src/main/antlr4\QuestionGrammar.g4 by ANTLR 4.12.0
package eapli.base.grammarutils;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link QuestionGrammarParser}.
 */
public interface QuestionGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link QuestionGrammarParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(QuestionGrammarParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionGrammarParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(QuestionGrammarParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionGrammarParser#multiple_choice_question}.
	 * @param ctx the parse tree
	 */
	void enterMultiple_choice_question(QuestionGrammarParser.Multiple_choice_questionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionGrammarParser#multiple_choice_question}.
	 * @param ctx the parse tree
	 */
	void exitMultiple_choice_question(QuestionGrammarParser.Multiple_choice_questionContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionGrammarParser#multiple_choice_answer}.
	 * @param ctx the parse tree
	 */
	void enterMultiple_choice_answer(QuestionGrammarParser.Multiple_choice_answerContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionGrammarParser#multiple_choice_answer}.
	 * @param ctx the parse tree
	 */
	void exitMultiple_choice_answer(QuestionGrammarParser.Multiple_choice_answerContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionGrammarParser#multiple_choice_solution}.
	 * @param ctx the parse tree
	 */
	void enterMultiple_choice_solution(QuestionGrammarParser.Multiple_choice_solutionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionGrammarParser#multiple_choice_solution}.
	 * @param ctx the parse tree
	 */
	void exitMultiple_choice_solution(QuestionGrammarParser.Multiple_choice_solutionContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionGrammarParser#matching_type_question}.
	 * @param ctx the parse tree
	 */
	void enterMatching_type_question(QuestionGrammarParser.Matching_type_questionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionGrammarParser#matching_type_question}.
	 * @param ctx the parse tree
	 */
	void exitMatching_type_question(QuestionGrammarParser.Matching_type_questionContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionGrammarParser#matching_type_answer}.
	 * @param ctx the parse tree
	 */
	void enterMatching_type_answer(QuestionGrammarParser.Matching_type_answerContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionGrammarParser#matching_type_answer}.
	 * @param ctx the parse tree
	 */
	void exitMatching_type_answer(QuestionGrammarParser.Matching_type_answerContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionGrammarParser#matching_type_solution}.
	 * @param ctx the parse tree
	 */
	void enterMatching_type_solution(QuestionGrammarParser.Matching_type_solutionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionGrammarParser#matching_type_solution}.
	 * @param ctx the parse tree
	 */
	void exitMatching_type_solution(QuestionGrammarParser.Matching_type_solutionContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionGrammarParser#true_false_question}.
	 * @param ctx the parse tree
	 */
	void enterTrue_false_question(QuestionGrammarParser.True_false_questionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionGrammarParser#true_false_question}.
	 * @param ctx the parse tree
	 */
	void exitTrue_false_question(QuestionGrammarParser.True_false_questionContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionGrammarParser#true_false_answer}.
	 * @param ctx the parse tree
	 */
	void enterTrue_false_answer(QuestionGrammarParser.True_false_answerContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionGrammarParser#true_false_answer}.
	 * @param ctx the parse tree
	 */
	void exitTrue_false_answer(QuestionGrammarParser.True_false_answerContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionGrammarParser#true_false_solution}.
	 * @param ctx the parse tree
	 */
	void enterTrue_false_solution(QuestionGrammarParser.True_false_solutionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionGrammarParser#true_false_solution}.
	 * @param ctx the parse tree
	 */
	void exitTrue_false_solution(QuestionGrammarParser.True_false_solutionContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionGrammarParser#select_missing_words}.
	 * @param ctx the parse tree
	 */
	void enterSelect_missing_words(QuestionGrammarParser.Select_missing_wordsContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionGrammarParser#select_missing_words}.
	 * @param ctx the parse tree
	 */
	void exitSelect_missing_words(QuestionGrammarParser.Select_missing_wordsContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionGrammarParser#missing_word_phrase}.
	 * @param ctx the parse tree
	 */
	void enterMissing_word_phrase(QuestionGrammarParser.Missing_word_phraseContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionGrammarParser#missing_word_phrase}.
	 * @param ctx the parse tree
	 */
	void exitMissing_word_phrase(QuestionGrammarParser.Missing_word_phraseContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionGrammarParser#missing_word_answer}.
	 * @param ctx the parse tree
	 */
	void enterMissing_word_answer(QuestionGrammarParser.Missing_word_answerContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionGrammarParser#missing_word_answer}.
	 * @param ctx the parse tree
	 */
	void exitMissing_word_answer(QuestionGrammarParser.Missing_word_answerContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionGrammarParser#missing_word_solution}.
	 * @param ctx the parse tree
	 */
	void enterMissing_word_solution(QuestionGrammarParser.Missing_word_solutionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionGrammarParser#missing_word_solution}.
	 * @param ctx the parse tree
	 */
	void exitMissing_word_solution(QuestionGrammarParser.Missing_word_solutionContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionGrammarParser#list_phrases}.
	 * @param ctx the parse tree
	 */
	void enterList_phrases(QuestionGrammarParser.List_phrasesContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionGrammarParser#list_phrases}.
	 * @param ctx the parse tree
	 */
	void exitList_phrases(QuestionGrammarParser.List_phrasesContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionGrammarParser#short_answer_question}.
	 * @param ctx the parse tree
	 */
	void enterShort_answer_question(QuestionGrammarParser.Short_answer_questionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionGrammarParser#short_answer_question}.
	 * @param ctx the parse tree
	 */
	void exitShort_answer_question(QuestionGrammarParser.Short_answer_questionContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionGrammarParser#short_answer_answer}.
	 * @param ctx the parse tree
	 */
	void enterShort_answer_answer(QuestionGrammarParser.Short_answer_answerContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionGrammarParser#short_answer_answer}.
	 * @param ctx the parse tree
	 */
	void exitShort_answer_answer(QuestionGrammarParser.Short_answer_answerContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionGrammarParser#short_answer_solution}.
	 * @param ctx the parse tree
	 */
	void enterShort_answer_solution(QuestionGrammarParser.Short_answer_solutionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionGrammarParser#short_answer_solution}.
	 * @param ctx the parse tree
	 */
	void exitShort_answer_solution(QuestionGrammarParser.Short_answer_solutionContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionGrammarParser#numerical_question}.
	 * @param ctx the parse tree
	 */
	void enterNumerical_question(QuestionGrammarParser.Numerical_questionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionGrammarParser#numerical_question}.
	 * @param ctx the parse tree
	 */
	void exitNumerical_question(QuestionGrammarParser.Numerical_questionContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionGrammarParser#numerical_answer}.
	 * @param ctx the parse tree
	 */
	void enterNumerical_answer(QuestionGrammarParser.Numerical_answerContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionGrammarParser#numerical_answer}.
	 * @param ctx the parse tree
	 */
	void exitNumerical_answer(QuestionGrammarParser.Numerical_answerContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionGrammarParser#numerical_solution}.
	 * @param ctx the parse tree
	 */
	void enterNumerical_solution(QuestionGrammarParser.Numerical_solutionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionGrammarParser#numerical_solution}.
	 * @param ctx the parse tree
	 */
	void exitNumerical_solution(QuestionGrammarParser.Numerical_solutionContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionGrammarParser#question}.
	 * @param ctx the parse tree
	 */
	void enterQuestion(QuestionGrammarParser.QuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionGrammarParser#question}.
	 * @param ctx the parse tree
	 */
	void exitQuestion(QuestionGrammarParser.QuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionGrammarParser#points}.
	 * @param ctx the parse tree
	 */
	void enterPoints(QuestionGrammarParser.PointsContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionGrammarParser#points}.
	 * @param ctx the parse tree
	 */
	void exitPoints(QuestionGrammarParser.PointsContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionGrammarParser#feedback}.
	 * @param ctx the parse tree
	 */
	void enterFeedback(QuestionGrammarParser.FeedbackContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionGrammarParser#feedback}.
	 * @param ctx the parse tree
	 */
	void exitFeedback(QuestionGrammarParser.FeedbackContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionGrammarParser#phrase}.
	 * @param ctx the parse tree
	 */
	void enterPhrase(QuestionGrammarParser.PhraseContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionGrammarParser#phrase}.
	 * @param ctx the parse tree
	 */
	void exitPhrase(QuestionGrammarParser.PhraseContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionGrammarParser#phrase_word}.
	 * @param ctx the parse tree
	 */
	void enterPhrase_word(QuestionGrammarParser.Phrase_wordContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionGrammarParser#phrase_word}.
	 * @param ctx the parse tree
	 */
	void exitPhrase_word(QuestionGrammarParser.Phrase_wordContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionGrammarParser#list_with_title}.
	 * @param ctx the parse tree
	 */
	void enterList_with_title(QuestionGrammarParser.List_with_titleContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionGrammarParser#list_with_title}.
	 * @param ctx the parse tree
	 */
	void exitList_with_title(QuestionGrammarParser.List_with_titleContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionGrammarParser#title_list}.
	 * @param ctx the parse tree
	 */
	void enterTitle_list(QuestionGrammarParser.Title_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionGrammarParser#title_list}.
	 * @param ctx the parse tree
	 */
	void exitTitle_list(QuestionGrammarParser.Title_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionGrammarParser#list}.
	 * @param ctx the parse tree
	 */
	void enterList(QuestionGrammarParser.ListContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionGrammarParser#list}.
	 * @param ctx the parse tree
	 */
	void exitList(QuestionGrammarParser.ListContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionGrammarParser#topic_list}.
	 * @param ctx the parse tree
	 */
	void enterTopic_list(QuestionGrammarParser.Topic_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionGrammarParser#topic_list}.
	 * @param ctx the parse tree
	 */
	void exitTopic_list(QuestionGrammarParser.Topic_listContext ctx);
}