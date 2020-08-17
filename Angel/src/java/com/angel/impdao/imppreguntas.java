/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.angel.impdao;

import com.angel.bd.conexion_base;
import com.angel.dao.Ipreguntasdao;
import com.angel.modelo.notificacion;
import com.angel.modelo.preguntas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Profesor
 */
public class imppreguntas implements Ipreguntasdao{
    Connection conex=null;
    private final String registrap="call sp_registra_pregunta(?,?)",trae_uno="call sp_trae_pregunta(?)",trae_varios="call sp_trae_preguntas()",eliminap="call sp_elimina_pregunta(?)";
    PreparedStatement sta=null;
    ResultSet resul=null;
    @Override
    public int altapreguntas(String texto, String correo) {
        int confirma=0;
        try{
            conexion_base conecta=new conexion_base();
            conex=conecta.getConex();
            sta=conex.prepareCall(registrap);
            sta.setString(1, texto);
            sta.setString(2, correo);
            resul=sta.executeQuery();
            if(resul.next()){
                confirma=resul.getInt(1);
            }
            conex.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return confirma;
    }

    @Override
    public preguntas traepreguntas(int id_pregunta) {
        preguntas pregun=null;
        try{
            conexion_base conecta=new conexion_base();
            conex=conecta.getConex();
            sta=conex.prepareCall(trae_uno);
            sta.setInt(1, id_pregunta);
            resul=sta.executeQuery();
            if(resul.next()){
                pregun=new preguntas(resul.getInt(1), resul.getInt(3), resul.getString(2));
            }
            conex.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return pregun;
    }

    @Override
    public int actualizapreguntas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int borrapreguntas(int id_pregunta) {
        int confirma=0;
        try{
            conexion_base conecta=new conexion_base();
            conex=conecta.getConex();
            sta=conex.prepareCall(eliminap);
            sta.setInt(1, id_pregunta);
            resul=sta.executeQuery();
            if(resul.next()){
                confirma=resul.getInt(1);
            }
            conex.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return confirma;
    }

    @Override
    public ArrayList<preguntas> traepreguntass() {
        ArrayList<preguntas> lista_preguntass=new ArrayList<>();
        try{
            conexion_base conecta=new conexion_base();
            conex=conecta.getConex();
            sta=conex.prepareCall(trae_varios);
            resul=sta.executeQuery();
            while(resul.next()){
                lista_preguntass.add(new preguntas(resul.getInt(1), resul.getInt(3), resul.getString(2)));
            }
            conex.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return lista_preguntass;
    }   
}