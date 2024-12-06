package Marbles;

import Jogo.Posicao;
import Jogo.Tabuleiro;

public abstract class Pecas {

private Cor cor;
private Posicao posicaoAtual;

public Posicao getPosicaoAtual() {
    return posicaoAtual;
}

public void setPosicaoAtual(Posicao posicaoAtual) {
    this.posicaoAtual = posicaoAtual;
}

public Pecas(Cor cor) {
    this.cor = cor;
}

public Cor getCor() {
    return cor;
}

public void setCor(Cor cor) {
    this.cor = cor;
}

public boolean movimentoValido(Tabuleiro jogo, Posicao posicao) {
    boolean valido = true;
   
    int xAtual = this.getPosicaoAtual().getX();
    int yAtual = this.getPosicaoAtual().getY(); 

    int xFinal = posicao.getX();
    int yFinal = posicao.getY();

    Pecas [][] tabuleiro = jogo.getTabuleiro();

    if (tabuleiro[yFinal][xFinal].getCor() == this.getCor()) {
        valido = false;
    }

    if (xAtual == xFinal && yAtual == yFinal) {
        valido = false;
    }

    if (xFinal >= 8 || yFinal >=8) {
        valido = false;
    }
    
    return valido;
}

}
