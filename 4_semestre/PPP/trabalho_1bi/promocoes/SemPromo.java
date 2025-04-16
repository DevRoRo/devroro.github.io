package promocoes;

public class SemPromo implements Promocao {

    @Override
    public Double descontar(Double preco) {
        return 0.0;
    }

    @Override
    public String toString() {
        return " ";
    }
    
}
