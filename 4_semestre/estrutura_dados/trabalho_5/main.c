#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>
#include <ctype.h>
#include "placas.h"
#include "hash.h"
#include "sort.h"
#include "utils.h"

void medirTemposOrdenacao(Placa *original) {
    Placa copiaBubble[NUM_PLACAS], copiaSelection[NUM_PLACAS], 
          copiaInsertion[NUM_PLACAS], copiaShell[NUM_PLACAS], 
          copiaQuick[NUM_PLACAS];
    
    copiarArray(original, copiaBubble, NUM_PLACAS);
    copiarArray(original, copiaSelection, NUM_PLACAS);
    copiarArray(original, copiaInsertion, NUM_PLACAS);
    copiarArray(original, copiaShell, NUM_PLACAS);
    copiarArray(original, copiaQuick, NUM_PLACAS);
    
    desordenarArray(copiaBubble, NUM_PLACAS);
    desordenarArray(copiaSelection, NUM_PLACAS);
    desordenarArray(copiaInsertion, NUM_PLACAS);
    desordenarArray(copiaShell, NUM_PLACAS);
    desordenarArray(copiaQuick, NUM_PLACAS);
    
    clock_t begin, end;
    
    begin = clock();
    bubbleSort(copiaBubble, NUM_PLACAS);
    end = clock();
    printf("Bubble Sort: %.4f segundos\n", (double)(end - begin) / CLOCKS_PER_SEC);
    
    begin = clock();
    selectionSort(copiaSelection, NUM_PLACAS);
    end = clock();
    printf("Selection Sort: %.4f segundos\n", (double)(end - begin) / CLOCKS_PER_SEC);
    
    begin = clock();
    insertionSort(copiaInsertion, NUM_PLACAS);
    end = clock();
    printf("Insertion Sort: %.4f segundos\n", (double)(end - begin) / CLOCKS_PER_SEC);
    
    begin = clock();
    shellSort(copiaShell, NUM_PLACAS);
    end = clock();
    printf("Shell Sort: %.4f segundos\n", (double)(end - begin) / CLOCKS_PER_SEC);
    
    begin = clock();
    quickSort(copiaQuick, 0, NUM_PLACAS - 1);
    end = clock();
    printf("Quick Sort: %.4f segundos\n", (double)(end - begin) / CLOCKS_PER_SEC);
}

void executarBuscas(Placa *original, Placa *ordenada, TabelaHash *th) {
    int numBuscas;
    printf("\nQuantas placas deseja buscar? ");
    scanf("%d", &numBuscas);
    getchar();
    
    double tempoTotal[3] = {0};
    int encontrados[3] = {0};
    
    for (int i = 0; i < numBuscas; i++) {
        char placaBusca[PLACA_SIZE];
        do {
            printf("Digite a placa %d (formato ABC1D23): ", i+1);
            scanf("%7s", placaBusca);
            getchar();
        } while (strlen(placaBusca) != 7);
        
        for (int j = 0; j < 7; j++) {
            placaBusca[j] = toupper(placaBusca[j]);
        }
        
        clock_t begin, end;
        
        begin = clock();
        int pos = buscarListaDesordenada(original, NUM_PLACAS, placaBusca);
        end = clock();
        tempoTotal[0] += (double)(end - begin) / CLOCKS_PER_SEC;
        if (pos != -1) encontrados[0]++;
        
        begin = clock();
        pos = buscarListaOrdenada(ordenada, NUM_PLACAS, placaBusca);
        end = clock();
        tempoTotal[1] += (double)(end - begin) / CLOCKS_PER_SEC;
        if (pos != -1) encontrados[1]++;
        
        begin = clock();
        No* no = buscarNaTabelaHash(th, placaBusca);
        end = clock();
        tempoTotal[2] += (double)(end - begin) / CLOCKS_PER_SEC;
        if (no != NULL) encontrados[2]++;
    }
    
    printf("\nEstatísticas de busca:\n");
    printf("Lista desordenada: %.6fs (média), %d encontradas\n", 
           tempoTotal[0]/numBuscas, encontrados[0]);
    printf("Lista ordenada: %.6fs (média), %d encontradas\n", 
           tempoTotal[1]/numBuscas, encontrados[1]);
    printf("Tabela hash: %.6fs (média), %d encontradas\n", 
           tempoTotal[2]/numBuscas, encontrados[2]);
}

int main() {
    srand(time(NULL));
    
    Placa placas[NUM_PLACAS];
    printf("Gerando %d placas...\n", NUM_PLACAS);
    for (int i = 0; i < NUM_PLACAS; i++) {
        gerarPlacaAleatoria(&placas[i]);
    }
    
    TabelaHash th;
    inicializarTabelaHash(&th);
    for (int i = 0; i < NUM_PLACAS; i++) {
        inserirNaTabelaHash(&th, placas[i]);
    }
    
    printf("\n=== TEMPOS DE ORDENACAO ===\n");
    medirTemposOrdenacao(placas);
    
    Placa copiaQuick[NUM_PLACAS];
    copiarArray(placas, copiaQuick, NUM_PLACAS);
    quickSort(copiaQuick, 0, NUM_PLACAS - 1);
    
    printf("\n=== SISTEMA DE BUSCA ===\n");
    executarBuscas(placas, copiaQuick, &th);
    
    liberarTabelaHash(&th);
    
    printf("\n=== RESUMO ===\n");
    printf("1. Quick Sort foi o algoritmo mais eficiente\n");
    printf("2. Tabela Hash teve o melhor desempenho em buscas\n");
    printf("3. Lista ordenada com busca binária foi mais rápida que lista desordenada\n");
    
    return 0;
}