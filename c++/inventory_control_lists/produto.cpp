//DEFINIÇÕES DA CLASSE PRODUTO

//bibliotecas
#include "produto.h"

//construtor padrão
produto::produto(){
	this->setNome("");
	this->setQtd(0);
	this->setMin(0);
}

//construtor com argumentos
produto::produto(string nomeProd, int qtd, int min){
	this->setNome(nomeProd);
	this->setQtd(qtd);
	this->setMin(min);
}

//destrutor padrão
produto::~produto(){
}

/*//////////////////////////////////////
-nome: setNome
-obj.: atribui uma string
	   ao nome do produto	
*///////////////////////////////////////
void produto::setNome(string nomeProd){
	this->nome = nomeProd;
}

/*//////////////////////////////////////
-nome: getNome
-obj.: retorna o nome do produto	
*///////////////////////////////////////
string produto::getNome(){
	return this->nome;
}

/*//////////////////////////////////////
-nome: setQtd
-obj.: define quantas unidades
	   do produto há no estoque
*///////////////////////////////////////
void produto::setQtd(int qtd){
	this->quantidade = qtd;
}

/*//////////////////////////////////////
-nome: getQtd
-obj.: retorna o número de unidades
	   do produto que há no estoque	
*///////////////////////////////////////
int produto::getQtd(){
	return this->quantidade;
}

/*//////////////////////////////////////
-nome: setMin
-obj.: define a quantidade mínima
	   necessária do produto no estoque
*///////////////////////////////////////
void produto::setMin(int min){
	this->minimo = min;
}

/*//////////////////////////////////////
-nome: getMin
-obj.: retorna a quantidade mínimma
	   necessária do produto no estoque	
*///////////////////////////////////////
int produto::getMin(){
	return this->minimo;
}

/*//////////////////////////////////////
-nome: imprime
-obj.: apresenta todos os dados do
	   produto (nome, quantidade em
	   estoque, quantidade mínima)	
*///////////////////////////////////////
void produto::imprime(){
	cout << "Prod: " << this->getNome() << " / Qtd: " << this->getQtd()
		 << " / Min: " << this->getMin() << endl;
}
