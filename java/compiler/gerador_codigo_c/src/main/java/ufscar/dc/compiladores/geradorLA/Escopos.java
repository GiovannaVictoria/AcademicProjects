package ufscar.dc.compiladores.geradorLA;

import java.util.List;
import java.util.LinkedList;

public class Escopos {
    
    static private LinkedList<TabelaSimbolos> pilha;
    
    public Escopos() {
        pilha = new LinkedList<>();
        criarNovoEscopo();
    }
    
    public static void criarNovoEscopo() {
        pilha.push(new TabelaSimbolos());
    }
    
    public TabelaSimbolos obterEscopoAtual() {
        return pilha.peek();
    }
    
    public List<TabelaSimbolos> percorrerEscoposAninhados() {
        return pilha;
    }
    
    public static void abandonarEscopo() {
        pilha.pop();
    }
    
}
