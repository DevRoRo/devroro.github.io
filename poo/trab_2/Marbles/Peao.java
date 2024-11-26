package Marbles;

public class Peao extends Pecas{

    public Peao (Cor cor) {
        super(cor);
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

}
