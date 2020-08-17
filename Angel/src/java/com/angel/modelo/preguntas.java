/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.angel.modelo;

/**
 *
 * @author Profesor
 */
public class preguntas {
    private int id_pregunta,id_usuario;
    private String texto;

    public int getId_pregunta() {
        return id_pregunta;
    }

    public void setId_pregunta(int id_pregunta) {
        this.id_pregunta = id_pregunta;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public preguntas(int id_pregunta, int id_usuario, String texto) {
        this.id_pregunta = id_pregunta;
        this.id_usuario = id_usuario;
        this.texto = texto;
    }

    @Override
    public String toString() {
        return "preguntas{" + "id_pregunta=" + id_pregunta + ", id_usuario=" + id_usuario + ", texto=" + texto + '}';
    }
    
}
