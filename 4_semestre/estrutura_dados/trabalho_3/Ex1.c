#include <stddef.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct tarefa {
    char descricao[100];
    int id, prioridade, concluida;
    struct tarefa *proximo;
    struct tarefa *anterior;
} Tarefa;

typedef struct lde {
    Tarefa *primeiro;
    int n;
} Lde;

Tarefa* criaTarefa(int id, int prioridade, char descricao[100]) {
    Tarefa *nova = (Tarefa*)malloc(sizeof(Tarefa));
    nova->id = id;
    fflush(stdin);
    nova->prioridade = prioridade;
    strcpy(nova->descricao, descricao);
/*  printf("Informe sua Prioridade:");
    scanf("%d",&nova->prioridade);
    printf("Informe a Descricao:");
    scanf("%s",nova->descricao);
    printf("Tarefa Criada com Sucesso\n "); */
    return nova;
}

Lde* criarListaDE() {
    Lde* nova =  (Lde*)malloc(sizeof(Lde));
    nova->primeiro = NULL;
    nova->n = 0;
    return nova;
}

void  mostraTarefa(Tarefa tarefa) {

}

void insereInicio(Lde* lista, Tarefa* tarefa) {
    tarefa->anterior = NULL;
    if(lista->primeiro == NULL) {
        tarefa->proximo = NULL;
    } else {
        tarefa->proximo = lista->primeiro;
        lista->primeiro->anterior = tarefa;
    }
    lista->primeiro = tarefa;
    lista->n++;
}

void insereFim(Lde* lista, Tarefa* tarefa) {
    Tarefa* aux = lista->primeiro;
    if(lista->primeiro == NULL){
        insereInicio(lista, tarefa);
    } else {
        while(aux->proximo != NULL){
            aux = aux->proximo;
        }
        aux->proximo = tarefa;
        tarefa->anterior = aux;
        tarefa->proximo = NULL;
        lista->n++;
    }
}

void inserePosicao(Lde* lista, Tarefa* tarefa, int posicao) {
    int i = 1;
    
    if(lista->primeiro == NULL) {
        printf("Lista vazia, inserindo no início\n");
        insereInicio(lista, tarefa);
    } else {
        Tarefa* atual = lista->primeiro;
        
        while(posicao > i ) {
            atual = atual->proximo;
            i++;
        }
        
        atual->anterior->proximo = tarefa;
        tarefa->anterior = atual->anterior;
        tarefa->proximo = atual;
        atual->anterior = tarefa;
        lista->n++;
    }
}

Tarefa* removeInicio(Lde* lista) {
    Tarefa* aux = lista->primeiro;
    if (aux->proximo == NULL) {
        lista->primeiro = NULL;
    } else {
        lista->primeiro = aux->proximo;
        lista->primeiro->anterior = NULL;
        aux->proximo = NULL;
        aux->anterior = NULL;
    }

    lista->n--;

    return aux;
}

Tarefa* removeFim(Lde* lista) {
    Tarefa* aux = lista->primeiro;
    if(lista->primeiro->proximo == NULL) {
        removeInicio(lista);
    } else {
        while(aux->proximo != NULL){
            aux = aux->proximo;
        }
        aux->anterior->proximo = NULL;
        aux->proximo = NULL;
        aux->anterior = NULL;
        lista->n--;

        return aux;
    }
    
}

Tarefa removePosicao(Lde* listaPosicao, int posicao) {

}

void mostraListaDE(Lde* lista) {
    if(lista->primeiro == NULL) {
        printf("Lista vazia\n");
    } else {
        Tarefa* aux = lista->primeiro;
        printf("NULL <-> ");
        while (aux != NULL) {
            printf("%s <-> ", aux->descricao);
            aux = aux->proximo;
        }
        printf("NULL (%d nós)\n", lista->n);
    }
}

void mostraListaED(Lde lista) {

}

void apagaLista() {

}

void apagaElemento(Tarefa* tarefa) {
    free(tarefa);
}

void menu(Lde* lista) {

}

int main() {
    int i = 0;
    Lde* lista = criarListaDE();
    char descricao[4][100] = {"A", "B", "C", "D"};
    
    while(i<4){
        Tarefa* tarefa = criaTarefa(i, 1, descricao[i]);
        insereFim(lista, *&tarefa);
        i++;
    }

    i = 0;

    mostraListaDE(lista);
    char c[100] = "b";
    Tarefa* teste = criaTarefa(5, 1, c);
    inserePosicao(lista, teste, 2);
    mostraListaDE(lista);

    char b[100] = "c";
    Tarefa* teste2 = criaTarefa(6, 1, b);
    insereFim(lista, teste2);
    mostraListaDE(lista);

    Tarefa* removido = removeInicio(lista);
    mostraListaDE(lista);
    removeInicio(lista);
    mostraListaDE(lista);
    removeInicio(lista);
    mostraListaDE(lista);
    removeInicio(lista);
    mostraListaDE(lista);
    removeInicio(lista);
    mostraListaDE(lista);
    removeInicio(lista);
    mostraListaDE(lista);

    while(i<4){
        Tarefa* tarefa = criaTarefa(i, 1, descricao[i]);
        insereFim(lista, *&tarefa);
        i++;
    }

    i = 0;

    mostraListaDE(lista);

    removeFim(lista);
    mostraListaDE(lista);
}