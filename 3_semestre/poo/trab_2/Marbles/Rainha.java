package Marbles;

import Jogo.Posicao;
import Jogo.Tabuleiro;
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
/**
 * Classe que herda os comportamentos da classe abstrata Pecas e determina as regras de movimento das instâncias de rainha
 */
=======

>>>>>>> 4e77ca7 (Tabuleiro funcional, todas as peças devidamente geradas, movimento funcional e restringidos para sobreposição de mesma cor, manter no mesmo lugar, sair para além do tabuleiro, respeito as regras de cada peça, sistema de jogadores com time de peças específicos, método alternativo de encerrar jogo com base na presença da peça rainha e declaração de vencedor.)
=======
/**
 * Classe que herda os comportamentos da classe abstrata Pecas e determina as regras de movimento das instâncias de rainha
 */
>>>>>>> 659ccc9 (Documentada a finalidade das peças e dos métodos de validação de movimento.)
=======

>>>>>>> 4e77ca7 (Tabuleiro funcional, todas as peças devidamente geradas, movimento funcional e restringidos para sobreposição de mesma cor, manter no mesmo lugar, sair para além do tabuleiro, respeito as regras de cada peça, sistema de jogadores com time de peças específicos, método alternativo de encerrar jogo com base na presença da peça rainha e declaração de vencedor.)
=======
/**
 * Classe que herda os comportamentos da classe abstrata Pecas e determina as regras de movimento das instâncias de rainha
 */
>>>>>>> 659ccc9 (Documentada a finalidade das peças e dos métodos de validação de movimento.)
public class Rainha extends Pecas {

    public Rainha (Cor cor) {
        super(cor);
    }

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 659ccc9 (Documentada a finalidade das peças e dos métodos de validação de movimento.)
=======
>>>>>>> 659ccc9 (Documentada a finalidade das peças e dos métodos de validação de movimento.)
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
=======
    public boolean movimentoValido(Tabuleiro jogo, Posicao posicao) {

        if (super.movimentoValido(jogo, posicao)) {

            Pecas bispo = new Bispo(this.getCor());
            bispo.setPosicaoAtual(this.getPosicaoAtual());

            Pecas torre = new Torre(this.getCor());
            torre.setPosicaoAtual(this.getPosicaoAtual());

            if (bispo.movimentoValido(jogo, posicao)) {
                return true;
<<<<<<< HEAD
            } else if (new Torre(this.getCor()).movimentoValido(jogo, posicao)) {
>>>>>>> 4e77ca7 (Tabuleiro funcional, todas as peças devidamente geradas, movimento funcional e restringidos para sobreposição de mesma cor, manter no mesmo lugar, sair para além do tabuleiro, respeito as regras de cada peça, sistema de jogadores com time de peças específicos, método alternativo de encerrar jogo com base na presença da peça rainha e declaração de vencedor.)
=======
            } else if (torre.movimentoValido(jogo, posicao)) {
>>>>>>> f0aaecf (corrigido bug na movimentação da rainha.)
=======
    public boolean movimentoValido(Tabuleiro jogo, Posicao posicao) {

        if (super.movimentoValido(jogo, posicao)) {

            Pecas bispo = new Bispo(this.getCor());
            bispo.setPosicaoAtual(this.getPosicaoAtual());

            Pecas torre = new Torre(this.getCor());
            torre.setPosicaoAtual(this.getPosicaoAtual());

            if (bispo.movimentoValido(jogo, posicao)) {
                return true;
<<<<<<< HEAD
            } else if (new Torre(this.getCor()).movimentoValido(jogo, posicao)) {
>>>>>>> 4e77ca7 (Tabuleiro funcional, todas as peças devidamente geradas, movimento funcional e restringidos para sobreposição de mesma cor, manter no mesmo lugar, sair para além do tabuleiro, respeito as regras de cada peça, sistema de jogadores com time de peças específicos, método alternativo de encerrar jogo com base na presença da peça rainha e declaração de vencedor.)
=======
            } else if (torre.movimentoValido(jogo, posicao)) {
>>>>>>> f0aaecf (corrigido bug na movimentação da rainha.)
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
