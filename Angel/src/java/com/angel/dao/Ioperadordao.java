/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.angel.dao;

import com.angel.modelo.operador;

/**
 *
 * @author devil
 */
public interface Ioperadordao {
    int altaoperador(operador a);
    
    operador traeoperador(operador a);
    
    int actualizaoperador(String correo_operador,operador a);
    
    int borraoperador(String correo_operador);
}
