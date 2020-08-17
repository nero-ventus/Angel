package com.angel.modelo;
public class administrador {
    private String correo;
    private String contra;
    private String nombre;
    private int modulo;

    public administrador(String correo, String contra, String nombre, int modulo) {
        this.correo = correo;
        this.contra = contra;
        this.nombre = nombre;
        this.modulo = modulo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getModulo() {
        return modulo;
    }

    public void setModulo(int modulo) {
        this.modulo = modulo;
    }

    @Override
    public String toString() {
        return "administrador{" + "correo=" + correo + ", contra=" + contra + ", nombre=" + nombre + ", modulo=" + modulo + '}';
    }
    
}