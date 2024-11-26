package Marbles;

public class Rainha extends Pecas {

    public Rainha (Cor cor) {
        super(cor);
    }

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
