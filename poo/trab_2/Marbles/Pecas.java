package Marbles;

<<<<<<< HEAD
<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;
=======
=======
>>>>>>> 71ae70a4725fc2266e72b148318a004376ccbdd4
import Jogo.Posicao;
import Jogo.Tabuleiro;

public abstract class Pecas {
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> d6b59be (Tabuleiro funcional com todas as peças do jogo, método de movimentação geral das peças criado.)

import Mesa.Tabuleiro;

public abstract class Pecas {
private Cor cor;
<<<<<<< HEAD
private int[] parOrdenado; /* Atributo que guardará o par ordenado (x e depois y, portanto parOrdenado[0] = x e ...[1] = y)
necessário implementar método set que extraia da instância de tabuleiro a posição da instância de peças nele. */
=======
=======
/* Armazena o Enum Cor responsável por identificar qual time pertence a peça */
private Cor cor;
/* par ordenado que registra o local atual da instância de peça no tabuleiro */
>>>>>>> 659ccc9 (Documentada a finalidade das peças e dos métodos de validação de movimento.)
=======
/* Armazena o Enum Cor responsável por identificar qual time pertence a peça */
private Cor cor;
/* par ordenado que registra o local atual da instância de peça no tabuleiro */
>>>>>>> 71ae70a4725fc2266e72b148318a004376ccbdd4
private Posicao posicaoAtual;

public Posicao getPosicaoAtual() {
    return posicaoAtual;
}

public void setPosicaoAtual(Posicao posicaoAtual) {
    this.posicaoAtual = posicaoAtual;
}
<<<<<<< HEAD
>>>>>>> d6b59be (Tabuleiro funcional com todas as peças do jogo, método de movimentação geral das peças criado.)
=======
>>>>>>> 71ae70a4725fc2266e72b148318a004376ccbdd4

public Pecas(Cor cor) {
    this.cor = cor;
}

public Cor getCor() {
    return cor;
}

public void setCor(Cor cor) {
    this.cor = cor;
}

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
public List<int[]> procurarInimigos (int[] parOrdenado, Tabuleiro jogo) {
    return new ArrayList<int[]>();
}

public void movimentoValido(int[] parOrdenado, List<int[]> possiveisInimigos) throws Exception {

    int x = parOrdenado[0];
    int y = parOrdenado[1];

    if(x >= 8 || y >= 8) throw new Exception("Informe coordenadas válidas para uma matrix 8x8");

    if (this.parOrdenado[0] == parOrdenado[0] && this.parOrdenado[1] == parOrdenado[1]) throw new Exception("A peça não pode se manter na mesma posição inicial, "
    +"movimento inválido. Tente novamente");
}

public int[] getParOrdenado() {
    return parOrdenado;
}

public void setParOrdenado(int x, int y) {
    int [] parOrdenado = new int[2];
    parOrdenado[0] = x;
    parOrdenado[1] = y;
    this.parOrdenado = parOrdenado;
=======
=======
/**
 * especifica as regras de movimentação de uma instância de peça, validando as regras gerais de movimentação
 * para todas as classes que herdam desta.
 */
>>>>>>> 659ccc9 (Documentada a finalidade das peças e dos métodos de validação de movimento.)
public boolean movimentoValido(Tabuleiro jogo, Posicao posicao) {
    boolean valido = true;
   
    int xAtual = this.getPosicaoAtual().getX();
    int yAtual = this.getPosicaoAtual().getY(); 

=======
/**
 * especifica as regras de movimentação de uma instância de peça, validando as regras gerais de movimentação
 * para todas as classes que herdam desta.
 */
public boolean movimentoValido(Tabuleiro jogo, Posicao posicao) {
    boolean valido = true;
   
    int xAtual = this.getPosicaoAtual().getX();
    int yAtual = this.getPosicaoAtual().getY(); 

>>>>>>> 71ae70a4725fc2266e72b148318a004376ccbdd4
    int xFinal = posicao.getX();
    int yFinal = posicao.getY();

    Pecas [][] tabuleiro = jogo.getTabuleiro();

    if (tabuleiro[yFinal][xFinal].getCor() == this.getCor()) {
        valido = false;
    }

    if (xAtual == xFinal && yAtual == yFinal) {
        valido = false;
    }

    if (xFinal >= 8 || yFinal >=8) {
        valido = false;
    }
    
<<<<<<< HEAD
<<<<<<< HEAD
    return true;
>>>>>>> d6b59be (Tabuleiro funcional com todas as peças do jogo, método de movimentação geral das peças criado.)
=======
    return valido;
>>>>>>> da701e9 (Tabuleiro funcional, todas as peças devidamente geradas, movimento funcional e restringidos para sobreposição de mesma cor, manter no mesmo lugar e sair para além do tabuleiro, sistema de jogadores com time de peças específicos, método de encerrar jogo com base na presença da peça rainha e declaração de vencedor.)
=======
    return valido;
>>>>>>> 71ae70a4725fc2266e72b148318a004376ccbdd4
}

}
