package negocio;

import java.util.ArrayList;

public class PedidoBuilder {
    private static int idFinal = 0; /* Finge que o sistema tá consultado o BD e extraindo o último id registrado*/
    private int id;
    private Cliente cliente;
    private Vendedor vendedor;
    private ArrayList<Item> itens;
    

    public PedidoBuilder(Cliente cliente){
        this.cliente = cliente;
    }

    public PedidoBuilder vendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
        return this;
    }

    public PedidoBuilder itens(ArrayList<Item> itens){
        this.itens = itens;
        return this;
    }

    public PedidoBuilder id() {
        this.id = PedidoBuilder.idFinal;
        PedidoBuilder.idFinal++;
        return this;
    }

    public Pedido build(){
        Pedido pedido =  new Pedido(this.id, this.cliente, this.vendedor, this.itens);

        return pedido;
    }
}
