package Jogo;
import Marbles.Cor;
import Marbles.Pecas;

<<<<<<< HEAD
<<<<<<< HEAD
/**
 * Classe que regra a instância de Jogador, determinando qual Cor de peças que este poderá interagir e um nome para identificação
 */
=======
>>>>>>> da701e9 (Tabuleiro funcional, todas as peças devidamente geradas, movimento funcional e restringidos para sobreposição de mesma cor, manter no mesmo lugar e sair para além do tabuleiro, sistema de jogadores com time de peças específicos, método de encerrar jogo com base na presença da peça rainha e declaração de vencedor.)
=======
/**
 * Classe que regra a instância de Jogador, determinando qual Cor de peças que este poderá interagir e um nome para identificação
 */
>>>>>>> 659ccc9 (Documentada a finalidade das peças e dos métodos de validação de movimento.)
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
<<<<<<< HEAD
<<<<<<< HEAD
    //método responsável por identificar se a peça escolhida pertence ao time do jogador.
=======

>>>>>>> da701e9 (Tabuleiro funcional, todas as peças devidamente geradas, movimento funcional e restringidos para sobreposição de mesma cor, manter no mesmo lugar e sair para além do tabuleiro, sistema de jogadores com time de peças específicos, método de encerrar jogo com base na presença da peça rainha e declaração de vencedor.)
=======
    //método responsável por identificar se a peça escolhida pertence ao time do jogador.
>>>>>>> 659ccc9 (Documentada a finalidade das peças e dos métodos de validação de movimento.)
    public void validarMovimento (Pecas peca) throws Exception {

        if (peca.getCor() == Cor.VAZIO || peca.getCor() != this.getTime()) throw new Exception("Declare a peça de acordo com a cor do seu time");
    }
}

