package Marbles;

public class Peao extends Pecas{
    private boolean primeiroMovimento;

    public Peao (Cor cor) {
        super(cor);
        this.primeiroMovimento = true;
    }
    
    @Override
    public String toString() {
        String corPeca = "";

        if (this.getCor()==Cor.BRANCO) {
            corPeca = "\u2659";
        } else {
            corPeca = "\u265f";
        }

        return corPeca;
    }

    public boolean movimentoValido(int[] parOrdenado) {
        
        boolean valido = false;

        if (super.movimentoValido(parOrdenado)) /* Buscar atirar exceções para movimentos inválidos enquanto instância de peça
        para catar no método executarMovimento da classe tabuleiro */{

            if(this.primeiroMovimento) {

                int xFinal = parOrdenado[0];
                int yFinal = parOrdenado[1];

                int [] parOrdenadoAtual = this.getParOrdenado();
                int xAtual = parOrdenadoAtual[0];
                int yAtual = parOrdenadoAtual[1];

            }

        }

        return valido;
    }

}
