package negocio;

import java.util.ArrayList;

public class Personagem {
    private Classe classe;
    private Raca raca;
    private ArrayList<Arma> armas;

    public Personagem(Classe classe, Raca raca, ArrayList<Arma> armas) {
        this.classe = classe;
        this.raca = raca;
        this.armas = armas;
    }

    public Classe getclasse() {
        return classe;
    }
    public void setclasse(Classe classe) {
        this.classe = classe;
    }
    public Raca getraca() {
        return raca;
    }
    public void setraca(Raca raca) {
        this.raca = raca;
    }
    public ArrayList<Arma> getArmas() {
        return armas;
    }
    public void setArmas(ArrayList<Arma> armas) {
        this.armas = armas;
    }

    @Override
    public String toString() {
        String itens ="";

        for (int index = 0; index < this.armas.size(); index++) {
            itens+=this.armas.get(index).getNome()+"\n";
        }
        return
        "\nclasse: "+this.classe.getNome()+
        "\nraca: "+this.raca.getNome()+
        "\nArmas:\n"+itens;
    }
}
