/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.angel.dao;

import com.angel.modelo.sensores;
import java.util.ArrayList;

/**
 *
 * @author devil
 */
public interface Isensoresdao {
    int altasensor(sensores a);
    
    sensores traesensor(int id_sensor,String correo);
    
    int actualizasensores(sensores a,String correo);
    
    int borrasensores(int id_sensor);
    
    ArrayList<sensores> traeSensores(String correo);
}