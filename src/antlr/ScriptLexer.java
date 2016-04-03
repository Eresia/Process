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
		Equals=1, Or=2, And=3, Not=4, Add=5, Sub=6, EndLine=7, LabelBegin=8, GotoBegin=9, 
		Variable=10, Hexa=11, Int=12, HexaOpen=13, LabelId=14, Comment=15, WS=16;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"Equals", "Or", "And", "Not", "Add", "Sub", "EndLine", "LabelBegin", "GotoBegin", 
		"Variable", "Hexa", "Int", "HexaOpen", "LabelId", "Comment", "WS"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\22q\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3\2\3"+
		"\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\6\fB\n\f\r\f\16\fC\3\r\6\r"+
		"G\n\r\r\r\16\rH\3\16\3\16\3\16\3\17\6\17O\n\17\r\17\16\17P\3\20\3\20\3"+
		"\20\3\20\7\20W\n\20\f\20\16\20Z\13\20\3\20\3\20\3\20\3\20\7\20`\n\20\f"+
		"\20\16\20c\13\20\3\20\3\20\5\20g\n\20\3\20\3\20\3\21\6\21l\n\21\r\21\16"+
		"\21m\3\21\3\21\3a\2\22\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27"+
		"\r\31\16\33\17\35\20\37\21!\22\3\2\20\4\2NNnn\4\2CCcc\4\2DDdd\4\2GGgg"+
		"\4\2IIii\4\2QQqq\4\2VVvv\4\2TTtt\3\2\629\5\2\62;CHch\3\2\62;\4\2CHch\4"+
		"\2\f\f\17\17\5\2\13\f\17\17\"\"w\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2"+
		"\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2"+
		"\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2"+
		"\2\37\3\2\2\2\2!\3\2\2\2\3#\3\2\2\2\5%\3\2\2\2\7\'\3\2\2\2\t)\3\2\2\2"+
		"\13+\3\2\2\2\r-\3\2\2\2\17/\3\2\2\2\21\61\3\2\2\2\23\67\3\2\2\2\25<\3"+
		"\2\2\2\27?\3\2\2\2\31F\3\2\2\2\33J\3\2\2\2\35N\3\2\2\2\37f\3\2\2\2!k\3"+
		"\2\2\2#$\7?\2\2$\4\3\2\2\2%&\7~\2\2&\6\3\2\2\2\'(\7(\2\2(\b\3\2\2\2)*"+
		"\7#\2\2*\n\3\2\2\2+,\7-\2\2,\f\3\2\2\2-.\7/\2\2.\16\3\2\2\2/\60\7=\2\2"+
		"\60\20\3\2\2\2\61\62\t\2\2\2\62\63\t\3\2\2\63\64\t\4\2\2\64\65\t\5\2\2"+
		"\65\66\t\2\2\2\66\22\3\2\2\2\678\t\6\2\289\t\7\2\29:\t\b\2\2:;\t\7\2\2"+
		";\24\3\2\2\2<=\t\t\2\2=>\t\n\2\2>\26\3\2\2\2?A\5\33\16\2@B\t\13\2\2A@"+
		"\3\2\2\2BC\3\2\2\2CA\3\2\2\2CD\3\2\2\2D\30\3\2\2\2EG\t\f\2\2FE\3\2\2\2"+
		"GH\3\2\2\2HF\3\2\2\2HI\3\2\2\2I\32\3\2\2\2JK\7\62\2\2KL\7z\2\2L\34\3\2"+
		"\2\2MO\t\r\2\2NM\3\2\2\2OP\3\2\2\2PN\3\2\2\2PQ\3\2\2\2Q\36\3\2\2\2RS\7"+
		"\61\2\2ST\7\61\2\2TX\3\2\2\2UW\n\16\2\2VU\3\2\2\2WZ\3\2\2\2XV\3\2\2\2"+
		"XY\3\2\2\2Yg\3\2\2\2ZX\3\2\2\2[\\\7\61\2\2\\]\7,\2\2]a\3\2\2\2^`\13\2"+
		"\2\2_^\3\2\2\2`c\3\2\2\2ab\3\2\2\2a_\3\2\2\2bd\3\2\2\2ca\3\2\2\2de\7,"+
		"\2\2eg\7\61\2\2fR\3\2\2\2f[\3\2\2\2gh\3\2\2\2hi\b\20\2\2i \3\2\2\2jl\t"+
		"\17\2\2kj\3\2\2\2lm\3\2\2\2mk\3\2\2\2mn\3\2\2\2no\3\2\2\2op\b\21\2\2p"+
		"\"\3\2\2\2\f\2ACHNPXafm\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}