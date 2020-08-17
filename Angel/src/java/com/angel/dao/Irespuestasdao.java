/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.angel.dao;

import com.angel.modelo.respuestas;
import java.util.ArrayList;

/**
 *
 * @author Profesor
 */
public interface Irespuestasdao {
    int altarespuestas(String texto,int id_pregunta);
    
    respuestas traerespuesta();
    
    int actualizarespuestas();
    
    int borrarespuestas();
    
    ArrayList<respuestas> traerespuestas();
}
