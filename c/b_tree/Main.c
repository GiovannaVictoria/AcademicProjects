#include "ArvB.h"

// com essa implementacao e com ordem = 6, a insercao do valor 425 aloca os filhos errado;
// se trocar a implementacao, com ordem = 8, a insercao do valor 552 passa a alocar os filhos errado;

int main () {

   ArvB *raiz = arvB_cria();

   arvB_insere(raiz, 100);
   arvB_insere(raiz, 200);
   arvB_insere(raiz, 300);
   arvB_insere(raiz, 400);
   arvB_insere(raiz, 500);

   arvB_insere(raiz, 225);
   arvB_insere(raiz, 250);
   arvB_insere(raiz, 275);
   arvB_insere(raiz, 600);
   arvB_insere(raiz, 700);

   arvB_insere(raiz, 800);
   arvB_insere(raiz, 350);
   arvB_insere(raiz, 325);
   arvB_insere(raiz, 375);
   arvB_insere(raiz, 430);
 
   arvB_insere(raiz, 460);
   arvB_insere(raiz, 363);
   arvB_insere(raiz, 366);
   arvB_insere(raiz, 369);
   arvB_insere(raiz, 550);

   arvB_insere(raiz, 900);
   arvB_insere(raiz, 1000);
   arvB_insere(raiz, 1100);
   arvB_insere(raiz, 950);
   arvB_insere(raiz, 825);

   arvB_insere(raiz, 850);
   arvB_insere(raiz, 875);
   arvB_insere(raiz, 1200);
   arvB_insere(raiz, 1300);
   arvB_insere(raiz, 1150);

   arvB_insere(raiz, 1025);
   arvB_insere(raiz, 1050);
   arvB_insere(raiz, 1075);
   arvB_insere(raiz, 1400);
   arvB_insere(raiz, 1500);

   arvB_insere(raiz, 425);
   arvB_insere(raiz, 435);
   arvB_insere(raiz, 440);
   arvB_insere(raiz, 555);
   arvB_insere(raiz, 560);

   arvB_insere(raiz, 565);
   arvB_insere(raiz, 525);
   arvB_insere(raiz, 552);
   arvB_insere(raiz, 553);
   arvB_insere(raiz, 570);

   arvB_insere(raiz, 575);
   arvB_insere(raiz, 580);
   arvB_insere(raiz, 445);
   arvB_insere(raiz, 426);
   arvB_insere(raiz, 427);

   arvB_insere(raiz, 428);
   arvB_insere(raiz, 450);
   arvB_insere(raiz, 455);
   arvB_insere(raiz, 355);

   arvB_destroi(raiz);

   return 0;

}