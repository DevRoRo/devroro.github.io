package negocio;

public class PedidoDespachado implements State {

    @Override
    public State status() {
        System.out.println("Seu pedido foi despachado. Acompanhe o trajeto até a rota de entrega.");
        return new PedidoEntegue();
    }
    
}
