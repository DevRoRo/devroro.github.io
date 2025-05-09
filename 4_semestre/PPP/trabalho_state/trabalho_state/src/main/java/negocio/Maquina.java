package negocio;

public class Maquina {
    protected int qtdeGomas;
    State maquinaEstado;

    public Maquina() {
        this.qtdeGomas = 1;
        this.maquinaEstado = new SemMoeda();
    }

    public void acionar() {
        this.maquinaEstado = this.maquinaEstado.trocaEstado(this);
    }

}
