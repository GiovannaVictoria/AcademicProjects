package portalVagas.PortalFacade;

public class Fechada implements Estado {
    String desc = "Fechada";
    @Override
    public void abrir(Vaga vaga)
    {
        vaga.setEstado(new Aberta());
        System.out.println("A vaga '" + vaga.getNome() + "' foi reaberta!");
    }

    @Override
    public void fechar(Vaga vaga)
    {
        System.out.println("A vaga '" + vaga.getNome() + "' já está fechada!");
    }

    @Override
    public void cancelar(Vaga vaga)
    {
        vaga.setEstado(new Cancelada());
        System.out.println("A vaga '" + vaga.getNome() + "' foi cancelada!");
    }
    public String getDesc()
    {
        return desc;
    }
}
