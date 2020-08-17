/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.angel.modelo;
import java.sql.Date;

/**
 *
 * @author Jesus Abraham
 */
public class reporte_mantenimiento {
    private int id_repor_mantenimiento;
    private Date fecha;
    private int estado;
    private String descripcion;
    private String solucion;
    private String tipo;
    private String correo_gere;

    public reporte_mantenimiento(int id_repor_mantenimiento, Date fecha, int estado, String descripcion, String solucion, String tipo, String correo_gere) {
        this.id_repor_mantenimiento = id_repor_mantenimiento;
        this.fecha = fecha;
        this.estado = estado;
        this.descripcion = descripcion;
        this.solucion = solucion;
        this.tipo = tipo;
        this.correo_gere = correo_gere;
    }

    public reporte_mantenimiento(Date fecha_re, String descrip, String tipo, String correo_gerent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId_repor_mantenimiento() {
        return id_repor_mantenimiento;
    }

    public void setId_repor_mantenimiento(int id_repor_mantenimiento) {
        this.id_repor_mantenimiento = id_repor_mantenimiento;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCorreo_gere() {
        return correo_gere;
    }

    public void setCorreo_gere(String correo_gere) {
        this.correo_gere = correo_gere;
    }
 

}
