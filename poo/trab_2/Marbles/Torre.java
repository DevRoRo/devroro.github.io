package Marbles;

public class Torre extends Pecas {

    public Torre (Cor cor) {
        super(cor);
    }
    
    @Override
    public String toString() {
        String corPeca = "";

        if (this.getCor()==Cor.BRANCO) {
            corPeca = "\u265c";
        } else {
            corPeca = "\u2656";
        }

        return corPeca;
    }

}
