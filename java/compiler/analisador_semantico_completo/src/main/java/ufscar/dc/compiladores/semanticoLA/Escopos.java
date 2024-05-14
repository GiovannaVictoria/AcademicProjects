package ufscar.dc.compiladores.semanticoLA;

import java.util.List;
import java.util.LinkedList;

public class Escopos {
    
    private LinkedList<TabelaSimbolos> pilha;
    
    public Escopos() {
        this.pilha = new LinkedList<>();
        criarNovoEscopo();
    }
    
    public void criarNovoEscopo() {
        this.pilha.push(new TabelaSimbolos());
    }
    
    public TabelaSimbolos obterEscopoAtual() {
        return this.pilha.peek();
    }
    
    public List<TabelaSimbolos> percorrerEscoposAninhados() {
        return this.pilha;
    }
    
    public void abandonarEscopo() {
        this.pilha.pop();
    }
    
}
