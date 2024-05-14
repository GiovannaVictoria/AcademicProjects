#ifndef METAL_H
#define METAL_H

#include "Elemento.h"

class Metal : public Elemento {
   
   private:
      double condutividadeEletrica, condutividadeTermica, temperaturaCondutividade;
   
   public:
      Metal ();
      Metal (string, string, string, int, int, int, double, double, string, double, double, double, double, double);
      virtual ~Metal ();
      virtual bool getTipo () const;
      double getCondutividadeEletrica () const;
      double getCondutividadeTermica () const;
      double getTemperaturaCondutividade () const;
      void setCondutividadeEletrica (double);
      void setCondutividadeTermica (double);
      void setTemperaturaCondutividade (double);
      void imprimeMetal () const;

};

#endif /* METAL_H */