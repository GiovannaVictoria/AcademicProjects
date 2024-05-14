#include "Catalogo.h"

namespace catalogo {

   /* Construtor da classe Catalogo */
   Catalogo::Catalogo () {}

   /* Destrutor da classe Catalogo */
   Catalogo::~Catalogo () {}

   /*
   Nome: adicionaMidia
   Objetivo: adicionar uma midia no vetor de midias, se ele ja nao contiver a midia
   Parametros: midia - objeto da classe Midia - parametro por referencia
   Retorno:
      - true se a midia foi adicionada
      - false se a midia nao foi adicionada (o vetor ja tinha a midia)
   */
   bool Catalogo::adicionaMidia (Midia& midia) {
      Midia *verificacao = this->obtemMidia(midia.getTitulo());
      if (verificacao!=NULL && midia.getTipo()==verificacao->getTipo()) {
         return false;
      } else {
         this->midias.push_back(&midia);
         return true;
      }
      delete(verificacao);
   }

   /*
   Nome: removeMidia
   Objetivo: remover uma midia do vetor de midias, se ele contiver a midia
   Parametros: titulo - string contendo o nome da midia que sera removida - parametro por copia
   Retorno:
      - true se a midia foi removida
      - false se a midia nao foi removida (o vetor nao continha a midia)
   */
   bool Catalogo::removeMidia (string titulo) {
      int pos;
      if (this->obtemMidia(titulo)==NULL) {
         return false;
      } else {
         pos = 0;
         while (this->midias[pos]->getTitulo()!=titulo) {
            pos++;
         }
         this->midias.erase(this->midias.begin()+pos);
         return true;
      }
   }

   /*
   Nome: obtemMidia
   Objetivo: procurar uma midia especifica no vetor de midias
   Parametros: titulo - string contendo o nome da midia que sera procurada - parametro por copia
   Retorno: ponteiro para midia contendo a midia procurada
   */
   Midia* Catalogo::obtemMidia (string titulo) const {
      Midia *midia = NULL;
      long unsigned int pos;
      pos = 0;
      while (pos<this->midias.size()) {
         if (this->midias[pos]->getTitulo()==titulo) {
            break;
         }
         pos++;
      }
      if (pos<this->midias.size()) {
         midia = this->midias[pos];
      } else {
         delete(midia);
      }
      return midia;
   }

   /*
   Nome: quantidadeDeMidias
   Objetivo: obter o numero total de midias que o vetor contem
   Parametros: nao ha
   Retorno: inteiro contendo a quantidade de midias alocadas
   */
   int Catalogo::quantidadeDeMidias () const {
      return this->midias.size();
   }

   /*
   Nome: quantidadeDeCDs
   Objetivo: obter o numero total de midias que sao do tipo CD
   Parametros: nao ha
   Retorno: inteiro contendo a quantidade de cds alocados
   */
   int Catalogo::quantidadeDeCDs () const {
      int quantidade;
      quantidade = 0;
      for (long unsigned int i=0; i<this->midias.size(); i++) {
         if (this->midias[i]->getTipo()==1) {
            quantidade++;
         }
      }
      return quantidade;
   }

   /*
   Nome: quantidadeDeDVDs
   Objetivo: obter o numero total de midias que sao do tipo DVD
   Parametros: nao ha
   Retorno: inteiro contendo a quantidade de dvds alocados
   */
   int Catalogo::quantidadeDeDVDs () const {
      int quantidade;
      quantidade = 0;
      for (long unsigned int i=0; i<this->midias.size(); i++) {
         if (this->midias[i]->getTipo()==2) {
            quantidade++;
         }
      }
      return quantidade;
   }

   /*
   Nome: quantidadeDeJogos
   Objetivo: obter o numero total de midias que sao do tipo Jogo
   Parametros: nao ha
   Retorno: inteiro contendo a quantidade de jogos alocados
   */
   int Catalogo::quantidadeDeJogos () const {
      int quantidade;
      quantidade = 0;
      for (long unsigned int i=0; i<this->midias.size(); i++) {
         if (this->midias[i]->getTipo()==3) {
            quantidade++;
         }
      }
      return quantidade;
   }

   /*
   Nome: imprimeColecao
   Objetivo: imprimir a ficha de todas as midias alocadas, o que inclui o titulo, o ano, o tipo da midia, e os dados dela
   Parametros: nao ha
   Retorno: nao ha
   */
   void Catalogo::imprimeColecao () {
      sort(this->midias.begin(), this->midias.end(), Midia::comparaMidia);
      for (long unsigned int i=0; i<this->midias.size(); i++) {
         this->midias[i]->imprimeFicha();
      }
   }

   /*
   Nome: imprimeColecaoPorTipo
   Objetivo: imprimir a ficha de todas as midias alocadas que sao de um tipo especifico, o que inclui o titulo, o ano, o tipo da midia, e os dados dela
   Parametros: tipo - inteiro referente ao tipo de midia que sera impressa - parametro por copia
   Retorno: nao ha
   */
   void Catalogo::imprimeColecaoPorTipo (int tipo) {
      sort(this->midias.begin(), this->midias.end(), Midia::comparaMidia);
      for (long unsigned int i=0; i<this->midias.size(); i++) {
         if (this->midias[i]->getTipo()==tipo) {
            this->midias[i]->imprimeFicha();
         }
      }
   }

}