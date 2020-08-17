/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.angel.dao;

import com.angel.modelo.config_lexterna;

/**
 *
 * @author devil
 */
public interface Iconfig_lexternadao {
    int altaconfig_lexterna(config_lexterna a,String correo);
    
    config_lexterna traeconfig_lexterna(String correo);
    
    int actualizaconfig_lexterna(config_lexterna a,String correo);
    
    int borraconfig_lexterna(int id_configli, String correo);
}