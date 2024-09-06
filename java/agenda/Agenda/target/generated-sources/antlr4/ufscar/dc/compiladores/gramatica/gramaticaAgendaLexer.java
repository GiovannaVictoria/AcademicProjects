// Generated from ufscar/dc/compiladores/gramatica/gramaticaAgenda.g4 by ANTLR 4.8
package ufscar.dc.compiladores.gramatica;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class gramaticaAgendaLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, COMENTARIO=4, ESPACO=5, DELIM=6, NUM_INT=7, PALAVRA_CHAVE=8, 
		MES=9, CADEIA=10, Erro_cadeia_nao_fechada=11;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "COMENTARIO", "ESPACO", "DELIM", "NUM_INT", "PALAVRA_CHAVE", 
			"MES", "CADEIA", "ESC_SEQ", "Digito", "Erro_cadeia_nao_fechada"
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


	public gramaticaAgendaLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "gramaticaAgenda.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\r\u00ad\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3"+
		"\4\3\5\3\5\7\5*\n\5\f\5\16\5-\13\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\7"+
		"\3\7\3\b\6\b:\n\b\r\b\16\b;\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\tE\n\t\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\5\n\u0094\n\n\3\13\3\13\3\13\7\13\u0099\n\13\f"+
		"\13\16\13\u009c\13\13\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\16\3\16\7\16\u00a7"+
		"\n\16\f\16\16\16\u00aa\13\16\3\16\3\16\2\2\17\3\3\5\4\7\5\t\6\13\7\r\b"+
		"\17\t\21\n\23\13\25\f\27\2\31\2\33\r\3\2\6\3\2\f\f\5\2\13\f\17\17\"\""+
		"\5\2\f\f$$^^\3\2$$\2\u00bc\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2"+
		"\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2"+
		"\25\3\2\2\2\2\33\3\2\2\2\3\35\3\2\2\2\5!\3\2\2\2\7%\3\2\2\2\t\'\3\2\2"+
		"\2\13\62\3\2\2\2\r\66\3\2\2\2\179\3\2\2\2\21D\3\2\2\2\23\u0093\3\2\2\2"+
		"\25\u0095\3\2\2\2\27\u009f\3\2\2\2\31\u00a2\3\2\2\2\33\u00a4\3\2\2\2\35"+
		"\36\7c\2\2\36\37\7p\2\2\37 \7q\2\2 \4\3\2\2\2!\"\7f\2\2\"#\7k\2\2#$\7"+
		"c\2\2$\6\3\2\2\2%&\7j\2\2&\b\3\2\2\2\'+\7%\2\2(*\n\2\2\2)(\3\2\2\2*-\3"+
		"\2\2\2+)\3\2\2\2+,\3\2\2\2,.\3\2\2\2-+\3\2\2\2./\7\f\2\2/\60\3\2\2\2\60"+
		"\61\b\5\2\2\61\n\3\2\2\2\62\63\t\3\2\2\63\64\3\2\2\2\64\65\b\6\2\2\65"+
		"\f\3\2\2\2\66\67\7<\2\2\67\16\3\2\2\28:\5\31\r\298\3\2\2\2:;\3\2\2\2;"+
		"9\3\2\2\2;<\3\2\2\2<\20\3\2\2\2=>\7c\2\2>?\7p\2\2?E\7q\2\2@A\7f\2\2AB"+
		"\7k\2\2BE\7c\2\2CE\7j\2\2D=\3\2\2\2D@\3\2\2\2DC\3\2\2\2E\22\3\2\2\2FG"+
		"\7L\2\2GH\7c\2\2HI\7p\2\2IJ\7g\2\2JK\7k\2\2KL\7t\2\2L\u0094\7q\2\2MN\7"+
		"H\2\2NO\7g\2\2OP\7x\2\2PQ\7g\2\2QR\7t\2\2RS\7g\2\2ST\7k\2\2TU\7t\2\2U"+
		"\u0094\7q\2\2VW\7O\2\2WX\7c\2\2XY\7t\2\2YZ\7\u00e9\2\2Z\u0094\7q\2\2["+
		"\\\7C\2\2\\]\7d\2\2]^\7t\2\2^_\7k\2\2_\u0094\7n\2\2`a\7O\2\2ab\7c\2\2"+
		"bc\7k\2\2c\u0094\7q\2\2de\7L\2\2ef\7w\2\2fg\7p\2\2gh\7j\2\2h\u0094\7q"+
		"\2\2ij\7L\2\2jk\7w\2\2kl\7n\2\2lm\7j\2\2m\u0094\7q\2\2no\7C\2\2op\7i\2"+
		"\2pq\7q\2\2qr\7u\2\2rs\7v\2\2s\u0094\7q\2\2tu\7U\2\2uv\7g\2\2vw\7v\2\2"+
		"wx\7g\2\2xy\7o\2\2yz\7d\2\2z{\7t\2\2{\u0094\7q\2\2|}\7Q\2\2}~\7w\2\2~"+
		"\177\7v\2\2\177\u0080\7w\2\2\u0080\u0081\7d\2\2\u0081\u0082\7t\2\2\u0082"+
		"\u0094\7q\2\2\u0083\u0084\7P\2\2\u0084\u0085\7q\2\2\u0085\u0086\7x\2\2"+
		"\u0086\u0087\7g\2\2\u0087\u0088\7o\2\2\u0088\u0089\7d\2\2\u0089\u008a"+
		"\7t\2\2\u008a\u0094\7q\2\2\u008b\u008c\7F\2\2\u008c\u008d\7g\2\2\u008d"+
		"\u008e\7|\2\2\u008e\u008f\7g\2\2\u008f\u0090\7o\2\2\u0090\u0091\7d\2\2"+
		"\u0091\u0092\7t\2\2\u0092\u0094\7q\2\2\u0093F\3\2\2\2\u0093M\3\2\2\2\u0093"+
		"V\3\2\2\2\u0093[\3\2\2\2\u0093`\3\2\2\2\u0093d\3\2\2\2\u0093i\3\2\2\2"+
		"\u0093n\3\2\2\2\u0093t\3\2\2\2\u0093|\3\2\2\2\u0093\u0083\3\2\2\2\u0093"+
		"\u008b\3\2\2\2\u0094\24\3\2\2\2\u0095\u009a\7$\2\2\u0096\u0099\5\27\f"+
		"\2\u0097\u0099\n\4\2\2\u0098\u0096\3\2\2\2\u0098\u0097\3\2\2\2\u0099\u009c"+
		"\3\2\2\2\u009a\u0098\3\2\2\2\u009a\u009b\3\2\2\2\u009b\u009d\3\2\2\2\u009c"+
		"\u009a\3\2\2\2\u009d\u009e\7$\2\2\u009e\26\3\2\2\2\u009f\u00a0\7^\2\2"+
		"\u00a0\u00a1\7)\2\2\u00a1\30\3\2\2\2\u00a2\u00a3\4\62;\2\u00a3\32\3\2"+
		"\2\2\u00a4\u00a8\7$\2\2\u00a5\u00a7\n\5\2\2\u00a6\u00a5\3\2\2\2\u00a7"+
		"\u00aa\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00ab\3\2"+
		"\2\2\u00aa\u00a8\3\2\2\2\u00ab\u00ac\7\f\2\2\u00ac\34\3\2\2\2\n\2+;D\u0093"+
		"\u0098\u009a\u00a8\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}