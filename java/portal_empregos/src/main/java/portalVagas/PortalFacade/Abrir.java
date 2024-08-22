package portalVagas.PortalFacade;

public class Abrir implements Acao {
    @Override
    public void executar(Vaga vaga)
    {
        vaga.abrir();
    }
    
}
