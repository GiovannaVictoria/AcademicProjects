#ifndef AMETAL_H
#define AMETAL_H

#include "Elemento.h"

class Ametal : public Elemento {

   private:
      double fragmentabilidade;

   public:
      Ametal ();
      Ametal (string, string, string, int, int, int, double, double, string, double, double, double);
      virtual ~Ametal ();
      virtual bool getTipo () const;
      double getFragmentabilidade () const;
      void setFragmentabilidade (double);
      void imprimeAmetal () const;

};

#endif /* AMETAL_H */