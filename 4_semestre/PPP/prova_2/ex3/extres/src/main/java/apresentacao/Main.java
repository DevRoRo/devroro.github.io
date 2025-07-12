package apresentacao;

import java.util.ArrayList;

import negocio.Arma;
import negocio.Classe;
import negocio.Guerreiro;
import negocio.Humano;
import negocio.Personagem;
import negocio.PersonagemBuilder;
import negocio.Raca;

//Utilizado método builder para resolução do exercício 3

public class Main{
    public static void main(String args[]) {
        
        Classe classe = new Guerreiro();
        Raca raca = new Humano();

        ArrayList<Arma> items = new ArrayList<Arma>();
        Arma item1 = new Arma("Espada");
        Arma item2 = new Arma("Escudo");
        items.add(item1);
        items.add(item2);

        Personagem personagem = new PersonagemBuilder(raca).classe(classe).armas(items).build();  

        System.out.println(personagem);

    }
}