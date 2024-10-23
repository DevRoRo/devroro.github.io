import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SistemaReservas {

    private Admin admin = new Admin();
    private List<Hotel> listaHoteis = new ArrayList<Hotel>();
    private List<Cliente> listaClientes = new ArrayList<Cliente>();
    private List<Reserva> listaReservas = new ArrayList<Reserva>();

    public void adicionarHotel(String nome, String endereco) {
        Hotel hotelCriado = admin.adicionarHotel(nome, endereco);
        listaHoteis.add(hotelCriado);
    }

    public String listarHoteis() {
        String lista = "";
        for (int i = 0; i < listaHoteis.size(); i++) {
            lista += listaHoteis.get(i).getNome()+"\n";
        }

        return lista;
    }

    public Hotel iterarHotelPorNome(String nomeHotel) {
        Hotel hotelFinal=null;

        for (int i = 0; i < this.listaHoteis.size(); i++) {
            Hotel hotelIterado = this.listaHoteis.get(i);
            if (hotelIterado.getNome().equals(nomeHotel)) {
                hotelFinal = hotelIterado;
                break;
            }
        }

        return hotelFinal;
    }

    public void adicionarQuarto (String nomeHotel, String numeroQuarto, String tipoQuarto, float precoQuarto) {

        Hotel hotel = iterarHotelPorNome(nomeHotel);

        /* if (hotel == null) {
            System.out.println("O hotel solicitado não existe");
        } */

        hotel.adicionarQuarto(numeroQuarto, tipoQuarto, precoQuarto);
        
    }

    public String listarQuartosDisponiveis (String nomeHotel) {

        Hotel hotel = iterarHotelPorNome(nomeHotel);

        String lista = hotel.listarQuartosDisponiveis();

        return lista;

    }

    public void fazerReserva (String nomeCliente, String emailCliente, String telefoneCliente, String nomeHotel, String numeroQuarto, LocalDate dataCheckIn, LocalDate dataCheckOut) {
        
        Cliente cliente = cadastrarCliente(nomeCliente, emailCliente, telefoneCliente);

        Hotel hotel = iterarHotelPorNome(nomeHotel);

        Quarto quarto = hotel.getQuartoByNumero(numeroQuarto);

        Reserva reserva = new Reserva(cliente, quarto, dataCheckIn, dataCheckOut);

        listaReservas.add(reserva);

    }

    public Cliente cadastrarCliente (String nome, String email, String telefone) {

        Cliente cliente=null;

        if (listaClientes.size() <= 0) {

            cliente = new Cliente(nome, email, telefone);

            System.out.println("Cliente cadastrado, efetuando reserva");
            
        } else {

            for (int i = 0; i < listaClientes.size(); i++) {

                if(listaClientes.get(i).getNome().equals(nome)) {

                    cliente = listaClientes.get(i);

                    System.out.println("Cliente já cadastrado, prosseguindo para a reserva");

                } else {

                    cliente = new Cliente(nome, email, telefone);

                    System.out.println("Cliente cadastrado, efetuando reserva");

                } 
            }
        }

        return cliente;

    }

    public String listarReservasCliente () {

        String lista = "";

        for (int i = 0; i < listaReservas.size(); i++) {

            Reserva reservaIterada = listaReservas.get(i);

            lista += reservaIterada.getReservista().getNome() + reservaIterada.getQuarto_reservado().getNumero() + reservaIterada.getDataCheckIn().getMonth() + reservaIterada.getDataCheckOut().getMonth();
        }
        
        return lista;

    }

}
