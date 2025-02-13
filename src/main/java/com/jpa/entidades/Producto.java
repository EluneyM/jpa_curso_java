package com.jpa.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "producto")
public class Producto {
    @Id
    @Column(name = "id_producto")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProducto;

    @Column(name = "cantidad_en_stock")
    private String cantidadEnStock;

    @Column(name = "codigo_producto")
    private String codigoProducto;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "dimensiones")
    private String dimensiones;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "precio")
    private int precio;

    @Column(name = "precio_venta")
    private int precioVenta;

    @Column(name = "proveedor")
    private String proveedor;

    @ManyToOne
    @JoinColumn(name = "id_gama")
    private GamaProducto gama;

    public Producto() {
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getCantidadEnStock() {
        return cantidadEnStock;
    }

    public void setCantidadEnStock(String cantidadEnStock) {
        this.cantidadEnStock = cantidadEnStock;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDimensiones() {
        return dimensiones;
    }

    public void setDimensiones(String dimensiones) {
        this.dimensiones = dimensiones;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(int precioVenta) {
        this.precioVenta = precioVenta;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public GamaProducto getGama() {
        return gama;
    }

    public void setGama(GamaProducto gama) {
        this.gama = gama;
    }

}
