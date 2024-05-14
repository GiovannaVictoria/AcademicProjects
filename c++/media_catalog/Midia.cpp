#include "Midia.h"

namespace catalogo {

   /* Construtor da classe Midia */
   Midia::Midia (string titulo, int anoCriacao) : titulo(titulo), anoCriacao(anoCriacao) {}

   /* Destrutor da classe Midia */
   Midia::~Midia () {}

   /*
   Nome: imprimeFicha
   Objetivo: imprimir a ficha da midia, o que inclui o titulo, o ano, o tipo da midia, e os dados dela
   Parametros: nao ha
   Retorno: nao ha
   */
   void Midia::imprimeFicha () const {
      cout << "Titulo: " << this->titulo << endl;
      cout << "Ano: " << this->anoCriacao << endl;
      switch (this->getTipo()) {
         case 1:
            cout << "Tipo: CD de musica" << endl;
            break;
         case 2:
            cout << "Tipo: Filve em DVD" << endl;
            break;
         case 3:
            cout << "Tipo: Jogo eletronico" << endl;
            break;
      }
      this->imprimeDados();
   }

   /* Setter do atributo Titulo */
   void Midia::setTitulo (string titulo) {
      this->titulo = titulo;
   }

   /* Setter do atributo anoCriacao */
   void Midia::setAnoCriacao (int anoCriacao) {
      this->anoCriacao = anoCriacao;
   }

   /* Getter do atributo Titulo */   
   string Midia::getTitulo () const {
      return this->titulo;
   }

   /* Getter do atributo anoCriacao */
   int Midia::getAnoCriacao () const {
      return this->anoCriacao;
   }

   /* Sobreposicao do operador < */
   bool Midia::operator< (const Midia& outra) const {
      if (this->getAnoCriacao()==outra.getAnoCriacao()) {
         return (this->getTitulo()<outra.getTitulo());
      } else {
         return (this->getAnoCriacao()>outra.getAnoCriacao());
      }
   }

   /*
   Nome: comparaMidia
   Objetivo: comparar duas midias
   Parametros:
      - midia1: ponteiro para o objeto da primeira midia - parametro por referencia
      - midia2: ponteiro para o objeto da segunda midia - parametro por referencia
   Retorno:
      - true se midia1 é menor que midia2
      - false se midia1 é maior que midia2
   */
   bool Midia::comparaMidia (const Midia* midia1, const Midia* midia2) {
      return (*midia1<*midia2);
   }

}