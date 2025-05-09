package negocio;

public class GomaVendida implements State {

    @Override
    public State trocaEstado(Maquina maquina) {
        return maquina.qtdeGomas == 0 ? new SemMoeda() : new GomaAcabou();
    }
    
}
