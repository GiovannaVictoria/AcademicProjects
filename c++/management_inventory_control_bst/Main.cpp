#include "ABB.h"

int main () {
   int opcao;
   ABB *estoque = new ABB();
   std::cout << "Bem-vindo ao programa de controle de estoque" << std::endl;
   estoque->imprimeMenu();
   do {
      std::cout << "Digite o numero da opcao desejada: ";
      std::cin >> opcao;
      estoque->escolheOperacao(estoque->getArvore(), opcao);
      std::cout << std::endl;
   } while (opcao!=8);
   delete estoque;
   return 0;
}