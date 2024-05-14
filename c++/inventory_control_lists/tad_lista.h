//DECLARAÇÕES DO TAD LISTA

#ifndef TAD_LISTA_H
#define TAD_LISTA_H

//bibliotecas
#include "node.h"
#include "produto.h"

class lista{
	public:
		lista();
		~lista();
		node* getPrimeiro();
		node* getUltimo() const;
		int getTam() const;
		bool vazia();
		bool insere(produto);
		bool retira(produto);
		node* getProximo();
		void imprime();
		bool buscar(string);
		
	private:
		node* primeiro;
		node* ultimo;
		int tamanho;
		node* elemento;
		
		void setPrimeiro(node*);
		void setUltimo(node*);
};

#endif
