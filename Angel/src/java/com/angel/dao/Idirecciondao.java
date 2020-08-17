/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.angel.dao;

import com.angel.modelo.direccion;

/**
 *
 * @author devil
 */
public interface Idirecciondao {
    int altadireccion(direccion a);
    
    direccion traedireccion(int id_direc);
    
    void actualizadireccion(direccion a);
    
    void borradireccion(int id_direc);
}