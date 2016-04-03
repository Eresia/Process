// Generated from Script.g4 by ANTLR 4.5.3

	package antlr;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ScriptParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		Equals=1, Or=2, And=3, Not=4, Add=5, Sub=6, EndLine=7, LabelBegin=8, GotoBegin=9, 
		Variable=10, Hexa=11, Int=12, HexaOpen=13, LabelId=14, Comment=15, WS=16;
	public static final int
		RULE_parse = 0, RULE_block = 1, RULE_line = 2, RULE_assignVar = 3, RULE_notExpression = 4, 
		RULE_operation = 5, RULE_hexaDisp = 6, RULE_integerDisp = 7, RULE_gotoExpression = 8, 
		RULE_labelExpression = 9;
	public static final String[] ruleNames = {
		"parse", "block", "line", "assignVar", "notExpression", "operation", "hexaDisp", 
		"integerDisp", "gotoExpression", "labelExpression"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'='", "'|'", "'&'", "'!'", "'+'", "'-'", "';'", null, null, null, 
		null, null, "'0x'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "Equals", "Or", "And", "Not", "Add", "Sub", "EndLine", "LabelBegin", 
		"GotoBegin", "Variable", "Hexa", "Int", "HexaOpen", "LabelId", "Comment", 
		"WS"
	};
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
	public String getGrammarFileName() { return "Script.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ScriptParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ParseContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(ScriptParser.EOF, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ParseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parse; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScriptListener ) ((ScriptListener)listener).enterParse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScriptListener ) ((ScriptListener)listener).exitParse(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScriptVisitor ) return ((ScriptVisitor<? extends T>)visitor).visitParse(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParseContext parse() throws RecognitionException {
		ParseContext _localctx = new ParseContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_parse);

		enterOuterAlt(_localctx, 1);
		{
		{
		setState(20);
		block();
		}
		setState(21);
		match(EOF);
		}
		exitRule();
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public List<LineContext> line() {
			return getRuleContexts(LineContext.class);
		}
		public LineContext line(int i) {
			return getRuleContext(LineContext.class,i);
		}
		public List<TerminalNode> Comment() { return getTokens(ScriptParser.Comment); }
		public TerminalNode Comment(int i) {
			return getToken(ScriptParser.Comment, i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScriptListener ) ((ScriptListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScriptListener ) ((ScriptListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScriptVisitor ) return ((ScriptVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_block);
		int _la;
		
		enterOuterAlt(_localctx, 1);
		{
		setState(29);
		_errHandler.sync(this);
		_la = _input.LA(1);
		while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Not) | (1L << LabelBegin) | (1L << GotoBegin) | (1L << Variable) | (1L << Comment))) != 0)) {
			{
			{
			setState(23);
			line();
			setState(25);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				{
				setState(24);
				match(Comment);
				}
				break;
			}
			}
			}
			setState(31);
			_errHandler.sync(this);
			_la = _input.LA(1);
		}
		}
		exitRule();
		return _localctx;
	}

	public static class LineContext extends ParserRuleContext {
		public TerminalNode EndLine() { return getToken(ScriptParser.EndLine, 0); }
		public AssignVarContext assignVar() {
			return getRuleContext(AssignVarContext.class,0);
		}
		public NotExpressionContext notExpression() {
			return getRuleContext(NotExpressionContext.class,0);
		}
		public OperationContext operation() {
			return getRuleContext(OperationContext.class,0);
		}
		public GotoExpressionContext gotoExpression() {
			return getRuleContext(GotoExpressionContext.class,0);
		}
		public LabelExpressionContext labelExpression() {
			return getRuleContext(LabelExpressionContext.class,0);
		}
		public TerminalNode Comment() { return getToken(ScriptParser.Comment, 0); }
		public LineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_line; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScriptListener ) ((ScriptListener)listener).enterLine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScriptListener ) ((ScriptListener)listener).exitLine(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScriptVisitor ) return ((ScriptVisitor<? extends T>)visitor).visitLine(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LineContext line() throws RecognitionException {
		LineContext _localctx = new LineContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_line);

		setState(42);
		switch (_input.LA(1)) {
		case Not:
		case LabelBegin:
		case GotoBegin:
		case Variable:
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(37);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(32);
				assignVar();
				}
				break;
			case 2:
				{
				setState(33);
				notExpression();
				}
				break;
			case 3:
				{
				setState(34);
				operation();
				}
				break;
			case 4:
				{
				setState(35);
				gotoExpression();
				}
				break;
			case 5:
				{
				setState(36);
				labelExpression();
				}
				break;
			}
			setState(39);
			match(EndLine);
			}
			}
			break;
		case Comment:
			enterOuterAlt(_localctx, 2);
			{
			setState(41);
			match(Comment);
			}
			break;
		default:
			throw new NoViableAltException(this);
		}
		exitRule();
		return _localctx;
	}

	public static class AssignVarContext extends ParserRuleContext {
		public List<TerminalNode> Variable() { return getTokens(ScriptParser.Variable); }
		public TerminalNode Variable(int i) {
			return getToken(ScriptParser.Variable, i);
		}
		public TerminalNode Equals() { return getToken(ScriptParser.Equals, 0); }
		public IntegerDispContext integerDisp() {
			return getRuleContext(IntegerDispContext.class,0);
		}
		public HexaDispContext hexaDisp() {
			return getRuleContext(HexaDispContext.class,0);
		}
		public AssignVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignVar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScriptListener ) ((ScriptListener)listener).enterAssignVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScriptListener ) ((ScriptListener)listener).exitAssignVar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScriptVisitor ) return ((ScriptVisitor<? extends T>)visitor).visitAssignVar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignVarContext assignVar() throws RecognitionException {
		AssignVarContext _localctx = new AssignVarContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_assignVar);

		enterOuterAlt(_localctx, 1);
		{
		setState(44);
		match(Variable);
		setState(45);
		match(Equals);
		setState(49);
		switch (_input.LA(1)) {
		case Variable:
			{
			setState(46);
			match(Variable);
			}
			break;
		case Int:
			{
			setState(47);
			integerDisp();
			}
			break;
		case Hexa:
			{
			setState(48);
			hexaDisp();
			}
			break;
		default:
			throw new NoViableAltException(this);
		}
		}
		exitRule();
		return _localctx;
	}

	public static class NotExpressionContext extends ParserRuleContext {
		public TerminalNode Not() { return getToken(ScriptParser.Not, 0); }
		public TerminalNode Variable() { return getToken(ScriptParser.Variable, 0); }
		public NotExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_notExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScriptListener ) ((ScriptListener)listener).enterNotExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScriptListener ) ((ScriptListener)listener).exitNotExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScriptVisitor ) return ((ScriptVisitor<? extends T>)visitor).visitNotExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NotExpressionContext notExpression() throws RecognitionException {
		NotExpressionContext _localctx = new NotExpressionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_notExpression);

		enterOuterAlt(_localctx, 1);
		{
		setState(51);
		match(Not);
		setState(52);
		match(Variable);
		}
		exitRule();
		return _localctx;
	}

	public static class OperationContext extends ParserRuleContext {
		public List<TerminalNode> Variable() { return getTokens(ScriptParser.Variable); }
		public TerminalNode Variable(int i) {
			return getToken(ScriptParser.Variable, i);
		}
		public TerminalNode Add() { return getToken(ScriptParser.Add, 0); }
		public TerminalNode Sub() { return getToken(ScriptParser.Sub, 0); }
		public TerminalNode And() { return getToken(ScriptParser.And, 0); }
		public TerminalNode Or() { return getToken(ScriptParser.Or, 0); }
		public OperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScriptListener ) ((ScriptListener)listener).enterOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScriptListener ) ((ScriptListener)listener).exitOperation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScriptVisitor ) return ((ScriptVisitor<? extends T>)visitor).visitOperation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OperationContext operation() throws RecognitionException {
		OperationContext _localctx = new OperationContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_operation);

		setState(66);
		_errHandler.sync(this);
		switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
		case 1:
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			match(Variable);
			setState(55);
			match(Add);
			setState(56);
			match(Variable);
			}
			break;
		case 2:
			enterOuterAlt(_localctx, 2);
			{
			setState(57);
			match(Variable);
			setState(58);
			match(Sub);
			setState(59);
			match(Variable);
			}
			break;
		case 3:
			enterOuterAlt(_localctx, 3);
			{
			setState(60);
			match(Variable);
			setState(61);
			match(And);
			setState(62);
			match(Variable);
			}
			break;
		case 4:
			enterOuterAlt(_localctx, 4);
			{
			setState(63);
			match(Variable);
			setState(64);
			match(Or);
			setState(65);
			match(Variable);
			}
			break;
		}
		exitRule();
		return _localctx;
	}

	public static class HexaDispContext extends ParserRuleContext {
		public TerminalNode Hexa() { return getToken(ScriptParser.Hexa, 0); }
		public HexaDispContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_hexaDisp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScriptListener ) ((ScriptListener)listener).enterHexaDisp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScriptListener ) ((ScriptListener)listener).exitHexaDisp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScriptVisitor ) return ((ScriptVisitor<? extends T>)visitor).visitHexaDisp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HexaDispContext hexaDisp() throws RecognitionException {
		HexaDispContext _localctx = new HexaDispContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_hexaDisp);

		enterOuterAlt(_localctx, 1);
		{
		setState(68);
		match(Hexa);
		}
		exitRule();
		return _localctx;
	}

	public static class IntegerDispContext extends ParserRuleContext {
		public TerminalNode Int() { return getToken(ScriptParser.Int, 0); }
		public IntegerDispContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_integerDisp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScriptListener ) ((ScriptListener)listener).enterIntegerDisp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScriptListener ) ((ScriptListener)listener).exitIntegerDisp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScriptVisitor ) return ((ScriptVisitor<? extends T>)visitor).visitIntegerDisp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntegerDispContext integerDisp() throws RecognitionException {
		IntegerDispContext _localctx = new IntegerDispContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_integerDisp);

		enterOuterAlt(_localctx, 1);
		{
		setState(70);
		match(Int);
		}
		exitRule();
		return _localctx;
	}

	public static class GotoExpressionContext extends ParserRuleContext {
		public TerminalNode GotoBegin() { return getToken(ScriptParser.GotoBegin, 0); }
		public TerminalNode LabelId() { return getToken(ScriptParser.LabelId, 0); }
		public GotoExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gotoExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScriptListener ) ((ScriptListener)listener).enterGotoExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScriptListener ) ((ScriptListener)listener).exitGotoExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScriptVisitor ) return ((ScriptVisitor<? extends T>)visitor).visitGotoExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GotoExpressionContext gotoExpression() throws RecognitionException {
		GotoExpressionContext _localctx = new GotoExpressionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_gotoExpression);

		enterOuterAlt(_localctx, 1);
		{
		setState(72);
		match(GotoBegin);
		setState(73);
		match(LabelId);
		}
		exitRule();
		return _localctx;
	}

	public static class LabelExpressionContext extends ParserRuleContext {
		public TerminalNode LabelBegin() { return getToken(ScriptParser.LabelBegin, 0); }
		public TerminalNode LabelId() { return getToken(ScriptParser.LabelId, 0); }
		public LabelExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_labelExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScriptListener ) ((ScriptListener)listener).enterLabelExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScriptListener ) ((ScriptListener)listener).exitLabelExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScriptVisitor ) return ((ScriptVisitor<? extends T>)visitor).visitLabelExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LabelExpressionContext labelExpression() throws RecognitionException {
		LabelExpressionContext _localctx = new LabelExpressionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_labelExpression);

		enterOuterAlt(_localctx, 1);
		{
		setState(75);
		match(LabelBegin);
		setState(76);
		match(LabelId);
		}
		exitRule();
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\22Q\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\3"+
		"\2\3\2\3\2\3\3\3\3\5\3\34\n\3\7\3\36\n\3\f\3\16\3!\13\3\3\4\3\4\3\4\3"+
		"\4\3\4\5\4(\n\4\3\4\3\4\3\4\5\4-\n\4\3\5\3\5\3\5\3\5\3\5\5\5\64\n\5\3"+
		"\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7E\n\7\3"+
		"\b\3\b\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3\13\2\2\f\2\4\6\b\n\f\16\20"+
		"\22\24\2\2R\2\26\3\2\2\2\4\37\3\2\2\2\6,\3\2\2\2\b.\3\2\2\2\n\65\3\2\2"+
		"\2\fD\3\2\2\2\16F\3\2\2\2\20H\3\2\2\2\22J\3\2\2\2\24M\3\2\2\2\26\27\5"+
		"\4\3\2\27\30\7\2\2\3\30\3\3\2\2\2\31\33\5\6\4\2\32\34\7\21\2\2\33\32\3"+
		"\2\2\2\33\34\3\2\2\2\34\36\3\2\2\2\35\31\3\2\2\2\36!\3\2\2\2\37\35\3\2"+
		"\2\2\37 \3\2\2\2 \5\3\2\2\2!\37\3\2\2\2\"(\5\b\5\2#(\5\n\6\2$(\5\f\7\2"+
		"%(\5\22\n\2&(\5\24\13\2\'\"\3\2\2\2\'#\3\2\2\2\'$\3\2\2\2\'%\3\2\2\2\'"+
		"&\3\2\2\2()\3\2\2\2)*\7\t\2\2*-\3\2\2\2+-\7\21\2\2,\'\3\2\2\2,+\3\2\2"+
		"\2-\7\3\2\2\2./\7\f\2\2/\63\7\3\2\2\60\64\7\f\2\2\61\64\5\20\t\2\62\64"+
		"\5\16\b\2\63\60\3\2\2\2\63\61\3\2\2\2\63\62\3\2\2\2\64\t\3\2\2\2\65\66"+
		"\7\6\2\2\66\67\7\f\2\2\67\13\3\2\2\289\7\f\2\29:\7\7\2\2:E\7\f\2\2;<\7"+
		"\f\2\2<=\7\b\2\2=E\7\f\2\2>?\7\f\2\2?@\7\5\2\2@E\7\f\2\2AB\7\f\2\2BC\7"+
		"\4\2\2CE\7\f\2\2D8\3\2\2\2D;\3\2\2\2D>\3\2\2\2DA\3\2\2\2E\r\3\2\2\2FG"+
		"\7\r\2\2G\17\3\2\2\2HI\7\16\2\2I\21\3\2\2\2JK\7\13\2\2KL\7\20\2\2L\23"+
		"\3\2\2\2MN\7\n\2\2NO\7\20\2\2O\25\3\2\2\2\b\33\37\',\63D";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}