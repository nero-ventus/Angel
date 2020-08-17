/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.angel.impdao;

import com.angel.bd.conexion_base;
import com.angel.dao.Iconfig_lexternadao;
import com.angel.modelo.config_lexterna;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author devil
 */
public class impconfig_lexterna implements Iconfig_lexternadao{
    Connection conex=null;
    PreparedStatement sta=null;
    ResultSet resul=null;
    private final String llama="call sp_getconfig_le(?)";
    private final String actualiza="call sp_actualiza_config_le(?,?,?)";
    @Override
    public int altaconfig_lexterna(config_lexterna a, String correo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public config_lexterna traeconfig_lexterna(String correo) {
        config_lexterna confi=null;
        try{
            conexion_base conecta=new conexion_base();
            conex=conecta.getConex();
            sta=conex.prepareCall(llama);
            sta.setString(1, correo);
            resul=sta.executeQuery();
            if(resul.next()){
                confi=new config_lexterna(resul.getInt(1), resul.getInt(2), resul.getInt(3), resul.getInt(4), resul.getInt(5));
            }
            conex.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return confi;
    }

    @Override
    public int actualizaconfig_lexterna(config_lexterna a, String correo) {
        int valida=0;
        try{
            conexion_base conecta=new conexion_base();
            conex=conecta.getConex();
            sta=conex.prepareCall(actualiza);
            sta.setString(1, correo);
            sta.setInt(2, a.getEstado_servicio());
            sta.setInt(3, a.getDistancia_permitida());
            resul=sta.executeQuery();
            if(resul.next()){
                valida=resul.getInt(1);
            }
            conex.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return valida;
    }

    @Override
    public int borraconfig_lexterna(int id_configli, String correo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}