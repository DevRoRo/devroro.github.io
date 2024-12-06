package Jogo;
<<<<<<< HEAD
<<<<<<< HEAD
/**
 * Armazena o par ordenado de posição de uma instância de Pecas
 */
=======

>>>>>>> d6b59be (Tabuleiro funcional com todas as peças do jogo, método de movimentação geral das peças criado.)
=======
/**
 * Armazena o par ordenado de posição de uma instância de Pecas
 */
>>>>>>> 659ccc9 (Documentada a finalidade das peças e dos métodos de validação de movimento.)
public class Posicao {
    int x;
    int y;

    public Posicao (int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
}
