package ufscar.dc.compiladores.agenda;

import java.io.IOException;
import java.io.PrintWriter;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import ufscar.dc.compiladores.gramatica.gramaticaAgendaLexer;
import ufscar.dc.compiladores.gramatica.gramaticaAgendaParser;
import ufscar.dc.compiladores.gramatica.gramaticaAgendaParser.CalendarioContext;
        
public class Main {
    
    public static void main (String args[]) throws IOException {
        
        Token t = null;                                           // objeto token usado na analise
        CharStream entrada = CharStreams.fromFileName(args[0]);   // arquivo de entrada
        gramaticaAgendaLexer lexer = new gramaticaAgendaLexer(entrada);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        gramaticaAgendaParser parser = new gramaticaAgendaParser (tokens);
        PrintWriter saida = new PrintWriter(args[1]);               // arquivo de saida
        
        // analise lexica
        // tratamento da escrita no arquivo de saida de acordo com o numero de cada tipo de token, disponivel no arquivo gramaticaAgenda.tokens
        while ((t = lexer.nextToken()).getType() != Token.EOF) {
            switch (t.getType()) {
                case 1:
                case 2:
                case 3:
                case 4:                     // comentarios
                case 5:                     // espacos em branco
                    break;
                case 6:                     // delimitador
//                    saida.write("<'"+gramaticaAgendaLexer.VOCABULARY.getDisplayName(t.getType())+"','"+t.getText()+"'>\n");
                    break;
                case 7:                     // num_int
//                    saida.write("<'"+gramaticaAgendaLexer.VOCABULARY.getDisplayName(t.getType())+"','"+t.getText()+"'>\n");
                    break;
                case 8:                     // palavra_chave
//                    saida.write("<'"+gramaticaAgendaLexer.VOCABULARY.getDisplayName(t.getType())+"','"+t.getText()+"'>\n");
                    break;
                case 9:                     // mes
//                    saida.write("<'"+gramaticaAgendaLexer.VOCABULARY.getDisplayName(t.getType())+"','"+t.getText()+"'>\n");
                    break;
                case 10:                     // cadeia
//                    saida.write("<'"+gramaticaAgendaLexer.VOCABULARY.getDisplayName(t.getType())+"','"+t.getText()+"'>\n");
                    break;
                case 11:                     // erro cadeia nao fechada
                    saida.write("Linha "+t.getLine()+": cadeia literal nao fechada\n");
                    saida.close();
                    System.exit(1);         // encerra a execucao do analisador
                default:                    // erro simbolo nao identificado
                    saida.write("Linha "+t.getLine()+": "+t.getText()+" - simbolo nao identificado\n");
                    saida.close();
                    System.exit(1);         // encerra a execucao do analisador
            }
        }
        
        // analise sintatica
        lexer.reset();
        parser.removeErrorListeners();
        CustomErrorListener cel = new CustomErrorListener(saida);
        parser.addErrorListener(cel);                             // adiciona listeners personalizados
        parser.calendario();                                      // inicia a execucao
        
        // analise semantica
        lexer.reset();
        parser.reset();
        CalendarioContext arvore = parser.calendario();
        Analisador as = new Analisador();
        as.visitCalendario(arvore);
        for (String erro : UtilsAgenda.errosSemanticos) {         // escrevendo os erros no arquivo
            saida.write(erro);
        }
        
        // geracao de codigo
        if (UtilsAgenda.errosSemanticos.isEmpty()) {
            GeradorHTML gerador = new GeradorHTML();
            gerador.visitCalendario(arvore);
            saida.write(gerador.saida.toString());
        } else {
            saida.write("Fim da compilacao\n");
        }
        
        saida.close();
        
    }
    
}
