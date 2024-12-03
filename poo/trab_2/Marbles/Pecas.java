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

public boolean movimentoValido(int[] parOrdenado) throws Exception { /* talvez possa ser void */

    boolean valido = false;
    int x = parOrdenado[0];
    int y = parOrdenado[1];

    if (x < 8 && y < 8) {
        valido = true;
    }

    return valido;
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
