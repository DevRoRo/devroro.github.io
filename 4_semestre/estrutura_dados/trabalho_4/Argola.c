#include <stdlib.h>

typedef struct argola {
    char cor;
    struct argola* proximo;
} Argola;

Argola* criarArgola(char cor){
    Argola* aux = malloc(sizeof(Argola));
    aux->cor = cor;

    return aux;
}