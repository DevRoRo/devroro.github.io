#include "sort.h"
#include <string.h>

void bubbleSort(Placa *arr, int n) {
    for (int i = 0; i < n-1; i++) {
        for (int j = 0; j < n-i-1; j++) {
            if (strcmp(arr[j].placa, arr[j+1].placa) > 0) {
                Placa temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
            }
        }
    }
}

void selectionSort(Placa *arr, int n) {
    for (int i = 0; i < n-1; i++) {
        int min_idx = i;
        for (int j = i+1; j < n; j++) {
            if (strcmp(arr[j].placa, arr[min_idx].placa) < 0) {
                min_idx = j;
            }
        }
        Placa temp = arr[min_idx];
        arr[min_idx] = arr[i];
        arr[i] = temp;
    }
}

void insertionSort(Placa *arr, int n) {
    for (int i = 1; i < n; i++) {
        Placa key = arr[i];
        int j = i - 1;
        
        while (j >= 0 && strcmp(arr[j].placa, key.placa) > 0) {
            arr[j + 1] = arr[j];
            j = j - 1;
        }
        arr[j + 1] = key;
    }
}

void shellSort(Placa *arr, int n) {
    for (int gap = n/2; gap > 0; gap /= 2) {
        for (int i = gap; i < n; i++) {
            Placa temp = arr[i];
            int j;
            
            for (j = i; j >= gap && strcmp(arr[j - gap].placa, temp.placa) > 0; j -= gap) {
                arr[j] = arr[j - gap];
            }
            
            arr[j] = temp;
        }
    }
}

int partition(Placa *arr, int low, int high) {
    Placa pivot = arr[high];
    int i = (low - 1);
    
    for (int j = low; j <= high - 1; j++) {
        if (strcmp(arr[j].placa, pivot.placa) < 0) {
            i++;
            Placa temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
    
    Placa temp = arr[i + 1];
    arr[i + 1] = arr[high];
    arr[high] = temp;
    
    return (i + 1);
}

void quickSort(Placa *arr, int low, int high) {
    if (low < high) {
        int pi = partition(arr, low, high);
        quickSort(arr, low, pi - 1);
        quickSort(arr, pi + 1, high);
    }
}