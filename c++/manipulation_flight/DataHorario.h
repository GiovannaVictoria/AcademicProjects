#ifndef DATAHORARIO_H
#define DATAHORARIO_H

#include <iomanip>
#include <iostream>

using namespace std;

class DataHorario {

   private:
      int ano, dia, hora, mes, minuto, segundo;

   public:
      DataHorario(int, int, int, int, int, int);
      virtual ~DataHorario();
      int compara(DataHorario&);
      int getDia() const;
      int getMes() const;
      int getAno() const;
      int getSegundo() const;
      int getMinuto() const;
      int getHora() const;
      void imprime(bool);
      void imprimePorExtenso();

};

#endif /* DATAHORARIO_H */