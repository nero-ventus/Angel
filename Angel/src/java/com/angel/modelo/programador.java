/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.angel.modelo;

/**
 *
 * @author Jesus Abraham
 */
public class programador {
     private String correo;
    private String contra;
    private String nombre;
    private String apellidos;

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

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public programador(String correo, String contra, String nombre, String apellidos) {
        this.correo = correo;
        this.contra = contra;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    @Override
    public String toString() {
        return "programador{" + "correo=" + correo + ", contra=" + contra + ", nombre=" + nombre + ", apellidos=" + apellidos + '}';
    }
    
}
