/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.angel.dao;

import com.angel.modelo.afecciones;
import java.util.ArrayList;

/**
 *
 * @author Alumno
 */
public interface Iafeccionesdao{
    int altaafecciones(afecciones a);
    
    int actualizaafecciones(afecciones a);
    
    void borraafecciones(int id_afecciones);
    
    ArrayList<afecciones> traeafeccionesInfante(int id_infante);
}