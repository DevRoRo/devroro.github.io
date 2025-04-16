package promocoes;

public class Regular implements Promocao, DescontoExtra {
    
    int mes;

    public Regular (int mes) {
        this.mes = mes;
    }

    @Override
    public Double descontoExtra(int mes) {
        return (mes >= 6) ? 0.05 : 0.1;
    }

    @Override
    public Double descontar(Double preco) {
        Double desconto = 0.1 + descontoExtra(this.mes);
        return preco * desconto;
    }

    @Override
    public String toString() {
        int dezOuQuinzeDesconto = (mes >= 6) ? 15 : 20;
        return "Não perca o desconto de "+dezOuQuinzeDesconto+"% !!";
    }
}
