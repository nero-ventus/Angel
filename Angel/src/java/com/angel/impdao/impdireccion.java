/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.angel.impdao;

import com.angel.bd.conexion_base;
import com.angel.dao.Idirecciondao;
import com.angel.modelo.direccion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author devil
 */
public class impdireccion implements Idirecciondao{
    private final String llamar="call sp_getdirec(?)";
    Connection conex=null;
    PreparedStatement sta=null;
    ResultSet resul=null;
    
    @Override
    public int altadireccion(direccion a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public direccion traedireccion(int id_direc) {
        direccion direc=null;
        try{
            conexion_base conecta=new conexion_base();
            conex=conecta.getConex();
            sta=conex.prepareCall(llamar);
            sta.setInt(1, id_direc);
            resul=sta.executeQuery();
            if(resul.next()){
                direc=new direccion(id_direc, resul.getInt(2), resul.getString(3), resul.getString(4), resul.getInt(5));
            }
            conex.close();
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return direc;
    }

    @Override
    public void actualizadireccion(direccion a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void borradireccion(int id_direc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
