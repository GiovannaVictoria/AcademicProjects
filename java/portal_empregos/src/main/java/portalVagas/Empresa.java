package portalVagas;

import java.util.ArrayList;
import java.util.List;

public class Empresa extends Usuario {
    private List<Vaga> vagas = new ArrayList<>();
    private String cnpj;
    private String descricao;
    private String cidade;
    private ArrayList<Observer> observers;

    public Empresa(String nome, String email, String senha,String cnpj,
                    String descricao, String cidade,PortalEmprego portal) {
        super(nome, email, senha, portal);
        this.cnpj = cnpj;
        this.descricao = descricao;
        this.cidade = cidade;
        this.observers = new ArrayList<>();
    }

    public Empresa(String nome, String email, String senha,String cnpj,
                    String descricao, String cidade,PortalEmprego portal, ArrayList<Observer> observers) {
        super(nome, email, senha, portal);
        this.cnpj = cnpj;
        this.descricao = descricao;
        this.cidade = cidade;
        this.observers = observers;
    }

    public String getCnpj() {
        return cnpj;
    }

    public List<Vaga> getVagas() {
        return vagas;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getCidade() {
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
        vagas.add(vaga);
    }
}