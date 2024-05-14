#ifndef CESAR_H
#define CESAR_H

#include <fstream>
#include <iostream>

using namespace std;

namespace cifra {

   class Cesar {

      public:
         Cesar();
         virtual ~Cesar();
         void encripte (string, string, int);

   };

}

#endif /* CESAR_H */