// Generated from ufscar/dc/compiladores/lexico/lexerLA.g4 by ANTLR 4.8
package ufscar.dc.compiladores.lexico;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class lexerLA extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		Comentario=1, Espaco=2, Delimitador=3, Pontuacao=4, Abre_Parenteses=5, 
		Fecha_Parenteses=6, Abre_Colchetes=7, Fecha_Colchetes=8, Atribuicao=9, 
		Operador_Relacional=10, Operador_Aritmetico=11, Ponteiro=12, Palavra_chave=13, 
		NUM_INT=14, NUM_REAL=15, IDENT=16, CADEIA=17, Erro_Comentario=18, Erro_Cadeia=19, 
		Simbolo_nao_identificado=20;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"Comentario", "Espaco", "Delimitador", "Pontuacao", "Abre_Parenteses", 
			"Fecha_Parenteses", "Abre_Colchetes", "Fecha_Colchetes", "Atribuicao", 
			"Operador_Relacional", "Operador_Aritmetico", "Ponteiro", "Palavra_chave", 
			"NUM_INT", "NUM_REAL", "IDENT", "CADEIA", "Erro_Comentario", "Erro_Cadeia", 
			"Simbolo_nao_identificado", "ESC_SEQ", "Letra", "Digito"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, "':'", null, "'('", "')'", "'['", "']'", "'<-'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "Comentario", "Espaco", "Delimitador", "Pontuacao", "Abre_Parenteses", 
			"Fecha_Parenteses", "Abre_Colchetes", "Fecha_Colchetes", "Atribuicao", 
			"Operador_Relacional", "Operador_Aritmetico", "Ponteiro", "Palavra_chave", 
			"NUM_INT", "NUM_REAL", "IDENT", "CADEIA", "Erro_Comentario", "Erro_Cadeia", 
			"Simbolo_nao_identificado"
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


	public lexerLA(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "lexerLA.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\26\u0195\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\3\2"+
		"\3\2\7\2\64\n\2\f\2\16\2\67\13\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3"+
		"\5\5\5C\n\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\5\13X\n\13\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\5\16\u0153\n\16\3\17\6\17\u0156\n\17\r\17\16\17\u0157"+
		"\3\20\6\20\u015b\n\20\r\20\16\20\u015c\3\20\3\20\6\20\u0161\n\20\r\20"+
		"\16\20\u0162\3\21\3\21\5\21\u0167\n\21\3\21\3\21\3\21\7\21\u016c\n\21"+
		"\f\21\16\21\u016f\13\21\3\22\3\22\3\22\7\22\u0174\n\22\f\22\16\22\u0177"+
		"\13\22\3\22\3\22\3\23\3\23\7\23\u017d\n\23\f\23\16\23\u0180\13\23\3\23"+
		"\3\23\3\24\3\24\7\24\u0186\n\24\f\24\16\24\u0189\13\24\3\24\3\24\3\25"+
		"\3\25\3\26\3\26\3\26\3\27\3\27\3\30\3\30\2\2\31\3\3\5\4\7\5\t\6\13\7\r"+
		"\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25"+
		")\26+\2-\2/\2\3\2\13\4\2\f\f\177\177\5\2\13\f\17\17\"\"\6\2\'\',-//\61"+
		"\61\4\2((``\5\2\f\f$$^^\3\2\177\177\3\2$$\16\2##%&BBbb\177\u0080\u00a4"+
		"\u00a5\u00a9\u00aa\u00ac\u00ac\u00ae\u00ae\u00b2\u00b2\u00b4\u00b6\u00bb"+
		"\u00bc\4\2C\\c|\2\u01c7\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2"+
		"\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25"+
		"\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2"+
		"\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\3\61\3\2"+
		"\2\2\5:\3\2\2\2\7<\3\2\2\2\tB\3\2\2\2\13D\3\2\2\2\rF\3\2\2\2\17H\3\2\2"+
		"\2\21J\3\2\2\2\23L\3\2\2\2\25W\3\2\2\2\27Y\3\2\2\2\31[\3\2\2\2\33\u0152"+
		"\3\2\2\2\35\u0155\3\2\2\2\37\u015a\3\2\2\2!\u0166\3\2\2\2#\u0170\3\2\2"+
		"\2%\u017a\3\2\2\2\'\u0183\3\2\2\2)\u018c\3\2\2\2+\u018e\3\2\2\2-\u0191"+
		"\3\2\2\2/\u0193\3\2\2\2\61\65\7}\2\2\62\64\n\2\2\2\63\62\3\2\2\2\64\67"+
		"\3\2\2\2\65\63\3\2\2\2\65\66\3\2\2\2\668\3\2\2\2\67\65\3\2\2\289\7\177"+
		"\2\29\4\3\2\2\2:;\t\3\2\2;\6\3\2\2\2<=\7<\2\2=\b\3\2\2\2>C\7\60\2\2?@"+
		"\7\60\2\2@C\7\60\2\2AC\7.\2\2B>\3\2\2\2B?\3\2\2\2BA\3\2\2\2C\n\3\2\2\2"+
		"DE\7*\2\2E\f\3\2\2\2FG\7+\2\2G\16\3\2\2\2HI\7]\2\2I\20\3\2\2\2JK\7_\2"+
		"\2K\22\3\2\2\2LM\7>\2\2MN\7/\2\2N\24\3\2\2\2OX\7>\2\2PQ\7>\2\2QX\7?\2"+
		"\2RX\4?@\2ST\7@\2\2TX\7?\2\2UV\7>\2\2VX\7@\2\2WO\3\2\2\2WP\3\2\2\2WR\3"+
		"\2\2\2WS\3\2\2\2WU\3\2\2\2X\26\3\2\2\2YZ\t\4\2\2Z\30\3\2\2\2[\\\t\5\2"+
		"\2\\\32\3\2\2\2]^\7c\2\2^_\7v\2\2_\u0153\7g\2\2`a\7c\2\2ab\7n\2\2bc\7"+
		"i\2\2cd\7q\2\2de\7t\2\2ef\7k\2\2fg\7v\2\2gh\7o\2\2h\u0153\7q\2\2ij\7e"+
		"\2\2jk\7c\2\2kl\7u\2\2l\u0153\7q\2\2mn\7e\2\2no\7q\2\2op\7p\2\2pq\7u\2"+
		"\2qr\7v\2\2rs\7c\2\2st\7p\2\2tu\7v\2\2u\u0153\7g\2\2vw\7f\2\2wx\7g\2\2"+
		"xy\7e\2\2yz\7n\2\2z{\7c\2\2{|\7t\2\2|\u0153\7g\2\2}\u0153\7g\2\2~\177"+
		"\7g\2\2\177\u0080\7p\2\2\u0080\u0081\7s\2\2\u0081\u0082\7w\2\2\u0082\u0083"+
		"\7c\2\2\u0083\u0084\7p\2\2\u0084\u0085\7v\2\2\u0085\u0153\7q\2\2\u0086"+
		"\u0087\7g\2\2\u0087\u0088\7p\2\2\u0088\u0089\7v\2\2\u0089\u008a\7c\2\2"+
		"\u008a\u0153\7q\2\2\u008b\u008c\7g\2\2\u008c\u008d\7u\2\2\u008d\u008e"+
		"\7e\2\2\u008e\u008f\7t\2\2\u008f\u0090\7g\2\2\u0090\u0091\7x\2\2\u0091"+
		"\u0153\7c\2\2\u0092\u0093\7h\2\2\u0093\u0094\7c\2\2\u0094\u0095\7e\2\2"+
		"\u0095\u0153\7c\2\2\u0096\u0097\7h\2\2\u0097\u0098\7c\2\2\u0098\u0099"+
		"\7n\2\2\u0099\u009a\7u\2\2\u009a\u0153\7q\2\2\u009b\u009c\7h\2\2\u009c"+
		"\u009d\7k\2\2\u009d\u009e\7o\2\2\u009e\u009f\7a\2\2\u009f\u00a0\7c\2\2"+
		"\u00a0\u00a1\7n\2\2\u00a1\u00a2\7i\2\2\u00a2\u00a3\7q\2\2\u00a3\u00a4"+
		"\7t\2\2\u00a4\u00a5\7k\2\2\u00a5\u00a6\7v\2\2\u00a6\u00a7\7o\2\2\u00a7"+
		"\u0153\7q\2\2\u00a8\u00a9\7h\2\2\u00a9\u00aa\7k\2\2\u00aa\u00ab\7o\2\2"+
		"\u00ab\u00ac\7a\2\2\u00ac\u00ad\7e\2\2\u00ad\u00ae\7c\2\2\u00ae\u00af"+
		"\7u\2\2\u00af\u0153\7q\2\2\u00b0\u00b1\7h\2\2\u00b1\u00b2\7k\2\2\u00b2"+
		"\u00b3\7o\2\2\u00b3\u00b4\7a\2\2\u00b4\u00b5\7g\2\2\u00b5\u00b6\7p\2\2"+
		"\u00b6\u00b7\7s\2\2\u00b7\u00b8\7w\2\2\u00b8\u00b9\7c\2\2\u00b9\u00ba"+
		"\7p\2\2\u00ba\u00bb\7v\2\2\u00bb\u0153\7q\2\2\u00bc\u00bd\7h\2\2\u00bd"+
		"\u00be\7k\2\2\u00be\u00bf\7o\2\2\u00bf\u00c0\7a\2\2\u00c0\u00c1\7h\2\2"+
		"\u00c1\u00c2\7w\2\2\u00c2\u00c3\7p\2\2\u00c3\u00c4\7e\2\2\u00c4\u00c5"+
		"\7c\2\2\u00c5\u0153\7q\2\2\u00c6\u00c7\7h\2\2\u00c7\u00c8\7k\2\2\u00c8"+
		"\u00c9\7o\2\2\u00c9\u00ca\7a\2\2\u00ca\u00cb\7r\2\2\u00cb\u00cc\7c\2\2"+
		"\u00cc\u00cd\7t\2\2\u00cd\u0153\7c\2\2\u00ce\u00cf\7h\2\2\u00cf\u00d0"+
		"\7k\2\2\u00d0\u00d1\7o\2\2\u00d1\u00d2\7a\2\2\u00d2\u00d3\7r\2\2\u00d3"+
		"\u00d4\7t\2\2\u00d4\u00d5\7q\2\2\u00d5\u00d6\7e\2\2\u00d6\u00d7\7g\2\2"+
		"\u00d7\u00d8\7f\2\2\u00d8\u00d9\7k\2\2\u00d9\u00da\7o\2\2\u00da\u00db"+
		"\7g\2\2\u00db\u00dc\7p\2\2\u00dc\u00dd\7v\2\2\u00dd\u0153\7q\2\2\u00de"+
		"\u00df\7h\2\2\u00df\u00e0\7k\2\2\u00e0\u00e1\7o\2\2\u00e1\u00e2\7a\2\2"+
		"\u00e2\u00e3\7t\2\2\u00e3\u00e4\7g\2\2\u00e4\u00e5\7i\2\2\u00e5\u00e6"+
		"\7k\2\2\u00e6\u00e7\7u\2\2\u00e7\u00e8\7v\2\2\u00e8\u00e9\7t\2\2\u00e9"+
		"\u0153\7q\2\2\u00ea\u00eb\7h\2\2\u00eb\u00ec\7k\2\2\u00ec\u00ed\7o\2\2"+
		"\u00ed\u00ee\7a\2\2\u00ee\u00ef\7u\2\2\u00ef\u0153\7g\2\2\u00f0\u00f1"+
		"\7h\2\2\u00f1\u00f2\7w\2\2\u00f2\u00f3\7p\2\2\u00f3\u00f4\7e\2\2\u00f4"+
		"\u00f5\7c\2\2\u00f5\u0153\7q\2\2\u00f6\u00f7\7k\2\2\u00f7\u00f8\7p\2\2"+
		"\u00f8\u00f9\7v\2\2\u00f9\u00fa\7g\2\2\u00fa\u00fb\7k\2\2\u00fb\u00fc"+
		"\7t\2\2\u00fc\u0153\7q\2\2\u00fd\u00fe\7n\2\2\u00fe\u00ff\7g\2\2\u00ff"+
		"\u0100\7k\2\2\u0100\u0153\7c\2\2\u0101\u0102\7n\2\2\u0102\u0103\7k\2\2"+
		"\u0103\u0104\7v\2\2\u0104\u0105\7g\2\2\u0105\u0106\7t\2\2\u0106\u0107"+
		"\7c\2\2\u0107\u0153\7n\2\2\u0108\u0109\7n\2\2\u0109\u010a\7q\2\2\u010a"+
		"\u010b\7i\2\2\u010b\u010c\7k\2\2\u010c\u010d\7e\2\2\u010d\u0153\7q\2\2"+
		"\u010e\u010f\7p\2\2\u010f\u0110\7c\2\2\u0110\u0153\7q\2\2\u0111\u0112"+
		"\7q\2\2\u0112\u0153\7w\2\2\u0113\u0114\7r\2\2\u0114\u0115\7c\2\2\u0115"+
		"\u0116\7t\2\2\u0116\u0153\7c\2\2\u0117\u0118\7r\2\2\u0118\u0119\7t\2\2"+
		"\u0119\u011a\7q\2\2\u011a\u011b\7e\2\2\u011b\u011c\7g\2\2\u011c\u011d"+
		"\7f\2\2\u011d\u011e\7k\2\2\u011e\u011f\7o\2\2\u011f\u0120\7g\2\2\u0120"+
		"\u0121\7p\2\2\u0121\u0122\7v\2\2\u0122\u0153\7q\2\2\u0123\u0124\7t\2\2"+
		"\u0124\u0125\7g\2\2\u0125\u0126\7c\2\2\u0126\u0153\7n\2\2\u0127\u0128"+
		"\7t\2\2\u0128\u0129\7g\2\2\u0129\u012a\7i\2\2\u012a\u012b\7k\2\2\u012b"+
		"\u012c\7u\2\2\u012c\u012d\7v\2\2\u012d\u012e\7t\2\2\u012e\u0153\7q\2\2"+
		"\u012f\u0130\7t\2\2\u0130\u0131\7g\2\2\u0131\u0132\7v\2\2\u0132\u0133"+
		"\7q\2\2\u0133\u0134\7t\2\2\u0134\u0135\7p\2\2\u0135\u0153\7g\2\2\u0136"+
		"\u0137\7u\2\2\u0137\u0153\7g\2\2\u0138\u0139\7u\2\2\u0139\u013a\7g\2\2"+
		"\u013a\u013b\7l\2\2\u013b\u0153\7c\2\2\u013c\u013d\7u\2\2\u013d\u013e"+
		"\7g\2\2\u013e\u013f\7p\2\2\u013f\u0140\7c\2\2\u0140\u0153\7q\2\2\u0141"+
		"\u0142\7v\2\2\u0142\u0143\7k\2\2\u0143\u0144\7r\2\2\u0144\u0153\7q\2\2"+
		"\u0145\u0146\7x\2\2\u0146\u0147\7c\2\2\u0147\u0153\7t\2\2\u0148\u0149"+
		"\7x\2\2\u0149\u014a\7g\2\2\u014a\u014b\7t\2\2\u014b\u014c\7f\2\2\u014c"+
		"\u014d\7c\2\2\u014d\u014e\7f\2\2\u014e\u014f\7g\2\2\u014f\u0150\7k\2\2"+
		"\u0150\u0151\7t\2\2\u0151\u0153\7q\2\2\u0152]\3\2\2\2\u0152`\3\2\2\2\u0152"+
		"i\3\2\2\2\u0152m\3\2\2\2\u0152v\3\2\2\2\u0152}\3\2\2\2\u0152~\3\2\2\2"+
		"\u0152\u0086\3\2\2\2\u0152\u008b\3\2\2\2\u0152\u0092\3\2\2\2\u0152\u0096"+
		"\3\2\2\2\u0152\u009b\3\2\2\2\u0152\u00a8\3\2\2\2\u0152\u00b0\3\2\2\2\u0152"+
		"\u00bc\3\2\2\2\u0152\u00c6\3\2\2\2\u0152\u00ce\3\2\2\2\u0152\u00de\3\2"+
		"\2\2\u0152\u00ea\3\2\2\2\u0152\u00f0\3\2\2\2\u0152\u00f6\3\2\2\2\u0152"+
		"\u00fd\3\2\2\2\u0152\u0101\3\2\2\2\u0152\u0108\3\2\2\2\u0152\u010e\3\2"+
		"\2\2\u0152\u0111\3\2\2\2\u0152\u0113\3\2\2\2\u0152\u0117\3\2\2\2\u0152"+
		"\u0123\3\2\2\2\u0152\u0127\3\2\2\2\u0152\u012f\3\2\2\2\u0152\u0136\3\2"+
		"\2\2\u0152\u0138\3\2\2\2\u0152\u013c\3\2\2\2\u0152\u0141\3\2\2\2\u0152"+
		"\u0145\3\2\2\2\u0152\u0148\3\2\2\2\u0153\34\3\2\2\2\u0154\u0156\5/\30"+
		"\2\u0155\u0154\3\2\2\2\u0156\u0157\3\2\2\2\u0157\u0155\3\2\2\2\u0157\u0158"+
		"\3\2\2\2\u0158\36\3\2\2\2\u0159\u015b\5/\30\2\u015a\u0159\3\2\2\2\u015b"+
		"\u015c\3\2\2\2\u015c\u015a\3\2\2\2\u015c\u015d\3\2\2\2\u015d\u015e\3\2"+
		"\2\2\u015e\u0160\7\60\2\2\u015f\u0161\5/\30\2\u0160\u015f\3\2\2\2\u0161"+
		"\u0162\3\2\2\2\u0162\u0160\3\2\2\2\u0162\u0163\3\2\2\2\u0163 \3\2\2\2"+
		"\u0164\u0167\5-\27\2\u0165\u0167\7a\2\2\u0166\u0164\3\2\2\2\u0166\u0165"+
		"\3\2\2\2\u0167\u016d\3\2\2\2\u0168\u016c\5-\27\2\u0169\u016c\5/\30\2\u016a"+
		"\u016c\7a\2\2\u016b\u0168\3\2\2\2\u016b\u0169\3\2\2\2\u016b\u016a\3\2"+
		"\2\2\u016c\u016f\3\2\2\2\u016d\u016b\3\2\2\2\u016d\u016e\3\2\2\2\u016e"+
		"\"\3\2\2\2\u016f\u016d\3\2\2\2\u0170\u0175\7$\2\2\u0171\u0174\5+\26\2"+
		"\u0172\u0174\n\6\2\2\u0173\u0171\3\2\2\2\u0173\u0172\3\2\2\2\u0174\u0177"+
		"\3\2\2\2\u0175\u0173\3\2\2\2\u0175\u0176\3\2\2\2\u0176\u0178\3\2\2\2\u0177"+
		"\u0175\3\2\2\2\u0178\u0179\7$\2\2\u0179$\3\2\2\2\u017a\u017e\7}\2\2\u017b"+
		"\u017d\n\7\2\2\u017c\u017b\3\2\2\2\u017d\u0180\3\2\2\2\u017e\u017c\3\2"+
		"\2\2\u017e\u017f\3\2\2\2\u017f\u0181\3\2\2\2\u0180\u017e\3\2\2\2\u0181"+
		"\u0182\7\f\2\2\u0182&\3\2\2\2\u0183\u0187\7$\2\2\u0184\u0186\n\b\2\2\u0185"+
		"\u0184\3\2\2\2\u0186\u0189\3\2\2\2\u0187\u0185\3\2\2\2\u0187\u0188\3\2"+
		"\2\2\u0188\u018a\3\2\2\2\u0189\u0187\3\2\2\2\u018a\u018b\7\f\2\2\u018b"+
		"(\3\2\2\2\u018c\u018d\t\t\2\2\u018d*\3\2\2\2\u018e\u018f\7^\2\2\u018f"+
		"\u0190\7)\2\2\u0190,\3\2\2\2\u0191\u0192\t\n\2\2\u0192.\3\2\2\2\u0193"+
		"\u0194\4\62;\2\u0194\60\3\2\2\2\21\2\65BW\u0152\u0157\u015c\u0162\u0166"+
		"\u016b\u016d\u0173\u0175\u017e\u0187\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}