package negocio;

public class Produto {

    private int id;
    private String nome;
    private int qtdeEstoque;
    private double preco;

    public Produto(int id, String nome, int qtdeEstoque, double preco) {
        this.id = id;
        this.nome = nome;
        this.qtdeEstoque = qtdeEstoque;
        this.preco = preco;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getQtdeEstoque() {
        return qtdeEstoque;
    }
    public void setQtdeEstoque(int qtdeEstoque) {
        this.qtdeEstoque = qtdeEstoque;
    }
    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }
}