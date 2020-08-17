/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.angel.modelo;

/**
 *
 * @author Alumno
 */
public class afecciones {
    private int id_afeccion;
    private String nombre;

    public afecciones(int id_afeccion, String nombre) {
        this.id_afeccion = id_afeccion;
        this.nombre = nombre;
    }

    public int getId_afeccion() {
        return id_afeccion;
    }

    public void setId_afeccion(int id_afeccion) {
        this.id_afeccion = id_afeccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "afecciones{" + "id_afeccion=" + id_afeccion + ", nombre=" + nombre + '}';
    }
    
}