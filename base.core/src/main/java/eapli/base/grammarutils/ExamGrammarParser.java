// Generated from C:/Uni/2A/sem4pi-22-23-24/base.core/src/main/antlr4\ExamGrammar.g4 by ANTLR 4.12.0
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
public class ExamGrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.12.0", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ANSWER_ENTRY=1, SOLUTION_ENTRY=2, TRUE_FALSE_RESPONSES=3, TITLE_ENTRY=4, 
		SECTION_ENTRY=5, SECTION_DESCRIPTION_ENTRY=6, FEEDBACK_ENTRY=7, QUESTION_ENTRY=8, 
		POINTS_ENTRY=9, TYPE_OF_GRADE_ENTRY=10, TYPE_OF_FEEDBACK_ENTRY=11, HEADER_DESCRIPTION_ENTRY=12, 
		WITH_PARAM=13, WITHOUT_PARAM=14, COMMA=15, WS=16, HASH=17, NEWLINE=18, 
		WORD=19, COLON=20, DASH=21, INT=22, NUMERICAL_VALUE=23, PUNCTUATION=24, 
		MISSING_WORD=25;
	public static final int
		RULE_prog = 0, RULE_question_type_with_feedback = 1, RULE_question_type_without_feedback = 2, 
		RULE_type_of_grade = 3, RULE_type_of_feedback = 4, RULE_header_description = 5, 
		RULE_multiple_choice_question = 6, RULE_multiple_choice_answer = 7, RULE_multiple_choice_solution = 8, 
		RULE_matching_type_question = 9, RULE_matching_type_answer = 10, RULE_matching_type_solution = 11, 
		RULE_true_false_question = 12, RULE_true_false_answer = 13, RULE_true_false_solution = 14, 
		RULE_select_missing_words = 15, RULE_missing_word_phrase = 16, RULE_missing_word_answer = 17, 
		RULE_missing_word_solution = 18, RULE_list_phrases = 19, RULE_short_answer_question = 20, 
		RULE_short_answer_answer = 21, RULE_short_answer_solution = 22, RULE_numerical_question = 23, 
		RULE_numerical_answer = 24, RULE_numerical_solution = 25, RULE_question = 26, 
		RULE_points = 27, RULE_feedback = 28, RULE_phrase = 29, RULE_phrase_word = 30, 
		RULE_list_with_title = 31, RULE_title_list = 32, RULE_list = 33, RULE_topic_list = 34, 
		RULE_title = 35, RULE_section = 36;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "question_type_with_feedback", "question_type_without_feedback", 
			"type_of_grade", "type_of_feedback", "header_description", "multiple_choice_question", 
			"multiple_choice_answer", "multiple_choice_solution", "matching_type_question", 
			"matching_type_answer", "matching_type_solution", "true_false_question", 
			"true_false_answer", "true_false_solution", "select_missing_words", "missing_word_phrase", 
			"missing_word_answer", "missing_word_solution", "list_phrases", "short_answer_question", 
			"short_answer_answer", "short_answer_solution", "numerical_question", 
			"numerical_answer", "numerical_solution", "question", "points", "feedback", 
			"phrase", "phrase_word", "list_with_title", "title_list", "list", "topic_list", 
			"title", "section"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, "','", null, "'#'", null, null, "':'", "'-'", null, 
			null, null, "'||WORD||'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "ANSWER_ENTRY", "SOLUTION_ENTRY", "TRUE_FALSE_RESPONSES", "TITLE_ENTRY", 
			"SECTION_ENTRY", "SECTION_DESCRIPTION_ENTRY", "FEEDBACK_ENTRY", "QUESTION_ENTRY", 
			"POINTS_ENTRY", "TYPE_OF_GRADE_ENTRY", "TYPE_OF_FEEDBACK_ENTRY", "HEADER_DESCRIPTION_ENTRY", 
			"WITH_PARAM", "WITHOUT_PARAM", "COMMA", "WS", "HASH", "NEWLINE", "WORD", 
			"COLON", "DASH", "INT", "NUMERICAL_VALUE", "PUNCTUATION", "MISSING_WORD"
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
	public String getGrammarFileName() { return "ExamGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ExamGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgContext extends ParserRuleContext {
		public TitleContext title() {
			return getRuleContext(TitleContext.class,0);
		}
		public Type_of_gradeContext type_of_grade() {
			return getRuleContext(Type_of_gradeContext.class,0);
		}
		public Type_of_feedbackContext type_of_feedback() {
			return getRuleContext(Type_of_feedbackContext.class,0);
		}
		public TerminalNode WITH_PARAM() { return getToken(ExamGrammarParser.WITH_PARAM, 0); }
		public TerminalNode WITHOUT_PARAM() { return getToken(ExamGrammarParser.WITHOUT_PARAM, 0); }
		public Header_descriptionContext header_description() {
			return getRuleContext(Header_descriptionContext.class,0);
		}
		public List<SectionContext> section() {
			return getRuleContexts(SectionContext.class);
		}
		public SectionContext section(int i) {
			return getRuleContext(SectionContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(ExamGrammarParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ExamGrammarParser.NEWLINE, i);
		}
		public List<Question_type_with_feedbackContext> question_type_with_feedback() {
			return getRuleContexts(Question_type_with_feedbackContext.class);
		}
		public Question_type_with_feedbackContext question_type_with_feedback(int i) {
			return getRuleContext(Question_type_with_feedbackContext.class,i);
		}
		public List<Question_type_without_feedbackContext> question_type_without_feedback() {
			return getRuleContexts(Question_type_without_feedbackContext.class);
		}
		public Question_type_without_feedbackContext question_type_without_feedback(int i) {
			return getRuleContext(Question_type_without_feedbackContext.class,i);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).exitProg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamGrammarVisitor ) return ((ExamGrammarVisitor<? extends T>)visitor).visitProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			title();
			setState(75);
			type_of_grade();
			setState(76);
			type_of_feedback();
			setState(115);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case WITH_PARAM:
				{
				{
				setState(77);
				match(WITH_PARAM);
				setState(79);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(78);
					header_description();
					}
					break;
				}
				setState(92); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(82); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(81);
						match(NEWLINE);
						}
						}
						setState(84); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==NEWLINE );
					setState(86);
					section();
					setState(88); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(87);
							question_type_with_feedback();
							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(90); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					}
					}
					setState(94); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE );
				}
				}
				break;
			case WITHOUT_PARAM:
				{
				{
				setState(96);
				match(WITHOUT_PARAM);
				setState(98);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
				case 1:
					{
					setState(97);
					header_description();
					}
					break;
				}
				setState(111); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(101); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(100);
						match(NEWLINE);
						}
						}
						setState(103); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==NEWLINE );
					setState(105);
					section();
					setState(107); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(106);
							question_type_without_feedback();
							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(109); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					}
					}
					setState(113); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE );
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
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
	public static class Question_type_with_feedbackContext extends ParserRuleContext {
		public Matching_type_questionContext matching_type_question() {
			return getRuleContext(Matching_type_questionContext.class,0);
		}
		public FeedbackContext feedback() {
			return getRuleContext(FeedbackContext.class,0);
		}
		public Select_missing_wordsContext select_missing_words() {
			return getRuleContext(Select_missing_wordsContext.class,0);
		}
		public True_false_questionContext true_false_question() {
			return getRuleContext(True_false_questionContext.class,0);
		}
		public Multiple_choice_questionContext multiple_choice_question() {
			return getRuleContext(Multiple_choice_questionContext.class,0);
		}
		public Short_answer_questionContext short_answer_question() {
			return getRuleContext(Short_answer_questionContext.class,0);
		}
		public Numerical_questionContext numerical_question() {
			return getRuleContext(Numerical_questionContext.class,0);
		}
		public Question_type_with_feedbackContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_question_type_with_feedback; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).enterQuestion_type_with_feedback(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).exitQuestion_type_with_feedback(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamGrammarVisitor ) return ((ExamGrammarVisitor<? extends T>)visitor).visitQuestion_type_with_feedback(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Question_type_with_feedbackContext question_type_with_feedback() throws RecognitionException {
		Question_type_with_feedbackContext _localctx = new Question_type_with_feedbackContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_question_type_with_feedback);
		try {
			setState(141);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(117);
				matching_type_question();
				setState(119);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
				case 1:
					{
					setState(118);
					feedback();
					}
					break;
				}
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(121);
				select_missing_words();
				setState(123);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
				case 1:
					{
					setState(122);
					feedback();
					}
					break;
				}
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				{
				setState(125);
				true_false_question();
				setState(127);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
				case 1:
					{
					setState(126);
					feedback();
					}
					break;
				}
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				{
				setState(129);
				multiple_choice_question();
				setState(131);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
				case 1:
					{
					setState(130);
					feedback();
					}
					break;
				}
				}
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				{
				setState(133);
				short_answer_question();
				setState(135);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
				case 1:
					{
					setState(134);
					feedback();
					}
					break;
				}
				}
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				{
				setState(137);
				numerical_question();
				setState(139);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
				case 1:
					{
					setState(138);
					feedback();
					}
					break;
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
	public static class Question_type_without_feedbackContext extends ParserRuleContext {
		public Matching_type_questionContext matching_type_question() {
			return getRuleContext(Matching_type_questionContext.class,0);
		}
		public Select_missing_wordsContext select_missing_words() {
			return getRuleContext(Select_missing_wordsContext.class,0);
		}
		public True_false_questionContext true_false_question() {
			return getRuleContext(True_false_questionContext.class,0);
		}
		public Multiple_choice_questionContext multiple_choice_question() {
			return getRuleContext(Multiple_choice_questionContext.class,0);
		}
		public Short_answer_questionContext short_answer_question() {
			return getRuleContext(Short_answer_questionContext.class,0);
		}
		public Numerical_questionContext numerical_question() {
			return getRuleContext(Numerical_questionContext.class,0);
		}
		public Question_type_without_feedbackContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_question_type_without_feedback; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).enterQuestion_type_without_feedback(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).exitQuestion_type_without_feedback(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamGrammarVisitor ) return ((ExamGrammarVisitor<? extends T>)visitor).visitQuestion_type_without_feedback(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Question_type_without_feedbackContext question_type_without_feedback() throws RecognitionException {
		Question_type_without_feedbackContext _localctx = new Question_type_without_feedbackContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_question_type_without_feedback);
		try {
			setState(149);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(143);
				matching_type_question();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(144);
				select_missing_words();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(145);
				true_false_question();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(146);
				multiple_choice_question();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(147);
				short_answer_question();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(148);
				numerical_question();
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
	public static class Type_of_gradeContext extends ParserRuleContext {
		public TerminalNode TYPE_OF_GRADE_ENTRY() { return getToken(ExamGrammarParser.TYPE_OF_GRADE_ENTRY, 0); }
		public TerminalNode WITH_PARAM() { return getToken(ExamGrammarParser.WITH_PARAM, 0); }
		public TerminalNode WITHOUT_PARAM() { return getToken(ExamGrammarParser.WITHOUT_PARAM, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(ExamGrammarParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ExamGrammarParser.NEWLINE, i);
		}
		public Type_of_gradeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_of_grade; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).enterType_of_grade(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).exitType_of_grade(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamGrammarVisitor ) return ((ExamGrammarVisitor<? extends T>)visitor).visitType_of_grade(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Type_of_gradeContext type_of_grade() throws RecognitionException {
		Type_of_gradeContext _localctx = new Type_of_gradeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_type_of_grade);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(152); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(151);
				match(NEWLINE);
				}
				}
				setState(154); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			setState(156);
			match(TYPE_OF_GRADE_ENTRY);
			setState(157);
			_la = _input.LA(1);
			if ( !(_la==WITH_PARAM || _la==WITHOUT_PARAM) ) {
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
	public static class Type_of_feedbackContext extends ParserRuleContext {
		public TerminalNode TYPE_OF_FEEDBACK_ENTRY() { return getToken(ExamGrammarParser.TYPE_OF_FEEDBACK_ENTRY, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(ExamGrammarParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ExamGrammarParser.NEWLINE, i);
		}
		public Type_of_feedbackContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_of_feedback; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).enterType_of_feedback(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).exitType_of_feedback(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamGrammarVisitor ) return ((ExamGrammarVisitor<? extends T>)visitor).visitType_of_feedback(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Type_of_feedbackContext type_of_feedback() throws RecognitionException {
		Type_of_feedbackContext _localctx = new Type_of_feedbackContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_type_of_feedback);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(159);
				match(NEWLINE);
				}
				}
				setState(162); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			setState(164);
			match(TYPE_OF_FEEDBACK_ENTRY);
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
	public static class Header_descriptionContext extends ParserRuleContext {
		public TerminalNode HEADER_DESCRIPTION_ENTRY() { return getToken(ExamGrammarParser.HEADER_DESCRIPTION_ENTRY, 0); }
		public PhraseContext phrase() {
			return getRuleContext(PhraseContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(ExamGrammarParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ExamGrammarParser.NEWLINE, i);
		}
		public Header_descriptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_header_description; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).enterHeader_description(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).exitHeader_description(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamGrammarVisitor ) return ((ExamGrammarVisitor<? extends T>)visitor).visitHeader_description(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Header_descriptionContext header_description() throws RecognitionException {
		Header_descriptionContext _localctx = new Header_descriptionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_header_description);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(167); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(166);
				match(NEWLINE);
				}
				}
				setState(169); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			setState(171);
			match(HEADER_DESCRIPTION_ENTRY);
			setState(172);
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
	public static class Multiple_choice_questionContext extends ParserRuleContext {
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
		public Multiple_choice_questionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiple_choice_question; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).enterMultiple_choice_question(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).exitMultiple_choice_question(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamGrammarVisitor ) return ((ExamGrammarVisitor<? extends T>)visitor).visitMultiple_choice_question(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Multiple_choice_questionContext multiple_choice_question() throws RecognitionException {
		Multiple_choice_questionContext _localctx = new Multiple_choice_questionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_multiple_choice_question);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
			points();
			setState(175);
			question();
			setState(176);
			list_with_title();
			setState(177);
			multiple_choice_answer();
			setState(178);
			multiple_choice_solution();
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
		public TerminalNode ANSWER_ENTRY() { return getToken(ExamGrammarParser.ANSWER_ENTRY, 0); }
		public List_phrasesContext list_phrases() {
			return getRuleContext(List_phrasesContext.class,0);
		}
		public Multiple_choice_answerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiple_choice_answer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).enterMultiple_choice_answer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).exitMultiple_choice_answer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamGrammarVisitor ) return ((ExamGrammarVisitor<? extends T>)visitor).visitMultiple_choice_answer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Multiple_choice_answerContext multiple_choice_answer() throws RecognitionException {
		Multiple_choice_answerContext _localctx = new Multiple_choice_answerContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_multiple_choice_answer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			match(ANSWER_ENTRY);
			setState(182);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 24805376L) != 0)) {
				{
				setState(181);
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
		public TerminalNode SOLUTION_ENTRY() { return getToken(ExamGrammarParser.SOLUTION_ENTRY, 0); }
		public List_phrasesContext list_phrases() {
			return getRuleContext(List_phrasesContext.class,0);
		}
		public Multiple_choice_solutionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiple_choice_solution; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).enterMultiple_choice_solution(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).exitMultiple_choice_solution(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamGrammarVisitor ) return ((ExamGrammarVisitor<? extends T>)visitor).visitMultiple_choice_solution(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Multiple_choice_solutionContext multiple_choice_solution() throws RecognitionException {
		Multiple_choice_solutionContext _localctx = new Multiple_choice_solutionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_multiple_choice_solution);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
			match(SOLUTION_ENTRY);
			setState(185);
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
		public Matching_type_questionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_matching_type_question; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).enterMatching_type_question(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).exitMatching_type_question(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamGrammarVisitor ) return ((ExamGrammarVisitor<? extends T>)visitor).visitMatching_type_question(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Matching_type_questionContext matching_type_question() throws RecognitionException {
		Matching_type_questionContext _localctx = new Matching_type_questionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_matching_type_question);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(187);
			points();
			setState(188);
			question();
			setState(189);
			list_with_title();
			setState(190);
			list_with_title();
			setState(191);
			matching_type_answer();
			setState(192);
			matching_type_solution();
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
		public TerminalNode ANSWER_ENTRY() { return getToken(ExamGrammarParser.ANSWER_ENTRY, 0); }
		public List<PhraseContext> phrase() {
			return getRuleContexts(PhraseContext.class);
		}
		public PhraseContext phrase(int i) {
			return getRuleContext(PhraseContext.class,i);
		}
		public List<TerminalNode> DASH() { return getTokens(ExamGrammarParser.DASH); }
		public TerminalNode DASH(int i) {
			return getToken(ExamGrammarParser.DASH, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ExamGrammarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ExamGrammarParser.COMMA, i);
		}
		public Matching_type_answerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_matching_type_answer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).enterMatching_type_answer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).exitMatching_type_answer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamGrammarVisitor ) return ((ExamGrammarVisitor<? extends T>)visitor).visitMatching_type_answer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Matching_type_answerContext matching_type_answer() throws RecognitionException {
		Matching_type_answerContext _localctx = new Matching_type_answerContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_matching_type_answer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194);
			match(ANSWER_ENTRY);
			setState(208);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 24805376L) != 0)) {
				{
				setState(195);
				phrase();
				setState(196);
				match(DASH);
				setState(197);
				phrase();
				setState(205);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(198);
					match(COMMA);
					setState(199);
					phrase();
					setState(200);
					match(DASH);
					setState(201);
					phrase();
					}
					}
					setState(207);
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
		public TerminalNode SOLUTION_ENTRY() { return getToken(ExamGrammarParser.SOLUTION_ENTRY, 0); }
		public List<PhraseContext> phrase() {
			return getRuleContexts(PhraseContext.class);
		}
		public PhraseContext phrase(int i) {
			return getRuleContext(PhraseContext.class,i);
		}
		public List<TerminalNode> DASH() { return getTokens(ExamGrammarParser.DASH); }
		public TerminalNode DASH(int i) {
			return getToken(ExamGrammarParser.DASH, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ExamGrammarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ExamGrammarParser.COMMA, i);
		}
		public Matching_type_solutionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_matching_type_solution; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).enterMatching_type_solution(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).exitMatching_type_solution(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamGrammarVisitor ) return ((ExamGrammarVisitor<? extends T>)visitor).visitMatching_type_solution(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Matching_type_solutionContext matching_type_solution() throws RecognitionException {
		Matching_type_solutionContext _localctx = new Matching_type_solutionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_matching_type_solution);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(210);
			match(SOLUTION_ENTRY);
			setState(211);
			phrase();
			setState(212);
			match(DASH);
			setState(213);
			phrase();
			setState(221);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(214);
				match(COMMA);
				setState(215);
				phrase();
				setState(216);
				match(DASH);
				setState(217);
				phrase();
				}
				}
				setState(223);
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
		public True_false_questionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_true_false_question; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).enterTrue_false_question(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).exitTrue_false_question(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamGrammarVisitor ) return ((ExamGrammarVisitor<? extends T>)visitor).visitTrue_false_question(this);
			else return visitor.visitChildren(this);
		}
	}

	public final True_false_questionContext true_false_question() throws RecognitionException {
		True_false_questionContext _localctx = new True_false_questionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_true_false_question);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(224);
			points();
			setState(225);
			question();
			setState(226);
			true_false_answer();
			setState(227);
			true_false_solution();
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
		public TerminalNode ANSWER_ENTRY() { return getToken(ExamGrammarParser.ANSWER_ENTRY, 0); }
		public TerminalNode TRUE_FALSE_RESPONSES() { return getToken(ExamGrammarParser.TRUE_FALSE_RESPONSES, 0); }
		public True_false_answerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_true_false_answer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).enterTrue_false_answer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).exitTrue_false_answer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamGrammarVisitor ) return ((ExamGrammarVisitor<? extends T>)visitor).visitTrue_false_answer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final True_false_answerContext true_false_answer() throws RecognitionException {
		True_false_answerContext _localctx = new True_false_answerContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_true_false_answer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(229);
			match(ANSWER_ENTRY);
			setState(231);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TRUE_FALSE_RESPONSES) {
				{
				setState(230);
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
		public TerminalNode SOLUTION_ENTRY() { return getToken(ExamGrammarParser.SOLUTION_ENTRY, 0); }
		public TerminalNode TRUE_FALSE_RESPONSES() { return getToken(ExamGrammarParser.TRUE_FALSE_RESPONSES, 0); }
		public True_false_solutionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_true_false_solution; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).enterTrue_false_solution(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).exitTrue_false_solution(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamGrammarVisitor ) return ((ExamGrammarVisitor<? extends T>)visitor).visitTrue_false_solution(this);
			else return visitor.visitChildren(this);
		}
	}

	public final True_false_solutionContext true_false_solution() throws RecognitionException {
		True_false_solutionContext _localctx = new True_false_solutionContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_true_false_solution);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(233);
			match(SOLUTION_ENTRY);
			setState(234);
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
		public Select_missing_wordsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_select_missing_words; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).enterSelect_missing_words(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).exitSelect_missing_words(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamGrammarVisitor ) return ((ExamGrammarVisitor<? extends T>)visitor).visitSelect_missing_words(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Select_missing_wordsContext select_missing_words() throws RecognitionException {
		Select_missing_wordsContext _localctx = new Select_missing_wordsContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_select_missing_words);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(236);
			points();
			setState(237);
			question();
			setState(238);
			missing_word_phrase();
			setState(240); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(239);
				list_with_title();
				}
				}
				setState(242); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			setState(244);
			missing_word_answer();
			setState(245);
			missing_word_solution();
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
		public List<TerminalNode> NEWLINE() { return getTokens(ExamGrammarParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ExamGrammarParser.NEWLINE, i);
		}
		public List<PhraseContext> phrase() {
			return getRuleContexts(PhraseContext.class);
		}
		public PhraseContext phrase(int i) {
			return getRuleContext(PhraseContext.class,i);
		}
		public List<TerminalNode> MISSING_WORD() { return getTokens(ExamGrammarParser.MISSING_WORD); }
		public TerminalNode MISSING_WORD(int i) {
			return getToken(ExamGrammarParser.MISSING_WORD, i);
		}
		public Missing_word_phraseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_missing_word_phrase; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).enterMissing_word_phrase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).exitMissing_word_phrase(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamGrammarVisitor ) return ((ExamGrammarVisitor<? extends T>)visitor).visitMissing_word_phrase(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Missing_word_phraseContext missing_word_phrase() throws RecognitionException {
		Missing_word_phraseContext _localctx = new Missing_word_phraseContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_missing_word_phrase);
		int _la;
		try {
			int _alt;
			setState(282);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(248); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(247);
					match(NEWLINE);
					}
					}
					setState(250); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE );
				setState(253);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 24805376L) != 0)) {
					{
					setState(252);
					phrase();
					}
				}

				setState(257); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(255);
						match(MISSING_WORD);
						setState(256);
						phrase();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(259); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(262);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==MISSING_WORD) {
					{
					setState(261);
					match(MISSING_WORD);
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(265); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(264);
					match(NEWLINE);
					}
					}
					setState(267); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE );
				setState(270);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==MISSING_WORD) {
					{
					setState(269);
					match(MISSING_WORD);
					}
				}

				setState(275); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(272);
						phrase();
						setState(273);
						match(MISSING_WORD);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(277); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(280);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 24805376L) != 0)) {
					{
					setState(279);
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
		public TerminalNode ANSWER_ENTRY() { return getToken(ExamGrammarParser.ANSWER_ENTRY, 0); }
		public List_phrasesContext list_phrases() {
			return getRuleContext(List_phrasesContext.class,0);
		}
		public Missing_word_answerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_missing_word_answer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).enterMissing_word_answer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).exitMissing_word_answer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamGrammarVisitor ) return ((ExamGrammarVisitor<? extends T>)visitor).visitMissing_word_answer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Missing_word_answerContext missing_word_answer() throws RecognitionException {
		Missing_word_answerContext _localctx = new Missing_word_answerContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_missing_word_answer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(284);
			match(ANSWER_ENTRY);
			setState(286);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 24805376L) != 0)) {
				{
				setState(285);
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
		public TerminalNode SOLUTION_ENTRY() { return getToken(ExamGrammarParser.SOLUTION_ENTRY, 0); }
		public List_phrasesContext list_phrases() {
			return getRuleContext(List_phrasesContext.class,0);
		}
		public Missing_word_solutionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_missing_word_solution; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).enterMissing_word_solution(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).exitMissing_word_solution(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamGrammarVisitor ) return ((ExamGrammarVisitor<? extends T>)visitor).visitMissing_word_solution(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Missing_word_solutionContext missing_word_solution() throws RecognitionException {
		Missing_word_solutionContext _localctx = new Missing_word_solutionContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_missing_word_solution);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(288);
			match(SOLUTION_ENTRY);
			setState(289);
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
		public List<TerminalNode> COMMA() { return getTokens(ExamGrammarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ExamGrammarParser.COMMA, i);
		}
		public List_phrasesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list_phrases; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).enterList_phrases(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).exitList_phrases(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamGrammarVisitor ) return ((ExamGrammarVisitor<? extends T>)visitor).visitList_phrases(this);
			else return visitor.visitChildren(this);
		}
	}

	public final List_phrasesContext list_phrases() throws RecognitionException {
		List_phrasesContext _localctx = new List_phrasesContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_list_phrases);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(291);
			phrase();
			setState(296);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(292);
				match(COMMA);
				setState(293);
				phrase();
				}
				}
				setState(298);
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
		public Short_answer_questionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_short_answer_question; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).enterShort_answer_question(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).exitShort_answer_question(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamGrammarVisitor ) return ((ExamGrammarVisitor<? extends T>)visitor).visitShort_answer_question(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Short_answer_questionContext short_answer_question() throws RecognitionException {
		Short_answer_questionContext _localctx = new Short_answer_questionContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_short_answer_question);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(299);
			points();
			setState(300);
			question();
			setState(301);
			short_answer_answer();
			setState(302);
			short_answer_solution();
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
		public TerminalNode ANSWER_ENTRY() { return getToken(ExamGrammarParser.ANSWER_ENTRY, 0); }
		public PhraseContext phrase() {
			return getRuleContext(PhraseContext.class,0);
		}
		public Short_answer_answerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_short_answer_answer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).enterShort_answer_answer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).exitShort_answer_answer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamGrammarVisitor ) return ((ExamGrammarVisitor<? extends T>)visitor).visitShort_answer_answer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Short_answer_answerContext short_answer_answer() throws RecognitionException {
		Short_answer_answerContext _localctx = new Short_answer_answerContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_short_answer_answer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(304);
			match(ANSWER_ENTRY);
			setState(306);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 24805376L) != 0)) {
				{
				setState(305);
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
		public TerminalNode SOLUTION_ENTRY() { return getToken(ExamGrammarParser.SOLUTION_ENTRY, 0); }
		public PhraseContext phrase() {
			return getRuleContext(PhraseContext.class,0);
		}
		public Short_answer_solutionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_short_answer_solution; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).enterShort_answer_solution(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).exitShort_answer_solution(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamGrammarVisitor ) return ((ExamGrammarVisitor<? extends T>)visitor).visitShort_answer_solution(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Short_answer_solutionContext short_answer_solution() throws RecognitionException {
		Short_answer_solutionContext _localctx = new Short_answer_solutionContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_short_answer_solution);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(308);
			match(SOLUTION_ENTRY);
			setState(309);
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
		public Numerical_questionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numerical_question; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).enterNumerical_question(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).exitNumerical_question(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamGrammarVisitor ) return ((ExamGrammarVisitor<? extends T>)visitor).visitNumerical_question(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Numerical_questionContext numerical_question() throws RecognitionException {
		Numerical_questionContext _localctx = new Numerical_questionContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_numerical_question);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(311);
			points();
			setState(312);
			question();
			setState(313);
			numerical_answer();
			setState(314);
			numerical_solution();
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
		public TerminalNode ANSWER_ENTRY() { return getToken(ExamGrammarParser.ANSWER_ENTRY, 0); }
		public TerminalNode WORD() { return getToken(ExamGrammarParser.WORD, 0); }
		public TerminalNode INT() { return getToken(ExamGrammarParser.INT, 0); }
		public TerminalNode NUMERICAL_VALUE() { return getToken(ExamGrammarParser.NUMERICAL_VALUE, 0); }
		public Numerical_answerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numerical_answer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).enterNumerical_answer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).exitNumerical_answer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamGrammarVisitor ) return ((ExamGrammarVisitor<? extends T>)visitor).visitNumerical_answer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Numerical_answerContext numerical_answer() throws RecognitionException {
		Numerical_answerContext _localctx = new Numerical_answerContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_numerical_answer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(316);
			match(ANSWER_ENTRY);
			setState(319);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==INT || _la==NUMERICAL_VALUE) {
				{
				setState(317);
				_la = _input.LA(1);
				if ( !(_la==INT || _la==NUMERICAL_VALUE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(318);
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
		public TerminalNode SOLUTION_ENTRY() { return getToken(ExamGrammarParser.SOLUTION_ENTRY, 0); }
		public TerminalNode WORD() { return getToken(ExamGrammarParser.WORD, 0); }
		public TerminalNode INT() { return getToken(ExamGrammarParser.INT, 0); }
		public TerminalNode NUMERICAL_VALUE() { return getToken(ExamGrammarParser.NUMERICAL_VALUE, 0); }
		public Numerical_solutionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numerical_solution; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).enterNumerical_solution(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).exitNumerical_solution(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamGrammarVisitor ) return ((ExamGrammarVisitor<? extends T>)visitor).visitNumerical_solution(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Numerical_solutionContext numerical_solution() throws RecognitionException {
		Numerical_solutionContext _localctx = new Numerical_solutionContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_numerical_solution);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(321);
			match(SOLUTION_ENTRY);
			setState(322);
			_la = _input.LA(1);
			if ( !(_la==INT || _la==NUMERICAL_VALUE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(323);
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
		public TerminalNode QUESTION_ENTRY() { return getToken(ExamGrammarParser.QUESTION_ENTRY, 0); }
		public PhraseContext phrase() {
			return getRuleContext(PhraseContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(ExamGrammarParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ExamGrammarParser.NEWLINE, i);
		}
		public QuestionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_question; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).enterQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).exitQuestion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamGrammarVisitor ) return ((ExamGrammarVisitor<? extends T>)visitor).visitQuestion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuestionContext question() throws RecognitionException {
		QuestionContext _localctx = new QuestionContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_question);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(326); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(325);
				match(NEWLINE);
				}
				}
				setState(328); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			setState(330);
			match(QUESTION_ENTRY);
			setState(331);
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
		public TerminalNode POINTS_ENTRY() { return getToken(ExamGrammarParser.POINTS_ENTRY, 0); }
		public TerminalNode INT() { return getToken(ExamGrammarParser.INT, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(ExamGrammarParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ExamGrammarParser.NEWLINE, i);
		}
		public PointsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_points; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).enterPoints(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).exitPoints(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamGrammarVisitor ) return ((ExamGrammarVisitor<? extends T>)visitor).visitPoints(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PointsContext points() throws RecognitionException {
		PointsContext _localctx = new PointsContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_points);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(334); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(333);
				match(NEWLINE);
				}
				}
				setState(336); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			setState(338);
			match(POINTS_ENTRY);
			setState(339);
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
		public TerminalNode FEEDBACK_ENTRY() { return getToken(ExamGrammarParser.FEEDBACK_ENTRY, 0); }
		public PhraseContext phrase() {
			return getRuleContext(PhraseContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(ExamGrammarParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ExamGrammarParser.NEWLINE, i);
		}
		public FeedbackContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_feedback; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).enterFeedback(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).exitFeedback(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamGrammarVisitor ) return ((ExamGrammarVisitor<? extends T>)visitor).visitFeedback(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FeedbackContext feedback() throws RecognitionException {
		FeedbackContext _localctx = new FeedbackContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_feedback);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(342); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(341);
				match(NEWLINE);
				}
				}
				setState(344); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			setState(346);
			match(FEEDBACK_ENTRY);
			setState(347);
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
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).enterPhrase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).exitPhrase(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamGrammarVisitor ) return ((ExamGrammarVisitor<? extends T>)visitor).visitPhrase(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PhraseContext phrase() throws RecognitionException {
		PhraseContext _localctx = new PhraseContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_phrase);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(350); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(349);
					phrase_word();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(352); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,42,_ctx);
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
		public TerminalNode WORD() { return getToken(ExamGrammarParser.WORD, 0); }
		public TerminalNode INT() { return getToken(ExamGrammarParser.INT, 0); }
		public TerminalNode PUNCTUATION() { return getToken(ExamGrammarParser.PUNCTUATION, 0); }
		public TerminalNode COMMA() { return getToken(ExamGrammarParser.COMMA, 0); }
		public TerminalNode HASH() { return getToken(ExamGrammarParser.HASH, 0); }
		public TerminalNode COLON() { return getToken(ExamGrammarParser.COLON, 0); }
		public TerminalNode DASH() { return getToken(ExamGrammarParser.DASH, 0); }
		public Phrase_wordContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_phrase_word; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).enterPhrase_word(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).exitPhrase_word(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamGrammarVisitor ) return ((ExamGrammarVisitor<? extends T>)visitor).visitPhrase_word(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Phrase_wordContext phrase_word() throws RecognitionException {
		Phrase_wordContext _localctx = new Phrase_wordContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_phrase_word);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(354);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 24805376L) != 0)) ) {
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
		public List<TerminalNode> NEWLINE() { return getTokens(ExamGrammarParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ExamGrammarParser.NEWLINE, i);
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
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).enterList_with_title(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).exitList_with_title(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamGrammarVisitor ) return ((ExamGrammarVisitor<? extends T>)visitor).visitList_with_title(this);
			else return visitor.visitChildren(this);
		}
	}

	public final List_with_titleContext list_with_title() throws RecognitionException {
		List_with_titleContext _localctx = new List_with_titleContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_list_with_title);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(357); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(356);
				match(NEWLINE);
				}
				}
				setState(359); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			setState(361);
			title_list();
			setState(363);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
			case 1:
				{
				setState(362);
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
		public TerminalNode COLON() { return getToken(ExamGrammarParser.COLON, 0); }
		public Title_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_title_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).enterTitle_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).exitTitle_list(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamGrammarVisitor ) return ((ExamGrammarVisitor<? extends T>)visitor).visitTitle_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Title_listContext title_list() throws RecognitionException {
		Title_listContext _localctx = new Title_listContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_title_list);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(365);
			phrase();
			setState(366);
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
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).enterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).exitList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamGrammarVisitor ) return ((ExamGrammarVisitor<? extends T>)visitor).visitList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListContext list() throws RecognitionException {
		ListContext _localctx = new ListContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_list);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(369); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(368);
					topic_list();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(371); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,45,_ctx);
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
		public TerminalNode DASH() { return getToken(ExamGrammarParser.DASH, 0); }
		public PhraseContext phrase() {
			return getRuleContext(PhraseContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(ExamGrammarParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ExamGrammarParser.NEWLINE, i);
		}
		public Topic_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_topic_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).enterTopic_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).exitTopic_list(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamGrammarVisitor ) return ((ExamGrammarVisitor<? extends T>)visitor).visitTopic_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Topic_listContext topic_list() throws RecognitionException {
		Topic_listContext _localctx = new Topic_listContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_topic_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(374); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(373);
				match(NEWLINE);
				}
				}
				setState(376); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			setState(378);
			match(DASH);
			setState(379);
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
	public static class TitleContext extends ParserRuleContext {
		public TerminalNode TITLE_ENTRY() { return getToken(ExamGrammarParser.TITLE_ENTRY, 0); }
		public PhraseContext phrase() {
			return getRuleContext(PhraseContext.class,0);
		}
		public TitleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_title; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).enterTitle(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).exitTitle(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamGrammarVisitor ) return ((ExamGrammarVisitor<? extends T>)visitor).visitTitle(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TitleContext title() throws RecognitionException {
		TitleContext _localctx = new TitleContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_title);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(381);
			match(TITLE_ENTRY);
			setState(382);
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
	public static class SectionContext extends ParserRuleContext {
		public TerminalNode SECTION_ENTRY() { return getToken(ExamGrammarParser.SECTION_ENTRY, 0); }
		public List<PhraseContext> phrase() {
			return getRuleContexts(PhraseContext.class);
		}
		public PhraseContext phrase(int i) {
			return getRuleContext(PhraseContext.class,i);
		}
		public TerminalNode SECTION_DESCRIPTION_ENTRY() { return getToken(ExamGrammarParser.SECTION_DESCRIPTION_ENTRY, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(ExamGrammarParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ExamGrammarParser.NEWLINE, i);
		}
		public SectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_section; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).enterSection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).exitSection(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamGrammarVisitor ) return ((ExamGrammarVisitor<? extends T>)visitor).visitSection(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SectionContext section() throws RecognitionException {
		SectionContext _localctx = new SectionContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_section);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(384);
			match(SECTION_ENTRY);
			setState(385);
			phrase();
			setState(393);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,48,_ctx) ) {
			case 1:
				{
				setState(387); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(386);
					match(NEWLINE);
					}
					}
					setState(389); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE );
				setState(391);
				match(SECTION_DESCRIPTION_ENTRY);
				setState(392);
				phrase();
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

	public static final String _serializedATN =
		"\u0004\u0001\u0019\u018c\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007"+
		"\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007"+
		"\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007"+
		"\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007"+
		"\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007"+
		"\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007"+
		"\u001e\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007"+
		"\"\u0002#\u0007#\u0002$\u0007$\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0003\u0000P\b\u0000\u0001\u0000\u0004\u0000S\b\u0000"+
		"\u000b\u0000\f\u0000T\u0001\u0000\u0001\u0000\u0004\u0000Y\b\u0000\u000b"+
		"\u0000\f\u0000Z\u0004\u0000]\b\u0000\u000b\u0000\f\u0000^\u0001\u0000"+
		"\u0001\u0000\u0003\u0000c\b\u0000\u0001\u0000\u0004\u0000f\b\u0000\u000b"+
		"\u0000\f\u0000g\u0001\u0000\u0001\u0000\u0004\u0000l\b\u0000\u000b\u0000"+
		"\f\u0000m\u0004\u0000p\b\u0000\u000b\u0000\f\u0000q\u0003\u0000t\b\u0000"+
		"\u0001\u0001\u0001\u0001\u0003\u0001x\b\u0001\u0001\u0001\u0001\u0001"+
		"\u0003\u0001|\b\u0001\u0001\u0001\u0001\u0001\u0003\u0001\u0080\b\u0001"+
		"\u0001\u0001\u0001\u0001\u0003\u0001\u0084\b\u0001\u0001\u0001\u0001\u0001"+
		"\u0003\u0001\u0088\b\u0001\u0001\u0001\u0001\u0001\u0003\u0001\u008c\b"+
		"\u0001\u0003\u0001\u008e\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0003\u0002\u0096\b\u0002\u0001\u0003\u0004"+
		"\u0003\u0099\b\u0003\u000b\u0003\f\u0003\u009a\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0004\u0004\u0004\u00a1\b\u0004\u000b\u0004\f\u0004"+
		"\u00a2\u0001\u0004\u0001\u0004\u0001\u0005\u0004\u0005\u00a8\b\u0005\u000b"+
		"\u0005\f\u0005\u00a9\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001"+
		"\u0007\u0003\u0007\u00b7\b\u0007\u0001\b\u0001\b\u0001\b\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0005\n\u00cc\b\n\n\n\f\n\u00cf"+
		"\t\n\u0003\n\u00d1\b\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b"+
		"\u00dc\b\u000b\n\u000b\f\u000b\u00df\t\u000b\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\r\u0001\r\u0003\r\u00e8\b\r\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0004\u000f\u00f1"+
		"\b\u000f\u000b\u000f\f\u000f\u00f2\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u0010\u0004\u0010\u00f9\b\u0010\u000b\u0010\f\u0010\u00fa\u0001"+
		"\u0010\u0003\u0010\u00fe\b\u0010\u0001\u0010\u0001\u0010\u0004\u0010\u0102"+
		"\b\u0010\u000b\u0010\f\u0010\u0103\u0001\u0010\u0003\u0010\u0107\b\u0010"+
		"\u0001\u0010\u0004\u0010\u010a\b\u0010\u000b\u0010\f\u0010\u010b\u0001"+
		"\u0010\u0003\u0010\u010f\b\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0004"+
		"\u0010\u0114\b\u0010\u000b\u0010\f\u0010\u0115\u0001\u0010\u0003\u0010"+
		"\u0119\b\u0010\u0003\u0010\u011b\b\u0010\u0001\u0011\u0001\u0011\u0003"+
		"\u0011\u011f\b\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0005\u0013\u0127\b\u0013\n\u0013\f\u0013\u012a\t\u0013"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0015"+
		"\u0001\u0015\u0003\u0015\u0133\b\u0015\u0001\u0016\u0001\u0016\u0001\u0016"+
		"\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0018"+
		"\u0001\u0018\u0001\u0018\u0003\u0018\u0140\b\u0018\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0001\u0019\u0001\u001a\u0004\u001a\u0147\b\u001a\u000b\u001a"+
		"\f\u001a\u0148\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001b\u0004\u001b"+
		"\u014f\b\u001b\u000b\u001b\f\u001b\u0150\u0001\u001b\u0001\u001b\u0001"+
		"\u001b\u0001\u001c\u0004\u001c\u0157\b\u001c\u000b\u001c\f\u001c\u0158"+
		"\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001d\u0004\u001d\u015f\b\u001d"+
		"\u000b\u001d\f\u001d\u0160\u0001\u001e\u0001\u001e\u0001\u001f\u0004\u001f"+
		"\u0166\b\u001f\u000b\u001f\f\u001f\u0167\u0001\u001f\u0001\u001f\u0003"+
		"\u001f\u016c\b\u001f\u0001 \u0001 \u0001 \u0001!\u0004!\u0172\b!\u000b"+
		"!\f!\u0173\u0001\"\u0004\"\u0177\b\"\u000b\"\f\"\u0178\u0001\"\u0001\""+
		"\u0001\"\u0001#\u0001#\u0001#\u0001$\u0001$\u0001$\u0004$\u0184\b$\u000b"+
		"$\f$\u0185\u0001$\u0001$\u0003$\u018a\b$\u0001$\u0000\u0000%\u0000\u0002"+
		"\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e"+
		" \"$&(*,.02468:<>@BDFH\u0000\u0003\u0001\u0000\r\u000e\u0001\u0000\u0016"+
		"\u0017\u0004\u0000\u000f\u000f\u0011\u0011\u0013\u0016\u0018\u0018\u019f"+
		"\u0000J\u0001\u0000\u0000\u0000\u0002\u008d\u0001\u0000\u0000\u0000\u0004"+
		"\u0095\u0001\u0000\u0000\u0000\u0006\u0098\u0001\u0000\u0000\u0000\b\u00a0"+
		"\u0001\u0000\u0000\u0000\n\u00a7\u0001\u0000\u0000\u0000\f\u00ae\u0001"+
		"\u0000\u0000\u0000\u000e\u00b4\u0001\u0000\u0000\u0000\u0010\u00b8\u0001"+
		"\u0000\u0000\u0000\u0012\u00bb\u0001\u0000\u0000\u0000\u0014\u00c2\u0001"+
		"\u0000\u0000\u0000\u0016\u00d2\u0001\u0000\u0000\u0000\u0018\u00e0\u0001"+
		"\u0000\u0000\u0000\u001a\u00e5\u0001\u0000\u0000\u0000\u001c\u00e9\u0001"+
		"\u0000\u0000\u0000\u001e\u00ec\u0001\u0000\u0000\u0000 \u011a\u0001\u0000"+
		"\u0000\u0000\"\u011c\u0001\u0000\u0000\u0000$\u0120\u0001\u0000\u0000"+
		"\u0000&\u0123\u0001\u0000\u0000\u0000(\u012b\u0001\u0000\u0000\u0000*"+
		"\u0130\u0001\u0000\u0000\u0000,\u0134\u0001\u0000\u0000\u0000.\u0137\u0001"+
		"\u0000\u0000\u00000\u013c\u0001\u0000\u0000\u00002\u0141\u0001\u0000\u0000"+
		"\u00004\u0146\u0001\u0000\u0000\u00006\u014e\u0001\u0000\u0000\u00008"+
		"\u0156\u0001\u0000\u0000\u0000:\u015e\u0001\u0000\u0000\u0000<\u0162\u0001"+
		"\u0000\u0000\u0000>\u0165\u0001\u0000\u0000\u0000@\u016d\u0001\u0000\u0000"+
		"\u0000B\u0171\u0001\u0000\u0000\u0000D\u0176\u0001\u0000\u0000\u0000F"+
		"\u017d\u0001\u0000\u0000\u0000H\u0180\u0001\u0000\u0000\u0000JK\u0003"+
		"F#\u0000KL\u0003\u0006\u0003\u0000Ls\u0003\b\u0004\u0000MO\u0005\r\u0000"+
		"\u0000NP\u0003\n\u0005\u0000ON\u0001\u0000\u0000\u0000OP\u0001\u0000\u0000"+
		"\u0000P\\\u0001\u0000\u0000\u0000QS\u0005\u0012\u0000\u0000RQ\u0001\u0000"+
		"\u0000\u0000ST\u0001\u0000\u0000\u0000TR\u0001\u0000\u0000\u0000TU\u0001"+
		"\u0000\u0000\u0000UV\u0001\u0000\u0000\u0000VX\u0003H$\u0000WY\u0003\u0002"+
		"\u0001\u0000XW\u0001\u0000\u0000\u0000YZ\u0001\u0000\u0000\u0000ZX\u0001"+
		"\u0000\u0000\u0000Z[\u0001\u0000\u0000\u0000[]\u0001\u0000\u0000\u0000"+
		"\\R\u0001\u0000\u0000\u0000]^\u0001\u0000\u0000\u0000^\\\u0001\u0000\u0000"+
		"\u0000^_\u0001\u0000\u0000\u0000_t\u0001\u0000\u0000\u0000`b\u0005\u000e"+
		"\u0000\u0000ac\u0003\n\u0005\u0000ba\u0001\u0000\u0000\u0000bc\u0001\u0000"+
		"\u0000\u0000co\u0001\u0000\u0000\u0000df\u0005\u0012\u0000\u0000ed\u0001"+
		"\u0000\u0000\u0000fg\u0001\u0000\u0000\u0000ge\u0001\u0000\u0000\u0000"+
		"gh\u0001\u0000\u0000\u0000hi\u0001\u0000\u0000\u0000ik\u0003H$\u0000j"+
		"l\u0003\u0004\u0002\u0000kj\u0001\u0000\u0000\u0000lm\u0001\u0000\u0000"+
		"\u0000mk\u0001\u0000\u0000\u0000mn\u0001\u0000\u0000\u0000np\u0001\u0000"+
		"\u0000\u0000oe\u0001\u0000\u0000\u0000pq\u0001\u0000\u0000\u0000qo\u0001"+
		"\u0000\u0000\u0000qr\u0001\u0000\u0000\u0000rt\u0001\u0000\u0000\u0000"+
		"sM\u0001\u0000\u0000\u0000s`\u0001\u0000\u0000\u0000t\u0001\u0001\u0000"+
		"\u0000\u0000uw\u0003\u0012\t\u0000vx\u00038\u001c\u0000wv\u0001\u0000"+
		"\u0000\u0000wx\u0001\u0000\u0000\u0000x\u008e\u0001\u0000\u0000\u0000"+
		"y{\u0003\u001e\u000f\u0000z|\u00038\u001c\u0000{z\u0001\u0000\u0000\u0000"+
		"{|\u0001\u0000\u0000\u0000|\u008e\u0001\u0000\u0000\u0000}\u007f\u0003"+
		"\u0018\f\u0000~\u0080\u00038\u001c\u0000\u007f~\u0001\u0000\u0000\u0000"+
		"\u007f\u0080\u0001\u0000\u0000\u0000\u0080\u008e\u0001\u0000\u0000\u0000"+
		"\u0081\u0083\u0003\f\u0006\u0000\u0082\u0084\u00038\u001c\u0000\u0083"+
		"\u0082\u0001\u0000\u0000\u0000\u0083\u0084\u0001\u0000\u0000\u0000\u0084"+
		"\u008e\u0001\u0000\u0000\u0000\u0085\u0087\u0003(\u0014\u0000\u0086\u0088"+
		"\u00038\u001c\u0000\u0087\u0086\u0001\u0000\u0000\u0000\u0087\u0088\u0001"+
		"\u0000\u0000\u0000\u0088\u008e\u0001\u0000\u0000\u0000\u0089\u008b\u0003"+
		".\u0017\u0000\u008a\u008c\u00038\u001c\u0000\u008b\u008a\u0001\u0000\u0000"+
		"\u0000\u008b\u008c\u0001\u0000\u0000\u0000\u008c\u008e\u0001\u0000\u0000"+
		"\u0000\u008du\u0001\u0000\u0000\u0000\u008dy\u0001\u0000\u0000\u0000\u008d"+
		"}\u0001\u0000\u0000\u0000\u008d\u0081\u0001\u0000\u0000\u0000\u008d\u0085"+
		"\u0001\u0000\u0000\u0000\u008d\u0089\u0001\u0000\u0000\u0000\u008e\u0003"+
		"\u0001\u0000\u0000\u0000\u008f\u0096\u0003\u0012\t\u0000\u0090\u0096\u0003"+
		"\u001e\u000f\u0000\u0091\u0096\u0003\u0018\f\u0000\u0092\u0096\u0003\f"+
		"\u0006\u0000\u0093\u0096\u0003(\u0014\u0000\u0094\u0096\u0003.\u0017\u0000"+
		"\u0095\u008f\u0001\u0000\u0000\u0000\u0095\u0090\u0001\u0000\u0000\u0000"+
		"\u0095\u0091\u0001\u0000\u0000\u0000\u0095\u0092\u0001\u0000\u0000\u0000"+
		"\u0095\u0093\u0001\u0000\u0000\u0000\u0095\u0094\u0001\u0000\u0000\u0000"+
		"\u0096\u0005\u0001\u0000\u0000\u0000\u0097\u0099\u0005\u0012\u0000\u0000"+
		"\u0098\u0097\u0001\u0000\u0000\u0000\u0099\u009a\u0001\u0000\u0000\u0000"+
		"\u009a\u0098\u0001\u0000\u0000\u0000\u009a\u009b\u0001\u0000\u0000\u0000"+
		"\u009b\u009c\u0001\u0000\u0000\u0000\u009c\u009d\u0005\n\u0000\u0000\u009d"+
		"\u009e\u0007\u0000\u0000\u0000\u009e\u0007\u0001\u0000\u0000\u0000\u009f"+
		"\u00a1\u0005\u0012\u0000\u0000\u00a0\u009f\u0001\u0000\u0000\u0000\u00a1"+
		"\u00a2\u0001\u0000\u0000\u0000\u00a2\u00a0\u0001\u0000\u0000\u0000\u00a2"+
		"\u00a3\u0001\u0000\u0000\u0000\u00a3\u00a4\u0001\u0000\u0000\u0000\u00a4"+
		"\u00a5\u0005\u000b\u0000\u0000\u00a5\t\u0001\u0000\u0000\u0000\u00a6\u00a8"+
		"\u0005\u0012\u0000\u0000\u00a7\u00a6\u0001\u0000\u0000\u0000\u00a8\u00a9"+
		"\u0001\u0000\u0000\u0000\u00a9\u00a7\u0001\u0000\u0000\u0000\u00a9\u00aa"+
		"\u0001\u0000\u0000\u0000\u00aa\u00ab\u0001\u0000\u0000\u0000\u00ab\u00ac"+
		"\u0005\f\u0000\u0000\u00ac\u00ad\u0003:\u001d\u0000\u00ad\u000b\u0001"+
		"\u0000\u0000\u0000\u00ae\u00af\u00036\u001b\u0000\u00af\u00b0\u00034\u001a"+
		"\u0000\u00b0\u00b1\u0003>\u001f\u0000\u00b1\u00b2\u0003\u000e\u0007\u0000"+
		"\u00b2\u00b3\u0003\u0010\b\u0000\u00b3\r\u0001\u0000\u0000\u0000\u00b4"+
		"\u00b6\u0005\u0001\u0000\u0000\u00b5\u00b7\u0003&\u0013\u0000\u00b6\u00b5"+
		"\u0001\u0000\u0000\u0000\u00b6\u00b7\u0001\u0000\u0000\u0000\u00b7\u000f"+
		"\u0001\u0000\u0000\u0000\u00b8\u00b9\u0005\u0002\u0000\u0000\u00b9\u00ba"+
		"\u0003&\u0013\u0000\u00ba\u0011\u0001\u0000\u0000\u0000\u00bb\u00bc\u0003"+
		"6\u001b\u0000\u00bc\u00bd\u00034\u001a\u0000\u00bd\u00be\u0003>\u001f"+
		"\u0000\u00be\u00bf\u0003>\u001f\u0000\u00bf\u00c0\u0003\u0014\n\u0000"+
		"\u00c0\u00c1\u0003\u0016\u000b\u0000\u00c1\u0013\u0001\u0000\u0000\u0000"+
		"\u00c2\u00d0\u0005\u0001\u0000\u0000\u00c3\u00c4\u0003:\u001d\u0000\u00c4"+
		"\u00c5\u0005\u0015\u0000\u0000\u00c5\u00cd\u0003:\u001d\u0000\u00c6\u00c7"+
		"\u0005\u000f\u0000\u0000\u00c7\u00c8\u0003:\u001d\u0000\u00c8\u00c9\u0005"+
		"\u0015\u0000\u0000\u00c9\u00ca\u0003:\u001d\u0000\u00ca\u00cc\u0001\u0000"+
		"\u0000\u0000\u00cb\u00c6\u0001\u0000\u0000\u0000\u00cc\u00cf\u0001\u0000"+
		"\u0000\u0000\u00cd\u00cb\u0001\u0000\u0000\u0000\u00cd\u00ce\u0001\u0000"+
		"\u0000\u0000\u00ce\u00d1\u0001\u0000\u0000\u0000\u00cf\u00cd\u0001\u0000"+
		"\u0000\u0000\u00d0\u00c3\u0001\u0000\u0000\u0000\u00d0\u00d1\u0001\u0000"+
		"\u0000\u0000\u00d1\u0015\u0001\u0000\u0000\u0000\u00d2\u00d3\u0005\u0002"+
		"\u0000\u0000\u00d3\u00d4\u0003:\u001d\u0000\u00d4\u00d5\u0005\u0015\u0000"+
		"\u0000\u00d5\u00dd\u0003:\u001d\u0000\u00d6\u00d7\u0005\u000f\u0000\u0000"+
		"\u00d7\u00d8\u0003:\u001d\u0000\u00d8\u00d9\u0005\u0015\u0000\u0000\u00d9"+
		"\u00da\u0003:\u001d\u0000\u00da\u00dc\u0001\u0000\u0000\u0000\u00db\u00d6"+
		"\u0001\u0000\u0000\u0000\u00dc\u00df\u0001\u0000\u0000\u0000\u00dd\u00db"+
		"\u0001\u0000\u0000\u0000\u00dd\u00de\u0001\u0000\u0000\u0000\u00de\u0017"+
		"\u0001\u0000\u0000\u0000\u00df\u00dd\u0001\u0000\u0000\u0000\u00e0\u00e1"+
		"\u00036\u001b\u0000\u00e1\u00e2\u00034\u001a\u0000\u00e2\u00e3\u0003\u001a"+
		"\r\u0000\u00e3\u00e4\u0003\u001c\u000e\u0000\u00e4\u0019\u0001\u0000\u0000"+
		"\u0000\u00e5\u00e7\u0005\u0001\u0000\u0000\u00e6\u00e8\u0005\u0003\u0000"+
		"\u0000\u00e7\u00e6\u0001\u0000\u0000\u0000\u00e7\u00e8\u0001\u0000\u0000"+
		"\u0000\u00e8\u001b\u0001\u0000\u0000\u0000\u00e9\u00ea\u0005\u0002\u0000"+
		"\u0000\u00ea\u00eb\u0005\u0003\u0000\u0000\u00eb\u001d\u0001\u0000\u0000"+
		"\u0000\u00ec\u00ed\u00036\u001b\u0000\u00ed\u00ee\u00034\u001a\u0000\u00ee"+
		"\u00f0\u0003 \u0010\u0000\u00ef\u00f1\u0003>\u001f\u0000\u00f0\u00ef\u0001"+
		"\u0000\u0000\u0000\u00f1\u00f2\u0001\u0000\u0000\u0000\u00f2\u00f0\u0001"+
		"\u0000\u0000\u0000\u00f2\u00f3\u0001\u0000\u0000\u0000\u00f3\u00f4\u0001"+
		"\u0000\u0000\u0000\u00f4\u00f5\u0003\"\u0011\u0000\u00f5\u00f6\u0003$"+
		"\u0012\u0000\u00f6\u001f\u0001\u0000\u0000\u0000\u00f7\u00f9\u0005\u0012"+
		"\u0000\u0000\u00f8\u00f7\u0001\u0000\u0000\u0000\u00f9\u00fa\u0001\u0000"+
		"\u0000\u0000\u00fa\u00f8\u0001\u0000\u0000\u0000\u00fa\u00fb\u0001\u0000"+
		"\u0000\u0000\u00fb\u00fd\u0001\u0000\u0000\u0000\u00fc\u00fe\u0003:\u001d"+
		"\u0000\u00fd\u00fc\u0001\u0000\u0000\u0000\u00fd\u00fe\u0001\u0000\u0000"+
		"\u0000\u00fe\u0101\u0001\u0000\u0000\u0000\u00ff\u0100\u0005\u0019\u0000"+
		"\u0000\u0100\u0102\u0003:\u001d\u0000\u0101\u00ff\u0001\u0000\u0000\u0000"+
		"\u0102\u0103\u0001\u0000\u0000\u0000\u0103\u0101\u0001\u0000\u0000\u0000"+
		"\u0103\u0104\u0001\u0000\u0000\u0000\u0104\u0106\u0001\u0000\u0000\u0000"+
		"\u0105\u0107\u0005\u0019\u0000\u0000\u0106\u0105\u0001\u0000\u0000\u0000"+
		"\u0106\u0107\u0001\u0000\u0000\u0000\u0107\u011b\u0001\u0000\u0000\u0000"+
		"\u0108\u010a\u0005\u0012\u0000\u0000\u0109\u0108\u0001\u0000\u0000\u0000"+
		"\u010a\u010b\u0001\u0000\u0000\u0000\u010b\u0109\u0001\u0000\u0000\u0000"+
		"\u010b\u010c\u0001\u0000\u0000\u0000\u010c\u010e\u0001\u0000\u0000\u0000"+
		"\u010d\u010f\u0005\u0019\u0000\u0000\u010e\u010d\u0001\u0000\u0000\u0000"+
		"\u010e\u010f\u0001\u0000\u0000\u0000\u010f\u0113\u0001\u0000\u0000\u0000"+
		"\u0110\u0111\u0003:\u001d\u0000\u0111\u0112\u0005\u0019\u0000\u0000\u0112"+
		"\u0114\u0001\u0000\u0000\u0000\u0113\u0110\u0001\u0000\u0000\u0000\u0114"+
		"\u0115\u0001\u0000\u0000\u0000\u0115\u0113\u0001\u0000\u0000\u0000\u0115"+
		"\u0116\u0001\u0000\u0000\u0000\u0116\u0118\u0001\u0000\u0000\u0000\u0117"+
		"\u0119\u0003:\u001d\u0000\u0118\u0117\u0001\u0000\u0000\u0000\u0118\u0119"+
		"\u0001\u0000\u0000\u0000\u0119\u011b\u0001\u0000\u0000\u0000\u011a\u00f8"+
		"\u0001\u0000\u0000\u0000\u011a\u0109\u0001\u0000\u0000\u0000\u011b!\u0001"+
		"\u0000\u0000\u0000\u011c\u011e\u0005\u0001\u0000\u0000\u011d\u011f\u0003"+
		"&\u0013\u0000\u011e\u011d\u0001\u0000\u0000\u0000\u011e\u011f\u0001\u0000"+
		"\u0000\u0000\u011f#\u0001\u0000\u0000\u0000\u0120\u0121\u0005\u0002\u0000"+
		"\u0000\u0121\u0122\u0003&\u0013\u0000\u0122%\u0001\u0000\u0000\u0000\u0123"+
		"\u0128\u0003:\u001d\u0000\u0124\u0125\u0005\u000f\u0000\u0000\u0125\u0127"+
		"\u0003:\u001d\u0000\u0126\u0124\u0001\u0000\u0000\u0000\u0127\u012a\u0001"+
		"\u0000\u0000\u0000\u0128\u0126\u0001\u0000\u0000\u0000\u0128\u0129\u0001"+
		"\u0000\u0000\u0000\u0129\'\u0001\u0000\u0000\u0000\u012a\u0128\u0001\u0000"+
		"\u0000\u0000\u012b\u012c\u00036\u001b\u0000\u012c\u012d\u00034\u001a\u0000"+
		"\u012d\u012e\u0003*\u0015\u0000\u012e\u012f\u0003,\u0016\u0000\u012f)"+
		"\u0001\u0000\u0000\u0000\u0130\u0132\u0005\u0001\u0000\u0000\u0131\u0133"+
		"\u0003:\u001d\u0000\u0132\u0131\u0001\u0000\u0000\u0000\u0132\u0133\u0001"+
		"\u0000\u0000\u0000\u0133+\u0001\u0000\u0000\u0000\u0134\u0135\u0005\u0002"+
		"\u0000\u0000\u0135\u0136\u0003:\u001d\u0000\u0136-\u0001\u0000\u0000\u0000"+
		"\u0137\u0138\u00036\u001b\u0000\u0138\u0139\u00034\u001a\u0000\u0139\u013a"+
		"\u00030\u0018\u0000\u013a\u013b\u00032\u0019\u0000\u013b/\u0001\u0000"+
		"\u0000\u0000\u013c\u013f\u0005\u0001\u0000\u0000\u013d\u013e\u0007\u0001"+
		"\u0000\u0000\u013e\u0140\u0005\u0013\u0000\u0000\u013f\u013d\u0001\u0000"+
		"\u0000\u0000\u013f\u0140\u0001\u0000\u0000\u0000\u01401\u0001\u0000\u0000"+
		"\u0000\u0141\u0142\u0005\u0002\u0000\u0000\u0142\u0143\u0007\u0001\u0000"+
		"\u0000\u0143\u0144\u0005\u0013\u0000\u0000\u01443\u0001\u0000\u0000\u0000"+
		"\u0145\u0147\u0005\u0012\u0000\u0000\u0146\u0145\u0001\u0000\u0000\u0000"+
		"\u0147\u0148\u0001\u0000\u0000\u0000\u0148\u0146\u0001\u0000\u0000\u0000"+
		"\u0148\u0149\u0001\u0000\u0000\u0000\u0149\u014a\u0001\u0000\u0000\u0000"+
		"\u014a\u014b\u0005\b\u0000\u0000\u014b\u014c\u0003:\u001d\u0000\u014c"+
		"5\u0001\u0000\u0000\u0000\u014d\u014f\u0005\u0012\u0000\u0000\u014e\u014d"+
		"\u0001\u0000\u0000\u0000\u014f\u0150\u0001\u0000\u0000\u0000\u0150\u014e"+
		"\u0001\u0000\u0000\u0000\u0150\u0151\u0001\u0000\u0000\u0000\u0151\u0152"+
		"\u0001\u0000\u0000\u0000\u0152\u0153\u0005\t\u0000\u0000\u0153\u0154\u0005"+
		"\u0016\u0000\u0000\u01547\u0001\u0000\u0000\u0000\u0155\u0157\u0005\u0012"+
		"\u0000\u0000\u0156\u0155\u0001\u0000\u0000\u0000\u0157\u0158\u0001\u0000"+
		"\u0000\u0000\u0158\u0156\u0001\u0000\u0000\u0000\u0158\u0159\u0001\u0000"+
		"\u0000\u0000\u0159\u015a\u0001\u0000\u0000\u0000\u015a\u015b\u0005\u0007"+
		"\u0000\u0000\u015b\u015c\u0003:\u001d\u0000\u015c9\u0001\u0000\u0000\u0000"+
		"\u015d\u015f\u0003<\u001e\u0000\u015e\u015d\u0001\u0000\u0000\u0000\u015f"+
		"\u0160\u0001\u0000\u0000\u0000\u0160\u015e\u0001\u0000\u0000\u0000\u0160"+
		"\u0161\u0001\u0000\u0000\u0000\u0161;\u0001\u0000\u0000\u0000\u0162\u0163"+
		"\u0007\u0002\u0000\u0000\u0163=\u0001\u0000\u0000\u0000\u0164\u0166\u0005"+
		"\u0012\u0000\u0000\u0165\u0164\u0001\u0000\u0000\u0000\u0166\u0167\u0001"+
		"\u0000\u0000\u0000\u0167\u0165\u0001\u0000\u0000\u0000\u0167\u0168\u0001"+
		"\u0000\u0000\u0000\u0168\u0169\u0001\u0000\u0000\u0000\u0169\u016b\u0003"+
		"@ \u0000\u016a\u016c\u0003B!\u0000\u016b\u016a\u0001\u0000\u0000\u0000"+
		"\u016b\u016c\u0001\u0000\u0000\u0000\u016c?\u0001\u0000\u0000\u0000\u016d"+
		"\u016e\u0003:\u001d\u0000\u016e\u016f\u0005\u0014\u0000\u0000\u016fA\u0001"+
		"\u0000\u0000\u0000\u0170\u0172\u0003D\"\u0000\u0171\u0170\u0001\u0000"+
		"\u0000\u0000\u0172\u0173\u0001\u0000\u0000\u0000\u0173\u0171\u0001\u0000"+
		"\u0000\u0000\u0173\u0174\u0001\u0000\u0000\u0000\u0174C\u0001\u0000\u0000"+
		"\u0000\u0175\u0177\u0005\u0012\u0000\u0000\u0176\u0175\u0001\u0000\u0000"+
		"\u0000\u0177\u0178\u0001\u0000\u0000\u0000\u0178\u0176\u0001\u0000\u0000"+
		"\u0000\u0178\u0179\u0001\u0000\u0000\u0000\u0179\u017a\u0001\u0000\u0000"+
		"\u0000\u017a\u017b\u0005\u0015\u0000\u0000\u017b\u017c\u0003:\u001d\u0000"+
		"\u017cE\u0001\u0000\u0000\u0000\u017d\u017e\u0005\u0004\u0000\u0000\u017e"+
		"\u017f\u0003:\u001d\u0000\u017fG\u0001\u0000\u0000\u0000\u0180\u0181\u0005"+
		"\u0005\u0000\u0000\u0181\u0189\u0003:\u001d\u0000\u0182\u0184\u0005\u0012"+
		"\u0000\u0000\u0183\u0182\u0001\u0000\u0000\u0000\u0184\u0185\u0001\u0000"+
		"\u0000\u0000\u0185\u0183\u0001\u0000\u0000\u0000\u0185\u0186\u0001\u0000"+
		"\u0000\u0000\u0186\u0187\u0001\u0000\u0000\u0000\u0187\u0188\u0005\u0006"+
		"\u0000\u0000\u0188\u018a\u0003:\u001d\u0000\u0189\u0183\u0001\u0000\u0000"+
		"\u0000\u0189\u018a\u0001\u0000\u0000\u0000\u018aI\u0001\u0000\u0000\u0000"+
		"1OTZ^bgmqsw{\u007f\u0083\u0087\u008b\u008d\u0095\u009a\u00a2\u00a9\u00b6"+
		"\u00cd\u00d0\u00dd\u00e7\u00f2\u00fa\u00fd\u0103\u0106\u010b\u010e\u0115"+
		"\u0118\u011a\u011e\u0128\u0132\u013f\u0148\u0150\u0158\u0160\u0167\u016b"+
		"\u0173\u0178\u0185\u0189";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}