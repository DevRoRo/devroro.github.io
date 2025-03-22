import { fetchFeriadosNacionais } from "./data.js";

export function renderCountries(countries) {
    const countryList = document.getElementById('country-list');

    //map
    const options = countries.map(country => 
        `<option value="${country.nome_pais}" id="${country.nome_pais}">${country.nome_pais}</option>`
    ).join('');
    
    countryList.innerHTML += options;
}

export function addCountrySelectionListener(countries) {
    const countryList = document.getElementById('country-list');

    countryList.addEventListener('change', (event) => {
        const selectedCountry = event.target.value;

        const countryData = countries.find(country => country.nome_pais === selectedCountry);

        if (countryData) {
            const mainSection = document.getElementById('container_paises');
            const newDiv = document.createElement('div');
            newDiv.id = `info-country`;
            newDiv.className = 'country-info';
            newDiv.innerHTML = `
                <h2>${countryData.nome_pais}</h2>
                <p>Gentílico: ${countryData.gentilico}</p>
                <p>Nome (internacional): ${countryData.nome_pais_int}</p>
                <p>Sigla: ${countryData.sigla}</p>
            `;

            // Remove existing country-info divs before appending the new one
            const existingDivs = document.querySelectorAll('.country-info');
            existingDivs.forEach(div => div.remove());

            // Append the new div to the main section
            mainSection.appendChild(newDiv);
        }
    });
}

export function accessInputTextValue() {
    const inputTypeText = document.getElementById("ano");
    return inputTypeText.value
}

export function renderFeriadosList(feriados) {
    console.log(feriados)
    const mainSection = document.getElementById('container_apibr');
    const newDiv = document.createElement('div');
    newDiv.id = `info-feriado`;
    newDiv.className = 'container';

    let content = '';
    /* destructuring */
    for (const {date, name, type} of feriados) {
        content += `
        <h2>${name}</h2>
        <p>Data: ${date} - ${type}</p>
    `;
    }
    
    newDiv.innerHTML = content;

    // Remove existing country-info divs before appending the new one
    const existingDivs = document.querySelectorAll('.feriado');
    existingDivs.forEach(div => div.remove());

    // Append the new div to the main section
    mainSection.appendChild(newDiv);
}