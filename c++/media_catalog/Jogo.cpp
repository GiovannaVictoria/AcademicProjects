#include "Jogo.h"

namespace catalogo {

   /* Construtor da classe Jogo */
   Jogo::Jogo (string titulo, int anoCriacao, string genero) : Midia(titulo, anoCriacao), genero(genero) {}

   /* Destrutor da classe Jogo */
   Jogo::~Jogo () {}

   /*
   Nome: getTipo
   Objetivo: informar qual o tipo de midia que é o objeto
   Parametros: nao ha
   Retorno: inteiro referente ao tipo da midia (1-CD, 2-DVD, 3-Jogo)
   */
   int Jogo::getTipo () const {
      return 3;
   }

   /*
   Nome: imprimeDados
   Objetivo: imprimir os dados do Jogo, o que inclui o seu genero
   Parametros: nao ha
   Retorno: nao ha
   */
   void Jogo::imprimeDados () const {
      cout << "Genero: " << this->genero << endl;
   }

   /* Setter do atributo Genero */
   void Jogo::setGenero (string genero) {
      this->genero = genero;
   }

   /* Getter do atributo Genero */
   string Jogo::getGenero () const {
      return this->genero;
   }

}