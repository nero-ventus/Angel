/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.angel.impdao;

import com.angel.bd.conexion_base;
import com.angel.dao.Ioperadordao;
import com.angel.modelo.operador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author devil
 */
public class impoperador implements Ioperadordao{
    Connection conex=null;
    PreparedStatement sta=null;
    ResultSet resul=null;
    final String registra="call sp_registra_operador(?,?,?,?);";
    final String trae="call sp_trae_operador(?,?);";
    @Override
    public int altaoperador(operador a) {
        int valida=0;
        try{
            conexion_base conecta=new conexion_base();
            conex=conecta.getConex();
            sta=conex.prepareCall(registra);
            sta.setString(1, a.getCorreo());
            sta.setString(2, a.getContra());
            sta.setString(3, a.getNombre());
            sta.setString(4, a.getApellidos());
            resul=sta.executeQuery();
            if(resul.next()){
                valida=resul.getInt(1);
            }
        }
        catch(Exception e){
            e.printStackTrace();
            valida=0;
        }
        return valida;
    }

    @Override
    public operador traeoperador(operador a) {
        operador opera=null;
        try{
            conexion_base conecta=new conexion_base();
            conex=conecta.getConex();
            sta=conex.prepareCall(trae);
            sta.setString(1, a.getCorreo());
            sta.setString(2, a.getContra());
            resul=sta.executeQuery();
            if(resul.next()){
                opera=new operador(resul.getString(1), resul.getString(2), resul.getString(3), resul.getString(4));
            }
        }
        catch(Exception e){
            e.printStackTrace();
            opera=null;
        }
        return opera;
    }

    @Override
    public int actualizaoperador(String correo_operador, operador a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int borraoperador(String correo_operador) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}