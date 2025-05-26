package apresentacao;

import negocio.CelphoneMessenger;
import negocio.Messenger;
import negocio.WppMessenger;
import negocio.WppMessengerAdapter;

public class Main {
    public static void main(String[] args) {
        String numeroReceptor = "5553981337478";
        String mensagem = "Não esquece de trocar o pneu do carro";

        Messenger messenger = new CelphoneMessenger(numeroReceptor);
        messenger.enviarMensagem(mensagem);

        WppMessengerAdapter wppMessenger = new WppMessengerAdapter(new WppMessenger(numeroReceptor));
        wppMessenger.enviarMensagem(mensagem);
    }
}
