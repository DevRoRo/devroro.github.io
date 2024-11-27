package Marbles;

public class Rei extends Pecas {

    public Rei (Cor cor) {
        super(cor);
    }
    
    @Override
    public String toString() {
        String corPeca = "";

        if (this.getCor()==Cor.BRANCO) {
            corPeca = "\u2654";
        } else {
            corPeca = "\u265a";
        }

        return corPeca;
    }

}