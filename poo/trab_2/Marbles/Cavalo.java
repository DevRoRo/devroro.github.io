package Marbles;

import Jogo.Posicao;
import Jogo.Tabuleiro;

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
/**
 * Classe que herda os comportamentos da classe abstrata Pecas e determina as regras de movimento das instâncias de Cavalo
 */
=======
>>>>>>> 4e77ca7 (Tabuleiro funcional, todas as peças devidamente geradas, movimento funcional e restringidos para sobreposição de mesma cor, manter no mesmo lugar, sair para além do tabuleiro, respeito as regras de cada peça, sistema de jogadores com time de peças específicos, método alternativo de encerrar jogo com base na presença da peça rainha e declaração de vencedor.)
=======
/**
 * Classe que herda os comportamentos da classe abstrata Pecas e determina as regras de movimento das instâncias de Cavalo
 */
>>>>>>> 659ccc9 (Documentada a finalidade das peças e dos métodos de validação de movimento.)
=======
>>>>>>> 4e77ca7 (Tabuleiro funcional, todas as peças devidamente geradas, movimento funcional e restringidos para sobreposição de mesma cor, manter no mesmo lugar, sair para além do tabuleiro, respeito as regras de cada peça, sistema de jogadores com time de peças específicos, método alternativo de encerrar jogo com base na presença da peça rainha e declaração de vencedor.)
=======
/**
 * Classe que herda os comportamentos da classe abstrata Pecas e determina as regras de movimento das instâncias de Cavalo
 */
>>>>>>> 659ccc9 (Documentada a finalidade das peças e dos métodos de validação de movimento.)
public class Cavalo extends Pecas{
    
    public Cavalo (Cor cor) {
        super(cor);
    }
    /**
     * Através do polimorfismo, especifica as regras de movimentação de uma instância de Cavalo
     */
    public boolean movimentoValido (Tabuleiro jogo, Posicao posicao) {
        
        if (super.movimentoValido(jogo, posicao)) {

<<<<<<< HEAD
<<<<<<< HEAD
=======
=======
>>>>>>> 4e77ca7 (Tabuleiro funcional, todas as peças devidamente geradas, movimento funcional e restringidos para sobreposição de mesma cor, manter no mesmo lugar, sair para além do tabuleiro, respeito as regras de cada peça, sistema de jogadores com time de peças específicos, método alternativo de encerrar jogo com base na presença da peça rainha e declaração de vencedor.)
    public boolean movimentoValido (Tabuleiro jogo, Posicao posicao) {
        
        if (super.movimentoValido(jogo, posicao)) {

<<<<<<< HEAD
>>>>>>> 4e77ca7 (Tabuleiro funcional, todas as peças devidamente geradas, movimento funcional e restringidos para sobreposição de mesma cor, manter no mesmo lugar, sair para além do tabuleiro, respeito as regras de cada peça, sistema de jogadores com time de peças específicos, método alternativo de encerrar jogo com base na presença da peça rainha e declaração de vencedor.)
=======
>>>>>>> 4e77ca7 (Tabuleiro funcional, todas as peças devidamente geradas, movimento funcional e restringidos para sobreposição de mesma cor, manter no mesmo lugar, sair para além do tabuleiro, respeito as regras de cada peça, sistema de jogadores com time de peças específicos, método alternativo de encerrar jogo com base na presença da peça rainha e declaração de vencedor.)
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
