#ifndef ELEMENTO_H
#define ELEMENTO_H

#include <fstream>
#include <cstring>
#include <iostream>
#include <algorithm>

using namespace std;

class Elemento {

   private:
      int grupo, numeroAtomico, periodo;
      string estado, nome, simbolo, subclassificacao;
      double densidade, massa, pontoEbulicao, pontoFusao;
      
   public:
      Elemento ();
      Elemento (string, string, string, int, int, int, double, double, string, double, double);
      virtual ~Elemento ();
      virtual bool getTipo () const = 0;
      string getNome () const;
      string getSubclassificacao () const;
      string getSimbolo () const;
      int getNumeroAtomico () const;
      int getGrupo () const;
      int getPeriodo () const;
      double getMassa () const;
      double getDensidade () const;
      string getEstado () const;
      double getPontoFusao () const;
      double getPontoEbulicao () const;
      void setNome (string);
      void setSubclassificacao (string);
      void setSimbolo (string);
      void setNumeroAtomico (int);
      void setGrupo (int);
      void setPeriodo (int);
      void setMassa (double);
      void setDensidade (double);
      void setEstado (string);
      void setPontoFusao (double);
      void setPontoEbuilcao (double);
      void imprimeElemento () const;
      static bool comparaElemento (Elemento*, Elemento*);

};

#endif /* ELEMENTO_H */