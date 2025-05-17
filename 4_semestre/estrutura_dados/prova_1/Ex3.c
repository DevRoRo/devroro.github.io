#include <stdio.h>
#include <string.h>
#include <stdlib.h>

typedef struct data{
    int dia, mes, ano;
}Data;

typedef struct pessoa{
    char nome[20];
    int idade;
    Data dataNascimento;
    struct pessoa *proximo;
}Pessoa;

Data criarData(int dia, int mes, int ano) {
    
    Data novaData;

    novaData.dia = dia;
    novaData.mes = mes;
    novaData.ano = ano;

    return novaData;
}

Pessoa criarPessoa(char nome[20], Data dataNascimento) {
    
    Pessoa novaPessoa;

    strcpy(novaPessoa.nome, nome);
    novaPessoa.dataNascimento = dataNascimento;

    return novaPessoa;
}

void calcularIdade(Pessoa *pessoa, Data *data) {
    
    int anoAux, mesAux, diaAux, idadeAux;

    anoAux = pessoa->dataNascimento.ano;
    mesAux = pessoa->dataNascimento.mes;
    diaAux = pessoa->dataNascimento.dia;

    idadeAux = data->ano - anoAux;

    if (mesAux > data->mes) {
        idadeAux--;
    } else if (mesAux == data->mes) {
        if (diaAux > data->dia) {
            idadeAux--;
        }
    }

    pessoa->idade = idadeAux;
}

typedef struct lse{
    Pessoa *primeiro;
    int n_elementos;
}LSE;


LSE* criaLista(){
    LSE *nova = (LSE*)malloc(sizeof(LSE));
    nova->primeiro = NULL;
    nova->n_elementos = 0;
    return nova;
}

void insereInicio(LSE *lista, Pessoa *novo){
    //insere um elemento no início da lista (primeiro) 
    if(lista->primeiro == NULL){
        //Lista Vazia
        novo->proximo = NULL;
    }else{
        //Lista com elementos
        novo->proximo = lista->primeiro;
    }
    lista->primeiro = novo;
    lista->n_elementos++;
}

void insereFim(LSE *lista, Pessoa *novo){
    //insere um novo elemento no fim da lista (último)
    novo->proximo = NULL;
    if(lista->primeiro == NULL){
        //Lista Vazia
        lista->primeiro = novo;
    }else{
        //Lista com elementos
        Pessoa *aux = lista->primeiro;
        while(aux->proximo!=NULL){
            aux = aux->proximo;
        }
        aux->proximo = novo;
    }
    lista->n_elementos++;
}

void inserePosicao(LSE *lista, Pessoa *novo, int posicao);
    //inserir um elemento em qualquer posição da lista (posicao)

Pessoa* removeInicio(LSE *lista){
    //remove o primeiro elemento da lista
    Pessoa *aux = lista->primeiro;
    if(aux != NULL){
        //lista com um ou mais elementos//
        lista->primeiro = aux->proximo;
        lista->n_elementos--;
    }else{
        printf("\n\t\t NÃO PODE REMOVER - Lista VAZIA!\n");
    }
    return aux;
}

Pessoa* removeFim(LSE *lista);
    //remove o último elemento da lista

Pessoa* removePosicao(LSE *lista, int posicao);
    //remove o elemento da lista na posicao definida (posicao)


void mostraPessoa(Pessoa novo){
    printf("\t\tPessoa: %s Idade %d Data nascimento: %d/%d/%d\n",novo.nome, novo.idade, novo.dataNascimento.dia, novo.dataNascimento.mes, novo.dataNascimento.ano);
}

void mostraLista(LSE lista){
    printf("\n\tMostra Lista Simplesmente Encadeada; \n");
    Pessoa *aux;
    aux = lista.primeiro;
    for(int i=0;i<lista.n_elementos;i++){
        mostraPessoa(*aux);
        aux = aux->proximo;
    }
    printf("\t\tTotal de pessoas na Lista = %d \n",lista.n_elementos);
    printf("\tFim da Lista!\n");
}

Pessoa* criarSeisPessoas(LSE *lista) {
    char nomes[6][20] = {"abc", "bac", "cba", "cab", "acb", "bca"};
    int dias[6] = {1, 2, 3, 4, 5, 6};
    int meses[6] = {1, 2, 3, 4, 5, 6};
    int anos[6] = {2001, 2002, 2003, 2004, 2005, 2006};
    int i = 0;
    Data data;
    Pessoa pessoa[6];
    
    while (i < 6) {
        data = criarData(dias[i], meses[i], anos[i]);
        pessoa[i] = criarPessoa(nomes[i], data);
        insereInicio(lista, &pessoa[i]);
        i++;
    }

    return pessoa;
}
int main() {
    LSE *lista = criaLista();
    Pessoa *pessoas[6] = criarSeisPessoas(lista);
    printf("%s", pessoas[0]->nome);
     
/*     mostraLista(*lista); */
}