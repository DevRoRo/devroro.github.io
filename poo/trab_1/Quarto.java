public class Quarto {
    private String numero;
    private String tipo;
    private float preco;
    private Boolean estaDisponivel;

    Quarto(String numero, String tipo, float preco) {
        this.numero = numero;
        this.tipo = tipo;
        this.preco = preco;
        estaDisponivel = true;

    }

    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public float getPreco() {
        return preco;
    }
    public void setPreco(float preco) {
        this.preco = preco;
    }
    public Boolean getEstaDisponivel() {
        return estaDisponivel;
    }
    public void setEstaDisponivel(Boolean estaDisponivel) {
        this.estaDisponivel = estaDisponivel;
    }
    
}
