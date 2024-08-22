package portalVagas.PortalFacade;

import java.util.ArrayList;

import portalVagas.Observer.Observer;

public class Empresa extends Usuario {
    private PoolVagas vagas;
    private PoolInscricao inscricoes;
    private String cnpj;
    private String descricao;
    private String cidade;
    private ArrayList<Observer> observers;

    public Empresa(String nome, String email, String senha,String cnpj,
                    String descricao, String cidade) {
        super(nome, email, senha);
        this.cnpj = cnpj;
        this.descricao = descricao;
        this.cidade = cidade;
        this.observers = new ArrayList<>();
        this.vagas = new PoolVagas();
        this.inscricoes = new PoolInscricao();
    }

    public Empresa(String nome, String email, String senha,String cnpj,
                    String descricao, String cidade, ArrayList<Observer> observers) {
        super(nome, email, senha);
        this.cnpj = cnpj;
        this.descricao = descricao;
        this.cidade = cidade;
        this.observers = observers;
        this.vagas = new PoolVagas();
        this.inscricoes = new PoolInscricao();
    }

    String getCnpj() {
        return cnpj;
    }

    PoolVagas getVagas() {
        return vagas;
    }
    
    PoolInscricao getinscricoes() {
        return inscricoes;
    }

    String getDescricao() {
        return descricao;
    }

    String getCidade() {
        return cidade;
    }

    public ArrayList<Observer> getObservers() {
        return observers;
    }

    public void setObservers(ArrayList<Observer> observers) {
        this.observers = observers;
    }

    public void adicionarObserver(Observer observer) {
        this.observers.add(observer);
    }

    public void removerObserver(Observer observer) {
        this.observers.remove(observer);
    }

    public void notificar(Vaga vaga) {
        for (Observer o : this.observers) {
            o.update(vaga);
        }
    }

    public void adicionarVaga(Vaga vaga) {
        vagas.adicionarVaga(vaga);
    }

    public void adicionarInscricao(Inscricao inscricao) {
        inscricoes.adicionarInscricao(inscricao);
    }

    public String getDocumento()
    {
        return getCnpj();
    }
}