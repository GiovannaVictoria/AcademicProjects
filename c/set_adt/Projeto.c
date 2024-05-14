/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\
*                                                                                                                                                   *
* Grupo 15:                                                                                                                                         *
* Adriano Tavares Santos Araújo de Castro - 811389                                                                                                  *
* Anna Carolina Brito Santos Farias - 811448                                                                                                        *
* Giovanna Victoria Rossetto - 791648                                                                                                               *
*                                                                                                                                                   *
* Objetivo: usando TAD, implementar as seguintes funcionalidades de manipulacao de conjuntos:                                                       *
*           - criar um conjunto vazio                                                                                                               *
*           - inserir um conjunto completo                                                                                                          *
*           - remover um conjunto completo                                                                                                          *
*           - imprimir todos os elementos de um conjunto                                                                                            *
*           - imprimir todos os elementos de um conjunto em ordem aleatoria                                                                         *
*           - imprimir todos os conjuntos atuais do programa                                                                                        *
*           - verificar se um conjunto é vazio                                                                                                      *
*           - verificar se um conjunto está no tamanho máximo suportado pelo programa                                                               *
*           - verificar o tamanho de um conjunto                                                                                                    *
*           - verificar se um conjunto contem um elemento especifico                                                                                *
*           - obter o conjunto resultante da diferenca de dois conjuntos                                                                            *
*           - obter o conjunto resultante da interseccao de dois conjuntos                                                                          *
*           - obter o conjunto resultante da uniao de dois conjuntos                                                                                *
*           - verificar se dois conjuntos sao iguais                                                                                                *
*           - verificar se um conjunto é subconjunto de outro conjunto                                                                              *
*           - inserir um elemento em um conjunto                                                                                                    *
*           - pegar um elemento aleatorio de um conjunto                                                                                            *
*           - obter o elemento de valor mais proximo de um dado valor de referencia                                                                 *
*           - remover um elemento de um conjunto                                                                                                    *
*           - remover todos os elementos de um conjunto                                                                                             *
*           - obter o elemento de menor valor de um conjunto.                                                                                       *
*           - obter o elemento de maior valor de um conjunto.                                                                                       *
*           - obter o valor da soma de todos os elementos de um conjunto.                                                                           *
*           - imprimir o menu                                                                                                                       *
*                                                                                                                                                   *
* Data de criacao: 27/08/2022                                                                                                                       *
* Data da ultima alteracao: 25/09/2022                                                                                                              *
*                                                                                                                                                   *
\* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define tam_max_elementos 1000  // tamanho maximo de elementos em um conjunto
#define tam_max_conjuntos 1000  // quantidade maxima de conjuntos para o vetor de conjuntos

typedef struct {
    int tamanho;
    int vetor[tam_max_elementos];
} tConjunto;

void ajuda (int);
int comparador(const void *, const void *);
int conjuntoMaximo (tConjunto);
int conjuntosIguais (tConjunto, tConjunto);
int conjuntoVazio (tConjunto);
void criarVazio (tConjunto *, int *);
tConjunto diferencaConjuntos (tConjunto, tConjunto);
int elementoMaximo (tConjunto);
int elementoMinimo (tConjunto);
void escolheOperacao (tConjunto *, int, int *);
void escreveConjunto (tConjunto);
int existeElemento (tConjunto, int);
void imprimeMenu (void);
int insereElemento (tConjunto *, int);
void insereConjunto (tConjunto *, tConjunto, int *);
void removeConjunto (tConjunto *, int, int *);
tConjunto interseccaoConjuntos (tConjunto, tConjunto);
int lerConjunto (tConjunto *, int *);
void limpaConjunto (tConjunto *);
tConjunto listaEnumerada (tConjunto);
int maisProximo (tConjunto, int);
int pegaElemento (tConjunto);
int removeElemento (tConjunto *, int);
unsigned long long somaElementos (tConjunto);
int subConjunto (tConjunto, tConjunto);
int tamanhoConjunto (tConjunto);
tConjunto uniaoConjuntos (tConjunto, tConjunto);

int main () {

    tConjunto conjuntos[tam_max_conjuntos];
    int operacao, qtd;  // operacao: armazena a operacao escolhida pelo usuario a partir do menu; qtd: armazena a quantidade atual de conjuntos alocados no vetor de conjuntos

    // inicialmente, imprime o menu para o usuario
    qtd = 0;
    printf("Bem-vindo! Este programa trabalha com conjuntos de numeros inteiros, e possui as seguintes funcionalidades:\n");
    imprimeMenu();

    // deixa o usuario escolher quantas operacoes quiser, ate que a operacao 18 (encerrar o programa) seja escolhida;
    do {
        printf("Digite o numero correspondente à operacao desejada (numero atual de conjuntos: %d): ", qtd);
        scanf("%d", &operacao);
        escolheOperacao(conjuntos, operacao, &qtd);  // administra o andamento de cada operacao
    } while (operacao!=25);

    return 0;

}

/*
Nome: ajuda
Objetivo: imprimir informacoes uteis sobre uma operacao especifica a pedido do usuario
Parametros formais:
    - operacao: numero da operacao sobre a qual o usuario quer informacoes
Valor de retorno: nao ha
*/
void ajuda (int operacao) {

    switch (operacao) {
        case 1:
            printf("O programa verifica se ha espaco para armazenar mais um conjunto.\n");
            printf("Se houver, é criado um conjunto vazio e inserido no programa.\n");
            printf("Se nao houver espaco suficiente, o programa informara e nao criara o conjunto vazio.\n");
            break;
        case 2:
            printf("O usuario deve inserir um conjunto completo a partir do teclado, ou seja: ");
            printf("inserir o tamanho (n) do conjunto e, depois, os n elementos que farao parte do conjunto.\n");
            printf("O programa verificara se é possivel adicionar o conjunto ao programa, ou seja: ");
            printf("se o programa esta no numero maximo de conjuntos inseridos (%d), ou se o tamanho escolhido é maior do que o maximo suportado pelo programa (%d).\n", tam_max_conjuntos, tam_max_elementos);
            printf("Apos isso, o programa informara se foi possivel fazer a insercao, e o motivo caso nao tenha sido.\n");
            printf("IMPORTANTE! O programa adiciona os conjuntos na ordem em que o usuario digita.\n");
            printf("Caso haja alguma duvida quanto ao numero de cada conjunto, a operacao #4 imprime todos os conjuntos atuais inseridos no programa e seus respectivos indices.\n");
            break;
        case 3:
            printf("O usuario deve escolher o numero do conjunto a ser removido, ou seja: ");
            printf("o indice referente à ordem de insercao de conjuntos feita pelo usuario.\n");
            printf("O programa verificara se é possivel remover o conjunto do programa, ou seja: ");
            printf("se o conjunto realmente esta inserido no programa.\n");
            printf("Apos isso, o programa informara se foi possivel fazer a remocao, e o motivo caso nao tenha sido.\n");
            printf("IMPORTANTE! Apos uma remocao, os programas que estao à frente do removido (os numeros posteriores) terao seus indices diminuidos em 1.\n");
            printf("Caso haja alguma duvida quanto ao numero de cada conjunto, a operacao #4 imprime todos os conjuntos atuais inseridos no programa e seus respectivos indices.\n");
            break;
        case 4:
            printf("O usuario deve escolher um conjunto para ser impresso, ou seja: \n");
            printf("escolher o numero referente ao indice do conjunto (a ordem em que foram inseridos no programa).\n");
            printf("O programa verificara se é possivel imprimir o conjunto, ou seja: ");
            printf("se o numero escolhido é um indice valido. Caso nao seja, o usuario deve digitar um numero valido.\n");
            printf("Em seguida, o programa imprimira o tamanho do conjunto, todos os seus elementos e seu indice.\n");
            printf("Caso haja alguma duvida quanto ao numero de cada conjunto, a operacao #4 imprime todos os conjuntos atuais inseridos no programa e seus respectivos indices.\n");
            break;
        case 5:
            printf("O usuario deve escolher um conjunto para ter seus elementos impressos em ordem aleatoria, ou seja: \n");
            printf("escolher o numero referente ao indice do conjunto (a ordem em que foram inseridos no programa).\n");
            printf("O programa verificara se é possivel imprimir os elementos, ou seja: ");
            printf("se o numero escolhido é um indice valido. Caso nao seja, o usuario deve digitar um numero valido.\n");
            printf("Em seguida, o programa imprimira todos os elementos do conjunto em ordem aleatoria.\n");
            printf("Caso haja alguma duvida quanto ao numero de cada conjunto, a operacao #4 imprime todos os conjuntos atuais inseridos no programa e seus respectivos indices.\n");
            break;
        case 6:
            printf("O programa vai imprimir todos os conjuntos atuais inseridos no programa (se houver), e seus respectivos indices (respeitando a diminuicao em 1 nos casos de remocao).\n");
            printf("Se nao houver conjuntos inseridos no programa, ele informara.\n");
            break;
        case 7:
            printf("O usuario deve escolher um conjunto para ser verificado se esta vazio ou nao, ou seja: ");
            printf("escolher o numero referente ao indice do conjunto (a ordem em que foram inseridos no programa).\n");
            printf("O programa verificara se o numero escolhido é um indice valido. Caso nao seja, o usuario deve digitar um numero valido.\n");
            printf("Em seguida, o programa informara se o conjunto escolhido esta vazio ou nao.\n");
            printf("Caso o conjunto nao esteja vazio, sera oferecida ao usuario a possibilidade de ver o conjunto impresso.\n");
            printf("Caso haja alguma duvida quanto ao numero de cada conjunto, a operacao #4 imprime todos os conjuntos atuais inseridos no programa e seus respectivos indices.\n");
            break;
        case 8:
            printf("O usuario deve escolher um conjunto para ser verificado se esta no tamanho maximo suportado pelo programa (%d), ou seja: ", tam_max_elementos);
            printf("escolher o numero referente ao indice do conjunto (a ordem em que foram inseridos no programa).\n");
            printf("O programa verificara se o numero escolhido é um indice valido. Caso nao seja, o usuario deve digitar um numero valido.\n");
            printf("Em seguida, o programa informara se o conjunto escolhido esta no tamanho maximo suportado pelo programa ou nao.\n");
            printf("Apos isso, sera oferecida ao usuario a possibilidade de ver o conjunto impresso.\n");
            printf("Caso haja alguma duvida quanto ao numero de cada conjunto, a operacao #4 imprime todos os conjuntos atuais inseridos no programa e seus respectivos indices.\n");
            break;
        case 9:
            printf("O usuario deve escolher um conjunto para ser verificado o seu tamanho, ou seja: ");
            printf("escolher o numero referente ao indice do conjunto (a ordem em que foram inseridos no programa).\n");
            printf("O programa verificara se o numero escolhido é um indice valido. Caso nao seja, o usuario deve digitar um numero valido.\n");
            printf("Em seguida, o programa informara o tamanho do conjunto. Apos isso, sera oferecida ao usuario a possibilidade de ver o conjunto impresso.\n");
            printf("Caso haja alguma duvida quanto ao numero de cada conjunto, a operacao #4 imprime todos os conjuntos atuais inseridos no programa e seus respectivos indices.\n");
            break;
        case 10:
            printf("O usuario deve escolher um elemento x e um conjunto A para verificar se x pertence a A, ou seja: ");
            printf("inserir o numero do conjunto escolhido e, depois, o elemento escolhido.\n");
            printf("O programa verificara se o numero escolhido para o conjunto é um indice valido. Caso nao seja, o usuario deve digitar um numero valido.\n");
            printf("Em seguida, o programa informara se o elemento esta contido no conjunto escolhido ou nao. Caso esteja, sera informada a posicao do elemento no conjunto.\n");
            printf("Apos isso, sera oferecida ao usuario a possibilidade de ver o conjunto impresso.\n");
            printf("Caso haja alguma duvida quanto ao numero de cada conjunto, a operacao #4 imprime todos os conjuntos atuais inseridos no programa e seus respectivos indices.\n");
            break;
        case 11:
            printf("O usuario deve escolher dois conjuntos, A e B, para obter um novo conjunto resultante da diferenca entre eles;\n");
            printf("A diferenca entre dois conjuntos A - B é dada pelos elementos que estao contidos em A e nao estao contidos em B.\n");
            printf("Portanto, o usuario deve escolher os numeros dos dois conjuntos escolhidos para A e B, nessa ordem.\n");
            printf("O programa verificara se ha, pelo menos, 2 conjuntos inseridos no programa. Caso nao haja, ele informara.\n");
            printf("Ademais, o programa verificara se os numero escolhidos para os conjuntos sao indices validos. Caso nao sejam, o usuario deve digitar numeros validos.\n");
            printf("Em seguida, o programa imprimira os dois conjuntos escolhidos e o conjunto resultante.\n");
            printf("Apos isso, sera oferecida ao usuario a possibilidade de inserir o conjunto no programa.\n");
            printf("Caso haja alguma duvida quanto ao numero de cada conjunto, a operacao #4 imprime todos os conjuntos atuais inseridos no programa e seus respectivos indices.\n");
            break;
        case 12:
            printf("O usuario deve escolher dois conjuntos, A e B, para obter um novo conjunto resultante da interseccao entre eles;\n");
            printf("A interseccao entre dois conjuntos A e B é dada pelos elementos que estao contidos em A e em B ao mesmo tempo.\n");
            printf("Portanto, o usuario deve escolher os numeros dos dois conjuntos escolhidos para A e B, nessa ordem.\n");
            printf("O programa verificara se ha, pelo menos, 2 conjuntos inseridos no programa. Caso nao haja, ele informara.\n");
            printf("Ademais, o programa verificara se os numero escolhidos para os conjuntos sao indices validos. Caso nao sejam, o usuario deve digitar numeros validos.\n");
            printf("Em seguida, o programa imprimira os dois conjuntos escolhidos e o conjunto resultante.\n");
            printf("Apos isso, sera oferecida ao usuario a possibilidade de inserir o conjunto no programa.\n");
            printf("Caso haja alguma duvida quanto ao numero de cada conjunto, a operacao #4 imprime todos os conjuntos atuais inseridos no programa e seus respectivos indices.\n");
            break;
        case 13:
            printf("O usuario deve escolher dois conjuntos, A e B, para obter um novo conjunto resultante da uniao entre eles;\n");
            printf("A uniao entre dois conjuntos A e B é dada pelos elementos que estao contidos em A ou em B.\n");
            printf("Portanto, o usuario deve escolher os numeros dos dois conjuntos escolhidos para A e B, nessa ordem.\n");
            printf("O programa verificara se ha, pelo menos, 2 conjuntos inseridos no programa. Caso nao haja, ele informara.\n");
            printf("Ademais, o programa verificara se os numero escolhidos para os conjuntos sao indices validos. Caso nao sejam, o usuario deve digitar numeros validos.\n");
            printf("Em seguida, o programa imprimira os dois conjuntos escolhidos e o conjunto resultante.\n");
            printf("Apos isso, sera oferecida ao usuario a possibilidade de inserir o conjunto no programa.\n");
            printf("Caso haja alguma duvida quanto ao numero de cada conjunto, a operacao #4 imprime todos os conjuntos atuais inseridos no programa e seus respectivos indices.\n");
            break;
        case 14:
            printf("O usuario deve escolher dois conjuntos, A e B, para verificar se eles sao iguais;\n");
            printf("Dois conjuntos A - B sao iguais se, e somente se, todos os elementos de A estao contidos em B, e vice-versa.\n");
            printf("Portanto, o usuario deve escolher os numeros dos dois conjuntos escolhidos para A e B, nessa ordem.\n");
            printf("O programa verificara se ha, pelo menos, 2 conjuntos inseridos no programa. Caso nao haja, ele informara.\n");
            printf("Ademais, o programa verificara se os numero escolhidos para os conjuntos sao indices validos. Caso nao sejam, o usuario deve digitar numeros validos.\n");
            printf("Em seguida, o programa imprimira os dois conjuntos escolhidos e informara se eles sao iguais ou nao.\n");
            printf("Apos isso, sera oferecida ao usuario a possibilidade de inserir o conjunto no programa.\n");
            printf("Caso haja alguma duvida quanto ao numero de cada conjunto, a operacao #4 imprime todos os conjuntos atuais inseridos no programa e seus respectivos indices.\n");
            break;
        case 15:
            printf("O usuario deve escolher dois conjuntos, A e B, para verificar se A é um subconjunto de B;\n");
            printf("Um conjunto A é um subconjunto de B se, e somente se, todos os elementos de A estao contidos em B.\n");
            printf("Portanto, o usuario deve escolher os numeros dos dois conjuntos escolhidos para A e B, nessa ordem.\n");
            printf("O programa verificara se ha, pelo menos, 2 conjuntos inseridos no programa. Caso nao haja, ele informara.\n");
            printf("Ademais, o programa verificara se os numero escolhidos para os conjuntos sao indices validos. Caso nao sejam, o usuario deve digitar numeros validos.\n");
            printf("Em seguida, o programa imprimira os dois conjuntos escolhidos e informara se A é um subconjunto de B ou nao.\n");
            printf("Caso haja alguma duvida quanto ao numero de cada conjunto, a operacao #4 imprime todos os conjuntos atuais inseridos no programa e seus respectivos indices.\n");
            break;
        case 16:
            printf("O usuario deve escolher um elemento e um conjunto para o elemento ser inserido no conjunto, ou seja: ");
            printf("escolher o numero do conjunto e, depois, o elemento que sera inserido.\n");
            printf("O programa verificara se o numero escolhido é um indice valido. Caso nao seja, o usuario deve digitar um numero valido.\n");
            printf("Ademais, o programa verificara se é possivel inserir o elemento no conjunto, ou seja: ");
            printf("se o conjunto esta com o numero maximo de elementos (%d), ou se o conjunto ja contem o elemento escolhido.\n", tam_max_elementos);
            printf("Em seguida, o programa informara se foi possivel fazer a insercao, e o motivo caso nao tenha sido.\n");
            printf("Apos isso, sera oferecida ao usuario a possibilidade de ver o conjunto impresso.\n");
            printf("Caso haja alguma duvida quanto ao numero de cada conjunto, a operacao #4 imprime todos os conjuntos atuais inseridos no programa e seus respectivos indices.\n");
            break;
        case 17:
            printf("O usuario deve escolher um conjunto para ser pegado um elemento aleatorio, ou seja: ");
            printf("escolher o numero do conjunto.\n");
            printf("O programa verificara se o numero escolhido é um indice valido. Caso nao seja, o usuario deve digitar um numero valido.\n");
            printf("Ademais, o programa verificara se é possivel pegar um elemento do conjunto, ou seja: se o conjunto esta vazio.\n");
            printf("Em seguida, o programa informara se foi possivel fazer a remocao, e o motivo caso nao tenha sido.\n");
            printf("Apos isso, o programa imprimira o elemento escolhido.\n");
            printf("Caso haja alguma duvida quanto ao numero de cada conjunto, a operacao #4 imprime todos os conjuntos atuais inseridos no programa e seus respectivos indices.\n");
            break;
        case 18:
            printf("O usuario deve escolher um conjunto e um valor inteiro para ser procurado o elemento de valor mais proximo a esse valor, ou seja: ");
            printf("escolher o numero do conjunto e, depois, o valor que sera usado como referencia na busca.\n");
            printf("O programa verificara se o numero escolhido para o conjunto é um indice valido. Caso nao seja, o usuario deve digitar um numero valido.\n");
            printf("Ademais, o programa verificara se é possivel buscar elementos no conjunto, ou seja: se o conjunto esta vazio.\n");
            printf("Se estiver, o programa informara. Senao, o programa imprimira o elemento de valor mais proximo ao valor escolhido como referencia, e sua posicao no conjunto.\n");
            printf("Caso haja alguma duvida quanto ao numero de cada conjunto, a operacao #4 imprime todos os conjuntos atuais inseridos no programa e seus respectivos indices.\n");
            break;
        case 19:
            printf("O usuario deve escolher um elemento e um conjunto para o elemento ser removido do conjunto, ou seja: ");
            printf("escolher o numero do conjunto e, depois, o elemento que sera removido.\n");
            printf("O programa verificara se o numero escolhido é um indice valido. Caso nao seja, o usuario deve digitar um numero valido.\n");
            printf("Ademais, o programa verificara se é possivel remover o elemento do conjunto, ou seja: ");
            printf("se o conjunto esta vazio, ou se o conjunto nao contem o elemento escolhido.\n");
            printf("Em seguida, o programa informara se foi possivel fazer a remocao, e o motivo caso nao tenha sido.\n");
            printf("Apos isso, sera oferecida ao usuario a possibilidade de ver o conjunto impresso.\n");
            printf("Caso haja alguma duvida quanto ao numero de cada conjunto, a operacao #4 imprime todos os conjuntos atuais inseridos no programa e seus respectivos indices.\n");
            break;
        case 20:
            printf("O usuario deve escolher um conjunto para serem removidos todos os seus elementos, ou seja: escolher o numero do conjunto.\n");
            printf("O programa verificara se o numero escolhido é um indice valido. Caso nao seja, o usuario deve digitar um numero valido.\n");
            printf("O programa verificara se o conjunto esta vazio.\n");
            printf("Se estiver, o programa informara. Senao, serao removidos todos os elementos do conjunto escolhido.\n");
            printf("Caso haja alguma duvida quanto ao numero de cada conjunto, a operacao #4 imprime todos os conjuntos atuais inseridos no programa e seus respectivos indices.\n");
            break;
        case 21:
            printf("O usuario deve escolher um conjunto para ser procurado seu menor valor, ou seja: escolher o numero do conjunto.\n");
            printf("O programa verificara se o numero escolhido é um indice valido. Caso nao seja, o usuario deve digitar um numero valido.\n");
            printf("O programa verificara se o conjunto esta vazio ou nao.\n");
            printf("Se estiver, o programa informara. Senao, sera informado o elemento de menor valor do conjunto escolhido.\n");
            break;
        case 22:
            printf("O usuario deve escolher um conjunto para ser procurado seu maior valor, ou seja: escolher o numero do conjunto");
            printf("O programa verificara se o numero escolhido é um indice valido. Caso nao seja, o usuario deve digitar um numero valido.\n");
            printf("O programa verificara se o conjunto esta vazio ou nao.\n");
            printf("Se estiver, o programa informara. Senao, sera informado o elemento de maior valor do conjunto escolhido.\n");
            break;
        case 23:
            printf("O usuario deve escolher um conjunto para se obter a soma de seus elementos, ou seja: escolher o numero do conjunto.\n");
            printf("O programa verificara se o numero escolhido é um indice valido. Caso nao seja, o usuario deve digitar um numero valido.\n");
            printf("O programa verificara se o conjunto esta vazio ou nao.\n");
            printf("Se estiver, o programa informara. Senao, sera informado o valor da soma de todos os elementos do conjunto escolhido.\n");
            break;
        case 24:
            printf("O programa imprime o menu novamente para o usuario.\n");
            break;
        case 25:
            printf("O programa encerra a sua execucao.\n");
            break;
        default:
            printf("Numero invalido. Digite um numero valido.\n");
    }

}

/*
Nome: comparador
Objetivo: comparar dois valores genericos para auxiliar a funcao qsort a ordenar uma lista de elementos
Parametros formais:
    - a: valor de tipo generico a ser usado na comparacao - parametro de entrada e saida de dados
    - b: valor de tipo generico a ser usado na comparacao - parametro de entrada e saida de dados
Valor de retorno: inteiro referente aos valores comparados
    - inteiro maior que zero, se a > b
    - inteiro menor que zero, se a < b
    - zero, se a = b
*/
int comparador (const void *a, const void *b) {

    return ( *(int*)a - *(int*)b );

}

/*
Nome: conjuntoMaximo
Objetivo: verificar se um dado conjunto esta com o tamanho maximo suportado pelo programa
Parametros formais:
    - conjunto: conjunto cujo tamanho sera verificado - parametro de entrada de dados
Valor de retorno: inteiro referente ao resultado da verificacao
    - 1, se o tamanho estiver no maximo
    - 0, se o tamanho nao estiver no maximo
*/
int conjuntoMaximo (tConjunto conjunto) {

    int maximo;

    // verifica se o tamanho do dado conjunto esta no maximo
    if (conjunto.tamanho==tam_max_elementos) {
        maximo = 1;
    } else {
        maximo = 0;
    }

    return maximo;

}

/*
Nome: conjuntosIguais
Objetivo: comparar dois dois conjuntos e verificar se eles sao iguais (A = B ?)
Parametros formais:
    - conjunto1: conjunto escolhido como A - parametro de entrada de dados
    - conjunto1: conjunto escolhido como B - parametro de entrada de dados
Valor de retorno: inteiro referente ao resultado da verificacao
    - 1, se os dois conjuntos forem iguais
    - 0, se os dois conjuntos forem diferentes
*/
int conjuntosIguais (tConjunto conjunto1, tConjunto conjunto2) {

    int iguais;

    iguais = 1;
    // se os tamanhos dos conjuntos forem diferentes, é impossivel eles serem iguais (dadas as condices restritas de manipulacao de conjuntos adotadas no programa)
    if (conjunto1.tamanho!=conjunto2.tamanho) {
        iguais = 0;
    } else {
        // se os tamanhos forem iguais, confere se todos os elementos sao iguais (partindo da condicao de que todos os conjuntos estao sempre ordenados, como foi implementado)
        for (int i=0; i<conjunto1.tamanho; i++) {
            if (conjunto1.vetor[i]!=conjunto2.vetor[i]) {
                iguais = 0;
                break;
            }
        }
    }

    return iguais;

}

/*
Nome: conjuntoVazio
Objetivo: verificar se um dado conjunto é vazio
Parametros formais:
    - conjunto: conjunto cujo tamanho sera verificado - parametro de entrada de dados
Valor de retorno: inteiro referente ao resultado da verificacao
    - 1, se o conjunto esta vazio
    - 0, se o conjunto nao esta vazio
*/
int conjuntoVazio (tConjunto conjunto) {

    int vazio;

    // verifica se o conjunto esta vazio, ou seja, se o tamanho é zero
    if (conjunto.tamanho==0) {
        vazio = 1;
    } else {
        vazio = 0;
    }

    return vazio;

}

/*
Nome: criarVazio
Objetivo: criar um conjunto vazio
Parametros formais:
    - conjuntos: vetor de conjuntos que armazena os conjuntos inseridos no programa - parametro de entrada de dados
    - qtd: inteiro que informa a quantidade de conjuntos atualmente inseridos no programa
Valor de retorno: nao ha
*/
void criarVazio (tConjunto conjuntos[], int *qtd) {

    // tamanho do conjunto vazio: 0
    conjuntos[*qtd].tamanho = 0;

    // finaliza o vetor de elementos com \0
    conjuntos[*qtd].vetor[conjuntos[*qtd].tamanho] = '\0';
    
    // atualiza a quantidade de conjuntos inseridos no programa
    *qtd = *qtd+1;

}

/*
Nome: diferencaConjuntos
Objetivo: obter um novo conjunto resultante da diferenca entre dois conjuntos (A - B)
Parametros formais:
    - conjunto1: conjunto escolhido como A - parametro de entrada de dados
    - conjunto2: conjunto escolhido como B - parametro de entrada de dados
Valor de retorno: conjunto resultante
*/
tConjunto diferencaConjuntos (tConjunto conjunto1, tConjunto conjunto2) {

    // conjunto resultante
    tConjunto diferenca;

    // inicializa o tamanho do conjunto resultante com 0 para ser incrementado à medida que os valores sao adicionados
    diferenca.tamanho = 0;
    for (int i=0; i<conjunto1.tamanho; i++) {
        // se o elemento esta contido em A e nao esta contido em B, ele esta contido no conjunto resultante
        if ( existeElemento(conjunto2, conjunto1.vetor[i])==-1 ) {
            diferenca.vetor[diferenca.tamanho] = conjunto1.vetor[i];
            diferenca.tamanho++;
        }
    }
    // finaliza o vetor de elementos com \0
    diferenca.vetor[diferenca.tamanho] = '\0';
    // garante que o vetor esteja ordenado
    qsort(diferenca.vetor, diferenca.tamanho, sizeof(int), comparador);

    return diferenca;

}

/*
Nome: elementoMaximo
Objetivo: obter o elemento de maior valor de um dado conjunto
Parametros formais:
    - conjunto: conjunto no qual sera procurado o maior valor - parametro de entrada de dados
Valor de retorno: inteiro referente ao elemento de maior valor do conjunto
*/
int elementoMaximo (tConjunto conjunto) {

    int maximo;

    // inicializa a variavel com o menor valor possivel
    maximo = -2147483648;
    for (int i=0; i<conjunto.tamanho; i++) {
        // procura valores maiores que o atual maximo
        if (conjunto.vetor[i]>maximo) {
            maximo = conjunto.vetor[i];
        }
    }

    return maximo;

}

/*
Nome: elementoMinimo
Objetivo: obter o elemento de menor valor de um dado conjunto
Parametros formais:
    - conjunto: conjunto no qual sera procurado o menor valor - parametro de entrada de dados
Valor de retorno: inteiro referente ao elemento de menor valor do conjunto
*/
int elementoMinimo (tConjunto conjunto) {

    int minimo;

    // inicializa a variavel com o maior valor possivel
    minimo = 2147483647;
    for (int i=0; i<conjunto.tamanho; i++) {
        // procura valores menores que o atual minimo
        if (conjunto.vetor[i]<minimo) {
            minimo = conjunto.vetor[i];
        }
    }

    return minimo;

}

/*
Nome: escolheOperacao
Objetivo: administrar as acoes pertinentes à operacao escolhida pelo usuario
Parametros formais:
    - conjuntos: conjunto principal que armazena os conjuntos inseridos no programa - parametro de entrada e saida de dados
    - operacao: numero da operacao escolhida pelo usuario a partir do menu impresso - parametro de entrada de dados
    - qtd: quantidade atual de conjuntos inseridos no programa - parametro de entrada e saida de dados
Valor de retorno: nao ha
*/
void escolheOperacao (tConjunto conjuntos[], int operacao, int *qtd) {

    char escolha;  // char que armazena a escolha do usuario em imprimir/inserir um conjunto ou nao, quando questionado
    tConjunto auxiliar, resultado;  // conjunto que armazena o conjunto resultante das operacoes de diferenca, interseccao e uniao de conjuntos
    unsigned long long soma;
    int busca, info, elemento, existe, iguais, indice, indiceA, indiceB, maximo, sub, sucesso, vazio;

    auxiliar.tamanho = 0;
    resultado.tamanho = 0;
    memset(auxiliar.vetor, 0, tam_max_elementos*sizeof(int));
    memset(resultado.vetor, 0, tam_max_elementos*sizeof(int));
    switch (operacao) {
        case 0:
            printf("De qual operacao gostaria mais informacoes?\n");
            printf("Digite o numero: ");
            scanf("%d", &info);
            ajuda(info);
            break;
        case 1:
            if (*qtd==tam_max_conjuntos) {
                printf("Numero maximo de conjuntos atingido. Nao é possivel inserir mais conjuntos.\n");
                printf("Quantidade atual de conjuntos no programa: %d\n", *qtd);
                printf("Remova conjuntos ou escolha outra operacao.\n");
            } else {
                printf("Operacao escolhida: criar um conjunto vazio.\n");
                // flag que verifica se o usuario escolheu ou nao um tamanho maior que o maximo suportado pelo programa
                criarVazio(conjuntos, qtd);
                printf("Operacao realizada com sucesso.\n");
                printf("Quantidade atual de conjuntos no programa: %d\n", *qtd);
            }
            break;
        case 2:
            // verifica se o vetor de conjuntos esta no tamanho maximo suportado pelo programa (se estiver, nao é possivel adicionar mais conjuntos)
            if (*qtd==tam_max_conjuntos) {
                printf("Numero maximo de conjuntos atingido. Nao é possivel inserir mais conjuntos.\n");
                printf("Quantidade atual de conjuntos no programa: %d\n", *qtd);
                printf("Remova conjuntos ou escolha outra operacao.\n");
            } else {
                printf("Operacao escolhida: inserir um conjunto completo.\n");
                // flag que verifica se o usuario escolheu ou nao um tamanho maior que o maximo suportado pelo programa
                sucesso = lerConjunto(conjuntos, qtd);
                if (!sucesso) {
                    printf("O tamanho escolhido para o conjunto é maior que o tamanho maximo suportado pelo programa (%d).\n", tam_max_elementos);
                    printf("Escolha um tamanho menor ou outra operacao.\n");
                } else {
                    printf("Operacao realizada com sucesso.\n");
                    printf("Quantidade atual de conjuntos no programa: %d\n", *qtd);
                }
            }
            break;
        case 3:
            // verifica se o vetor de conjuntos esta vazio (se estiver, nao é possivel remover conjuntos)
            if (*qtd==0) {
                printf("Nao ha conjuntos inseridos no programa.\n");
                printf("Quantidade atual de conjuntos no programa: %d\n", *qtd);
                printf("Insira mais conjuntos ou escolha outra operacao.\n");
            } else {
                printf("Operacao escolhida: remover um conjunto completo.\n");
                printf("Digite o numero do conjunto a ser removido: ");
                scanf("%d", &indice);
                // verifica se o usuario escolheu um indice valido do vetor de conjuntos, e entra num loop ate o usuario digitar um numero valido
                while (indice>*qtd || indice<1) {
                    printf("Esse conjunto nao esta inserido no programa. Digite um numero valido.\n");
                    printf("Quantidade atual de conjuntos no programa: %d\n", *qtd);
                    printf("Digite o numero do conjunto a ser removido: ");
                    scanf("%d", &indice);
                }
                // remove o conjunto do vetor de conjuntos
                removeConjunto(conjuntos, indice-1, qtd);
                printf("Operacao realizada com sucesso.\n");
                printf("Quantidade atual de conjuntos no programa: %d\n", *qtd);
                printf("ATENCAO: todos os conjuntos de indice maior que o do removido tiveram seus indices diminuidos em 1.\n");
            }
            break;
        case 4:
            // verifica se o vetor de conjuntos esta vazio (se estiver, nao é possivel imprimir elementos)
            if (*qtd==0) {
                printf("Nao ha conjuntos inseridos no programa.\n");
                printf("Quantidade atual de conjuntos no programa: %d\n", *qtd);
                printf("Insira mais conjuntos ou escolha outra operacao.\n");
            } else {
                printf("Operacao escolhida: imprimir todos os elementos de um conjunto.\n");
                printf("Digite o numero do conjunto a ser impresso: ");
                scanf("%d", &indice);
                // verifica se o usuario escolheu um indice valido do vetor de conjuntos, e entra num loop ate o usuario digitar um numero valido
                while (indice>*qtd || indice<1) {
                    printf("Esse conjunto nao esta inserido no programa. Digite um numero valido.\n");
                    printf("Quantidade atual de conjuntos no programa: %d\n", *qtd);
                    printf("Digite o numero do conjunto a ser impresso: ");
                    scanf("%d", &indice);
                }
                printf("Conjunto %d:\n", indice);
                if (conjuntos[indice-1].tamanho==0) {
                    printf("O conjunto esta vazio.\n");
                } else {
                    escreveConjunto(conjuntos[indice-1]);
                }
            }
            break;
        case 5:
            // verifica se o vetor de conjuntos esta vazio (se estiver, nao é possivel imprimir elementos)
            if (*qtd==0) {
                printf("Nao ha conjuntos inseridos no programa.\n");
                printf("Quantidade atual de conjuntos no programa: %d\n", *qtd);
                printf("Insira mais conjuntos ou escolha outra operacao.\n");
            } else {
                printf("Operacao escolhida: imprimir todos os elementos de um conjunto em ordem aleatoria.\n");
                printf("Digite o numero do conjunto a ser impresso: ");
                scanf("%d", &indice);
                // verifica se o usuario escolheu um indice valido do vetor de conjuntos, e entra num loop ate o usuario digitar um numero valido
                while (indice>*qtd || indice<1) {
                    printf("Esse conjunto nao esta inserido no programa. Digite um numero valido.\n");
                    printf("Quantidade atual de conjuntos no programa: %d\n", *qtd);
                    printf("Digite o numero do conjunto a ser impresso: ");
                    scanf("%d", &indice);
                }
                printf("Conjunto %d:\n", indice);
                if (conjuntos[indice-1].tamanho==0) {
                    printf("O conjunto esta vazio.\n");
                } else {
                    auxiliar = listaEnumerada(conjuntos[indice-1]);
                    escreveConjunto(auxiliar);
                }
            }
            break;
        case 6:
            // verifica se o vetor de conjuntos esta vazio (se estiver, nao é possivel imprimir conjuntos)
            if (*qtd==0) {
                printf("Nao ha conjuntos inseridos no programa.\n");
                printf("Quantidade atual de conjuntos no programa: %d\n", *qtd);
                printf("Insira mais conjuntos ou escolha outra operacao.\n");
            } else {
                printf("Operacao escolhida: imprimir todos os conjuntos atuais do programa.\n");
                // imprime todos os conjuntos inseridos no programa
                for (int i=0; i<*qtd; i++) {
                    printf("Conjunto %d:\n", i+1);
                    escreveConjunto(conjuntos[i]);
                    printf("\n");
                }
            }
            break;
        case 7:
            // verifica se o vetor de conjuntos esta vazio (se estiver, nao é possivel realizar a operacao)
            if (*qtd==0) {
                printf("Nao ha conjuntos inseridos no programa.\n");
                printf("Quantidade atual de conjuntos no programa: %d\n", *qtd);
                printf("Insira mais conjuntos ou escolha outra operacao.\n");
            } else {
                printf("Operacao escolhida: verificar se um conjunto é vazio.\n");
                printf("Digite o numero do conjunto a ser verificado: ");
                scanf("%d", &indice);
                // verifica se o usuario escolheu um indice valido do vetor de conjuntos, e entra num loop ate o usuario digitar um numero valido
                while (indice>*qtd || indice<1) {
                    printf("Esse conjunto nao esta inserido no programa. Digite um numero valido.\n");
                    printf("Quantidade atual de conjuntos no programa: %d\n", *qtd);
                    printf("Digite o numero do conjunto a ser verificado: ");
                    scanf("%d", &indice);
                }
                // verifica se o conjunto esta vazio
                vazio = conjuntoVazio(conjuntos[indice-1]);
                if (vazio) {
                    printf("O conjunto %d esta vazio.\n", indice);
                } else {
                    printf("O conjunto %d nao esta vazio.\n", indice);
                    // da ao usuario a chance de ver o vetor impresso
                    printf("Gostaria de imprimi-lo? (s/n): ");
                    scanf(" %c", &escolha);
                    if (escolha=='s' || escolha=='S') {
                        escreveConjunto(conjuntos[indice-1]);
                    }
                }
            }
            break;
        case 8:
            // verifica se o vetor de conjuntos esta vazio (se estiver, nao é possivel realizar a operacao)
            if (*qtd==0) {
                printf("Nao ha conjuntos inseridos no programa.\n");
                printf("Quantidade atual de conjuntos no programa: %d\n", *qtd);
                printf("Insira mais conjuntos ou escolha outra operacao.\n");
            } else {
                printf("Operacao escolhida: verificar se um conjunto está no tamanho máximo suportado pelo programa.\n");
                printf("Digite o numero do conjunto a ser verificado: ");
                scanf("%d", &indice);
                // verifica se o usuario escolheu um indice valido do vetor de conjuntos, e entra num loop ate o usuario digitar um numero valido
                while (indice>*qtd || indice<1) {
                    printf("Esse conjunto nao esta inserido no programa. Digite um numero valido.\n");
                    printf("Quantidade atual de conjuntos no programa: %d\n", *qtd);
                    printf("Digite o numero do conjunto a ser verificado: ");
                    scanf("%d", &indice);
                }
                // verifica se o conjuntoe esta no tamanho maximo suportado pelo programa
                maximo = conjuntoMaximo(conjuntos[indice-1]);
                if (maximo) {
                    printf("O conjunto %d esta com o tamanho maximo suportado pelo programa (%d).\n", indice, tam_max_elementos);
                } else {
                    printf("O conjunto %d nao esta com o tamanho maximo suportado pelo programa (%d).\n", indice, tam_max_elementos);
                }
                // da ao usuario a chance de ver o vetor impresso
                printf("Gostaria de imprimi-lo? (s/n): ");
                scanf(" %c", &escolha);
                if (escolha=='s' || escolha=='S') {
                    escreveConjunto(conjuntos[indice-1]);
                }
            }
            break;
        case 9:
            // verifica se o vetor de conjuntos esta vazio (se estiver, nao é possivel realizar a operacao)
            if (*qtd==0) {
                printf("Nao ha conjuntos inseridos no programa.\n");
                printf("Quantidade atual de conjuntos no programa: %d\n", *qtd);
                printf("Insira mais conjuntos ou escolha outra operacao.\n");
            } else {
                printf("Operacao escolhida: verificar o tamanho de um conjunto.\n");
                printf("Digite o numero do conjunto a ser verificado: ");
                scanf("%d", &indice);
                // verifica se o usuario escolheu um indice valido do vetor de conjuntos, e entra num loop ate o usuario digitar um numero valido
                while (indice>*qtd || indice<1) {
                    printf("Esse conjunto nao esta inserido no programa. Digite um numero valido.\n");
                    printf("Quantidade atual de conjuntos no programa: %d\n", *qtd);
                    printf("Digite o numero do conjunto a ser verificado: ");
                    scanf("%d", &indice);
                }
                printf("Tamanho do conjunto %d: %d\n", indice, conjuntos[indice-1].tamanho);
                // da ao usuario a chance de ver o vetor impresso
                printf("Gostaria de imprimi-lo? (s/n): ");
                scanf(" %c", &escolha);
                if (escolha=='s' || escolha=='S') {
                    escreveConjunto(conjuntos[indice-1]);
                }
            }
            break;
        case 10:
            // verifica se o vetor de conjuntos esta vazio (se estiver, nao é possivel realizar a operacao)
            if (*qtd==0) {
                printf("Nao ha conjuntos inseridos no programa.\n");
                printf("Quantidade atual de conjuntos no programa: %d\n", *qtd);
                printf("Insira mais conjuntos ou escolha outra operacao.\n");
            } else {
                printf("Operacao escolhida: verificar se um conjunto contem um elemento especifico.\n");
                printf("Digite o numero do conjunto a ser verificado: ");
                scanf("%d", &indice);
                // verifica se o usuario escolheu um indice valido do vetor de conjuntos, e entra num loop ate o usuario digitar um numero valido
                while (indice>*qtd || indice<1) {
                    printf("Esse conjunto nao esta inserido no programa. Digite um numero valido.\n");
                    printf("Quantidade atual de conjuntos no programa: %d\n", *qtd);
                    printf("Digite o numero do conjunto a ser verificado: ");
                    scanf("%d", &indice);
                }
                printf("Digite o elemento a ser verificado: ");
                scanf("%d", &elemento);
                // verifica se o elemento esta contido no conjunto
                existe = existeElemento(conjuntos[indice-1], elemento);
                if (existe==-1) {
                    printf("O elemento %d nao esta contido no conjunto %d.\n", elemento, indice);
                } else {
                    // se estiver, mostra a posicao do elemento no vetor
                    printf("O elemento %d esta contido no conjunto %d.\n", elemento, indice);
                    printf("A posicao do elemento no conjunto é %d.\n", existe+1);
                }
                // da ao usuario a chance de ver o vetor impresso
                printf("Gostaria de imprimi-lo? (s/n): ");
                scanf(" %c", &escolha);
                if (escolha=='s' || escolha=='S') {
                    escreveConjunto(conjuntos[indice-1]);
                }
            }
            break;
        case 11:
            // verifica se o vetor de conjuntos tem menos de 2 conjuntos inseridos (se tiver, nao é possivel obter o conjunto resultante)
            if (*qtd<2) {
                printf("Nao ha conjuntos suficientes para realizar a operacao.\n");
                printf("Quantidade atual de conjuntos no programa: %d\n", *qtd);
                printf("Insira mais conjuntos ou escolha outra operacao.\n");
            } else {
                printf("Operacao escolhida: obter o conjunto resultante da diferenca de dois conjuntos.\n");
                printf("Conjunto A - Conjunto B:\n");
                printf("Digite o numero do conjunto escolhido como A: ");
                scanf("%d", &indiceA);
                // verifica se o usuario escolheu um indice valido do vetor de conjuntos, e entra num loop ate o usuario digitar um numero valido
                while (indiceA>*qtd || indiceA<1) {
                    printf("Esse conjunto nao esta inserido no programa. Digite um numero valido.\n");
                    printf("Quantidade atual de conjuntos no programa: %d\n", *qtd);
                    printf("Digite o numero do conjunto escolhido como A: ");
                    scanf("%d", &indiceA);
                }
                printf("Digite o numero do conjunto escolhido como B: ");
                scanf("%d", &indiceB);
                // verifica se o usuario escolheu um indice valido do vetor de conjuntos, e entra num loop ate o usuario digitar um numero valido
                while (indiceB>*qtd || indiceB<1) {
                    printf("Esse conjunto nao esta inserido no programa. Digite um numero valido.\n");
                    printf("Quantidade atual de conjuntos no programa: %d\n", *qtd);
                    printf("Digite o numero do conjunto escolhido como B: ");
                    scanf("%d", &indiceB);
                }
                // obtem o conjunto resultante da operacao de diferenca de conjuntos
                resultado = diferencaConjuntos(conjuntos[indiceA-1], conjuntos[indiceB-1]);
                printf("Conjunto A:\n");
                escreveConjunto(conjuntos[indiceA-1]);
                printf("Conjunto B:\n");
                escreveConjunto(conjuntos[indiceB-1]);
                if (conjuntoVazio(resultado)) {
                    printf("O conjunto resultante é vazio.\n");
                } else {
                    printf("Conjunto resultante:\n");
                    escreveConjunto(resultado);
                }
                // oferece ao usuario a possibilidade de inserir o conjunto no vetor de conjuntos
                printf("Gostaria de inseri-lo no programa? (s/n): ");
                scanf(" %c", &escolha);
                if (escolha=='s' || escolha=='S') {
                    // verifica se o vetor de conjuntos esta no tamanho maximo suportado pelo programa (se estiver, nao é possivel adicionar mais conjuntos)
                    if (*qtd==tam_max_conjuntos) {
                        printf("Numero maximo de conjuntos atingido. Nao é possivel inserir mais conjuntos.\n");
                        printf("Quantidade atual de conjuntos no programa: %d\n", *qtd);
                        printf("Para inserir este conjunto, remova outro.\n");
                    } else {
                        insereConjunto(conjuntos, resultado, qtd);
                        printf("Insercao realizada com sucesso.\n");
                        printf("Quantidade atual de conjuntos no programa: %d\n", *qtd);
                    }
                }
            }
            break;
        case 12:
            // verifica se o vetor de conjuntos tem menos de 2 conjuntos inseridos (se tiver, nao é possivel obter o conjunto resultante)
            if (*qtd<2) {
                printf("Nao ha conjuntos suficientes para realizar a operacao.\n");
                printf("Quantidade atual de conjuntos no programa: %d\n", *qtd);
                printf("Insira mais conjuntos ou escolha outra operacao.\n");
            } else {
                printf("Operacao escolhida: obter o conjunto resultante da interseccao de dois conjuntos.\n");
                printf("Interseccao do conjunto A com o conjunto B:\n");
                printf("Digite o numero do conjunto escolhido como A: ");
                scanf("%d", &indiceA);
                // verifica se o usuario escolheu um indice valido do vetor de conjuntos, e entra num loop ate o usuario digitar um numero valido
                while (indiceA>*qtd || indiceA<1) {
                    printf("Esse conjunto nao esta inserido no programa. Digite um numero valido.\n");
                    printf("Quantidade atual de conjuntos no programa: %d\n", *qtd);
                    printf("Digite o numero do conjunto escolhido como A: ");
                    scanf("%d", &indiceA);
                }
                printf("Digite o numero do conjunto escolhido como B: ");
                scanf("%d", &indiceB);
                // verifica se o usuario escolheu um indice valido do vetor de conjuntos, e entra num loop ate o usuario digitar um numero valido
                while (indiceB>*qtd || indiceB<1) {
                    printf("Esse conjunto nao esta inserido no programa. Digite um numero valido.\n");
                    printf("Quantidade atual de conjuntos no programa: %d\n", *qtd);
                    printf("Digite o numero do conjunto escolhido como B: ");
                    scanf("%d", &indiceB);
                }
                // obtem o conjunto resultante da operacao de interseccao de conjuntos
                resultado = interseccaoConjuntos(conjuntos[indiceA-1], conjuntos[indiceB-1]);
                printf("Conjunto A:\n");
                escreveConjunto(conjuntos[indiceA-1]);
                printf("Conjunto B:\n");
                escreveConjunto(conjuntos[indiceB-1]);
                if (conjuntoVazio(resultado)) {
                    printf("O conjunto resultante é vazio.\n");
                } else {
                    printf("Conjunto resultante:\n");
                    escreveConjunto(resultado);
                }
                // oferece ao usuario a possibilidade de inserir o conjunto no vetor de conjuntos
                printf("Gostaria de inseri-lo no programa? (s/n): ");
                scanf(" %c", &escolha);
                if (escolha=='s' || escolha=='S') {
                    // verifica se o vetor de conjuntos esta no tamanho maximo suportado pelo programa (se estiver, nao é possivel adicionar mais conjuntos)
                    if (*qtd==tam_max_conjuntos) {
                        printf("Numero maximo de conjuntos atingido. Nao é possivel inserir mais conjuntos.\n");
                        printf("Quantidade atual de conjuntos no programa: %d\n", *qtd);
                        printf("Para inserir este conjunto, remova outro.\n");
                    } else {
                        insereConjunto(conjuntos, resultado, qtd);
                        printf("Insercao realizada com sucesso.\n");
                        printf("Quantidade atual de conjuntos no programa: %d\n", *qtd);
                    }
                }
            }
            break;
        case 13:
            // verifica se o vetor de conjuntos tem menos de 2 conjuntos inseridos (se tiver, nao é possivel obter o conjunto resultante)
            if (*qtd<2) {
                printf("Nao ha conjuntos suficientes para realizar a operacao.\n");
                printf("Quantidade atual de conjuntos no programa: %d\n", *qtd);
                printf("Insira mais conjuntos ou escolha outra operacao.\n");
            } else {
                printf("Operacao escolhida: obter o conjunto resultante da uniao de dois conjuntos.\n");
                printf("Uniao do conjunto A com o conjunto B:\n");
                printf("Digite o numero do conjunto escolhido como A: ");
                scanf("%d", &indiceA);
                // verifica se o usuario escolheu um indice valido do vetor de conjuntos, e entra num loop ate o usuario digitar um numero valido
                while (indiceA>*qtd || indiceA<1) {
                    printf("Esse conjunto nao esta inserido no programa. Digite um numero valido.\n");
                    printf("Quantidade atual de conjuntos no programa: %d\n", *qtd);
                    printf("Digite o numero do conjunto escolhido como A: ");
                    scanf("%d", &indiceA);
                }
                printf("Digite o numero do conjunto escolhido como B: ");
                scanf("%d", &indiceB);
                // verifica se o usuario escolheu um indice valido do vetor de conjuntos, e entra num loop ate o usuario digitar um numero valido
                while (indiceB>*qtd || indiceB<1) {
                    printf("Esse conjunto nao esta inserido no programa. Digite um numero valido.\n");
                    printf("Quantidade atual de conjuntos no programa: %d\n", *qtd);
                    printf("Digite o numero do conjunto escolhido como B: ");
                    scanf("%d", &indiceB);
                }
                // obtem o conjunto resultante da operacao de uniao de conjuntos
                resultado = uniaoConjuntos(conjuntos[indiceA-1], conjuntos[indiceB-1]);
                // verifica se o conjunto resultante teria um tamanho maior que o maximo suportado pelo programa
                if (resultado.tamanho==-1) {
                    printf("Nao é possivel realizar a operacao, pois o tamanho do conjunto resultante é maior que o tamanho maximo suportado pelo programa.\n");
                    printf("Escolha conjuntos menores, ou remova elementos de algum dos conjuntos, ou escolha outra operacao.\n");
                } else {
                    printf("Conjunto A:\n");
                    escreveConjunto(conjuntos[indiceA-1]);
                    printf("Conjunto B:\n");
                    escreveConjunto(conjuntos[indiceB-1]);
                    if (conjuntoVazio(resultado)) {
                        printf("O conjunto resultante é vazio.\n");
                    } else {
                        printf("Conjunto resultante:\n");
                        escreveConjunto(resultado);
                    }
                    // oferece ao usuario a possibilidade de inserir o conjunto no vetor de conjuntos
                    printf("Gostaria de inseri-lo no programa? (s/n): ");
                    scanf(" %c", &escolha);
                    if (escolha=='s' || escolha=='S') {
                        // verifica se o vetor de conjuntos esta no tamanho maximo suportado pelo programa (se estiver, nao é possivel adicionar mais conjuntos)
                        if (*qtd==tam_max_conjuntos) {
                            printf("Numero maximo de conjuntos atingido. Nao é possivel inserir mais conjuntos.\n");
                            printf("Quantidade atual de conjuntos no programa: %d\n", *qtd);
                            printf("Para inserir este conjunto, remova outro.\n");
                        } else {
                            insereConjunto(conjuntos, resultado, qtd);
                            printf("Insercao realizada com sucesso.\n");
                            printf("Quantidade atual de conjuntos no programa: %d\n", *qtd);
                        }
                    }
                }
            }
            break;
        case 14:
            // verifica se o vetor de conjuntos esta vazio (se estiver, nao é possivel realizar a operacao)
            if (*qtd<2) {
                printf("Nao ha conjuntos suficientes para realizar a operacao.\n");
                printf("Quantidade atual de conjuntos no programa: %d\n", *qtd);
                printf("Insira mais conjuntos ou escolha outra operacao.\n");
            } else {
                printf("Operacao escolhida: verificar se dois conjuntos sao iguais.\n");
                printf("Conjunto A = Conjunto B ?\n");
                printf("Digite o numero do conjunto escolhido como A: ");
                scanf("%d", &indiceA);
                // verifica se o usuario escolheu um indice valido do vetor de conjuntos, e entra num loop ate o usuario digitar um numero valido
                while (indiceA>*qtd || indiceA<1) {
                    printf("Esse conjunto nao esta inserido no programa. Digite um numero valido.\n");
                    printf("Quantidade atual de conjuntos no programa: %d\n", *qtd);
                    printf("Digite o numero do conjunto escolhido como A: ");
                    scanf("%d", &indiceA);
                }
                printf("Digite o numero do conjunto escolhido como B: ");
                scanf("%d", &indiceB);
                // verifica se o usuario escolheu um indice valido do vetor de conjuntos, e entra num loop ate o usuario digitar um numero valido
                while (indiceB>*qtd || indiceB<1) {
                    printf("Esse conjunto nao esta inserido no programa. Digite um numero valido.\n");
                    printf("Quantidade atual de conjuntos no programa: %d\n", *qtd);
                    printf("Digite o numero do conjunto escolhido como B: ");
                    scanf("%d", &indiceB);
                }
                // verifica se os conjuntos escolhidos sao iguais
                iguais = conjuntosIguais(conjuntos[indiceA-1], conjuntos[indiceB-1]);
                printf("Conjunto A:\n");
                escreveConjunto(conjuntos[indiceA-1]);
                printf("Conjunto B:\n");
                escreveConjunto(conjuntos[indiceB-1]);
                if (iguais) {
                    printf("O conjunto %d e o conjunto %d sao iguais.\n", indiceA, indiceB);
                } else {
                    printf("O conjunto %d e o conjunto %d nao sao iguais.\n", indiceA, indiceB);
                }
            }
            break;
        case 15:
            // verifica se o vetor de conjuntos esta vazio (se estiver, nao é possivel realizar a operacao)
            if (*qtd<2) {
                printf("Nao ha conjuntos suficientes para realizar a operacao.\n");
                printf("Quantidade atual de conjuntos no programa: %d\n", *qtd);
                printf("Insira mais conjuntos ou escolha outra operacao.\n");
            } else {
                printf("Operacao escolhida: verificar se um conjunto é subconjunto de outro conjunto.\n");
                printf("Conjunto A é subconjunto do Conjunto B ?\n");
                printf("Digite o numero do conjunto escolhido como A: ");
                scanf("%d", &indiceA);
                // verifica se o usuario escolheu um indice valido do vetor de conjuntos, e entra num loop ate o usuario digitar um numero valido
                while (indiceA>*qtd || indiceA<1) {
                    printf("Esse conjunto nao esta inserido no programa. Digite um numero valido.\n");
                    printf("Quantidade atual de conjuntos no programa: %d\n", *qtd);
                    printf("Digite o numero do conjunto escolhido como A: ");
                    scanf("%d", &indiceA);
                }
                printf("Digite o numero do conjunto escolhido como B: ");
                scanf("%d", &indiceB);
                // verifica se o usuario escolheu um indice valido do vetor de conjuntos, e entra num loop ate o usuario digitar um numero valido
                while (indiceB>*qtd || indiceB<1) {
                    printf("Esse conjunto nao esta inserido no programa. Digite um numero valido.\n");
                    printf("Quantidade atual de conjuntos no programa: %d\n", *qtd);
                    printf("Digite o numero do conjunto escolhido como B: ");
                    scanf("%d", &indiceB);
                }
                // verifica se o conjunto A é um subconjunto do conjunto B
                sub = subConjunto(conjuntos[indiceA-1], conjuntos[indiceB-1]);
                printf("Conjunto A:\n");
                escreveConjunto(conjuntos[indiceA-1]);
                printf("Conjunto B:\n");
                escreveConjunto(conjuntos[indiceB-1]);
                if (sub) {
                    printf("O conjunto %d é um subconjunto do conjunto %d.\n", indiceA, indiceB);
                } else {
                    printf("O conjunto %d nao é um subconjunto do conjunto %d.\n", indiceA, indiceB);
                }
            }
            break;
        case 16:
            // verifica se o vetor de conjuntos esta vazio (se estiver, nao é possivel realizar a operacao)
            if (*qtd==0) {
                printf("Nao ha conjuntos inseridos no programa.\n");
                printf("Quantidade atual de conjuntos no programa: %d\n", *qtd);
            } else {
                printf("Operacao escolhida: inserir um elemento em um conjunto.\n");
                printf("Digite o numero do conjunto escolhido: ");
                scanf("%d", &indice);
                // verifica se o usuario escolheu um indice valido do vetor de conjuntos, e entra num loop ate o usuario digitar um numero valido
                while (indice>*qtd || indice<1) {
                    printf("Esse conjunto nao esta inserido no programa. Digite um numero valido.\n");
                    printf("Quantidade atual de conjuntos no programa: %d\n", *qtd);
                    printf("Digite o numero do conjunto escolhido: ");
                    scanf("%d", &indice);
                }
                // verifica se o conjunto escolhido esta com o tamanho maximo suportado pelo programa (se estiver, nao é possivel adicionar mais elementos)
                if ( conjuntoMaximo(conjuntos[indice-1]) ) {
                    printf("O conjunto %d esta com o tamanho maximo suportado pelo programa.\n", indice);
                    printf("Remova elementos deste conjunto ou escolha outra operacao.\n");
                } else {
                    printf("Digite o elemento a ser adicionado: ");
                    scanf("%d", &elemento);
                    // verifica se o elemento foi inserido ou nao no conjunto
                    sucesso = insereElemento(&conjuntos[indice-1], elemento);
                    if (sucesso) {
                        printf("Elemento inserido com sucesso no conjunto.\n");
                    } else {
                        printf("O elemento nao foi inserido no conjunto pois ele ja contem o elemento.\n");
                    }
                    // da ao usuario a chance de ver o conjunto impresso
                    printf("Gostaria de imprimi-lo? (s/n): ");
                    scanf(" %c", &escolha);
                    if (escolha=='s' || escolha=='S') {
                        escreveConjunto(conjuntos[indice-1]);
                    }
                }
            }
            break;
        case 17:
            // verifica se o vetor de conjuntos esta vazio (se estiver, nao é possivel realizar a operacao)
            if (*qtd==0) {
                printf("Nao ha conjuntos inseridos no programa.\n");
                printf("Quantidade atual de conjuntos no programa: %d\n", *qtd);
            } else {
                printf("Operacao escolhida: pegar um elemento aleatorio de um conjunto.\n");
                printf("Digite o numero do conjunto escolhido: ");
                scanf("%d", &indice);
                // verifica se o usuario escolheu um indice valido do vetor de conjuntos, e entra num loop ate o usuario digitar um numero valido
                while (indice>*qtd || indice<1) {
                    printf("Esse conjunto nao esta inserido no programa. Digite um numero valido.\n");
                    printf("Quantidade atual de conjuntos no programa: %d\n", *qtd);
                    printf("Digite o numero do conjunto escolhido: ");
                    scanf("%d", &indice);
                }
                // verifica se o conjunto escolhido esta vazio
                if (conjuntoVazio(conjuntos[indice-1])) {
                    printf("O conjunto %d esta vazio.\n", indice);
                } else {
                    // pega um elemento aleatorio do conjunto escolhido
                    elemento = pegaElemento(conjuntos[indice-1]);
                    printf("O elemento aleatorio escolhido foi: %d\n", elemento);
                }
            }
            break;
        case 18:
            // verifica se o vetor de conjuntos esta vazio (se estiver, nao é possivel realizar a operacao)
            if (*qtd==0) {
                printf("Nao ha conjuntos inseridos no programa.\n");
                printf("Quantidade atual de conjuntos no programa: %d\n", *qtd);
            } else {
                printf("Operacao escolhida: encontrar o elemento de valor mais proximo ao de um valor escolhido como referencia.\n");
                printf("Digite o numero do conjunto escolhido: ");
                scanf("%d", &indice);
                // verifica se o usuario escolheu um indice valido do vetor de conjuntos, e entra num loop ate o usuario digitar um numero valido
                while (indice>*qtd || indice<1) {
                    printf("Esse conjunto nao esta inserido no programa. Digite um numero valido.\n");
                    printf("Quantidade atual de conjuntos no programa: %d\n", *qtd);
                    printf("Digite o numero do conjunto escolhido: ");
                    scanf("%d", &indice);
                }
                printf("Digite o valor inteiro de referencia para a busca: ");
                scanf("%d", &busca);
                // verifica se o conjunto escolhido esta vazio
                if (conjuntoVazio(conjuntos[indice-1])) {
                    printf("O conjunto %d esta vazio.\n", indice);
                } else {
                    // faz a busca pelo elemento mais proximo
                    elemento = maisProximo(conjuntos[indice-1], busca);
                    printf("O elemento de valor mais proximo ao valor %d é: %d, e sua posicao no conjunto é %d.\n", busca, conjuntos[indice-1].vetor[elemento], elemento+1);
                }
            }
            break;
        case 19:
            // verifica se o vetor de conjuntos esta vazio (se estiver, nao é possivel realizar a operacao)
            if (*qtd==0) {
                printf("Nao ha conjuntos inseridos no programa.\n");
                printf("Quantidade atual de conjuntos no programa: %d\n", *qtd);
            } else {
                printf("Operacao escolhida: remover um elemento de um conjunto.\n");
                printf("Digite o numero do conjunto escolhido: ");
                scanf("%d", &indice);
                // verifica se o usuario escolheu um indice valido do vetor de conjuntos, e entra num loop ate o usuario digitar um numero valido
                while (indice>*qtd || indice<1) {
                    printf("Esse conjunto nao esta inserido no programa. Digite um numero valido.\n");
                    printf("Quantidade atual de conjuntos no programa: %d\n", *qtd);
                    printf("Digite o numero do conjunto escolhido: ");
                    scanf("%d", &indice);
                }
                // verifica se o conjunto escolhido esta vazio
                if ( conjuntoVazio(conjuntos[indice-1]) ) {
                    printf("O conjunto %d esta vazio.\n", indice);
                    printf("Escolha outro conjunto ou outra operacao.\n");
                } else {
                    printf("Digite o elemento a ser removido: ");
                    scanf("%d", &elemento);
                    // verifica se o elemento foi removido ou nao do conjunto escolhido
                    sucesso = removeElemento(&conjuntos[indice-1], elemento);
                    if (sucesso) {
                        printf("Elemento removido com sucesso do conjunto.\n");
                    } else {
                        printf("O elemento nao foi removido do conjunto pois ele nao contem o elemento.\n");
                    }
                    // da ao usuario a chance de ver o conjunto impresso
                    printf("Gostaria de imprimi-lo? (s/n): ");
                    scanf(" %c", &escolha);
                    if (escolha=='s' || escolha=='S') {
                        escreveConjunto(conjuntos[indice-1]);
                    }
                }
            }
            break;
        case 20:
            // verifica se o vetor de conjuntos esta vazio (se estiver, nao é possivel realizar a operacao)
            if (*qtd==0) {
                printf("Nao ha conjuntos inseridos no programa.\n");
                printf("Quantidade atual de conjuntos no programa: %d\n", *qtd);
            } else {
                printf("Operacao escolhida: remover todos os elementos de um conjunto.\n");
                printf("Digite o numero do conjunto escolhido: ");
                scanf("%d", &indice);
                // verifica se o usuario escolheu um indice valido do vetor de conjuntos, e entra num loop ate o usuario digitar um numero valido
                while (indice>*qtd || indice<1) {
                    printf("Esse conjunto nao esta inserido no programa. Digite um numero valido.\n");
                    printf("Quantidade atual de conjuntos no programa: %d\n", *qtd);
                    printf("Digite o numero do conjunto escolhido: ");
                    scanf("%d", &indice);
                }
                // verifica se o conjunto escolhido esta vazio
                if ( conjuntoVazio(conjuntos[indice-1]) ) {
                    printf("O conjunto %d esta vazio.\n", indice);
                    printf("Escolha outro conjunto ou outra operacao.\n");
                } else {
                    limpaConjunto(&conjuntos[indice-1]);
                    printf("Elementos removidos com sucesso.\n");
                }
            }
            break;
        case 21:
            // verifica se o vetor de conjuntos esta vazio (se estiver, nao é possivel realizar a operacao)
            if (*qtd==0) {
                printf("Nao ha conjuntos inseridos no programa.\n");
                printf("Quantidade atual de conjuntos no programa: %d\n", *qtd);
            } else {
                printf("Operacao escolhida: obter o menor elemento de um conjunto.\n");
                printf("Digite o numero do conjunto escolhido: ");
                scanf("%d", &indice);
                // verifica se o usuario escolheu um indice valido do vetor de conjuntos, e entra num loop ate o usuario digitar um numero valido
                while (indice>*qtd || indice<1) {
                    printf("Esse conjunto nao esta inserido no programa. Digite um numero valido.\n");
                    printf("Quantidade atual de conjuntos no programa: %d\n", *qtd);
                    printf("Digite o numero do conjunto escolhido: ");
                    scanf("%d", &indice);
                }
                // verifica se o conjunto escolhido esta vazio
                if (conjuntoVazio(conjuntos[indice-1])) {
                    printf("O conjunto %d esta vazio.\n", indice);
                } else {
                    // obtem o elemento de menor valor do conjunto
                    elemento = elementoMinimo(conjuntos[indice-1]);
                    printf("O elemento de menor valor do conjunto %d é: %d\n", indice, elemento);
                }
            }
            break;
        case 22:
            // verifica se o vetor de conjuntos esta vazio (se estiver, nao é possivel realizar a operacao)
            if (*qtd==0) {
                printf("Nao ha conjuntos inseridos no programa.\n");
                printf("Quantidade atual de conjuntos no programa: %d\n", *qtd);
            } else {
                printf("Operacao escolhida: obter o maior elemento de um conjunto.\n");
                printf("Digite o numero do conjunto escolhido: ");
                scanf("%d", &indice);
                // verifica se o usuario escolheu um indice valido do vetor de conjuntos, e entra num loop ate o usuario digitar um numero valido
                while (indice>*qtd || indice<1) {
                    printf("Esse conjunto nao esta inserido no programa. Digite um numero valido.\n");
                    printf("Quantidade atual de conjuntos no programa: %d\n", *qtd);
                    printf("Digite o numero do conjunto escolhido: ");
                    scanf("%d", &indice);
                }
                // verifica se o conjunto escolhido esta vazio
                if (conjuntoVazio(conjuntos[indice-1])) {
                    printf("O conjunto %d esta vazio.\n", indice);
                } else {
                    // obtem o elemento de menor valor do conjunto
                    elemento = elementoMaximo(conjuntos[indice-1]);
                    printf("O elemento de maior valor do conjunto %d é: %d\n", indice, elemento);
                }
            }
            break;
        case 23:
            // verifica se o vetor de conjuntos esta vazio (se estiver, nao é possivel realizar a operacao)
            if (*qtd==0) {
                printf("Nao ha conjuntos inseridos no programa.\n");
                printf("Quantidade atual de conjuntos no programa: %d\n", *qtd);
            } else {
                printf("Operacao escolhida: obter o valor da soma de todos os elementos de um conjunto.\n");
                printf("Digite o numero do conjunto escolhido: ");
                scanf("%d", &indice);
                // verifica se o usuario escolheu um indice valido do vetor de conjuntos, e entra num loop ate o usuario digitar um numero valido
                while (indice>*qtd || indice<1) {
                    printf("Esse conjunto nao esta inserido no programa. Digite um numero valido.\n");
                    printf("Quantidade atual de conjuntos no programa: %d\n", *qtd);
                    printf("Digite o numero do conjunto escolhido: ");
                    scanf("%d", &indice);
                }
                // verifica se o conjunto escolhido esta vazio
                if (conjuntoVazio(conjuntos[indice-1])) {
                    printf("O conjunto %d esta vazio.\n", indice);
                } else {
                    // obtem o elemento de menor valor do conjunto
                    soma = somaElementos(conjuntos[indice-1]);
                    printf("O valor da soma de todos os elementos do conjunto %d é: %lld\n", indice, soma);
                }
            }
            break;
        case 24:
            // imprime novamente o menu a pedido do usuario
            imprimeMenu();
            break;
        case 25:
            // faz uma despedida
            printf("Obrigada por usar o programa! Ate a proxima :)\n");
            break;
        // verifica se o numero digitado pelo usuario é valido ou nao
        default: printf("Operacao invalida. Digite um numero valido.\n");
    }

}

/*
Nome: escreveConjunto
Objetivo: imprimir os elementos de um dado conjunto
Parametros formais:
    - conjunto: conjunto que sera impresso - parametro de entrada de dados
Valor de retorno: nao ha
*/
void escreveConjunto (tConjunto conjunto) {

    printf("Tamanho do conjunto: %d\n", conjunto.tamanho);
    printf("Elementos do conjunto: ");
    // imprime todos os elementos do conjunto
    for (int i=0; i<conjunto.tamanho; i++) {
        printf("%d ", conjunto.vetor[i]);
    }
    printf("\n");

}

/*
Nome: existeElemento
Objetivo: verificar se um dado elemento esta contido em um dado conjunto, e se existir, informar a posicao do elemento no vetor
Parametros formais:
    - conjunto: conjunto a ser verificado - parametro de entrada de dados
    - elemento: elemento a ser verificado - parametro de entrada de dados
Valor de retorno: inteiro referente ao resultado da verificacao
    - -1, se o elemento nao esta contido no conjunto
    - inteiro maior ou igual a zero, referente à posicao do elemento no vetor
*/
int existeElemento (tConjunto conjunto, int elemento) {

    int existe;

    // inicializa a flag com o valor associado ao resultado de verificacao negativa
    existe = -1;
    for (int i=0; i<conjunto.tamanho; i++) {
        // se achar, atualiza a flag e ela passa a ter o valor da posicao do elemento no conjunto
        if (conjunto.vetor[i]==elemento) {
            existe = i;
            break;
        }
    }

    return existe;

}

/*
Nome: imprimeMenu
Objetivo: imprimir o menu do programa com as operacoes disponiveis e seus respectivos codigos
Parametros formais: nao ha
Valor de retorno: nao ha
*/
void imprimeMenu (void) {

    printf("Importante! O programa suporta um conjunto de tamanho maximo de %d elementos, e um maximo de %d conjuntos.\n", tam_max_elementos, tam_max_conjuntos);
    printf("1 - criar um conjunto vazio\n");
    printf("2 - inserir um conjunto completo\n");
    printf("3 - remover um conjunto completo\n");
    printf("4 - imprimir todos os elementos de um conjunto\n");
    printf("5 - imprimir todos os elementos de um conjunto em ordem aleatoria\n");
    printf("6 - imprimir todos os conjuntos atuais do programa\n");
    printf("7 - verificar se um conjunto é vazio\n");
    printf("8 - verificar se um conjunto está no tamanho máximo suportado pelo programa\n");
    printf("9 - verificar o tamanho de um conjunto\n");
    printf("10 - verificar se um conjunto contem um elemento especifico\n");
    printf("11 - obter o conjunto resultante da diferenca de dois conjuntos\n");
    printf("12 - obter o conjunto resultante da interseccao de dois conjuntos\n");
    printf("13 - obter o conjunto resultante da uniao de dois conjuntos\n");
    printf("14 - verificar se dois conjuntos sao iguais\n");
    printf("15 - verificar se um conjunto é subconjunto de outro conjunto\n");
    printf("16 - inserir um elemento em um conjunto\n");
    printf("17 - pegar um elemento aleatorio de um conjunto\n");
    printf("18 - obter o elemento de valor mais proximo de um dado valor de referencia\n");
    printf("19 - remover um elemento de um conjunto\n");
    printf("20 - remover todos os elementos de um conjunto\n");
    printf("21 - obter o elemento de menor valor de um conjunto.\n");
    printf("22 - obter o elemento de maior valor de um conjunto.\n");
    printf("23 - obter o valor da soma de todos os elementos de um conjunto.\n");
    printf("24 - mostra o menu novamente\n");
    printf("25 - encerra o programa\n");
    printf("Caso deseje informacoes mais detalhadas de uma operacao, digite 0\n");

}

/*
Nome: insereElemento
Objetivo: inserir, se possivel, um dado elemento num dado conjunto
Parametros formais:
    - conjunto: conjunto no qual sera inserido o elemento - parametro de entrada e saida de dados
    - elemento: elemento a ser inserido - parametro de entrada de dados
Valor de retorno: inteiro referente ao sucesso da insercao
    - 0, se o conjunto ja continha o elemento (portanto, nao foi adicionado pois nao podem haver valores repetidos)
    - 1, se o elemento foi inserido com sucesso no conjunto
*/
int insereElemento (tConjunto *conjunto, int elemento) {

    int sucesso;

    // verifica se o elemento a ser inserido ja esta contido no dado conjunto
    sucesso = existeElemento(*conjunto, elemento);
    // se nao esta contido, insere o elemento
    if (sucesso==-1) {
        conjunto->vetor[conjunto->tamanho] = elemento;
        conjunto->tamanho++;
        conjunto->vetor[conjunto->tamanho] = '\0';
        qsort(conjunto->vetor, conjunto->tamanho, sizeof(int), comparador);
        sucesso = 1;
    // se ja esta contido, nao insere
    } else {
        sucesso = 0;
    }

    return sucesso;
    
}

/*
Nome: insereConjunto
Objetivo: inserir, se possivel, um dado conjunto no vetor de conjuntos
Parametros formais:
    - conjuntos : vetor de conjuntos no qual sera inserido o conjunto - parametro de entrada e saida de dados
    - conjunto: conjunto a ser inserido - parametro de entrada de dados
    - qtd: quantidade atual de conjuntos inseridos no programa - parametro de entrada e saida de dados
Valor de retorno: nao ha
*/
void insereConjunto (tConjunto conjuntos[], tConjunto conjunto, int *qtd) {

    // insere o conjunto na posicao atual em conjuntos e atualiza a quantidade de conjuntos do programa
    conjuntos[*qtd] = conjunto;
    *qtd = *qtd+1;

}

/*
Nome: interseccaoConjuntos
Objetivo: obter um novo conjunto resultante da interseccao entre dois conjuntos (A interseccao B)
Parametros formais:
    - conjunto1: conjunto escolhido como A - parametro de entrada de dados
    - conjunto2: conjunto escolhido como B - parametro de entrada de dados
Valor de retorno: conjunto resultante
*/
tConjunto interseccaoConjuntos (tConjunto conjunto1, tConjunto conjunto2) {

    tConjunto interseccao;

    // inicializa o tamanho do conjunto resultante com 0 para ser incrementado à medida que os valores sao adicionados
    interseccao.tamanho = 0;
    for (int i=0; i<conjunto1.tamanho; i++) {
        // se o elemento esta nos dois conjuntos, ele é adicionado ao conjunto resultante
        if ( existeElemento(conjunto2, conjunto1.vetor[i])!=-1 ) {
            interseccao.vetor[interseccao.tamanho] = conjunto1.vetor[i];
            interseccao.tamanho++;
        }
    }
    // finaliza o vetor de elementos com \0
    interseccao.vetor[interseccao.tamanho] = '\0';
    // garante que o vetor esteja ordenado
    qsort(interseccao.vetor, interseccao.tamanho, sizeof(int), comparador);;

    return interseccao;

}

/*
Nome: lerConjunto
Objetivo: ler o tamanho de um conjunto e seus elementos do teclado
Parametros formais:
    - conjuntos: vetor de conjuntos no qual sera inserido o novo conjunto - parametro de entrada e saida de dados
    - qtd: quantidade atual de conjuntos inseridos no programa - parametro de entrada e saida de dados
Valor de retorno: inteiro referente ao sucesso da leitura
    - 0, se o tamanho digitado pelo usuario for maior que o tamanho maximo suportado pelo programa para um conjunto
    - 1, se o conjunto for lido com sucesso
*/
int lerConjunto (tConjunto conjuntos[], int *qtd) {

    printf("Digite o tamanho do conjunto: ");
    scanf("%d", &conjuntos[*qtd].tamanho);

    // verifica se o tamanho digitado pelo usuario é superiro ao tamanho maximo suportado pelo programa
    if (conjuntos[*qtd].tamanho>tam_max_elementos) {
        return 0;
    }

    // le os elementos do teclado e armazena no conjunto
    printf("Digite os %d elementos do conjunto: ", conjuntos[*qtd].tamanho);
    for (int i=0; i<conjuntos[*qtd].tamanho; i++) {
        scanf("%d", &conjuntos[*qtd].vetor[i]);
    }
    // finaliza o vetor de elementos com \0
    conjuntos[*qtd].vetor[conjuntos[*qtd].tamanho] = '\0';
    // garante que o vetor esteja ordenado
    qsort(conjuntos[*qtd].vetor, conjuntos[*qtd].tamanho, sizeof(int), comparador);
    // atualiza a quantidade de conjuntos inseridos no programa
    *qtd = *qtd+1;

    return 1;

}

/*
Nome: limpaConjunto
Objetivo: remover todos os elementos de um conjunto
Parametros formais:
    - conjunto: conjunto do qual serao removidos todos os elementos - parametro de entrada e saida de dados
Valor de retorno: nao ha
*/
void limpaConjunto (tConjunto *conjunto) {

    // limpa todos os elementos do conjunto
    for (int i=0; i<conjunto->tamanho; i++) {
        conjunto->vetor[i] = 0;
    }
    conjunto->vetor[0] = '\0';

    // atualiza o tamanho do conjunto
    conjunto->tamanho = 0;

}

/*
Nome: listaEnumerada
Objetivo: obter uma lista com os elementos de um conjunto em uma ordem aleatoria
Parametros formais:
    - conjunto: conjunto cujos elementos farao parte da lista - parametro de entrada de dados
Valor de retorno: conjunto com os elementos em ordem aleatoria
*/
tConjunto listaEnumerada (tConjunto conjunto) {

    int sucesso;
    tConjunto auxiliar, lista;

    auxiliar = conjunto;

    // lista armazenara os elementos em ordem aleatoria
    lista.tamanho = 0;
    for (int i=0; i<conjunto.tamanho; i++) {
        // pega um elemento aleatorio por vez
        lista.vetor[i] = pegaElemento(auxiliar);
        lista.tamanho++;
        // e depois remove ele do conjunto auxiliar
        sucesso = removeElemento(&auxiliar, lista.vetor[i]);
    }

    return lista;

}

/*
Nome: maisProximo
Objetivo: obter o elemento de valor mais proximo de um dado valor de referencia
Parametros formais:
    - conjunto: conjunto no qual sera procurado o elemento - parametro de entrada de dados
    - elemento: valor inteiro como refencia para a busca de seu valor mais proximo
Valor de retorno: posicao do elemento de valor mais proximo do valor de referencia
*/
int maisProximo (tConjunto conjunto, int elemento) {

    int posicao, proximo;

    // procura o elemento mais proximo ao valor de referencia, parando se ultrapassar esse valor ou se chegar no fim do conjunto
    posicao = 0;
    while (conjunto.vetor[posicao]<elemento && posicao<conjunto.tamanho) {
        posicao++;
    }

    // se o valor mais proximo for o proprio valor de busca, entao esta pronto; senao, faz o seguinte
    if (conjunto.vetor[posicao]!=elemento) {
        // se a posicao estiver no fim do vetor, o valor mais proximo com certeza é o ultimo
        if (posicao==conjunto.tamanho) {
            proximo = posicao-1;
        } else if (posicao==0) {
            // se estiver na primeira posicao ainda, entao com certeza o valor mais proximo é o ultimo
            proximo = posicao;
        } else {
            // se estiver no meio do conjunto, ve qual dos dois valores (o primeiro que ultrapassou e o anterior) esta mais proximo do valor referencia
            if ( abs(conjunto.vetor[posicao]-elemento) < abs(conjunto.vetor[posicao-1]-elemento) ) {
                proximo = posicao;
            } else {
                proximo = posicao-1;
            }
        }
    }

    return proximo;

}

/*
Nome: pegaElemento
Objetivo: pegar um elemento aleatorio de um dado conjunto
Parametros formais:
    - conjunto: conjunto do qual sera escolhido um valor aleatorio - parametro de entrada de dados
Valor de retorno: elemento escolhido
*/
int pegaElemento (tConjunto conjunto) {

    int elemento;

    // escolhe um indice aleatorio e pega esse elemento do conjunto
    elemento = conjunto.vetor[rand()%conjunto.tamanho];

    return elemento;

}

/*
Nome: removeConjunto
Objetivo: remover um conjunto completo do vetor de conjuntos do programa
Parametros formais:
    - conjuntos: vetor de conjuntos do qual sera removido o dado conjunto - parametro de entrada e saida de dados
    - indice: indice, no vetor de conjuntos, do conjunto a ser removido - parametro de entrada de dados
    - qtd: quantidade atual de conjuntos inseridos no programa - parametro de entrada e saida de dados
Valor de retorno: nao ha
*/
void removeConjunto (tConjunto conjuntos[], int indice, int *qtd) {

    // move uma posicao para tras todos os conjuntos à frente do conjunto a ser removido
    for (int i=indice; i<*qtd-1; i++) {
        conjuntos[i] = conjuntos[i+1];
    }
    // zera o conjunto da ultima posicao
    conjuntos[*qtd-1].tamanho = '\0';
    conjuntos[*qtd-1].vetor[0] = '\0';
    // atualiza a quantidade de conjuntos do programa
    *qtd = *qtd-1;

}

/*
Nome: removeElemento
Objetivo: remover, se possivel, um dado elemento de um dado conjunto
Parametros formais:
    - conjunto: conjunto do qual sera removido o elemento - parametro de entrada e saida de dados
    - elemento: elemento a ser removido
Valor de retorno: inteiro referente ao sucesso da remocao
    - 1, se o elemento foi removido
    - 0, se o elemento nao foi removido (porque o dado conjunto nao continha o elemento)
*/
int removeElemento (tConjunto *conjunto, int elemento) {

    int i, sucesso;

    // verifica se o elemento a ser removido esta contido no conjunto
    sucesso = existeElemento(*conjunto, elemento);
    if (sucesso!=-1) {
        i = 0;
        // se estiver contido, procura o indice do elemento
        while (conjunto->vetor[i]!=elemento) {
            i++;
        }
        // e substitui o elemento a ser removido com o ultimo elemento do conjunto
        conjunto->vetor[i] = conjunto->vetor[conjunto->tamanho-1];
        // atualiza a finalizacao do vetor com \0
        conjunto->vetor[conjunto->tamanho-1] = '\0';
        // atualiza o tamanho do conjunto
        conjunto->tamanho--;
        // e ordena o conjunto
        qsort(conjunto->vetor, conjunto->tamanho, sizeof(int), comparador);
        sucesso = 1;
    } else {
        sucesso = 0;
    }

    return sucesso;
    
}

/*
Nome: somaElementos
Objetivo: somar todos os elementos de um conjunto
Parametros formais:
    - conjunto: conjunto cujos elementos serao somados - parametro de entrada de dados
Valor de retorno: unsigned long long referente à soma dos elementos do conjunto
*/
unsigned long long somaElementos (tConjunto conjunto) {

    unsigned long long soma;

    // inicializa o valor da soma com 0
    soma = 0;
    // soma todos os elementos do vetor
    for (int i=0; i<conjunto.tamanho; i++) {
        soma += conjunto.vetor[i];
    }

    return soma;

}

/*
Nome: subConjunto
Objetivo: verificar se um conjunto é subconjunto de outro conjunto (A subconjunto de B ?)
Parametros formais:
    - conjunto1: conjunto escolhido como A - parametro de entrada dados
    - conjunto2: conjunto escolhido como B - parametro de entrada dados
Valor de retorno: inteiro referente ao resultado da verificacao
    - 1, se o conjunto A for um subconjunto do conjunto B
    - 0, se o conjunto A nao for um subconjunto do conjunto B
*/
int subConjunto (tConjunto conjunto1, tConjunto conjunto2) {

    int sub;

    // inicializa a flag com o valor associado ao resultado positivo da verificacao
    sub = 1;
    for (int i=0; i<conjunto1.tamanho; i++) {
        // se algum elemento de conjunto2 nao estiver contido em conjunto1, conjunto2 nao é um subconjunto de conjunto1
        if ( existeElemento(conjunto2, conjunto1.vetor[i])==-1 ) {
            sub = 0;
            break;
        }
    }

    return sub;

}

/*
Nome: tamanhoConjunto
Objetivo: verificar o tamanho de um dado conjunto
Parametros formais:
    - conjunto: conjunto cujo tamanho sera verificado - parametro de entrada dados
Valor de retorno: tamanho do conjunto
*/
int tamanhoConjunto (tConjunto conjunto) {

    // retorna o tamanho do conjunto
    return conjunto.tamanho;

}

/*
Nome: uniaoConjuntos
Objetivo: obter um novo conjunto resultante da uniao entre dois conjuntos (A uniao B)
Parametros formais:
    - conjunto1: conjunto escolhido como A - parametro de entrada de dados
    - conjunto2: conjunto escolhido como B - parametro de entrada de dados
Valor de retorno: conjunto resultante
*/
tConjunto uniaoConjuntos (tConjunto conjunto1, tConjunto conjunto2) {

    tConjunto uniao;

    // inicializa o tamanho do conjunto resultante com 0 para ser incrementado à medida que os valores sao adicionados
    uniao.tamanho = 0;
    // adiciona todos os elementos de conjunto1 ao conjunto resultante
    for (int i=0; i<conjunto1.tamanho; i++) {
        uniao.vetor[i] = conjunto1.vetor[i];
        uniao.tamanho++;
    }
    for (int i=0; i<conjunto2.tamanho; i++) {
        // adiciona ao conjunto resultante apenas os elementos de conjunto2 que nao estao contidos em conjunto1, para nao haver elementos repetidos
        if ( existeElemento(uniao, conjunto2.vetor[i])==-1 ) {
            if (uniao.tamanho==tam_max_elementos) {
                uniao.tamanho = -1;
                return uniao;
            }
            uniao.vetor[uniao.tamanho] = conjunto2.vetor[i];
            uniao.tamanho++;
        }
    }
    // finaliza o vetor de elementos com \0
    uniao.vetor[uniao.tamanho] = '\0';
    // garante que o vetor esteja ordenado
    qsort(uniao.vetor, uniao.tamanho, sizeof(int), comparador);

    return uniao;

}