package portalVagas.PortalFacade;

import portalVagas.Observer.Observer;

public abstract class Usuario {
    private String email;
    private String nome;
    private String senha;

    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        
    }

    String getEmail() {
        return email;
    }

    String getNome() {
        return nome;
    }

    String getSenha() {
        return senha;
    }

    public void adicionarVaga(Vaga vaga) {}

    public abstract void adicionarObserver(Observer observer);
    public abstract void removerObserver(Observer observer);
    public abstract void notificar(Vaga vaga);
    public abstract String getDocumento();
}