package negocio;

public class Banana extends SorveteDecorator{

    public Banana (Sorvete sorvete) {
        super(sorvete);
        this.ingredientes = "Banana\n";
    }
}