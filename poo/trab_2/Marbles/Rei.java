package Marbles;

public class Rei extends Pecas {

    public Rei (Cor cor) {
        super(cor);
    }
    
    @Override
    public String toString() {
        String corPeca = "";

        if (this.getCor()==Cor.BRANCO) {
            corPeca = "\u265a";
        } else {
            corPeca = "\u2654";
        }

        return corPeca;
    }

}