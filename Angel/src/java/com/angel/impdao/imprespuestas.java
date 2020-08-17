/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.angel.impdao;

import com.angel.bd.conexion_base;
import com.angel.dao.Irespuestasdao;
import com.angel.modelo.respuestas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Profesor
 */
public class imprespuestas implements Irespuestasdao{
    Connection conex=null;
    PreparedStatement sta=null;
    ResultSet resul=null;
    private final String regitra="call sp_registra_respuesta(?,?)",trae_varias="call sp_trae_respuestas()";
    @Override
    public int altarespuestas(String texto, int id_pregunta) {
        int valida=0;
        try{
            conexion_base conecta=new conexion_base();
            conex=conecta.getConex();
            sta=conex.prepareCall(regitra);
            sta.setString(1, texto);
            sta.setInt(2, id_pregunta);
            resul=sta.executeQuery();
            if(resul.next()){
                valida=resul.getInt(1);
                conex.close();
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            valida=0;
        }
        return valida;
    }

    @Override
    public respuestas traerespuesta() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int actualizarespuestas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int borrarespuestas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<respuestas> traerespuestas() {
        ArrayList<respuestas> lista_respuestass=new ArrayList<>();
        try{
            conexion_base conecta=new conexion_base();
            conex=conecta.getConex();
            sta=conex.prepareCall(trae_varias);
            resul=sta.executeQuery();
            while(resul.next()){
                lista_respuestass.add(new respuestas(resul.getInt(1), resul.getString(2), resul.getInt(3)));
            }
            conex.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
            return lista_respuestass;
    }
    
}
