/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.angel.impdao;

import com.angel.bd.conexion_base;
import com.angel.dao.Iconfig_linternadao;
import com.angel.modelo.config_linterna;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author devil
 */
public class impconfig_linterna implements Iconfig_linternadao{
    private final String llamar1="call sp_getconfig_li(?)";
    private final String modifica="call sp_actualiza_config_li(?,?)";
    Connection conex=null;
    PreparedStatement sta=null;
    ResultSet resul=null;
    @Override
    public int altaconfig_linterna(config_linterna a, String correo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public config_linterna traeconfig_linterna(String correo) {
        config_linterna configuracion=null;
        try{
            conexion_base conecta=new conexion_base();
            conex=conecta.getConex();
            sta=conex.prepareCall(llamar1);
            sta.setString(1, correo);
            resul=sta.executeQuery();
            if(resul.next()){
                configuracion=new config_linterna(resul.getInt(1), resul.getInt(2), resul.getInt(3), resul.getInt(4));
            }
            conex.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return configuracion;
    }

    @Override
    public int actualizaconfig_linterna(config_linterna a, String correo) {
        int validado=0;
        try{
            conexion_base conecta=new conexion_base();
            conex=conecta.getConex();
            sta=conex.prepareCall(modifica);
            sta.setString(1, correo);
            sta.setInt(2, a.getEstado_servicio());
            resul=sta.executeQuery();
            if(resul.next()){
                validado=resul.getInt(1);
            }
            conex.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return validado;
    }

    @Override
    public int borraconfig_linterna(int id_configli, String correo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}