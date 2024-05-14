#include "Cesar.h"

using namespace cifra;

int main() {
    Cesar cesar;
    cesar.encripte("entrada.txt", "saida.txt", 10);
    //cesar.encripte("encriptado.txt", "saida.txt", -6);
    return 0;
}

