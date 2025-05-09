package negocio;

public class FreteConvencional extends Frete {

    @Override
    protected float taxaModalidadeEDistancia(float distancia) {
        return distancia * 0.3f;
    }
    
}
