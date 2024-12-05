package Jogo;

import java.util.Scanner;

import Marbles.Pecas;

public class Main {

    public static void main(String []args) {

        Scanner in = new Scanner (System.in);

        Tabuleiro jogo = new Tabuleiro();

        System.out.println(jogo);

        System.out.println("\nDigite y para jogar e n para encerrar o programa");

        while (true) {
                    
            System.out.println("Escolha as coordenadas de uma peça e para onde deseja movê-la no seguinte formato: x y x y");
            int x = in.nextInt();
            int y = in.nextInt();
            int xFinal = in.nextInt();
            int yFinal = in.nextInt();
            Pecas [][] tabuleiro = jogo.getTabuleiro();

            jogo.executarMovimento(tabuleiro[y][x], new Posicao(xFinal, yFinal));

            System.out.println(jogo);

        }
    }
}
