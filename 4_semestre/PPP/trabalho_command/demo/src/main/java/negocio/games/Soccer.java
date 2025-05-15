package negocio.games;

public class Soccer extends Game {
    
    public Soccer(String name) {
        super(name);
    }

    public void run() {
        System.out.println("Correndo...");
    }

    public void kick() {
        System.err.println("Chutei a bola");
    }
}
