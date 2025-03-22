class Bola {
    x
    y
    cor
    temParente

    constructor (x, y, cor) {
        this.x = x
        this.y = y
        this.cor = cor
        temParente = false
    }

    verificarParentes() {

    } 
}

class Canhao {
    cartucho = new Array
    
    atirar () {
    
    }

    // usar métodos do array pra atirar o [0] e atualizar a fila
}

class Tela {
    canhao
    grade = new Array

    criarBolas (qtdNaFileira) {
        for (let index = 0; index < qtdNaFileira; index++) {
            novaBola = new Bola(x, y, cor)
            this.grade.pushO(novaBola)
            
        }
    }
}

while(true) {

    const turno = 0
    const spawnBolas = false
    if(turno % 5 == 0) spawnBolas = true

    if (spawnBolas == true) criarBolas

    atirar()

    turno++
}