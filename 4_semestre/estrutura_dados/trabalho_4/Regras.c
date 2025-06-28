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
    }  // Jeito que o deepseek sugeriu fazer com base no código que eu fiz sozinho

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

void movimentar(Pilha* pilha1, Pilha* pilha2) {
    Argola* aux = pop(pilha1);
    push(pilha2, aux);
    push(pilha1, criarArgola(determinarCor(5)));
}