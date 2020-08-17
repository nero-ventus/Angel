/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.angel.impdao;

import com.angel.bd.conexion_base;
import com.angel.dao.Iafeccionesdao;
import com.angel.modelo.afecciones;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Alumno
 */
public class impafecciones implements Iafeccionesdao{
    private final String llamar="call sp_getafecciones(?)";
    Connection conex=null;
    PreparedStatement sta=null;
    ResultSet resul=null;
    @Override
    public int altaafecciones(afecciones a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int actualizaafecciones(afecciones a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void borraafecciones(int id_afecciones) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<afecciones> traeafeccionesInfante(int id_infante) {
        ArrayList<afecciones> lista=new ArrayList<>();
        try{
            conexion_base conecta=new conexion_base();
            conex=conecta.getConex();
            sta=conex.prepareCall(llamar);
            sta.setInt(1, id_infante);
            resul=sta.executeQuery();
            while(resul.next()){
                lista.add(new afecciones(resul.getInt(1), resul.getString(2)));
            }
            conex.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return lista;
    }
    
}