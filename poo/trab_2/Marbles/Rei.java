package Marbles;

import Jogo.Posicao;
import Jogo.Tabuleiro;

<<<<<<< HEAD
/**
 * Classe que herda os comportamentos da classe abstrata Pecas e determina as regras de movimento das instâncias de Rei
 */
=======
>>>>>>> 4e77ca7 (Tabuleiro funcional, todas as peças devidamente geradas, movimento funcional e restringidos para sobreposição de mesma cor, manter no mesmo lugar, sair para além do tabuleiro, respeito as regras de cada peça, sistema de jogadores com time de peças específicos, método alternativo de encerrar jogo com base na presença da peça rainha e declaração de vencedor.)
public class Rei extends Pecas {

    public Rei (Cor cor) {
        super(cor);
    }
<<<<<<< HEAD
    /**
     * Através do polimorfismo, especifica as regras de movimentação de uma instância de Rei
     */
=======

>>>>>>> 4e77ca7 (Tabuleiro funcional, todas as peças devidamente geradas, movimento funcional e restringidos para sobreposição de mesma cor, manter no mesmo lugar, sair para além do tabuleiro, respeito as regras de cada peça, sistema de jogadores com time de peças específicos, método alternativo de encerrar jogo com base na presença da peça rainha e declaração de vencedor.)
    public boolean movimentoValido (Tabuleiro jogo, Posicao posicao) {
        int xAtual = this.getPosicaoAtual().getX();
        int yAtual = this.getPosicaoAtual().getY();

        int xFinal = posicao.getX();
        int yFinal  = posicao.getY();

        boolean valido = (xFinal == xAtual && Math.abs(yFinal - yAtual) == 1)||
        (yFinal == yAtual && Math.abs(xFinal - xAtual) == 1) ||
        (xFinal != xAtual && yFinal != yAtual && Math.abs(xFinal - xAtual) == 1 && Math.abs(yFinal - yAtual) == 1);

        return valido;
    }
    
    @Override
    public String toString() {
        String corPeca = "";

        if (this.getCor()==Cor.BRANCO) {
            corPeca = "\u265a";
        } else {
            corPeca = "\u2654";
        }

        return corPeca;
    }

}