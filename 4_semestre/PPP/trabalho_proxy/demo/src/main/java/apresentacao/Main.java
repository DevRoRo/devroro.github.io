package apresentacao;

import negocio.Carro;
import negocio.CarroProxy;
import negocio.Data;
import negocio.Empregado;

public class Main {
    public static void main(String[] args) {
        Empregado estagiario = new Empregado("João", new Data(1, 1, 2009), 0);
        Empregado semCnh = new Empregado("Marcelo", new Data(2, 2, 1989), 0);
        Empregado maioral = new Empregado("Caio", new Data(3, 3, 2001), 2425233);

        Carro carro = new Carro(2023, "Hb20", "Hyundai", "STR-32Q5", "342");
        CarroProxy carroProxy = new CarroProxy(carro);

        carroProxy.manobrar(estagiario);
        carroProxy.manobrar(semCnh);
        carroProxy.manobrar(maioral);
    }
}