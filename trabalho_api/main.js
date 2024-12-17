import { fetchCountryData, fetchFeriadosNacionais } from './modules/data.js';
import { renderCountries } from './modules/render.js';
import { addCountrySelectionListener } from './modules/render.js';
import { accessInputTextValue } from './modules/render.js';
import { renderFeriadosList } from './modules/render.js';

async function init() {
    const countries = await fetchCountryData();
    renderCountries(countries);
    addCountrySelectionListener(countries);

    document.getElementById('submit_ano').addEventListener('click', async () => {
        const ano = accessInputTextValue();
        console.log(ano);
        if (ano) { 
            const feriados = await fetchFeriadosNacionais(ano); 
            console.log(feriados); 
            renderFeriadosList(feriados); 
        } else { 
            console.error('Ano is not provided.'); 
        }
    });
}

document.addEventListener('DOMContentLoaded', init);