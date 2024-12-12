export function loadCountries() {
    const response = fetch('./paises.json');
    const data = response.json();

    //**map, filter ou reduce**
    const countrySelect = document.getElementById('countrySelect');
    const options = data.map(({ nome_pais }) => 
        `<option value="${nome_pais}">${nome_pais}</option>`).join('');
    countrySelect.innerHTML += options;
}
