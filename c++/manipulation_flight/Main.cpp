#include "Aluno.h"
#include "DataHorario.h"
#include "Voo.h"
#include "Pessoa.h"
#include <iomanip>
#include <iostream>
#include <string>
#include <sstream>

using namespace std;

void imprimeDatas(DataHorario& d1, DataHorario& d2) {

    stringstream ss1;
    ss1 << setfill('0') << setw(2) << d1.getDia();
    ss1 << "/";
    ss1 << setfill('0') << setw(2) << d1.getMes();
    ss1 << "/";
    ss1 << setfill('0') << setw(4) << d1.getAno();
    ss1 << " ";
    ss1 << setfill('0') << setw(2) << d1.getHora();
    ss1 << ":";
    ss1 << setfill('0') << setw(2) << d1.getMinuto();
    ss1 << ":";
    ss1 << setfill('0') << setw(2) << d1.getSegundo();

    stringstream ss2;
    ss2 << setfill('0') << setw(2) << d2.getDia();
    ss2 << "/";
    ss2 << setfill('0') << setw(2) << d2.getMes();
    ss2 << "/";
    ss2 << setfill('0') << setw(4) << d2.getAno();
    ss2 << " ";
    ss2 << setfill('0') << setw(2) << d2.getHora();
    ss2 << ":";
    ss2 << setfill('0') << setw(2) << d2.getMinuto();
    ss2 << ":";
    ss2 << setfill('0') << setw(2) << d2.getSegundo();

    int cmp = d1.compara(d2);
    if (cmp > 0) {
        cout << ss1.str() << " > " << ss2.str() << endl;
    } else if (cmp < 0) {
        cout << ss1.str() << " < " << ss2.str() << endl;
    } else {
        cout << ss1.str() << " == " << ss2.str() << endl;
    }
}

int main() {

    cout << "=================== Ex 1 ===================" << endl;

    Pessoa p1("920.160.912-40", "Bianca Débora Sara da Rocha");
    Pessoa p2("522.924.726-60", "Mário Benício Rodrigues");
    p1.imprime();
    p2.imprime(); 
    
    cout << "=================== Ex 2 ===================" << endl;
    
    Aluno aluno1("700.879.680-37", "Manuela Stefany Giovanna da Rosa", 13579, 7, 7, 7);
    Aluno aluno2("767.692.493-67", "Renato Enrico Melo", 24680, 8, 8, 0);
    Aluno aluno3("287.624.030-01", "Raquel Milena da Luz", 12345, 3, 4, 5);

    cout << "---------------------------------" << endl;
    aluno1.imprime();
    
    cout << "---------------------------------" << endl;
    aluno2.imprime();
    
    cout << "---------------------------------" << endl;
    aluno3.imprime();
    
    cout << "=================== Ex 3 ===================" << endl;
    
    DataHorario data1(1, 1, 2022, 10, 0, 0);
    DataHorario data2(2, 2, 2022, 10, 0, 0);

    data1.imprime(false);
    data2.imprime(false);

    imprimeDatas(data1, data2);
    imprimeDatas(data2, data1);
    imprimeDatas(data1, data1);
    imprimeDatas(data2, data2);

    cout << "---------------------------------" << endl;
    
    for (int i = 1; i <= 12; i++) {
        DataHorario* d = new DataHorario(1, i, 2022, 10, 0, 0);
        d->imprimePorExtenso();
        delete d;
    }

    cout << "=================== Ex 4 ===================" << endl;
    
    Voo voo(1, data1);
    
    voo.imprime();
    
    int vaga;

    vaga = voo.proximoLivre();
    cout << "ocupa: " << (voo.ocupa(vaga, p1)? "true" : "false") << endl;
    cout << "ocupa: " << (voo.ocupa(vaga, p1)? "true" : "false") << endl;
    vaga = voo.proximoLivre();
    cout << "ocupa: " << (voo.ocupa(vaga, aluno1)? "true" : "false") << endl;
    cout << "ocupa: " << (voo.ocupa(vaga, aluno1)? "true" : "false") << endl;
    vaga = voo.proximoLivre();
    cout << "ocupa: " << (voo.ocupa(vaga, aluno3)? "true" : "false") << endl;
    cout << "ocupa: " << (voo.ocupa(vaga, aluno3)? "true" : "false") << endl;
    
    voo.imprime();
    
    cout << "desocupa: " << (voo.desocupa(4)? "true" : "false") << endl;
    cout << "desocupa: " << (voo.desocupa(3)? "true" : "false") << endl;
    cout << "desocupa: " << (voo.desocupa(3)? "true" : "false") << endl;
    cout << "desocupa: " << (voo.desocupa(2)? "true" : "false") << endl;
    cout << "desocupa: " << (voo.desocupa(2)? "true" : "false") << endl;
    cout << "desocupa: " << (voo.desocupa(1)? "true" : "false") << endl;
    cout << "desocupa: " << (voo.desocupa(1)? "true" : "false") << endl;
    
    voo.imprime();
    return 0;
}

