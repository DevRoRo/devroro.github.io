public class PedidoRecebido implements State {

    @Override
    public State status() {
        System.out.println("Seu pedido foi efetuado e estamos aguardando pagamento");
        return new PedidoAprovado();
    }
}
