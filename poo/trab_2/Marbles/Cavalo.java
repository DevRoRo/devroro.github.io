package Marbles;

import Jogo.Posicao;
import Jogo.Tabuleiro;

/**
 * Classe que herda os comportamentos da classe abstrata Pecas e determina as regras de movimento das instâncias de Cavalo
 */
public class Cavalo extends Pecas{
    
    public Cavalo (Cor cor) {
        super(cor);
    }
    /**
     * Através do polimorfismo, especifica as regras de movimentação de uma instância de Cavalo
     */
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
