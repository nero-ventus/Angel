package com.angel.modelo;
public class tickets {
    private int id_ticket;
    private int id_usuario;
    private  String correo_admin;
    private int estado;
    private int modulo;
    private String pregunta;
    private String respuesta;

    public tickets(int id_ticket, int id_usuario, String correo_admin, int estado, int modulo, String pregunta, String respuesta) {
        this.id_ticket = id_ticket;
        this.id_usuario = id_usuario;
        this.correo_admin = correo_admin;
        this.estado = estado;
        this.modulo = modulo;
        this.pregunta = pregunta;
        this.respuesta = respuesta;
    }

    public int getId_ticket() {
        return id_ticket;
    }

    public void setId_ticket(int id_ticket) {
        this.id_ticket = id_ticket;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getCorreo_admin() {
        return correo_admin;
    }

    public void setCorreo_admin(String correo_admin) {
        this.correo_admin = correo_admin;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getModulo() {
        return modulo;
    }

    public void setModulo(int modulo) {
        this.modulo = modulo;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    @Override
    public String toString() {
        return "tickets{" + "id_ticket=" + id_ticket + ", id_usuario=" + id_usuario + ", correo_admin=" + correo_admin + ", estado=" + estado + ", modulo=" + modulo + ", pregunta=" + pregunta + ", respuesta=" + respuesta + '}';
    }
    
}