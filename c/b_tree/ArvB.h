#ifndef ARV_B
#define ARV_B

#define ordem 3 //número máximo de filhos

#include <stdlib.h>
#include <stdbool.h>

typedef struct NO *ArvB;

struct NO {
    int qtd_chaves;
    int chaves[ordem - 1];
    struct NO *filhos[ordem];
};

ArvB* arvB_cria();
bool eFolha(struct NO *no);
void arvB_destroi(ArvB *raiz);
int arvB_insere(ArvB* raiz, int valor);
void split(ArvB *raiz, ArvB filho, int ch);
int compare(const void *a, const void *b);

#endif /* ARV_B */
