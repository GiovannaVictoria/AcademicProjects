#include "CRUD.h"

/* Construtor da classe CRUD com todos os atributos */
CRUD::CRUD () {}

/* Destrutor da classe CRUD */
CRUD::~CRUD () {}

/*
Nome: criar
Objetivo: escrever os dados de um dado elemento no arquivo
Parametros:
   - arquivo: string no formato ponteiro para const char - nome do arquivo em que os dados serao inseridos
   - elemento: ponteiro para Elemento - elemento com os dados que serao inseridos no arquivo
Retorno:
   - false se o elemento nao foi inserido
   - true se o elemento foi inserido
*/
bool CRUD::criar (const char *arquivo, Elemento* elemento) {
   Elemento *busca;
   ofstream saida;
   saida.open(arquivo, ios::app|ios::binary);
   if (saida.is_open()) {
      if (ler(arquivo, elemento, busca)) {
         cout << "Elemento de numero atomico " << elemento->getNumeroAtomico() << " ja presente no arquivo" << endl;
         saida.close();
         return false;
      } else {
         saida.write(reinterpret_cast<char *>(&elemento), sizeof(Elemento*));
         saida.close();
         //qtdeElementos++;
         return true;
      }
   } else {
      cout << "Nao foi possivel abrir o arquivo \"" << arquivo << "\"" << endl;
      saida.close();
      return false;
   }
}

/*
Nome: ler
Objetivo: ler os dados de um dado elemento do arquivo
Parametros:
   - arquivo: string no formato ponteiro para const char - nome do arquivo do qual os dados serao lidos
   - elemento: ponteiro para Elemento - elemento com os dados que serao procurados no arquivo
   - procura: ponteiro para Elemento - elemento que armazenara os dados lidos do arquivo
Retorno:
   - false se o elemento nao foi lido
   - true se o elemento foi lido
*/
bool CRUD::ler (const char * arquivo, Elemento* elemento, Elemento* procura) {
   bool achou;
   ifstream entrada;
   Elemento* busca;
   entrada.open(arquivo, ios::in|ios::binary);
   achou = false;
   if (entrada.is_open()) {
      while (!entrada.eof() && !achou) {
         entrada.read(reinterpret_cast<char *>(&busca), sizeof(Elemento*));
         if (busca==elemento) {
            achou = true;
         }
      }
      if (achou) {
         procura->setNome(busca->getNome());
         procura->setDensidade(busca->getDensidade());
         procura->setEstado(busca->getEstado());
         procura->setGrupo(busca->getGrupo());
         procura->setMassa(busca->getMassa());
         procura->setNumeroAtomico(busca->getNumeroAtomico());
         procura->setPeriodo(busca->getPeriodo());
         procura->setPontoEbuilcao(busca->getPontoEbulicao());
         procura->setPontoFusao(busca->getPontoFusao());
         procura->setSimbolo(busca->getSimbolo());
         procura->setSubclassificacao(busca->getSubclassificacao());
         if (procura->getTipo()) {   
            (dynamic_cast<Metal*>(procura))->setCondutividadeEletrica((dynamic_cast<Metal*>(busca))->getCondutividadeEletrica());
            (dynamic_cast<Metal*>(procura))->setCondutividadeTermica((dynamic_cast<Metal*>(busca))->getCondutividadeTermica());
            (dynamic_cast<Metal*>(procura))->setTemperaturaCondutividade((dynamic_cast<Metal*>(busca))->getTemperaturaCondutividade());
         } else {
            (dynamic_cast<Ametal*>(procura))->setFragmentabilidade((dynamic_cast<Ametal*>(busca))->getFragmentabilidade());
         }
         entrada.close();
         return true;
      } else {
         procura = NULL;
         entrada.close();
         return false;
      }
   } else {
      cout << "Nao foi possivel abrir o arquivo \"" << arquivo << "\"" << endl;
      entrada.close();
      return false;
   }
}