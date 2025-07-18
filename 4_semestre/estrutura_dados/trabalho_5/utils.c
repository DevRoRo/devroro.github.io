#include "utils.h"
#include <stdlib.h>
#include <string.h>
#include <ctype.h>
#include <time.h>

void gerarPlacaAleatoria(Placa *p) {
    for (int i = 0; i < 3; i++) {
        p->placa[i] = 'A' + rand() % 26;
    }
    p->placa[3] = '0' + rand() % 10;
    p->placa[4] = 'A' + rand() % 26;
    p->placa[5] = '0' + rand() % 10;
    p->placa[6] = '0' + rand() % 10;
    p->placa[7] = '\0';
}

void copiarArray(Placa *orig, Placa *dest, int n) {
    for (int i = 0; i < n; i++) {
        strcpy(dest[i].placa, orig[i].placa);
    }
}

void desordenarArray(Placa *arr, int n) {
    for (int i = n - 1; i > 0; i--) {
        int j = rand() % (i + 1);
        Placa temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

int buscarListaDesordenada(Placa *arr, int n, const char *placa) {
    for (int i = 0; i < n; i++) {
        if (strcmp(arr[i].placa, placa) == 0) {
            return i;
        }
    }
    return -1;
}

int buscarListaOrdenada(Placa *arr, int n, const char *placa) {
    int left = 0;
    int right = n - 1;
    
    while (left <= right) {
        int mid = left + (right - left) / 2;
        int cmp = strcmp(arr[mid].placa, placa);
        
        if (cmp == 0) {
            return mid;
        } else if (cmp < 0) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }
    
    return -1;
}