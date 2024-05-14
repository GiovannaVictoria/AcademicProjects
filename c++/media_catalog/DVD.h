#ifndef DVD_H
#define DVD_H

#include "Midia.h"

namespace catalogo {

   class DVD : public Midia {

      private:
         string diretor;
         vector<string> artistasNomes, artistasPapeis;

      public:
         DVD(string, int, string);
         virtual ~DVD();
         virtual int getTipo() const;
         virtual void imprimeDados() const;
         void adicionaArtista(string, string);
         void setDiretor(string);
         string getDiretor() const;

   };

}

#endif /* DVD_H */