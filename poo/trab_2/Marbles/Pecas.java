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
    
    return true;
}

}
