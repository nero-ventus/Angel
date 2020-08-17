/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.angel.dao;

import com.angel.modelo.preguntas;
import java.util.ArrayList;

/**
 *
 * @author Profesor
 */
public interface Ipreguntasdao {
    int altapreguntas(String texto,String correo);
    
    preguntas traepreguntas(int id_pregunta);
    
    int actualizapreguntas();
    
    int borrapreguntas(int id_pregunta);
    
    ArrayList<preguntas> traepreguntass();
}
