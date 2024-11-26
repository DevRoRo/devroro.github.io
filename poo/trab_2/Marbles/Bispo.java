package Marbles;

public class Bispo extends Pecas {

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
