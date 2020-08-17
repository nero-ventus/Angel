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
public class respuestas {
    private int id_respuesta;
    private String texto;
    private int id_pregunta;

    public respuestas(int id_respuesta, String texto, int id_pregunta) {
        this.id_respuesta = id_respuesta;
        this.texto = texto;
        this.id_pregunta = id_pregunta;
    }

    public int getId_respuesta() {
        return id_respuesta;
    }

    public void setId_respuesta(int id_respuesta) {
        this.id_respuesta = id_respuesta;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getId_pregunta() {
        return id_pregunta;
    }

    public void setId_pregunta(int id_pregunta) {
        this.id_pregunta = id_pregunta;
    }

    @Override
    public String toString() {
        return "respuestas{" + "id_respuesta=" + id_respuesta + ", texto=" + texto + ", id_pregunta=" + id_pregunta + '}';
    }
    
}
