/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.angel.dao;

import com.angel.modelo.cuenta_usuario;

/**
 *
 * @author devil
 */
public interface Icuenta_usuario {
    int altacuenta_usuario(cuenta_usuario a);
    
    cuenta_usuario traecuenta_usuario(String correo);
    
    void actualizacuenta_usuario(cuenta_usuario a);
    
    void borracuenta_usuario(String correo);
}