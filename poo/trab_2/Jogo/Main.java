package Jogo;

import java.util.Scanner;

import Marbles.Cor;
import Marbles.Pecas;

public class Main {

    public static void main(String []args) {

        Scanner in = new Scanner (System.in);

        Tabuleiro jogo = new Tabuleiro();

        Jogador jogador;

        int turno = 1;

        Object [] parEncerrarJogoeRainha;

        boolean jogoTermina;

        boolean temRainhaBranca;

        System.out.println("======XADREZ======");

        System.out.println("Insira o nome do jogador que utilizará as peças brancas:");
        Jogador jogador1 = new Jogador(in.nextLine(), Cor.BRANCO);

        System.out.println("Insira o nome do jogador que utilizará as peças pretas:");
        Jogador jogador2 = new Jogador(in.nextLine(), Cor.PRETO);

        System.out.println(jogo);

        while (true) {

            if (turno % 2 == 0) {
                jogador = jogador1;
                System.out.println("Turno de: "+jogador.getNome());
            } else {
                jogador = jogador2;
                System.out.println("Turno de "+jogador.getNome());
            }
                    
            System.out.println("Escolha as coordenadas de uma peça e para onde deseja movê-la no seguinte formato: x y x y");
            int x = in.nextInt();
            int y = in.nextInt();
            int xFinal = in.nextInt();
            int yFinal = in.nextInt();
            Pecas [][] tabuleiro = jogo.getTabuleiro();

            try {
                jogador.validarMovimento(tabuleiro[y][x]);
                jogo.executarMovimento(tabuleiro[y][x], new Posicao(xFinal, yFinal));
            } catch (Exception e) {
                System.out.println(e);
                System.out.println(jogo);
                continue;
            }

            System.out.println(jogo);

            parEncerrarJogoeRainha = jogo.jogoEncerrado();
            jogoTermina = (boolean) parEncerrarJogoeRainha[0];
            temRainhaBranca = (boolean) parEncerrarJogoeRainha[1];

            if(jogoTermina){
                System.out.println("jogo encerrado.");
                if(temRainhaBranca){
                    jogador = jogador1;
                } else {
                    jogador = jogador2;
                }
                System.out.println("Vencedor: "+jogador.getNome());
            
                break;
            }

            turno++;

        }
    }
}
