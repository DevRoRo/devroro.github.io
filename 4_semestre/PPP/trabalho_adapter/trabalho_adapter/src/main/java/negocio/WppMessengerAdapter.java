package negocio;

public class WppMessengerAdapter implements Messenger {
    WppMessenger wppMessenger;

    public WppMessengerAdapter (WppMessenger wppMessenger) {
        this.wppMessenger = wppMessenger;
    }

    @Override
    public void enviarMensagem(String mensagem) {
        wppMessenger.enviarMsgWpp(mensagem);
    }
}
