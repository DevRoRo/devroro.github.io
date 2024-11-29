import Marbles.*;

public class Tabuleiro {

    private Pecas[][] tabuleiro = new Pecas[8][8];

    public Tabuleiro() {
        
        for (int i = 0; i < tabuleiro.length; i++) {
            
            for (int j = 0; j < tabuleiro[i].length; j++) {

                int x = j;
                int y = i;

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
                            Pecas torre = new Torre(cor);
                            torre.setParOrdenado(x, y);
                            tabuleiro[y][x] = torre;
                            break;

                        case 1:
                        case 6:
                            Pecas cavalo = new Cavalo(cor);
                            cavalo.setParOrdenado(x, y);
                            tabuleiro[y][x] = cavalo;
                            break;

                        case 2:
                        case 5:
                            Pecas bispo = new Bispo(cor);
                            bispo.setParOrdenado(x, y);
                            tabuleiro[y][x] = bispo;
                            break;

                        case 3:
                            Pecas rei = new Rei(cor);
                            rei.setParOrdenado(x, y);
                            tabuleiro[y][x] = rei;
                            break;
                        case 4:
                            Pecas rainha = new Rainha(cor);
                            rainha.setParOrdenado(x, y);
                            tabuleiro[y][x] = rainha;
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

                    Pecas peao = new Peao(cor);
                    peao.setParOrdenado(x, y);
                    tabuleiro[y][x] = peao;
                } else if (6 > i && i > 1) {
                    tabuleiro[y][x] = new Vazio();
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

    public void executarMovimento(Object[] pecaEMovimento) {

        Pecas pecaMovimentada = (Pecas) pecaEMovimento[0];

        int[] parOrdenadoFinal = (int[]) pecaEMovimento[1];

        pecaMovimentada.movimentoValido(parOrdenadoFinal); /* Usar try/catch para pegar a exceção atirada pelos métodos movimentosVálidos das classes filhas de Pecas */

        int x = parOrdenadoFinal[0];
        int y = parOrdenadoFinal[1];

        int [] parOrdenadoAtual = pecaMovimentada.getParOrdenado();

        tabuleiro[x][y] = pecaMovimentada;

        tabuleiro[parOrdenadoAtual[0]][parOrdenadoFinal[1]] = new Vazio(); /* melhorar leitura dessa parte da função, armazenar os índices de parOrdenadoAtual
        em varíaveis que comuniquem melhor a ideia de localização da peça antes do movimento */

    }
} 