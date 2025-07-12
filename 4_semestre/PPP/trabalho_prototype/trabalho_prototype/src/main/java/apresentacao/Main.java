package apresentacao;

import negocio.MonstroPrototype;
import negocio.Orc;
import negocio.listaMonstros;

public class Main {
    public static void main(String[] args) {
        MonstroPrototype goblin1 = listaMonstros.obterModelo("Goblin");
        if (goblin1 != null) {
            System.out.println("Criado: " + goblin1);
            goblin1.atacar();
        }

        MonstroPrototype goblin2 = listaMonstros.obterModelo("Goblin");
        if (goblin2 != null) {
            ((Orc) goblin2).setSaude(70);
            System.out.println("Criado: " + goblin2);
            goblin2.atacar();
        }

        MonstroPrototype orcGuerreiro = listaMonstros.obterModelo("Orc Guerreiro");
        if (orcGuerreiro != null) {
            System.out.println("Criado: " + orcGuerreiro);
            orcGuerreiro.atacar();
        }

        Orc orcPersonalizado = new Orc("Orc de Elite", 150, 35, "espada grande");
        listaMonstros.adicionarNaListaDeMonstros(orcPersonalizado);

        MonstroPrototype orcElite1 = listaMonstros.obterModelo("Orc de Elite");
        if (orcElite1 != null) {
            System.out.println("Criado: " + orcElite1);
            orcElite1.atacar();
            ((Orc) orcElite1).setArma("Espada Grande Flamejante");
        }

        MonstroPrototype orcElite2 = listaMonstros.obterModelo("Orc de Elite");
        if (orcElite2 != null) {
            System.out.println("Criado: " + orcElite2);
            orcElite2.atacar();
        }

        System.out.println("\nGoblin1 original após modificações em goblin2: " + goblin1);
        System.out.println("OrcPersonalizado original após modificações em orcElite1: " + orcPersonalizado);
    }
}