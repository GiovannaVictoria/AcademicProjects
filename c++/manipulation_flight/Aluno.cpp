#include "Aluno.h"

/*
Construtor da classe Aluno
*/
Aluno::Aluno(string CPF, string nome, int RA, double P1, double P2, double T1) : Pessoa(CPF, nome), RA(RA), P1(P1), P2(P2), T1(T1) {}

/*
Getter do parametro "RA"
*/
int Aluno::getRA() {
   return this->RA;
}

/*
nome: media
objetivo: calcular a media final do aluno
parametros: nao ha
retorno:
   - double relativo a media
*/
double Aluno::media() {
   return (0.35*this->P1 + 0.35*this->P2 + 0.3*this->T1);
}

/*
nome: aprovado
objetivo: verificar se o aluno foi aprovado ou nao na disciplina
parametros: nao ha
retorno:
   - true se o aluno foi aprovado
   - false se o aluno nao foi aprovado
*/
bool Aluno::aprovado() {
   return (media()>=6);
}

/*
nome: sac
objetivo: verificar se o aluno ficou de recuperacao
parametros: nao ha
retorno:
   - true se o aluno ficou de recuperacao
   - false se o aluno nao ficou de recuperacao
*/
bool Aluno::sac() {
   return ( (media()<6)&&(media()>=5) );
}

/*
nome: notaSac
objetivo: calcular a nota minima necessaria pro aluno tirar na recuperacao e ser aprovado
parametros: nao ha
retorno:
   - double relativo a nota minima
*/
double Aluno::notaSAC() {
   if (sac()) {
      return (12-media());
   } else {
      return 0;
   }
}

/*
nome: imprime
objetivo: imprimir as informacoes do aluno - nome, CPF, RA e media final
parametros: nao ha
retorno: nao ha
*/
void Aluno::imprime() {
   Pessoa::imprime();
   cout << "RA: " << this->RA << endl;
   cout << "Media final: " << media() << endl;
}