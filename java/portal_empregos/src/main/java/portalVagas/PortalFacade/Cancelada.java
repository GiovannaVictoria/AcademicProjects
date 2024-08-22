package portalVagas.PortalFacade;

public class Cancelada implements Estado {
    String desc = "Cancelada";
    @Override
    public void abrir(Vaga vaga)
    {
        System.out.println("A vaga '" + vaga.getNome() + "' nao pode ser aberta, pois foi cancelada!");
        
    }

    @Override
    public void fechar(Vaga vaga)
    {
        System.out.println("A vaga '" + vaga.getNome() + "' nao pode ser fechada, pois foi cancelada!");
    }

    @Override
    public void cancelar(Vaga vaga)
    {
        System.out.println("A vaga '" + vaga.getNome() + "' já foi cancelada!");
    }
    
    public String getDesc()
    {
        return desc;
    }
}
