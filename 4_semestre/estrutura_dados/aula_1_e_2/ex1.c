#include <stdio.h>

int main () {
    int a = 18;
    int b = 21;
    int s = 0;

    int *ps = &s;
    
    *ps = a + b;

    printf("%d\n", *ps);

    printf("%p\n", &ps);
    printf("%d\n", *ps);




}