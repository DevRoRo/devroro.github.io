package Negocio;

public class Participante implements Observer {
    private String nome;
    private float lance;

    public Participante(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public float getLance() {
        return lance;
    }

    public void setLance(float lance) {
        this.lance = lance;
    }

    public void realizarLance(Leiloeiro leiloeiro, float lance) {
        if (leiloeiro.lanceValido(lance)) {
            setLance(lance);
            leiloeiro.notifyObservers(lance);
        } else {
            System.out.println("Valor não cobre o último lance, lance inválido.\n"
            +"============================\n");
        }
    
    }

    @Override
    public void update(float lance) {
        System.out.println(this.nome+"\nNovo lance no valor de: "+lance+"\n============================\n");
    }
    
}
