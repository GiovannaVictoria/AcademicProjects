#include "Pessoa.h"

/*
Construtor da classe Pessoa
*/
Pessoa::Pessoa(string CPF, string nome) : CPF(CPF), nome(nome) {}

/*
Getter do parametro "CPF"
*/
string Pessoa::getCPF() {
   return this->CPF;
}

/*
Getter do parametro "nome"
*/
string Pessoa::getNome() {
   return this->nome;
}

/*
nome: imprime
objetivo: imprimir as informacoes da pessoa - nome e CPF
parametros: nao ha
retorno: nao ha
*/
void Pessoa::imprime() {
   cout << "Nome: " << this->nome << endl;
   cout << "CPF: " << this->CPF << endl;
}