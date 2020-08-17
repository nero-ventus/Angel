package com.angel.modelo;
public class cuenta_usuario {
    private String correo;
    private String contra;
    private int estado_cuenta;
    private String codigo;

    public cuenta_usuario(String correo, String contra, int estado_cuenta, String codigo) {
        this.correo = correo;
        this.contra = contra;
        this.estado_cuenta = estado_cuenta;
        this.codigo = codigo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public int getEstado_cuenta() {
        return estado_cuenta;
    }

    public void setEstado_cuenta(int estado_cuenta) {
        this.estado_cuenta = estado_cuenta;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "cuenta_usuario{" + "correo=" + correo + ", contra=" + contra + ", estado_cuenta=" + estado_cuenta + ", codigo=" + codigo + '}';
    }
    
}