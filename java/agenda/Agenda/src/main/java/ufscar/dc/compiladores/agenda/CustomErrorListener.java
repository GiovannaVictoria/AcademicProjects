package ufscar.dc.compiladores.agenda;

import java.util.BitSet;
import java.io.PrintWriter;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.ANTLRErrorListener;
import org.antlr.v4.runtime.RecognitionException;

public class CustomErrorListener implements ANTLRErrorListener {
    
    PrintWriter pw;
    
    public CustomErrorListener(PrintWriter pw) {
        this.pw = pw;
    }
    
    @Override
    public void	reportAmbiguity(Parser recognizer, DFA dfa, int startIndex, int stopIndex, boolean exact, BitSet ambigAlts, ATNConfigSet configs) {}
    
    @Override
    public void reportAttemptingFullContext(Parser recognizer, DFA dfa, int startIndex, int stopIndex, BitSet conflictingAlts, ATNConfigSet configs) {}

    @Override
    public void reportContextSensitivity(Parser recognizer, DFA dfa, int startIndex, int stopIndex, int prediction, ATNConfigSet configs) {}

    @Override
    public void	syntaxError(Recognizer<?,?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
        
        Token t = (Token) offendingSymbol;
        if (t.getType()==Token.EOF) {
            pw.println("Linha " + line + ": erro sintatico proximo a EOF");
        } else {
            pw.println("Linha " + line + ": erro sintatico proximo a " + t.getText());
        }
        pw.println("Fim da compilacao");
        pw.close();
        System.exit(1);
            
    }
}