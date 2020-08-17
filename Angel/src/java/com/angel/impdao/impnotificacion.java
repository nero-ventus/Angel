/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.angel.impdao;

import com.angel.bd.conexion_base;
import com.angel.dao.Inotificaciondao;
import com.angel.modelo.notificacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author devil
 */
public class impnotificacion implements Inotificaciondao{
    private final String llamar1="call sp_getnoti(?)";
    private final String modifica="call sp_actualiza_noti(?,?,?,1)";
    Connection conex=null;
    PreparedStatement sta=null;
    ResultSet resul=null;
    @Override
    public int altanotificacion(notificacion a, String correo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public notificacion traenotificacion(String correo) {
        notificacion noti=null;
        try{
            conexion_base conecta=new conexion_base();
            conex=conecta.getConex();
            sta=conex.prepareCall(llamar1);
            sta.setString(1, correo);
            resul=sta.executeQuery();
            if(resul.next()){
                noti=new notificacion(resul.getInt(1), resul.getInt(2), resul.getString(3), resul.getInt(4));
            }
            conex.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return noti;
    }

    @Override
    public int actualizanotificacion(notificacion a, String correo) {
        int validado=0;
        try{
            conexion_base conecta=new conexion_base();
            conex=conecta.getConex();
            sta=conex.prepareCall(modifica);
            sta.setString(1, correo);
            sta.setInt(2, a.getVolumen());
            sta.setString(3, a.getTono());
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
    public int borranotificacion(int noti, String correo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}