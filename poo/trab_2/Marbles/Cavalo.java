package Marbles;

public class Cavalo extends Pecas{
    
    public Cavalo (Cor cor) {
        super(cor);
    }

    @Override
    public String toString() {
        String corPeca = "";

        if (this.getCor()==Cor.BRANCO) {
            corPeca = "\u2658";
        } else {
            corPeca = "\u265e";
        }

        return corPeca;
    }

}
