package Jogo;

import java.util.Scanner;

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
import Marbles.Cor;
=======
>>>>>>> d6b59be (Tabuleiro funcional com todas as peças do jogo, método de movimentação geral das peças criado.)
=======
import Marbles.Cor;
>>>>>>> da701e9 (Tabuleiro funcional, todas as peças devidamente geradas, movimento funcional e restringidos para sobreposição de mesma cor, manter no mesmo lugar e sair para além do tabuleiro, sistema de jogadores com time de peças específicos, método de encerrar jogo com base na presença da peça rainha e declaração de vencedor.)
=======
>>>>>>> d6b59be (Tabuleiro funcional com todas as peças do jogo, método de movimentação geral das peças criado.)
=======
import Marbles.Cor;
>>>>>>> da701e9 (Tabuleiro funcional, todas as peças devidamente geradas, movimento funcional e restringidos para sobreposição de mesma cor, manter no mesmo lugar e sair para além do tabuleiro, sistema de jogadores com time de peças específicos, método de encerrar jogo com base na presença da peça rainha e declaração de vencedor.)
import Marbles.Pecas;

public class Main {

    public static void main(String []args) {

        Scanner in = new Scanner (System.in);

        Tabuleiro jogo = new Tabuleiro();

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> da701e9 (Tabuleiro funcional, todas as peças devidamente geradas, movimento funcional e restringidos para sobreposição de mesma cor, manter no mesmo lugar e sair para além do tabuleiro, sistema de jogadores com time de peças específicos, método de encerrar jogo com base na presença da peça rainha e declaração de vencedor.)
=======
>>>>>>> da701e9 (Tabuleiro funcional, todas as peças devidamente geradas, movimento funcional e restringidos para sobreposição de mesma cor, manter no mesmo lugar e sair para além do tabuleiro, sistema de jogadores com time de peças específicos, método de encerrar jogo com base na presença da peça rainha e declaração de vencedor.)
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

<<<<<<< HEAD
<<<<<<< HEAD
        System.out.println(jogo);

        while (true) {

            if (turno % 2 == 0) {
                jogador = jogador1;
                System.out.println("Turno de: "+jogador.getNome());
            } else {
                jogador = jogador2;
                System.out.println("Turno de "+jogador.getNome());
            }
=======
=======
>>>>>>> da701e9 (Tabuleiro funcional, todas as peças devidamente geradas, movimento funcional e restringidos para sobreposição de mesma cor, manter no mesmo lugar e sair para além do tabuleiro, sistema de jogadores com time de peças específicos, método de encerrar jogo com base na presença da peça rainha e declaração de vencedor.)
        System.out.println(jogo);

        while (true) {
<<<<<<< HEAD
>>>>>>> d6b59be (Tabuleiro funcional com todas as peças do jogo, método de movimentação geral das peças criado.)
=======

            if (turno % 2 == 0) {
                jogador = jogador1;
                System.out.println("Turno de: "+jogador.getNome());
            } else {
                jogador = jogador2;
                System.out.println("Turno de "+jogador.getNome());
            }
>>>>>>> da701e9 (Tabuleiro funcional, todas as peças devidamente geradas, movimento funcional e restringidos para sobreposição de mesma cor, manter no mesmo lugar e sair para além do tabuleiro, sistema de jogadores com time de peças específicos, método de encerrar jogo com base na presença da peça rainha e declaração de vencedor.)
=======
=======
>>>>>>> da701e9 (Tabuleiro funcional, todas as peças devidamente geradas, movimento funcional e restringidos para sobreposição de mesma cor, manter no mesmo lugar e sair para além do tabuleiro, sistema de jogadores com time de peças específicos, método de encerrar jogo com base na presença da peça rainha e declaração de vencedor.)
        System.out.println(jogo);

        while (true) {
<<<<<<< HEAD
>>>>>>> d6b59be (Tabuleiro funcional com todas as peças do jogo, método de movimentação geral das peças criado.)
=======

            if (turno % 2 == 0) {
                jogador = jogador1;
                System.out.println("Turno de: "+jogador.getNome());
            } else {
                jogador = jogador2;
                System.out.println("Turno de "+jogador.getNome());
            }
>>>>>>> da701e9 (Tabuleiro funcional, todas as peças devidamente geradas, movimento funcional e restringidos para sobreposição de mesma cor, manter no mesmo lugar e sair para além do tabuleiro, sistema de jogadores com time de peças específicos, método de encerrar jogo com base na presença da peça rainha e declaração de vencedor.)
                    
            System.out.println("Escolha as coordenadas de uma peça e para onde deseja movê-la no seguinte formato: x y x y");
            int x = in.nextInt();
            int y = in.nextInt();
            int xFinal = in.nextInt();
            int yFinal = in.nextInt();
            Pecas [][] tabuleiro = jogo.getTabuleiro();

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> da701e9 (Tabuleiro funcional, todas as peças devidamente geradas, movimento funcional e restringidos para sobreposição de mesma cor, manter no mesmo lugar e sair para além do tabuleiro, sistema de jogadores com time de peças específicos, método de encerrar jogo com base na presença da peça rainha e declaração de vencedor.)
=======
>>>>>>> da701e9 (Tabuleiro funcional, todas as peças devidamente geradas, movimento funcional e restringidos para sobreposição de mesma cor, manter no mesmo lugar e sair para além do tabuleiro, sistema de jogadores com time de peças específicos, método de encerrar jogo com base na presença da peça rainha e declaração de vencedor.)
            try {
                jogador.validarMovimento(tabuleiro[y][x]);
                jogo.executarMovimento(tabuleiro[y][x], new Posicao(xFinal, yFinal));
            } catch (Exception e) {
                System.out.println(e);
                System.out.println(jogo);
                continue;
            }
<<<<<<< HEAD
<<<<<<< HEAD

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

=======
=======
>>>>>>> d6b59be (Tabuleiro funcional com todas as peças do jogo, método de movimentação geral das peças criado.)
            jogo.executarMovimento(tabuleiro[y][x], new Posicao(xFinal, yFinal));

            System.out.println(jogo);

<<<<<<< HEAD
>>>>>>> d6b59be (Tabuleiro funcional com todas as peças do jogo, método de movimentação geral das peças criado.)
=======

            System.out.println(jogo);

=======

            System.out.println(jogo);

>>>>>>> da701e9 (Tabuleiro funcional, todas as peças devidamente geradas, movimento funcional e restringidos para sobreposição de mesma cor, manter no mesmo lugar e sair para além do tabuleiro, sistema de jogadores com time de peças específicos, método de encerrar jogo com base na presença da peça rainha e declaração de vencedor.)
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

<<<<<<< HEAD
>>>>>>> da701e9 (Tabuleiro funcional, todas as peças devidamente geradas, movimento funcional e restringidos para sobreposição de mesma cor, manter no mesmo lugar e sair para além do tabuleiro, sistema de jogadores com time de peças específicos, método de encerrar jogo com base na presença da peça rainha e declaração de vencedor.)
=======
>>>>>>> d6b59be (Tabuleiro funcional com todas as peças do jogo, método de movimentação geral das peças criado.)
=======
>>>>>>> da701e9 (Tabuleiro funcional, todas as peças devidamente geradas, movimento funcional e restringidos para sobreposição de mesma cor, manter no mesmo lugar e sair para além do tabuleiro, sistema de jogadores com time de peças específicos, método de encerrar jogo com base na presença da peça rainha e declaração de vencedor.)
        }
    }
}
