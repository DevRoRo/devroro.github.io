package negocio;

public class CelphoneMessenger implements Messenger {
    private String numeroReceptor;

    public CelphoneMessenger(String numeroReceptor) {
        this.numeroReceptor = numeroReceptor;
    }

    @Override
    public void enviarMensagem(String mensagem) {
        System.out.println("Mensagem para "+numeroReceptor+":\n"+mensagem);
    }   
}
