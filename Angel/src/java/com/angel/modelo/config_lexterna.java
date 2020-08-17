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
public class config_lexterna {
    private int id_configle;
    private int distancia_permitida;
    private int estado_servicio;
    private int id_usuario;
    private int id_noti;

    public config_lexterna(int id_configle, int distancia_permitida, int estado_servicio, int id_usuario, int id_noti) {
        this.id_configle = id_configle;
        this.distancia_permitida = distancia_permitida;
        this.estado_servicio = estado_servicio;
        this.id_usuario = id_usuario;
        this.id_noti = id_noti;
    }

    public int getId_configle() {
        return id_configle;
    }

    public void setId_configle(int id_configle) {
        this.id_configle = id_configle;
    }

    public int getDistancia_permitida() {
        return distancia_permitida;
    }

    public void setDistancia_permitida(int distancia_permitida) {
        this.distancia_permitida = distancia_permitida;
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
        return "config_lexterna{" + "id_configle=" + id_configle + ", distancia_permitida=" + distancia_permitida + ", estado_servicio=" + estado_servicio + ", id_usuario=" + id_usuario + ", id_noti=" + id_noti + '}';
    }
    
}