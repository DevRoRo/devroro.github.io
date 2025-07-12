package negocio;

public class Chocolate extends SorveteDecorator{

    public Chocolate (Sorvete sorvete) {
        super(sorvete);
        this.ingredientes = "Chocolate\n";
    }
}
