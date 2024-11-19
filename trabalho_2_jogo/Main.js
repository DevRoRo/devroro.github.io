let rs = 15
let cs = 5
let re = 16
let ce = 6

let contadorComida = 0

const cima = '<rect height="10" width="4" x="8" y="0" fill="red"></rect>\n'+
                '<circle r="8" cx="10.5" cy="10.5" fill="green"></circle>\n'+ 
                '<circle r="2" cx="7" cy="14" fill="white"></circle>\n'+ 
                '<circle r="2" cx="14" cy="14" fill="white"></circle>\n'+ 
                '<circle r="1" cx="7" cy="13" fill="blue"></circle>\n'+
                '<circle r="1" cx="14" cy="13" fill="blue"></circle>'

const baixo = '<rect height="10" width="4" x="8" y="10.5" fill="red"></rect>\n'+
                '<circle r="8" cx="10.5" cy="10.5" fill="green"></circle>\n'+
                '<circle r="2" cx="14" cy="7" fill="white"></circle>\n'+
                '<circle r="2" cx="7" cy="7" fill="white"></circle>\n'+
                '<circle r="1" cx="14" cy="8 " fill="blue"></circle>\n'+
                '<circle r="1" cx="7" cy="8" fill="blue"></circle>'

const esquerda = '<rect height="4" width="10" x="0" y="8" fill="red"></rect>\n'+
                '<circle r="8" cx="10.5" cy="10.5" fill="green"></circle>\n'+
                '<circle r="2" cx="14" cy="7" fill="white"></circle>\n'+
                '<circle r="2" cx="14" cy="14" fill="white"></circle>\n'+
                '<circle r="1" cx="13" cy="8 " fill="blue"></circle>\n'+
                '<circle r="1" cx="13" cy="14" fill="blue"></circle>'

const direita = '<rect height="4" width="10" x="14" y="8" fill="red"></rect>\n'+
                '<circle r="8" cx="10.5" cy="10.5" fill="green"></circle>\n'+
                '<circle r="2" cx="7" cy="14" fill="white"></circle>\n'+
                '<circle r="2" cx="7" cy="7" fill="white"></circle>\n'+
                '<circle r="1" cx="8" cy="14" fill="blue"></circle>\n'+
                '<circle r="1" cx="8" cy="7" fill="blue"></circle>'

const divComida = '<div id="comida"><svg id="plano_desenho_comida"><circle r="4" cx="10.5" cy="10.5" fill="yellow" stroke="red"></circle></svg></div>'

const svgComida = ''

var direction = 'ArrowRight'

const planoDesenhoCobra = document.getElementById("plano_desenho_cobra")

const cobra = document.getElementById('cobra')

const gridPrincipal = document.getElementById('grid_principal')

const comida = document.getElementById('comida')

var  comidaDiv

function movimentarCobra() {

    let stringArea = '' 

    switch (direction) {
        case 'ArrowUp':
            rs--
            re--
            break;
        case 'ArrowDown':
            rs++
            re++       
            break;
        case 'ArrowRight':
            cs++
            ce++
            break;
        case 'ArrowLeft':
            cs--
            ce--
            break;

        default:
            break;

    }

    stringArea = rs+'/'+cs+'/'+re+'/'+ce

    cobra.style.gridArea = stringArea

}

function direcionarCobra(event) {

    switch (event.key) {
        case 'ArrowUp':
            planoDesenhoCobra.innerHTML = cima
            direction = event.key

            break;

        case 'ArrowDown':
            planoDesenhoCobra.innerHTML = baixo
            direction = event.key

            break;

        case 'ArrowRight':
            planoDesenhoCobra.innerHTML = direita
            direction = event.key
            
            break;

        case 'ArrowLeft':
            planoDesenhoCobra.innerHTML = esquerda
            direction = event.key

            break;

        default:
            break;

    }
}

function colisao() {
    let element = cobra.style.gridArea
    const arrayDirecoes = element.split("/")
    
    if (arrayDirecoes[1] <= 1 && arrayDirecoes[3] <= 2) {
        direction = 'ArrowRight'
        planoDesenhoCobra.innerHTML=direita
    } else if (arrayDirecoes[0] <= 1 && arrayDirecoes[2] <= 2) {
        direction = 'ArrowDown'
        planoDesenhoCobra.innerHTML=baixo
    } else if (arrayDirecoes[1] >= 25 && arrayDirecoes[3] >= 26) {
        direction = 'ArrowLeft'
        planoDesenhoCobra.innerHTML=esquerda
    } else if (arrayDirecoes[0] >= 25 && arrayDirecoes[2] >= 26){
        direction = 'ArrowUp'
        planoDesenhoCobra.innerHTML=cima
    }
}

function spawnComida() {

    let rs = Math.floor(Math.random() * 24)
    let re = rs + 1
    let cs = Math.floor(Math.random() * 24)
    let ce = cs + 1

    let stringArea = rs+'/'+cs+'/'+re+'/'+ce

    /* gridPrincipal.innerHTML += divComida

    comida.style.gridArea = stringArea --> buscar entender o motivo de não funcionar */

    comidaDiv = document.createElement('div')
    comidaDiv.innerHTML = divComida; gridPrincipal.appendChild(comidaDiv.firstChild)
    
    const comida = document.getElementById('comida')
    comida.style.gridArea = stringArea

}

function comerComida() {

    if (cobra.style.gridArea == comidaDiv.style.gridArea ) {
        comidaDiv.remove
        contadorComida--
    }
}
 
document.addEventListener('keydown', direcionarCobra)

timerMovimento = setInterval(movimentarCobra, 200)

timerColisao = setInterval(colisao, 200)

if(contadorComida<1){
    spawnComida();
    contadorComida++
}

console.log(cobra.style.gridArea)
console.log(document.getElementById('comida').style.gridArea)

if(cobra.style.gridArea == comida.style.gridArea) console.log('teste')