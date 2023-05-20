package org.withered.tyr.chords.parsers;// Generated from D:/Code2/TYRH/Device_Info/src/main\ChordGrammar.g4 by ANTLR 4.10.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ChordGrammarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.10.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, RootNode=2, ChordAddition=3, ChordType=4, WS=5;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "RootNode", "Note", "ChordAddition", "BareAdditionPrefix", "BareAdditionNumber", 
			"ChordType", "BareChordType", "BareChordNumber", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'-'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, "RootNode", "ChordAddition", "ChordType", "WS"
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


	public ChordGrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "ChordGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u0005\u008c\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0003\u0001\u001a\b\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003"+
		")\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0003\u00041\b\u0004\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0003\u00058\b\u0005\u0001\u0006\u0001\u0006"+
		"\u0003\u0006<\b\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0003\u0006B\b\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0003\u0007\u0080\b\u0007\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0003\b\u0087\b\b\u0001\t\u0001\t\u0001\t\u0001\t\u0000"+
		"\u0000\n\u0001\u0001\u0003\u0002\u0005\u0000\u0007\u0003\t\u0000\u000b"+
		"\u0000\r\u0004\u000f\u0000\u0011\u0000\u0013\u0005\u0001\u0000\u0006\u0002"+
		"\u0000##bb\u0001\u0000AG\u0002\u00002799\u0002\u0000MMmm\u0002\u00007"+
		"799\u0002\u0000\t\t  \u009d\u0000\u0001\u0001\u0000\u0000\u0000\u0000"+
		"\u0003\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000"+
		"\r\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0001\u0015"+
		"\u0001\u0000\u0000\u0000\u0003\u0017\u0001\u0000\u0000\u0000\u0005\u001b"+
		"\u0001\u0000\u0000\u0000\u0007(\u0001\u0000\u0000\u0000\t0\u0001\u0000"+
		"\u0000\u0000\u000b7\u0001\u0000\u0000\u0000\rA\u0001\u0000\u0000\u0000"+
		"\u000f\u007f\u0001\u0000\u0000\u0000\u0011\u0086\u0001\u0000\u0000\u0000"+
		"\u0013\u0088\u0001\u0000\u0000\u0000\u0015\u0016\u0005-\u0000\u0000\u0016"+
		"\u0002\u0001\u0000\u0000\u0000\u0017\u0019\u0003\u0005\u0002\u0000\u0018"+
		"\u001a\u0007\u0000\u0000\u0000\u0019\u0018\u0001\u0000\u0000\u0000\u0019"+
		"\u001a\u0001\u0000\u0000\u0000\u001a\u0004\u0001\u0000\u0000\u0000\u001b"+
		"\u001c\u0007\u0001\u0000\u0000\u001c\u0006\u0001\u0000\u0000\u0000\u001d"+
		"\u001e\u0005s\u0000\u0000\u001e\u001f\u0005u\u0000\u0000\u001f \u0005"+
		"s\u0000\u0000 )\u00052\u0000\u0000!\"\u0005s\u0000\u0000\"#\u0005u\u0000"+
		"\u0000#$\u0005s\u0000\u0000$)\u00054\u0000\u0000%&\u0003\t\u0004\u0000"+
		"&\'\u0003\u000b\u0005\u0000\')\u0001\u0000\u0000\u0000(\u001d\u0001\u0000"+
		"\u0000\u0000(!\u0001\u0000\u0000\u0000(%\u0001\u0000\u0000\u0000)\b\u0001"+
		"\u0000\u0000\u0000*1\u0007\u0000\u0000\u0000+,\u0005a\u0000\u0000,-\u0005"+
		"d\u0000\u0000-1\u0005d\u0000\u0000./\u0005n\u0000\u0000/1\u0005o\u0000"+
		"\u00000*\u0001\u0000\u0000\u00000+\u0001\u0000\u0000\u00000.\u0001\u0000"+
		"\u0000\u00001\n\u0001\u0000\u0000\u000028\u0007\u0002\u0000\u000034\u0005"+
		"1\u0000\u000048\u00051\u0000\u000056\u00051\u0000\u000068\u00053\u0000"+
		"\u000072\u0001\u0000\u0000\u000073\u0001\u0000\u0000\u000075\u0001\u0000"+
		"\u0000\u00008\f\u0001\u0000\u0000\u00009;\u0003\u000f\u0007\u0000:<\u0003"+
		"\u0011\b\u0000;:\u0001\u0000\u0000\u0000;<\u0001\u0000\u0000\u0000<B\u0001"+
		"\u0000\u0000\u0000=B\u0003\u0011\b\u0000>?\u00056\u0000\u0000?B\u0005"+
		"9\u0000\u0000@B\u000256\u0000A9\u0001\u0000\u0000\u0000A=\u0001\u0000"+
		"\u0000\u0000A>\u0001\u0000\u0000\u0000A@\u0001\u0000\u0000\u0000B\u000e"+
		"\u0001\u0000\u0000\u0000C\u0080\u0007\u0003\u0000\u0000DE\u0005d\u0000"+
		"\u0000EF\u0005i\u0000\u0000F\u0080\u0005m\u0000\u0000GH\u0005a\u0000\u0000"+
		"HI\u0005u\u0000\u0000I\u0080\u0005g\u0000\u0000JK\u0005a\u0000\u0000K"+
		"L\u0005l\u0000\u0000L\u0080\u0005t\u0000\u0000MN\u0005I\u0000\u0000NO"+
		"\u0005o\u0000\u0000OP\u0005n\u0000\u0000PQ\u0005i\u0000\u0000QR\u0005"+
		"a\u0000\u0000R\u0080\u0005n\u0000\u0000ST\u0005D\u0000\u0000TU\u0005o"+
		"\u0000\u0000UV\u0005r\u0000\u0000VW\u0005i\u0000\u0000WX\u0005a\u0000"+
		"\u0000X\u0080\u0005n\u0000\u0000YZ\u0005P\u0000\u0000Z[\u0005h\u0000\u0000"+
		"[\\\u0005r\u0000\u0000\\]\u0005y\u0000\u0000]^\u0005g\u0000\u0000^_\u0005"+
		"i\u0000\u0000_`\u0005a\u0000\u0000`\u0080\u0005n\u0000\u0000ab\u0005L"+
		"\u0000\u0000bc\u0005y\u0000\u0000cd\u0005d\u0000\u0000de\u0005i\u0000"+
		"\u0000ef\u0005a\u0000\u0000f\u0080\u0005n\u0000\u0000gh\u0005M\u0000\u0000"+
		"hi\u0005i\u0000\u0000ij\u0005x\u0000\u0000jk\u0005o\u0000\u0000kl\u0005"+
		"l\u0000\u0000lm\u0005y\u0000\u0000mn\u0005d\u0000\u0000no\u0005i\u0000"+
		"\u0000op\u0005a\u0000\u0000p\u0080\u0005n\u0000\u0000qr\u0005A\u0000\u0000"+
		"rs\u0005e\u0000\u0000st\u0005o\u0000\u0000tu\u0005l\u0000\u0000uv\u0005"+
		"i\u0000\u0000vw\u0005a\u0000\u0000w\u0080\u0005n\u0000\u0000xy\u0005L"+
		"\u0000\u0000yz\u0005o\u0000\u0000z{\u0005c\u0000\u0000{|\u0005r\u0000"+
		"\u0000|}\u0005i\u0000\u0000}~\u0005a\u0000\u0000~\u0080\u0005n\u0000\u0000"+
		"\u007fC\u0001\u0000\u0000\u0000\u007fD\u0001\u0000\u0000\u0000\u007fG"+
		"\u0001\u0000\u0000\u0000\u007fJ\u0001\u0000\u0000\u0000\u007fM\u0001\u0000"+
		"\u0000\u0000\u007fS\u0001\u0000\u0000\u0000\u007fY\u0001\u0000\u0000\u0000"+
		"\u007fa\u0001\u0000\u0000\u0000\u007fg\u0001\u0000\u0000\u0000\u007fq"+
		"\u0001\u0000\u0000\u0000\u007fx\u0001\u0000\u0000\u0000\u0080\u0010\u0001"+
		"\u0000\u0000\u0000\u0081\u0087\u0007\u0004\u0000\u0000\u0082\u0083\u0005"+
		"1\u0000\u0000\u0083\u0087\u00051\u0000\u0000\u0084\u0085\u00051\u0000"+
		"\u0000\u0085\u0087\u00053\u0000\u0000\u0086\u0081\u0001\u0000\u0000\u0000"+
		"\u0086\u0082\u0001\u0000\u0000\u0000\u0086\u0084\u0001\u0000\u0000\u0000"+
		"\u0087\u0012\u0001\u0000\u0000\u0000\u0088\u0089\u0007\u0005\u0000\u0000"+
		"\u0089\u008a\u0001\u0000\u0000\u0000\u008a\u008b\u0006\t\u0000\u0000\u008b"+
		"\u0014\u0001\u0000\u0000\u0000\t\u0000\u0019(07;A\u007f\u0086\u0001\u0006"+
		"\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}