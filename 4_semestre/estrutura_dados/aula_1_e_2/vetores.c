#include <stdio.h>

void imprimeVetor (int vt[], int n) {
    for (int i = 0; i<n; i++) {
        printf("\n v[%d] = %d", i, vt[i]);
    }
}

void imprimeVetorPonteiro (int *p, int n) {
    printf("\nVetor ponteiro");
    for (int i = 0; i<n; i++) {
        printf("\n vt[%d] = %d", i, *(p+i));
    }
}

void somaDez(int *p, int n) {
    printf("\n Soma 10 ao vetor Ponteiro");
    for (int i = 0; i<n; i++) {
        *(p+i) += 10;
    }
}

int main() {
    int v[5] = {3, 4, 5, 2, 1}, n=5;
    imprimeVetor(v, n);
    imprimeVetorPonteiro(v, n);
    somaDez(v, n);
    imprimeVetor(v, n);
}