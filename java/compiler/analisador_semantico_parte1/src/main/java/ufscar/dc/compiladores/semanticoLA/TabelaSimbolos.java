package ufscar.dc.compiladores.semanticoLA;

import java.util.HashMap;

public class TabelaSimbolos {
    
    private final HashMap<String, EntradaTabelaSimbolos> tabela;
    
    public TabelaSimbolos() {
        this.tabela = new HashMap<>();
    }
    
    public void inserir(String nome, TipoLA tipo_la) {
        EntradaTabelaSimbolos entrada = new EntradaTabelaSimbolos(nome, tipo_la);
        tabela.put(nome, entrada);
    }
    
    public TipoLA verificar(String nome) {
        return tabela.get(nome).tipo_la;
    }
    
    public boolean existe(String nome) {
        return tabela.containsKey(nome);
    }
    
}
