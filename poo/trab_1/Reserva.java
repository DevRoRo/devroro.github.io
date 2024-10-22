import java.time.LocalDateTime;

public class Reserva {
    private Cliente reservista;
    private Quarto quarto_reservado;
    private LocalDateTime dataCheckIn;
    private LocalDateTime dataCheckOut;
    
    public Cliente getReservista() {
        return reservista;
    }
    public void setReservista(Cliente reservista) {
        this.reservista = reservista;
    }
    public Quarto getQuarto_reservado() {
        return quarto_reservado;
    }
    public void setQuarto_reservado(Quarto quarto_reservado) {
        this.quarto_reservado = quarto_reservado;
    }
    public LocalDateTime getDataCheckIn() {
        return dataCheckIn;
    }
    public void setDataCheckIn(LocalDateTime dataCheckIn) {
        this.dataCheckIn = dataCheckIn;
    }
    public LocalDateTime getDataCheckOut() {
        return dataCheckOut;
    }
    public void setDataCheckOut(LocalDateTime dataCheckOut) {
        this.dataCheckOut = dataCheckOut;
    }
    
}
