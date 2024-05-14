package ufscar.dc.compiladores.semanticoLA;

import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;

public class TabelaSimbolos {
    
    private final HashMap<String, List<EntradaTabelaSimbolos>> tabela;                  // agora, cada variavel tem o seu nome, e uma possivel lista de campos com nome e tipo
                                                                                        // quando for um registro, a lista possuira "registro" + "nome_registro" na primeira posicao
                                                                                        // e os campos com seus nomes e tipos nas outras posicoes
                                                                                        // quando nao for registro, a primeira posicao sera o nome da variavel duplicado + o tipo
    
    public TabelaSimbolos() {
        this.tabela = new HashMap<>();
    }
    
    public void inserir(String nomeRegistro, String nomeVariavel, String tipo) {
        EntradaTabelaSimbolos entrada = new EntradaTabelaSimbolos(nomeVariavel, tipo);
        if (!tabela.containsKey(nomeRegistro)) {
            tabela.put(nomeRegistro, new ArrayList<EntradaTabelaSimbolos>());
        }
        tabela.get(nomeRegistro).add(entrada);
    }
    
    public List<EntradaTabelaSimbolos> verificar(String nome) {
        return tabela.get(nome);
    }
    
    // procura um campo especifico em um registro
    public boolean contem(List<EntradaTabelaSimbolos> simbolos, String nome) {
        for (EntradaTabelaSimbolos elemento : simbolos) {
            if (nome.equals(elemento.nome) || nome.equals(elemento.tipo)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean existe(String nome) {
        return tabela.containsKey(nome);
    }
    
}
