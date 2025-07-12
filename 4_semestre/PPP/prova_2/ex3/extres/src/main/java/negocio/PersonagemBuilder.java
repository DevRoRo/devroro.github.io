package negocio;

import java.util.ArrayList;

public class PersonagemBuilder {
    private Raca raca;
    private Classe classe;
    private ArrayList<Arma> armas;
    

    public PersonagemBuilder(Raca raca){
        this.raca = raca;
    }

    public PersonagemBuilder classe(Classe classe) {
        this.classe = classe;
        return this;
    }

    public PersonagemBuilder armas(ArrayList<Arma> armas){
        this.armas = armas;
        return this;
    }

    public Personagem build(){
        Personagem personagem = new Personagem(this.classe, this.raca, this.armas);

        return personagem;
    }
}
