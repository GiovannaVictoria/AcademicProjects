package portalVagas;

public class Main {
    public static void main(String[] args) {
        // Instanciacao de fabricas
        ObserverFactory observerFactory = ObserverFactory.getInstance();
        VagaFactory vagaFactory = VagaFactory.getInstance();
        UserFactory userFactory = UserFactory.getInstance();
        
        // Criacao dos objetos concretos
        PortalEmprego portal1 = new PortalEmprego("Portal de POOA");
        Usuario empresa1 = userFactory.criarEmpresa("TechCorp", "techplus@exemplo.com",  "TechCorp_123", "12.341.488/0001-08", "Empresa de tecnologia", "Sao Paulo", portal1);
        Usuario funcionario1 = userFactory.criarFuncionario("Fulano", "fulano@gmail.com", "Senha123","123.123.123-09", "(11) 1234-5678", "Masculino", "09/02/1931" , portal1);
        Observer obsFunc1 = observerFactory.criaObserverFuncionario(funcionario1);
        Observer obsEmp1 = observerFactory.criaObserverEmpresa(empresa1);
        Vaga vaga1 = vagaFactory.criaVaga("Engenheiro de Software", "Vaga para desenvolvedores plenos", empresa1);
        Vaga vaga2 = vagaFactory.criaVaga("Engenheiro de Producao", "Vaga Producao", empresa1);
        Vaga vaga3 = vagaFactory.criaVaga("Engenheiro de Dados", "Vaga Dados", empresa1);
        Vaga vaga4 = vagaFactory.criaVaga("Assitente de Marketing", "Vaga Marketing", empresa1);
        Vaga vaga5 = vagaFactory.criaVaga("Professor", "Vaga Escola", empresa1);
        Vaga vaga6 = vagaFactory.criaVaga("Secretario", "Vaga Secretaria", empresa1);
        
        // Definicao dos observers em Empresa e Funcionario
        portal1.adicionarEmpresaObserver(empresa1, obsEmp1);
        portal1.adicionarFuncionarioObserver(funcionario1, obsFunc1);

        // Registro de empresa e funcionario no portal
        portal1.registrarEmpresa(empresa1);
        portal1.registrarFuncionario(funcionario1);
        
        // Adicao de vagas
        portal1.postarVaga(empresa1, vaga1);
        portal1.postarVaga(empresa1, vaga2);
        portal1.postarVaga(empresa1, vaga3);
        portal1.postarVaga(empresa1, vaga4);
        portal1.postarVaga(empresa1, vaga5);
        portal1.postarVaga(empresa1, vaga6);

        // Candidaturas
        portal1.candidatura(funcionario1, vaga1);
        portal1.candidatura(funcionario1, vaga4);
        portal1.candidatura(funcionario1, vaga5);
    }
}
