#include "Cesar.h"

namespace cifra {

   Cesar::Cesar () {}

   Cesar::~Cesar () {}

   void Cesar::encripte (string fileIn, string fileOut, int k) {
      char caractere;
      ifstream entrada;
      ofstream saida;
      entrada.open(fileIn);
      saida.open(fileOut);
      if (entrada.is_open()) {
         entrada.get(caractere);
         while (!entrada.eof()) {
            if ( (caractere>64&&caractere<91)||(caractere>96&&caractere<123) ) {
               if (caractere+k<65) {
                  saida.put(caractere+k+26);
               } else if (caractere+k>90&&caractere+k<97) {
                  if (caractere<91) {
                     saida.put(caractere+k-26);
                  } else {
                     saida.put(caractere+k+26);
                  }
               } else if (caractere+k>122) {
                  saida.put(caractere+k-26);
               } else {
                  saida.put(caractere+k);
               }
            } else {
               saida.put(caractere);
            }
            entrada.get(caractere);
         }
      } else {
         cout << "Nao foi possivel abrir o arquivo \"" << fileIn << "\"" << endl;
      }
      entrada.close();
      saida.close();
   }

}