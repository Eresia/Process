// Generated from Script.g4 by ANTLR 4.5.3

	package antlr;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ScriptLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		Equals=1, Or=2, And=3, Not=4, Add=5, Sub=6, Variable=7, Int=8, Hexa=9, 
		HexaOpen=10, HexaClose=11, Comment=12, WS=13;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"Equals", "Or", "And", "Not", "Add", "Sub", "Variable", "Int", "Hexa", 
		"HexaOpen", "HexaClose", "Comment", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'='", "'|'", "'&'", "'!'", "'+'", "'-'", null, null, null, "'('", 
		"')'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "Equals", "Or", "And", "Not", "Add", "Sub", "Variable", "Int", "Hexa", 
		"HexaOpen", "HexaClose", "Comment", "WS"
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


	public ScriptLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Script.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\17Y\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6"+
		"\3\7\3\7\3\b\3\b\3\b\3\t\6\t.\n\t\r\t\16\t/\3\n\6\n\63\n\n\r\n\16\n\64"+
		"\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\r\7\r?\n\r\f\r\16\rB\13\r\3\r\3\r\3\r"+
		"\3\r\7\rH\n\r\f\r\16\rK\13\r\3\r\3\r\5\rO\n\r\3\r\3\r\3\16\6\16T\n\16"+
		"\r\16\16\16U\3\16\3\16\3I\2\17\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13"+
		"\25\f\27\r\31\16\33\17\3\2\7\3\2\629\3\2\62;\5\2\62;C\\c|\4\2\f\f\17\17"+
		"\5\2\13\f\17\17\"\"^\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2"+
		"\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3"+
		"\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\3\35\3\2\2\2\5\37\3\2\2"+
		"\2\7!\3\2\2\2\t#\3\2\2\2\13%\3\2\2\2\r\'\3\2\2\2\17)\3\2\2\2\21-\3\2\2"+
		"\2\23\62\3\2\2\2\25\66\3\2\2\2\278\3\2\2\2\31N\3\2\2\2\33S\3\2\2\2\35"+
		"\36\7?\2\2\36\4\3\2\2\2\37 \7~\2\2 \6\3\2\2\2!\"\7(\2\2\"\b\3\2\2\2#$"+
		"\7#\2\2$\n\3\2\2\2%&\7-\2\2&\f\3\2\2\2\'(\7/\2\2(\16\3\2\2\2)*\7T\2\2"+
		"*+\t\2\2\2+\20\3\2\2\2,.\t\3\2\2-,\3\2\2\2./\3\2\2\2/-\3\2\2\2/\60\3\2"+
		"\2\2\60\22\3\2\2\2\61\63\t\4\2\2\62\61\3\2\2\2\63\64\3\2\2\2\64\62\3\2"+
		"\2\2\64\65\3\2\2\2\65\24\3\2\2\2\66\67\7*\2\2\67\26\3\2\2\289\7+\2\29"+
		"\30\3\2\2\2:;\7\61\2\2;<\7\61\2\2<@\3\2\2\2=?\n\5\2\2>=\3\2\2\2?B\3\2"+
		"\2\2@>\3\2\2\2@A\3\2\2\2AO\3\2\2\2B@\3\2\2\2CD\7\61\2\2DE\7,\2\2EI\3\2"+
		"\2\2FH\13\2\2\2GF\3\2\2\2HK\3\2\2\2IJ\3\2\2\2IG\3\2\2\2JL\3\2\2\2KI\3"+
		"\2\2\2LM\7,\2\2MO\7\61\2\2N:\3\2\2\2NC\3\2\2\2OP\3\2\2\2PQ\b\r\2\2Q\32"+
		"\3\2\2\2RT\t\6\2\2SR\3\2\2\2TU\3\2\2\2US\3\2\2\2UV\3\2\2\2VW\3\2\2\2W"+
		"X\b\16\2\2X\34\3\2\2\2\n\2/\62\64@INU\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}