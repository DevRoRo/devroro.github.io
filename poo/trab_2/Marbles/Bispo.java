package Marbles;

import Jogo.Posicao;
import Jogo.Tabuleiro;

/**
 * Classe que herda os comportamentos da classe abstrata Pecas e determina as regras de movimento das instâncias de Cavalo
 */
public class Bispo extends Pecas {

    public Bispo (Cor cor) {
        super(cor);
    }

    /**
     * Através do polimorfismo, especifica as regras de movimentação de uma instância de Bispo
     */
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
