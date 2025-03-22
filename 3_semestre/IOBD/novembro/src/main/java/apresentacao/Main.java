/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package apresentacao;

import java.awt.FlowLayout;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import negocio.Veiculo;
import persistencia.ConexaoPostgreSQL;
import persistencia.VeiculoDAO;

/**
 *
 * @author iapereira
 */
public class Main {
    
    public static void main(String[] args) throws SQLException, IOException {

        VeiculoDAO veiculoDAO = new VeiculoDAO();
        Veiculo veiculo = veiculoDAO.obter(11); // trocar o id
        System.out.println(veiculo);  
        
        JFrame jFrame = new JFrame();
        jFrame.setLayout(new FlowLayout());
        jFrame.setSize(500, 400);
        JLabel jLabel = new JLabel(new ImageIcon(/*colocar caminho da foto*/));
        jFrame.add(jLabel);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }   
}
