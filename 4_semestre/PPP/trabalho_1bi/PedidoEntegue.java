public class PedidoEntegue implements State {

    @Override
    public State status() {
        System.out.println("Seu pedido foi entregue, agradecemos a compra!");
        return this;
    }
    
}
