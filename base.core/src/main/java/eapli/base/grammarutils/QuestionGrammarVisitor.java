// Generated from C:/Users/windows/Documents/sem4pi-22-23-24/base.core/src/main/antlr4\QuestionGrammar.g4 by ANTLR 4.12.0
package eapli.base.grammarutils;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link QuestionGrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface QuestionGrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link QuestionGrammarParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(QuestionGrammarParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionGrammarParser#multiple_choice_question}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiple_choice_question(QuestionGrammarParser.Multiple_choice_questionContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionGrammarParser#multiple_choice_answer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiple_choice_answer(QuestionGrammarParser.Multiple_choice_answerContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionGrammarParser#multiple_choice_solution}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiple_choice_solution(QuestionGrammarParser.Multiple_choice_solutionContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionGrammarParser#matching_type_question}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatching_type_question(QuestionGrammarParser.Matching_type_questionContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionGrammarParser#matching_type_answer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatching_type_answer(QuestionGrammarParser.Matching_type_answerContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionGrammarParser#matching_type_solution}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatching_type_solution(QuestionGrammarParser.Matching_type_solutionContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionGrammarParser#true_false_question}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrue_false_question(QuestionGrammarParser.True_false_questionContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionGrammarParser#true_false_answer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrue_false_answer(QuestionGrammarParser.True_false_answerContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionGrammarParser#true_false_solution}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrue_false_solution(QuestionGrammarParser.True_false_solutionContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionGrammarParser#select_missing_words}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelect_missing_words(QuestionGrammarParser.Select_missing_wordsContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionGrammarParser#missing_word_phrase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMissing_word_phrase(QuestionGrammarParser.Missing_word_phraseContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionGrammarParser#missing_word_answer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMissing_word_answer(QuestionGrammarParser.Missing_word_answerContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionGrammarParser#missing_word_solution}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMissing_word_solution(QuestionGrammarParser.Missing_word_solutionContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionGrammarParser#list_phrases}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList_phrases(QuestionGrammarParser.List_phrasesContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionGrammarParser#short_answer_question}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShort_answer_question(QuestionGrammarParser.Short_answer_questionContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionGrammarParser#short_answer_answer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShort_answer_answer(QuestionGrammarParser.Short_answer_answerContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionGrammarParser#short_answer_solution}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShort_answer_solution(QuestionGrammarParser.Short_answer_solutionContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionGrammarParser#numerical_question}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumerical_question(QuestionGrammarParser.Numerical_questionContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionGrammarParser#numerical_answer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumerical_answer(QuestionGrammarParser.Numerical_answerContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionGrammarParser#numerical_solution}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumerical_solution(QuestionGrammarParser.Numerical_solutionContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionGrammarParser#question}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestion(QuestionGrammarParser.QuestionContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionGrammarParser#points}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPoints(QuestionGrammarParser.PointsContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionGrammarParser#feedback}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFeedback(QuestionGrammarParser.FeedbackContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionGrammarParser#phrase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPhrase(QuestionGrammarParser.PhraseContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionGrammarParser#phrase_word}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPhrase_word(QuestionGrammarParser.Phrase_wordContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionGrammarParser#list_with_title}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList_with_title(QuestionGrammarParser.List_with_titleContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionGrammarParser#title_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTitle_list(QuestionGrammarParser.Title_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionGrammarParser#list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList(QuestionGrammarParser.ListContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionGrammarParser#topic_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTopic_list(QuestionGrammarParser.Topic_listContext ctx);
}