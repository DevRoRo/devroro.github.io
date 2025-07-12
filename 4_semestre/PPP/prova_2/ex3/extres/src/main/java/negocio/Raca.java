package negocio;

public abstract class Raca {
    private String nome;

    public Raca(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

}
