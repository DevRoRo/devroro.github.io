package Jogo;

import Marbles.*;
<<<<<<< HEAD
/**
 * Classe que organiza uma instância de jogo
 */
public class Tabuleiro {
    
    /* Array multidimensional de Pecas, emula o tabuleiro de xadrez */
=======

public class Tabuleiro {

>>>>>>> d6b59be (Tabuleiro funcional com todas as peças do jogo, método de movimentação geral das peças criado.)
    private Pecas[][] tabuleiro = new Pecas[8][8];

    public Tabuleiro() {
        
        for (int i = 0; i < tabuleiro.length; i++) {

            Pecas peca;
            
            for (int j = 0; j < tabuleiro[i].length; j++) {

                int y = i;
                int x = j;

                if(y == 0 || y == 7){

                    Cor cor;

                    if(y == 0) {
                        cor = Cor.BRANCO;
                    } else {
                        cor = Cor.PRETO;
                    }

                    switch (x) {
                        case 0:
                        case 7:
                            peca = new Torre(cor);
                            peca.setPosicaoAtual(new Posicao(x, y));
                            tabuleiro[y][x] = peca;
                            break;

                        case 1:
                        case 6:
                            peca = new Cavalo(cor);
                            peca.setPosicaoAtual(new Posicao(x, y));
                            tabuleiro[y][x] = peca;
                            break;

                        case 2:
                        case 5:
                            peca = new Bispo(cor);
                            peca.setPosicaoAtual(new Posicao(x, y));
                            tabuleiro[y][x] = peca;
                            
                            break;

                        case 3:
                            peca = new Rei(cor);
                            peca.setPosicaoAtual(new Posicao(x, y));
                            tabuleiro[y][x] = peca;
                            break;
                        case 4:
                            peca = new Rainha(cor);
                            peca.setPosicaoAtual(new Posicao(x, y));
                            tabuleiro[y][x] = peca;
                            break;
                    
                        default:
                            break;
                    }
                }
                
                if(y == 1 || y == 6) {
                    Cor cor;

                    if (y == 1) {
                        cor = Cor.BRANCO;
                    } else {
                        cor = Cor.PRETO;
                    }

                    peca = new Peao(cor);
                    peca.setPosicaoAtual(new Posicao(x, y));
                    tabuleiro[y][x] = peca;
                } else if (6 > i && i > 1) {
                    tabuleiro[y][x] = new Vazio();
                }
            }
        }
    }
<<<<<<< HEAD
    /**
     * 
     * @param peca
     * instância de Pecas selecionada para ser movimentada.
     * @param posicao
     * instância de Posicao que armazena o par ordenado de coordenadas que a peca será movida
     * @throws Exception
     */
    public void executarMovimento (Pecas peca, Posicao posicao) throws Exception {

        boolean movimentoEhValido = peca.movimentoValido(this, posicao);

        if (movimentoEhValido) {
            this.getTabuleiro()[posicao.getY()][posicao.getX()] = peca;
            
            this.getTabuleiro()[peca.getPosicaoAtual().getY()][peca.getPosicaoAtual().getX()] = new Vazio();

            peca.setPosicaoAtual(posicao);
        } else {
            throw new Exception("Movimento inválido, tente novamente.");
        }
=======

    public void executarMovimento (Pecas peca, Posicao posicao) {

        this.getTabuleiro()[posicao.getY()][posicao.getX()] = peca;
        
        this.getTabuleiro()[peca.getPosicaoAtual().getY()][peca.getPosicaoAtual().getX()] = new Vazio();

        peca.setPosicaoAtual(posicao);
>>>>>>> d6b59be (Tabuleiro funcional com todas as peças do jogo, método de movimentação geral das peças criado.)
    
    }

    public Pecas[][] getTabuleiro() {
        return tabuleiro;
    }
    
    public String toString() {
<<<<<<< HEAD
        String ilustracaoTerminal = "   0 1 2 3 4 5 6 7  X";
        int numero = 0;
        
        for (int i = 0; i < this.tabuleiro.length; i++) {
            ilustracaoTerminal += "\n"+numero+"  ";
            numero++;
=======
        String ilustracaoTerminal = "";
        
        for (int i = 0; i < this.tabuleiro.length; i++) {
            ilustracaoTerminal += "\n";
>>>>>>> d6b59be (Tabuleiro funcional com todas as peças do jogo, método de movimentação geral das peças criado.)
            for (int j = 0; j < tabuleiro[i].length; j++) {
                Pecas peca = tabuleiro[i][j];
                ilustracaoTerminal += peca.toString() + "|";
            }
        }

<<<<<<< HEAD
        ilustracaoTerminal += "\n\nY";

        return ilustracaoTerminal;
    }
    /**
     * responsável por realizar a leitura de presença de instâncias de rainha para declarar o jogo como encerrado e a Instância de Jogador vencedor.
     * @return
     */
    public Object [] jogoEncerrado () {

        Object [] parEncerrarJogoeRainha = new Object[2];
        boolean encerrado = false;
        boolean temRainhaBranca = true;
        Pecas rainhaBranca  = null;
        Pecas rainhaPreta = null;
        Pecas [][] tabuleiro = this.tabuleiro;

        for (int y = 0; y < tabuleiro.length; y++) {
            for (int x = 0; x < tabuleiro.length; x++) {
                if (tabuleiro[y][x].toString() == "\u265b") {
                    rainhaBranca = tabuleiro[y][x];
                } 
                
                if (tabuleiro[y][x].toString() == "\u2655") {
                    rainhaPreta = tabuleiro[y][x];
                }
            }
        }

        if(rainhaBranca == null) {
            encerrado = true;
            temRainhaBranca = false;
        } else if (rainhaPreta == null) {
            encerrado = true;
            temRainhaBranca = true;
        }

        parEncerrarJogoeRainha[0] = encerrado;
        parEncerrarJogoeRainha[1] = temRainhaBranca;

        return parEncerrarJogoeRainha;
    } 
=======
        return ilustracaoTerminal;
    }
>>>>>>> d6b59be (Tabuleiro funcional com todas as peças do jogo, método de movimentação geral das peças criado.)

/*     public void setTabuleiro(Pecas[][] tabuleiro) {
        this.tabuleiro = tabuleiro;
    } */
}