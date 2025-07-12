#include "Pilha.c"
#include <time.h>
#include <unistd.h>

char determinarCor(int n) {
    if (n == 1) {
        return 'P';
    } else if (n == 2) {
        return  'V';
    } else if (n == 3) {
        return 'A';
    } else if (n == 4) {
        return 'R';
    } else {
        return ' ';
    }
}

int estaDuplicado(int* array, int ultimoIndex, int valor) {

    for (int i = 0; i < ultimoIndex; i++) {
        if (array[i] == valor) {
            return 1;
        }
    }

    return 0;
}

int* geraQuatroRandom() {
    
    int* random = (int*)malloc(4 * sizeof(int));

    srand(time(0));
    int n = 4;

    for (size_t i = 0; i < 4; i++) {
        int aux;

        do {
            aux = rand() % n + 1;
        } while (estaDuplicado(random, i, aux));

        random[i] = aux;
    }
    
    return random;

}
 
Pilha* randomizarPilha() {
    Pilha* p = criaPilha();
    int* random = geraQuatroRandom();
    sleep(1);

    for (size_t f = 0; f < 4; f++) {

        push(p, criarArgola(determinarCor(random[f])));

    }

    return p;
}

void toString(Pilha* pilha, Pilha* pilha2, Pilha* pilha3, Pilha* pilha4, Pilha* pilha5, Pilha* pilha6) {
    Pilha* pilhas[4] = {pilha, pilha2, pilha3, pilha4};

    char matrizPilha[4][5];

    if(pilha5 != NULL && pilha6 != NULL) {
        printf("\nAuxiliar 1: %c\nAuxiliar 2: %c\n\n", pilha5->topo->cor, pilha6->topo->cor);
    } else if (pilha5 != NULL || pilha6 != NULL) {
        Pilha* aux;

        if (pilha5 != NULL) {
            aux = pilha5;
        } else {
        aux = pilha6;
        }

        printf("Auxiliar: %c\n\n", aux->topo->cor);
    }

    for (size_t i = 0; i < sizeof(pilhas)/sizeof(pilhas[0]); i++)
    {
        Argola* aux = pilhas[i]->topo;

        for (size_t j = 0; j <= sizeof(pilhas)/sizeof(pilhas[0]); j++)
        {
            if (aux != NULL){
                matrizPilha[i][j] = aux->cor;
                aux = aux->proximo;

            } else {
                matrizPilha[i][j] = '%';
            }
        }
    }
    
    for (size_t i = 0; i < sizeof(pilhas)/sizeof(pilhas[0]); i++)
    {
        printf("\n");
        for (size_t j = 0; j < sizeof(matrizPilha[i])/sizeof(matrizPilha[i][0]); j++)
        {
            printf(" %c ", matrizPilha[i][j]);
        }
    }
    
    printf("\n");
}

void movimentar(Pilha* alvo, Pilha* destino) {
    //testar qts argolas tem na pilha
    if (destino->qtd >= 5) {
        printf("\nPilha destino já possui o número máximo de argolas\n");
    } else {
        push(destino, pop(alvo));
    }
}

void verificarVitoria(Pilha* pilha, Pilha* pilha2, Pilha* pilha3, Pilha* pilha4) {
    // Array para armazenar a cor de cada pilha
    Pilha* pilhas[4] = {pilha, pilha2, pilha3, pilha4};
    char cores[4] = {0};
    
    // Verificar cada pilha
    for (int i = 0; i < 4; i++) {
        if (pilhas[i]->topo == NULL) {
            // Pilha vazia - não é vitória
            return;
        }
        
        // Pegar a cor do topo como referência
        char cor_referencia = pilhas[i]->topo->cor;
        Argola* atual = pilhas[i]->topo;
        
        // Verificar todas as argolas na pilha
        while (atual != NULL) {
            if (atual->cor != cor_referencia) {
                // Cor diferente encontrada - não é vitória
                return;
            }
            atual = atual->proximo;
        }
        
        // Armazenar a cor desta pilha
        cores[i] = cor_referencia;
    }
    
    // Verificar se todas as 4 pilhas têm cores diferentes entre si
    for (int i = 0; i < 4; i++) {
        for (int j = i + 1; j < 4; j++) {
            if (cores[i] == cores[j]) {
                // Cores iguais em pilhas diferentes - não é vitória
                return;
            }
        }
    }
    
    // Se chegou aqui, o jogador venceu!
    printf("\nPARABÉNS! VOCÊ VENCEU!\n");
    printf("Todas as pilhas estão organizadas corretamente:\n");

    // Mostrar o estado final
    toString(pilhas[0], pilhas[1], pilhas[2], pilhas[3], NULL, NULL);
    
    exit(0); // Termina o programa
}

void mostrarMenu() {
    printf("\n=== MENU ===\n");
    printf("1. Mover argola (movimentar)\n");
    printf("2. Sair\n");
    printf("============\n");
    printf("Escolha uma opção: ");
}

void mostrarDificuldades() {
    printf("\n=== DIFICULDADE ===\n");
    printf("1. Facil\n");
    printf("2. Medio\n");
    printf("3. Dificil\n");
    printf("==================\n");
    printf("Escolha a dificuldade: ");
}
