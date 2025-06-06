#include "Argola.c"
#include <stddef.h>

typedef struct pilha {
    Argola* topo;
    int qtd;
} Pilha;

Pilha* criaPilha() {
    Pilha* p = (Pilha*)malloc(sizeof(Pilha));
    p->topo = NULL;
    p->qtd = 0;
    return p;
}

void push(Pilha* p, Argola* argola) {
    argola->proximo = p->topo;
    p->topo = argola;
    p->qtd++;

}

Argola* pop(Pilha* p) {
    Argola* aux = p->topo;
    if(aux != NULL){
        p->topo = aux->proximo;
        p->qtd--;
        aux->proximo = NULL;
    }
    return aux;
}