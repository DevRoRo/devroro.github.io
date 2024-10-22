import java.util.ArrayList;
import java.util.List;

public class SistemaReservas {

    private Admin admin = new Admin();
    private List<Hotel> listaHoteis = new ArrayList<Hotel>();

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

}
