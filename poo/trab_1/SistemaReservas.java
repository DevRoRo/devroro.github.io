import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SistemaReservas {

    private Admin admin = new Admin();
    private List<Hotel> listaHoteis = new ArrayList<Hotel>();
    private List<Cliente> listaClientes = new ArrayList<Cliente>();
    private List<Reserva> listaReservas = new ArrayList<Reserva>();

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void adicionarHotel(String nome, String endereco) {
        Hotel hotelCriado = admin.adicionarHotel(nome, endereco);
        listaHoteis.add(hotelCriado);
    }

    public String listarHoteis() {
        String lista = "Lista de hotéis:\n";
        for (int i = 0; i < listaHoteis.size(); i++) {
            lista += " - " + listaHoteis.get(i).getNome()+"\n";
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

        if (hotelFinal == null) {
            throw new IllegalArgumentException("Hotel informado não existe");
        }

        return hotelFinal;
    }

    public void adicionarQuarto (String nomeHotel, String numeroQuarto, String tipoQuarto, float precoQuarto) {

        Hotel hotel = iterarHotelPorNome(nomeHotel);
        hotel.adicionarQuarto(numeroQuarto, tipoQuarto, precoQuarto);
        
    }

    public String listarQuartosDisponiveis (String nomeHotel) {

        Hotel hotel = iterarHotelPorNome(nomeHotel);
        String lista = "Lista de quartos disponíveis em " + hotel.getNome() + "\n" + hotel.listarQuartosDisponiveis();

        return lista;

    }

    public void fazerReserva (String nomeCliente, String emailCliente, String telefoneCliente, String nomeHotel, String numeroQuarto, LocalDate dataCheckIn, LocalDate dataCheckOut) {
        
        Cliente cliente = cadastrarCliente(nomeCliente, emailCliente, telefoneCliente);
        Hotel hotel = iterarHotelPorNome(nomeHotel);
        Quarto quarto = hotel.getQuartoByNumero(numeroQuarto);

        if (quarto.getEstaDisponivel()) {
            Reserva reserva = new Reserva(cliente, quarto, dataCheckIn, dataCheckOut);
            listaReservas.add(reserva);
            quarto.setEstaDisponivel(false);
            System.out.println("Quarto reservado");
    
        } else {
            System.out.println("Quarto não disponível");
        }        
    }

    public Cliente cadastrarCliente (String nome, String email, String telefone) {

        Cliente cliente = null;
        boolean clienteEncontrado = false;

        for (int i = 0; i < listaClientes.size(); i++) {

            if(listaClientes.get(i).getNome().equals(nome)) {
                cliente = listaClientes.get(i);
                clienteEncontrado = true;

                break;
            }
        }

            if (!clienteEncontrado) {
                cliente = new Cliente(nome, email, telefone);
                listaClientes.add(cliente);
                System.out.println("Cliente cadastrado, efetuando reserva");
            }
            
        return cliente;
    }

    public String listarReservasCliente (String nome) {

        String lista = "Reservas feitas pelo cliente "+nome.substring(0, 1).toUpperCase() + nome.substring(1)+"\n";

        for (int i = 0; i < listaReservas.size(); i++) {
            Reserva reservaIterada = listaReservas.get(i);
            if (reservaIterada.getcliente().getNome().equals(nome)) {
                lista += "Quarto: " + reservaIterada.getquarto().getNumero();
                lista += " Check-In: " + reservaIterada.getDataCheckIn().getDayOfMonth() + "/" + reservaIterada.getDataCheckIn().getMonthValue() + "/" + reservaIterada.getDataCheckIn().getYear();
                lista += " Check-In: " + reservaIterada.getDataCheckOut().getDayOfMonth() + "/" + reservaIterada.getDataCheckOut().getMonthValue() + "/" + reservaIterada.getDataCheckOut().getYear();
            }
        }

        lista += "\n\n";

        return lista;
    }
}