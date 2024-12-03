package Marbles;

public class Cavalo extends Pecas{
    
    public Cavalo (Cor cor) {
        super(cor);
    }

    @Override
    public String toString() {
        String corPeca = "";

        if (this.getCor()==Cor.BRANCO) {
            corPeca = "\u265e";
        } else {
            corPeca = "\u2658";
        }

        return corPeca;
    }

}
