#include <stdio.h>

void calculadora(int *a, int *b, int *c) {
    int soma = *a + *b + *c;
    int multi = *b * *c;
    int maior;

    if(*a > *b) {
        if (*a > *c) {
            maior = *a;
        } else {
            maior = *c;
        }
    } else {
        if (*b > *c) {
            maior = *b;
        } else {
            maior = *c;
        }
    }

    *a = soma;
    *b = multi;
    *c = maior;
}

int main() {

int a, b, c;

printf("Informe a:\n");
scanf("%d",&a);
printf("Informe b:\n");
scanf("%d",&b);
printf("Informe c:\n");
scanf("%d",&c);

printf("Antes da função:\na = %d\nb = %d\nc = %d\n", a, b, c);

calculadora(&a, &b, &c);

printf("Depois da função:\na = %d\nb = %d\nc = %d\n", a, b, c);

}