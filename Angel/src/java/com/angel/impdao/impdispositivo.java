/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.angel.impdao;

import com.angel.bd.conexion_base;
import com.angel.dao.Idispositivodao;
import com.angel.modelo.dispositivo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author devil
 */
public class impdispositivo implements Idispositivodao{
    private final String llamar="call sp_getdispositivos(?)";
    private final String llamar1="call sp_getdispositivo(?)";
    Connection conex=null;
    PreparedStatement sta=null;
    ResultSet resul=null;
    @Override
    public int altadispositivo(dispositivo a, String correo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public dispositivo traedispositivo(int id_infante) {
        dispositivo dispo=null;
        try{
            conexion_base conecta=new conexion_base();
            conex=conecta.getConex();
            sta=conex.prepareCall(llamar1);
            sta.setInt(1, id_infante);
            resul=sta.executeQuery();
            if(resul.next()){
                dispo=new dispositivo(resul.getString(1), resul.getString(2), resul.getString(3));
            }
            conex.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return dispo;
    }

    @Override
    public int actualizadispositivo(dispositivo a, String correo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void borradispositivo(int id_dispositivo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<dispositivo> tredispositivosLibres(String correo) {
        ArrayList<dispositivo> libres=new ArrayList<>();
        try{
            conexion_base conecta=new conexion_base();
            conex=conecta.getConex();
            sta=conex.prepareCall(llamar);
            sta.setString(1, correo);
            resul=sta.executeQuery();
            while(resul.next()){
                libres.add(new dispositivo(resul.getString(1), resul.getString(2), resul.getString(3)));
            }
            conex.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return libres;
    }
}