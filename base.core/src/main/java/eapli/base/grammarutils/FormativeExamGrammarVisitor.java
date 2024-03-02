// Generated from C:/Users/windows/Documents/sem4pi-22-23-24/base.core/src/main/antlr4\FormativeExamGrammar.g4 by ANTLR 4.12.0
package eapli.base.grammarutils;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link FormativeExamGrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface FormativeExamGrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link FormativeExamGrammarParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(FormativeExamGrammarParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormativeExamGrammarParser#multiple_choice_question}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiple_choice_question(FormativeExamGrammarParser.Multiple_choice_questionContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormativeExamGrammarParser#multiple_choice_answer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiple_choice_answer(FormativeExamGrammarParser.Multiple_choice_answerContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormativeExamGrammarParser#multiple_choice_solution}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiple_choice_solution(FormativeExamGrammarParser.Multiple_choice_solutionContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormativeExamGrammarParser#matching_type_question}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatching_type_question(FormativeExamGrammarParser.Matching_type_questionContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormativeExamGrammarParser#matching_type_answer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatching_type_answer(FormativeExamGrammarParser.Matching_type_answerContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormativeExamGrammarParser#matching_type_solution}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatching_type_solution(FormativeExamGrammarParser.Matching_type_solutionContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormativeExamGrammarParser#true_false_question}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrue_false_question(FormativeExamGrammarParser.True_false_questionContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormativeExamGrammarParser#true_false_answer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrue_false_answer(FormativeExamGrammarParser.True_false_answerContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormativeExamGrammarParser#true_false_solution}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrue_false_solution(FormativeExamGrammarParser.True_false_solutionContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormativeExamGrammarParser#select_missing_words}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelect_missing_words(FormativeExamGrammarParser.Select_missing_wordsContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormativeExamGrammarParser#missing_word_phrase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMissing_word_phrase(FormativeExamGrammarParser.Missing_word_phraseContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormativeExamGrammarParser#missing_word_answer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMissing_word_answer(FormativeExamGrammarParser.Missing_word_answerContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormativeExamGrammarParser#missing_word_solution}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMissing_word_solution(FormativeExamGrammarParser.Missing_word_solutionContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormativeExamGrammarParser#list_phrases}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList_phrases(FormativeExamGrammarParser.List_phrasesContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormativeExamGrammarParser#short_answer_question}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShort_answer_question(FormativeExamGrammarParser.Short_answer_questionContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormativeExamGrammarParser#short_answer_answer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShort_answer_answer(FormativeExamGrammarParser.Short_answer_answerContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormativeExamGrammarParser#short_answer_solution}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShort_answer_solution(FormativeExamGrammarParser.Short_answer_solutionContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormativeExamGrammarParser#numerical_question}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumerical_question(FormativeExamGrammarParser.Numerical_questionContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormativeExamGrammarParser#numerical_answer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumerical_answer(FormativeExamGrammarParser.Numerical_answerContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormativeExamGrammarParser#numerical_solution}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumerical_solution(FormativeExamGrammarParser.Numerical_solutionContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormativeExamGrammarParser#question}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestion(FormativeExamGrammarParser.QuestionContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormativeExamGrammarParser#points}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPoints(FormativeExamGrammarParser.PointsContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormativeExamGrammarParser#feedback}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFeedback(FormativeExamGrammarParser.FeedbackContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormativeExamGrammarParser#phrase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPhrase(FormativeExamGrammarParser.PhraseContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormativeExamGrammarParser#phrase_word}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPhrase_word(FormativeExamGrammarParser.Phrase_wordContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormativeExamGrammarParser#list_with_title}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList_with_title(FormativeExamGrammarParser.List_with_titleContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormativeExamGrammarParser#title_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTitle_list(FormativeExamGrammarParser.Title_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormativeExamGrammarParser#list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList(FormativeExamGrammarParser.ListContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormativeExamGrammarParser#topic_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTopic_list(FormativeExamGrammarParser.Topic_listContext ctx);
}