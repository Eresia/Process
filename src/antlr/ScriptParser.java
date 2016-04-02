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
		RULE_operation = 5;
	public static final String[] ruleNames = {
		"parse", "block", "line", "assignVar", "notExpression", "operation"
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
			setState(12);
			block();
			}
			setState(13);
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
			setState(21);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Not) | (1L << Variable) | (1L << Comment))) != 0)) {
				{
				{
				setState(15);
				line();
				setState(17);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(16);
					match(Comment);
					}
					break;
				}
				}
				}
				setState(23);
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
			setState(28);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(24);
				assignVar();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(25);
				notExpression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(26);
				operation();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				{
				setState(27);
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
		public TerminalNode Hexa() { return getToken(ScriptParser.Hexa, 0); }
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(30);
			match(Variable);
			setState(31);
			match(Equals);
			setState(32);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Variable) | (1L << Int) | (1L << Hexa))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
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
			setState(34);
			match(Not);
			setState(35);
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
			setState(49);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(37);
				match(Variable);
				setState(38);
				match(Add);
				setState(39);
				match(Variable);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(40);
				match(Variable);
				setState(41);
				match(Sub);
				setState(42);
				match(Variable);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(43);
				match(Variable);
				setState(44);
				match(And);
				setState(45);
				match(Variable);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(46);
				match(Variable);
				setState(47);
				match(Or);
				setState(48);
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

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\r\66\4\2\t\2\4\3"+
		"\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\3\2\3\2\3\3\3\3\5\3\24\n\3\7"+
		"\3\26\n\3\f\3\16\3\31\13\3\3\4\3\4\3\4\3\4\5\4\37\n\4\3\5\3\5\3\5\3\5"+
		"\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\64\n"+
		"\7\3\7\2\2\b\2\4\6\b\n\f\2\3\3\2\t\13\67\2\16\3\2\2\2\4\27\3\2\2\2\6\36"+
		"\3\2\2\2\b \3\2\2\2\n$\3\2\2\2\f\63\3\2\2\2\16\17\5\4\3\2\17\20\7\2\2"+
		"\3\20\3\3\2\2\2\21\23\5\6\4\2\22\24\7\f\2\2\23\22\3\2\2\2\23\24\3\2\2"+
		"\2\24\26\3\2\2\2\25\21\3\2\2\2\26\31\3\2\2\2\27\25\3\2\2\2\27\30\3\2\2"+
		"\2\30\5\3\2\2\2\31\27\3\2\2\2\32\37\5\b\5\2\33\37\5\n\6\2\34\37\5\f\7"+
		"\2\35\37\7\f\2\2\36\32\3\2\2\2\36\33\3\2\2\2\36\34\3\2\2\2\36\35\3\2\2"+
		"\2\37\7\3\2\2\2 !\7\t\2\2!\"\7\3\2\2\"#\t\2\2\2#\t\3\2\2\2$%\7\6\2\2%"+
		"&\7\t\2\2&\13\3\2\2\2\'(\7\t\2\2()\7\7\2\2)\64\7\t\2\2*+\7\t\2\2+,\7\b"+
		"\2\2,\64\7\t\2\2-.\7\t\2\2./\7\5\2\2/\64\7\t\2\2\60\61\7\t\2\2\61\62\7"+
		"\4\2\2\62\64\7\t\2\2\63\'\3\2\2\2\63*\3\2\2\2\63-\3\2\2\2\63\60\3\2\2"+
		"\2\64\r\3\2\2\2\6\23\27\36\63";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}