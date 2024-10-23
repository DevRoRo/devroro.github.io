import java.time.LocalDate;

public class Reserva {
    private Cliente reservista;
    private Quarto quarto_reservado;
    private LocalDate dataCheckIn;
    private LocalDate dataCheckOut;

    Reserva(Cliente cliente, Quarto quarto, LocalDate dataCheckIn, LocalDate dataCheckOut) {
        this.reservista = cliente;
        this.quarto_reservado = quarto;
        this.dataCheckIn = dataCheckIn;
        this.dataCheckOut = dataCheckOut;
    }

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
    public LocalDate getDataCheckIn() {
        return dataCheckIn;
    }
    public void setDataCheckIn(LocalDate dataCheckIn) {
        this.dataCheckIn = dataCheckIn;
    }
    public LocalDate getDataCheckOut() {
        return dataCheckOut;
    }
    public void setDataCheckOut(LocalDate dataCheckOut) {
        this.dataCheckOut = dataCheckOut;
    }
    
}
