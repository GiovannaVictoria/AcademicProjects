#include "ArvB.h"

ArvB* arvB_cria() {
   ArvB *raiz = (ArvB*)malloc(sizeof(ArvB));
   if (raiz!=NULL) {
      *raiz = NULL;
   }
   return raiz;
}

void arvB_destroi (ArvB *raiz) {
    struct NO *aux = *raiz;
    if(aux != NULL){
        for(int i = 0; i<aux->qtd_chaves; i++){
            arvB_destroi(&aux->filhos[i]);
        }
        free(aux);
    }
}

int arvB_insere(ArvB* raiz, int valor) {

   if (raiz==NULL) {
      return 0;
   }

   struct NO* novo;
   novo = (struct NO*)malloc(sizeof(struct NO));
   novo->chaves[novo->qtd_chaves] = valor;
   novo->qtd_chaves++;

   if (novo==NULL) {
      return 0;
   }

   if (*raiz==NULL) {
      *raiz = novo;
      return 1;
   }

   int posicao = 0;
   struct NO* p = *raiz;

   // a chave sera inserida num no folha, entao procura ele
   if (!eFolha(p)) {
      while (!eFolha(p)) {
         posicao = 0;
         while (p->chaves[posicao]<valor && posicao<p->qtd_chaves) {
            posicao++;
         }
         p = p->filhos[p->filhos[posicao]==NULL ? posicao - 1 : posicao];
      }
   }

   // se o no folha encontrado estiver cheio, ele eh particionado
   if (p->qtd_chaves==ordem-1) {
      split(raiz, p, valor);
   } else {
      // senao, apenas insere a chave
      p->chaves[p->qtd_chaves] = valor;
      p->qtd_chaves++;
      qsort(p->chaves, p->qtd_chaves, sizeof(int), compare);
   }

   return 1;

}

void split(ArvB *raiz, ArvB filho, int ch) {

   bool encontrou = false;
   struct NO *novo1, *novo2, *p = *raiz;
   int posicaoFilho, posicaoNovo, posicaoNovosFilhos, posicaoP, posicaoPai, separador, *vetor;

   vetor = (int*)malloc(ordem*sizeof(int));

   novo1 = (struct NO*)malloc(sizeof(struct NO));
   novo2 = (struct NO*)malloc(sizeof(struct NO));

   // problema na alocacao dos novos nos
   if (novo1==NULL || novo2==NULL) {
      return;
   }

   for (int i=0; i<ordem-1; i++) {
      vetor[i] = filho->chaves[i];
   }
   vetor[ordem-1] = ch;

   qsort(vetor, ordem, sizeof(int), compare);

   novo1->qtd_chaves = 0;
   novo2->qtd_chaves = 0;

   // separa as chaves do no filho:
   // a primeira metade vai pra novo1
   for (int i=0, j=0; i<=ordem/2; i++, j++) {
      novo1->chaves[j] = vetor[i];
      novo1->qtd_chaves++;
   }
   // e a segunda metade vai pra novo2
   for (int j=0, i = ordem/2+1; i<ordem; i++, j++) {
      novo2->chaves[j] = vetor[i];
      novo2->qtd_chaves++;
   }

   if (novo1->qtd_chaves>novo2->qtd_chaves) {
      separador = novo1->chaves[novo1->qtd_chaves-1];
      novo1->chaves[novo1->qtd_chaves-1] = 0;
      novo1->qtd_chaves--;
      qsort(novo1->chaves, novo1->qtd_chaves, sizeof(int), compare);
   } else {
      separador = novo2->chaves[0];
      novo2->chaves[0] = novo2->chaves[novo2->qtd_chaves-1];
      novo2->chaves[novo2->qtd_chaves-1] = 0;
      novo2->qtd_chaves--;
      qsort(novo2->chaves, novo2->qtd_chaves, sizeof(int), compare);   
   }

   // atualiza os filhos dos novos nos
   posicaoNovosFilhos=0;
   if (!eFolha(filho)) {
      for (int j=0; j<=novo1->qtd_chaves; j++, posicaoNovosFilhos++) {
         novo1->filhos[j] = filho->filhos[posicaoNovosFilhos];
      }
      //if (ordem==6) {
         posicaoNovosFilhos--;
      //}
      for (int j=0; j<=novo2->qtd_chaves; j++, posicaoNovosFilhos++) {
         novo2->filhos[j] = filho->filhos[posicaoNovosFilhos];
      }
   }

   // procura o pai do no filho
   if (*raiz!=filho) {
      while (!encontrou) {
         for (posicaoPai=0; posicaoPai<=p->qtd_chaves && !encontrou && filho->chaves[0]>p->chaves[posicaoPai]; posicaoPai++) {
            if (p->filhos[posicaoPai]==filho) {
               encontrou = true;
            }
         }
         if (posicaoPai<p->qtd_chaves) {
            if (p->filhos[posicaoPai]==filho) {
               encontrou = true;
            }
         }
         if (!encontrou) {
            p = p->filhos[p->qtd_chaves>0 ? posicaoPai : posicaoPai - 1];
         }
      }
   }

   // o no a ser particionado eh a propria raiz
   if (*raiz==filho) {
      for (int i=0; i<p->qtd_chaves; i++) {
         p->chaves[i] = 0;
      }
      for (int i=0; i<ordem; i++) {
         p->filhos[i] = NULL;
      }
      p->qtd_chaves = 0;
   }

   // o no pai do no particionado tambem esta cheio e tambem precisa ser particionado
   if (p->qtd_chaves==ordem-1 && *raiz!=filho) {
      split(raiz, p, separador);
      struct NO *p = *raiz;
      encontrou = false;
      // procura o novo no particionado
      while (!encontrou) {
         for (posicaoP=0; posicaoP<p->qtd_chaves && !encontrou && separador>=p->chaves[posicaoP]; posicaoP++) {
            if (p->chaves[posicaoP]==separador) {
               encontrou = true;
            }
         }
         if (posicaoP<p->qtd_chaves) {
            if (p->chaves[posicaoP]==separador) {
               encontrou = true;
            }
         }
         if (!encontrou) {
            p = p->filhos[p->qtd_chaves>0 ? posicaoP : posicaoP - 1];
         }
      }
      // atualiza os filhos do novo no particionado e o atributo 'folha'
      int aux = p->qtd_chaves;
      while (aux>posicaoP) {
         p->filhos[aux] = p->filhos[aux-1];
         aux--;
      }
      p->filhos[aux] = novo2;
      p->filhos[aux-1] = novo1;
      for (int i=p->qtd_chaves+1; i<ordem; i++) {
         p->filhos[i] = NULL;
      }
   } else {
      // o no pai do no particionado nao esta cheio, entao so adiciona o separador e atualiza os filhos e o atributo 'folha'
      int aux1, aux2 = p->qtd_chaves;
      while (aux2>posicaoPai) {
         p->chaves[aux2] = p->chaves[aux2-1];
         p->filhos[aux2+1] = p->filhos[aux2];
         aux2--;
      }
      p->chaves[aux2] = separador;
      p->filhos[aux2+1] = novo2;
      p->filhos[aux2] = novo1;
      p->qtd_chaves++;
      for (int i=p->qtd_chaves+1; i<ordem; i++) {
         p->filhos[i] = NULL;
      }
   }

   free(vetor);

   return;

}

// funcao que determina se um no eh folha ou nao
bool eFolha(struct NO *no) {
   return (no->filhos[0] == NULL);
}

// funcao comparadora para qsort
int compare(const void *a, const void *b) {
   return ( *(int*)a - *(int*)b );
}