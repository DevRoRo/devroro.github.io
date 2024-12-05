package Marbles;

public class Peao extends Pecas{

    public Peao (Cor cor) {
        super(cor);
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

}
