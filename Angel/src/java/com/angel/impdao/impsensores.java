/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.angel.impdao;

import com.angel.bd.conexion_base;
import com.angel.dao.Isensoresdao;
import com.angel.modelo.sensores;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author devil
 */
public class impsensores implements Isensoresdao{
    Connection conex=null;
    PreparedStatement sta=null;
    ResultSet resul=null;
    private final String traesensores="call sp_getsensores(?)";
    private final String actualiza="call sp_actualiza_sensor(?,?,?,?);";
    @Override
    public int altasensor(sensores a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public sensores traesensor(int id_sensor, String correo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int actualizasensores(sensores a,String correo) {
        int valida=0;
        try{
            conexion_base conecta=new conexion_base();
            conex=conecta.getConex();
            sta=conex.prepareCall(actualiza);
            sta.setString(1, correo);
            sta.setString(2, a.getId_sensor());
            sta.setInt(3, a.getId_cuarto());
            sta.setInt(4, a.getEstado_permiso());
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
    public int borrasensores(int id_sensor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<sensores> traeSensores(String correo) {
        ArrayList<sensores> lista_sensores=new ArrayList<>();
        try{
            conexion_base conecta=new conexion_base();
            conex=conecta.getConex();
            sta=conex.prepareCall(traesensores);
            sta.setString(1, correo);
            resul=sta.executeQuery();
            while(resul.next()){
                lista_sensores.add(new sensores(resul.getString(1), resul.getString(2), resul.getInt(3), resul.getInt(4)));
            }
            conex.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return lista_sensores;
    }
    
}