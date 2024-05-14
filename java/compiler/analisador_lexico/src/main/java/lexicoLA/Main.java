package lexicoLA;

import java.io.FileWriter;
import java.io.IOException;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import ufscar.dc.compiladores.lexico.lexerLA;

public class Main {
    
    public static void main (String args[]) throws IOException {
        
        Token t = null;                                           // objeto token usado na analise
        CharStream entrada = CharStreams.fromFileName(args[0]);   // arquivo de entrada
        lexerLA la = new lexerLA(entrada);
        FileWriter saida = new FileWriter(args[1]);               // arquvio de saida
        
        // tratamento da escrita no arquivo de saida de acordo com o numero de cada tipo de token, disponivel no arquivo lexerLA.tokens
        while ((t = la.nextToken()).getType() != Token.EOF) {
            switch (t.getType()) {
                case 1:                     // comentario
                case 2:                     // espacos
                    break;
                case 3:                     // delimitadores
                case 4:                     // pontuacao
                case 5:                     // abre parenteses
                case 6:                     // fecha parenteses    
                case 7:                     // abre colchetes
                case 8:                     // fecha colchetes
                case 9:                     // atribuicao
                case 10:                    // operador relacional
                case 11:                    // operador aritmetico
                case 12:                    // ponteiro e endereco
                case 13:                    // palavra chave
                    saida.write("<'"+t.getText()+"','"+t.getText()+"'>\n");
                    break;
                case 14:                    // numero inteiro
                case 15:                    // numero real
                case 16:                    // identificador
                case 17:                    // cadeia
                    saida.write("<'"+t.getText()+"',"+lexerLA.VOCABULARY.getDisplayName(t.getType())+">\n");
                    break;
                case 18:                    // comentario nao fechado
                    saida.write("Linha "+t.getLine()+": comentario nao fechado\n");
                    saida.close();
                    System.exit(1);         // encerra a execucao do analisador
                case 19:                    // cadeia nao fechada
                    saida.write("Linha "+t.getLine()+": cadeia literal nao fechada\n");
                    saida.close();
                    System.exit(1);         // encerra a execucao do analisador
                case 20:                    // simbolo nao identificado
                    saida.write("Linha "+t.getLine()+": "+t.getText()+" - simbolo nao identificado\n");
                    saida.close();
                    System.exit(1);         // encerra a execucao do analisador
            }
        }
        
        saida.close();
        
    }
    
}