#include "ABB.h"

/*
Construtor da classe: inicializa o ponteiro para a arvore como nulo
*/
ABB::ABB() {
   setArvore(NULL);
}

/*
Destrutor da classe
*/
ABB::~ABB() {}

/*
Getter do atributo Arvore: retorna o ponteiro para a arvore
*/
NodePtr* ABB::getArvore() {
   return &(this->Arvore);
}

/*
Setter do atributo Arvore: seta o ponteiro para a arvore com o parametro "no"
*/
void ABB::setArvore(NodePtr no) {
   this->Arvore = no;
}

/*
Nome: newNode
Objetivo: alocar memoria para um novo no da arvore
Parametros: nenhum
Retorno: tipo NodePtr, ponteiro para o novo no alocado
*/
NodePtr ABB::newNode () {
   NodePtr novoNo = (NodePtr)malloc(sizeof(Node));
   return novoNo;
}

/*
Nome: deleteNode
Objetivo: desalocar memoria de um no da arvore
Parametros: no - tipo NodePtr, o no que sera desalocado - parametro por copia
Retorno: nao ha
*/
void ABB::deleteNode (NodePtr no) {
   free(no);
}

/*
Nome: estaNoEstoque
Objetivo: verificar se um determinado produto esta cadastrado no estoque
Parametros:
   - R: tipo NodePtr, ponteiro para a arvore - parametro por copia
   - X: tipo int, codigo do produto que sera procurado - parametro por copia
Retorno: tipo boolean
   - true se o produto esta cadastrado no estoque
   - false se o produto nao esta cadastrado no estoque
*/
bool ABB::estaNoEstoque (NodePtr R, int X) {
   if (vazia(R)) {
      return false;
   } else {
      if (R->Codigo==X) {
         return true;
      } else if (R->Codigo<X) {
         return estaNoEstoque(R->Dir, X);
      } else {
         return estaNoEstoque(R->Esq, X);
      }
   }
}

/*
Nome: inserirNoEstoque
Objetivo: cadastrar um novo produto no estoque, caso ele ainda nao esteja cadastrado e o estoque nao esteja cheio
Parametros:
   - R: tipo NodePtr, ponteiro para o estoque - parametro por referencia
   - nome: tipo string, nome do produto que sera cadastrado - parametro por copia
   - codigo: tipo int, codigo do produto que sera cadastrado - parametro por copia
   - qtdAtual: tipo int, quantidade atual do produto que sera cadastrado - parametro por copia
   - qtdMin: tipo int, quantidade minima do produto que sera cadastrado - parametro por copia
Retorno: tipo boolean
   - true se o produto foi cadastrado
   - false se o produto nao foi cadastrado
*/
bool ABB::cadastrarProdutos (NodePtr *R, std::string nome, int codigo, int qtdatual, int qtdminima) {
   if (vazia(*R)) {
      NodePtr novoNo = newNode();
      novoNo->Codigo = codigo;
      novoNo->Nome = nome;

      novoNo->QtdAtual = qtdatual;
      novoNo->QtdMinima = qtdminima;
      novoNo->Esq = NULL;
      novoNo->Dir = NULL;
      *R = novoNo;
      return true;
   } else {
      if ((*R)->Codigo==codigo) {
         // se o produto ja estiver cadastrado, ele nao sera cadastrado de novo
         return false;
      } else {
         if ((*R)->Codigo<codigo) {
            if ((*R)->Dir==NULL) {
               // o produto sera armazenado numa nova folha
               NodePtr novoNo = newNode();
               novoNo->Codigo = codigo;
               novoNo->Nome = nome;
               novoNo->QtdAtual = qtdatual;
               novoNo->QtdMinima = qtdminima;
               (*R)->Dir = novoNo;
               novoNo->Esq = NULL;
               novoNo->Dir = NULL;
               return true;
            } else {
               // se ainda nao encontrou a ultima folha presente, procura por ela
               return cadastrarProdutos(&(*R)->Dir, nome, codigo, qtdatual, qtdminima);
            }
         } else {
            if ((*R)->Esq==NULL) {
               // o produto sera armazenado numa nova folha
               NodePtr novoNo = newNode();
               novoNo->Codigo = codigo;
               novoNo->Nome = nome;
               novoNo->QtdAtual = qtdatual;
               novoNo->QtdMinima = qtdminima;
               (*R)->Esq = novoNo;
               novoNo->Esq = NULL;
               novoNo->Dir = NULL;
               return true;
            } else {
               // se ainda nao encontrou a ultima folha presente, procura por ela
               return cadastrarProdutos(&(*R)->Esq, nome, codigo, qtdatual, qtdminima);
            }
         }
      }
   }
}

/*
Nome: removerDoEstoque
Objetivo: descadastrar um produto do estoque, caso ele esteja cadastrado
Parametros:
   - R: tipo NodePtr, ponteiro para o estoque - parametro por referencia
   - codigo: tipo int, codigo do produto que sera removido - parametro por copia
Retorno: tipo boolean
   - true se o produto foi descadastrado
   - false se o produto nao foi descadastrado
*/
bool ABB::removerProdutos (NodePtr &R, int codigo) {
   NodePtr Aux = R;
   std::string nomeAnt;
   int codigoAnt, qtdAtualAnt, qtdMinAnt;
   if (vazia(R)) {
      return false;
   } else {
      if (R->Codigo==codigo) {
         if (R->Esq==NULL && R->Dir==NULL) {
            deleteNode(R);
            R = NULL;
         } else if (R->Esq!=NULL && R->Dir!=NULL) {
            // se o no a ser removido tem dois filhos, procura o maior na subarvore do filho da esquerda e troca de lugar
            maior(R->Esq, &nomeAnt, &codigoAnt, &qtdAtualAnt, &qtdMinAnt);
            removerProdutos(R, codigoAnt);
            R->Codigo = codigoAnt;
            R->Nome = nomeAnt;
            R->QtdAtual = qtdAtualAnt;
            R->QtdMinima = qtdMinAnt;
         } else if (R->Esq!=NULL) {
            // se o no a ser removido tem apenas o filho da esquerda, procura o maior na sua subarvore e troca de lugar
            maior(R->Esq, &nomeAnt, &codigoAnt, &qtdAtualAnt, &qtdMinAnt);
            removerProdutos(R, codigoAnt);
            R->Codigo = codigoAnt;
            R->Nome = nomeAnt;
            R->QtdAtual = qtdAtualAnt;
            R->QtdMinima = qtdMinAnt;
         } else {
            // se o no a ser removido tem apenas o filho da direita, procura o menor na sua subarvore e troca de lugar
            menor(R->Dir, &nomeAnt, &codigoAnt, &qtdAtualAnt, &qtdMinAnt);
            removerProdutos(R, codigoAnt);
            R->Codigo = codigoAnt;
            R->Nome = nomeAnt;
            R->QtdAtual = qtdAtualAnt;
            R->QtdMinima = qtdMinAnt;
         }
         return true;
      // ainda nao achou, entao continua procurando
      } else if (R->Codigo<codigo) {
         return removerProdutos(R->Dir, codigo);
      } else {
         return removerProdutos(R->Esq, codigo);
      }
   }
}

/*
Nome: atualizarQtd
Objetivo: atualizar a quantidade atual de um produto no estoque, caso ele esteja cadastrado
Parametros:
   - R: tipo NodePtr, ponteiro para o estoque - parametro por referencia
   - codigo: tipo int, codigo do produto cuja quantidade sera atualizada - parametro por copia
   - novaQtd: tipo int, nova quantidade do produto - parametro por copia
Retorno: tipo boolean
   - true se a quantidade foi atualizada
   - false se a quantidade nao foi atualizada
*/
bool ABB::atualizarQtd (NodePtr *R, int codigo, int novaQtd) {
   if (vazia(*R) || !estaNoEstoque(*R, codigo)) {
      return false;
   } else {
      if ((*R)->Codigo==codigo) {
         (*R)->QtdAtual = novaQtd;
         return true;
      } else if ((*R)->Codigo<codigo) {
         return atualizarQtd(&(*R)->Dir, codigo, novaQtd);
      } else {
         return atualizarQtd(&(*R)->Esq, codigo, novaQtd);
      }
   }
}

/*
Nome: limparEstoque
Objetivo: descadastrar todos os produtos do estoque, caso ele nao esteja vazio
Parametros:
   - R: tipo NodePtr, ponteiro para o estoque - parametro por referencia
Retorno: nao ha
*/
void ABB::limparEstoque (NodePtr *R) {
   while (!vazia(*R)) {
      if ((*R)!=NULL) {
         if ((*R)->Esq!=NULL) {
            limparEstoque(&((*R)->Esq));
         }
         if ((*R)->Dir!=NULL) {
            limparEstoque(&((*R)->Dir));
         }
         *R = NULL;
      }
   }
}

/*
Nome: listaDeCompras
Objetivo: gerar uma lista com os produtos que estao abaixo da quantidade minima e a quantidade necessaria para atingir a minima
Parametros:
   - R: tipo NodePtr, ponteiro para o estoque - parametro por copia
   - verificador: tipo boolean, indicador se a quantidade atual esta abaixo da minima - parametro por referencia
Retorno: nao ha
*/
void ABB::gerarListaCompras (NodePtr R, bool *verificador) {
   if (R!=NULL) {
      gerarListaCompras(R->Esq, verificador);
      if (R->QtdAtual<R->QtdMinima) {
         *verificador = true;
         std::cout << "Codigo: " << R->Codigo << std::endl;
         std::cout << "Nome: " << R->Nome << std::endl;
         std::cout << "Quantidade Minima: " << R->QtdMinima << std::endl;
         std::cout << "Quantidade Atual: " << R->QtdAtual << std::endl;
         std::cout << "Quantidade a ser comprada: " << R->QtdMinima-R->QtdAtual << std::endl << std::endl;
      }
      gerarListaCompras(R->Dir, verificador);
   }
}

/*
Nome: imprimeEstoque
Objetivo: imprimir uma lista com todos os produtos cadastrados no estoque, caso ele nao esteja vazio
Parametros:
   - R: tipo NodePtr, ponteiro para o estoque - parametro por copia
Retorno: nao ha
*/
void ABB::exibirEstoque (NodePtr R) {
   if (R!=NULL) {
      exibirEstoque(R->Esq);
      std::cout << "Codigo: " << R->Codigo << std::endl;
      std::cout << "Nome: " << R->Nome << std::endl;
      std::cout << "Quantidade Minima: " << R->QtdMinima << std::endl;
      std::cout << "Quantidade Atual: " << R->QtdAtual << std::endl << std::endl;
      exibirEstoque(R->Dir);
   }
}

/*
Nome: imprimeMenu
Objetivo: imprimir o menu com as funcionalidades do programa
Parametros: nao ha
Retorno: nao ha
*/
void ABB::imprimeMenu () {
   std::cout << "Menu de opcoes:" << std::endl;
   std::cout << "1: imprimir estoque" << std::endl;
   std::cout << "2: cadastrar produtos" << std::endl;
   std::cout << "3: remover produtos" << std::endl;
   std::cout << "4: atualizar quantidade no estoque" << std::endl;
   std::cout << "5: limpar estoque" << std::endl;
   std::cout << "6: gerar lista de compras" << std::endl;
   std::cout << "7: imprimir menu novamente" << std::endl;
   std::cout << "8: encerrar programa" << std::endl;
}

/*
Nome: menor
Objetivo: procurar o produto com o menor codigo no estoque, caso ele nao esteja vazio
Parametros:
   - R: tipo NodePtr, ponteiro para o estoque - parametro por copia
   - nome: tipo string, variavel que armazenara o nome do produto que tem o menor codigo - parametro por referencia
   - codigo: tipo int, variavel que armazenara o codigo do produto - parametro por referencia
   - qtdAtual: tipo int, variavel que armazenara a quantidade atual do produto que tem o menor codigo - parametro por referencia
   - qtdMin: tipo int, variavel que armazenara a quantidade minima do produto que tem o menor codigo - parametro por referencia 
Retorno: tipo boolean
   - true se o estoque nao esta vazio e, portanto, foi possivel encontrar o produto com o menor codigo
   - false se o estoque esta vazio e, portanto, nao foi possivel encontrar o produto com o menor codigo
*/
bool ABB::menor (NodePtr R, std::string *nome, int *codigo, int *qtdAtual, int *qtdMin) {
   NodePtr Aux = R;
   if (vazia(R)) {
      return false;
   } else {
      while (Aux->Dir!=NULL) {
         Aux = Aux->Dir;
      }
      *codigo = Aux->Codigo;
      *nome = Aux->Nome;
      *qtdAtual = Aux->QtdAtual;
      *qtdMin = Aux->QtdMinima;
      return true;
   }
}

/*
Nome: maior
Objetivo: procurar o produto com o maior codigo no estoque, caso ele nao esteja vazio
Parametros:
   - R: tipo NodePtr, ponteiro para o estoque - parametro por copia
   - nome: tipo string, variavel que armazenara o nome do produto que tem o maior codigo - parametro por referencia
   - codigo: tipo int, variavel que armazenara o codigo do produto - parametro por referencia
   - qtdAtual: tipo int, variavel que armazenara a quantidade atual do produto que tem o maior codigo - parametro por referencia
   - qtdMin: tipo int, variavel que armazenara a quantidade minima do produto que tem o maior codigo - parametro por referencia 
Retorno: tipo boolean
   - true se o estoque nao esta vazio e, portanto, foi possivel encontrar o produto com o maior codigo
   - false se o estoque esta vazio e, portanto, nao foi possivel encontrar o produto com o maior codigo
*/
bool ABB::maior (NodePtr R, std::string *nome, int *codigo, int *qtdAtual, int *qtdMin) {
   NodePtr Aux = R;
   if (vazia(R)) {
      return false;
   } else {
      while (Aux->Esq!=NULL) {
         Aux = Aux->Esq;
      }
      *codigo = Aux->Codigo;
      *nome = Aux->Nome;
      *qtdAtual = Aux->QtdAtual;
      *qtdMin = Aux->QtdMinima;
      return true;
   }
}

/*
Nome: vazia
Objetivo: verificar se o estoque esta vazio ou nao
Parametros:
   - R: tipo NodePtr, ponteiro para o estoque - parametro por copia
Retorno: tipo boolean
   - true se o estoque esta vazio
   - false se o estoque nao esta vazio
*/
bool ABB::vazia (NodePtr R) {
   if (R==NULL) {
      return true;
   } else {
      return false;
   }
}

/*
Nome: escolheOperacao
Objetivo: receber o numero da opcao - referente a alguma funcionalidade - escolhida pelo usuario, imprimir as mensagens adequadas na tela e chamar as funcoes conforme necessario 
Parametros:
   - R: tipo NodePtr, ponteiro para o estoque - parametro por referencia
   - opcao: tipo int, opcao escolhida pelo usuario - parametro por copia
Retorno: nao ha
*/
void ABB::escolheOperacao (NodePtr *R, int opcao) {
   bool sucesso, *verificador;
   char confirmacao;
   std::string nome;
   int codigo, qtdatual, qtdminima;
   switch(opcao) {
      case 1:
         if (vazia(*R)) {
            std::cout << "Estoque vazio" << std::endl;
         } else {
            std::cout << "Produtos cadastrados:" << std::endl << std::endl;
            exibirEstoque(*R);
         }
         break;
      case 2:
         std::cout << "Digite o codigo do produto a ser cadastrado: ";
         std::cin >> codigo;
         std::cout << "Digite o nome do produto a ser cadastrado: ";
         std::cin >> nome;
         std::cout << "Digite a quantidade minima do produto a ser cadastrado: ";
         std::cin >> qtdminima;
         while (qtdminima<0) {
            std::cout << "Quantidade invalida. Informe uma quantidade valida: ";
            std::cin >> qtdminima;
         }
         std::cout << "Digite a quantidade atual do produto a ser cadastrado: ";
         std::cin >> qtdatual;
         while (qtdatual<0) {
            std::cout << "Quantidade invalida. Informe uma quantidade valida: ";
            std::cin >> qtdatual;
         }
         sucesso = cadastrarProdutos(R, nome, codigo, qtdatual, qtdminima);
         if (sucesso) {
            std::cout << "Produto cadastrado com sucesso" << std::endl;
         } else {
            std::cout << "Produto ja cadastrado, nao foram feitas alteracoes no estoque" << std::endl;
         }
         break;
      case 3:
         std::cout << "Digite o codigo do produto a ser removido: ";
         std::cin >> codigo;
         sucesso = removerProdutos(*R, codigo);
         if (sucesso) {
            std::cout << "Produto removido com sucesso" << std::endl;
         } else {
            std::cout << "Produto nao encontrado, nao foram feitas alteracoes no estoque" << std::endl;
         }
         break;
      case 4:
         std::cout << "Digite o codigo do produto que tera a quantidade atualizada: ";
         std::cin >> codigo;
         std::cout << "Digite a nova quantidade atual do produto: ";
         std::cin >> qtdatual;
         while (qtdatual<0) {
            std::cout << "Quantidade invalida. Informe uma quantidade valida: ";
            std::cin >> qtdatual;
         }
         sucesso = atualizarQtd(R, codigo, qtdatual);
         if (sucesso) {
            std::cout << "Atualizacao realizada com sucesso" << std::endl;
         } else {
            std::cout << "Produto nao cadastrado, nao foram feitas alteracoes no estoque" << std::endl;
         }
         break;
      case 5:
         std::cout << "O estoque sera completamente limpo. Para confirmar, tecle 's': ";
         std::cin >> confirmacao;
         if (confirmacao=='s' || confirmacao=='S') {
            limparEstoque(R);
            std::cout << "Estoque limpo com sucesso" << std::endl;
         } else {
            std::cout << "Operacao cancelada" << std::endl;
         }
         break;
      case 6:
         *verificador = false;
         std::cout << "Lista de produtos a serem comprados:" << std::endl;
         gerarListaCompras(*R, verificador);
         if (!verificador) {
            std::cout << "Nao ha produtos a serem comprados" << std::endl;
         }
         break;
      case 7:
         imprimeMenu();
         break;
      case 8:
         std::cout << "Obrigado por utilizar o programa!" << std::endl;
         break;
      default:
         std::cout << "Opcao invalida!" << std::endl;
   }
}