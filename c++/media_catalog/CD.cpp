#include "CD.h"

namespace catalogo {

   /* Construtor da classe CD */
   CD::CD (string titulo, int anoCriacao, string artista) : Midia(titulo, anoCriacao), artista(artista) {}

   /* Destrutor da classe CD */
   CD::~CD () {}

   /*
   Nome: getTipo
   Objetivo: informar qual o tipo de midia que é o objeto
   Parametros: nao ha
   Retorno: inteiro referente ao tipo da midia (1-CD, 2-DVD, 3-Jogo)
   */
   int CD::getTipo () const {
      return 1;
   }

   /*
   Nome: imprimeDados
   Objetivo: imprimir os dados do CD, o que inclui o artista e o nome e duracao de cada faixa
   Parametros: nao ha
   Retorno: nao ha
   */
   void CD::imprimeDados () const {
      int minutos, segundos;
      cout << "Artista: " << this->artista << endl;
      for (long unsigned int i=0; i<this->faixaNomes.size(); i++) {
         minutos = this->faixaDuracao[i]/60;
         segundos -= minutos*60;
         cout << "Faixa " << (i+1) << ": " << this->faixaNomes[i] << ", duracao: " << minutos << ":" << segundos << endl;
      }
   }

   /*
   Nome: adicionaFaixa
   Objetivo: adicionar uma faixa no CD
   Parametros:
      - nome: string contendo o nome da faixa
      - duracao: inteiro contendo a duracao da faixa em segundos
   Retorno: nao ha
   */
   void CD::adicionaFaixa (string nome, int duracao) {
      this->faixaNomes.push_back(nome);
      this->faixaDuracao.push_back(duracao);
   }

   /* Setter do atributo Artista */
   void CD::setArtista (string artista) {
      this->artista = artista;
   }

   /* Getter do atributo Artista */
   string CD::getArtista () const {
      return this->artista;
   }

}