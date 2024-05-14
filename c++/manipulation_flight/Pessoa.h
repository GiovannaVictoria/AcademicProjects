#ifndef PESSOA_H
#define PESSOA_H

#include <iostream>

using namespace std;

class Pessoa {

   private:
      string CPF, nome;

   public:
      Pessoa(string, string);
      string getCPF();
      string getNome();
      void imprime();

};

#endif /* PESSOA_H */