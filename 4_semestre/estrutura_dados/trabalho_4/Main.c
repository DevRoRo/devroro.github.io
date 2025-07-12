#include <stdio.h>
#include "Regras.c"
#include "time.h"

void mostrarMenuPrincipal() {
    printf("\n=== MENU ===\n");
    printf("1. Mover argola\n");
    printf("2. Sair\n");
    printf("============\n");
    printf("Escolha uma opcao: ");
}

int main() {
    int dificuldade;
    mostrarDificuldades();
    scanf("%d", &dificuldade);

    Pilha* pilhas[6] = {NULL};
    int numPilhas = 4;

    for (size_t i = 0; i < 4; i++) {
        pilhas[i] = randomizarPilha();
    }

    switch (dificuldade) {
        case 1:
            pilhas[4] = criaPilha();
            pilhas[5] = criaPilha();
            pilhas[4]->topo = criarArgola(' ');
            pilhas[5]->topo = criarArgola(' ');
            numPilhas = 6;
            break;
        case 2:
            pilhas[4] = criaPilha();
            pilhas[4]->topo = criarArgola(' ');
            numPilhas = 5;
            break;
        case 3:
            numPilhas = 4;
            break;
        default:
            printf("Opcao invalida! Usando dificuldade padrao (Dificil).\n");
            numPilhas = 4;
    }

    int opcao;
    int origem, destino;

    do {
        toString(pilhas[0], pilhas[1], pilhas[2], pilhas[3], pilhas[4], pilhas[5]);
        mostrarMenuPrincipal();
        scanf("%d", &opcao);

        switch (opcao) {
           
            case 1:

                printf("\nDigite a pilha de origem (1-%d): ", numPilhas);
                scanf("%d", &origem);
                printf("Digite a pilha de destino (1-%d): ", numPilhas);
                scanf("%d", &destino);

                origem--;
                destino--;

                if (origem < 0 || origem >= numPilhas || destino < 0 || destino >= numPilhas) {
                    printf("Numero de pilha invalido!\n");
                    break;
                } else if (origem >=5 && destino >= 5) {
                    printf("Não pode mover entre auxiliares");
                    break;
                }

                if (origem == destino) {
                    printf("Nao pode mover para a mesma pilha!\n");
                } else {
                    movimentar(pilhas[origem], pilhas[destino]);
                    verificarVitoria(pilhas[0], pilhas[1], pilhas[2], pilhas[3]);
                }
                break;

            case 2:
                printf("Saindo...\n");
                break;

            default:
                printf("Opcao invalida!\n");
        }

    } while (opcao != 2);

    return 0;
}