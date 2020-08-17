/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.angel.dao;

import com.angel.modelo.infante;
import java.util.ArrayList;

/**
 *
 * @author devil
 */
public interface Iinfantedao {
    int altainfante(infante a,String correo,String id_dispositivo,ArrayList afecciones);
    
    infante traeinfante(int id_infante, String correo);
    
    int actualizainfante(infante a,String id_dispositivo,ArrayList afecciones);
    
    int borrainfante(int id_infante);
    
    ArrayList<infante> treinfantes(String correo);
}