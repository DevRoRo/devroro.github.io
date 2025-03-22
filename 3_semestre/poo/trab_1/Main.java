import java.time.LocalDate;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SistemaReservas sistema = new SistemaReservas();
        int opcao;

        // Create first hotel and add rooms
    sistema.adicionarHotel("hotel1".toLowerCase(), "rua1".toLowerCase());
    sistema.adicionarQuarto("hotel1".toLowerCase(), "001".toLowerCase(), "comum".toLowerCase(), 100);
    sistema.adicionarQuarto("hotel1".toLowerCase(), "002".toLowerCase(), "comum".toLowerCase(), 120);
    sistema.adicionarQuarto("hotel1".toLowerCase(), "003".toLowerCase(), "luxo".toLowerCase(), 200);
    sistema.adicionarQuarto("hotel1".toLowerCase(), "004".toLowerCase(), "comum".toLowerCase(), 100);
    sistema.adicionarQuarto("hotel1".toLowerCase(), "005".toLowerCase(), "luxo".toLowerCase(), 210);
    sistema.adicionarQuarto("hotel1".toLowerCase(), "006".toLowerCase(), "comum".toLowerCase(), 130);
    sistema.adicionarQuarto("hotel1".toLowerCase(), "007".toLowerCase(), "luxo".toLowerCase(), 250);
    sistema.adicionarQuarto("hotel1".toLowerCase(), "008".toLowerCase(), "comum".toLowerCase(), 110);
    sistema.adicionarQuarto("hotel1".toLowerCase(), "009".toLowerCase(), "comum".toLowerCase(), 115);
    sistema.adicionarQuarto("hotel1".toLowerCase(), "010".toLowerCase(), "luxo".toLowerCase(), 230);
    sistema.adicionarQuarto("hotel1".toLowerCase(), "011".toLowerCase(), "comum".toLowerCase(), 105);

    // Create second hotel and add rooms
    sistema.adicionarHotel("hotel2".toLowerCase(), "rua2".toLowerCase());
    sistema.adicionarQuarto("hotel2".toLowerCase(), "101".toLowerCase(), "comum".toLowerCase(), 90);
    sistema.adicionarQuarto("hotel2".toLowerCase(), "102".toLowerCase(), "comum".toLowerCase(), 95);
    sistema.adicionarQuarto("hotel2".toLowerCase(), "103".toLowerCase(), "luxo".toLowerCase(), 150);
    sistema.adicionarQuarto("hotel2".toLowerCase(), "104".toLowerCase(), "comum".toLowerCase(), 100);
    sistema.adicionarQuarto("hotel2".toLowerCase(), "105".toLowerCase(), "luxo".toLowerCase(), 160);
    sistema.adicionarQuarto("hotel2".toLowerCase(), "106".toLowerCase(), "comum".toLowerCase(), 80);
    sistema.adicionarQuarto("hotel2".toLowerCase(), "107".toLowerCase(), "luxo".toLowerCase(), 170);
    sistema.adicionarQuarto("hotel2".toLowerCase(), "108".toLowerCase(), "comum".toLowerCase(), 85);
    sistema.adicionarQuarto("hotel2".toLowerCase(), "109".toLowerCase(), "comum".toLowerCase(), 90);
    sistema.adicionarQuarto("hotel2".toLowerCase(), "110".toLowerCase(), "luxo".toLowerCase(), 180);

    // Create more clients
    sistema.cadastrarCliente("RoRo".toLowerCase(), "RoRo@RoRo".toLowerCase(), "53988".toLowerCase());
    sistema.cadastrarCliente("João".toLowerCase(), "joao@example.com".toLowerCase(), "12345".toLowerCase());
    sistema.cadastrarCliente("Maria".toLowerCase(), "maria@example.com".toLowerCase(), "67890".toLowerCase());
    sistema.cadastrarCliente("Pedro".toLowerCase(), "pedro@example.com".toLowerCase(), "11223".toLowerCase());
    sistema.cadastrarCliente("Ana".toLowerCase(), "ana@example.com".toLowerCase(), "33445".toLowerCase());
    sistema.cadastrarCliente("Lucas".toLowerCase(), "lucas@example.com".toLowerCase(), "55667".toLowerCase());
    sistema.cadastrarCliente("Beatriz".toLowerCase(), "beatriz@example.com".toLowerCase(), "88990".toLowerCase());

        do {
            System.out.println("===== Menu Principal =====");
            System.out.println("1. Adicionar Novo Hotel");
            System.out.println("2. Listar Todos os Hotéis");
            System.out.println("3. Adicionar Quarto a um Hotel");
            System.out.println("4. Listar Quartos Disponíveis em um Hotel");
            System.out.println("5. Fazer Reserva");
            System.out.println("6. Cancelar Reserva");
            System.out.println("7. Listar Reservas de um Cliente");
            System.out.println("8. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("\nInsira o nome do hotel");
                    String nomeHotel = scanner.next().toLowerCase();
                    
                    System.out.println("\nInsira o endereco do hotel");
                    String endereco = scanner.next().toLowerCase();

                    sistema.adicionarHotel(nomeHotel, endereco);

                    break;
                case 2:
                    System.out.println("\n"+sistema.listarHoteis());
                    break;                    
                case 3:
                    System.out.println("\nInsira o nome do hotel");
                    nomeHotel = scanner.next().toLowerCase();

                    System.out.println("\nInsira o numero do quarto");
                    String numeroQuarto = scanner.next().toLowerCase();

                    System.out.println("\nInsira o tipo do quarto");
                    String tipoQuarto = scanner.next().toLowerCase();

                    System.out.println("\nInsira o valor do quarto");
                    float preco = scanner.nextFloat();

                    try {
                        sistema.adicionarQuarto(nomeHotel, numeroQuarto, tipoQuarto, preco);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Não foi possível realizar a operação pois: ");
                        System.out.println(e.getMessage());
                        break;
                    }
                    break;
                case 4:
                    try {
                        System.out.println("\nInsira o nome do hotel");
                        nomeHotel = scanner.next().toLowerCase();
                        System.out.println("\n"+sistema.listarQuartosDisponiveis(nomeHotel));
                        break;
                    } catch (IllegalArgumentException e) {
                        System.out.println("Não foi possível realizar a operação pois: ");
                        System.out.println(e.getMessage());
                        break;
                    }
                case 5:
                    String emailCliente ="";
                    String telefoneCliente="";
                    boolean clienteCadastrado = false;

                    System.out.println("Insira o nome do cliente");
                    String nomeCliente = scanner.next().toLowerCase();

                    for (int i = 0; i < sistema.getListaClientes().size(); i++) {
                        Cliente cliente = sistema.getListaClientes().get(i);
                        
                        if (cliente.getNome().equals(nomeCliente)) {
                            System.out.println("Cliente já cadastrado, prosseguindo com a reserva.\n");
                            emailCliente = cliente.getEmail();
                            telefoneCliente = cliente.getTelefone();
                            clienteCadastrado = true;
                            break;
                        }
                    }
                    if (!clienteCadastrado) {
                        System.out.println("Insira o email do cliente");
                        emailCliente = scanner.next().toLowerCase();

                        System.out.println("insira o telefone do cliente");
                        telefoneCliente = scanner.next().toLowerCase();
                    }

                    System.out.println("Insira o nome do hotel que deseja reservar o quarto");
                    nomeHotel = scanner.next().toLowerCase();

                    System.out.println("Insira o numero do quarto a ser reservado");
                    numeroQuarto = scanner.next().toLowerCase();

                    System.out.println("Insira a data prevista para check-in e a data prevista para check-out (dd/mm/yyyy)");

                    List<LocalDate> data = new ArrayList<LocalDate>();

                    for (int i = 0 ; i < 2; i++) {
                        int [] arrayDataInt;
                        while (true) {
                            try {
                                arrayDataInt = Ferramentas.dataStringparaInt(scanner.next());
                                break;
                            } catch (NumberFormatException excecao) {
                                System.out.println("Tente um valor válido: " + excecao.getMessage());
                            }
                        }
                        LocalDate dataCheck = LocalDate.of(arrayDataInt[0], arrayDataInt[1], arrayDataInt[2]);
                        data.add(dataCheck);

                    }

                    LocalDate checkIn = data.get(0);
                    LocalDate checkOut = data.get(1);
           
                    try {sistema.fazerReserva(nomeCliente, emailCliente, telefoneCliente, nomeHotel, numeroQuarto, checkIn, checkOut);
                    } catch (IllegalArgumentException excecao) {
                        System.out.println("Não foi possível realizar a reserva pois: ");
                        System.out.println(excecao.getMessage());
                        break;
                    }
                    break;
/*                 case 6:
                    sistema.cancelarReserva();
                    break; */
                case 7:
                    System.out.println("Insira o nome do cliente");
                    System.out.println(sistema.listarReservasCliente(scanner.next()));
                    break;
                case 8:
                    System.out.println("Saindo do sistema...");
                    break;
                case 9:
                    switch (opcao) {
                        case 1:

                            
                            break;
                    
                        default:
                            break;
                    }
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 8);

        scanner.close();
    }
}