// Generated from ufscar/dc/compiladores/gramatica/gramaticaAgenda.g4 by ANTLR 4.8
package ufscar.dc.compiladores.gramatica;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class gramaticaAgendaParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, COMENTARIO=4, ESPACO=5, DELIM=6, NUM_INT=7, PALAVRA_CHAVE=8, 
		MES=9, CADEIA=10, Erro_cadeia_nao_fechada=11;
	public static final int
		RULE_calendario = 0, RULE_corpoAno = 1, RULE_corpoMes = 2, RULE_corpoDia = 3, 
		RULE_corpoHorario = 4, RULE_horario = 5, RULE_descricao = 6;
	private static String[] makeRuleNames() {
		return new String[] {
			"calendario", "corpoAno", "corpoMes", "corpoDia", "corpoHorario", "horario", 
			"descricao"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'ano'", "'dia'", "'h'", null, null, "':'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, "COMENTARIO", "ESPACO", "DELIM", "NUM_INT", "PALAVRA_CHAVE", 
			"MES", "CADEIA", "Erro_cadeia_nao_fechada"
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
	public String getGrammarFileName() { return "gramaticaAgenda.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public gramaticaAgendaParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class CalendarioContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(gramaticaAgendaParser.EOF, 0); }
		public List<CorpoAnoContext> corpoAno() {
			return getRuleContexts(CorpoAnoContext.class);
		}
		public CorpoAnoContext corpoAno(int i) {
			return getRuleContext(CorpoAnoContext.class,i);
		}
		public CalendarioContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_calendario; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gramaticaAgendaListener ) ((gramaticaAgendaListener)listener).enterCalendario(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gramaticaAgendaListener ) ((gramaticaAgendaListener)listener).exitCalendario(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gramaticaAgendaVisitor ) return ((gramaticaAgendaVisitor<? extends T>)visitor).visitCalendario(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CalendarioContext calendario() throws RecognitionException {
		CalendarioContext _localctx = new CalendarioContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_calendario);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(15); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(14);
				corpoAno();
				}
				}
				setState(17); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__0 );
			setState(19);
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

	public static class CorpoAnoContext extends ParserRuleContext {
		public TerminalNode NUM_INT() { return getToken(gramaticaAgendaParser.NUM_INT, 0); }
		public List<CorpoMesContext> corpoMes() {
			return getRuleContexts(CorpoMesContext.class);
		}
		public CorpoMesContext corpoMes(int i) {
			return getRuleContext(CorpoMesContext.class,i);
		}
		public CorpoAnoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_corpoAno; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gramaticaAgendaListener ) ((gramaticaAgendaListener)listener).enterCorpoAno(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gramaticaAgendaListener ) ((gramaticaAgendaListener)listener).exitCorpoAno(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gramaticaAgendaVisitor ) return ((gramaticaAgendaVisitor<? extends T>)visitor).visitCorpoAno(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CorpoAnoContext corpoAno() throws RecognitionException {
		CorpoAnoContext _localctx = new CorpoAnoContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_corpoAno);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(21);
			match(T__0);
			setState(22);
			match(NUM_INT);
			setState(24); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(23);
				corpoMes();
				}
				}
				setState(26); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==MES );
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

	public static class CorpoMesContext extends ParserRuleContext {
		public TerminalNode MES() { return getToken(gramaticaAgendaParser.MES, 0); }
		public List<CorpoDiaContext> corpoDia() {
			return getRuleContexts(CorpoDiaContext.class);
		}
		public CorpoDiaContext corpoDia(int i) {
			return getRuleContext(CorpoDiaContext.class,i);
		}
		public CorpoMesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_corpoMes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gramaticaAgendaListener ) ((gramaticaAgendaListener)listener).enterCorpoMes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gramaticaAgendaListener ) ((gramaticaAgendaListener)listener).exitCorpoMes(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gramaticaAgendaVisitor ) return ((gramaticaAgendaVisitor<? extends T>)visitor).visitCorpoMes(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CorpoMesContext corpoMes() throws RecognitionException {
		CorpoMesContext _localctx = new CorpoMesContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_corpoMes);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(28);
			match(MES);
			setState(30); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(29);
				corpoDia();
				}
				}
				setState(32); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__1 );
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

	public static class CorpoDiaContext extends ParserRuleContext {
		public TerminalNode NUM_INT() { return getToken(gramaticaAgendaParser.NUM_INT, 0); }
		public List<CorpoHorarioContext> corpoHorario() {
			return getRuleContexts(CorpoHorarioContext.class);
		}
		public CorpoHorarioContext corpoHorario(int i) {
			return getRuleContext(CorpoHorarioContext.class,i);
		}
		public CorpoDiaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_corpoDia; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gramaticaAgendaListener ) ((gramaticaAgendaListener)listener).enterCorpoDia(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gramaticaAgendaListener ) ((gramaticaAgendaListener)listener).exitCorpoDia(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gramaticaAgendaVisitor ) return ((gramaticaAgendaVisitor<? extends T>)visitor).visitCorpoDia(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CorpoDiaContext corpoDia() throws RecognitionException {
		CorpoDiaContext _localctx = new CorpoDiaContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_corpoDia);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(34);
			match(T__1);
			setState(35);
			match(NUM_INT);
			setState(37); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(36);
				corpoHorario();
				}
				}
				setState(39); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NUM_INT );
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

	public static class CorpoHorarioContext extends ParserRuleContext {
		public HorarioContext horario() {
			return getRuleContext(HorarioContext.class,0);
		}
		public TerminalNode DELIM() { return getToken(gramaticaAgendaParser.DELIM, 0); }
		public DescricaoContext descricao() {
			return getRuleContext(DescricaoContext.class,0);
		}
		public CorpoHorarioContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_corpoHorario; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gramaticaAgendaListener ) ((gramaticaAgendaListener)listener).enterCorpoHorario(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gramaticaAgendaListener ) ((gramaticaAgendaListener)listener).exitCorpoHorario(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gramaticaAgendaVisitor ) return ((gramaticaAgendaVisitor<? extends T>)visitor).visitCorpoHorario(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CorpoHorarioContext corpoHorario() throws RecognitionException {
		CorpoHorarioContext _localctx = new CorpoHorarioContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_corpoHorario);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(41);
			horario();
			setState(42);
			match(DELIM);
			setState(43);
			descricao();
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

	public static class HorarioContext extends ParserRuleContext {
		public List<TerminalNode> NUM_INT() { return getTokens(gramaticaAgendaParser.NUM_INT); }
		public TerminalNode NUM_INT(int i) {
			return getToken(gramaticaAgendaParser.NUM_INT, i);
		}
		public HorarioContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_horario; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gramaticaAgendaListener ) ((gramaticaAgendaListener)listener).enterHorario(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gramaticaAgendaListener ) ((gramaticaAgendaListener)listener).exitHorario(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gramaticaAgendaVisitor ) return ((gramaticaAgendaVisitor<? extends T>)visitor).visitHorario(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HorarioContext horario() throws RecognitionException {
		HorarioContext _localctx = new HorarioContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_horario);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(45);
			match(NUM_INT);
			setState(46);
			match(T__2);
			setState(47);
			match(NUM_INT);
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

	public static class DescricaoContext extends ParserRuleContext {
		public TerminalNode CADEIA() { return getToken(gramaticaAgendaParser.CADEIA, 0); }
		public DescricaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_descricao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gramaticaAgendaListener ) ((gramaticaAgendaListener)listener).enterDescricao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gramaticaAgendaListener ) ((gramaticaAgendaListener)listener).exitDescricao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof gramaticaAgendaVisitor ) return ((gramaticaAgendaVisitor<? extends T>)visitor).visitDescricao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DescricaoContext descricao() throws RecognitionException {
		DescricaoContext _localctx = new DescricaoContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_descricao);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(49);
			match(CADEIA);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\r\66\4\2\t\2\4\3"+
		"\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\6\2\22\n\2\r\2\16\2\23"+
		"\3\2\3\2\3\3\3\3\3\3\6\3\33\n\3\r\3\16\3\34\3\4\3\4\6\4!\n\4\r\4\16\4"+
		"\"\3\5\3\5\3\5\6\5(\n\5\r\5\16\5)\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\b"+
		"\3\b\3\b\2\2\t\2\4\6\b\n\f\16\2\2\2\62\2\21\3\2\2\2\4\27\3\2\2\2\6\36"+
		"\3\2\2\2\b$\3\2\2\2\n+\3\2\2\2\f/\3\2\2\2\16\63\3\2\2\2\20\22\5\4\3\2"+
		"\21\20\3\2\2\2\22\23\3\2\2\2\23\21\3\2\2\2\23\24\3\2\2\2\24\25\3\2\2\2"+
		"\25\26\7\2\2\3\26\3\3\2\2\2\27\30\7\3\2\2\30\32\7\t\2\2\31\33\5\6\4\2"+
		"\32\31\3\2\2\2\33\34\3\2\2\2\34\32\3\2\2\2\34\35\3\2\2\2\35\5\3\2\2\2"+
		"\36 \7\13\2\2\37!\5\b\5\2 \37\3\2\2\2!\"\3\2\2\2\" \3\2\2\2\"#\3\2\2\2"+
		"#\7\3\2\2\2$%\7\4\2\2%\'\7\t\2\2&(\5\n\6\2\'&\3\2\2\2()\3\2\2\2)\'\3\2"+
		"\2\2)*\3\2\2\2*\t\3\2\2\2+,\5\f\7\2,-\7\b\2\2-.\5\16\b\2.\13\3\2\2\2/"+
		"\60\7\t\2\2\60\61\7\5\2\2\61\62\7\t\2\2\62\r\3\2\2\2\63\64\7\f\2\2\64"+
		"\17\3\2\2\2\6\23\34\")";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}