package Marbles;
import java.util.ArrayList;
import java.util.List;

import Mesa.Tabuleiro;

import Jogo.Posicao;
import Jogo.Tabuleiro;

public class Peao extends Pecas{
    private boolean primeiroMovimento;

    private boolean primeiroMovimento;

    public Peao (Cor cor) {
        super(cor);
        this.primeiroMovimento = true;
<<<<<<< HEAD
=======
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
>>>>>>> da701e9 (Tabuleiro funcional, todas as peças devidamente geradas, movimento funcional e restringidos para sobreposição de mesma cor, manter no mesmo lugar e sair para além do tabuleiro, sistema de jogadores com time de peças específicos, método de encerrar jogo com base na presença da peça rainha e declaração de vencedor.)
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

    @Override
    public List<int[]> procurarInimigos (int[] parOrdenado, Tabuleiro jogo) {

        int xAtual = parOrdenado[0];
        int yAtual = parOrdenado[1];
        Pecas [][] tabuleiro = jogo.getTabuleiro();
        List<int []> possiveisInimigos = new ArrayList<int []>();

        int casasAFrente;
        int diagonalEsquerda;
        int repeticoes = 3;
        Cor corInimigo;

        if (this.getCor() == Cor.BRANCO) {
            casasAFrente = yAtual-1;
            corInimigo = Cor.PRETO;
        } else {
            casasAFrente = yAtual+1;
            corInimigo = Cor.BRANCO;
        }

        if (xAtual-1 >= 0) {
            diagonalEsquerda = xAtual-1;
        } else {
            diagonalEsquerda = 0;
            repeticoes = 2;
        }

        System.out.println("posicao atual dentro de validarAtaque: "+xAtual+" "+yAtual);

        for (int x = diagonalEsquerda; x < repeticoes; x += 2) {

            Pecas possivelInimigo = tabuleiro[casasAFrente][x];

            System.out.println("possivelInimigo: "+possivelInimigo);

            if (possivelInimigo.getCor() == corInimigo) {

                int [] coordenadasInimigo = possivelInimigo.getParOrdenado();
                possiveisInimigos.add(coordenadasInimigo);
                
            }
        }

        return possiveisInimigos;
    }

    public void movimentoValido(int[] parOrdenado, List<int[]> possiveisInimigos) throws Exception {

        super.movimentoValido(parOrdenado, possiveisInimigos);

        int xFinal = parOrdenado[0];
        int yFinal = parOrdenado[1];

        int [] parOrdenadoAtual = this.getParOrdenado();
        int xAtual = parOrdenadoAtual[0];
        int yAtual = parOrdenadoAtual[1];

        Cor corPeca = this.getCor();

        System.out.println(possiveisInimigos);

        for (int i = 0; i < possiveisInimigos.size(); i++) {
            int [] inimigo = possiveisInimigos.get(i);
            System.out.println("peca inimiga nas coordenadas: "+inimigo[0]+","+inimigo[1]);

        }

        /* if (xFinal == xAtual) {
            if (this.primeiroMovimento == true) {
                if (this.getCor() == Cor.BRANCO) {
                    if (yFinal <  yAtual-2) {
                        true;
                    }
                } else {
                    if (yFinal > yAtual+2) {
                        true;
                    }
                }
            } else {
                if (this.getCor() == Cor.BRANCO) {
                    if (yFinal < yAtual-1) {
                        true;
                    }
                } else {
                    if (yFinal > yAtual+1) {
                        true;
                    }
                }

            }
        } else {

        } */
        
        /* if (xFinal != xAtual) {
            throw new Exception("Peão só se movimenta em linha reta, tente novamente.");
        } else {
            if (corPeca == Cor.BRANCO) {

                if (this.primeiroMovimento) {
                    if (yFinal < yAtual-2) {
                        throw new Exception("Não é permitido avançar mais de duas casas na primeira jogada, tente novamente.");
                    }
                } else {
                    if (yFinal > yAtual) {
                        throw new Exception("Não é permitido voltar casas, tente novamente.");
                    } else if (yFinal < yAtual-1) {
                        throw new Exception("Não é permitido avançar mais de uma casa, tente novamente");
                    }
                }

            } else {

                if (this.primeiroMovimento) {
                    if (yFinal > yAtual+2) {
                        throw new Exception("Não é permitido avançar mais de duas casas na primeira jogada, tente novamente.");
                    }
                } else {
                    if (yFinal < yAtual) {
                        throw new Exception("Não é permitido voltar casas, tente novamente.");
                    } else if (yFinal > yAtual+1) {
                        throw new Exception("Não é permitido avançar mais de uma casa, tente novamente");
                    }
                }
            }
        } */

        this.primeiroMovimento = false;
    }
}