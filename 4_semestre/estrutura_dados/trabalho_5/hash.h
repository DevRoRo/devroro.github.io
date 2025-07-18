#ifndef HASH_H
#define HASH_H

#include "placas.h"

typedef struct No {
    Placa placa;
    struct No* proximo;
} No;

typedef struct {
    No* tabela[HASH_SIZE];
} TabelaHash;

void inicializarTabelaHash(TabelaHash *th);
void inserirNaTabelaHash(TabelaHash *th, Placa p);
No* buscarNaTabelaHash(TabelaHash *th, const char *placa);
void liberarTabelaHash(TabelaHash *th);

#endif