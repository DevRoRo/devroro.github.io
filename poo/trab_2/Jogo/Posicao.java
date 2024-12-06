package Jogo;
/**
 * Armazena o par ordenado de posição de uma instância de Pecas
 */
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
