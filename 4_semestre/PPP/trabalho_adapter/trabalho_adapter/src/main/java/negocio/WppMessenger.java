package negocio;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;

public class WppMessenger {
    /* idTelefone é a String do id do número fornecido pela Meta na API. Esse é o número que envia a mensagem */
    private String idTelefone = "580690545137364";
    private String numeroReceptor;
    /* bearerToken é o token de acesso da API. */
    private String bearerToken = "EAATsphzUi7oBOzjhxEDQOT1QOgxJjAZAlHNZAWZAp1y8KP7toiOdsxWJYuQk0U4q1fKEyiReIt6mODvFkN39XGUbgQKbZCjyfPSjUQioZCDoFmwfLruF66981G6n9MTMiTFTbcRntR9l9eUFCo2H2eZBWGurnj3WbeCqHa42fSD4mHHywoVIVA6r4B8YIxgWRXDX7Ch9pwIqkUGh9lSvtC2l97bOSKF3UZD";

    public WppMessenger(String numeroReceptor) {
        this. numeroReceptor = numeroReceptor;
    }

    public void enviarMsgWpp(String mensagem) {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://graph.facebook.com/v13.0/"+idTelefone+"/messages"))
                .header("Authorization", "Bearer "+bearerToken)
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString("{ \"messaging_product\": \"whatsapp\", \"recipient_type\": \"individual\", \"to\": \""+numeroReceptor+"\", \"type\": \"text\", \"text\": { \"preview_url\": false, \"body\": \""+mensagem+"\" } }"))
                .build();
            HttpClient http = HttpClient.newHttpClient();
            http.send(request,BodyHandlers.ofString());
            System.out.println("Enviando via Whatsapp...");
            
        } catch (URISyntaxException | IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

