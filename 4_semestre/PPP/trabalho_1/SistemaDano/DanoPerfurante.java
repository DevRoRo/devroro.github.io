package SistemaDano;
import Personagens.Personagem;

public class DanoPerfurante implements Dano {
    private int valorDano;
    private float ignorarDefesa;

    public DanoPerfurante (int valorDano, float ignorarDefesa){
        this.valorDano = valorDano;
        this.ignorarDefesa = ignorarDefesa;
    }

    @Override
    public void causarDano(Personagem personagem) {
        int vidaAtual = personagem.getVida();
        int defesaAtual = personagem.getDefesa();
        int defesaIgnorada = (int) (defesaAtual * ignorarDefesa);

        vidaAtual = vidaAtual - (valorDano - (defesaAtual-defesaIgnorada));
    }

    @Override
    public String toString() {
        String string = ""+this.valorDano;
        return string;
    }
}
