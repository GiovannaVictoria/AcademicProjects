#ifndef MIDIA_H
#define MIDIA_H

#include <vector>
#include <string>
#include <iostream>
#include <algorithm>

using namespace std;

namespace catalogo {

   class Midia {

      private:
         string titulo;
         int anoCriacao;

      public:
         Midia(string, int);
         virtual ~Midia();
         virtual int getTipo() const = 0;
         virtual void imprimeDados() const = 0;
         void imprimeFicha() const;
         void setTitulo(string);
         void setAnoCriacao(int);
         string getTitulo() const;
         int getAnoCriacao() const;
         virtual bool operator<(const Midia&) const;
         static bool comparaMidia(const Midia*, const Midia*);

   };

}

#endif /* MIDIA_H */