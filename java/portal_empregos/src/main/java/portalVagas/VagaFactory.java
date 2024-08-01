package portalVagas;

public class VagaFactory {
   private static VagaFactory instance;

   private VagaFactory() {}

   public static VagaFactory getInstance() {
      if (instance == null) {
         instance = new VagaFactory();
      }
      return instance;
   }

   public Vaga criaVaga(String nome,  String descricao, Usuario empresa) {
      return new Vaga(nome, descricao, empresa);
   }
}
