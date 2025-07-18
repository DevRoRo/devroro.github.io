#ifndef SORT_H
#define SORT_H

#include "placas.h"

void bubbleSort(Placa *arr, int n);
void selectionSort(Placa *arr, int n);
void insertionSort(Placa *arr, int n);
void shellSort(Placa *arr, int n);
void quickSort(Placa *arr, int low, int high);

#endif