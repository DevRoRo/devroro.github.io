package negocio.games;

public class Fight extends Game {
    
    public Fight(String name) {
        super(name);
    }

    public void kick() {
        System.out.println("Chutei");
    }

    public void punch() {
        System.out.println("Soqueei");
    }
}
