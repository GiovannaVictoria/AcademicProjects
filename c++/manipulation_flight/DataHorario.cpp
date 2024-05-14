#include "DataHorario.h"

/*
Construtor da classe DataHorario
parametros: 6 inteiros, relativos a data e ao horario
*/
DataHorario::DataHorario(int dia, int mes, int ano, int segundo, int minuto, int hora) {
   bool errado = false;
   // verificacao da validade da data
   if (dia>31 || mes>12) { // em qualquer caso em que o dia eh maior que 31 ou que o mes eh maior que 12, a data nao existe
      errado = true;
   } else if (dia==31) { // se tiver 31 dias, alguns meses em especifico nao sao validos
      if (mes==2 || mes==4 || mes==6 || mes==9 || mes==11) {
         errado = true;
      }
   } else if (dia==30 && mes==2) { // se tiver 30 dias, nao pode ser fevereiro
      errado = true;
   } else if (dia==29 && mes==2) { // se tiver 29 dias, precisa verificar se o ano eh bissexto
      if (!(ano%400==0 || ( ano%4==0 && !(ano%100==0 && ano%400!=0) ))) {
         errado = true;
      }
   }
   // verificacao da validade do horario
   if (segundo>59 || minuto>59 || hora>23) { // em qualquer caso que o segundo/minuto eh maior que 59 ou a hora eh maior que 23, o horario nao existe
      errado = true;
   }
   // se for invalido, seta pra outro valido
   if (errado) {
      this->dia = 1;
      this->mes = 1;
      this->ano = 1;
      this->segundo = 0;
      this->minuto = 0;
      this->hora = 0;
   } else {
      this->dia = dia;
      this->mes = mes;
      this->ano = ano;
      this->segundo = segundo;
      this->minuto = minuto;
      this->hora = hora;
   }
}

/*
Destrutor da classe DataHorario
*/
DataHorario::~DataHorario() {}

/*
nome: compara
objetivo: comparar duas datas
parametros:
   - objeto da classe DataHorario
retorno:
   - -1 se a data corrente for menor que a data do objeto
   - 0 se as duas datas forem iguais
   - 1 se a data corrente for maior que a data do objeto
*/
int DataHorario::compara (DataHorario& outra) {
   if (this->ano>outra.getAno()) {
      return 1;
   } else if (this->ano<outra.getAno()) {
      return -1;
   } else {
      if (this->mes>outra.getMes()) {
         return 1;
      } else if (this->mes<outra.getMes()) {
         return -1;
      } else {
         if (this->dia>outra.getDia()) {
            return 1;
         } else if (this->dia<outra.getDia()) {
            return -1;
         } else {
            if (this->hora>outra.getHora()) {
               return 1;
            } else if (this->hora<outra.getHora()) {
               return -1;
            } else {
               if (this->minuto>outra.getMinuto()) {
                  return 1;
               } else if (this->minuto<outra.getMinuto()) {
                  return -1;
               } else {
                  if (this->segundo>outra.getSegundo()) {
                     return 1;
                  } else if (this->segundo<outra.getSegundo()) {
                     return -1;
                  } else {
                     return 0;
                  }
               }
            }
         }
      }
   }
}

/*
Getter do parametro "ano"
*/
int DataHorario::getAno() const {
   return this->ano;
}

/*
Getter do parametro "mes"
*/
int DataHorario::getMes() const {
   return this->mes;
}

/*
Getter do parametro "dia"
*/
int DataHorario::getDia() const {
   return this->dia;
}

/*
Getter do parametro "hora"
*/
int DataHorario::getHora() const {
   return this->hora;
}

/*
Getter do parametro "minuto"
*/
int DataHorario::getMinuto() const {
   return this->minuto;
}

/*
Getter do parametro "segundo"
*/
int DataHorario::getSegundo() const {
   return this->segundo;
}

/*
nome: imprime
objetivo: imprimir a data no formato DD/MM/AAAA hh:mm:ss [AM/PM]
parametros:
   - boolean indicando se o formato eh de 12 horas
retorno: nao ha
*/
void DataHorario::imprime(bool AM) {
   cout << setfill('0') << setw(2) << this->dia << "/";
   cout << setfill('0') << setw(2) << this->mes << "/";
   cout << setfill('0') << setw(4) << this->ano << " ";
   if (AM && this->hora>12) {
      cout << setfill('0') << setw(2) << this->hora-12 << ":";
   } else {
      cout << setfill('0') << setw(2) << this->hora << ":";
   }
   cout << setfill('0') << setw(2) << this->minuto << ":";
   cout << setfill('0') << setw(2) << this->segundo;
   if (AM) {
      if (this->hora>12) {
         cout << " PM";
      } else {
         cout << " AM";
      }
   }
   cout << endl;
}

/*
nome: imprimePorExtenso
objetivo: imprimir a data por extenso
parametros: nao ha
retorno: nao ha
*/
void DataHorario::imprimePorExtenso() {
   string meses[12] = {"Janeiro", "Fevereiro",
                       "Março", "Abril", "Maio",
                       "Junho", "Julho", "Agosto",
                       "Setembro", "Outubro",
                       "Novembro", "Dezembro"};
   cout << setfill('0') << setw(2) << this->dia << " de ";
   cout << meses[this->mes-1] << " de ";
   cout << setfill('0') << setw(4) << this->ano << " - ";
   cout << setfill('0') << setw(2) << this->hora;
   if (this->hora==1) {
      cout << " hora, ";
   } else {
      cout << " horas, ";
   }
   cout << setfill('0') << setw(2) << this->minuto;
   if (this->minuto==1) {
      cout << " minuto e ";
   } else {
      cout << " minutos e ";
   }
   cout << setfill('0') << setw(2) << this->segundo;
   if (this->segundo==1) {
      cout << " segundo.";
   } else {
      cout << " segundos.";
   }
   cout << endl;
}

/*
duvidas:
   classe DataHorario:
      - construtor: as datas e horarios errados devem ser tratados separados ou juntos?
      - os getters tem que ser const?
      - no imprimePorExtenso, é preciso imprimir os dias, horas, minutos e segundos com 2 digitos e anos com 4 (preenchendo com 0s), ou nao?
      - as outras classes nao precisam de destrutor?
*/