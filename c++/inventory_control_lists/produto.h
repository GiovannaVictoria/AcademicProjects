//DECLARAÇÕES DA CLASSE PRODUTO

#ifndef PRODUTO_H
#define PRODUTO_H

//bibliotecas
#include <iostream>
#include <string.h>
using namespace std;

class produto{
	public:
		produto();
		produto(string, int, int);
		~produto();
		void setNome(string);
		string getNome();
		void setQtd(int);
		int getQtd();
		void setMin(int);
		int getMin();
		void imprime();
		
	private:
		string nome;
		int quantidade;
		int minimo;
};

#endif
