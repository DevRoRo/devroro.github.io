package service;

import negocio.Cliente;
import persistencia.ConsultaDAO;

public class ClienteService {
    
    public void inserirCliente(String nome, String cpf) throws Exception {
        Cliente cliente = new Cliente(nome, cpf);
        if (new ConsultaDAO().ExisteCpfNaDataBase(cliente)){
            throw new Exception("Já existe cliente com esse CPF, não foi possível inserir.");
        } else {
            new ConsultaDAO().inserir(cliente);
            System.out.println("Cliente inserido com sucesso no banco de dados.");
        }
    }

}
