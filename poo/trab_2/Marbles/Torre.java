package Marbles;

import Jogo.Posicao;
import Jogo.Tabuleiro;

public class Torre extends Pecas {

    public Torre (Cor cor) {
        super(cor);
    }
    
    public boolean movimentoValido (Tabuleiro jogo, Posicao posicao) {
        boolean valido = false;

        if (super.movimentoValido(jogo, posicao)) {
            int xAtual = this.getPosicaoAtual().getX();
            int yAtual = this.getPosicaoAtual().getY();

            int xFinal = posicao.getX();
            int yFinal = posicao.getY();

            if(xFinal == xAtual || yFinal == yAtual) {
                valido = true;
            }
        } else {
            valido = false;
        }
        
        return valido;
    }


    @Override
    public String toString() {
        String corPeca = "";

        if (this.getCor()==Cor.BRANCO) {
            corPeca = "\u265c";
        } else {
            corPeca = "\u2656";
        }

        return corPeca;
    }

}
