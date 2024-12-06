package Marbles;

import Jogo.Posicao;
import Jogo.Tabuleiro;

public class Rainha extends Pecas {

    public Rainha (Cor cor) {
        super(cor);
    }

    public boolean movimentoValido(Tabuleiro jogo, Posicao posicao) {

        if (super.movimentoValido(jogo, posicao)) {
            if (new Bispo(this.getCor()).movimentoValido(jogo, posicao)) {
                return true;
            } else if (new Torre(this.getCor()).movimentoValido(jogo, posicao)) {
                return true;
            } else {
                return false;
            }
        } else return false;
    }

    @Override
    public String toString() {
        String corPeca = "";

        if (this.getCor()==Cor.BRANCO) {
            corPeca = "\u265b";
        } else {
            corPeca = "\u2655";
        }

        return corPeca;
    }
    
}
