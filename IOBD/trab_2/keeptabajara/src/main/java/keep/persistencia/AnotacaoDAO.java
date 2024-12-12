package keep.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import keep.negocio.Anotacao;

public class AnotacaoDAO {

    public void listarAnotacoes() throws SQLException {

        String sql = "SELECT id, titulo from anotacao";
        Connection conexao = new ConexaoPostgres().getConexao();

        PreparedStatement preparedStatement = conexao.prepareStatement(sql);

        ResultSet rs = preparedStatement.executeQuery();

        while (rs.next()) {
            System.out.println(rs.getString("id")+" - "+rs.getString("titulo"));
        }
    }

    public Anotacao obterAnotacao (int id) throws SQLException {

        String sql = "SELECT * FROM anotacao WHERE id = ?"; /* Testar a funcionalidade unique no postgres pra recolher as anotações pelo titulo como uma chave primária */
        Connection conexao = new ConexaoPostgres().getConexao();

        PreparedStatement preparedStatement = conexao.prepareStatement(sql);
        preparedStatement.setInt(1, id);

        ResultSet rs = preparedStatement.executeQuery();

        rs.next(); /* pra que serve? */

        String titulo = rs.getString("titulo");
        String descricao = rs.getString("descricao");
        String data = rs.getString("data_hora");

        return new Anotacao(titulo, descricao, data);

    }

    public void registrarAnotacao(Anotacao anotacao) throws SQLException {
        String sql = "INSERT INTO anotacao (titulo, descricao, cor, data_hora) VALUES (?, ?, ?, ?)";
        Connection conexao = new ConexaoPostgres().getConexao();
        
        PreparedStatement preparedStatement = conexao.prepareStatement(sql);
        preparedStatement.setString(1, anotacao.getTitulo());
        preparedStatement.setString(2, anotacao.getDescricao());
        preparedStatement.setString(3, anotacao.getCor());

        preparedStatement.executeUpdate();
    }

    public void deletarAnotacao(int id) throws SQLException {
        String sql = "DELETE FROM anotacao where id = ?";
        Connection conexao = new ConexaoPostgres().getConexao();

        PreparedStatement preparedStatement = conexao.prepareStatement(sql);
        preparedStatement.setInt(1, id);

        int i = preparedStatement.executeUpdate();

        if (i > 0) {
            System.out.println(id+" deletado");
        } else {
            System.out.println("Não existe anotação de id "+id+". Tente novamente.");
        }
    }

    public void atualizarAnotacao (int id, String coluna, String troca) throws SQLException {
        switch (coluna.toLowerCase()) {
            case "titulo":
                
                break;

            case "descricao":
                
                break;

            case "cor":
                
                break;

            case "foto":
                
                break;
        
            default:
            throw new SQLException("Não existe atributo a ser trocado com esse nome");
        }

        String sql = "UPDATE anotacao set "+coluna+" = ? where id = ?";
        Connection conexao = new ConexaoPostgres().getConexao();

        PreparedStatement preparedStatement = conexao.prepareStatement(sql);
        preparedStatement.setString(1, troca);
        preparedStatement.setInt(2, id);

        preparedStatement.executeUpdate();
    }
}
