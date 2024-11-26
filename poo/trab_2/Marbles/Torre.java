package Marbles;

public class Torre extends Pecas {
    
    @Override
    public String toString() {
        String corPeca = "";

        if (this.getCor()==Cor.BRANCO) {
            corPeca = "\u2656";
        } else {
            corPeca = "\u265c";
        }

        return corPeca;
    }

}
