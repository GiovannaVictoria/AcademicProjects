//APLICAÇÃO - CONTROLE DE ESTOQUE

//bibliotecas
#include <iostream>
#include <cstring>
#include "tad_lista.h"

using namespace std;

//protótipos
string capsLock(string);
int menu();
bool verificarValor(int, int, int);
void exibirEstoque(lista);
void cadastrarProdutos(lista*);
void removerProdutos(lista*);
void atualizarQtd(lista*);
void baixaEmEstoque(lista*);
void gerarListaCompras(lista*);

//função principal
int main()
{
	//cria a lista "estoque"
	lista estoque;
	int opcao;
	
	//seleciona a opção do menu desejada
	while ( (opcao=menu())!=7 ) {
		switch (opcao) {
	        case 1:
	            exibirEstoque(estoque);
	            break;
	        case 2:
	            cadastrarProdutos(&estoque);
	            break;
	        case 3:
	            removerProdutos(&estoque);
	            break;
	        case 4:
	            atualizarQtd(&estoque);
	            break;
	        case 5:
	            baixaEmEstoque(&estoque);
	            break;
	        case 6:
	            gerarListaCompras(&estoque);
	            break;
	    }
	}

	//finalização do programa	
	cout << "Obrigado por usar o programa!" << endl;
	return 0;
}

/*//////////////////////////////////////
-nome: capsLock
-obj.: converter todos os caracteres de
	   uma string para caixa alta	
*///////////////////////////////////////
string capsLock(string palavra)
{
	//declarações locais
	int i;
	string aux = palavra;
	
	//converte cada um dos caracteres para caixa alta
	for(i = 0; i < palavra.length(); i++)
	{
		aux[i] = toupper(palavra[i]);
	}
	
	//retorna a string toda em caixa alta;
	return aux;
}

/*//////////////////////////////////////
-nome: menu
-obj.: apresenta as opções de operações
	   do estoque e retorna aquela
	   selecionada pelo usuário	
*///////////////////////////////////////
int menu()
{
	//declarações locais
	int opcao;
	
	//apresenta o título
	cout << "CONTROLE DE ESTOQUE - MENU";
	cout << endl;
	
	//menu de opções
	cout << "1 - Exibir estoque" << endl;
	cout << "2 - Cadastrar novo produto" << endl;
	cout << "3 - Deletar produto" << endl;
	cout << "4 - Atualizar quantidade" << endl;
	cout << "5 - Dar baixa no estoque" << endl;
	cout << "6 - Gerar lista de compras" << endl;
	cout << "7 - Finalizar programa" << endl;
	
	//solicita a opção desejada pelo usuário
	cout << "\nOpcao desejada: ";
	cin >> opcao;
	
	//valida a opção informada
	while(verificarValor(opcao, 1, 7) == false)
	{
		cout << "\nOPCAO INVALIDA!" << endl;
		cout << "\nOpcao desejada: ";
		cin >> opcao;
	}
	
	cout << endl;
	
	//retorna uma opção válida
	return opcao;
}

/*//////////////////////////////////////
-nome: verificarValor
-obj.: verificar se um valor esta dentro
	   de um determinado intervalo	
*///////////////////////////////////////
bool verificarValor(int valor, int min, int max)
{
	//verfifica se o valor está dentro do intervalo informado
	if((valor >= min) && (valor <= max))
		return true;
		
	return false;
}

/*//////////////////////////////////////
-nome: exibirEstoque
-obj.: apresentar todos os itens no estoque	
*///////////////////////////////////////
void exibirEstoque(lista estoque)
{
	//verifica se o estoque está vazio
	if(estoque.vazia())
		cout << "ESTOQUE VAZIO" << endl;
	
	//imprime todos os itens caso o estoque não esteja vazio
	else
	{
		cout << "ESTOQUE (PROD./QTD./MIN.)" << endl;
		estoque.imprime();
		cout << "ITENS EM ESTOQUE: " << estoque.getTam() << endl;
	}
	cout << endl;
}

/*//////////////////////////////////////
-nome: cadastrarProdutos
-obj.: inserir itens no estoque	
*///////////////////////////////////////
void cadastrarProdutos(lista* estoque)
{
	//declarações locais
	string nome;
	int qtd;
	int qtdMin;
	bool out = false;
	
	//enquanto o usuário não finalizar a operação
	while(out == false)
	{
		//apresenta o título
		cout << "CADASTRAR NOVO PRODUTO";
		cout << endl;
		
		///apresenta o estoque
		exibirEstoque(*estoque);
		
		//solicita o nome do novo produto
		cout << "Nome do produto ('sair' para retornar ao menu): ";
		cin >> nome;
		nome = capsLock(nome);
		
		//verifica se o usuário deseja finalizar a operação
		if(strcmp(nome.c_str(), "SAIR") == 0)
			out = true;
			
		else
		{
			//solicita a quantidade do produto que será colocada no estoque
			cout << "\nQuantidade em estoque: ";
			cin >> qtd;
			
			//verifica se o valor informado é válido
			while(qtd < 0)
			{
				cout << "VALOR INVALIDO!" << endl;
				cout << "Quantidade em estoque: ";
				cin >> qtd;
			}
			
			//solicita a quantidade mínima
			cout << "\nQuantidade minima no estoque: ";
			cin >> qtdMin;
			
			//verifica se o valor informado é válido
			while(qtdMin < 0)
			{
				cout << "VALOR INVALIDO!" << endl;
				cout << "Quantidade minima em estoque: ";
				cin >> qtdMin;
			}
						
			//cria um novo produto com as informações coletadas anteriormente
			produto* aux;
			aux = new produto(nome, qtd, qtdMin);
			cout << endl;
			
			//apresenta o produto e confirma se ele será de fato inserido
			aux->imprime();
			cout << "Deseja inserir? ('s' para confirmmar): ";
			getchar();
			
			//insere o produto
			if((getchar() == 's') || (getchar() == 'S'))
			{
				cout << endl;
				estoque->insere(*aux);
				exibirEstoque(*estoque);
				cout << endl;
				delete aux;
			}
			//não insere o produto
			else
			{
				cout << "OPERACAO  CANCELADA!" << endl << endl;
				delete aux;
			}
		}
	}
	cout << endl;
}

/*//////////////////////////////////////
-nome: removerProdutos
-obj.: remover o cadastro de
	   produtos do estoque	
*///////////////////////////////////////
void removerProdutos(lista* estoque)
{
	//declarações locais
	string remove;
	bool out = false;
	
	//enquanto o usuário não finalizar a operação
	while(out == false)
	{
		//apresenta o título
		cout << "REMOVER PRODUTO";
		cout << endl;
		
		//apresenta o estoque;
		exibirEstoque(*estoque);
		
		//solicita o nome do produto que será removido
		cout << "Informe o produto a ser removido ('sair' para retornar  ao menu): ";
		cin >> remove;
		remove = capsLock(remove);
		
		//verifica se o usuário deseja finalizar a operação
		if(strcmp(remove.c_str(), "SAIR") == 0)
			out = true;
		
		else
		{
			//verifica se o produto informado existe no estoque
			while(estoque->buscar(remove) == false)
			{
				cout << "\nProduto " << remove << " nao cadastrado!" << endl;
				cout << "Informe o produto a ser removido: ";
				cin >> remove;
				remove = capsLock(remove);
			}
			
			//cria um ponteiro para o primeiro elemento do estoque
			node* gps;
			gps = estoque->getPrimeiro();
			
			//identifica em qual posição está o produto a ser removido
			while(strcmp(remove.c_str(), gps->getInfo()->getNome().c_str()) != 0)
			{
				gps = estoque->getProximo();
			}
			
			//apresenta o produto a ser removido e confirma se ele será de fato removido
			cout << endl;
			gps->getInfo()->imprime();
			cout << "Deseja remover? ('s' para confirmar): ";
			getchar();
			
			//remove o produto
			if((getchar() == 's') || (getchar() == 'S'))
			{
				estoque->retira(*gps->getInfo());
				cout << endl;
				exibirEstoque(*estoque);
			}
			
			//não remove o produto
			else
			{
				cout << "OPERACAO CANCELADA" << endl;
			}
			
			//zera e deleta o ponteiro
			gps = NULL;
			delete gps;
		}
		cout << endl;
	}
}

/*//////////////////////////////////////
-nome: atualizarQtd
-obj.: alterar as quantidades dos
	   produtos em estoque	
*///////////////////////////////////////
void atualizarQtd(lista* estoque)
{
	//declarações locais
	string nomeProduto;
	bool out = false;
	produto prodAux;
	int novaQtd;
	int novoMin;
	
	//enquanto o usuário não finalizar a operação
	while(out == false)
	{
		//apresenta o título
		cout << "ATUALIZAR QUANTIDADES";
		cout << endl;
		
		//apresenta o estoque
		estoque->imprime();
		
		//solicita o produto que será alterado
		cout << "\nInforme o produto a ser atualizado ('sair' para retornar ao menu): ";
		cin >> nomeProduto;
		nomeProduto = capsLock(nomeProduto);
		
		//verifica se o usuário deseja finalizar a operação
		if(strcmp(nomeProduto.c_str(), "SAIR") == 0)
			out = true;
		
		else
		{
			//verifica se o produto informado está no estoque
			while(estoque->buscar(nomeProduto) == false)
			{
				cout << "Produto " << nomeProduto << " nao cadastrado!" << endl;
				cout << "Informe o produto a ser atualizado: ";
				cin >> nomeProduto;
				nomeProduto = capsLock(nomeProduto);
			}
			
			//cria um ponteiro apontando para o primeiro item do estoque
			node* gps;
			gps = estoque->getPrimeiro();
			
			//identifica em qual posição está o produto que será atualizado
			while(strcmp(gps->getInfo()->getNome().c_str(), nomeProduto.c_str()) != 0)
			{
				gps = estoque->getProximo();
			}
			
			//apresenta o produto que será atualizado
			cout << endl;
			prodAux = *gps->getInfo();
			prodAux.imprime();
			
			//solicita a nova quantidade
			cout << "\nInforme a nova quantidade: ";
			cin >> novaQtd;
			
			//verifica se o valor informado é válido
			while(novaQtd < 0)
			{
				cout << "VALOR INVALIDO!" << endl;
				cout << "Informe a nova quantidade: ";
				cin >> novaQtd;
			}
			
			prodAux.setQtd(novaQtd);
			
			//solicita o novo valor mínimo
			cout << "Informe o novo valor minimo: ";
			cin >> novoMin;
			
			//verifica se o valor informado é válido
			while(novoMin < 0)
			{
				cout << "VALOR INVALIDO" << endl;
				cout << "Informe o novo valor minimo: ";
				cin >> novoMin;
			}
			
			prodAux.setMin(novoMin);
			
			//apresenta os valores originais e os valores a serem atualizados
			cout << "\nVALOR ATUAL: ";
			gps->getInfo()->imprime();
			cout << "NOVO VALOR: ";
			prodAux.imprime();
			
			//confirma se os valores serão de fato atualizados
			cout << endl << "Atualizar valores? ('s' para confirmar): ";
			getchar();
			
			//atualiza os valores
			if((getchar() == 's') || (getchar() == 'S'))
			{
				//atualiza os valores do produto no estoque
				gps->getInfo()->setMin(novoMin);
				gps->getInfo()->setQtd(novaQtd);
				
				//apresenta o produto atualizado
				cout << endl;
				gps->getInfo()->imprime();
				
				//verifica se o usuário deseja atualizar o nome do produto
				cout << "Deseja alterar o nome do produto? ('s' para atualizar)" << endl;
				cout << "Opcao desejada: ";
				//getchar();
				
				//caso o usuário deseja alterar o nome
				if((getchar() == 'S') || (getchar() == 's'))
				{
					//solicita o novo nome do produto
					string novoNome;
					cout << "\nInforme o novo nome: ";
					cin >> novoNome;
					
					novoNome = capsLock(novoNome);
					
					//verifica se já existe um produto com o mesmo nome
					while(estoque->buscar(novoNome) == true)
					{
						cout << "JA EXISTE um produto com este nome!" << endl;
						cout << "Informe o novo nome: ";
						cin >> novoNome;
						
						novoNome = capsLock(novoNome);
					}
					
					//apresenta o nome anterior e o novo nome
					cout << "\nNome atual: " << gps->getInfo()->getNome() << endl;
					cout << "Novo nome: " << novoNome << endl;
					cout << "\nConfirmar atualizacao? ('s' para atualizar): ";
					//getchar();
					
					//solicita que o usuário confirme a intenção de alterar o nome
					if((getchar() == 'S') || (getchar() == 's'))
					{
						gps->getInfo()->setNome(novoNome);
						prodAux = *gps->getInfo();
						estoque->retira(prodAux);
						estoque->insere(prodAux);
					}
					
					//não atualiza o nome						
					else
						cout << "OPERACAO CANCELADA!" << endl;
				}
			}
			
			//não atualiza os valores
			else
			{
				cout << "OPERACAO CANCELADA!" << endl;
			}
			
			//zera e deleta o ponteiro
			gps = NULL;
			delete gps;
		}
		cout << endl;
	}
	cout << endl;
}

/*//////////////////////////////////////
-nome: baixaEmEstoque
-obj.: dar baixa em produtos
	   retirados do estoque	
*///////////////////////////////////////
void baixaEmEstoque(lista* estoque)
{
	//declarações locais
	string nomeProduto;
	bool out = false;
	
	//repete o procedimento até que o usuário opte por sair
	while(out == false)
	{
		//apresenta o título
		cout << "CONSUMO DO ESTOQUE";
		cout << endl;
		
		//apresenta o estoque
		estoque->imprime();
		
		//solicita o nome do produto que terá a quantidade reduzida
		cout << "\nInforme o produto ('sair' para retornar ao menu): ";
		cin >> nomeProduto;
		
		nomeProduto = capsLock(nomeProduto);
		
		//verifica se o usuário deseja encerrar o procedimento
		if(strcmp(nomeProduto.c_str(), "SAIR") == 0)
			out = true;
		
		else
		{
			//verifica se o produto informado está cadastrado no estoque
			while(estoque->buscar(nomeProduto) == false)
			{
				cout << "PRODUTO NAO CADASTRADO!" << endl;
				cout << "Informe o produto: ";
				cin >> nomeProduto;
				
				nomeProduto = capsLock(nomeProduto);
			}
			
			//pega o primeiro elemento do estoque
			node* gps;
			gps = estoque->getPrimeiro();
			
			//localiza o endereço do produto a ser alterado
			while(strcmp(gps->getInfo()->getNome().c_str(), nomeProduto.c_str()) != 0)
			{
				gps = estoque->getProximo();
			}
			
			//verifica se o produto já está com estoque zerado
			if(gps->getInfo()->getQtd() == 0)
				cout << "Produto INDISPONIVEL!" << endl;
				
			//caso haja unidades do produto em estoque
			else
			{
				int removeQtd;
				
				//solicita quantas unidades do produto serão retiradas do estoque
				cout << "Informe a quantidade a ser retirada do estoque: ";
				cin >> removeQtd;
				
				//verifica se o valor é válido
				while(verificarValor(removeQtd, 0, gps->getInfo()->getQtd() == false))
				{
					cout << "Valor INVALIDO!" << endl;
					cout << "Informe a quantidade a ser retirada do estoque: ";
					cin >> removeQtd;
				}
				
				//o getInfo precisa retornar um ponteiro pra produto, não retornar o produto, por isso tá dando erro na hora de atualizar o valor
				
				//remove a quantidade desejada do estoque
				gps->getInfo()->setQtd(gps->getInfo()->getQtd() - removeQtd);
				
				//apresenta o produto com a quantidade atualizada
				gps->getInfo()->imprime();
			}
		}
	}
}

/*//////////////////////////////////////
-nome: gerarListaCompras
-obj.: gerar uma lista de compras dos
	   itens que estão com quantidade
	   abaixo do valor mínimo	
*///////////////////////////////////////
void gerarListaCompras(lista* estoque)
{
	//declarações locais
	node* gps;
	node* aux;
	lista compras;
	bool out = false;
	
	cout << "Gerando lista de compras..." << endl << endl;
	
	//apresenta o título
	cout << "LISTA DE COMPRAS";
	cout << endl;
	
	//atribuição de ponteiros
	gps = estoque->getPrimeiro();
	aux = estoque->getUltimo();
	
	//passa por todos os elementos da lista
	while(out == false)
	{
		//insere na lista de compras os produtos que estão abaixo da quantidade mínima
		if(gps->getInfo()->getQtd() < gps->getInfo()->getMin())
			compras.insere(*gps->getInfo());
		
		//passa para o próximo item
		gps = gps->getProx();
		
		//finaliza a varredura quando identifica que retornou ao início da lista
		if(gps->getAnt() == aux)
			out = true;
	}
	
	//apresenta a lista de compras
	if(compras.getTam() == 0)
		cout << "LISTA VAZIA" << endl;
	else
		compras.imprime();
}
