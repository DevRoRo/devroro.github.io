package Personagens;

import java.util.ArrayList;
import java.util.List;

import Armas.Arma;

public class Personagem {
    private String nome;
    private int vida;
    private int defesa;
    private Arma armaEquipada;

    private List<Arma> inventario = new ArrayList<Arma>();

    public Personagem (String nome, int vida, int defesa) {
        this.nome = nome;
        this.vida = vida;
        this.defesa = defesa;
    }

    public String getNome() {
        return nome;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getDefesa() {
        return defesa;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    public void setArmaEquipada(Arma armaEquipada) {
        this.armaEquipada = armaEquipada;
    }

    public Arma getArmaEquipada() {
        return armaEquipada;
    }

    public void mostrarInventario() {
        List<Arma> inventario = this.inventario;
        for (int i = 0; i < inventario.size(); i++) {
            System.out.println(i + "-" + inventario.get(i).toString());    
        }
    }

    public void adicionarAoInventario(Arma arma) {
        inventario.add(arma);
    }

    public void escolherArma(int indexArma) {
        adicionarAoInventario(armaEquipada);
        this.armaEquipada = this.inventario.get(indexArma);
        this.inventario.remove(indexArma);
    }

    public void atacar (Personagem personagem) {
        armaEquipada.getDano().causarDano(personagem);
    }
}