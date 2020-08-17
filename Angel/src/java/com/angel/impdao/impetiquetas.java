/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.angel.impdao;

import com.angel.bd.conexion_base;
import com.angel.dao.Ietiquetasdao;
import com.angel.modelo.etiquetas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author devil
 */
public class impetiquetas implements Ietiquetasdao{
    Connection conex=null;
    PreparedStatement sta=null;
    ResultSet resul=null;
    private final String registra="call sp_asigna_reporte_evento_etiqueta(?,?);";
    private final String relaciona="call sp_relaciona_reporte_evento_etiqueta(?,?);";
    private final String trae_uno="call sp_get_relacion_reporte_evento_etiqueta(?);";
    private final String trae_varios="call sp_trae_etiquetas_todas();";
    @Override
    public int altaetiquetas(String nombre_etiqueta, int trae_etiquetas_todas) {
        int valida=0;
        try{
            conexion_base conecta=new conexion_base();
            conex=conecta.getConex();
            sta=conex.prepareCall(registra);
            sta.setString(1, nombre_etiqueta);
            sta.setInt(2, trae_etiquetas_todas);
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
    public etiquetas traeetiqueta(int id_reporte_evento) {
        etiquetas contenedor=null;
        try{
            conexion_base conecta=new conexion_base();
            conex=conecta.getConex();
            sta=conex.prepareCall(trae_uno);
            sta.setInt(1, id_reporte_evento);
            resul=sta.executeQuery();
            if(resul.next()){
                contenedor=new etiquetas(resul.getInt(1), resul.getString(2));
            }
        }
        catch(Exception e){
            e.printStackTrace();
            contenedor=null;
        }
        return contenedor;
    }

    @Override
    public int relaciona_reporte_evento_etiqueta(int id_etiqueta, int id_reporte) {
        int valida=0;
        try{
            conexion_base conecta=new conexion_base();
            conex=conecta.getConex();
            sta=conex.prepareCall(relaciona);
            sta.setInt(1, id_etiqueta);
            sta.setInt(2, id_reporte);
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
    public ArrayList<etiquetas> traeetiquetas() {
        ArrayList<etiquetas> lista=new ArrayList<etiquetas>();
        try{
            conexion_base conecta=new conexion_base();
            conex=conecta.getConex();
            sta=conex.prepareCall(trae_varios);
            resul=sta.executeQuery();
            while(resul.next()){
                lista.add(new etiquetas(resul.getInt(1), resul.getString(2)));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return lista;
    }
    
    @Override
    public int traecantidad(int id_eti) {
        int cantidad=0;
        try{
            conexion_base conecta=new conexion_base();
            conex=conecta.getConex();
            sta=conex.prepareCall("call sp_trae_cantidad_etiqueta(?);");
            sta.setInt(1, id_eti);
            resul=sta.executeQuery();
            if(resul.next()){
                cantidad=resul.getInt(1);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return cantidad;
    }
    
}
