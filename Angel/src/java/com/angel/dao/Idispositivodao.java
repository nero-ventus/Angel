/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.angel.dao;

import com.angel.modelo.dispositivo;
import java.util.ArrayList;

/**
 *
 * @author devil
 */
public interface Idispositivodao {
    int altadispositivo(dispositivo a,String correo);
    
    dispositivo traedispositivo(int id_infante);
    
    int actualizadispositivo(dispositivo a,String correo);
    
    void borradispositivo(int id_dispositivo);
    
    ArrayList<dispositivo> tredispositivosLibres(String correo);
}