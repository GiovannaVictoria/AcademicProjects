package portalVagas;

public abstract class Usuario {
    private String email;
    private String nome;
    private String senha;
    private PortalEmprego portal;

    public Usuario(String nome, String email, String senha, PortalEmprego portal) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.portal = portal; 
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    public PortalEmprego getPortal() {
        return portal;
    }

    public void adicionarVaga(Vaga vaga) {}

    public abstract void adicionarObserver(Observer observer);
    public abstract void removerObserver(Observer observer);
    public abstract void notificar(Vaga vaga);
}