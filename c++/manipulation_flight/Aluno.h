#ifndef ALUNO_H
#define ALUNO_H

#include "Pessoa.h"

class Aluno : public Pessoa {

   private:
      int RA;
      double P1, P2, T1;

   public:
      Aluno(string, string, int, double, double, double);
      int getRA();
      double media();
      bool aprovado();
      bool sac();
      double notaSAC();
      void imprime();

};

#endif /* ALUNO_H */