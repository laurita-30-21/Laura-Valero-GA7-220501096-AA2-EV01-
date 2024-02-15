package co.edu.sena.inventariolv.controlador;

import co.edu.sena.inventariolv.modelo.Producto;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CProducto {
    
    public void RegistrarProducto(Producto p){
        
        try {
            Statement st= Conexion.getConect().createStatement();
            st.execute("insert into producto values('"+p.getId_prod()+"','"+p.getDescripcion()+"','"+p.getNumero_serie()+"','"+p.getPrecio()+"')");
            JOptionPane.showMessageDialog(null, " Producto Registrado");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo registrar el producto");
            Logger.getLogger(CProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ResultSet ConsultarProducto(){
        ResultSet rs=null;
        
        try {
            
            Statement st= Conexion.getConect().createStatement();
            rs=st.executeQuery("Select * from producto");
            
        } catch (SQLException ex) {
            Logger.getLogger(CProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rs;
    }
    
    public ResultSet ConsultarProductoPorID(int codigo){
        ResultSet rs=null;
        
        try {
            
            Statement st= Conexion.getConect().createStatement();
            rs=st.executeQuery("Select * from producto where id_prod='"+codigo+"'");
            
        } catch (SQLException ex) {
            Logger.getLogger(CProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rs;    
    }
    
    public void ModificarProducto(Producto p){
        
        try {
            
            Statement st= Conexion.getConect().createStatement();
            st.execute("update producto set descripcion='"+p.getDescripcion()+"', numero_serie='"+p.getNumero_serie()+"', precio='"+p.getPrecio()+"' where id_prod='"+p.getId_prod()+"'");
            JOptionPane.showMessageDialog(null, "Actualizado");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No pudo actualizar");
            Logger.getLogger(CProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void EliminarProducto(int codigo ){
        try {
            
            Statement st= Conexion.getConect().createStatement();
            st.execute("delete from producto where id_prod ='"+codigo+"'");
            JOptionPane.showMessageDialog(null, "Eliminado");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No Eliminado");
            Logger.getLogger(CProducto.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public void pintarTabla(JTable tabla, ResultSet rs){
        
        DefaultTableModel modelo =new DefaultTableModel();
        
        modelo.addColumn("ID");
        modelo.addColumn("DESCRIPCION");
        modelo.addColumn("NUMERO DE SERIE");
        modelo.addColumn("PRECIO");
        
        try {
            while( rs.next()){
                       
                String fila []={rs.getString("id_prod"),rs.getString("descripcion"),rs.getString("numero_serie"),rs.getString("precio")};
                modelo.addRow(fila);
            }
            
            tabla.setModel(modelo);
            
        } catch (SQLException ex) {
            Logger.getLogger(CProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
