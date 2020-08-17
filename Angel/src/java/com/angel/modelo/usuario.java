package com.angel.modelo;
public class usuario {
    private int id_usuario;
    private String nombre;
    private String apellido_p;
    private String apellido_m;
    private int id_direccion;
    private String correo;

    public usuario(int id_usuario, String nombre, String apellido_p, String apellido_m, int id_direccion, String correo) {
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.apellido_p = apellido_p;
        this.apellido_m = apellido_m;
        this.id_direccion = id_direccion;
        this.correo = correo;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido_p() {
        return apellido_p;
    }

    public void setApellido_p(String apellido_p) {
        this.apellido_p = apellido_p;
    }

    public String getApellido_m() {
        return apellido_m;
    }

    public void setApellido_m(String apellido_m) {
        this.apellido_m = apellido_m;
    }

    public int getId_direccion() {
        return id_direccion;
    }

    public void setId_direccion(int id_direccion) {
        this.id_direccion = id_direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "usuario{" + "id_usuario=" + id_usuario + ", nombre=" + nombre + ", apellido_p=" + apellido_p + ", apellido_m=" + apellido_m + ", id_direccion=" + id_direccion + ", correo=" + correo + '}';
    }
    
}