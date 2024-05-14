#include "Elemento.h"

/* Construtor vazio da classe Elemento */
Elemento::Elemento () {}

/* Construtor classe Elemento com todos os atributos */
Elemento::Elemento (string nome, string simbolo, string subclassificacao, int numeroAtomico, int grupo, int periodo, double massa, double densidade, string estado, double pontoFusao, double pontoEbulicao) : nome(nome), simbolo(simbolo), subclassificacao(subclassificacao), numeroAtomico(numeroAtomico), grupo(grupo), periodo(periodo), massa(massa), densidade(densidade), estado(estado), pontoFusao(pontoFusao), pontoEbulicao(pontoEbulicao) {}

/* Destrutor da classe Elemento */
Elemento::~Elemento () {}

/* Getter do atributo nome */
string Elemento::getNome () const {
   return this->nome;
}

/* Getter do atributo subclassificacao */
string Elemento::getSubclassificacao () const {
   return this->subclassificacao;
}

/* Getter do atributo simbolo */
string Elemento::getSimbolo () const {
   return this->simbolo;
}

/* Getter do atributo numeroAtomico */
int Elemento::getNumeroAtomico () const {
   return this->numeroAtomico;
}

/* Getter do atributo grupo */
int Elemento::getGrupo () const {
   return this->grupo;
}

/* Getter do atributo periodo */
int Elemento::getPeriodo () const {
   return this->periodo;
}

/* Getter do atributo massa */
double Elemento::getMassa () const {
   return this->massa;
}

/* Getter do atributo densidade */
double Elemento::getDensidade () const {
   return this->densidade;
}

/* Getter do atributo estado */
string Elemento::getEstado () const {
   return this->estado;
}

/* Getter do atributo pontoFusao */
double Elemento::getPontoFusao () const {
   return this->pontoFusao;
}

/* Getter do atributo pontoEbulicao */
double Elemento::getPontoEbulicao () const {
   return this->pontoEbulicao;
}

/* Setter do atributo nome */
void Elemento::setNome (string nome) {
   this->nome = nome;
}

/* Setter do atributo subClassificacao */
void Elemento::setSubclassificacao (string subclassificacao) {
   this->subclassificacao = subclassificacao;
}

/* Setter do atributo simbolo */
void Elemento::setSimbolo (string simbolo) {
   this->simbolo = simbolo;
}

/* Setter do atributo numeroAtomico */
void Elemento::setNumeroAtomico (int numeroAtomico) {
   this->numeroAtomico = numeroAtomico;
}

/* Setter do atributo grupo */
void Elemento::setGrupo (int grupo) {
   this->grupo = grupo;
}

/* Setter do atributo periodo */
void Elemento::setPeriodo (int periodo) {
   this->periodo = periodo;
}

/* Setter do atributo massa */
void Elemento::setMassa (double massa) {
   this->massa = massa;
}

/* Setter do atributo densidade */
void Elemento::setDensidade (double densidade) {
   this->densidade = densidade;
}

/* Setter do atributo estado */
void Elemento::setEstado (string estado) {
   this->estado = estado;
}

/* Setter do atributo pontoFusao */
void Elemento::setPontoFusao (double pontoFusao) {
   this->pontoFusao = pontoFusao;
}

/* Setter do atributo pontoEbulicao */
void Elemento::setPontoEbuilcao (double pontoEbulicao) {
   this->pontoEbulicao = pontoEbulicao;
}

/*
Nome: imprimeElemento
Objetivo: imprimir todos os atributos do elemento
Parametros: nao ha
Retorno: nao ha
*/
void Elemento::imprimeElemento () const {
   cout << "Nome: " << this->nome << endl;
   cout << "Simbolo: " << this->simbolo << endl;
   cout << "Subclassificacao: " << this->subclassificacao << endl;
   cout << "Numero atomico: " << this->numeroAtomico << endl;
   cout << "Grupo: " << this->grupo << endl;
   cout << "Periodo: " << this->periodo << endl;
   cout << "Massa atomica: " << this->massa << " u" << endl;
   cout << "Densidade: " << this->densidade << "g/cm^3" << endl;
   cout << "Estado na temperatura ambiente: " << this->estado << endl;
   cout << "Ponto de fusao: " << this->pontoFusao << "°C" << endl;
   cout << "Ponto de ebulicao: " << this->pontoEbulicao << "°C" << endl;
}

/*
Nome: comparaElemento
Objetivo: definir a ordem dos elementos em caso de necessidade, que no caso sao ordenados pelo numero atomico
Parametros:
   - e1: ponteiro para o tipo Elemento, o primeiro elemento a ser comparado
   - e2: ponteiro para o tipo Elemento, o segundo elemento a ser comparado
Retorno:
   - false se o numero atomico de e1 for maior que o numero atomico de e2
   - true se o numero atomico de e1 for menor que o numero atomico de e2
*/
bool Elemento::comparaElemento (Elemento *e1, Elemento *e2) {
   return (e1->getNumeroAtomico()<e2->getNumeroAtomico());
}