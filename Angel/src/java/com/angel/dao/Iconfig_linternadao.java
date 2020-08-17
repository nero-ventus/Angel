/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.angel.dao;

import com.angel.modelo.config_linterna;

/**
 *
 * @author devil
 */
public interface Iconfig_linternadao {
    int altaconfig_linterna(config_linterna a,String correo);
    
    config_linterna traeconfig_linterna(String correo);
    
    int actualizaconfig_linterna(config_linterna a,String correo);
    
    int borraconfig_linterna(int id_configli, String correo);
}