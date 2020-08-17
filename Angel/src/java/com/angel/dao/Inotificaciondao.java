/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.angel.dao;

import com.angel.modelo.notificacion;

/**
 *
 * @author devil
 */
public interface Inotificaciondao {
    int altanotificacion(notificacion a,String correo);
    
    notificacion traenotificacion(String correo);
    
    int actualizanotificacion(notificacion a,String correo);
    
    int borranotificacion(int noti, String correo);
}