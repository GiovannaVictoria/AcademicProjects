#ifndef JOGO_H
#define JOGO_H

#include "Midia.h"

namespace catalogo {

   class Jogo : public Midia {

      private:
         string genero;

      public:
         Jogo(string, int, string);
         virtual ~Jogo();
         virtual int getTipo() const;
         virtual void imprimeDados() const;
         void setGenero(string);
         string getGenero() const;

   };

}

#endif /* JOGO_H */
