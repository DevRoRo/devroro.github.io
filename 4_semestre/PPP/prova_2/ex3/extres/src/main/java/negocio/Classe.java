package negocio;

public abstract class Classe {
    private String nome;

    public Classe (String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

}
