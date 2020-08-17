/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.angel.impdao;

import com.angel.bd.conexion_base;
import com.angel.dao.Iadministradordao;
import com.angel.modelo.administrador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author devil
 */
public class impadministrador implements Iadministradordao{
    Connection conex=null;
    PreparedStatement sta=null;
    ResultSet resul=null;
    private final String registra="call sp_registra_admi(?,?,?,?)";
    private final String trae1="call sp_trae_admi1(?,?)";
    private final String trae2="call sp_trae_admi2(?)";
    @Override
    public int altaadministrador(administrador a) {
        conexion_base conecta=new conexion_base();
        conex=conecta.getConex();
        int valida=0;
        try{
            sta=conex.prepareCall(registra);
            sta.setString(1, a.getCorreo());
            sta.setString(2, a.getContra());
            sta.setString(3, a.getNombre());
            sta.setInt(4, a.getModulo());
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
    public administrador traeadministrador1(String correo, String contra) {
        conexion_base conecta=new conexion_base();
        conex=conecta.getConex();
        administrador admi=null;
        System.out.println(correo);
            System.out.println(contra);
        try{
            sta=conex.prepareCall(trae1);
            sta.setString(1, correo);
            sta.setString(2, contra);
            resul=sta.executeQuery();
            if(resul.next()){
                admi=new administrador(resul.getString(1), resul.getString(2), resul.getString(3), resul.getInt(4));
            }
            conex.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return admi;
    }

    @Override
    public administrador traeadministrador2(String correo) {
        conexion_base conecta=new conexion_base();
        conex=conecta.getConex();
        administrador admi=null;
        try{
            sta=conex.prepareCall(trae2);
            sta.setString(1, correo);
            resul=sta.executeQuery();
            if(resul.next()){
                admi=new administrador(resul.getString(1), resul.getString(2), resul.getString(3), resul.getInt(4));
            }
            conex.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return admi;
    }

    @Override
    public int actualizaadministrador(administrador a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int borraadministrador(String correo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
