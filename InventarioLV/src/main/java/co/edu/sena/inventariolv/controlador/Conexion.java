package co.edu.sena.inventariolv.controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Conexion {
    private static Connection conect;
    
    public static void conectar(){
    
        try {
            String url = "jdbc:mysql://localhost:3306/inventario_db?serverTimeZone=UTC";
            String usr = "root";
            String ctr = "Admin";
            
            conect= DriverManager.getConnection(url,usr,ctr);
            JOptionPane.showMessageDialog(null, "Conectado al servidor");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Problemas con la conexion");
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Connection getConect() {
        return conect;
    }
}
