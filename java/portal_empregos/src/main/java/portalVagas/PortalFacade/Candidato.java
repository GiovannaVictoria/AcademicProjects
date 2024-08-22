package portalVagas.PortalFacade;

import java.util.ArrayList;

import portalVagas.Observer.Observer;

public class Candidato extends Usuario {

    private String cpf;
    private String telefone;
    private String sexo;
    private String dataNasc;
    private ArrayList<Observer> observers;

    public Candidato(String nome, String email, String senha, String cpf,
                        String telefone, String sexo, String dataNasc) {
        super(nome, email, senha);
        this.cpf = cpf;
        this.telefone = telefone;
        this.sexo = sexo;
        this.dataNasc = dataNasc;
        this.observers = new ArrayList<>();
    }

    public Candidato(String nome, String email, String senha, String cpf,
                        String telefone, String sexo, String dataNasc, 
                         ArrayList<Observer> observers) {
        super(nome, email, senha);
        this.cpf = cpf;
        this.telefone = telefone;
        this.sexo = sexo;
        this.dataNasc = dataNasc;
        this.observers = observers;
    }



    String getCpf() {
        return cpf;
    }

    String getTelefone() {
        return telefone;
    }

    String getSexo() {
        return sexo;
    }

    String getDataNasc() {
        return dataNasc;
    }

    ArrayList<Observer> getObservers() {
        return observers;
    }

    void setObservers(ArrayList<Observer> observers) {
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

    public String getDocumento()
    {
        return getCpf();
    }
}