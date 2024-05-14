#include <fstream>
#include <iostream>
#include "Metal.h"
#include "Ametal.h"
#include "CRUD.h"

using namespace std;

int main () {
   
   Metal *m1 = new Metal ("Cobre", "Cu", "Metal de transicao", 29, 11, 4, 63.546, 8.96, "solido", 1085, 2562, 56, 401, 20);
   Metal *m2 = new Metal ();
   Metal *m3 = new Metal ("Calcio", "Ca", "Metal alcalino-terroso", 20, 2, 4, 40.078, 1.54, "solido", 842, 1484, 298000, 2, 20);
   Metal *m4 = new Metal ();
   Metal *m5 = new Metal ("Plutonio alpha", "alpha-Pu", "Actinidio", 94, 3, 7, 244, 19.8, "solido", 639.4, 3232, 150, 6.74, 20);
   Metal *m6 = new Metal ();

   Ametal *am1 = new Ametal ("Fluor", "F", "Halogenio", 9, 17, 2, 18.998, 1.696, "gasoso", -219.6, -188.1, 126.31);
   Ametal *am2 = new Ametal ();
   Ametal *am3 = new Ametal ("Argonio", "Ar", "Gas nobre", 18, 18, 3, 39.948, 1784, "gasoso", -189.4, -185.8, 0.952);
   Ametal *am4 = new Ametal ();

   ofstream elementos;
   elementos.open("elementos.dat", ios::out|ios::binary);
   CRUD *arquivo = new CRUD();
   
   arquivo->criar("elementos.dat", m1);
   arquivo->criar("elementos.dat", m3);
   arquivo->criar("elementos.dat", m5);
   arquivo->criar("elementos.dat", am1);
   arquivo->criar("elementos.dat", am3);
   
   arquivo->ler("elementos.dat", m1, m2);
   arquivo->ler("elementos.dat", m3, m4);
   arquivo->ler("elementos.dat", m5, m6);
   arquivo->ler("elementos.dat", am1, am2);
   arquivo->ler("elementos.dat", am3, am4);
   
   m2->imprimeMetal();
   cout << "-------------------------------------------" << endl;
   m4->imprimeMetal();
   cout << "-------------------------------------------" << endl;
   m6->imprimeMetal();
   cout << "-------------------------------------------" << endl;
   am2->imprimeAmetal();
   cout << "-------------------------------------------" << endl;
   am4->imprimeAmetal();
   
   delete (m1);
   delete (m2);
   delete (m3);
   delete (m4);
   delete (m5);
   delete (m6);
   delete (am1);
   delete (am2);
   delete (am3);
   delete (am4);
   
   return 0;

}