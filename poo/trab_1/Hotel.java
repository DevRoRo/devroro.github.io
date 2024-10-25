import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private String nome;
    private String endereco;
    private List<Quarto> listadeQuartos = new ArrayList<Quarto>();

    //Construtor para o objetvo Cliente que obriga a inserção dos atributos nome e endereço.
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

    /* Recebe uma string numero e a utiliza para comparação com todas as iterações do objeto quarto no arrayList de quartos,
    retornando o objeto quarto com o mesmo atributo numero que o parâmetro ou nulo quando não houver, disparando uma exceção
    IllegalArgumentException
     */
    public Quarto getQuartoByNumero (String numero) {
        Quarto quartoFinal = null;

        for (int i = 0; i < listadeQuartos.size(); i++) {
            Quarto quartoIterado = listadeQuartos.get(i);
            if (quartoIterado.getNumero().equals(numero)) {
                quartoFinal = quartoIterado;
            }
        }

        if (quartoFinal == null) {
            throw new IllegalArgumentException("Quarto informado não existe");
        }

        return quartoFinal;
    }
    // Instancia um novo objeto quarto usando os parâmetros como atributo e adiciona esse objeto no arrayList de quartos
    public void adicionarQuarto (String numero, String tipo, float preco) {

        Quarto quarto = new Quarto(numero, tipo, preco);
        listadeQuartos.add(quarto);

    }

    public void removerQuarto(Quarto quarto) {
        listadeQuartos.remove(quarto);
    }

    //
    public String listarQuartosDisponiveis() {

        String lista ="";

        for (int i = 0; i < listadeQuartos.size(); i++) {
            Quarto quartoIterado = listadeQuartos.get(i);

            if (quartoIterado.getEstaDisponivel() == true) {
                lista += " - " + quartoIterado.getNumero()+"\n";
            } else {
                continue;
            }
        }

        return lista;
    }
}
