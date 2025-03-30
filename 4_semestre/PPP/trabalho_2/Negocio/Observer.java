package Negocio;

public interface Observer {
    public void update(float lance);

    public String getNome(); //Por que preciso estabelecer o contrato na interface pra chamar uma função da classe concreta? Pra chamar o getNome no método ToString do leiloeiro, precisei declarar aqui na interface

    public float getLance();
}