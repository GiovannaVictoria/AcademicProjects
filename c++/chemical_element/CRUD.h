#ifndef CRUD_H
#define CRUD_H

#include "Metal.h"
#include "Ametal.h"

class CRUD {

   public:
      CRUD ();
      virtual ~CRUD ();
      bool criar (const char *, Elemento*);
      bool ler (const char *, Elemento*, Elemento*);

};

#endif /* CRUD_H */