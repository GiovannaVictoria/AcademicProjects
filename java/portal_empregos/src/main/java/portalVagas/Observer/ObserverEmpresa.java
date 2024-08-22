package portalVagas.Observer;

import portalVagas.PortalFacade.Usuario;
import portalVagas.PortalFacade.Vaga;

public class ObserverEmpresa extends Observer {
   private Usuario empresa;

   public ObserverEmpresa() {
      super();
   }

   public ObserverEmpresa(Usuario empresa) {
      super();
      this.empresa = empresa;
   }

   public Usuario getEmpresa() {
      return empresa;
   }

   public void setEmpresa(Usuario empresa) {
      this.empresa = empresa;
   }

   public void update(Vaga vaga) {
      System.out.println("Nova candidatura para a vaga " + vaga.getNome());
   }
}
