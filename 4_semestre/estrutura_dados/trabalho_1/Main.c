#include <stdio.h>
#include <stdlib.h>
#include <time.h>

struct peça {
    int valor;
    char figura;
};

void imprimeMatriz(struct peça tabuleiro[3][3]) {
    printf("   0  1  2\n  *-------*\n");

    for (int i = 0; i < 3; i++)
    {
        printf("%d | ", i);

        for (int j = 0; j < 3; j++)
        {
           printf("%c ", tabuleiro[i][j].figura);
        }   

        printf("| \n");

    }

    printf("  *-------*\n   0  1  2\n");
}

//Pra mim não faz sentido passar o jogador como parâmetro pois essa função é igual pra ambos, apenas valida a jogada dentro do campo
int lerCoordJogada(int *x){

    if(*x > 2) {

        printf("Coordenada inválida\n");

        return 0;

    } else return 1;

}

int jogadaValida(int *i, int *j, struct peça *tabuleiro[3][3]) {
    if (tabuleiro[*i][*j]->valor != 0) {
        printf("Jogada inválida, já existe peça na posição");
        return 0;
    } else {
        return 1;
    }
}

int main() {
    srand(time(0));
    struct peça tabuleiro[3][3] = {{{0, ' '}, {0, ' '}, {0, ' '}}, {{0, ' '}, {0, ' '}, {0, ' '}}, {{0, ' '}, {0, ' '}, {0, ' '}}};
    int *x;
    int *y;
    int i;
    int j;
    int encerra;
    int turno = rand() % 2;
    struct peça jogador;

    while (1) {

        if (turno % 2 == 0) {
            jogador.figura = 'x';
            jogador.valor = 1;
        } else {
            jogador.figura = 'o';
            jogador.valor = 2;
        };

        printf("--Turno de %c--\n\n", jogador.figura);

        imprimeMatriz(tabuleiro);

        do { 
            printf("Insira a coordenada y de onde deseja inserir uma peça: \n");
            scanf("%d", &i);
            
        } while (!lerCoordJogada(&i));

        do { 
            printf("Insira a coordenada x de onde deseja inserir uma peça: \n");
            scanf("%d", &j);
            
        } while (!lerCoordJogada(&j));

        /* do { // Não consegui implementar a função de teste por erro na sintaxe do ponteiro do tabuleiro
            jogadaValida(&i, &j, &tabuleiro);
        } while (!jogadaValida); */

        tabuleiro[i][j].figura = jogador.figura;
        tabuleiro[i][j].valor = jogador.valor;
        turno++;

        printf("Continuar? 1 - sim 0 - não\n");
        scanf("%d", &encerra);

        if(encerra == 0) {
            break;
        }
    }
}