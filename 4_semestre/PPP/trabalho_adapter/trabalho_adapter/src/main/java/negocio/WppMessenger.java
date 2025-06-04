package negocio;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class WppMessenger {
    /* idTelefone é a String do id do número fornecido pela Meta na API. Esse é o número que envia a mensagem */
    private String idTelefone = "580690545137364";
    private String numeroReceptor;
    /* bearerToken é o token de acesso da API. */
    private String bearerToken = "EAATsphzUi7oBOy9SadKT3Lg63P9RsVQbb7trEZCvzqpRyASEBEZBhpJQNIWQM4IbjpZClaD81AYggyLDvYsvqbO7qZAJRnv6mJnfKkVp7b9VeaaUS5alHzC2L8lZC9HDrSr2yyiLx7g2XZBHfAALIlzn6nYbMyCZAOljkp7FW4X2jdl1ZABJaSQL2fesHBhmb3krrTXS3SZACnNqEwM2ZAxjITx5xxrYJlfyBI";

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
            System.out.println(request);
            System.out.println("Enviando via Whatsapp...");
            
        } catch (URISyntaxException | IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

