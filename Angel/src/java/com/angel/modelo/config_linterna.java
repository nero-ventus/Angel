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
public class config_linterna {
    private int id_configli;
    private int estado_servicio;
    private int id_usuario;
    private int id_noti;

    public config_linterna(int id_configli, int estado_servicio, int id_usuario, int id_noti) {
        this.id_configli = id_configli;
        this.estado_servicio = estado_servicio;
        this.id_usuario = id_usuario;
        this.id_noti = id_noti;
    }

    public int getId_configli() {
        return id_configli;
    }

    public void setId_configli(int id_configli) {
        this.id_configli = id_configli;
    }

    public int getEstado_servicio() {
        return estado_servicio;
    }

    public void setEstado_servicio(int estado_servicio) {
        this.estado_servicio = estado_servicio;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_noti() {
        return id_noti;
    }

    public void setId_noti(int id_noti) {
        this.id_noti = id_noti;
    }

    @Override
    public String toString() {
        return "config_linterna{" + "id_configli=" + id_configli + ", estado_servicio=" + estado_servicio + ", id_usuario=" + id_usuario + ", id_noti=" + id_noti + '}';
    }
    
}