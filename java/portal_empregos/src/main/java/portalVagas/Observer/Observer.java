package portalVagas.Observer;

import portalVagas.PortalFacade.Vaga;

public abstract class Observer {
    public Observer() {}

    public abstract void update(Vaga vaga);
}