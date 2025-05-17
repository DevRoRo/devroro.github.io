#include <stdio.h>
#include <string.h>

typedef struct data{
    int dia, mes, ano;
}Data;

typedef struct pessoa{
    char nome[20];
    int idade;
    Data dataNascimento;
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

int main() {

    int dia, mes, ano;
    Pessoa pessoa[3];
    int i = 0;
    char nome[20];
    Data dataNascimento;
    Data dataAtual;

    //A)
    while (i < 3) {

        printf("Informe um nome:\n");
        scanf("%s", nome);
        printf("Informe o dia do aniversário de %s:\n", nome);
        scanf("%d", &dia);
        printf("Informe o mês do aniversário de %s:\n", nome);
        scanf("%d", &mes);
        printf("Informe o ano do aniversário de %s:\n", nome);
        scanf("%d", &ano);

        dataNascimento = criarData(dia, mes, ano);
        pessoa[i] = criarPessoa(nome, dataNascimento);

        i++;
    }

    i = 0;

    printf("=====================\n");

    //fim do A)

    //B)
    printf("Informe o dia de hoje: ");
    scanf("%d", &dia);
    printf("Informe o mês atual: ");
    scanf("%d", &mes);
    printf("Informe o ano atualv: ");
    scanf("%d", &ano);

    dataAtual = criarData(dia, mes, ano);

    printf("Data atual: %d/%d/%d\n=====================\n", dataAtual.dia, dataAtual.mes, dataAtual.ano);
    //fim do B)

    //C)

    while (i < 3) {
        calcularIdade(&pessoa[i], &dataAtual);
        i++;
    }

    i = 0;


    while (i < 3) {
        printf("Nome: %s\nData de nascimento: %d/%d/%d\n Idade: %d anos\n", pessoa[i].nome, pessoa[i].dataNascimento.dia, pessoa[i].dataNascimento.mes, pessoa[i].dataNascimento.ano, pessoa[i].idade); 
        i++;
    }

    printf("=====================\n");

    i = 0;

    //fim do C)

}