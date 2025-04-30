public class PedidoAprovado implements State {

    @Override
    public State status() {
        System.out.println("Seu pagamento foi processado. Estaremos enviando o produto em seguida.");
        return new PedidoDespachado();
    }
    
}
