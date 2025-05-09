package negocio;

public class FreteSedex extends Frete{

    @Override
    protected float taxaModalidadeEDistancia(float distancia) {
        return distancia * 0.5f;
    }
    
}
