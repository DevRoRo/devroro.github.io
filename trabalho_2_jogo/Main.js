let rs = 15
let cs = 5
let re = 16
let ce = 6

var direction = ''

function movimentarCobra() {
    const element = document.getElementById('cobra')
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

    element.style.gridArea = stringArea

}

function direcionarCobra(event) {
    switch (event.key) {
        case 'ArrowUp':
        case 'ArrowDown':
        case 'ArrowRight':
        case 'ArrowLeft':

            direction = event.key

            break;

        default:
            break;

    }
}

function colisao() {
    let element = document.getElementById('cobra').style.gridArea
    const arrayDirecoes = element.split("/")
    

    if (arrayDirecoes[1] == 1 && arrayDirecoes[3] == 2) {
        direction = 'ArrowRight'
    } else if (arrayDirecoes[0] == 1 && arrayDirecoes[2] == 2) {
        direction = 'ArrowDown'
    } else if (arrayDirecoes[1] == 50 && arrayDirecoes[3] == 51) {
        direction = 'ArrowLeft'
    } else if (arrayDirecoes[0] == 50 && arrayDirecoes[2] == 51){
        direction = 'ArrowUp'
    }
}
 
document.addEventListener('keydown', direcionarCobra)

timerMovimento = setInterval(movimentarCobra, 200)

timerCOlisao =setInterval(colisao, 200)

