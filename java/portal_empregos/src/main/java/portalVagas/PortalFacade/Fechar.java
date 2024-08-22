package portalVagas.PortalFacade;

public class Fechar implements Acao {
    @Override
    public void executar(Vaga vaga)
    {
        vaga.fechar();
    }
    
}
