#ifndef VOO_H
#define VOO_H

#include <cstring>
#include "Pessoa.h"
#include "DataHorario.h"

class Voo {

   private:
      int numero;
      DataHorario &diaHora;
      Pessoa *passageiros[100];

   public:
      Voo(int, DataHorario&);
      int proximoLivre();
      bool verifica(int);
      bool ocupa(int, Pessoa&);
      bool desocupa(int);
      int vagas();
      void imprime();
      int getNumero() const;
      void setNumero(int);
      DataHorario getDiaHora() const;
      void setDiaHora(DataHorario);

};

#endif /* VOO_H */