import Marbles.Cor;
import Marbles.Pecas;

public class Main {

    public static void main(String []args) {

        Tabuleiro jogo = new Tabuleiro();
        Pecas [][] tabuleiro = jogo.getTabuleiro();

        Jogador jogador1 = new Jogador("roro", Cor.BRANCO);

        Jogador jogador2 = new Jogador("Vini", Cor.PRETO);

        System.out.println(jogo);

        Pecas peca = tabuleiro[6][0];

        Object [] jogadaJogador1 = jogador1.declararMovimento(peca, 0, 4);

        jogo.executarMovimento(jogadaJogador1);

        System.out.println(jogo);

        Pecas peca2 = tabuleiro[1][0];
        
        Object [] jogadaJogador2 = jogador2.declararMovimento(peca2, 0, 3);
        
        jogo.executarMovimento(jogadaJogador2);

        System.out.println(jogo);

        /* O erro está na segunda parte da proposição lógica envolvendo o yfinal e atual */
            
    }
}
