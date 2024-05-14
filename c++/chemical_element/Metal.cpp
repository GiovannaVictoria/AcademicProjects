#include "Metal.h"

/* Construtor vazio da classe Metal */
Metal::Metal () {}

/* Construtor da classe Metal com todos os atributos */
Metal::Metal (string nome, string simbolo, string subclassificacao, int numeroAtomico, int grupo, int periodo, double massa, double densidade, string estado, double pontoFusao, double pontoEbulicao, double condutividadeEletrica, double condutividadeTermica, double temperaturaCondutividade) : Elemento (nome, simbolo, subclassificacao, numeroAtomico, grupo, periodo, massa, densidade, estado, pontoFusao, pontoEbulicao), condutividadeEletrica(condutividadeEletrica), condutividadeTermica(condutividadeTermica), temperaturaCondutividade(temperaturaCondutividade) {}

/* Destrutor da classe Metal */
Metal::~Metal () {}

/*
Nome: getTipo
Objetivo: informar se o elemento é metal ou ametal
Parametros: nao ha
Retorno:
   - false se o elemento for ametal
   - true se o elemento for metal
*/
bool Metal::getTipo () const {
   return true;
}

/* Getter do atributo condutividadeEletrica */
double Metal::getCondutividadeEletrica () const {
   return this->condutividadeEletrica;
}

/* Getter do atributo condutividadeTermica */
double Metal::getCondutividadeTermica () const {
   return this->condutividadeTermica;
}

/* Getter do atributo temperaturaCondutividade */
double Metal::getTemperaturaCondutividade () const {
   return this->temperaturaCondutividade;
}

/* Setter do atributo condutividadeEletrica */
void Metal::setCondutividadeEletrica (double condutividadeEletrica) {
   this->condutividadeEletrica = condutividadeEletrica;
}

/* Setter do atributo condutividadeTermica */
void Metal::setCondutividadeTermica (double condutividadeTermica) {
   this->condutividadeTermica = condutividadeTermica;
}

/* Setter do atributo temperaturaCondutividade */
void Metal::setTemperaturaCondutividade (double temperaturaCondutividade) {
   this->temperaturaCondutividade = temperaturaCondutividade;
}

/*
Nome: imprimeMetal
Objetivo: imprimir todos os atributos do metal
Parametros: nao ha
Retorno: nao ha
*/
void Metal::imprimeMetal () const {
   Elemento::imprimeElemento();
   cout << "Condutividade eletrica: " << this->condutividadeEletrica << " m/(Ω·mm^2) a " << this->temperaturaCondutividade << "°C" << endl;
   cout << "Condutividade termica: " << this->condutividadeTermica << " W/m°C" << endl;
}