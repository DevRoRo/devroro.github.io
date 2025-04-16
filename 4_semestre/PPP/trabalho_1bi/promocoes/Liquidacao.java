package promocoes;

public class Liquidacao implements Promocao {

    @Override
    public Double descontar(Double preco) {
        Double desconto = 0.3;
        return preco * desconto;
    }

    @Override
    public String toString() {
        return "Não perca a liquidação !!";
    }
    
}
