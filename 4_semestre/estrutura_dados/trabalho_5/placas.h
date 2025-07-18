#ifndef PLACAS_H
#define PLACAS_H

#define HASH_SIZE 500
#define NUM_PLACAS 10000
#define PLACA_SIZE 8 // ABC1D23 + '\0'

typedef struct {
    char placa[PLACA_SIZE];
} Placa;

#endif