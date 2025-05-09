package negocio;

public class RecebeMoeda implements State {

    @Override
    public State trocaEstado(Maquina maquina) {
        System.out.println("*Barulho de catraca girando*\n*Barulho de goma caindo*");
        return new GomaVendida();
    }
    
}
