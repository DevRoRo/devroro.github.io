package Marbles;

import Jogo.Posicao;
import Jogo.Tabuleiro;

public abstract class Pecas {
/* Armazena o Enum Cor responsável por identificar qual time pertence a peça */
private Cor cor;
/* par ordenado que registra o local atual da instância de peça no tabuleiro */
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

/**
 * especifica as regras de movimentação de uma instância de peça, validando as regras gerais de movimentação
 * para todas as classes que herdam desta.
 */
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
