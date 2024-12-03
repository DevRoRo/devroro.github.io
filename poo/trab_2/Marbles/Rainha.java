package Marbles;

public class Rainha extends Pecas {

    public Rainha (Cor cor) {
        super(cor);
    }

    @Override
    public String toString() {
        String corPeca = "";

        if (this.getCor()==Cor.BRANCO) {
            corPeca = "\u265b";
        } else {
            corPeca = "\u2655";
        }

        return corPeca;
    }
    
}
