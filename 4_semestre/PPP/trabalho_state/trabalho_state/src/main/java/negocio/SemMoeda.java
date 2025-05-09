package negocio;

public class SemMoeda implements State {

    @Override
    public State trocaEstado(Maquina maquina) {
        System.out.println("*Barulho de moeda entrando no slot*");
        return new RecebeMoeda();
    }
    
}
