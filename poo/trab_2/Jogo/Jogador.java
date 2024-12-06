package Jogo;
import Marbles.Cor;
import Marbles.Pecas;

public class Jogador {
    private Cor time;
    private String nome;

    public Jogador(String nome, Cor cor) {
        this.time = cor;
        this.nome = nome;
    }
    
    public Cor getTime() {
        return time;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void validarMovimento (Pecas peca) throws Exception {

        if (peca.getCor() == Cor.VAZIO || peca.getCor() != this.getTime()) throw new Exception("Declare a peça de acordo com a cor do seu time");
    }
}

