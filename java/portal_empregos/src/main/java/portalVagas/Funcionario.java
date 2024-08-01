package portalVagas;

import java.util.ArrayList;
import java.util.List;

public class Funcionario extends Usuario {
    private PortalEmprego portal;
    private String cpf;
    private String telefone;
    private String sexo;
    private String dataNasc;
    private ArrayList<Observer> observers;

    public Funcionario(String nome, String email, String senha, String cpf,
                        String telefone, String sexo, String dataNasc, 
                        PortalEmprego portal) {
        super(nome, email, senha, portal);
        this.cpf = cpf;
        this.telefone = telefone;
        this.sexo = sexo;
        this.dataNasc = dataNasc;
        System.out.println("PORTAL: " + portal.getNome());
        this.observers = new ArrayList<>();
    }

    public Funcionario(String nome, String email, String senha, String cpf,
                        String telefone, String sexo, String dataNasc, 
                        PortalEmprego portal, ArrayList<Observer> observers) {
        super(nome, email, senha, portal);
        this.cpf = cpf;
        this.telefone = telefone;
        this.sexo = sexo;
        this.dataNasc = dataNasc;
        System.out.println("PORTAL: " + portal.getNome());
        this.observers = observers;
    }

    public PortalEmprego getPortal() {
        return portal;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getSexo() {
        return sexo;
    }

    public String getDataNasc() {
        return dataNasc;
    }

    public ArrayList<Observer> getObservers() {
        return observers;
    }

    public void setObservers(ArrayList<Observer> observers) {
        this.observers = observers;
    }

    public List<Vaga> buscaVagas(String filtro) {
        return this.portal.buscaVagasFiltradas(filtro);
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
}