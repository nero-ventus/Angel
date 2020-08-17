/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.angel.modelo;

import java.sql.Date;

/**
 *
 * @author devil
 */
public class infante {
    private int id_infante;
    private String nombre;
    private String apellido_p;
    private String apellido_m;
    private int peso;
    private int altura;
    private int sexo;
    private Date fecha_naci;

    public infante(int id_infante, String nombre, String apellido_p, String apellido_m, int peso, int altura, int sexo, Date fecha_naci) {
        this.id_infante = id_infante;
        this.nombre = nombre;
        this.apellido_p = apellido_p;
        this.apellido_m = apellido_m;
        this.peso = peso;
        this.altura = altura;
        this.sexo = sexo;
        this.fecha_naci = fecha_naci;
    }

    public int getId_infante() {
        return id_infante;
    }

    public void setId_infante(int id_infante) {
        this.id_infante = id_infante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido_p() {
        return apellido_p;
    }

    public void setApellido_p(String apellido_p) {
        this.apellido_p = apellido_p;
    }

    public String getApellido_m() {
        return apellido_m;
    }

    public void setApellido_m(String apellido_m) {
        this.apellido_m = apellido_m;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getSexo() {
        return sexo;
    }

    public void setSexo(int sexo) {
        this.sexo = sexo;
    }

    public Date getFecha_naci() {
        return fecha_naci;
    }

    public void setFecha_naci(Date fecha_naci) {
        this.fecha_naci = fecha_naci;
    }

    @Override
    public String toString() {
        return "infante{" + "id_infante=" + id_infante + ", nombre=" + nombre + ", apellido_p=" + apellido_p + ", apellido_m=" + apellido_m + ", peso=" + peso + ", altura=" + altura + ", sexo=" + sexo + ", fecha_naci=" + fecha_naci + '}';
    }
    
}