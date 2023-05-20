package org.withered.tyr.chords.parsers;// Generated from D:/Code2/TYRH/Device_Info/src/main\ChordGrammar.g4 by ANTLR 4.10.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ChordGrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.10.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, RootNode=2, ChordAddition=3, ChordType=4, WS=5;
	public static final int
		RULE_progression = 0, RULE_chord = 1, RULE_main_part = 2, RULE_additions = 3;
	private static String[] makeRuleNames() {
		return new String[] {
			"progression", "chord", "main_part", "additions"
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

	@Override
	public String getGrammarFileName() { return "ChordGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ChordGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgressionContext extends ParserRuleContext {
		public List<ChordContext> chord() {
			return getRuleContexts(ChordContext.class);
		}
		public ChordContext chord(int i) {
			return getRuleContext(ChordContext.class,i);
		}
		public ProgressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_progression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ChordGrammarListener ) ((ChordGrammarListener)listener).enterProgression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ChordGrammarListener ) ((ChordGrammarListener)listener).exitProgression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ChordGrammarVisitor ) return ((ChordGrammarVisitor<? extends T>)visitor).visitProgression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgressionContext progression() throws RecognitionException {
		ProgressionContext _localctx = new ProgressionContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_progression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(8);
			chord();
			setState(13);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(9);
				match(T__0);
				setState(10);
				chord();
				}
				}
				setState(15);
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

	public static class ChordContext extends ParserRuleContext {
		public Main_partContext main_part() {
			return getRuleContext(Main_partContext.class,0);
		}
		public AdditionsContext additions() {
			return getRuleContext(AdditionsContext.class,0);
		}
		public ChordContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_chord; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ChordGrammarListener ) ((ChordGrammarListener)listener).enterChord(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ChordGrammarListener ) ((ChordGrammarListener)listener).exitChord(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ChordGrammarVisitor ) return ((ChordGrammarVisitor<? extends T>)visitor).visitChord(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ChordContext chord() throws RecognitionException {
		ChordContext _localctx = new ChordContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_chord);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(16);
			main_part();
			setState(17);
			additions();
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

	public static class Main_partContext extends ParserRuleContext {
		public TerminalNode RootNode() { return getToken(ChordGrammarParser.RootNode, 0); }
		public TerminalNode ChordType() { return getToken(ChordGrammarParser.ChordType, 0); }
		public Main_partContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_main_part; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ChordGrammarListener ) ((ChordGrammarListener)listener).enterMain_part(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ChordGrammarListener ) ((ChordGrammarListener)listener).exitMain_part(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ChordGrammarVisitor ) return ((ChordGrammarVisitor<? extends T>)visitor).visitMain_part(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Main_partContext main_part() throws RecognitionException {
		Main_partContext _localctx = new Main_partContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_main_part);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(19);
			match(RootNode);
			setState(21);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ChordType) {
				{
				setState(20);
				match(ChordType);
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

	public static class AdditionsContext extends ParserRuleContext {
		public List<TerminalNode> ChordAddition() { return getTokens(ChordGrammarParser.ChordAddition); }
		public TerminalNode ChordAddition(int i) {
			return getToken(ChordGrammarParser.ChordAddition, i);
		}
		public AdditionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_additions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ChordGrammarListener ) ((ChordGrammarListener)listener).enterAdditions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ChordGrammarListener ) ((ChordGrammarListener)listener).exitAdditions(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ChordGrammarVisitor ) return ((ChordGrammarVisitor<? extends T>)visitor).visitAdditions(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AdditionsContext additions() throws RecognitionException {
		AdditionsContext _localctx = new AdditionsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_additions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(26);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ChordAddition) {
				{
				{
				setState(23);
				match(ChordAddition);
				}
				}
				setState(28);
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

	public static final String _serializedATN =
		"\u0004\u0001\u0005\u001e\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0005\u0000\f\b\u0000\n\u0000\f\u0000\u000f\t\u0000\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0003\u0002\u0016"+
		"\b\u0002\u0001\u0003\u0005\u0003\u0019\b\u0003\n\u0003\f\u0003\u001c\t"+
		"\u0003\u0001\u0003\u0000\u0000\u0004\u0000\u0002\u0004\u0006\u0000\u0000"+
		"\u001c\u0000\b\u0001\u0000\u0000\u0000\u0002\u0010\u0001\u0000\u0000\u0000"+
		"\u0004\u0013\u0001\u0000\u0000\u0000\u0006\u001a\u0001\u0000\u0000\u0000"+
		"\b\r\u0003\u0002\u0001\u0000\t\n\u0005\u0001\u0000\u0000\n\f\u0003\u0002"+
		"\u0001\u0000\u000b\t\u0001\u0000\u0000\u0000\f\u000f\u0001\u0000\u0000"+
		"\u0000\r\u000b\u0001\u0000\u0000\u0000\r\u000e\u0001\u0000\u0000\u0000"+
		"\u000e\u0001\u0001\u0000\u0000\u0000\u000f\r\u0001\u0000\u0000\u0000\u0010"+
		"\u0011\u0003\u0004\u0002\u0000\u0011\u0012\u0003\u0006\u0003\u0000\u0012"+
		"\u0003\u0001\u0000\u0000\u0000\u0013\u0015\u0005\u0002\u0000\u0000\u0014"+
		"\u0016\u0005\u0004\u0000\u0000\u0015\u0014\u0001\u0000\u0000\u0000\u0015"+
		"\u0016\u0001\u0000\u0000\u0000\u0016\u0005\u0001\u0000\u0000\u0000\u0017"+
		"\u0019\u0005\u0003\u0000\u0000\u0018\u0017\u0001\u0000\u0000\u0000\u0019"+
		"\u001c\u0001\u0000\u0000\u0000\u001a\u0018\u0001\u0000\u0000\u0000\u001a"+
		"\u001b\u0001\u0000\u0000\u0000\u001b\u0007\u0001\u0000\u0000\u0000\u001c"+
		"\u001a\u0001\u0000\u0000\u0000\u0003\r\u0015\u001a";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}