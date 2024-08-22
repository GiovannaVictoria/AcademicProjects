package portalVagas.PortalFacade;

import java.util.ArrayList;
import java.util.List;

public class Vaga {
    private String nome;
    private String descricao;
    private Usuario empresa;
    private List<Usuario> candidatos;
    //State
    private Estado estado;

    public Vaga(String nome, String descricao, Usuario empresa) {
        this.nome = nome;
        this.descricao = descricao;
        this.empresa = empresa;
        this.candidatos = new ArrayList<>();

        //Inicializar com estado = aberto
        this.estado = new Aberta();
    }

    void addCandidato(Usuario candidato) {
        candidatos.add(candidato);
    }

    void setNome(String n) {
        this.nome = n;
    }
    
    public String getNome() {
        return this.nome;
    }

    void setDescricao(String d) {
        this.nome = d;
    }

    String getDescricao() {
        return this.descricao;
    }

    void setEmpresa(Empresa e) {
        this.empresa = e;
    }

    Usuario getEmpresa() {
        return this.empresa;
    }

    //getters e setters para estado
    void setEstado(Estado estado) {
        this.estado = estado;
    }
    
    Estado getEstado() {
        return this.estado;
    }

    // Métodos para abrir, fechar ou cancelar a vaga
    void abrir() {
        estado.abrir(this);
    }

    void fechar() {
        estado.fechar(this);
    }

    void cancelar() {
        estado.cancelar(this);
    }

    // Método para executar a ação (factory)
    public void executarAcao(Acao acao) {
        //O state vai decidir o que acontece ao executar cada ação.
        acao.executar(this);
    }

}
