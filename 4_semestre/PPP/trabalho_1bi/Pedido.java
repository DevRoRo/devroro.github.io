public class Pedido {
    private State estadoPedido;

    public Pedido() {
        this.estadoPedido = new PedidoRecebido();
    }

    public void Status() {
        this.estadoPedido = this.estadoPedido.status();
    }
}
