package Marbles;

import Jogo.Posicao;
import Jogo.Tabuleiro;

public class Peao extends Pecas{

    private boolean primeiroMovimento;

    public Peao (Cor cor) {
        super(cor);
        this.primeiroMovimento = true;
    }
    
    public boolean movimentoValido (Tabuleiro jogo, Posicao posicao) {
        boolean ehValido = true;
        int casas;

        int xAtual = this.getPosicaoAtual().getX();
        int yAtual = this.getPosicaoAtual().getY();

        int xFinal = posicao.getX();
        int yFinal = posicao.getY();

        Cor corPeca = this.getCor();

        return ehValido;
    }
    
    @Override
    public String toString() {
        String corPeca = "";

        if (this.getCor()==Cor.BRANCO) {
            corPeca = "\u265f";
        } else {
            corPeca = "\u2659";
        }

        return corPeca;
    }

}
