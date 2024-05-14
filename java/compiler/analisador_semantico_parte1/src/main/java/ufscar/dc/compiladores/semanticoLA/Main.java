package ufscar.dc.compiladores.semanticoLA;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import org.antlr.v4.runtime.Token;
import java.io.FileNotFoundException;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import ufscar.dc.compiladores.semanticoLA.expressoesLAParser.ProgramaContext;

public class Main {

    public static void main(String args[]) throws IOException {

        try ( PrintWriter saida = new PrintWriter(new File(args[1]))) {

            CharStream entrada = CharStreams.fromFileName(args[0]);           // arquvio de entrada
            expressoesLALexer lexer = new expressoesLALexer(entrada);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            expressoesLAParser parser = new expressoesLAParser(tokens);       // arquivo de saida
            ProgramaContext arvore = parser.programa();
            Analisador as = new Analisador();
            as.visitPrograma(arvore);
            for (String erro : UtilsLA.errosSemanticos) {                     // escrevendo os erros no arquivo
                saida.write(erro);
            }
            saida.write("Fim da compilacao\n");
            saida.close();

        } catch(FileNotFoundException fnfe) {
            System.err.println("O arquivo/diretório não existe: " + args[1]);
        }

    }

}