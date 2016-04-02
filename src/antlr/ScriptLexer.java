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
		Comment=10, WS=11;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"Equals", "Or", "And", "Not", "Add", "Sub", "Variable", "Int", "Hexa", 
		"Comment", "WS"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\rQ\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3"+
		"\b\3\t\6\t*\n\t\r\t\16\t+\3\n\6\n/\n\n\r\n\16\n\60\3\13\3\13\3\13\3\13"+
		"\7\13\67\n\13\f\13\16\13:\13\13\3\13\3\13\3\13\3\13\7\13@\n\13\f\13\16"+
		"\13C\13\13\3\13\3\13\5\13G\n\13\3\13\3\13\3\f\6\fL\n\f\r\f\16\fM\3\f\3"+
		"\f\3A\2\r\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\3\2\7\3\2"+
		"\629\3\2\62;\6\2\62;C\\aac|\4\2\f\f\17\17\5\2\13\f\17\17\"\"V\2\3\3\2"+
		"\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17"+
		"\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\3\31\3\2"+
		"\2\2\5\33\3\2\2\2\7\35\3\2\2\2\t\37\3\2\2\2\13!\3\2\2\2\r#\3\2\2\2\17"+
		"%\3\2\2\2\21)\3\2\2\2\23.\3\2\2\2\25F\3\2\2\2\27K\3\2\2\2\31\32\7?\2\2"+
		"\32\4\3\2\2\2\33\34\7~\2\2\34\6\3\2\2\2\35\36\7(\2\2\36\b\3\2\2\2\37 "+
		"\7#\2\2 \n\3\2\2\2!\"\7-\2\2\"\f\3\2\2\2#$\7/\2\2$\16\3\2\2\2%&\7T\2\2"+
		"&\'\t\2\2\2\'\20\3\2\2\2(*\t\3\2\2)(\3\2\2\2*+\3\2\2\2+)\3\2\2\2+,\3\2"+
		"\2\2,\22\3\2\2\2-/\t\4\2\2.-\3\2\2\2/\60\3\2\2\2\60.\3\2\2\2\60\61\3\2"+
		"\2\2\61\24\3\2\2\2\62\63\7\61\2\2\63\64\7\61\2\2\648\3\2\2\2\65\67\n\5"+
		"\2\2\66\65\3\2\2\2\67:\3\2\2\28\66\3\2\2\289\3\2\2\29G\3\2\2\2:8\3\2\2"+
		"\2;<\7\61\2\2<=\7,\2\2=A\3\2\2\2>@\13\2\2\2?>\3\2\2\2@C\3\2\2\2AB\3\2"+
		"\2\2A?\3\2\2\2BD\3\2\2\2CA\3\2\2\2DE\7,\2\2EG\7\61\2\2F\62\3\2\2\2F;\3"+
		"\2\2\2GH\3\2\2\2HI\b\13\2\2I\26\3\2\2\2JL\t\6\2\2KJ\3\2\2\2LM\3\2\2\2"+
		"MK\3\2\2\2MN\3\2\2\2NO\3\2\2\2OP\b\f\2\2P\30\3\2\2\2\t\2+\608AFM\3\b\2"+
		"\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}