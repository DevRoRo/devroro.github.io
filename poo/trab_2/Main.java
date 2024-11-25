import Marbles.*;

public class Main {

    public static void main(String []args) {
        Tabuleiro tabuleiro = new Tabuleiro();

        Bispo bispo = new Bispo();
        Peao peao = new Peao();

        Pecas[][] novoT = {{bispo, peao}};

        System.out.println(novoT[0][0].toString());

        tabuleiro.setTabuleiro(null);
    }
}
