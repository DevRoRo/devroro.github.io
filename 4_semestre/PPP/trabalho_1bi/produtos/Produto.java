package produtos;

import promocoes.Promocao;

public abstract class Produto {
    private String nome;
    private Double preco;
    private Promocao p;

    public Produto (String nome, Double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public void setP(Promocao p) {
        this.p = p;
    }

    public String calcpreco() {

        Double desconto = p.descontar(preco);
        Double precoAtual = this.preco - desconto;
        String etiqueta = "Preço: "+precoAtual;

        return etiqueta;
    }

    @Override
    public String toString() {
        String string;
        if(this.p.toString() == " ") {
            string = "|"+this.nome+"|\n|Preço: "+calcpreco()+"|\n\n";
        } else {
            string = "|"+this.nome+"|\n|Preço: "+calcpreco()+"|\n|"+p.toString()+"|\n\n";
        }
        
        return string;
    }
}