package keep.negocio;

public class Anotacao {
    private String titulo;
    private String descricao;
    private String cor;
    private String dataHora;
    private Byte foto;

    public Anotacao(String titulo, String descricao, String dataHora) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataHora = dataHora;
    }

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCor() {
        return cor;
    }
    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getDataHora() {
        return dataHora;
    }
    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }

    public Byte getFoto() {
        return foto;
    }
    public void setFoto(Byte foto) {
        this.foto = foto;
    }
    @Override
    public String toString() {
        String string = "===="+this.titulo+"====\n"+this.descricao;
        
        return string;
    }
}
