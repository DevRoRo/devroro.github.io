package Marbles;
import java.util.ArrayList;
import java.util.List;

<<<<<<< HEAD
<<<<<<< HEAD
import Mesa.Tabuleiro;

import Jogo.Posicao;
import Jogo.Tabuleiro;

/**
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
 * Classe que herda os comportamentos da classe abstrata Pecas e determina as regras de movimento das instâncias de Peao
 */
=======
import Jogo.Posicao;
import Jogo.Tabuleiro;

>>>>>>> da701e9 (Tabuleiro funcional, todas as peças devidamente geradas, movimento funcional e restringidos para sobreposição de mesma cor, manter no mesmo lugar e sair para além do tabuleiro, sistema de jogadores com time de peças específicos, método de encerrar jogo com base na presença da peça rainha e declaração de vencedor.)
=======
 * 
=======
 * Classe que herda os comportamentos da classe abstrata Pecas e determina as regras de movimento das instâncias de Peao
>>>>>>> 659ccc9 (Documentada a finalidade das peças e dos métodos de validação de movimento.)
 */
>>>>>>> 4e77ca7 (Tabuleiro funcional, todas as peças devidamente geradas, movimento funcional e restringidos para sobreposição de mesma cor, manter no mesmo lugar, sair para além do tabuleiro, respeito as regras de cada peça, sistema de jogadores com time de peças específicos, método alternativo de encerrar jogo com base na presença da peça rainha e declaração de vencedor.)
=======
import Jogo.Posicao;
import Jogo.Tabuleiro;

>>>>>>> da701e9 (Tabuleiro funcional, todas as peças devidamente geradas, movimento funcional e restringidos para sobreposição de mesma cor, manter no mesmo lugar e sair para além do tabuleiro, sistema de jogadores com time de peças específicos, método de encerrar jogo com base na presença da peça rainha e declaração de vencedor.)
=======
 * 
=======
 * Classe que herda os comportamentos da classe abstrata Pecas e determina as regras de movimento das instâncias de Peao
>>>>>>> 659ccc9 (Documentada a finalidade das peças e dos métodos de validação de movimento.)
 */
>>>>>>> 4e77ca7 (Tabuleiro funcional, todas as peças devidamente geradas, movimento funcional e restringidos para sobreposição de mesma cor, manter no mesmo lugar, sair para além do tabuleiro, respeito as regras de cada peça, sistema de jogadores com time de peças específicos, método alternativo de encerrar jogo com base na presença da peça rainha e declaração de vencedor.)
public class Peao extends Pecas{
    private boolean primeiroMovimento;

    private boolean primeiroMovimento;

    private boolean primeiroMovimento;

    private boolean primeiroMovimento;

    public Peao (Cor cor) {
        super(cor);
        this.primeiroMovimento = true;
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
    }
    /**
     * Através do polimorfismo, especifica as regras de movimentação de uma instância de Peao
     */
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

                if (direcaoValida) {

                    if (xFinal == xAtual) {
                        ehValido = tabuleiro[yAtual + direcaoY][xAtual].getCor() == Cor.VAZIO;
                    } else {
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
                            if (xFinal == xAtual + 1 || xFinal == xAtual - 1) {
                                ehValido = true;
                            } else {
                                ehValido = false;
                            }
                        } else {
                            ehValido = false;
                        }
                    }
                } else if (primeiroMovimento) {
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
>>>>>>> da701e9 (Tabuleiro funcional, todas as peças devidamente geradas, movimento funcional e restringidos para sobreposição de mesma cor, manter no mesmo lugar e sair para além do tabuleiro, sistema de jogadores com time de peças específicos, método de encerrar jogo com base na presença da peça rainha e declaração de vencedor.)
=======
    }
    /**
     * Através do polimorfismo, especifica as regras de movimentação de uma instância de Peao
     */
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

                if (direcaoValida) {

                    if (xFinal == xAtual) {
                        ehValido = tabuleiro[yAtual + direcaoY][xAtual].getCor() == Cor.VAZIO;
                    } else {
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
                            if (xFinal == xAtual + 1 || xFinal == xAtual - 1) {
                                ehValido = true;
                            } else {
                                ehValido = false;
                            }
                        } else {
                            ehValido = false;
                        }
                    }
                } else if (primeiroMovimento) {
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
>>>>>>> da701e9 (Tabuleiro funcional, todas as peças devidamente geradas, movimento funcional e restringidos para sobreposição de mesma cor, manter no mesmo lugar e sair para além do tabuleiro, sistema de jogadores com time de peças específicos, método de encerrar jogo com base na presença da peça rainha e declaração de vencedor.)
=======
    }
    /**
     * Através do polimorfismo, especifica as regras de movimentação de uma instância de Peao
     */
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

                if (direcaoValida) {

                    if (xFinal == xAtual) {
                        ehValido = tabuleiro[yAtual + direcaoY][xAtual].getCor() == Cor.VAZIO;
                    } else {
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
                            if (xFinal == xAtual + 1 || xFinal == xAtual - 1) {
                                ehValido = true;
                            } else {
                                ehValido = false;
                            }
                        } else {
                            ehValido = false;
                        }
                    }
                } else if (primeiroMovimento) {
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