import Marbles.*;

public class Tabuleiro {

    private Pecas[][] tabuleiro = new Pecas[8][8];

    public Tabuleiro() {
        
        for (int i = 0; i < tabuleiro.length; i++) {
            
            for (int j = 0; j < tabuleiro[i].length; j++) {

                int x = j;
                int y = i;

                if(y == 0 || y == 7){

                    Cor cor;

                    if(y == 7) {
                        cor = Cor.BRANCO;
                    } else {
                        cor = Cor.PRETO;
                    }

                    switch (x) {
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
                
                if(y == 1 || y == 6) {

                    Cor cor;

                    if (y == 6) {
                        cor = Cor.BRANCO;
                    } else {
                        cor = Cor.PRETO;
                    }

                    Pecas peao = new Peao(cor);
                    peao.setParOrdenado(x, y);
                    tabuleiro[y][x] = peao;
                    
                } else if (6 > y && y > 1) {

                    tabuleiro[y][x] = new Vazio();

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

    private void verificarSobreposicao (Object[] pecaEmovimento) throws Exception {

        Pecas peca = (Pecas) pecaEmovimento[0];
        int []  parOrdenado = (int []) pecaEmovimento[1];

        int x = parOrdenado[0];
        int y = parOrdenado[1];

        if  (peca.getCor() == tabuleiro[y][x].getCor()) {
            throw new Exception("Não pode sobrepor peças da mesma cor, tente novamente");
        }
        
    }

    public void executarMovimento(Object[] pecaEMovimento) throws Exception {

/*         verificarSobreposicao(pecaEMovimento);
 */
        Pecas pecaMovimentada = (Pecas) pecaEMovimento[0];

        int[] parOrdenadoFinal = (int[]) pecaEMovimento[1];

        pecaMovimentada.movimentoValido(parOrdenadoFinal);
    
        int x = parOrdenadoFinal[0];
        int y = parOrdenadoFinal[1];

        int [] parOrdenadoAtual = pecaMovimentada.getParOrdenado();
        int xAtual  = parOrdenadoAtual[0];
        int yAtual = parOrdenadoAtual[1];

        tabuleiro[y][x] = pecaMovimentada;

        pecaMovimentada.setParOrdenado(x, y);

        tabuleiro[yAtual][xAtual] = new Vazio();
    }
} 