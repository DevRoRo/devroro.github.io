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

    public boolean movimentoValido(int[] parOrdenado) throws Exception { /* Talvez não precise retornar boolean e ser void */
        
        boolean valido = false;

        if (super.movimentoValido(parOrdenado)) {

            int xFinal = parOrdenado[0];
            int yFinal = parOrdenado[1];

            int [] parOrdenadoAtual = this.getParOrdenado();
            int xAtual = parOrdenadoAtual[0];
            int yAtual = parOrdenadoAtual[1];

            Cor corPeca = this.getCor();

            int qtdCasasPermitidas;

            if(this.primeiroMovimento) {
                qtdCasasPermitidas =  2;
            } else {
                qtdCasasPermitidas = 1;
            }

            switch (corPeca) {
                case BRANCO:
                
                    if(xFinal == xAtual && yFinal <= yAtual-qtdCasasPermitidas) {

                        valido = true;

                    } else {
                        throw new Exception("movimento incorreto, declare novamente");
                    }

                break;

                case PRETO:

                    if(xFinal == xAtual && yFinal >= yAtual+qtdCasasPermitidas) {

                        valido = true;

                    } else {
                        throw new Exception("movimento incorreto, declare novamente");
                    }

                break;
            
                default:
                break;
            }

            this.primeiroMovimento = false;

        } else {
            throw new Exception("Informe coordenadas válidas para uma matrix 8x8");
        }

        return valido;
    }

}
