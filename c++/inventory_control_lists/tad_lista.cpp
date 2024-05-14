//DEFINI��ES DO TAD LISTA

//bibliotecas
#include "tad_lista.h"
#include "node.h"
#include <iostream>
#include <string.h>

using namespace std;

//construtor padr�o
lista::lista(){
	this->setPrimeiro(NULL);
	this->setUltimo(NULL);
	this->tamanho = 0;
	this->elemento = NULL;
}

//destrutor padr�o
lista::~lista(){
}

/*//////////////////////////////////////
-nome: setPrimeiro
-obj.: define o ponteiro para o
	   primeiro item da lista	
*///////////////////////////////////////
void lista::setPrimeiro(node* first){
	this->primeiro = first;
}

/*//////////////////////////////////////
-nome: getPrimeiro
-obj.: retorna o ponteiro para o
	   primeiro item da lista	
*///////////////////////////////////////
node* lista::getPrimeiro(){
	this->elemento = this->primeiro;
	return this->elemento;
}

/*//////////////////////////////////////
-nome: setUltimo
-obj.: define o ponteiro para o
	   �ltimo elemento da lista	
*///////////////////////////////////////
void lista::setUltimo(node* last){
	this->ultimo = last;
}

/*//////////////////////////////////////
-nome: getUltimo
-obj.: retorna o ponteiro para o
	   �ltimo elemento da lista	
*///////////////////////////////////////
node* lista::getUltimo() const{
	return this->ultimo;
}

/*//////////////////////////////////////
-nome: getTam
-obj.: retorna o n�mero de itens na lista
*///////////////////////////////////////
int lista::getTam() const{
	return this->tamanho;
}

/*//////////////////////////////////////
-nome: vazia
-obj.: verifica se a lista est� vazia	
*///////////////////////////////////////
bool lista::vazia(){
	if(this->getTam() == 0)
		return true;
		
	return false;
}

/*//////////////////////////////////////
-nome: insere
-obj.: inserir um novo elmemento na
	   lista em ordem alfab�tica	
*///////////////////////////////////////
bool lista::insere(produto Prod){
	//declara��es locais
	int caso = 0;
	int ordem;
	node* gps;
	node* novo;
	
	//verifica se a lista est� vazia
	if(this->vazia())
		caso = 1;
	else
	{
		//string auxiliar;
		//auxiliar = Prod.getNome();
		//if(this->buscar(auxiliar) == true)
		//	return false;
				
		//compara os nomes do primeiro produto e do produto a ser inserido
		ordem = strcmp(this->getPrimeiro()->getInfo()->getNome().c_str(), Prod.getNome().c_str());
		gps = this->getPrimeiro()->getProx();
		
		//se os nomes s�o iguais, n�o insere (estaria inserindo produtos repetidos)
		if(ordem == 0)
			return false;
			
		//verifica se a lista tem apenas um elemento
		else if(this->getTam() == 1)
		{
			//se o nome do produto a ser inserido vem antes do nome do primeiro produto
			if(ordem > 0)
				caso = 2;
			
			//se o nome do produto a ser inserido vem depois do nome do primeiro produto
			else if(ordem < 0)
				caso = 3;
		}
		
		//se a lista tem mais de um elemento
		else if(this->getTam() > 1)
		{
			//se o nome do produto a ser inserido vem antes do nome do primeiro produto
			if(ordem > 0)
				caso = 4;
						
			else
			{
				//compara os nomes do produto a ser inserido e do ultimo produto
				ordem = strcmp(this->getUltimo()->getInfo()->getNome().c_str(), Prod.getNome().c_str());
				
				//se os nomes forem iguais, n�o insere (estaria inserindo produtos repetidos)
				if(ordem == 0)
					return false;
				
				//se o nome do produto a ser inserido vem depois do nome do ultimo produto				
				if(ordem < 0)
					caso = 5;
									
				else
				{
					//compara os nomes do segundo produto da lista com o nome do produto a ser inserido
					ordem = strcmp(gps->getInfo()->getNome().c_str(), Prod.getNome().c_str());
					
					//se os nomes forem iguais, n�o insere (estaria inserindo produtos iguais)			
					if(ordem == 0)
						return false;
					
					//compara os nomes de cada elemento da lista at� encontrar um que deveria vir depois do nome do produto a ser inserido					
					while(ordem < 0)
					{
						gps = gps->getProx();
						ordem = strcmp(gps->getInfo()->getNome().c_str(), Prod.getNome().c_str());
						
						//se encontrar algum produto com o mesmo nome, n�o insere (estaria inserindo produtos repetidos)
						if(ordem == 0)
							return false;
					}
					
					caso = 6;
				}
			}
		}
	}
	
	//realiza a inser��o de acordo com o caso identificado anteriormente
	switch (caso)
	{
		case 1: //lista vazia
			//cout << "caso 1 ativado" << endl; //para fins de acompanhamento (remover depois)
			
			//cria um novo node
			novo = new node(Prod, novo, novo);
			
			//readequa os ponteiros para a nova situa��o
			this->setPrimeiro(novo);
			this->setUltimo(novo);
			
			//aumenta o tamanho da lista em 1 unidade
			this->tamanho++;
			break;
			
		case 2: //lista com 1 elemento (inserir no come�o)
			//cout << "caso 2 ativado" << endl; //para fins de acompanhamento (remover depois)
			
			//cria um novo node
			novo = new node(Prod, this->getPrimeiro(), this->getPrimeiro());
			
			//readequa os ponteiros para a nova situa��o
			this->getPrimeiro()->setAnt(novo);
			this->getPrimeiro()->setProx(novo);
			this->setPrimeiro(novo);
			
			//aumenta o tamanho da lista em 1 unidade
			this->tamanho++;
			break;
			
		case 3: //lista com 1 elemento (inserir no fim)
			//cout << "caso 3 ativado" << endl; //para fins de acompanhamento (remover depois)
			
			//cria um novo node
			novo = new node(Prod, this->getPrimeiro(), this->getPrimeiro());
			
			//readequa os ponteiros para a nova situa��o
			this->getPrimeiro()->setAnt(novo);
			this->getPrimeiro()->setProx(novo);
			this->setUltimo(novo);
			
			//aumenta o tamanho da lista em 1 unidade
			this->tamanho++;
			break;
			
		case 4: //lista com mais elementos (inserir no come�o)
			//cout << "caso 4 ativado" << endl; //para fins de acompanhamento (remover depois)
			
			//cria um novo node
			novo = new node(Prod, this->getPrimeiro(), this->getUltimo());
			
			//readequa os ponteiros para a nova situa��o
			this->getPrimeiro()->setAnt(novo);
			this->getUltimo()->setProx(novo);
			this->setPrimeiro(novo);
			
			//aumenta o tamanho da lista em 1 unidade
			this->tamanho++;
			break;
			
		case 5: //lista com mais elementos (inserir no fim)
			//cout << "caso 5 ativado" << endl; //para fins de acompanhamento (remover depois)
			
			//cria um novo node
			novo = new node(Prod, this->getPrimeiro(), this->getUltimo());
			
			//readequa os ponteiros para a nova situa��o
			this->getPrimeiro()->setAnt(novo);
			this->getUltimo()->setProx(novo);
			this->setUltimo(novo);
			
			//aumenta o tamanho da lista em 1 unidade
			this->tamanho++;
			break;
			
		case 6: //lista com mais elementos (inserir no meio)
			//cout << "caso 6 ativado" << endl; //para fins de acompanhamento (remover depois)
			
			//cria um novo node
			novo = new node(Prod, gps, gps->getAnt());
			
			//readequa os ponteiros para a nova situa��o
			gps->getAnt()->setProx(novo);
			gps->setAnt(novo);
			
			//aumenta o tamanho da lista em 1 unidade
			this->tamanho++;
			break;
			
		default:
			//cout << "default ativado" << endl; //para fins de acompanhamento (remover depois)
			return false;
			break;
	}
	
	//informa que o novo produto foi inserido com sucesso
	return true;
}

/*//////////////////////////////////////
-nome: getProximo
-obj.: faz o ponteiro "elemento" apontar
	   para o pr�ximo item da lista (caso
	   ele ainda n�o esteja apontando
	   para nenhum item, ser� direcionado
	   para o primeiro elemento da lista)
*///////////////////////////////////////
node* lista::getProximo(){
	if(this->elemento == NULL)
		this->getPrimeiro();
	else
		this->elemento = this->elemento->getProx();
		
	return this->elemento;
}

/*//////////////////////////////////////
-nome: imprime
-obj.: imprime os todos os itens da
	   da lista na ordem em que est�o	
*///////////////////////////////////////
void lista::imprime(){
	int i;
	
	this->getPrimeiro()->getInfo()->imprime();
	
	for(i = 1; i < this->getTam(); i++)
	{
		this->getProximo()->getInfo()->imprime();
	}
}

/*//////////////////////////////////////
-nome: buscar
-obj.: verificar a exist�ncia de um
	   elemento em uma lista	
*///////////////////////////////////////
bool lista::buscar(string palavra){
	//verifica se existem elementos para serem comparados
	if(this->vazia())
		return false;
	
	//declara��es locais
	node* aux;
	aux = this->getPrimeiro();
	int compara;
	
	compara = strcmp(aux->getInfo()->getNome().c_str(), palavra.c_str());
	
	//compara o nome de todos os produtos da lista com o nome informado
	while(compara != 0)
	{
		if(aux->getProx() == this->getPrimeiro())
			return false;
		
		aux = aux->getProx();
		
		compara = strcmp(aux->getInfo()->getNome().c_str(), palavra.c_str());
	}
	
	return true;
}

/*//////////////////////////////////////
-nome: retira
-obj.: remove um item da lista
*///////////////////////////////////////
bool lista::retira(produto Prod){
	//declara��es locais
	node* trash;
	node* gps;
	int caso;
	
	//verifica se a lista est� vazia
	if(this->vazia())
		return false;
		
	//verifica se o elemento a ser removido existe na lista
	if(this->buscar(Prod.getNome()) == false)
		return false;
	
	//verifica se lista cont�m apenas um elemento
	if(this->getTam() == 1)
		caso = 1;
		
	else
	{
		//coloca o ponteiro "gps" apontando para o primeiro item da lista
		gps = this->getPrimeiro();
		
		//procura a posi��o do elemento a ser removid
		while(strcmp(gps->getInfo()->getNome().c_str(), Prod.getNome().c_str()) != 0)
		{
			gps = this->getProximo();
		}
		
		//verifica se o elemento a ser removido � o primeiro
		if(gps == this->getPrimeiro())
			caso = 2;
			
		//verifica se o elemento a ser removido � o �ltimo
		else if(gps == this->getUltimo())
			caso = 3;
			
		//indica que o elemento a ser removido est� no meio da lista
		else
			caso = 4;
	}
	
	//realiza a remo��o de acordo com o caso identificado anteriormente
	switch (caso)
	{
		case 1: //lista com apenas um elemento
			//cout << "caso 1 (retira) ativado" << endl; //para fins de acompanhamento (remover posteriormente)
			
			//aponta qual node ser� removido
			trash = gps;
			
			//readequa os ponteiros para a nova situa��o
			this->setPrimeiro(NULL);
			this->setUltimo(NULL);
			
			//deleta o node
			delete trash;
			
			//decrementa o tamanho da lista em 1 unidade
			this->tamanho--;
			break;
			
		case 2: //lista com v�rios elementos (remover o primeiro)
			//cout << "caso 2 (retira) ativado" << endl; //para fins de acompanhamento (remover posteriormente)
			
			//aponta qual node ser� removido
			trash = gps;
			
			//readequa os ponteiros para a nova situa��o
			this->getUltimo()->setProx(this->getPrimeiro()->getProx());
			this->getPrimeiro()->getProx()->setAnt(this->getUltimo());
			this->setPrimeiro(this->getPrimeiro()->getProx());
			
			//deleta o node
			delete trash;
			
			//decrementa o tamanho da lista em 1 unidade
			this->tamanho--;
			break;
			
		case 3: //lista com v�rios elementos (remover o �ltimo)
			//cout << "caso 3 (retira) ativado" << endl; //para fins de acompanhamento (remover posteriormente)
			
			//aponta qual node ser� removido
			trash = gps;
			
			//readequa os ponteiros para a nova situa��o
			this->getPrimeiro()->setAnt(this->getUltimo()->getAnt());
			this->getUltimo()->getAnt()->setProx(this->getPrimeiro());
			this->setUltimo(this->getUltimo()->getAnt());
			
			//deleta o node
			delete trash;
			
			//decrementa o tamanho da lista em 1 unidade
			this->tamanho--;
			break;
			
		case 4: //lista com v�rios elementos (remover no meio)
			//cout << "caso 4 (retira) ativado" << endl; //para fins de acompanhamento (remover posteriormente)
			
			//aponta qual node ser� removido
			trash = gps;
			
			//readequa os ponteiros para a nova situa��o
			gps->getAnt()->setProx(gps->getProx());
			gps->getProx()->setAnt(gps->getAnt());
			
			//deleta o node
			delete trash;
			
			//decrementa o tamanho da lista em 1 unidade
			this->tamanho--;
			break;
			
		default: //caso algo tenha dado errado
			//cout << "default (retira) ativado" << endl; //para fins de acompanhamento (remover posteriormente)
			return false;
			break;
	}
	
	//informe que a remo��o foi feita com sucesso
	return true;
}
