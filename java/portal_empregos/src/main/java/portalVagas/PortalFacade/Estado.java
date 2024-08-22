package portalVagas.PortalFacade;

//interface para os possíveis estados de uma vaga

public interface Estado {
    void abrir(Vaga vaga);
    void fechar(Vaga vaga);
    void cancelar(Vaga vaga);
    String getDesc();
}
