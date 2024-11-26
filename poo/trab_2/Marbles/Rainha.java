package Marbles;

public class Rainha extends Pecas {

    @Override
    public String toString() {
        String corPeca = "";

        if (this.getCor()==Cor.BRANCO) {
            corPeca = "\u2655";
        } else {
            corPeca = "\u265b";
        }

        return corPeca;
    }
    
}
