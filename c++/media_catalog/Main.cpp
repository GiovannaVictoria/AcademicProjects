#include <cstdlib>

#include "CD.h"
#include "DVD.h"
#include "Catalogo.h"
#include "Jogo.h"

using namespace std;
using namespace catalogo;

void realizaTestes() {
    CD *cd1, *cd2;
    DVD *dvd1, *dvd2;
    Jogo *jogo1, *jogo2;
    Catalogo *catalogo;

    cd1 = new CD("X & Y", 2005, "Cold Play");
    cd1->adicionaFaixa("Square One", 287); // 4:47
    cd1->adicionaFaixa("What If", 297); // 4:57
    cd1->adicionaFaixa("White Shadows", 328); // 5:28
    cd1->adicionaFaixa("Fix You", 294); // 4:54
    cd1->adicionaFaixa("Talk", 311); // 5:11
    cd1->adicionaFaixa("X&Y", 274); // 4:34

    dvd1 = new DVD("O Senhor dos Anéis - A Sociedade dos Anel", 2001,
            "Peter Jacson");
    dvd1->adicionaArtista("Elijah Wood", "Frodo Baggins");
    dvd1->adicionaArtista("Viggo Mortensen", "Aragorn");
    dvd1->adicionaArtista("Orlando Bloom", "Legolas Greenleaf");
    dvd1->adicionaArtista("Christopher Lee", "Saruman");
    dvd1->adicionaArtista("Ian McKellen", "Gandalf");

    jogo1 = new Jogo("Need For Speed - Underground II", 2005, "Corrida");

    cd2 = new CD("Bachianas Brasileiras No.2", 2004,
            "Orquestra de Câmara da Universidade de São Paulo");
    cd2->adicionaFaixa("(Prelúdio) O Canto do Capadócio", 512); // 4:32
    cd2->adicionaFaixa("(Ária) O Canto da Nossa Terra", 389); // 6:29
    cd2->adicionaFaixa("(Dança) Lembranca do Sertão", 324); // 5:24
    cd2->adicionaFaixa("(Tocata) O Trenzinho do Caipira", 284); // 4:44

    dvd2 = new DVD("Matrix", 1999, "Andy & Larry Wachoski");
    dvd2->adicionaArtista("Keanu Reeves", "Neo");
    dvd2->adicionaArtista("Laurence Fishburne", "Morpheus");
    dvd2->adicionaArtista("Carrie-Anne Moss", "Trinity");
    dvd2->adicionaArtista("Hugo Weaving", "Agente Smith");
    dvd2->adicionaArtista("Gloria Foster", "Óraculo");

    jogo2 = new Jogo("Fifa 2008", 2008, "Esporte");

    // Criar uma classe cadastro e tenta buscar uma midia na lista vazia

    catalogo = new Catalogo();

    // adiciona 6 midias

    catalogo->adicionaMidia(*cd1);
    catalogo->adicionaMidia(*dvd1);
    catalogo->adicionaMidia(*jogo1);
    catalogo->adicionaMidia(*cd2);
    catalogo->adicionaMidia(*dvd2);
    catalogo->adicionaMidia(*jogo2);

    catalogo->imprimeColecao();
    cout << "-------------------------------------" << endl;
    catalogo->imprimeColecaoPorTipo(1);
    cout << "-------------------------------------" << endl;
    catalogo->imprimeColecaoPorTipo(2);
    cout << "-------------------------------------" << endl;
    catalogo->imprimeColecaoPorTipo(3);
    cout << "-------------------------------------" << endl;

    if (cd1 != catalogo->obtemMidia("X & Y")) {
        throw 1;
    }

    if (dvd1 != catalogo->obtemMidia("O Senhor dos Anéis - A Sociedade dos Anel")) {
        throw 2;
    }

    if (jogo1 != catalogo->obtemMidia("Need For Speed - Underground II")) {
        throw 3;
    }

    if (cd2 != catalogo->obtemMidia("Bachianas Brasileiras No.2")) {
        throw 4;
    }

    if (dvd2 != catalogo->obtemMidia("Matrix")) {
        throw 5;
    }
    
    if (jogo2 != catalogo->obtemMidia("Fifa 2008")) {
        throw 6;
    }    

    // Verificando lista (todos)

    if (catalogo->quantidadeDeMidias() != 6) {
        throw 7;
    }

    // Verificando lista (seleciona pelo tipo - CD de música - implementada
    // pela classe CD)
    
    if (catalogo->quantidadeDeCDs() != 2) {
        throw 8;
    }

    // Verificando lista (seleciona pelo tipo - DVD de filme - implementada
    // pela classe DVD)

    if (catalogo->quantidadeDeDVDs() != 2) {
        throw 9;
    }

    // Verificando lista (seleciona pelo tipo - Jogo Eletrônico -
    // implementada pela classe Jogo)

    if (catalogo->quantidadeDeJogos() != 2) {
        throw 10;
    }

    catalogo->removeMidia(cd2->getTitulo());

    // Verificando lista (seleciona pelo tipo - CD de música - implementada
    // pela classe CD)
    
    if (catalogo->quantidadeDeCDs() != 1) {
        throw 11;
    }

    catalogo->removeMidia(dvd2->getTitulo());
    
    // Verificando lista (seleciona pelo tipo - DVD de filme - implementada
    // pela classe DVD)
    
    if (catalogo->quantidadeDeDVDs() != 1) {
        throw 12;
    }

    catalogo->removeMidia(jogo2->getTitulo());
    
    // Verificando lista (seleciona pelo tipo - Jogo Eletrônico -
    // implementada pela classe Jogo)
    
    if (catalogo->quantidadeDeJogos() != 1) {
        throw 13;
    }
    
    cout << "Testes executados com sucesso !!" << endl;

    cout << endl;

    delete cd1;
    delete cd2;
    delete dvd1;
    delete dvd2;
    delete jogo1;
    delete jogo2;
    delete catalogo;
}

int main() {
    try {
        realizaTestes();
    } catch (int e) {
        cout << "Uma exceção ocorreu. Exceção Nr. " << e << '\n';
    }
}

