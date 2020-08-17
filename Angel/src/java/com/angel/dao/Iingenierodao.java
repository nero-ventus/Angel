/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.angel.dao;

import com.angel.modelo.ingeniero;
import java.util.ArrayList;

/**
 *
 * @author devil
 */
public interface Iingenierodao {
    int altaingeniero(ingeniero a);
    
    ingeniero traeingeniero(ingeniero a);
    
    ingeniero traeingeniero_sin_contra(String correo);
    
    int asigna_reporte_ingeniero(int id_reporte,String correo_inge);
    
    int actualizaingeniero(String correo_ingeniero,ingeniero a);
    
    int borraingeniero(String correo_ingeniero);
    
    ArrayList<ingeniero> trae_ingenieros();
    
    int subir_solucion(String solucion,int id_reporte_e);
}
