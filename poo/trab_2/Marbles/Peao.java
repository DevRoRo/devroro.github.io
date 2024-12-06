package Marbles;

import Jogo.Posicao;
import Jogo.Tabuleiro;

/**
 * 
 */
public class Peao extends Pecas{

    private boolean primeiroMovimento;

    public Peao (Cor cor) {
        super(cor);
        this.primeiroMovimento = true;
    }
    
    public boolean movimentoValido (Tabuleiro jogo, Posicao posicao) {
        
        boolean ehValido = true;

        if (super.movimentoValido(jogo, posicao)) {

            Pecas[][] tabuleiro = jogo.getTabuleiro();

            int xAtual = this.getPosicaoAtual().getX();
            int yAtual = this.getPosicaoAtual().getY();

            int xFinal = posicao.getX();
            int yFinal = posicao.getY();

            Cor corPeca = this.getCor();

            Cor corAtual = this.getCor();

            Cor corInimiga = (corAtual == Cor.PRETO) ? Cor.BRANCO : Cor.PRETO;
            int direcaoY = (corAtual == Cor.PRETO) ? -1 : 1;
            
            boolean direcao = (yFinal - yAtual) * direcaoY > 0;
            boolean direcaoValida = yFinal == yAtual + direcaoY;

            if (direcao) {
                System.out.println("teste y direction");

                if (direcaoValida) {
                    System.out.println("teste yf = y+/-1");

                    if (xFinal == xAtual) {
                        System.out.println("teste x = x");
                        ehValido = tabuleiro[yAtual + direcaoY][xAtual].getCor() == Cor.VAZIO;
                    } else {
                        System.out.println("teste cor");
                        boolean isEnemyOppositeLeft = false;
                        boolean isEnemyOppositeRight = false;
                        if (xAtual == 0) {
                            isEnemyOppositeRight = tabuleiro[yAtual + direcaoY][xAtual + 1].getCor() == corInimiga;
                        } else if (xAtual == 7) {
                            isEnemyOppositeLeft = tabuleiro[yAtual + direcaoY][xAtual - 1].getCor() == corInimiga;
                        } else {
                            isEnemyOppositeRight = tabuleiro[yAtual + direcaoY][xAtual + 1].getCor() == corInimiga;
                            isEnemyOppositeLeft = tabuleiro[yAtual + direcaoY][xAtual - 1].getCor() == corInimiga;                        
                        }

                        if (isEnemyOppositeLeft || isEnemyOppositeRight) {
                            System.out.println("teste inimigo");
                            if (xFinal == xAtual + 1 || xFinal == xAtual - 1) {
                                System.out.println("teste sobreposicao inimigo");
                                ehValido = true;
                            } else {
                                ehValido = false;
                            }
                        } else {
                            ehValido = false;
                        }
                    }
                } else if (primeiroMovimento) {
                    System.out.println("teste primeiro movimento");
                    ehValido = (corAtual == Cor.PRETO) ? (yFinal >= yAtual - 2) : (yFinal <= yAtual + 2);
                } else {
                    ehValido = false;
                }
            } else {
                ehValido = false;
            }

            if (ehValido == true) this.primeiroMovimento = false;
        } else {
            ehValido = false;
        }

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
