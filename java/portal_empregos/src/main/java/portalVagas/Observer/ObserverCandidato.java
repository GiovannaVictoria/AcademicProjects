package portalVagas.Observer;

import portalVagas.PortalFacade.Usuario;
import portalVagas.PortalFacade.Vaga;

public class ObserverCandidato extends Observer {
   private Usuario candidato;

   public ObserverCandidato() {
      super();
   }

   public ObserverCandidato(Usuario candidato) {
      this.candidato = candidato;
   }

   public Usuario getCandidato() {
      return candidato;
   }

   public void setCandidato(Usuario candidato) {
      this.candidato = candidato;
   }

   public void update(Vaga vaga) {
      System.out.println("Nova vaga postada: " + vaga.getNome());
   }
}
