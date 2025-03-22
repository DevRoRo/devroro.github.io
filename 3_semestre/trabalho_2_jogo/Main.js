

let contadorComida = 0
let contadorParteCobra = 1

let gameOver = false

var stringAreaPlayer = '15/5/16/6'
var stringAreaInimigo = '12/7/13/8'
var stringAreaComida = ''
var direction = 'ArrowRight'

const cima = 
                '<circle r="8" cx="10.5" cy="10.5" fill="green"></circle>\n'+
                '<polygon points="10.5, 10.5 0, 0 20, 0" fill="white"></polygon>' 

const baixo = 
                '<circle r="8" cx="10.5" cy="10.5" fill="green"></circle>\n'+
                '<polygon points="10.5, 10.5 20, 20 0, 20" fill="white"></polygon>'

const esquerda = 
                '<circle r="8" cx="10.5" cy="10.5" fill="green"></circle>\n'+
                '<polygon points="10.5, 10.5 0, 0 0, 20" fill="white"></polygon>'

const direita = 
                '<circle r="8" cx="10.5" cy="10.5" fill="green"></circle>\n'+
                '<polygon points="10.5, 10.5 20, 0 20, 20" fill="white"></polygon>'

const cima2 = 
                '<circle r="8" cx="10.5" cy="10.5" fill="red"></circle>\n'+
                '<polygon points="10.5, 10.5 0, 0 20, 0" fill="white"></polygon>' 

const baixo2 = 
                '<circle r="8" cx="10.5" cy="10.5" fill="red"></circle>\n'+
                '<polygon points="10.5, 10.5 20, 20 0, 20" fill="white"></polygon>'

const esquerda2 = 
                '<circle r="8" cx="10.5" cy="10.5" fill="red"></circle>\n'+
                '<polygon points="10.5, 10.5 0, 0 0, 20" fill="white"></polygon>'

const direita2 = 
                '<circle r="8" cx="10.5" cy="10.5" fill="red"></circle>\n'+
                '<polygon points="10.5, 10.5 20, 0 20, 20" fill="white"></polygon>'

const divComida = '<div id="comida"><svg id="plano_desenho_comida"><circle r="4" cx="10.5" cy="10.5" fill="yellow" stroke="red"></circle></svg></div>'

const parteCobraSVG = '<svg id="plano_desenho_cobra" width="100%" height="100%">'
                        '<circle r="8" cx="10.5" cy="10.5" fill="green"></circle>'+
                        '</svg>'
const iconeMorte = '<svg id="plano_desenho_player" width="100%" height="100%"><line x1="2" y1="2" x2="19" y2="19" style="stroke-width:3;stroke:black"></line><line x1="2" y1="19" x2="19" y2="2" style="stroke-width:3;stroke:black"></line></svg>'

const parteCobraSVG = '<svg id="plano_desenho_cobra" width="100%" height="100%">'
                        '<circle r="8" cx="10.5" cy="10.5" fill="green"></circle>'+
                        '</svg>'

const planoDesenhoPlayer = document.getElementById("plano_desenho_player")

const planoDesenhoInimigo = document.getElementById("plano_desenho_inimigo")

const player = document.getElementById('player')

const gridPrincipal = document.getElementById('grid_principal')

function movimentar(direcao, coordenadaAnterior) { 

    console.log(direcao)
    console.log(coordenadaAnterior)
    array = coordenadaAnterior.split("/")

    let rs = array[0]
    let cs = array[1]
    let re = array[2]
    let ce = array[3]

    switch (direcao) {
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

        case 'parar':

            break

        default:

            break;

    }

    let stringArea = rs+'/'+cs+'/'+re+'/'+ce

    return stringArea
}

function direcionarPlayer(event) {

    switch (event.key) {
        case 'ArrowUp':
            planoDesenhoPlayer.innerHTML = cima
            direction = event.key

            break;

        case 'ArrowDown':
            planoDesenhoPlayer.innerHTML = baixo
            direction = event.key

            break;

        case 'ArrowRight':
            planoDesenhoPlayer.innerHTML = direita
            direction = event.key
            
            break;

        case 'ArrowLeft':
            planoDesenhoPlayer.innerHTML = esquerda
            direction = event.key

            break;

        default:
            break;

    }
}

function colisao(personagem) {
    let element = personagem.style.gridArea
    const arrayDirecoes = element.split("/")
    
    if (arrayDirecoes[1] == 1 && arrayDirecoes[3] == 2) {
        planoDesenhoPlayer.innerHTML=iconeMorte
        direction = 'parar'
    } else if (arrayDirecoes[0] == 1 && arrayDirecoes[2] == 2) {
        planoDesenhoPlayer.innerHTML=iconeMorte
        direction = 'parar'
    } else if (arrayDirecoes[1] == 25 && arrayDirecoes[3] == 26) {
        planoDesenhoPlayer.innerHTML=iconeMorte
        direction = 'parar'
    } else if (arrayDirecoes[0] == 25 && arrayDirecoes[2] == 26){
        planoDesenhoPlayer.innerHTML=iconeMorte
        direction = 'parar'
    }
}

function spawnComida() {

    let rs = Math.floor(Math.random() * 23)+2
    let re = rs + 1
    let cs = Math.floor(Math.random() * 23)+2
    let ce = cs + 1

    stringAreaComida = rs+'/'+cs+'/'+re+'/'+ce

    let comidaDiv = document.createElement('div')
    comidaDiv.innerHTML = divComida; gridPrincipal.appendChild(comidaDiv.firstChild)
    
    const comida = document.getElementById('comida')
    comida.style.gridArea = stringAreaComida

}

function comerComida() {
    document.getElementById('comida').parentNode.removeChild(document.getElementById('comida'))

}

function sistemaComida(stringArea) {

    if(contadorComida<1){
        spawnComida();
        contadorComida++
    }

    if(stringArea == comida.style.gridArea  ) {
        comerComida()
        contadorComida--
    }       
}

function directionInimigo() {
    
    random = Math.floor(Math.random() * 4)

    if (random == 0) {
        planoDesenhoInimigo.innerHTML = cima2
        return 'ArrowUp'
    } else if (random == 1){
        planoDesenhoInimigo.innerHTML = baixo2
        return 'ArrowDown'
    } else if (random == 2){
        planoDesenhoInimigo.innerHTML = direita2
        return 'ArrowRight'
    } else if (random == 3){
        planoDesenhoInimigo.innerHTML = esquerda2
        return 'ArrowLeft'
    }
}

function jogo() {

    player.style.gridArea = movimentar(direction, stringAreaPlayer)
    stringAreaPlayer = player.style.gridArea

    inimigo.style.gridArea = movimentar(directionInimigo(), stringAreaInimigo)
    stringAreaInimigo = inimigo.style.gridArea

    colisao(player)

    sistemaComida(player.style.gridArea)

}
 
document.addEventListener('keydown', direcionarPlayer)

timerJogo = setInterval(jogo, 100)