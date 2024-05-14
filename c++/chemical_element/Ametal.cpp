#include "Ametal.h"

/* Construtor vazio da classe Ametal */
Ametal::Ametal () {}

/* Construtor da classe Ametal com todos os atributos */
Ametal::Ametal (string nome, string simbolo, string subclassificacao, int numeroAtomico, int grupo, int periodo, double massa, double densidade, string estado, double pontoFusao, double pontoEbulicao, double fragmentabilidade) : Elemento (nome, simbolo, subclassificacao, numeroAtomico, grupo, periodo, massa, densidade, estado, pontoFusao, pontoEbulicao), fragmentabilidade(fragmentabilidade) {}

/* Destrutor da classe Ametal */
Ametal::~Ametal () {}

/*
Nome: getTipo
Objetivo: informar se o elemento é metal ou ametal
Parametros: nao ha
Retorno:
   - false se o elemento for ametal
   - true se o elemento for metal
*/
bool Ametal::getTipo () const {
   return false;
}

/* Getter do atributo fragmentabilidade */
double Ametal::getFragmentabilidade () const {
   return this->fragmentabilidade;
}

/* Setter do atributo fragmentabilidade */
void Ametal::setFragmentabilidade (double fragmentabilidade) {
   this->fragmentabilidade = fragmentabilidade;
}

/*
Nome: imprimeAmetal
Objetivo: imprimir todos os atributos do ametal
Parametros: nao ha
Retorno: nao ha
*/
void Ametal::imprimeAmetal () const {
   Elemento::imprimeElemento();
   cout << "Fragmentabilidade: " << this->fragmentabilidade << " F/m^2Kg" << endl;
}