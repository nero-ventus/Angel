package com.angel.modelo;
public class direccion {
    private int id_direccion;
    private int n_exterior;
    private String calle;
    private String municipio;
    private int id_estado;

    public direccion(int id_direccion, int n_exterior, String calle, String municipio, int id_estado) {
        this.id_direccion = id_direccion;
        this.n_exterior = n_exterior;
        this.calle = calle;
        this.municipio = municipio;
        this.id_estado = id_estado;
    }

    public int getId_direccion() {
        return id_direccion;
    }

    public void setId_direccion(int id_direccion) {
        this.id_direccion = id_direccion;
    }

    public int getN_exterior() {
        return n_exterior;
    }

    public void setN_exterior(int n_exterior) {
        this.n_exterior = n_exterior;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public int getId_estado() {
        return id_estado;
    }

    public void setId_estado(int id_estado) {
        this.id_estado = id_estado;
    }

    @Override
    public String toString() {
        return "direccion{" + "id_direccion=" + id_direccion + ", n_exterior=" + n_exterior + ", calle=" + calle + ", municipio=" + municipio + ", id_estado=" + id_estado + '}';
    }
    
}