/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.angel.dao;

import com.angel.modelo.administrador;

/**
 *
 * @author devil
 */
public interface Iadministradordao {
    int altaadministrador(administrador a);
    
    administrador traeadministrador1(String correo,String contra);
    
    administrador traeadministrador2(String correo);
    
    int actualizaadministrador(administrador a);
    
    int borraadministrador(String correo);
}