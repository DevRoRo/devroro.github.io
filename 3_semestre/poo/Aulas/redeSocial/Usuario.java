import java.util.HashSet;

public class Usuario {

    private String nome;

    private HashSet<Usuario> amigos;

    Usuario (String nome) {
        this.nome = nome;
        amigos = new HashSet<Usuario>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public HashSet<Usuario> getAmigos() {
        return amigos;
    }

    public void setAmigos(HashSet<Usuario> amigos) {
        this.amigos = amigos;
    }

    public void addAmigo (Usuario outro) {
        amigos.add(outro);
    }
}