/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.angel.impdao;

import com.angel.bd.conexion_base;
import com.angel.dao.Iingenierodao;
import com.angel.modelo.etiquetas;
import com.angel.modelo.ingeniero;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author devil
 */
public class impingeniero implements Iingenierodao{
    Connection conex=null;
    PreparedStatement sta=null;
    ResultSet resul=null;
    private final String registra_solucion="call sp_soluciona_reporte_evento(?,?);";
    private final String registra="call sp_registra_ingeniero(?,?,?,?);";
    private final String trae="call sp_trae_ingeniero(?,?);";
    private final String trae_varios="call sp_trae_ingenieros();";
    private final String asigna="call sp_asigna_reporte_evento(?,?);";
    @Override
    public int altaingeniero(ingeniero a) {
        int valida=0;
        try{
            conexion_base conecta=new conexion_base();
            conex=conecta.getConex();
            sta=conex.prepareCall(registra);
            sta.setString(1, a.getCorreo());
            sta.setString(2, a.getContra());
            sta.setString(3, a.getNombre());
            sta.setString(4, a.getApellidos());
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
    public ingeniero traeingeniero(ingeniero a) {
        ingeniero inge=null;
        try{
            conexion_base conecta=new conexion_base();
            conex=conecta.getConex();
            sta=conex.prepareCall(trae);
            sta.setString(1, a.getCorreo());
            sta.setString(2, a.getContra());
            resul=sta.executeQuery();
            if(resul.next()){
                inge=new ingeniero(resul.getString(1), resul.getString(2), resul.getString(3), resul.getString(4));
            }
        }
        catch(Exception e){
            e.printStackTrace();
            inge=null;
        }
        return inge;
    }
    
    @Override
    public ingeniero traeingeniero_sin_contra(String correo) {
        ingeniero inge=null;
        try{
            conexion_base conecta=new conexion_base();
            conex=conecta.getConex();
            sta=conex.prepareCall("call sp_trae_ingeniero_sin_contra(?);");
            sta.setString(1, correo);
            resul=sta.executeQuery();
            if(resul.next()){
                inge=new ingeniero(resul.getString(1), resul.getString(2), resul.getString(3), resul.getString(4));
            }
        }
        catch(Exception e){
            e.printStackTrace();
            inge=null;
        }
        return inge;
    }

    @Override
    public int actualizaingeniero(String correo_ingeniero, ingeniero a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int borraingeniero(String correo_ingeniero) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<ingeniero> trae_ingenieros() {
        ArrayList<ingeniero> lista=new ArrayList<ingeniero>();
        try{
            conexion_base conecta=new conexion_base();
            conex=conecta.getConex();
            sta=conex.prepareCall(trae_varios);
            resul=sta.executeQuery();
            while(resul.next()){
                lista.add(new ingeniero(resul.getString(1), resul.getString(2), resul.getString(3), resul.getString(4)));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return lista;
    }
    
    @Override
    public int asigna_reporte_ingeniero(int id_reporte,String correo_inge){
        int valida=0;
        try{
            conexion_base conecta=new conexion_base();
            conex=conecta.getConex();
            sta=conex.prepareCall(asigna);
            sta.setInt(1, id_reporte);
            sta.setString(2, correo_inge);
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
    public int subir_solucion(String solucion,int id_reporte_e){
        int valida=0;
        try{
            conexion_base conecta=new conexion_base();
            conex=conecta.getConex();
            sta=conex.prepareCall(registra_solucion);
            sta.setInt(1, id_reporte_e);
            sta.setString(2, solucion);
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
}