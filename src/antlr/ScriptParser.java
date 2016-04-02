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
		Equals=1, Or=2, And=3, Not=4, Add=5, Sub=6, Variable=7, Int=8, Hexa=9, 
		Comment=10, WS=11;
	public static final int
		RULE_parse = 0, RULE_block = 1, RULE_line = 2, RULE_assignVar = 3, RULE_notExpression = 4, 
		RULE_operation = 5, RULE_hexaDisp = 6, RULE_integerDisp = 7;
	public static final String[] ruleNames = {
		"parse", "block", "line", "assignVar", "notExpression", "operation", "hexaDisp", 
		"integerDisp"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'='", "'|'", "'&'", "'!'", "'+'", "'-'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "Equals", "Or", "And", "Not", "Add", "Sub", "Variable", "Int", "Hexa", 
		"Comment", "WS"
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(16);
			block();
			}
			setState(17);
			match(EOF);
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(25);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Not) | (1L << Variable) | (1L << Comment))) != 0)) {
				{
				{
				setState(19);
				line();
				setState(21);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(20);
					match(Comment);
					}
					break;
				}
				}
				}
				setState(27);
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

	public static class LineContext extends ParserRuleContext {
		public AssignVarContext assignVar() {
			return getRuleContext(AssignVarContext.class,0);
		}
		public NotExpressionContext notExpression() {
			return getRuleContext(NotExpressionContext.class,0);
		}
		public OperationContext operation() {
			return getRuleContext(OperationContext.class,0);
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
		try {
			setState(32);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(28);
				assignVar();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(29);
				notExpression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(30);
				operation();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				{
				setState(31);
				match(Comment);
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

	public static class AssignVarContext extends ParserRuleContext {
		public List<TerminalNode> Variable() { return getTokens(ScriptParser.Variable); }
		public TerminalNode Variable(int i) {
			return getToken(ScriptParser.Variable, i);
		}
		public TerminalNode Equals() { return getToken(ScriptParser.Equals, 0); }
		public TerminalNode Int() { return getToken(ScriptParser.Int, 0); }
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34);
			match(Variable);
			setState(35);
			match(Equals);
			setState(39);
			switch (_input.LA(1)) {
			case Variable:
				{
				setState(36);
				match(Variable);
				}
				break;
			case Int:
				{
				setState(37);
				match(Int);
				}
				break;
			case Hexa:
				{
				setState(38);
				hexaDisp();
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(41);
			match(Not);
			setState(42);
			match(Variable);
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
		try {
			setState(56);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(44);
				match(Variable);
				setState(45);
				match(Add);
				setState(46);
				match(Variable);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(47);
				match(Variable);
				setState(48);
				match(Sub);
				setState(49);
				match(Variable);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(50);
				match(Variable);
				setState(51);
				match(And);
				setState(52);
				match(Variable);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(53);
				match(Variable);
				setState(54);
				match(Or);
				setState(55);
				match(Variable);
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(58);
			match(Hexa);
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			match(Int);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\rA\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\3\2\3\2\3\3\3\3"+
		"\5\3\30\n\3\7\3\32\n\3\f\3\16\3\35\13\3\3\4\3\4\3\4\3\4\5\4#\n\4\3\5\3"+
		"\5\3\5\3\5\3\5\5\5*\n\5\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\5\7;\n\7\3\b\3\b\3\t\3\t\3\t\2\2\n\2\4\6\b\n\f\16\20\2"+
		"\2B\2\22\3\2\2\2\4\33\3\2\2\2\6\"\3\2\2\2\b$\3\2\2\2\n+\3\2\2\2\f:\3\2"+
		"\2\2\16<\3\2\2\2\20>\3\2\2\2\22\23\5\4\3\2\23\24\7\2\2\3\24\3\3\2\2\2"+
		"\25\27\5\6\4\2\26\30\7\f\2\2\27\26\3\2\2\2\27\30\3\2\2\2\30\32\3\2\2\2"+
		"\31\25\3\2\2\2\32\35\3\2\2\2\33\31\3\2\2\2\33\34\3\2\2\2\34\5\3\2\2\2"+
		"\35\33\3\2\2\2\36#\5\b\5\2\37#\5\n\6\2 #\5\f\7\2!#\7\f\2\2\"\36\3\2\2"+
		"\2\"\37\3\2\2\2\" \3\2\2\2\"!\3\2\2\2#\7\3\2\2\2$%\7\t\2\2%)\7\3\2\2&"+
		"*\7\t\2\2\'*\7\n\2\2(*\5\16\b\2)&\3\2\2\2)\'\3\2\2\2)(\3\2\2\2*\t\3\2"+
		"\2\2+,\7\6\2\2,-\7\t\2\2-\13\3\2\2\2./\7\t\2\2/\60\7\7\2\2\60;\7\t\2\2"+
		"\61\62\7\t\2\2\62\63\7\b\2\2\63;\7\t\2\2\64\65\7\t\2\2\65\66\7\5\2\2\66"+
		";\7\t\2\2\678\7\t\2\289\7\4\2\29;\7\t\2\2:.\3\2\2\2:\61\3\2\2\2:\64\3"+
		"\2\2\2:\67\3\2\2\2;\r\3\2\2\2<=\7\13\2\2=\17\3\2\2\2>?\7\n\2\2?\21\3\2"+
		"\2\2\7\27\33\"):";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}