#include <stdio.h>
#include "Regras.c"

void toString(Pilha* p, Pilha* p2, Pilha* p3, Pilha* p4, Pilha* p5, Pilha* p6) {
    Pilha aux = *p;
    Pilha aux2 = *p2;
    Pilha aux3 = *p3;
    Pilha aux4 = *p4;

    printf("| %c |               | %c |\n\n", p5->topo->cor, p6->topo->cor);

    while(aux.qtd > 0) {
        printf("    | %c | %c | %c | %c |\n", aux.topo->cor, aux2.topo->cor, aux3.topo->cor, aux4.topo->cor);
        pop(&aux);
        pop(&aux2);
        pop(&aux3);
        pop(&aux4);
    }
}

int main() {

    Pilha* p5 = criaPilha();

    push(p5, criarArgola(' '));

    Pilha* p6 = criaPilha();

    push(p6, criarArgola(' '));

    Pilha* pArray = criarTabuleiro();

    toString(&pArray[0], &pArray[1], &pArray[2], &pArray[3], p5, p6);

}