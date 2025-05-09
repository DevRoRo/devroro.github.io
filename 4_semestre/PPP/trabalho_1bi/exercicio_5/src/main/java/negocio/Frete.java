package negocio;

public abstract class Frete {

    public final void mostrarFrete (float distancia, float peso, boolean temCupom) {

        float valorTaxa = taxaModalidadeEDistancia(distancia);

        valorTaxa += taxaPesoProduto(peso);

        System.out.println("VALOR TOTAL: "+valorTaxa * descontoCupom(temCupom));

    }

    private float taxaPesoProduto(float peso) {
        return peso * 0.3f;
    }

    private float descontoCupom(boolean temCupom) {
        return temCupom ? 0.9f : 1;
    }

    protected abstract float taxaModalidadeEDistancia(float distancia);
    
}
