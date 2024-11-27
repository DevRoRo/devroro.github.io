import Marbles.*;

public class Tabuleiro {

    private Pecas[][] tabuleiro = new Pecas[8][8];

    public Tabuleiro() {
        
        for (int i = 0; i < tabuleiro.length; i++) {
            
            for (int j = 0; j < tabuleiro[i].length; j++) {

                if(i == 0 || i == 7){

                    Cor cor;

                    if(i == 0) {
                        cor = Cor.BRANCO;
                    } else {
                        cor = Cor.PRETO;
                    }

                    switch (j) {
                        case 0:
                        case 7:
                            tabuleiro[i][j] = new Torre(cor);
                            break;

                        case 1:
                        case 6:
                            tabuleiro[i][j] = new Cavalo(cor);
                            break;

                        case 2:
                        case 5:
                            tabuleiro[i][j] = new Bispo(cor);
                            break;

                        case 3:
                            tabuleiro[i][j] = new Rei(cor);
                            break;
                        case 4:
                            tabuleiro[i][j] = new Rainha(cor);
                            break;
                    
                        default:
                            break;
                    }
                }
                
                if(i == 1 || i == 6) {
                    Cor cor;

                    if (i == 1) {
                        cor = Cor.BRANCO;
                    } else {
                        cor = Cor.PRETO;
                    }

                    tabuleiro[i][j] = new Peao(cor);
                } else if (6 > i && i > 1) {
                    tabuleiro[i][j] = new Vazio();
                }
                


            }
        }

    }

/*     public Pecas[][] getTabuleiro() {
        return tabuleiro;
    } */
    
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