package Marbles;

import java.util.ArrayList;
import java.util.List;

import Mesa.Tabuleiro;

public abstract class Pecas {
private Cor cor;
private int[] parOrdenado; /* Atributo que guardará o par ordenado (x e depois y, portanto parOrdenado[0] = x e ...[1] = y)
necessário implementar método set que extraia da instância de tabuleiro a posição da instância de peças nele. */

public Pecas(Cor cor) {
    this.cor = cor;
}

public Cor getCor() {
    return cor;
}

public void setCor(Cor cor) {
    this.cor = cor;
}

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
}

}
