package Jogo;

import Marbles.*;

public class Tabuleiro {

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

    public void executarMovimento (Pecas peca, Posicao posicao) {

        this.getTabuleiro()[posicao.getY()][posicao.getX()] = peca;
        
        this.getTabuleiro()[peca.getPosicaoAtual().getY()][peca.getPosicaoAtual().getX()] = new Vazio();

        peca.setPosicaoAtual(posicao);
    
    }

    public Pecas[][] getTabuleiro() {
        return tabuleiro;
    }
    
    public String toString() {
        String ilustracaoTerminal = "";
        
        for (int i = 0; i < this.tabuleiro.length; i++) {
            ilustracaoTerminal += "\n";
            for (int j = 0; j < tabuleiro[i].length; j++) {
                Pecas peca = tabuleiro[i][j];
                ilustracaoTerminal += peca.toString() + "|";
            }
        }

        return ilustracaoTerminal;
    }

/*     public void setTabuleiro(Pecas[][] tabuleiro) {
        this.tabuleiro = tabuleiro;
    } */
}