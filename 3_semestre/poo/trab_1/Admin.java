public class Admin {
    private String nome;
    private String id;

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    //Instancia um novo objeto hotel
    public Hotel adicionarHotel (String nome, String endereco) {

        Hotel hotel = new Hotel(nome, endereco);

        return hotel;

    }
    
}

