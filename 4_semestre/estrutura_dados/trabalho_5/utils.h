#ifndef UTILS_H
#define UTILS_H

#include "placas.h"

void gerarPlacaAleatoria(Placa *p);
void copiarArray(Placa *orig, Placa *dest, int n);
void desordenarArray(Placa *arr, int n);
int buscarListaDesordenada(Placa *arr, int n, const char *placa);
int buscarListaOrdenada(Placa *arr, int n, const char *placa);

#endif