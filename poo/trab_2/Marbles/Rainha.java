package Marbles;

import Jogo.Posicao;
import Jogo.Tabuleiro;
/**
 * Classe que herda os comportamentos da classe abstrata Pecas e determina as regras de movimento das instâncias de rainha
 */
public class Rainha extends Pecas {

    public Rainha (Cor cor) {
        super(cor);
    }

    /**
     * Através do polimorfismo, especifica as regras de movimentação de uma instância de Rainha
     */
    public boolean movimentoValido(Tabuleiro jogo, Posicao posicao) {

        if (super.movimentoValido(jogo, posicao)) {

            Pecas bispo = new Bispo(this.getCor());
            bispo.setPosicaoAtual(this.getPosicaoAtual());

            Pecas torre = new Torre(this.getCor());
            torre.setPosicaoAtual(this.getPosicaoAtual());

            if (bispo.movimentoValido(jogo, posicao)) {
                return true;
            } else if (torre.movimentoValido(jogo, posicao)) {
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
