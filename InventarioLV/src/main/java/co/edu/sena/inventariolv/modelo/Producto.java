package co.edu.sena.inventariolv.modelo;

import java.math.BigInteger;

public class Producto {
    
    private int id_prod;
    private String descripcion;
    private BigInteger numero_serie;
    private BigInteger precio;

    public Producto(int id_prod, String descripcion, BigInteger numero_serie, BigInteger precio) {
        this.id_prod = id_prod;
        this.descripcion = descripcion;
        this.numero_serie = numero_serie;
        this.precio = precio;
    }

    public int getId_prod() {
        return id_prod;
    }

    public void setId_prod(int id_prod) {
        this.id_prod = id_prod;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigInteger getNumero_serie() {
        return numero_serie;
    }

    public void setNumero_serie(BigInteger numero_serie) {
        this.numero_serie = numero_serie;
    }

    public BigInteger getPrecio() {
        return precio;
    }

    public void setPrecio(BigInteger precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto{" + "id_prod=" + id_prod + ", descripcion=" + descripcion + ", numero_serie=" + numero_serie + ", precio=" + precio + '}';
    }
    
}
