package SistemaDano;

import Personagens.Personagem;

public class DanoCorte implements Dano {
    private int valorDano;
    private int contadorSangramento;

    public DanoCorte (int valorDano, int contadorSangramento) {
        this.valorDano = valorDano;
        this.contadorSangramento = contadorSangramento;
    }

    @Override
    public void causarDano(Personagem personagem) {
        int vidaAtual = personagem.getVida();
        int defesaAtual = personagem.getDefesa();
        
        vidaAtual = vidaAtual - (this.valorDano - defesaAtual) - contadorSangramento;
        System.out.println(personagem.getNome()+"sofreu "+(this.valorDano - defesaAtual)+" de dano");
        System.out.println(personagem.getNome()+"sofreu "+contadorSangramento+" de dano de sangramento");
        contadorSangramento++;

        personagem.setVida(vidaAtual);
    }

    @Override
    public String toString() {
        String string = ""+this.valorDano;
        return string;
    }
}
