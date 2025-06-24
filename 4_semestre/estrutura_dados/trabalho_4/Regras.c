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
    } else {
        return 'R';
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
    } // Jeito que o deepseek sugeriu fazer com base no código que eu fiz sozinho
    

/*     for (size_t i = 0; i < 4; i++) {

        if (i == 0) {

            random[i] = rand() % n + 1;

        } else if (i == 1) {

            do {

                random[i] = rand() % n + 1;

            } while (random[i] == random[i-1]);

        } else if (i == 2) {

            do {

                random[i] = rand() % n + 1;

            } while (random[i] == random[i-1] || random [i] == random[i-2]);

        } else if (i == 3) {

            do {

                random[i] = rand() % n + 1;

            } while (random[i] == random[i-1] || random [i] == random[i-2] || random[i] == random[i-3]);

        } else {

            do {

                random[i] = rand() % n + 1;

            } while (random[i] == random[i-1] || random [i] == random[i-2] || random[i] == random[i-3] || random[i] == random[i-4]);

        }
    }  jeito que eu fiz sozinho*/
    
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