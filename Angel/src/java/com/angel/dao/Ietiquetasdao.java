/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.angel.dao;

import com.angel.modelo.etiquetas;
import java.util.ArrayList;

/**
 *
 * @author devil
 */
public interface Ietiquetasdao {
    int altaetiquetas(String nombre_etiqueta,int id_reporte_evento);
    
    etiquetas traeetiqueta(int id_reporte_evento);
    
    int relaciona_reporte_evento_etiqueta(int id_etiqueta,int id_reporte);
    
    ArrayList<etiquetas> traeetiquetas();
    
    int traecantidad(int id_eti);
}
