/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.angel.modelo;

/**
 *
 * @author devil
 */
public class etiquetas {
    private int id_etiqueta;
    private String nombre;

    public etiquetas(int id_etiqueta, String nombre) {
        this.id_etiqueta = id_etiqueta;
        this.nombre = nombre;
    }

    public int getId_etiqueta() {
        return id_etiqueta;
    }

    public void setId_etiqueta(int id_etiqueta) {
        this.id_etiqueta = id_etiqueta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "etiquetas{" + "id_etiqueta=" + id_etiqueta + ", nombre=" + nombre + '}';
    }
    
}
