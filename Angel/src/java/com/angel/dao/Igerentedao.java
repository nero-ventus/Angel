/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.angel.dao;

import com.angel.modelo.ingeniero;

/**
 *
 * @author devil
 */
public interface Igerentedao {
    int altagerente(ingeniero a);
    
    int subir_solucion(String solucion, int id_reporte_e);
    
    ingeniero traegerente(ingeniero a);
    
    int actualizagerente(String correo_gerente,ingeniero a);
    
    int borragerente(String correo_gerente);
}