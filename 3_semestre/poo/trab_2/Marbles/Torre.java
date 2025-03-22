package Marbles;

import Jogo.Posicao;
import Jogo.Tabuleiro;

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
/**
 * Classe que herda os comportamentos da classe abstrata Pecas e determina as regras de movimento das instâncias de Torre
 */
=======
>>>>>>> 4e77ca7 (Tabuleiro funcional, todas as peças devidamente geradas, movimento funcional e restringidos para sobreposição de mesma cor, manter no mesmo lugar, sair para além do tabuleiro, respeito as regras de cada peça, sistema de jogadores com time de peças específicos, método alternativo de encerrar jogo com base na presença da peça rainha e declaração de vencedor.)
=======
/**
 * Classe que herda os comportamentos da classe abstrata Pecas e determina as regras de movimento das instâncias de Torre
 */
>>>>>>> 659ccc9 (Documentada a finalidade das peças e dos métodos de validação de movimento.)
=======
>>>>>>> 4e77ca7 (Tabuleiro funcional, todas as peças devidamente geradas, movimento funcional e restringidos para sobreposição de mesma cor, manter no mesmo lugar, sair para além do tabuleiro, respeito as regras de cada peça, sistema de jogadores com time de peças específicos, método alternativo de encerrar jogo com base na presença da peça rainha e declaração de vencedor.)
=======
/**
 * Classe que herda os comportamentos da classe abstrata Pecas e determina as regras de movimento das instâncias de Torre
 */
>>>>>>> 659ccc9 (Documentada a finalidade das peças e dos métodos de validação de movimento.)
public class Torre extends Pecas {

    public Torre (Cor cor) {
        super(cor);
    }
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
    /**
     * Através do polimorfismo, especifica as regras de movimentação de uma instância de Torre
     */
=======
    
<<<<<<< HEAD
>>>>>>> 4e77ca7 (Tabuleiro funcional, todas as peças devidamente geradas, movimento funcional e restringidos para sobreposição de mesma cor, manter no mesmo lugar, sair para além do tabuleiro, respeito as regras de cada peça, sistema de jogadores com time de peças específicos, método alternativo de encerrar jogo com base na presença da peça rainha e declaração de vencedor.)
=======
    /**
     * Através do polimorfismo, especifica as regras de movimentação de uma instância de Torre
     */
>>>>>>> 659ccc9 (Documentada a finalidade das peças e dos métodos de validação de movimento.)
=======
>>>>>>> 4e77ca7 (Tabuleiro funcional, todas as peças devidamente geradas, movimento funcional e restringidos para sobreposição de mesma cor, manter no mesmo lugar, sair para além do tabuleiro, respeito as regras de cada peça, sistema de jogadores com time de peças específicos, método alternativo de encerrar jogo com base na presença da peça rainha e declaração de vencedor.)
=======
    /**
     * Através do polimorfismo, especifica as regras de movimentação de uma instância de Torre
     */
>>>>>>> 659ccc9 (Documentada a finalidade das peças e dos métodos de validação de movimento.)
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
