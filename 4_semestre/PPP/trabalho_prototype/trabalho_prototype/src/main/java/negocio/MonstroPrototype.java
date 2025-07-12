package negocio;

public interface MonstroPrototype extends Cloneable {
    MonstroPrototype clonar();
    void atacar();
    String getEspecie();
}