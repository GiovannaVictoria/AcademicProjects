#include "Voo.h"

/*
Construtor da classe Voo
*/
Voo::Voo(int numero, DataHorario &diaHora) : numero(numero), diaHora(diaHora) {
   memset(passageiros, 0, 100*sizeof(Pessoa*));
}

/*
nome: proximoLivre
objetivo: identificar a proxima poltrona disponivel no voo
parametros: nao ha
retorno:
   - inteiro relativo ao numero da poltrona
*/
int Voo::proximoLivre() {
   int proximo = 0;
   while (this->passageiros[proximo]!=0 && proximo<100) {
      proximo++;
   }
   return ++proximo;
}

/*
nome: verifica
objetivo: verificar se uma poltrona especifica esta ocupada
parametros:
   - inteiro relativo ao numero da poltrona
retorno:
   - true se a poltrona estiver ocupada
   - false se a poltrona estiver livre
*/
bool Voo::verifica(int poltrona) {
   return (passageiros[poltrona-1]!=0);
}

bool Voo::ocupa(int poltrona, Pessoa &passageiro) {
   if (verifica(poltrona)) {
      return false;
   } else {
      passageiros[poltrona-1] = &passageiro;
      return true;
   }
}

/*
nome: desocupa
objetivo: tentar desocupar uma poltrona, caso ela esteja ocupada
parametros:
   - inteiro relativo ao numero da poltrona
retorno:
   - true se a poltrona foi desocupada
   - false se a poltrona nao foi desocupada
*/
bool Voo::desocupa(int poltrona) {
   if (verifica(poltrona)) {
      passageiros[poltrona-1] = 0;
      return true;
   } else {
      return false;
   }
}

/*
nome: vagas
objetivo: informar o numero total de poltronas disponiveis no voo
parametros: nao ha
retorno:
   - inteiro relativo ao numero de vagas
*/
int Voo::vagas() {
   int qtd = 0;
   for (int i=1; i<=100; i++) {
      if (!verifica(i)) {
         qtd++;
      }
   }
   return qtd;
}

/*
nome: imprime
objetivo: imprimir as informacoes do voo - numero, data e horario, numero de vagas, e lista dos passageiros com suas informacoes (nome e CPF)
parametros: nao ha
retorno: nao ha
*/
void Voo::imprime() {
   cout << "Numero: " << this->numero << endl;
   this->diaHora.imprime(false);
   cout << "Vagas livres: " << vagas() << endl << endl;
   cout << "Passageiros:" << endl;
   for (int i=0; i<100; i++) {
      if (verifica(i+1)) {
         this->passageiros[i]->imprime();
         cout << endl;
      }
   }
}

/*
Getter do parametro "numero"
*/
int Voo::getNumero() const {
   return this->numero;
}

/*
Setter do parametro "numero"
*/
void Voo::setNumero(int numero) {
   this->numero = numero;
}

/*
Getter do parametro "diaHora"
*/
DataHorario Voo::getDiaHora() const {
   return this->diaHora;
}

/*
Setter do parametro "diaHora"
*/
void Voo::setDiaHora(DataHorario diaHora) {
   this->diaHora = diaHora;
}