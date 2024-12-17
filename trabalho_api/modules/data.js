export async function fetchCountryData() {
    const response = await fetch('./modules/paises.json');
    const data = await response.json();

    return data;
}

export async function fetchFeriadosNacionais(ano) {  
    const response = await fetch('https://brasilapi.com.br/api/feriados/v1/'+ano);
    const data = await response.json();

    return data;
}

