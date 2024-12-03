import java.util.Scanner;

import Marbles.Cor;
import Marbles.Pecas;

public class Main {

    public static void main(String []args) {

        Scanner in = new Scanner(System.in);

        Tabuleiro jogo = new Tabuleiro();
        Pecas [][] tabuleiro = jogo.getTabuleiro();

        Jogador jogador1 = new Jogador("roro", Cor.BRANCO);

        Jogador jogador2 = new Jogador("Vini", Cor.PRETO);

        Pecas peca;

        Object [] jogada;

        boolean t = true;

        System.out.println(jogo);

        while (t) {
            System.out.println("Insira as coordenadas x e y da peça a ser selecionada");
            int x = in.nextInt();
            int y = in.nextInt();

            peca = tabuleiro[y][x];

            System.out.println("Informe as coordenadas que a peça será movimentada para");

            jogada = jogador1.declararMovimento(peca, in.nextInt(), in.nextInt());

            try {
                jogo.executarMovimento(jogada);
            } catch (Exception e) {
                System.out.println(e);
                continue;
            }

            System.out.println(jogo);

            System.out.println("Deseja continuar o jogo? y/n");

            switch (in.next()) {
                case "y":
                    break;

                case "n":
                    t = false;
                    break;
            
                default:
                    break;
            }
        }
    }
}
