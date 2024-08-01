package portalVagas;

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

   public Observer criaObserverFuncionario() {
      return new ObserverFuncionario();
   }

   public Observer criaObserverFuncionario(Usuario funcionario) {
      return new ObserverFuncionario(funcionario);
   }
}
