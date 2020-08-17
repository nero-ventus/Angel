/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.angel.impdao;

import com.angel.bd.conexion_base;
import com.angel.dao.Icuenta_usuario;
import com.angel.modelo.cuenta_usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author devil
 */
public class impcuenta_usuario implements Icuenta_usuario{
    private final String llamar="call sp_getcuenta_usuario(?)";
    Connection conex=null;
    PreparedStatement sta=null;
    ResultSet resul=null;
    @Override
    public int altacuenta_usuario(cuenta_usuario a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public cuenta_usuario traecuenta_usuario(String correo) {
        cuenta_usuario cuenta=null;
        try{
            conexion_base conecta=new conexion_base();
            conex=conecta.getConex();
            sta=conex.prepareCall(llamar);
            sta.setString(1, correo);
            resul=sta.executeQuery();
            if(resul.next()){
                cuenta=new cuenta_usuario(resul.getString(1), resul.getString(2), resul.getInt(3), resul.getString(4));
            }
            conex.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return cuenta;
    }

    @Override
    public void actualizacuenta_usuario(cuenta_usuario a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void borracuenta_usuario(String correo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}