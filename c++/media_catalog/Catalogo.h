#ifndef CATALOGO_H
#define CATALOGO_H

#include "Midia.h"

namespace catalogo {

   class Catalogo {

      private:
         vector<Midia*> midias;

      public:
         Catalogo();
         virtual ~Catalogo();
         bool adicionaMidia(Midia&);
         bool removeMidia(string);
         Midia* obtemMidia(string) const;
         int quantidadeDeMidias() const;
         int quantidadeDeCDs() const;
         int quantidadeDeDVDs() const;
         int quantidadeDeJogos() const;
         void imprimeColecao();
         void imprimeColecaoPorTipo(int);

   };

}

#endif /* CATALOGO_H */
