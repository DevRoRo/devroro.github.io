package negocio;

public class FreteTransportadora extends Frete {

    @Override
    protected float taxaModalidadeEDistancia(float distancia) {
        return distancia * 0.65f;
    }
    
}
