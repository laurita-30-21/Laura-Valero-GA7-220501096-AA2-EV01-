package co.edu.sena.inventariolv;

import co.edu.sena.inventariolv.controlador.Conexion;
import co.edu.sena.inventariolv.vista.ManejadorPantallas;

public class InventarioLV {

    public static void main(String[] args) {
        
        Conexion.conectar();
        ManejadorPantallas.abrirPantallaProducto();
    }
}
