package Marbles;

public class Bispo extends Pecas {

    public Bispo (Cor cor) {
        super(cor);
    }

    @Override
    public String toString() {
        String corPeca = "";

        if (this.getCor()==Cor.BRANCO) {
            corPeca = "\u2657";
        } else {
            corPeca = "\u265d";
        }

        return corPeca;
    }
    
}
