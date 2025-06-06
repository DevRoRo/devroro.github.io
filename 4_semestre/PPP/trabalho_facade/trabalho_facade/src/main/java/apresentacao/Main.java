package apresentacao;

import java.sql.SQLException;
import java.util.Scanner;

import service.ClienteService;

public class Main {
    public static void main(String[] args) throws SQLException {
        boolean invalidInput = true;
        Scanner in = new Scanner(System.in);

        while (invalidInput) {
            try {
                System.out.println("Informe o nome e CPF do cliente a ser inserido no banco de dados:");
                new ClienteService().inserirCliente(in.next(), in.next());
                invalidInput = false;
            } catch(Exception e) {
                System.out.println(e);
                invalidInput = true;
            }
        }

        in.close();
    }
}