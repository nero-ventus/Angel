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
public class sensores {
    private String id_sensor;
    private String codigo;
    private int id_cuarto;
    private int estado_permiso;

    public sensores(String id_sensor, String codigo, int id_cuarto, int estado_permiso) {
        this.id_sensor = id_sensor;
        this.codigo = codigo;
        this.id_cuarto = id_cuarto;
        this.estado_permiso = estado_permiso;
    }

    public String getId_sensor() {
        return id_sensor;
    }

    public void setId_sensor(String id_sensor) {
        this.id_sensor = id_sensor;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getId_cuarto() {
        return id_cuarto;
    }

    public void setId_cuarto(int id_cuarto) {
        this.id_cuarto = id_cuarto;
    }

    public int getEstado_permiso() {
        return estado_permiso;
    }

    public void setEstado_permiso(int estado_permiso) {
        this.estado_permiso = estado_permiso;
    }

    @Override
    public String toString() {
        return "sensores{" + "id_sensor=" + id_sensor + ", codigo=" + codigo + ", id_cuarto=" + id_cuarto + ", estado_permiso=" + estado_permiso + '}';
    }
    
}