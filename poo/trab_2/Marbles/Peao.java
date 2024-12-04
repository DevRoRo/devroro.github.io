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
            corPeca = "\u265f";
        } else {
            corPeca = "\u2659";
        }

        return corPeca;
    }

    public void movimentoValido(int[] parOrdenado) throws Exception {

        super.movimentoValido(parOrdenado);

        int xFinal = parOrdenado[0];
        int yFinal = parOrdenado[1];

        int [] parOrdenadoAtual = this.getParOrdenado();
        int xAtual = parOrdenadoAtual[0];
        int yAtual = parOrdenadoAtual[1];

        Cor corPeca = this.getCor();
        
        if (corPeca == Cor.BRANCO) {

            if (yFinal > yAtual) {
                throw new Exception("Não é permitido voltar casas, tente novamente.");
            } else if (this.primeiroMovimento && yFinal < yAtual-2) {
                throw new Exception("Não é permitido avançar mais de duas casas na primeira jogada, tente novamente.");
            } else if (yFinal < yAtual-1) {
                throw new Exception("Não é permitido avançar mais de uma casa, tente novamente");
            }

        } else {

            if (yFinal < yAtual) {
                throw new Exception("Não é permitido voltar casas, tente novamente.");
            } else if (this.primeiroMovimento && yFinal > yAtual+2) {
                throw new Exception("Não é permitido avançar mais de duas casas na primeira jogada, tente novamente.");
            } else if (yFinal > yAtual+1) {
                throw new Exception("Não é permitido avançar mais de uma casa, tente novamente");
            }
        }

        this.primeiroMovimento = false;
    }
}