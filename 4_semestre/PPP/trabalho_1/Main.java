import java.util.Scanner;

import Armas.Arma;
import Personagens.Personagem;
import SistemaDano.DanoCorte;
import SistemaDano.DanoPerfurante;
import SistemaLuta.Luta;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int scanner;
        Personagem jogador;

        Arma espada = new Arma("Espada", new DanoCorte(15, 1));

        Arma faca = new Arma("faca", new DanoPerfurante(5, 0.7f));

        Arma arcoFlecha = new Arma("Arco e flecha", new DanoPerfurante(15, 0.4f));

        Arma machado =  new Arma("Machado", new DanoCorte(10, 3));
        
        System.out.println("============================\n"+
        "Escolha o seu personagem:\n"+
        "1 - Rei\n"+
        "2 - Rainha\n"+
        "3 - Cavaleiro");
        
        scanner = in.nextInt();

        if (scanner == 1) {
            jogador = new Personagem("Rei", 50, 25);
            jogador.setArmaEquipada(faca);
            jogador.adicionarAoInventario(machado);
        } else if (scanner == 2) {
            jogador = new Personagem("Rainha", 70, 10);
            jogador.setArmaEquipada(arcoFlecha);
            jogador.adicionarAoInventario(espada);
        } else {
            jogador = new Personagem("Cavaleiro", 150, 30);
            jogador.setArmaEquipada(espada);
        }

        while (true) {
            System.out.println("============================\n"+
            "Seus status: \n"+
            "Vida: "+jogador.getVida()+
            "\nDefesa: "+jogador.getDefesa()+
            "\nArma equipada: "+jogador.getArmaEquipada().toString());

            System.out.println("============================\n"+
            "Escolha o que fazer:\n"+
            "1 - Ver inventário"+
            "\n2 - Trocar Arma"+
            "\n3 - Lutar");
            
            switch (in.nextInt()) {
                case 1:
                System.out.println("============================\n");
                jogador.mostrarInventario();
                    break;
                
                case 2:
                    System.out.println("============================\n"+
                    "Escolha o número referente a arma que quer trocar");
                    scanner = in.nextInt();
                    jogador.escolherArma(scanner);
                    break;
                
                case 3:

                    Personagem inimigo = new Personagem("Goblin", 40, 15);
                    inimigo.setArmaEquipada(faca);

                    while (!Luta.encerraLuta(jogador, inimigo)) {
                        System.out.println("============================\n"
                        +jogador.getNome()+
                        "\nVida: " +jogador.getVida()+"\n\n"+
                        inimigo.getNome()+"\nVida: "+inimigo.getVida()+"\n\n");
                        Luta.lutaPorTurno(jogador, inimigo);
                    }
                    
                    break;
            
                default:
                    break;
            }

            in.close();

        }
    }
}
