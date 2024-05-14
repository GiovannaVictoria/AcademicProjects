#ifndef ABB_H
#define ABB_H

#include <cstring>
#include <iostream>

typedef struct Node {
   std::string Nome;
   int Codigo, QtdAtual, QtdMinima;
   struct Node *Esq, *Dir;
} Node;

typedef struct Node *NodePtr;

class ABB {
   private:
      NodePtr Arvore;
   public:
      ABB();
      virtual ~ABB();
      NodePtr* getArvore();
      void setArvore(NodePtr no);
      NodePtr newNode ();
      void deleteNode (NodePtr);
      bool estaNoEstoque (NodePtr, int);
      bool cadastrarProdutos (NodePtr*, std::string, int, int, int);
      bool removerProdutos (NodePtr&, int);
      bool atualizarQtd (NodePtr*, int, int);
      void limparEstoque (NodePtr*);
      void gerarListaCompras (NodePtr, bool*);
      void exibirEstoque (NodePtr);
      void imprimeMenu ();
      bool menor (NodePtr, std::string*, int*, int*, int*);
      bool maior (NodePtr, std::string*, int*, int*, int*);
      bool vazia (NodePtr);
      void escolheOperacao(NodePtr*, int);
};

#endif /* ABB_H */