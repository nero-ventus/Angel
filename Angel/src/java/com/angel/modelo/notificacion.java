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
public class notificacion {
    private int id_noti;
    private int volumen;
    private String tono;
    private int tipo_noti;

    public notificacion(int id_noti, int volumen, String tono, int tipo_noti) {
        this.id_noti = id_noti;
        this.volumen = volumen;
        this.tono = tono;
        this.tipo_noti = tipo_noti;
    }

    public int getId_noti() {
        return id_noti;
    }

    public void setId_noti(int id_noti) {
        this.id_noti = id_noti;
    }

    public int getVolumen() {
        return volumen;
    }

    public void setVolumen(int volumen) {
        this.volumen = volumen;
    }

    public String getTono() {
        return tono;
    }

    public void setTono(String tono) {
        this.tono = tono;
    }

    public int getTipo_noti() {
        return tipo_noti;
    }

    public void setTipo_noti(int tipo_noti) {
        this.tipo_noti = tipo_noti;
    }

    @Override
    public String toString() {
        return "notificacion{" + "id_noti=" + id_noti + ", volumen=" + volumen + ", tono=" + tono + ", tipo_noti=" + tipo_noti + '}';
    }
    
}