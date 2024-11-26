package Marbles;

public class Rei extends Pecas {
    
    @Override
    public String toString() {
        String corPeca = "";

        if (this.getCor()==Cor.BRANCO) {
            corPeca = "\u2654";
        } else {
            corPeca = "\u265A";
        }

        return corPeca;
    }

}