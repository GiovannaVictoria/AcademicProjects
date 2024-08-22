package portalVagas.Factory;

import portalVagas.Observer.Observer;
import portalVagas.Observer.ObserverCandidato;
import portalVagas.Observer.ObserverEmpresa;
import portalVagas.PortalFacade.Usuario;

public class ObserverFactory {
   private static ObserverFactory instance;
   
   private ObserverFactory() {}
   
   public static ObserverFactory getInstance() {
      if (instance == null) {
         instance = new ObserverFactory();
      }
      return instance;
   }

   public Observer criaObserverEmpresa() {
      return new ObserverEmpresa();
   }

   public Observer criaObserverEmpresa(Usuario empresa) {
      return new ObserverEmpresa(empresa);
   }

   public Observer criaObserverCandidato() {
      return new ObserverCandidato();
   }

   public Observer criaObserverCandidato(Usuario candidato) {
      return new ObserverCandidato(candidato);
   }
}
