package portalVagas;

public class ObserverFuncionario extends Observer {
   private Usuario funcionario;

   public ObserverFuncionario() {
      super();
   }

   public ObserverFuncionario(Usuario funcionario) {
      this.funcionario = funcionario;
   }

   public Usuario getFuncionario() {
      return funcionario;
   }

   public void setFuncionario(Usuario funcionario) {
      this.funcionario = funcionario;
   }

   public void update(Vaga vaga) {
      System.out.println("Nova vaga postada: " + vaga.getNome());
   }
}
