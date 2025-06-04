package apresentacao;

import java.util.Scanner;

import negocio.CelphoneMessenger;
import negocio.Messenger;
import negocio.WppMessenger;
import negocio.WppMessengerAdapter;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        String numeroReceptor = "5553981337478";
        String mensagem = "Bom dia";

        Messenger messenger = new CelphoneMessenger(numeroReceptor);
        messenger.enviarMensagem(mensagem);

        WppMessengerAdapter wppMessenger = new WppMessengerAdapter(new WppMessenger(numeroReceptor));
        wppMessenger.enviarMensagem(mensagem);

        in.close();
        }
    }
