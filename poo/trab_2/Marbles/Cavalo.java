package Marbles;

import Jogo.Posicao;
import Jogo.Tabuleiro;

public class Cavalo extends Pecas{
    
    public Cavalo (Cor cor) {
        super(cor);
    }

    public boolean movimentoValido (Tabuleiro jogo, Posicao posicao) {
        
        if (super.movimentoValido(jogo, posicao)) {

            int xAtual = this.getPosicaoAtual().getX();
            int yAtual = this.getPosicaoAtual().getY();

            int xFinal = posicao.getX();
            int yFinal = posicao.getY();

            boolean valido = (Math.abs(xFinal - xAtual) == 1 && Math.abs(yFinal - yAtual) == 2) ||
            (Math.abs(xFinal - xAtual) == 1 && Math.abs(yFinal - yAtual) == 2);

            return valido;

        } else return false;
    }
 
    @Override
    public String toString() {
        String corPeca = "";

        if (this.getCor()==Cor.BRANCO) {
            corPeca = "\u265e";
        } else {
            corPeca = "\u2658";
        }

        return corPeca;
    }

}
