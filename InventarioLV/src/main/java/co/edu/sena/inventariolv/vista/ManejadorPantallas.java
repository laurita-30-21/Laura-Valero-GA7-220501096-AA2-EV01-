package co.edu.sena.inventariolv.vista;

public class ManejadorPantallas {
    
    private static VProducto pantallaProducto;
    
    public static void abrirPantallaProducto(){
        
        pantallaProducto = new VProducto();
        pantallaProducto.setVisible(true);
        pantallaProducto.setLocation(3,10);
    }
    
    public static void cerrarPantallaCLiente(){
        
        pantallaProducto.setVisible(false);
        pantallaProducto=null;
    }
}
