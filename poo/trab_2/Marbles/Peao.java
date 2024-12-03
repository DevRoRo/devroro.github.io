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
                
            if(xFinal == xAtual) /* Essa condição não é válida nos casos onde há a eliminação de peça inimiga, revisar a lógica após
            a implementação da mecânica de eliminar peças inimigas */ {

                System.out.println("Xfinal: "+xFinal+"\nYfinal: "+yFinal+"\nXatual: "+xAtual+"\nYatual: "+yAtual+"\ncorPeca: "+corPeca+"\nqtdCasasP: "+qtdCasasPermitidas);

                if (yFinal >= yAtual-qtdCasasPermitidas && corPeca == Cor.BRANCO) {

                    valido = true;

                } else if (yFinal <= yAtual+qtdCasasPermitidas && corPeca == Cor.PRETO) {
                    
                    valido = true;

                } else {
                    
                    throw new Exception("Eixo y declarado incorretamente, declare novamente");

                }
            } else {

                throw new Exception("Eixo x declarado incorretamente, declare novamente");

            }

            this.primeiroMovimento = false;

        } 

        return valido;
    }
}