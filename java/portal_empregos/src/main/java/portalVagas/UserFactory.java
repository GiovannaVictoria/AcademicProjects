package portalVagas;

import java.util.ArrayList;

public class UserFactory {
    private static UserFactory instance;

    private UserFactory() {}

    public static UserFactory getInstance() {
        if (instance == null) {
            instance = new UserFactory();
        }
        return instance;
    }

    public Usuario criarEmpresa(String nome, String email, String senha, String cnpj, String descricao, String cidade, PortalEmprego portal) {
        return new Empresa(nome, email, senha, cnpj, descricao, cidade, portal);
    }

    public Usuario criarEmpresa(String nome, String email, String senha, String cnpj, String descricao, String cidade, PortalEmprego portal, ArrayList<Observer> observers) {
        return new Empresa(nome, email, senha, cnpj, descricao, cidade, portal, observers);
    }

    public Usuario criarFuncionario(String nome, String email, String senha, String cpf, String telefone, String sexo, String dataNasc, PortalEmprego portal) {
        return new Funcionario(nome, email, senha, cpf, telefone, sexo, dataNasc, portal);
    }

    public Usuario criarFuncionario(String nome, String email, String senha, String cpf, String telefone, String sexo, String dataNasc, PortalEmprego portal, ArrayList<Observer> observers) {
        return new Funcionario(nome, email, senha, cpf, telefone, sexo, dataNasc, portal, observers);
    }
}