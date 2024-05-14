package ufscar.dc.compiladores.sintaticoLA;

import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public class Main {

    public static void main(String args[]) throws IOException {

        try ( PrintWriter saida = new PrintWriter(new File(args[1]))) {
            
            Token t = null;                                           // objeto token usado nas analises
            CharStream entrada = CharStreams.fromFileName(args[0]);   // arquvio de entrada
            parserLALexer lexer = new parserLALexer(entrada);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            parserLAParser parser = new parserLAParser(tokens);       // arquivo de saida
            parser.removeErrorListeners();
            
            // analise lexica, detectando apenas os erros lexicos de acordo com o numero de cada tipo de token, disponivel no arquivo parserLA.tokens
            while ((t = lexer.nextToken()).getType() != Token.EOF) {
                switch (t.getType()) {
                    case 71:                    // comentario nao fechado
                        saida.write("Linha " + t.getLine() + ": comentario nao fechado\n");
                        saida.write("Fim da compilacao\n");
                        saida.close();
                        System.exit(1);         // encerra a execucao do analisador
                    case 72:                    // cadeia nao fechada
                        saida.write("Linha " + t.getLine() + ": cadeia literal nao fechada\n");
                        saida.write("Fim da compilacao\n");
                        saida.close();
                        System.exit(1);         // encerra a execucao do analisador
                    case 73:                    // simbolo nao identificado
                        saida.write("Linha " + t.getLine() + ": " + t.getText() + " - simbolo nao identificado\n");
                        saida.write("Fim da compilacao\n");
                        saida.close();
                        System.exit(1);         // encerra a execucao do analisador
                }
            }
            
            // analise sintatica
            lexer.reset();                                            // volta a leitura pro inicio do arquivo
            parser.removeErrorListeners();                            // remove os listeners padrao
            CustomErrorListener cel = new CustomErrorListener(saida);
            parser.addErrorListener(cel);                             // adiciona listeners personalizados
            parser.programa();                                        // inicia a execucao
            
        } catch (Exception e) {

        }
        
    }

}
