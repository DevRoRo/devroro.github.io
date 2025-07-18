#include "hash.h"
#include <stdlib.h>
#include <string.h>
#include <stdio.h>

int hash(const char *placa) {
    unsigned long hash = 5381;
    int c;
    
    while ((c = *placa++)) {
        hash = ((hash << 5) + hash) + c;
    }
    
    return hash % HASH_SIZE;
}

void inicializarTabelaHash(TabelaHash *th) {
    for (int i = 0; i < HASH_SIZE; i++) {
        th->tabela[i] = NULL;
    }
}

void inserirNaTabelaHash(TabelaHash *th, Placa p) {
    int indice = hash(p.placa);
    
    No* novoNo = (No*)malloc(sizeof(No));
    if (novoNo == NULL) {
        perror("Erro ao alocar memória para novo nó");
        exit(EXIT_FAILURE);
    }
    
    novoNo->placa = p;
    novoNo->proximo = th->tabela[indice];
    th->tabela[indice] = novoNo;
}

No* buscarNaTabelaHash(TabelaHash *th, const char *placa) {
    int indice = hash(placa);
    No* atual = th->tabela[indice];
    
    while (atual != NULL) {
        if (strcmp(atual->placa.placa, placa) == 0) {
            return atual;
        }
        atual = atual->proximo;
    }
    
    return NULL;
}

void liberarTabelaHash(TabelaHash *th) {
    for (int i = 0; i < HASH_SIZE; i++) {
        No* atual = th->tabela[i];
        while (atual != NULL) {
            No* temp = atual;
            atual = atual->proximo;
            free(temp);
        }
    }
}