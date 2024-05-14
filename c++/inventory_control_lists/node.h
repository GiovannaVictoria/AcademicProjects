//DECLARAÇÕES DA CLASSE NODE

#ifndef NODE_H
#define NODE_H

//bibliotecas
#include "produto.h"

class node{
	public:
		node();
		node(produto, node*, node*);
		~node();
		node* getProx() const;
		node* getAnt() const;
		void setInfo(string, int, int);
		produto* getInfo();
		void setAnt(node*);
		void setProx(node*);
		
	private:
		produto info;
		node* prox;
		node* ant;
};

#endif
