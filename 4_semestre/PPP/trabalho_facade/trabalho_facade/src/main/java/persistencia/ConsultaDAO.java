package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import negocio.Cliente;

public class ConsultaDAO {

    private ConexaoPostgreSQL conexao;

    public ConsultaDAO(){
        this.conexao = new ConexaoPostgreSQL();
    }

    public boolean ExisteCpfNaDataBase(Cliente cliente) throws SQLException {
        String sql = "SELECT nome FROM clientes WHERE cpf = ?;";
        Connection connection = conexao.getConexao();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, cliente.getCpf());
        ResultSet result = statement.executeQuery();

        if (result.next()) {
            statement.close();
            connection.close();
            return true;
        }

        statement.close();
        connection.close();
        
        return false;
    }

    public boolean inserir(Cliente cliente) throws SQLException{
        String sql = "INSERT INTO clientes (nome, cpf) VALUES (?,?) RETURNING cpf;";
        Connection connection = conexao.getConexao();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, cliente.getNome());
        statement.setString(2, cliente.getCpf());
        ResultSet rs = statement.executeQuery();

        return rs.next(); 
    }

    public void deletar(String nome) throws SQLException {
        String sql = "DELETE FROM consulta where nome = ?;";
        Connection connection = conexao.getConexao();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(0, nome);
        statement.executeUpdate();
        statement.close();
        connection.close();
    }
}
