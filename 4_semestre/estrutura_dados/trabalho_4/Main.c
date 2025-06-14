#include "Pilha.c"
#include <stdio.h>

void toString(Pilha* p, Pilha* p2, Pilha* p3) {
    Pilha aux = *p;
    Pilha aux2 = *p2;
    Pilha aux3 = *p3;

    while(aux.qtd > 0) {
        printf("| %c | %c | %c |\n", aux.topo->cor, aux2.topo->cor, aux3.topo->cor);
        pop(&aux);
        pop(&aux2);
        pop(&aux3);
    }
}

int main() {

    Pilha* p = criaPilha();

    push(p, criarArgola('P'));
    push(p, criarArgola('A'));
    push(p, criarArgola('V'));

    Pilha* p2 = criaPilha();

    push(p2, criarArgola('V'));
    push(p2, criarArgola('P'));
    push(p2, criarArgola('V'));

    Pilha* p3 = criaPilha();

    push(p3, criarArgola('V'));
    push(p3, criarArgola('A'));
    push(p3, criarArgola('P'));

    toString(p, p2, p3);
}