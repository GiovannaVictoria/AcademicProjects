package portalVagas;

import java.util.ArrayList;
import java.util.List;

public class Vaga {
    private String nome;
    private String descricao;
    private Usuario empresa;
    private List<Usuario> funcionarios;

    public Vaga(String nome, String descricao, Usuario empresa) {
        this.nome = nome;
        this.descricao = descricao;
        this.empresa = empresa;
        this.funcionarios = new ArrayList<>();

    }

    public void addFuncionario(Usuario funcionario) {
        funcionarios.add(funcionario);
    }

    public void setNome(String n) {
        this.nome = n;
    }
    
    public String getNome() {
        return this.nome;
    }

    public void setDescricao(String d) {
        this.nome = d;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setEmpresa(Empresa e) {
        this.empresa = e;
    }

    public Usuario getEmpresa() {
        return this.empresa;
    }
}
