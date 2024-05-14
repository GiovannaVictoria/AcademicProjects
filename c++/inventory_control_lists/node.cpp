//DEFINIÇÕES DA CLASSE NODE

//bibliotecas
#include "node.h"

//construtor padrão
node::node(){
	this->setProx(NULL);
	this->setAnt(NULL);
	this->setInfo("", 0, 0);
}

//construtor com argumentos
node::node(produto prod, node* proximo, node* anterior){
	this->setInfo(prod.getNome(), prod.getQtd(), prod.getMin());
	this->setProx(proximo);
	this->setAnt(anterior);
}

//destrutor padrão
node::~node(){
}

/*//////////////////////////////////////
-nome: setProx
-obj.: define o ponteiro
	   para o próximo nó	
*///////////////////////////////////////
void node::setProx(node* proximo){
	this->prox = proximo;
}

/*//////////////////////////////////////
-nome: getProx
-obj.: retorna um ponteiro
	   para o próximo nó
*///////////////////////////////////////
node* node::getProx() const{
	return this->prox;
}

/*//////////////////////////////////////
-nome: setAnt
-obj.: define o ponteiro
	   para o nó anterior	
*///////////////////////////////////////
void node::setAnt(node* anterior){
	this->ant = anterior;
}

/*//////////////////////////////////////
-nome: getAnt
-obj.: retorna um ponteiro
	   para o nó anterior	
*///////////////////////////////////////
node* node::getAnt() const{
	return this->ant;
}

/*//////////////////////////////////////
-nome: setInfo
-obj.: define os parâmetros do produto
	   representado pelo nó	
*///////////////////////////////////////
void node::setInfo(string nomeProd, int qtd, int min){
	this->info.setNome(nomeProd);
	this->info.setQtd(qtd);
	this->info.setMin(min);
}

/*//////////////////////////////////////
-nome: getInfo
-obj.: retorna o produto
	   representado pelo nó	
*///////////////////////////////////////
produto* node::getInfo(){
	return &this->info;
}
