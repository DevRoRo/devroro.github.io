package negocio;

public class CoberturaMorango extends SorveteDecorator{

    public CoberturaMorango (Sorvete sorvete) {
        super(sorvete);
        this.ingredientes = "Cobertura de morango\n";
    }
}
