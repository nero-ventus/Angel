package com.angel.modelo;
public class codigo_venta {
    private String codigo;
    private int estado_uso;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getEstado_uso() {
        return estado_uso;
    }

    public void setEstado_uso(int estado_uso) {
        this.estado_uso = estado_uso;
    }

    public codigo_venta(String codigo, int estado_uso) {
        this.codigo = codigo;
        this.estado_uso = estado_uso;
    }

    @Override
    public String toString() {
        return "codigo_venta{" + "codigo=" + codigo + ", estado_uso=" + estado_uso + '}';
    }
    
}