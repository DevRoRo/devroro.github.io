import Marbles.*;

public class Tabuleiro {

    private Pecas[][] tabuleiro = new Pecas[8][8];

    public Tabuleiro() {
        
        for (int i = 0; i < tabuleiro.length; i++) {
            
            for (int j = 0; j < tabuleiro[i].length; j++) {
                
                if(i == 1) {
                    tabuleiro[i][j] = new Peao(Cor.BRANCO);
                }
                
            }
        }

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