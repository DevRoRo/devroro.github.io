package Marbles;

import Jogo.Posicao;
import Jogo.Tabuleiro;

public class Bispo extends Pecas {

    public Bispo (Cor cor) {
        super(cor);
    }


    public boolean movimentoValido (Tabuleiro jogo, Posicao posicao) {
        boolean valido = false;

        if (super.movimentoValido(jogo, posicao)) {

            int xAtual = this.getPosicaoAtual().getX();
            int yAtual = this.getPosicaoAtual().getY();

            int xFinal = posicao.getX();
            int yFinal = posicao.getY();

            if(Math.abs(xAtual-xFinal) == Math.abs(yAtual-yFinal)) {
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
            corPeca = "\u265d";
        } else {
            corPeca = "\u2657";
        }

        return corPeca;
    }
    
}
