package com.angel.modelos;

public class dispositivo {
    private String id_dispositivo;
    private String posicion_global;
    private String codigo;

    public dispositivo(String id_dispositivo, String posicion_global, String codigo) {
        this.id_dispositivo = id_dispositivo;
        this.posicion_global = posicion_global;
        this.codigo = codigo;
    }

    public String getId_dispositivo() {
        return id_dispositivo;
    }

    public void setId_dispositivo(String id_dispositivo) {
        this.id_dispositivo = id_dispositivo;
    }

    public String getPosicion_global() {
        return posicion_global;
    }

    public void setPosicion_global(String posicion_global) {
        this.posicion_global = posicion_global;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "dispositivo{" + "id_dispositivo=" + id_dispositivo + ", posicion_global=" + posicion_global + ", codigo=" + codigo + '}';
    }
}