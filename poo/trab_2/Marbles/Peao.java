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

    public boolean movimentoValido(Object[] pecaEMovimento) {
        
        boolean valido = false;

        int[] parOrdenado = (int[]) pecaEMovimento[1];

        if (super.movimentoValido(parOrdenado)) /* Buscar tratar exceções para movimentos inválidos enquanto instância de peça
        para retornar ao usuário como prosseguir */{

            if(this.primeiroMovimento) {
                /* A partir daqui é necessário ter o registro da posição atual de cada peça, atualmente no código não existe
                 * nenhum atributo responsável por isso, a única classe que sabe a localização de determinada peça é a classe Tabuleiro.
                 * É necessário implementar o registro das posições das peças antes de seguir a validação do movimento das instâncias de
                 * classe filhas.
                 */
            }

        }

        return valido;
    }

}
