package Mesa;
import Marbles.Cor;
import Marbles.Pecas;

public class Jogador {
    private Cor time;
    
    private String nome;

    public Jogador(String nome, Cor cor) {
        this.time = cor;
        this.nome = nome;
    }
    
    public Cor getTime() {
        return time;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public Object[] declararMovimento (Pecas peca, int x, int y) throws Exception {

        if (peca.getCor() == Cor.VAZIO || peca.getCor() != this.getTime()) throw new Exception("Declare a peça de acordo com a cor do seu time");

        Object[] pecaEMovimento = new Object[2];

        int [] parOrdenado = empacotarCoordMovimento(x, y);

        pecaEMovimento[0] = peca;
        pecaEMovimento[1] = parOrdenado;

        return pecaEMovimento;
    }

    private int[] empacotarCoordMovimento (int x, int y) {

        int [] parOrdenado = new int[2];

        parOrdenado[0] = x;
        parOrdenado[1] = y;

        return parOrdenado;
        
    }
    
}
