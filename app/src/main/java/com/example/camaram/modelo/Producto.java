package com.example.camaram.modelo;

import android.content.Context;

public class Producto {

    private int codigo;
    private String nombre;
    private String descripcion;
    private double costo;
    private double precio;
    private int stock;
    private String fecha;
    private byte imagen;

    public Producto(int codigo, String nombre, String descripcion, double costo, double precio, int stock, String fecha, byte imagen) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.costo = costo;
        this.precio = precio;
        this.stock = stock;
        this.fecha = fecha;
        this.imagen = imagen;
    }

    public void guardar(Context context) {
        DbHelper db = new DbHelper(context);
        System.out.println("hola");
        String noSql = "INSERT INTO producto (id,nombre,descripcion,costo,precio,stock,fecha) " +
                "VALUES (" + getCodigo() + ",'" + getNombre()+ "','" + getDescripcion() + "'," + getCosto()+ ","+getPrecio()+","
                +getStock()+",'"+getFecha()+"');";
        db.noQuery(noSql);
        db.close();
    }

    public void Editar(Context context) {
        DbHelper db = new DbHelper(context);
        String noSql = "UPDATE producto set nombre= ' "+getNombre()+"', descripcion= '"+getDescripcion()+"'"
                + "', costo= "+getCosto()+", precio= "+getPrecio()+", stock= "+getStock()+ ",fecha= '"+getFecha()+ "' where codigo="+getCodigo()+";";
        db.noQuery(noSql);
        db.close();
    }

    public void eliminar(Context context){
        DbHelper db = new DbHelper(context);
        String noSql = "DELETE FROM producto where codigo= "+getCodigo();
        db.noQuery(noSql);
        db.close();

    }



    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public byte getImagen() {
        return imagen;
    }

    public void setImagen(byte imagen) {
        this.imagen = imagen;
    }
}
