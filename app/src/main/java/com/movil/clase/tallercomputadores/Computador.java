package com.movil.clase.tallercomputadores;

public class Computador {
    private int marca,tipo,ram,color,so, foto;
    private String id;
    public Computador(String id, int marca, int tipo, int ram, int color, int so, int foto) {
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

    public int getMarca() {
        return marca;
    }
    public String getId() {
        return id;
    }

    public void setMarca(int marca) {
        this.marca = marca;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getSo() {
        return so;
    }

    public void setSo(int so) {
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
