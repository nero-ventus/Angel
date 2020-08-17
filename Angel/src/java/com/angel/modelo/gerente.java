/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.angel.modelo;

/**
 *
 * @author devil
 */
public class gerente {
    private String correo_inge;

    public gerente(String correo_inge) {
        this.correo_inge = correo_inge;
    }

    public String getCorreo_inge() {
        return correo_inge;
    }

    public void setCorreo_inge(String correo_inge) {
        this.correo_inge = correo_inge;
    }

    @Override
    public String toString() {
        return "gerente{" + "correo_inge=" + correo_inge + '}';
    }
    
}
