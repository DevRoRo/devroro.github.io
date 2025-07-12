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
 
Pilha* criarTabuleiro() {
    Pilha* pArray = (Pilha*)malloc(4 * sizeof(Pilha));
    int* random;

    for (size_t i = 0; i < 4; i++) {
        pArray[i] = *criaPilha();
        sleep(1);
        random = geraQuatroRandom();

        for (size_t f = 0; f < 4; f++) {
    
            push(&pArray[i], criarArgola(determinarCor(random[f])));

        }
    }
    
    return pArray;
}

int movimentar(Pilha* pilha1, Pilha* pilha2) {
    // Check if source stack is empty
    if (pilha2->topo == NULL) {
        printf("Erro: Pilha de origem vazia!\n");
        return 0;
    }
    
    // Check if destination stack already has 4 members
    if (pilha1->qtd >= 4) {
        printf("Erro: Pilha de destino ja tem 4 argolas (limite maximo)!\n");
        return 0;
    }
    
    // Perform the move
    Argola* argola = pop(pilha2);
    push(pilha1, argola);
    return 1;
}

int verificarVitoria(Pilha* pArray) {
    char target_cor = ' ';
    
    // Check each of the 4 main piles
    for (int i = 0; i < 4; i++) {
        // Pile must have exactly 4 argolas
        if (pArray[i].qtd != 4) {
            return 0;
        }
        
        // All argolas in the pile must be the same color
        Argola* current = pArray[i].topo;
        char pile_color = current->cor;
        
        // Check if all argolas in this pile have the same color
        while (current != NULL) {
            if (current->cor != pile_color) {
                return 0;
            }
            current = current->proximo;
        }
        
        // For the first pile, set the target color
        if (i == 0) {
            target_cor = pile_color;
        }
        // For other piles, check if they match the first pile's color
        else if (pile_color != target_cor) {
            return 0;
        }
    }
    
    return 1; // All conditions met
}