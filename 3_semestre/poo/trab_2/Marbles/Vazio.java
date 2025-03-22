package Marbles;

/**
 * Classe que instancia os espaços vazios no tabuleiro, recebe Cor.VAZIO para abstrair não-participação das suas instâncias em nenhum time de Jogador.
 */
public class Vazio extends Pecas {

    public Vazio(){
        super(Cor.VAZIO);
    }

    @Override
    public String toString() {
        return " ";
    }
}
