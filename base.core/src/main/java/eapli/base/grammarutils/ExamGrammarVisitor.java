// Generated from C:/Uni/2A/sem4pi-22-23-24/base.core/src/main/antlr4\ExamGrammar.g4 by ANTLR 4.12.0
package eapli.base.grammarutils;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ExamGrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ExamGrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ExamGrammarParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(ExamGrammarParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamGrammarParser#question_type_with_feedback}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestion_type_with_feedback(ExamGrammarParser.Question_type_with_feedbackContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamGrammarParser#question_type_without_feedback}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestion_type_without_feedback(ExamGrammarParser.Question_type_without_feedbackContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamGrammarParser#type_of_grade}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType_of_grade(ExamGrammarParser.Type_of_gradeContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamGrammarParser#type_of_feedback}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType_of_feedback(ExamGrammarParser.Type_of_feedbackContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamGrammarParser#header_description}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHeader_description(ExamGrammarParser.Header_descriptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamGrammarParser#multiple_choice_question}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiple_choice_question(ExamGrammarParser.Multiple_choice_questionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamGrammarParser#multiple_choice_answer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiple_choice_answer(ExamGrammarParser.Multiple_choice_answerContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamGrammarParser#multiple_choice_solution}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiple_choice_solution(ExamGrammarParser.Multiple_choice_solutionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamGrammarParser#matching_type_question}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatching_type_question(ExamGrammarParser.Matching_type_questionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamGrammarParser#matching_type_answer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatching_type_answer(ExamGrammarParser.Matching_type_answerContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamGrammarParser#matching_type_solution}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatching_type_solution(ExamGrammarParser.Matching_type_solutionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamGrammarParser#true_false_question}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrue_false_question(ExamGrammarParser.True_false_questionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamGrammarParser#true_false_answer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrue_false_answer(ExamGrammarParser.True_false_answerContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamGrammarParser#true_false_solution}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrue_false_solution(ExamGrammarParser.True_false_solutionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamGrammarParser#select_missing_words}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelect_missing_words(ExamGrammarParser.Select_missing_wordsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamGrammarParser#missing_word_phrase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMissing_word_phrase(ExamGrammarParser.Missing_word_phraseContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamGrammarParser#missing_word_answer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMissing_word_answer(ExamGrammarParser.Missing_word_answerContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamGrammarParser#missing_word_solution}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMissing_word_solution(ExamGrammarParser.Missing_word_solutionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamGrammarParser#list_phrases}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList_phrases(ExamGrammarParser.List_phrasesContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamGrammarParser#short_answer_question}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShort_answer_question(ExamGrammarParser.Short_answer_questionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamGrammarParser#short_answer_answer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShort_answer_answer(ExamGrammarParser.Short_answer_answerContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamGrammarParser#short_answer_solution}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShort_answer_solution(ExamGrammarParser.Short_answer_solutionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamGrammarParser#numerical_question}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumerical_question(ExamGrammarParser.Numerical_questionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamGrammarParser#numerical_answer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumerical_answer(ExamGrammarParser.Numerical_answerContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamGrammarParser#numerical_solution}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumerical_solution(ExamGrammarParser.Numerical_solutionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamGrammarParser#question}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestion(ExamGrammarParser.QuestionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamGrammarParser#points}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPoints(ExamGrammarParser.PointsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamGrammarParser#feedback}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFeedback(ExamGrammarParser.FeedbackContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamGrammarParser#phrase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPhrase(ExamGrammarParser.PhraseContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamGrammarParser#phrase_word}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPhrase_word(ExamGrammarParser.Phrase_wordContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamGrammarParser#list_with_title}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList_with_title(ExamGrammarParser.List_with_titleContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamGrammarParser#title_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTitle_list(ExamGrammarParser.Title_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamGrammarParser#list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList(ExamGrammarParser.ListContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamGrammarParser#topic_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTopic_list(ExamGrammarParser.Topic_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamGrammarParser#title}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTitle(ExamGrammarParser.TitleContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamGrammarParser#section}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSection(ExamGrammarParser.SectionContext ctx);
}