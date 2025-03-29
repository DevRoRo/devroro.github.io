package Armas;

import SistemaDano.Dano;

public class Arma {
    private String nome;
    private Dano dano;

    public Arma (String nome, Dano dano) {
        this.nome = nome;
        this.dano = dano;
    }

    public Dano getDano() {
        return dano;
    }

    @Override
    public String toString() {
        String string = nome + " - dano: " + dano.toString();
        return string;
    }
}
    

