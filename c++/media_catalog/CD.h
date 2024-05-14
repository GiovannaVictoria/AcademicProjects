#ifndef CD_H
#define CD_H

#include "Midia.h"

namespace catalogo {

   class CD : public Midia {

      private:
         string artista;
         vector<string> faixaNomes;
         vector<int> faixaDuracao;

      public:
         CD(string, int, string);
         virtual ~CD();
         virtual int getTipo() const;
         virtual void imprimeDados() const;
         void adicionaFaixa(string, int);
         void setArtista(string);
         string getArtista() const;

   };

}

#endif /* CD_H */