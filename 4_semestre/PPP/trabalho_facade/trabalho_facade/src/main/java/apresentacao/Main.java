package apresentacao;

import java.sql.SQLException;

import negocio.Cliente;
import persistencia.ConsultaDAO;

public class Main {
    public static void main(String[] args) throws SQLException {
        Cliente cliente = new Cliente("Ronaldo", "04134650046");
        ConsultaDAO consulta = new ConsultaDAO();

        System.out.println(consulta.ExisteCpfNaDataBase(cliente));

        /* if (consulta.ExisteCpfNaDataBase(cliente)) {
            System.out.println("Já existe uma pessoa com esse CPF, não foi possível inserir.");
        } else {
            consulta.inserir(cliente);
            System.out.println("Cliente inserido com sucesso.");
        } */
        
    }
}