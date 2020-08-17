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
public class reporte_evento {
    private int id_repor_evento;
    private Date fecha;
    private int estado;
    private String descripcion;
    private String solucion;
    private String correo_inge;
    private String correo_usua;

    public reporte_evento(int id_repor_evento, Date fecha, int estado, String descripcion, String solucion, String correo_inge, String correo_usua) {
        this.id_repor_evento = id_repor_evento;
        this.fecha = fecha;
        this.estado = estado;
        this.descripcion = descripcion;
        this.solucion = solucion;
        this.correo_inge = correo_inge;
        this.correo_usua = correo_usua;
    }

    public int getId_repor_evento() {
        return id_repor_evento;
    }

    public void setId_repor_evento(int id_repor_evento) {
        this.id_repor_evento = id_repor_evento;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getSolucion() {
        return solucion;
    }

    public void setSolucion(String solucion) {
        this.solucion = solucion;
    }

    public String getCorreo_inge() {
        return correo_inge;
    }

    public void setCorreo_inge(String correo_inge) {
        this.correo_inge = correo_inge;
    }

    public String getCorreo_usua() {
        return correo_usua;
    }

    public void setCorreo_usua(String correo_usua) {
        this.correo_usua = correo_usua;
    }

    @Override
    public String toString() {
        return "reporte_evento{" + "id_repor_evento=" + id_repor_evento + ", fecha=" + fecha + ", estado=" + estado + ", descripcion=" + descripcion + ", solucion=" + solucion + ", correo_inge=" + correo_inge + ", correo_usua=" + correo_usua + '}';
    }
    
}