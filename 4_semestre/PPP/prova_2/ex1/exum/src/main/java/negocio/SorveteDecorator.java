package negocio;

public abstract class SorveteDecorator extends Sorvete {
    protected Sorvete sorvete;

    public SorveteDecorator(Sorvete sorvete) {
        this.sorvete = sorvete;
    }

    public String build () {
        return this.sorvete.build() + this.ingredientes;
    }
}