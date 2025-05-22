package negocio;

public class Empregado {
    private String nome;
    private Data dataNascimento;
    private int nroCnh;

    public Empregado(String nome, Data dataNascimento, int nroCnh) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.nroCnh = nroCnh;
    }

    public String getNome() {
        return nome;
    }
    public Data getDataNascimento() {
        return dataNascimento;
    }
    public int getNroCnh() {
        return nroCnh;
    }

    public void getIdade()  {

    }

    public boolean temCnh() {
        return this.nroCnh == 0 ? false : true;
    }

    
}