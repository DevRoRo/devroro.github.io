package negocio;

public class Orc implements MonstroPrototype {
    private String Especie;
    private int saude;
    private int dano;
    private String arma;

    public Orc(String Especie, int saude, int dano, String arma) {
        this.Especie = Especie;
        this.saude = saude;
        this.dano = dano;
        this.arma = arma;
    }

    public Orc(Orc fonte) {
        this.Especie = fonte.Especie;
        this.saude = fonte.saude;
        this.dano = fonte.dano;
        this.arma = fonte.arma;
    }

    @Override
    public MonstroPrototype clonar() {
        return new Orc(this);
    }

    @Override
    public void atacar() {
        System.out.println("Ação do "+Especie+"\n" + " o Orc ataca com " + arma + " causando " + dano + " de dano!\n");
    }

    @Override
    public String getEspecie() {
        return Especie;
    }

    public void setSaude(int saude) {
        this.saude = saude;
    }

    public void setArma(String arma) {
        this.arma = arma;
    }

    @Override
    public String toString() {
        return "Orc [Especie=" + Especie + ", saude=" + saude + ", dano=" + dano + ", arma=" + arma + "]";
    }
}
