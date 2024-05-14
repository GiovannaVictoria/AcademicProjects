#include "DVD.h"

namespace catalogo {

   /* Construtor da classe CD */
   DVD::DVD (string titulo, int anoCriacao, string diretor) : Midia(titulo, anoCriacao), diretor(diretor) {}

   /* Destrutor da classe CD */
   DVD::~DVD () {}

   /*
   Nome: getTipo
   Objetivo: informar qual o tipo de midia que é o objeto
   Parametros: nao ha
   Retorno: inteiro referente ao tipo da midia (1-CD, 2-DVD, 3-Jogo)
   */
   int DVD::getTipo () const {
      return 2;
   }

   /*
   Nome: imprimeDados
   Objetivo: imprimir os dados do DVD, o que inclui o diretor e o elenco da obra, ou seja, o nome do artista e o seu papel
   Parametros: nao ha
   Retorno: nao ha
   */
   void DVD::imprimeDados () const {
      cout << "Diretor: " << this->diretor << endl;
      for (long unsigned int i=0; i<artistasNomes.size(); i++) {
         cout << "Artista " << (i+1) << ": " << artistasNomes[i] << ", papel: " << artistasPapeis[i] << endl;
      }
   }

   /*
   Nome: adicionaArtista
   Objetivo: adicionar um artista e seu papel no elenco do DVD
   Parametros:
      - nome: string contendo o nome do artista
      - papel: string contendo o papel do artista
   Retorno: nao ha
   */
   void DVD::adicionaArtista (string nome, string papel) {
      artistasNomes.push_back(nome);
      artistasPapeis.push_back(papel);
   }

   /* Setter do atributo Diretor */
   void DVD::setDiretor (string diretor) {
      this->diretor = diretor;
   }

   /* Getter do atributo Diretor */
   string DVD::getDiretor () const {
      return this->diretor;
   }

}