// Generated from C:/Users/windows/Documents/sem4pi-22-23-24/base.core/src/main/antlr4\FormativeExamGrammar.g4 by ANTLR 4.12.0
package eapli.base.grammarutils;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class FormativeExamGrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.12.0", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ANSWER_ENTRY=1, SOLUTION_ENTRY=2, TRUE_FALSE_RESPONSES=3, FEEDBACK_ENTRY=4, 
		QUESTION_ENTRY=5, POINTS_ENTRY=6, MC_Q=7, N_Q=8, SA_Q=9, SMW_Q=10, TF_Q=11, 
		MT_Q=12, POINTS=13, COMMA=14, WS=15, HASH=16, NEWLINE=17, WORD=18, COLON=19, 
		DASH=20, INT=21, NUMERICAL_VALUE=22, PUNCTUATION=23, MISSING_WORD=24;
	public static final int
		RULE_prog = 0, RULE_multiple_choice_question = 1, RULE_multiple_choice_answer = 2, 
		RULE_multiple_choice_solution = 3, RULE_matching_type_question = 4, RULE_matching_type_answer = 5, 
		RULE_matching_type_solution = 6, RULE_true_false_question = 7, RULE_true_false_answer = 8, 
		RULE_true_false_solution = 9, RULE_select_missing_words = 10, RULE_missing_word_phrase = 11, 
		RULE_missing_word_answer = 12, RULE_missing_word_solution = 13, RULE_list_phrases = 14, 
		RULE_short_answer_question = 15, RULE_short_answer_answer = 16, RULE_short_answer_solution = 17, 
		RULE_numerical_question = 18, RULE_numerical_answer = 19, RULE_numerical_solution = 20, 
		RULE_question = 21, RULE_points = 22, RULE_feedback = 23, RULE_phrase = 24, 
		RULE_phrase_word = 25, RULE_list_with_title = 26, RULE_title_list = 27, 
		RULE_list = 28, RULE_topic_list = 29;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "multiple_choice_question", "multiple_choice_answer", "multiple_choice_solution", 
			"matching_type_question", "matching_type_answer", "matching_type_solution", 
			"true_false_question", "true_false_answer", "true_false_solution", "select_missing_words", 
			"missing_word_phrase", "missing_word_answer", "missing_word_solution", 
			"list_phrases", "short_answer_question", "short_answer_answer", "short_answer_solution", 
			"numerical_question", "numerical_answer", "numerical_solution", "question", 
			"points", "feedback", "phrase", "phrase_word", "list_with_title", "title_list", 
			"list", "topic_list"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, null, "'Multiple Choice'", "'Numerical'", 
			"'Short Answer'", "'Select Missing Words'", "'True/False Question'", 
			"'Matching Type'", "'Points'", "','", null, "'#'", null, null, "':'", 
			"'-'", null, null, null, "'||WORD||'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "ANSWER_ENTRY", "SOLUTION_ENTRY", "TRUE_FALSE_RESPONSES", "FEEDBACK_ENTRY", 
			"QUESTION_ENTRY", "POINTS_ENTRY", "MC_Q", "N_Q", "SA_Q", "SMW_Q", "TF_Q", 
			"MT_Q", "POINTS", "COMMA", "WS", "HASH", "NEWLINE", "WORD", "COLON", 
			"DASH", "INT", "NUMERICAL_VALUE", "PUNCTUATION", "MISSING_WORD"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "FormativeExamGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public FormativeExamGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgContext extends ParserRuleContext {
		public List<Matching_type_questionContext> matching_type_question() {
			return getRuleContexts(Matching_type_questionContext.class);
		}
		public Matching_type_questionContext matching_type_question(int i) {
			return getRuleContext(Matching_type_questionContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(FormativeExamGrammarParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(FormativeExamGrammarParser.NEWLINE, i);
		}
		public List<Select_missing_wordsContext> select_missing_words() {
			return getRuleContexts(Select_missing_wordsContext.class);
		}
		public Select_missing_wordsContext select_missing_words(int i) {
			return getRuleContext(Select_missing_wordsContext.class,i);
		}
		public List<True_false_questionContext> true_false_question() {
			return getRuleContexts(True_false_questionContext.class);
		}
		public True_false_questionContext true_false_question(int i) {
			return getRuleContext(True_false_questionContext.class,i);
		}
		public List<Multiple_choice_questionContext> multiple_choice_question() {
			return getRuleContexts(Multiple_choice_questionContext.class);
		}
		public Multiple_choice_questionContext multiple_choice_question(int i) {
			return getRuleContext(Multiple_choice_questionContext.class,i);
		}
		public List<Short_answer_questionContext> short_answer_question() {
			return getRuleContexts(Short_answer_questionContext.class);
		}
		public Short_answer_questionContext short_answer_question(int i) {
			return getRuleContext(Short_answer_questionContext.class,i);
		}
		public List<Numerical_questionContext> numerical_question() {
			return getRuleContexts(Numerical_questionContext.class);
		}
		public Numerical_questionContext numerical_question(int i) {
			return getRuleContext(Numerical_questionContext.class,i);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamGrammarListener ) ((FormativeExamGrammarListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamGrammarListener ) ((FormativeExamGrammarListener)listener).exitProg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormativeExamGrammarVisitor ) return ((FormativeExamGrammarVisitor<? extends T>)visitor).visitProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			setState(102);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(63); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(60);
					matching_type_question();
					setState(61);
					match(NEWLINE);
					}
					}
					setState(65); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==HASH );
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(70); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(67);
					select_missing_words();
					setState(68);
					match(NEWLINE);
					}
					}
					setState(72); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==HASH );
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(77); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(74);
					true_false_question();
					setState(75);
					match(NEWLINE);
					}
					}
					setState(79); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==HASH );
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(84); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(81);
					multiple_choice_question();
					setState(82);
					match(NEWLINE);
					}
					}
					setState(86); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==HASH );
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(91); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(88);
					short_answer_question();
					setState(89);
					match(NEWLINE);
					}
					}
					setState(93); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==HASH );
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(98); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(95);
					numerical_question();
					setState(96);
					match(NEWLINE);
					}
					}
					setState(100); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==HASH );
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Multiple_choice_questionContext extends ParserRuleContext {
		public TerminalNode HASH() { return getToken(FormativeExamGrammarParser.HASH, 0); }
		public TerminalNode MC_Q() { return getToken(FormativeExamGrammarParser.MC_Q, 0); }
		public PointsContext points() {
			return getRuleContext(PointsContext.class,0);
		}
		public QuestionContext question() {
			return getRuleContext(QuestionContext.class,0);
		}
		public List_with_titleContext list_with_title() {
			return getRuleContext(List_with_titleContext.class,0);
		}
		public Multiple_choice_answerContext multiple_choice_answer() {
			return getRuleContext(Multiple_choice_answerContext.class,0);
		}
		public Multiple_choice_solutionContext multiple_choice_solution() {
			return getRuleContext(Multiple_choice_solutionContext.class,0);
		}
		public FeedbackContext feedback() {
			return getRuleContext(FeedbackContext.class,0);
		}
		public Multiple_choice_questionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiple_choice_question; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamGrammarListener ) ((FormativeExamGrammarListener)listener).enterMultiple_choice_question(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamGrammarListener ) ((FormativeExamGrammarListener)listener).exitMultiple_choice_question(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormativeExamGrammarVisitor ) return ((FormativeExamGrammarVisitor<? extends T>)visitor).visitMultiple_choice_question(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Multiple_choice_questionContext multiple_choice_question() throws RecognitionException {
		Multiple_choice_questionContext _localctx = new Multiple_choice_questionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_multiple_choice_question);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			match(HASH);
			setState(105);
			match(MC_Q);
			setState(106);
			points();
			setState(107);
			question();
			setState(108);
			list_with_title();
			setState(109);
			multiple_choice_answer();
			setState(110);
			multiple_choice_solution();
			setState(112);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(111);
				feedback();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Multiple_choice_answerContext extends ParserRuleContext {
		public TerminalNode ANSWER_ENTRY() { return getToken(FormativeExamGrammarParser.ANSWER_ENTRY, 0); }
		public List_phrasesContext list_phrases() {
			return getRuleContext(List_phrasesContext.class,0);
		}
		public Multiple_choice_answerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiple_choice_answer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamGrammarListener ) ((FormativeExamGrammarListener)listener).enterMultiple_choice_answer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamGrammarListener ) ((FormativeExamGrammarListener)listener).exitMultiple_choice_answer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormativeExamGrammarVisitor ) return ((FormativeExamGrammarVisitor<? extends T>)visitor).visitMultiple_choice_answer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Multiple_choice_answerContext multiple_choice_answer() throws RecognitionException {
		Multiple_choice_answerContext _localctx = new Multiple_choice_answerContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_multiple_choice_answer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
			match(ANSWER_ENTRY);
			setState(116);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 12402688L) != 0)) {
				{
				setState(115);
				list_phrases();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Multiple_choice_solutionContext extends ParserRuleContext {
		public TerminalNode SOLUTION_ENTRY() { return getToken(FormativeExamGrammarParser.SOLUTION_ENTRY, 0); }
		public List_phrasesContext list_phrases() {
			return getRuleContext(List_phrasesContext.class,0);
		}
		public Multiple_choice_solutionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiple_choice_solution; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamGrammarListener ) ((FormativeExamGrammarListener)listener).enterMultiple_choice_solution(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamGrammarListener ) ((FormativeExamGrammarListener)listener).exitMultiple_choice_solution(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormativeExamGrammarVisitor ) return ((FormativeExamGrammarVisitor<? extends T>)visitor).visitMultiple_choice_solution(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Multiple_choice_solutionContext multiple_choice_solution() throws RecognitionException {
		Multiple_choice_solutionContext _localctx = new Multiple_choice_solutionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_multiple_choice_solution);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			match(SOLUTION_ENTRY);
			setState(119);
			list_phrases();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Matching_type_questionContext extends ParserRuleContext {
		public TerminalNode HASH() { return getToken(FormativeExamGrammarParser.HASH, 0); }
		public TerminalNode MT_Q() { return getToken(FormativeExamGrammarParser.MT_Q, 0); }
		public PointsContext points() {
			return getRuleContext(PointsContext.class,0);
		}
		public QuestionContext question() {
			return getRuleContext(QuestionContext.class,0);
		}
		public List<List_with_titleContext> list_with_title() {
			return getRuleContexts(List_with_titleContext.class);
		}
		public List_with_titleContext list_with_title(int i) {
			return getRuleContext(List_with_titleContext.class,i);
		}
		public Matching_type_answerContext matching_type_answer() {
			return getRuleContext(Matching_type_answerContext.class,0);
		}
		public Matching_type_solutionContext matching_type_solution() {
			return getRuleContext(Matching_type_solutionContext.class,0);
		}
		public FeedbackContext feedback() {
			return getRuleContext(FeedbackContext.class,0);
		}
		public Matching_type_questionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_matching_type_question; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamGrammarListener ) ((FormativeExamGrammarListener)listener).enterMatching_type_question(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamGrammarListener ) ((FormativeExamGrammarListener)listener).exitMatching_type_question(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormativeExamGrammarVisitor ) return ((FormativeExamGrammarVisitor<? extends T>)visitor).visitMatching_type_question(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Matching_type_questionContext matching_type_question() throws RecognitionException {
		Matching_type_questionContext _localctx = new Matching_type_questionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_matching_type_question);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			match(HASH);
			setState(122);
			match(MT_Q);
			setState(123);
			points();
			setState(124);
			question();
			setState(125);
			list_with_title();
			setState(126);
			list_with_title();
			setState(127);
			matching_type_answer();
			setState(128);
			matching_type_solution();
			setState(130);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(129);
				feedback();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Matching_type_answerContext extends ParserRuleContext {
		public TerminalNode ANSWER_ENTRY() { return getToken(FormativeExamGrammarParser.ANSWER_ENTRY, 0); }
		public List<PhraseContext> phrase() {
			return getRuleContexts(PhraseContext.class);
		}
		public PhraseContext phrase(int i) {
			return getRuleContext(PhraseContext.class,i);
		}
		public List<TerminalNode> DASH() { return getTokens(FormativeExamGrammarParser.DASH); }
		public TerminalNode DASH(int i) {
			return getToken(FormativeExamGrammarParser.DASH, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(FormativeExamGrammarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(FormativeExamGrammarParser.COMMA, i);
		}
		public Matching_type_answerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_matching_type_answer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamGrammarListener ) ((FormativeExamGrammarListener)listener).enterMatching_type_answer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamGrammarListener ) ((FormativeExamGrammarListener)listener).exitMatching_type_answer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormativeExamGrammarVisitor ) return ((FormativeExamGrammarVisitor<? extends T>)visitor).visitMatching_type_answer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Matching_type_answerContext matching_type_answer() throws RecognitionException {
		Matching_type_answerContext _localctx = new Matching_type_answerContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_matching_type_answer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			match(ANSWER_ENTRY);
			setState(146);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 12402688L) != 0)) {
				{
				setState(133);
				phrase();
				setState(134);
				match(DASH);
				setState(135);
				phrase();
				setState(143);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(136);
					match(COMMA);
					setState(137);
					phrase();
					setState(138);
					match(DASH);
					setState(139);
					phrase();
					}
					}
					setState(145);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Matching_type_solutionContext extends ParserRuleContext {
		public TerminalNode SOLUTION_ENTRY() { return getToken(FormativeExamGrammarParser.SOLUTION_ENTRY, 0); }
		public List<PhraseContext> phrase() {
			return getRuleContexts(PhraseContext.class);
		}
		public PhraseContext phrase(int i) {
			return getRuleContext(PhraseContext.class,i);
		}
		public List<TerminalNode> DASH() { return getTokens(FormativeExamGrammarParser.DASH); }
		public TerminalNode DASH(int i) {
			return getToken(FormativeExamGrammarParser.DASH, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(FormativeExamGrammarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(FormativeExamGrammarParser.COMMA, i);
		}
		public Matching_type_solutionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_matching_type_solution; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamGrammarListener ) ((FormativeExamGrammarListener)listener).enterMatching_type_solution(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamGrammarListener ) ((FormativeExamGrammarListener)listener).exitMatching_type_solution(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormativeExamGrammarVisitor ) return ((FormativeExamGrammarVisitor<? extends T>)visitor).visitMatching_type_solution(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Matching_type_solutionContext matching_type_solution() throws RecognitionException {
		Matching_type_solutionContext _localctx = new Matching_type_solutionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_matching_type_solution);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(148);
			match(SOLUTION_ENTRY);
			setState(149);
			phrase();
			setState(150);
			match(DASH);
			setState(151);
			phrase();
			setState(159);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(152);
				match(COMMA);
				setState(153);
				phrase();
				setState(154);
				match(DASH);
				setState(155);
				phrase();
				}
				}
				setState(161);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class True_false_questionContext extends ParserRuleContext {
		public TerminalNode HASH() { return getToken(FormativeExamGrammarParser.HASH, 0); }
		public TerminalNode TF_Q() { return getToken(FormativeExamGrammarParser.TF_Q, 0); }
		public PointsContext points() {
			return getRuleContext(PointsContext.class,0);
		}
		public QuestionContext question() {
			return getRuleContext(QuestionContext.class,0);
		}
		public True_false_answerContext true_false_answer() {
			return getRuleContext(True_false_answerContext.class,0);
		}
		public True_false_solutionContext true_false_solution() {
			return getRuleContext(True_false_solutionContext.class,0);
		}
		public FeedbackContext feedback() {
			return getRuleContext(FeedbackContext.class,0);
		}
		public True_false_questionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_true_false_question; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamGrammarListener ) ((FormativeExamGrammarListener)listener).enterTrue_false_question(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamGrammarListener ) ((FormativeExamGrammarListener)listener).exitTrue_false_question(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormativeExamGrammarVisitor ) return ((FormativeExamGrammarVisitor<? extends T>)visitor).visitTrue_false_question(this);
			else return visitor.visitChildren(this);
		}
	}

	public final True_false_questionContext true_false_question() throws RecognitionException {
		True_false_questionContext _localctx = new True_false_questionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_true_false_question);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
			match(HASH);
			setState(163);
			match(TF_Q);
			setState(164);
			points();
			setState(165);
			question();
			setState(166);
			true_false_answer();
			setState(167);
			true_false_solution();
			setState(169);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				setState(168);
				feedback();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class True_false_answerContext extends ParserRuleContext {
		public TerminalNode ANSWER_ENTRY() { return getToken(FormativeExamGrammarParser.ANSWER_ENTRY, 0); }
		public TerminalNode TRUE_FALSE_RESPONSES() { return getToken(FormativeExamGrammarParser.TRUE_FALSE_RESPONSES, 0); }
		public True_false_answerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_true_false_answer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamGrammarListener ) ((FormativeExamGrammarListener)listener).enterTrue_false_answer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamGrammarListener ) ((FormativeExamGrammarListener)listener).exitTrue_false_answer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormativeExamGrammarVisitor ) return ((FormativeExamGrammarVisitor<? extends T>)visitor).visitTrue_false_answer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final True_false_answerContext true_false_answer() throws RecognitionException {
		True_false_answerContext _localctx = new True_false_answerContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_true_false_answer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(171);
			match(ANSWER_ENTRY);
			setState(173);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TRUE_FALSE_RESPONSES) {
				{
				setState(172);
				match(TRUE_FALSE_RESPONSES);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class True_false_solutionContext extends ParserRuleContext {
		public TerminalNode SOLUTION_ENTRY() { return getToken(FormativeExamGrammarParser.SOLUTION_ENTRY, 0); }
		public TerminalNode TRUE_FALSE_RESPONSES() { return getToken(FormativeExamGrammarParser.TRUE_FALSE_RESPONSES, 0); }
		public True_false_solutionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_true_false_solution; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamGrammarListener ) ((FormativeExamGrammarListener)listener).enterTrue_false_solution(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamGrammarListener ) ((FormativeExamGrammarListener)listener).exitTrue_false_solution(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormativeExamGrammarVisitor ) return ((FormativeExamGrammarVisitor<? extends T>)visitor).visitTrue_false_solution(this);
			else return visitor.visitChildren(this);
		}
	}

	public final True_false_solutionContext true_false_solution() throws RecognitionException {
		True_false_solutionContext _localctx = new True_false_solutionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_true_false_solution);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(175);
			match(SOLUTION_ENTRY);
			setState(176);
			match(TRUE_FALSE_RESPONSES);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Select_missing_wordsContext extends ParserRuleContext {
		public TerminalNode HASH() { return getToken(FormativeExamGrammarParser.HASH, 0); }
		public TerminalNode SMW_Q() { return getToken(FormativeExamGrammarParser.SMW_Q, 0); }
		public PointsContext points() {
			return getRuleContext(PointsContext.class,0);
		}
		public QuestionContext question() {
			return getRuleContext(QuestionContext.class,0);
		}
		public Missing_word_phraseContext missing_word_phrase() {
			return getRuleContext(Missing_word_phraseContext.class,0);
		}
		public Missing_word_answerContext missing_word_answer() {
			return getRuleContext(Missing_word_answerContext.class,0);
		}
		public Missing_word_solutionContext missing_word_solution() {
			return getRuleContext(Missing_word_solutionContext.class,0);
		}
		public List<List_with_titleContext> list_with_title() {
			return getRuleContexts(List_with_titleContext.class);
		}
		public List_with_titleContext list_with_title(int i) {
			return getRuleContext(List_with_titleContext.class,i);
		}
		public FeedbackContext feedback() {
			return getRuleContext(FeedbackContext.class,0);
		}
		public Select_missing_wordsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_select_missing_words; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamGrammarListener ) ((FormativeExamGrammarListener)listener).enterSelect_missing_words(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamGrammarListener ) ((FormativeExamGrammarListener)listener).exitSelect_missing_words(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormativeExamGrammarVisitor ) return ((FormativeExamGrammarVisitor<? extends T>)visitor).visitSelect_missing_words(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Select_missing_wordsContext select_missing_words() throws RecognitionException {
		Select_missing_wordsContext _localctx = new Select_missing_wordsContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_select_missing_words);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(178);
			match(HASH);
			setState(179);
			match(SMW_Q);
			setState(180);
			points();
			setState(181);
			question();
			setState(182);
			missing_word_phrase();
			setState(184); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(183);
				list_with_title();
				}
				}
				setState(186); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			setState(188);
			missing_word_answer();
			setState(189);
			missing_word_solution();
			setState(191);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(190);
				feedback();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Missing_word_phraseContext extends ParserRuleContext {
		public List<TerminalNode> NEWLINE() { return getTokens(FormativeExamGrammarParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(FormativeExamGrammarParser.NEWLINE, i);
		}
		public List<PhraseContext> phrase() {
			return getRuleContexts(PhraseContext.class);
		}
		public PhraseContext phrase(int i) {
			return getRuleContext(PhraseContext.class,i);
		}
		public List<TerminalNode> MISSING_WORD() { return getTokens(FormativeExamGrammarParser.MISSING_WORD); }
		public TerminalNode MISSING_WORD(int i) {
			return getToken(FormativeExamGrammarParser.MISSING_WORD, i);
		}
		public Missing_word_phraseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_missing_word_phrase; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamGrammarListener ) ((FormativeExamGrammarListener)listener).enterMissing_word_phrase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamGrammarListener ) ((FormativeExamGrammarListener)listener).exitMissing_word_phrase(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormativeExamGrammarVisitor ) return ((FormativeExamGrammarVisitor<? extends T>)visitor).visitMissing_word_phrase(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Missing_word_phraseContext missing_word_phrase() throws RecognitionException {
		Missing_word_phraseContext _localctx = new Missing_word_phraseContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_missing_word_phrase);
		int _la;
		try {
			int _alt;
			setState(228);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(194); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(193);
					match(NEWLINE);
					}
					}
					setState(196); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE );
				setState(199);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 12402688L) != 0)) {
					{
					setState(198);
					phrase();
					}
				}

				setState(203); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(201);
						match(MISSING_WORD);
						setState(202);
						phrase();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(205); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(208);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==MISSING_WORD) {
					{
					setState(207);
					match(MISSING_WORD);
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(211); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(210);
					match(NEWLINE);
					}
					}
					setState(213); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE );
				setState(216);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==MISSING_WORD) {
					{
					setState(215);
					match(MISSING_WORD);
					}
				}

				setState(221); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(218);
						phrase();
						setState(219);
						match(MISSING_WORD);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(223); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(226);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 12402688L) != 0)) {
					{
					setState(225);
					phrase();
					}
				}

				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Missing_word_answerContext extends ParserRuleContext {
		public TerminalNode ANSWER_ENTRY() { return getToken(FormativeExamGrammarParser.ANSWER_ENTRY, 0); }
		public List_phrasesContext list_phrases() {
			return getRuleContext(List_phrasesContext.class,0);
		}
		public Missing_word_answerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_missing_word_answer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamGrammarListener ) ((FormativeExamGrammarListener)listener).enterMissing_word_answer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamGrammarListener ) ((FormativeExamGrammarListener)listener).exitMissing_word_answer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormativeExamGrammarVisitor ) return ((FormativeExamGrammarVisitor<? extends T>)visitor).visitMissing_word_answer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Missing_word_answerContext missing_word_answer() throws RecognitionException {
		Missing_word_answerContext _localctx = new Missing_word_answerContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_missing_word_answer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(230);
			match(ANSWER_ENTRY);
			setState(232);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 12402688L) != 0)) {
				{
				setState(231);
				list_phrases();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Missing_word_solutionContext extends ParserRuleContext {
		public TerminalNode SOLUTION_ENTRY() { return getToken(FormativeExamGrammarParser.SOLUTION_ENTRY, 0); }
		public List_phrasesContext list_phrases() {
			return getRuleContext(List_phrasesContext.class,0);
		}
		public Missing_word_solutionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_missing_word_solution; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamGrammarListener ) ((FormativeExamGrammarListener)listener).enterMissing_word_solution(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamGrammarListener ) ((FormativeExamGrammarListener)listener).exitMissing_word_solution(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormativeExamGrammarVisitor ) return ((FormativeExamGrammarVisitor<? extends T>)visitor).visitMissing_word_solution(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Missing_word_solutionContext missing_word_solution() throws RecognitionException {
		Missing_word_solutionContext _localctx = new Missing_word_solutionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_missing_word_solution);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(234);
			match(SOLUTION_ENTRY);
			setState(235);
			list_phrases();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class List_phrasesContext extends ParserRuleContext {
		public List<PhraseContext> phrase() {
			return getRuleContexts(PhraseContext.class);
		}
		public PhraseContext phrase(int i) {
			return getRuleContext(PhraseContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(FormativeExamGrammarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(FormativeExamGrammarParser.COMMA, i);
		}
		public List_phrasesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list_phrases; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamGrammarListener ) ((FormativeExamGrammarListener)listener).enterList_phrases(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamGrammarListener ) ((FormativeExamGrammarListener)listener).exitList_phrases(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormativeExamGrammarVisitor ) return ((FormativeExamGrammarVisitor<? extends T>)visitor).visitList_phrases(this);
			else return visitor.visitChildren(this);
		}
	}

	public final List_phrasesContext list_phrases() throws RecognitionException {
		List_phrasesContext _localctx = new List_phrasesContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_list_phrases);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(237);
			phrase();
			setState(242);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(238);
				match(COMMA);
				setState(239);
				phrase();
				}
				}
				setState(244);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Short_answer_questionContext extends ParserRuleContext {
		public TerminalNode HASH() { return getToken(FormativeExamGrammarParser.HASH, 0); }
		public TerminalNode SA_Q() { return getToken(FormativeExamGrammarParser.SA_Q, 0); }
		public PointsContext points() {
			return getRuleContext(PointsContext.class,0);
		}
		public QuestionContext question() {
			return getRuleContext(QuestionContext.class,0);
		}
		public Short_answer_answerContext short_answer_answer() {
			return getRuleContext(Short_answer_answerContext.class,0);
		}
		public Short_answer_solutionContext short_answer_solution() {
			return getRuleContext(Short_answer_solutionContext.class,0);
		}
		public FeedbackContext feedback() {
			return getRuleContext(FeedbackContext.class,0);
		}
		public Short_answer_questionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_short_answer_question; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamGrammarListener ) ((FormativeExamGrammarListener)listener).enterShort_answer_question(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamGrammarListener ) ((FormativeExamGrammarListener)listener).exitShort_answer_question(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormativeExamGrammarVisitor ) return ((FormativeExamGrammarVisitor<? extends T>)visitor).visitShort_answer_question(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Short_answer_questionContext short_answer_question() throws RecognitionException {
		Short_answer_questionContext _localctx = new Short_answer_questionContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_short_answer_question);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(245);
			match(HASH);
			setState(246);
			match(SA_Q);
			setState(247);
			points();
			setState(248);
			question();
			setState(249);
			short_answer_answer();
			setState(250);
			short_answer_solution();
			setState(252);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				{
				setState(251);
				feedback();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Short_answer_answerContext extends ParserRuleContext {
		public TerminalNode ANSWER_ENTRY() { return getToken(FormativeExamGrammarParser.ANSWER_ENTRY, 0); }
		public PhraseContext phrase() {
			return getRuleContext(PhraseContext.class,0);
		}
		public Short_answer_answerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_short_answer_answer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamGrammarListener ) ((FormativeExamGrammarListener)listener).enterShort_answer_answer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamGrammarListener ) ((FormativeExamGrammarListener)listener).exitShort_answer_answer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormativeExamGrammarVisitor ) return ((FormativeExamGrammarVisitor<? extends T>)visitor).visitShort_answer_answer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Short_answer_answerContext short_answer_answer() throws RecognitionException {
		Short_answer_answerContext _localctx = new Short_answer_answerContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_short_answer_answer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(254);
			match(ANSWER_ENTRY);
			setState(256);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 12402688L) != 0)) {
				{
				setState(255);
				phrase();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Short_answer_solutionContext extends ParserRuleContext {
		public TerminalNode SOLUTION_ENTRY() { return getToken(FormativeExamGrammarParser.SOLUTION_ENTRY, 0); }
		public PhraseContext phrase() {
			return getRuleContext(PhraseContext.class,0);
		}
		public Short_answer_solutionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_short_answer_solution; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamGrammarListener ) ((FormativeExamGrammarListener)listener).enterShort_answer_solution(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamGrammarListener ) ((FormativeExamGrammarListener)listener).exitShort_answer_solution(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormativeExamGrammarVisitor ) return ((FormativeExamGrammarVisitor<? extends T>)visitor).visitShort_answer_solution(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Short_answer_solutionContext short_answer_solution() throws RecognitionException {
		Short_answer_solutionContext _localctx = new Short_answer_solutionContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_short_answer_solution);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(258);
			match(SOLUTION_ENTRY);
			setState(259);
			phrase();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Numerical_questionContext extends ParserRuleContext {
		public TerminalNode HASH() { return getToken(FormativeExamGrammarParser.HASH, 0); }
		public TerminalNode N_Q() { return getToken(FormativeExamGrammarParser.N_Q, 0); }
		public PointsContext points() {
			return getRuleContext(PointsContext.class,0);
		}
		public QuestionContext question() {
			return getRuleContext(QuestionContext.class,0);
		}
		public Numerical_answerContext numerical_answer() {
			return getRuleContext(Numerical_answerContext.class,0);
		}
		public Numerical_solutionContext numerical_solution() {
			return getRuleContext(Numerical_solutionContext.class,0);
		}
		public FeedbackContext feedback() {
			return getRuleContext(FeedbackContext.class,0);
		}
		public Numerical_questionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numerical_question; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamGrammarListener ) ((FormativeExamGrammarListener)listener).enterNumerical_question(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamGrammarListener ) ((FormativeExamGrammarListener)listener).exitNumerical_question(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormativeExamGrammarVisitor ) return ((FormativeExamGrammarVisitor<? extends T>)visitor).visitNumerical_question(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Numerical_questionContext numerical_question() throws RecognitionException {
		Numerical_questionContext _localctx = new Numerical_questionContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_numerical_question);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(261);
			match(HASH);
			setState(262);
			match(N_Q);
			setState(263);
			points();
			setState(264);
			question();
			setState(265);
			numerical_answer();
			setState(266);
			numerical_solution();
			setState(268);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				{
				setState(267);
				feedback();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Numerical_answerContext extends ParserRuleContext {
		public TerminalNode ANSWER_ENTRY() { return getToken(FormativeExamGrammarParser.ANSWER_ENTRY, 0); }
		public TerminalNode WORD() { return getToken(FormativeExamGrammarParser.WORD, 0); }
		public TerminalNode INT() { return getToken(FormativeExamGrammarParser.INT, 0); }
		public TerminalNode NUMERICAL_VALUE() { return getToken(FormativeExamGrammarParser.NUMERICAL_VALUE, 0); }
		public Numerical_answerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numerical_answer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamGrammarListener ) ((FormativeExamGrammarListener)listener).enterNumerical_answer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamGrammarListener ) ((FormativeExamGrammarListener)listener).exitNumerical_answer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormativeExamGrammarVisitor ) return ((FormativeExamGrammarVisitor<? extends T>)visitor).visitNumerical_answer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Numerical_answerContext numerical_answer() throws RecognitionException {
		Numerical_answerContext _localctx = new Numerical_answerContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_numerical_answer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(270);
			match(ANSWER_ENTRY);
			setState(273);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==INT || _la==NUMERICAL_VALUE) {
				{
				setState(271);
				_la = _input.LA(1);
				if ( !(_la==INT || _la==NUMERICAL_VALUE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(272);
				match(WORD);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Numerical_solutionContext extends ParserRuleContext {
		public TerminalNode SOLUTION_ENTRY() { return getToken(FormativeExamGrammarParser.SOLUTION_ENTRY, 0); }
		public TerminalNode WORD() { return getToken(FormativeExamGrammarParser.WORD, 0); }
		public TerminalNode INT() { return getToken(FormativeExamGrammarParser.INT, 0); }
		public TerminalNode NUMERICAL_VALUE() { return getToken(FormativeExamGrammarParser.NUMERICAL_VALUE, 0); }
		public Numerical_solutionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numerical_solution; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamGrammarListener ) ((FormativeExamGrammarListener)listener).enterNumerical_solution(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamGrammarListener ) ((FormativeExamGrammarListener)listener).exitNumerical_solution(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormativeExamGrammarVisitor ) return ((FormativeExamGrammarVisitor<? extends T>)visitor).visitNumerical_solution(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Numerical_solutionContext numerical_solution() throws RecognitionException {
		Numerical_solutionContext _localctx = new Numerical_solutionContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_numerical_solution);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(275);
			match(SOLUTION_ENTRY);
			setState(276);
			_la = _input.LA(1);
			if ( !(_la==INT || _la==NUMERICAL_VALUE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(277);
			match(WORD);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class QuestionContext extends ParserRuleContext {
		public TerminalNode QUESTION_ENTRY() { return getToken(FormativeExamGrammarParser.QUESTION_ENTRY, 0); }
		public PhraseContext phrase() {
			return getRuleContext(PhraseContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(FormativeExamGrammarParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(FormativeExamGrammarParser.NEWLINE, i);
		}
		public QuestionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_question; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamGrammarListener ) ((FormativeExamGrammarListener)listener).enterQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamGrammarListener ) ((FormativeExamGrammarListener)listener).exitQuestion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormativeExamGrammarVisitor ) return ((FormativeExamGrammarVisitor<? extends T>)visitor).visitQuestion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuestionContext question() throws RecognitionException {
		QuestionContext _localctx = new QuestionContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_question);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(280); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(279);
				match(NEWLINE);
				}
				}
				setState(282); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			setState(284);
			match(QUESTION_ENTRY);
			setState(285);
			phrase();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PointsContext extends ParserRuleContext {
		public TerminalNode POINTS_ENTRY() { return getToken(FormativeExamGrammarParser.POINTS_ENTRY, 0); }
		public TerminalNode INT() { return getToken(FormativeExamGrammarParser.INT, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(FormativeExamGrammarParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(FormativeExamGrammarParser.NEWLINE, i);
		}
		public PointsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_points; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamGrammarListener ) ((FormativeExamGrammarListener)listener).enterPoints(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamGrammarListener ) ((FormativeExamGrammarListener)listener).exitPoints(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormativeExamGrammarVisitor ) return ((FormativeExamGrammarVisitor<? extends T>)visitor).visitPoints(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PointsContext points() throws RecognitionException {
		PointsContext _localctx = new PointsContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_points);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(288); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(287);
				match(NEWLINE);
				}
				}
				setState(290); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			setState(292);
			match(POINTS_ENTRY);
			setState(293);
			match(INT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FeedbackContext extends ParserRuleContext {
		public TerminalNode FEEDBACK_ENTRY() { return getToken(FormativeExamGrammarParser.FEEDBACK_ENTRY, 0); }
		public PhraseContext phrase() {
			return getRuleContext(PhraseContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(FormativeExamGrammarParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(FormativeExamGrammarParser.NEWLINE, i);
		}
		public FeedbackContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_feedback; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamGrammarListener ) ((FormativeExamGrammarListener)listener).enterFeedback(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamGrammarListener ) ((FormativeExamGrammarListener)listener).exitFeedback(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormativeExamGrammarVisitor ) return ((FormativeExamGrammarVisitor<? extends T>)visitor).visitFeedback(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FeedbackContext feedback() throws RecognitionException {
		FeedbackContext _localctx = new FeedbackContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_feedback);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(296); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(295);
				match(NEWLINE);
				}
				}
				setState(298); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			setState(300);
			match(FEEDBACK_ENTRY);
			setState(301);
			phrase();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PhraseContext extends ParserRuleContext {
		public List<Phrase_wordContext> phrase_word() {
			return getRuleContexts(Phrase_wordContext.class);
		}
		public Phrase_wordContext phrase_word(int i) {
			return getRuleContext(Phrase_wordContext.class,i);
		}
		public PhraseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_phrase; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamGrammarListener ) ((FormativeExamGrammarListener)listener).enterPhrase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamGrammarListener ) ((FormativeExamGrammarListener)listener).exitPhrase(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormativeExamGrammarVisitor ) return ((FormativeExamGrammarVisitor<? extends T>)visitor).visitPhrase(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PhraseContext phrase() throws RecognitionException {
		PhraseContext _localctx = new PhraseContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_phrase);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(304); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(303);
					phrase_word();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(306); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Phrase_wordContext extends ParserRuleContext {
		public TerminalNode WORD() { return getToken(FormativeExamGrammarParser.WORD, 0); }
		public TerminalNode INT() { return getToken(FormativeExamGrammarParser.INT, 0); }
		public TerminalNode PUNCTUATION() { return getToken(FormativeExamGrammarParser.PUNCTUATION, 0); }
		public TerminalNode COMMA() { return getToken(FormativeExamGrammarParser.COMMA, 0); }
		public TerminalNode HASH() { return getToken(FormativeExamGrammarParser.HASH, 0); }
		public TerminalNode COLON() { return getToken(FormativeExamGrammarParser.COLON, 0); }
		public TerminalNode DASH() { return getToken(FormativeExamGrammarParser.DASH, 0); }
		public Phrase_wordContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_phrase_word; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamGrammarListener ) ((FormativeExamGrammarListener)listener).enterPhrase_word(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamGrammarListener ) ((FormativeExamGrammarListener)listener).exitPhrase_word(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormativeExamGrammarVisitor ) return ((FormativeExamGrammarVisitor<? extends T>)visitor).visitPhrase_word(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Phrase_wordContext phrase_word() throws RecognitionException {
		Phrase_wordContext _localctx = new Phrase_wordContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_phrase_word);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(308);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 12402688L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class List_with_titleContext extends ParserRuleContext {
		public Title_listContext title_list() {
			return getRuleContext(Title_listContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(FormativeExamGrammarParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(FormativeExamGrammarParser.NEWLINE, i);
		}
		public ListContext list() {
			return getRuleContext(ListContext.class,0);
		}
		public List_with_titleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list_with_title; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamGrammarListener ) ((FormativeExamGrammarListener)listener).enterList_with_title(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamGrammarListener ) ((FormativeExamGrammarListener)listener).exitList_with_title(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormativeExamGrammarVisitor ) return ((FormativeExamGrammarVisitor<? extends T>)visitor).visitList_with_title(this);
			else return visitor.visitChildren(this);
		}
	}

	public final List_with_titleContext list_with_title() throws RecognitionException {
		List_with_titleContext _localctx = new List_with_titleContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_list_with_title);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(311); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(310);
				match(NEWLINE);
				}
				}
				setState(313); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			setState(315);
			title_list();
			setState(317);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
			case 1:
				{
				setState(316);
				list();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Title_listContext extends ParserRuleContext {
		public PhraseContext phrase() {
			return getRuleContext(PhraseContext.class,0);
		}
		public TerminalNode COLON() { return getToken(FormativeExamGrammarParser.COLON, 0); }
		public Title_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_title_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamGrammarListener ) ((FormativeExamGrammarListener)listener).enterTitle_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamGrammarListener ) ((FormativeExamGrammarListener)listener).exitTitle_list(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormativeExamGrammarVisitor ) return ((FormativeExamGrammarVisitor<? extends T>)visitor).visitTitle_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Title_listContext title_list() throws RecognitionException {
		Title_listContext _localctx = new Title_listContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_title_list);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(319);
			phrase();
			setState(320);
			match(COLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ListContext extends ParserRuleContext {
		public List<Topic_listContext> topic_list() {
			return getRuleContexts(Topic_listContext.class);
		}
		public Topic_listContext topic_list(int i) {
			return getRuleContext(Topic_listContext.class,i);
		}
		public ListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamGrammarListener ) ((FormativeExamGrammarListener)listener).enterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamGrammarListener ) ((FormativeExamGrammarListener)listener).exitList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormativeExamGrammarVisitor ) return ((FormativeExamGrammarVisitor<? extends T>)visitor).visitList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListContext list() throws RecognitionException {
		ListContext _localctx = new ListContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_list);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(323); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(322);
					topic_list();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(325); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Topic_listContext extends ParserRuleContext {
		public TerminalNode DASH() { return getToken(FormativeExamGrammarParser.DASH, 0); }
		public PhraseContext phrase() {
			return getRuleContext(PhraseContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(FormativeExamGrammarParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(FormativeExamGrammarParser.NEWLINE, i);
		}
		public Topic_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_topic_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamGrammarListener ) ((FormativeExamGrammarListener)listener).enterTopic_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamGrammarListener ) ((FormativeExamGrammarListener)listener).exitTopic_list(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormativeExamGrammarVisitor ) return ((FormativeExamGrammarVisitor<? extends T>)visitor).visitTopic_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Topic_listContext topic_list() throws RecognitionException {
		Topic_listContext _localctx = new Topic_listContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_topic_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(328); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(327);
				match(NEWLINE);
				}
				}
				setState(330); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			setState(332);
			match(DASH);
			setState(333);
			phrase();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u0018\u0150\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007"+
		"\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007"+
		"\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007"+
		"\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007"+
		"\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007"+
		"\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0004\u0000@\b\u0000\u000b\u0000\f\u0000A\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0004\u0000G\b\u0000\u000b\u0000\f\u0000H\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0004\u0000N\b\u0000\u000b\u0000\f\u0000"+
		"O\u0001\u0000\u0001\u0000\u0001\u0000\u0004\u0000U\b\u0000\u000b\u0000"+
		"\f\u0000V\u0001\u0000\u0001\u0000\u0001\u0000\u0004\u0000\\\b\u0000\u000b"+
		"\u0000\f\u0000]\u0001\u0000\u0001\u0000\u0001\u0000\u0004\u0000c\b\u0000"+
		"\u000b\u0000\f\u0000d\u0003\u0000g\b\u0000\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003"+
		"\u0001q\b\u0001\u0001\u0002\u0001\u0002\u0003\u0002u\b\u0002\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004"+
		"\u0083\b\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005\u008e\b\u0005"+
		"\n\u0005\f\u0005\u0091\t\u0005\u0003\u0005\u0093\b\u0005\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0005\u0006\u009e\b\u0006\n\u0006\f\u0006\u00a1\t\u0006"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0003\u0007\u00aa\b\u0007\u0001\b\u0001\b\u0003\b\u00ae\b"+
		"\b\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0004\n\u00b9\b\n\u000b\n\f\n\u00ba\u0001\n\u0001\n\u0001\n\u0003\n"+
		"\u00c0\b\n\u0001\u000b\u0004\u000b\u00c3\b\u000b\u000b\u000b\f\u000b\u00c4"+
		"\u0001\u000b\u0003\u000b\u00c8\b\u000b\u0001\u000b\u0001\u000b\u0004\u000b"+
		"\u00cc\b\u000b\u000b\u000b\f\u000b\u00cd\u0001\u000b\u0003\u000b\u00d1"+
		"\b\u000b\u0001\u000b\u0004\u000b\u00d4\b\u000b\u000b\u000b\f\u000b\u00d5"+
		"\u0001\u000b\u0003\u000b\u00d9\b\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0004\u000b\u00de\b\u000b\u000b\u000b\f\u000b\u00df\u0001\u000b\u0003"+
		"\u000b\u00e3\b\u000b\u0003\u000b\u00e5\b\u000b\u0001\f\u0001\f\u0003\f"+
		"\u00e9\b\f\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0005\u000e\u00f1\b\u000e\n\u000e\f\u000e\u00f4\t\u000e\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0003"+
		"\u000f\u00fd\b\u000f\u0001\u0010\u0001\u0010\u0003\u0010\u0101\b\u0010"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0003\u0012\u010d\b\u0012"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0003\u0013\u0112\b\u0013\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0015\u0004\u0015\u0119\b\u0015"+
		"\u000b\u0015\f\u0015\u011a\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0016"+
		"\u0004\u0016\u0121\b\u0016\u000b\u0016\f\u0016\u0122\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0017\u0004\u0017\u0129\b\u0017\u000b\u0017\f"+
		"\u0017\u012a\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0018\u0004\u0018"+
		"\u0131\b\u0018\u000b\u0018\f\u0018\u0132\u0001\u0019\u0001\u0019\u0001"+
		"\u001a\u0004\u001a\u0138\b\u001a\u000b\u001a\f\u001a\u0139\u0001\u001a"+
		"\u0001\u001a\u0003\u001a\u013e\b\u001a\u0001\u001b\u0001\u001b\u0001\u001b"+
		"\u0001\u001c\u0004\u001c\u0144\b\u001c\u000b\u001c\f\u001c\u0145\u0001"+
		"\u001d\u0004\u001d\u0149\b\u001d\u000b\u001d\f\u001d\u014a\u0001\u001d"+
		"\u0001\u001d\u0001\u001d\u0001\u001d\u0000\u0000\u001e\u0000\u0002\u0004"+
		"\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \""+
		"$&(*,.02468:\u0000\u0002\u0001\u0000\u0015\u0016\u0004\u0000\u000e\u000e"+
		"\u0010\u0010\u0012\u0015\u0017\u0017\u015d\u0000f\u0001\u0000\u0000\u0000"+
		"\u0002h\u0001\u0000\u0000\u0000\u0004r\u0001\u0000\u0000\u0000\u0006v"+
		"\u0001\u0000\u0000\u0000\by\u0001\u0000\u0000\u0000\n\u0084\u0001\u0000"+
		"\u0000\u0000\f\u0094\u0001\u0000\u0000\u0000\u000e\u00a2\u0001\u0000\u0000"+
		"\u0000\u0010\u00ab\u0001\u0000\u0000\u0000\u0012\u00af\u0001\u0000\u0000"+
		"\u0000\u0014\u00b2\u0001\u0000\u0000\u0000\u0016\u00e4\u0001\u0000\u0000"+
		"\u0000\u0018\u00e6\u0001\u0000\u0000\u0000\u001a\u00ea\u0001\u0000\u0000"+
		"\u0000\u001c\u00ed\u0001\u0000\u0000\u0000\u001e\u00f5\u0001\u0000\u0000"+
		"\u0000 \u00fe\u0001\u0000\u0000\u0000\"\u0102\u0001\u0000\u0000\u0000"+
		"$\u0105\u0001\u0000\u0000\u0000&\u010e\u0001\u0000\u0000\u0000(\u0113"+
		"\u0001\u0000\u0000\u0000*\u0118\u0001\u0000\u0000\u0000,\u0120\u0001\u0000"+
		"\u0000\u0000.\u0128\u0001\u0000\u0000\u00000\u0130\u0001\u0000\u0000\u0000"+
		"2\u0134\u0001\u0000\u0000\u00004\u0137\u0001\u0000\u0000\u00006\u013f"+
		"\u0001\u0000\u0000\u00008\u0143\u0001\u0000\u0000\u0000:\u0148\u0001\u0000"+
		"\u0000\u0000<=\u0003\b\u0004\u0000=>\u0005\u0011\u0000\u0000>@\u0001\u0000"+
		"\u0000\u0000?<\u0001\u0000\u0000\u0000@A\u0001\u0000\u0000\u0000A?\u0001"+
		"\u0000\u0000\u0000AB\u0001\u0000\u0000\u0000Bg\u0001\u0000\u0000\u0000"+
		"CD\u0003\u0014\n\u0000DE\u0005\u0011\u0000\u0000EG\u0001\u0000\u0000\u0000"+
		"FC\u0001\u0000\u0000\u0000GH\u0001\u0000\u0000\u0000HF\u0001\u0000\u0000"+
		"\u0000HI\u0001\u0000\u0000\u0000Ig\u0001\u0000\u0000\u0000JK\u0003\u000e"+
		"\u0007\u0000KL\u0005\u0011\u0000\u0000LN\u0001\u0000\u0000\u0000MJ\u0001"+
		"\u0000\u0000\u0000NO\u0001\u0000\u0000\u0000OM\u0001\u0000\u0000\u0000"+
		"OP\u0001\u0000\u0000\u0000Pg\u0001\u0000\u0000\u0000QR\u0003\u0002\u0001"+
		"\u0000RS\u0005\u0011\u0000\u0000SU\u0001\u0000\u0000\u0000TQ\u0001\u0000"+
		"\u0000\u0000UV\u0001\u0000\u0000\u0000VT\u0001\u0000\u0000\u0000VW\u0001"+
		"\u0000\u0000\u0000Wg\u0001\u0000\u0000\u0000XY\u0003\u001e\u000f\u0000"+
		"YZ\u0005\u0011\u0000\u0000Z\\\u0001\u0000\u0000\u0000[X\u0001\u0000\u0000"+
		"\u0000\\]\u0001\u0000\u0000\u0000][\u0001\u0000\u0000\u0000]^\u0001\u0000"+
		"\u0000\u0000^g\u0001\u0000\u0000\u0000_`\u0003$\u0012\u0000`a\u0005\u0011"+
		"\u0000\u0000ac\u0001\u0000\u0000\u0000b_\u0001\u0000\u0000\u0000cd\u0001"+
		"\u0000\u0000\u0000db\u0001\u0000\u0000\u0000de\u0001\u0000\u0000\u0000"+
		"eg\u0001\u0000\u0000\u0000f?\u0001\u0000\u0000\u0000fF\u0001\u0000\u0000"+
		"\u0000fM\u0001\u0000\u0000\u0000fT\u0001\u0000\u0000\u0000f[\u0001\u0000"+
		"\u0000\u0000fb\u0001\u0000\u0000\u0000g\u0001\u0001\u0000\u0000\u0000"+
		"hi\u0005\u0010\u0000\u0000ij\u0005\u0007\u0000\u0000jk\u0003,\u0016\u0000"+
		"kl\u0003*\u0015\u0000lm\u00034\u001a\u0000mn\u0003\u0004\u0002\u0000n"+
		"p\u0003\u0006\u0003\u0000oq\u0003.\u0017\u0000po\u0001\u0000\u0000\u0000"+
		"pq\u0001\u0000\u0000\u0000q\u0003\u0001\u0000\u0000\u0000rt\u0005\u0001"+
		"\u0000\u0000su\u0003\u001c\u000e\u0000ts\u0001\u0000\u0000\u0000tu\u0001"+
		"\u0000\u0000\u0000u\u0005\u0001\u0000\u0000\u0000vw\u0005\u0002\u0000"+
		"\u0000wx\u0003\u001c\u000e\u0000x\u0007\u0001\u0000\u0000\u0000yz\u0005"+
		"\u0010\u0000\u0000z{\u0005\f\u0000\u0000{|\u0003,\u0016\u0000|}\u0003"+
		"*\u0015\u0000}~\u00034\u001a\u0000~\u007f\u00034\u001a\u0000\u007f\u0080"+
		"\u0003\n\u0005\u0000\u0080\u0082\u0003\f\u0006\u0000\u0081\u0083\u0003"+
		".\u0017\u0000\u0082\u0081\u0001\u0000\u0000\u0000\u0082\u0083\u0001\u0000"+
		"\u0000\u0000\u0083\t\u0001\u0000\u0000\u0000\u0084\u0092\u0005\u0001\u0000"+
		"\u0000\u0085\u0086\u00030\u0018\u0000\u0086\u0087\u0005\u0014\u0000\u0000"+
		"\u0087\u008f\u00030\u0018\u0000\u0088\u0089\u0005\u000e\u0000\u0000\u0089"+
		"\u008a\u00030\u0018\u0000\u008a\u008b\u0005\u0014\u0000\u0000\u008b\u008c"+
		"\u00030\u0018\u0000\u008c\u008e\u0001\u0000\u0000\u0000\u008d\u0088\u0001"+
		"\u0000\u0000\u0000\u008e\u0091\u0001\u0000\u0000\u0000\u008f\u008d\u0001"+
		"\u0000\u0000\u0000\u008f\u0090\u0001\u0000\u0000\u0000\u0090\u0093\u0001"+
		"\u0000\u0000\u0000\u0091\u008f\u0001\u0000\u0000\u0000\u0092\u0085\u0001"+
		"\u0000\u0000\u0000\u0092\u0093\u0001\u0000\u0000\u0000\u0093\u000b\u0001"+
		"\u0000\u0000\u0000\u0094\u0095\u0005\u0002\u0000\u0000\u0095\u0096\u0003"+
		"0\u0018\u0000\u0096\u0097\u0005\u0014\u0000\u0000\u0097\u009f\u00030\u0018"+
		"\u0000\u0098\u0099\u0005\u000e\u0000\u0000\u0099\u009a\u00030\u0018\u0000"+
		"\u009a\u009b\u0005\u0014\u0000\u0000\u009b\u009c\u00030\u0018\u0000\u009c"+
		"\u009e\u0001\u0000\u0000\u0000\u009d\u0098\u0001\u0000\u0000\u0000\u009e"+
		"\u00a1\u0001\u0000\u0000\u0000\u009f\u009d\u0001\u0000\u0000\u0000\u009f"+
		"\u00a0\u0001\u0000\u0000\u0000\u00a0\r\u0001\u0000\u0000\u0000\u00a1\u009f"+
		"\u0001\u0000\u0000\u0000\u00a2\u00a3\u0005\u0010\u0000\u0000\u00a3\u00a4"+
		"\u0005\u000b\u0000\u0000\u00a4\u00a5\u0003,\u0016\u0000\u00a5\u00a6\u0003"+
		"*\u0015\u0000\u00a6\u00a7\u0003\u0010\b\u0000\u00a7\u00a9\u0003\u0012"+
		"\t\u0000\u00a8\u00aa\u0003.\u0017\u0000\u00a9\u00a8\u0001\u0000\u0000"+
		"\u0000\u00a9\u00aa\u0001\u0000\u0000\u0000\u00aa\u000f\u0001\u0000\u0000"+
		"\u0000\u00ab\u00ad\u0005\u0001\u0000\u0000\u00ac\u00ae\u0005\u0003\u0000"+
		"\u0000\u00ad\u00ac\u0001\u0000\u0000\u0000\u00ad\u00ae\u0001\u0000\u0000"+
		"\u0000\u00ae\u0011\u0001\u0000\u0000\u0000\u00af\u00b0\u0005\u0002\u0000"+
		"\u0000\u00b0\u00b1\u0005\u0003\u0000\u0000\u00b1\u0013\u0001\u0000\u0000"+
		"\u0000\u00b2\u00b3\u0005\u0010\u0000\u0000\u00b3\u00b4\u0005\n\u0000\u0000"+
		"\u00b4\u00b5\u0003,\u0016\u0000\u00b5\u00b6\u0003*\u0015\u0000\u00b6\u00b8"+
		"\u0003\u0016\u000b\u0000\u00b7\u00b9\u00034\u001a\u0000\u00b8\u00b7\u0001"+
		"\u0000\u0000\u0000\u00b9\u00ba\u0001\u0000\u0000\u0000\u00ba\u00b8\u0001"+
		"\u0000\u0000\u0000\u00ba\u00bb\u0001\u0000\u0000\u0000\u00bb\u00bc\u0001"+
		"\u0000\u0000\u0000\u00bc\u00bd\u0003\u0018\f\u0000\u00bd\u00bf\u0003\u001a"+
		"\r\u0000\u00be\u00c0\u0003.\u0017\u0000\u00bf\u00be\u0001\u0000\u0000"+
		"\u0000\u00bf\u00c0\u0001\u0000\u0000\u0000\u00c0\u0015\u0001\u0000\u0000"+
		"\u0000\u00c1\u00c3\u0005\u0011\u0000\u0000\u00c2\u00c1\u0001\u0000\u0000"+
		"\u0000\u00c3\u00c4\u0001\u0000\u0000\u0000\u00c4\u00c2\u0001\u0000\u0000"+
		"\u0000\u00c4\u00c5\u0001\u0000\u0000\u0000\u00c5\u00c7\u0001\u0000\u0000"+
		"\u0000\u00c6\u00c8\u00030\u0018\u0000\u00c7\u00c6\u0001\u0000\u0000\u0000"+
		"\u00c7\u00c8\u0001\u0000\u0000\u0000\u00c8\u00cb\u0001\u0000\u0000\u0000"+
		"\u00c9\u00ca\u0005\u0018\u0000\u0000\u00ca\u00cc\u00030\u0018\u0000\u00cb"+
		"\u00c9\u0001\u0000\u0000\u0000\u00cc\u00cd\u0001\u0000\u0000\u0000\u00cd"+
		"\u00cb\u0001\u0000\u0000\u0000\u00cd\u00ce\u0001\u0000\u0000\u0000\u00ce"+
		"\u00d0\u0001\u0000\u0000\u0000\u00cf\u00d1\u0005\u0018\u0000\u0000\u00d0"+
		"\u00cf\u0001\u0000\u0000\u0000\u00d0\u00d1\u0001\u0000\u0000\u0000\u00d1"+
		"\u00e5\u0001\u0000\u0000\u0000\u00d2\u00d4\u0005\u0011\u0000\u0000\u00d3"+
		"\u00d2\u0001\u0000\u0000\u0000\u00d4\u00d5\u0001\u0000\u0000\u0000\u00d5"+
		"\u00d3\u0001\u0000\u0000\u0000\u00d5\u00d6\u0001\u0000\u0000\u0000\u00d6"+
		"\u00d8\u0001\u0000\u0000\u0000\u00d7\u00d9\u0005\u0018\u0000\u0000\u00d8"+
		"\u00d7\u0001\u0000\u0000\u0000\u00d8\u00d9\u0001\u0000\u0000\u0000\u00d9"+
		"\u00dd\u0001\u0000\u0000\u0000\u00da\u00db\u00030\u0018\u0000\u00db\u00dc"+
		"\u0005\u0018\u0000\u0000\u00dc\u00de\u0001\u0000\u0000\u0000\u00dd\u00da"+
		"\u0001\u0000\u0000\u0000\u00de\u00df\u0001\u0000\u0000\u0000\u00df\u00dd"+
		"\u0001\u0000\u0000\u0000\u00df\u00e0\u0001\u0000\u0000\u0000\u00e0\u00e2"+
		"\u0001\u0000\u0000\u0000\u00e1\u00e3\u00030\u0018\u0000\u00e2\u00e1\u0001"+
		"\u0000\u0000\u0000\u00e2\u00e3\u0001\u0000\u0000\u0000\u00e3\u00e5\u0001"+
		"\u0000\u0000\u0000\u00e4\u00c2\u0001\u0000\u0000\u0000\u00e4\u00d3\u0001"+
		"\u0000\u0000\u0000\u00e5\u0017\u0001\u0000\u0000\u0000\u00e6\u00e8\u0005"+
		"\u0001\u0000\u0000\u00e7\u00e9\u0003\u001c\u000e\u0000\u00e8\u00e7\u0001"+
		"\u0000\u0000\u0000\u00e8\u00e9\u0001\u0000\u0000\u0000\u00e9\u0019\u0001"+
		"\u0000\u0000\u0000\u00ea\u00eb\u0005\u0002\u0000\u0000\u00eb\u00ec\u0003"+
		"\u001c\u000e\u0000\u00ec\u001b\u0001\u0000\u0000\u0000\u00ed\u00f2\u0003"+
		"0\u0018\u0000\u00ee\u00ef\u0005\u000e\u0000\u0000\u00ef\u00f1\u00030\u0018"+
		"\u0000\u00f0\u00ee\u0001\u0000\u0000\u0000\u00f1\u00f4\u0001\u0000\u0000"+
		"\u0000\u00f2\u00f0\u0001\u0000\u0000\u0000\u00f2\u00f3\u0001\u0000\u0000"+
		"\u0000\u00f3\u001d\u0001\u0000\u0000\u0000\u00f4\u00f2\u0001\u0000\u0000"+
		"\u0000\u00f5\u00f6\u0005\u0010\u0000\u0000\u00f6\u00f7\u0005\t\u0000\u0000"+
		"\u00f7\u00f8\u0003,\u0016\u0000\u00f8\u00f9\u0003*\u0015\u0000\u00f9\u00fa"+
		"\u0003 \u0010\u0000\u00fa\u00fc\u0003\"\u0011\u0000\u00fb\u00fd\u0003"+
		".\u0017\u0000\u00fc\u00fb\u0001\u0000\u0000\u0000\u00fc\u00fd\u0001\u0000"+
		"\u0000\u0000\u00fd\u001f\u0001\u0000\u0000\u0000\u00fe\u0100\u0005\u0001"+
		"\u0000\u0000\u00ff\u0101\u00030\u0018\u0000\u0100\u00ff\u0001\u0000\u0000"+
		"\u0000\u0100\u0101\u0001\u0000\u0000\u0000\u0101!\u0001\u0000\u0000\u0000"+
		"\u0102\u0103\u0005\u0002\u0000\u0000\u0103\u0104\u00030\u0018\u0000\u0104"+
		"#\u0001\u0000\u0000\u0000\u0105\u0106\u0005\u0010\u0000\u0000\u0106\u0107"+
		"\u0005\b\u0000\u0000\u0107\u0108\u0003,\u0016\u0000\u0108\u0109\u0003"+
		"*\u0015\u0000\u0109\u010a\u0003&\u0013\u0000\u010a\u010c\u0003(\u0014"+
		"\u0000\u010b\u010d\u0003.\u0017\u0000\u010c\u010b\u0001\u0000\u0000\u0000"+
		"\u010c\u010d\u0001\u0000\u0000\u0000\u010d%\u0001\u0000\u0000\u0000\u010e"+
		"\u0111\u0005\u0001\u0000\u0000\u010f\u0110\u0007\u0000\u0000\u0000\u0110"+
		"\u0112\u0005\u0012\u0000\u0000\u0111\u010f\u0001\u0000\u0000\u0000\u0111"+
		"\u0112\u0001\u0000\u0000\u0000\u0112\'\u0001\u0000\u0000\u0000\u0113\u0114"+
		"\u0005\u0002\u0000\u0000\u0114\u0115\u0007\u0000\u0000\u0000\u0115\u0116"+
		"\u0005\u0012\u0000\u0000\u0116)\u0001\u0000\u0000\u0000\u0117\u0119\u0005"+
		"\u0011\u0000\u0000\u0118\u0117\u0001\u0000\u0000\u0000\u0119\u011a\u0001"+
		"\u0000\u0000\u0000\u011a\u0118\u0001\u0000\u0000\u0000\u011a\u011b\u0001"+
		"\u0000\u0000\u0000\u011b\u011c\u0001\u0000\u0000\u0000\u011c\u011d\u0005"+
		"\u0005\u0000\u0000\u011d\u011e\u00030\u0018\u0000\u011e+\u0001\u0000\u0000"+
		"\u0000\u011f\u0121\u0005\u0011\u0000\u0000\u0120\u011f\u0001\u0000\u0000"+
		"\u0000\u0121\u0122\u0001\u0000\u0000\u0000\u0122\u0120\u0001\u0000\u0000"+
		"\u0000\u0122\u0123\u0001\u0000\u0000\u0000\u0123\u0124\u0001\u0000\u0000"+
		"\u0000\u0124\u0125\u0005\u0006\u0000\u0000\u0125\u0126\u0005\u0015\u0000"+
		"\u0000\u0126-\u0001\u0000\u0000\u0000\u0127\u0129\u0005\u0011\u0000\u0000"+
		"\u0128\u0127\u0001\u0000\u0000\u0000\u0129\u012a\u0001\u0000\u0000\u0000"+
		"\u012a\u0128\u0001\u0000\u0000\u0000\u012a\u012b\u0001\u0000\u0000\u0000"+
		"\u012b\u012c\u0001\u0000\u0000\u0000\u012c\u012d\u0005\u0004\u0000\u0000"+
		"\u012d\u012e\u00030\u0018\u0000\u012e/\u0001\u0000\u0000\u0000\u012f\u0131"+
		"\u00032\u0019\u0000\u0130\u012f\u0001\u0000\u0000\u0000\u0131\u0132\u0001"+
		"\u0000\u0000\u0000\u0132\u0130\u0001\u0000\u0000\u0000\u0132\u0133\u0001"+
		"\u0000\u0000\u0000\u01331\u0001\u0000\u0000\u0000\u0134\u0135\u0007\u0001"+
		"\u0000\u0000\u01353\u0001\u0000\u0000\u0000\u0136\u0138\u0005\u0011\u0000"+
		"\u0000\u0137\u0136\u0001\u0000\u0000\u0000\u0138\u0139\u0001\u0000\u0000"+
		"\u0000\u0139\u0137\u0001\u0000\u0000\u0000\u0139\u013a\u0001\u0000\u0000"+
		"\u0000\u013a\u013b\u0001\u0000\u0000\u0000\u013b\u013d\u00036\u001b\u0000"+
		"\u013c\u013e\u00038\u001c\u0000\u013d\u013c\u0001\u0000\u0000\u0000\u013d"+
		"\u013e\u0001\u0000\u0000\u0000\u013e5\u0001\u0000\u0000\u0000\u013f\u0140"+
		"\u00030\u0018\u0000\u0140\u0141\u0005\u0013\u0000\u0000\u01417\u0001\u0000"+
		"\u0000\u0000\u0142\u0144\u0003:\u001d\u0000\u0143\u0142\u0001\u0000\u0000"+
		"\u0000\u0144\u0145\u0001\u0000\u0000\u0000\u0145\u0143\u0001\u0000\u0000"+
		"\u0000\u0145\u0146\u0001\u0000\u0000\u0000\u01469\u0001\u0000\u0000\u0000"+
		"\u0147\u0149\u0005\u0011\u0000\u0000\u0148\u0147\u0001\u0000\u0000\u0000"+
		"\u0149\u014a\u0001\u0000\u0000\u0000\u014a\u0148\u0001\u0000\u0000\u0000"+
		"\u014a\u014b\u0001\u0000\u0000\u0000\u014b\u014c\u0001\u0000\u0000\u0000"+
		"\u014c\u014d\u0005\u0014\u0000\u0000\u014d\u014e\u00030\u0018\u0000\u014e"+
		";\u0001\u0000\u0000\u0000(AHOV]dfpt\u0082\u008f\u0092\u009f\u00a9\u00ad"+
		"\u00ba\u00bf\u00c4\u00c7\u00cd\u00d0\u00d5\u00d8\u00df\u00e2\u00e4\u00e8"+
		"\u00f2\u00fc\u0100\u010c\u0111\u011a\u0122\u012a\u0132\u0139\u013d\u0145"+
		"\u014a";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}