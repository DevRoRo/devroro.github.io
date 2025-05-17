package negocio.games;

public class Race extends Game {
    
    public Race(String name) {
        super(name);
    }

    public void accelerate() {
        System.out.println("Acelerando...");
    }

    public void brake() {
        System.out.println("freiando...");
    }
}
