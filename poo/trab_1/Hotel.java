import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private String nome;
    private String endereco;
    private List<Quarto> listadeQuartos = new ArrayList<Quarto>();

    Hotel(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Quarto getQuartoByNumero (String numero) {
        Quarto quartoIterado = null;

        for (int i = 0; i < listadeQuartos.size(); i++) {

            quartoIterado = listadeQuartos.get(i);

            if (quartoIterado.getNumero().equals(numero)) {
                return quartoIterado;
            }
            
        }

        return quartoIterado;

    }

    public void adicionarQuarto (String numero, String tipo, float preco) {

        Quarto quarto = new Quarto(numero, tipo, preco);
        listadeQuartos.add(quarto);

    }

    public void removerQuarto(Quarto quarto) {
        listadeQuartos.remove(quarto);
    }

    public String listarQuartosDisponiveis() {

        String lista ="";

        for (int i = 0; i < listadeQuartos.size(); i++) {

            Quarto quartoIterado = listadeQuartos.get(i);

            if (quartoIterado.getEstaDisponivel() == true) {
                lista += quartoIterado.getNumero()+"\n";
            } else {
                continue;
            }
            
        }

        return lista;
    }

}
