package com.movil.clase.tallercomputadores;

public class Computador {
    private String marca,tipo,ram,color,so;
    private int foto;
    private String id;
    public Computador(String id, String marca, String tipo, String ram, String color, String so, int foto) {
        this.marca = marca;
        this.tipo = tipo;
        this.ram = ram;
        this.color = color;
        this.so = so;
        this.foto = foto;
        this.id = id;
    }

    public Computador() {
    }
    public Computador(String id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }
    public String getId() {
        return id;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSo() {
        return so;
    }

    public void setSo(String so) {
        this.so = so;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public void guardar(){
        Datos.guardar(this);
    }

    public void eliminar(){ Datos.eliminarComputadors(this); }
}
