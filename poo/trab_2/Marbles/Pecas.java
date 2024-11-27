package Marbles;

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

public boolean movimentoValido(int[] parOrdenado) {

    boolean valido = false;

    if (parOrdenado[0] < 8 && parOrdenado[1] < 8) {
        valido = true;
    }

    return valido;
}

}
