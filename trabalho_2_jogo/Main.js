let rs = 1
let cs = 1
let re = 2
let ce = 2

let direction = 'ArrowDown'

function movimentarCobra(direction) {
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

document.addEventListener('keydown', movimentarCobra)