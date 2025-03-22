package keep.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoPostgres {

    private final String dbname;
    public static String username;
    public static String password;
    private final String port;
    private final String host;
    private final String url;
    
              
     public ConexaoPostgres(){
        dbname  = "keep_tabajara";
        username = "postgres";
        password = "postgres";
        port = "5432";
        host = "localhost";
        url = "jdbc:postgresql://"+host+":"+port+"/"+dbname;

     }
     
     public Connection getConexao() throws SQLException{
        return DriverManager.getConnection(url, username, password);
     }
    
}