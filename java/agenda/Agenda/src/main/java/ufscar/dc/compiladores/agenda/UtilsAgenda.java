package ufscar.dc.compiladores.agenda;

import java.util.List;
import java.util.ArrayList;
import org.antlr.v4.runtime.Token;

public class UtilsAgenda {

    public static List<String> errosSemanticos = new ArrayList<>();

    public static void adicionarErroSemantico(Token t, String mensagem) {
        int linha = t.getLine();
        errosSemanticos.add(String.format("Linha %d: %s", linha, mensagem));
    }
    
}