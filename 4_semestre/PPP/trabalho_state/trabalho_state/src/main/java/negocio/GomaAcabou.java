package negocio;

public class GomaAcabou implements State{
    
    public State trocaEstado(Maquina maquina) {
        System.out.println("Acabou a goma, recarregue a máquina.\n...");
        maquina.qtdeGomas += 1;
        System.out.println("Máquina recarregada");
        return new SemMoeda();
    }

}
