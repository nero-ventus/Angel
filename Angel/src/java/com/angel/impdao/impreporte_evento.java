/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.angel.impdao;

import com.angel.bd.conexion_base;
import com.angel.dao.Ireporte_eventodao;
import com.angel.modelo.reporte_evento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author devil
 */
public class impreporte_evento implements Ireporte_eventodao{
    Connection conex=null;
    PreparedStatement sta=null;
    ResultSet resul=null;
    private final String verifica_cerrado_evento_mantenimiento="call sp_valida_cerrado_reporte_mantenimiento_de_evento(?)";
    private final String cerrar_reporte="call sp_cerrar_reporte_evento(?);";
    private final String trae_reportes_evento_abiertos_respondidos_ingeniero="call sp_trae_reportes_evento_respondidos_ingeniero(?);";
    private final String trae_reportes_evento_abiertos_sin_asignar="call sp_trae_reportes_evento_abiertos_sin_asignar();";
    private final String trae_reportes_evento_abiertos_asignados="call sp_trae_reportes_evento_abiertos_asignados();";
    private final String trae_reportes_evento_cerrados="call sp_trae_reportes_evento_cerrados_solucionados();";
    private final String trae_reportes_evento_abiertos_sin_responder_ingeniero="call sp_trae_reportes_evento_sin_responder_ingeniero(?);";
    private final String registra="call sp_registra_reporte_evento(?,?,?);";
    private final String registra_ingeniero="call sp_registra_reporte_evento_ingeniero(?,?,?,?);";
    
    @Override
    public int valida_cerrado_evento_mantenimiento(int id_reporte_evento) {
        int valida=0;
        try{
            conexion_base conecta=new conexion_base();
            conex=conecta.getConex();
            sta=conex.prepareCall(verifica_cerrado_evento_mantenimiento);
            sta.setInt(1, id_reporte_evento);
            resul=sta.executeQuery();
            if(resul.next()){
                valida=resul.getInt(1);
            }
            conex.close();
        }
        catch(Exception e){
            e.printStackTrace();
            valida=0;
        }
        return valida;
    }
    
    @Override
    public int altareporte_evento(reporte_evento a) {
        int valida=0;
        try{
            conexion_base conecta=new conexion_base();
            conex=conecta.getConex();
            sta=conex.prepareCall(registra);
            sta.setDate(1, a.getFecha());
            sta.setString(2, a.getDescripcion());
            sta.setString(3, a.getCorreo_usua());
            resul=sta.executeQuery();
            if(resul.next()){
                valida=resul.getByte(1);
            }
            conex.close();
        }
        catch(Exception e){
            e.printStackTrace();
            valida=0;
        }
        return valida;
    }
    
    @Override
    public int altareporte_evento_ingeniero(reporte_evento a) {
        int valida=0;
        try{
            conexion_base conecta=new conexion_base();
            conex=conecta.getConex();
            sta=conex.prepareCall(registra_ingeniero);
            sta.setDate(1, a.getFecha());
            sta.setString(2, a.getDescripcion());
            sta.setString(3, a.getCorreo_usua());
            sta.setString(4, a.getCorreo_inge());
            resul=sta.executeQuery();
            if(resul.next()){
                valida=resul.getByte(1);
            }
            conex.close();
        }
        catch(Exception e){
            e.printStackTrace();
            valida=0;
        }
        return valida;
    }
    
    @Override
    public int cerrar_de_mantenimiento(int id_reporte_evento) {
        int valida=0;
        try{
            conexion_base conecta=new conexion_base();
            conex=conecta.getConex();
            sta=conex.prepareCall("call sp_cerrar_reporte_mantenimiento_de_evento(?)");
            sta.setInt(1, id_reporte_evento);
            resul=sta.executeQuery();
            if(resul.next()){
                valida=resul.getInt(1);
            }
            conex.close();
        }
        catch(Exception e){
            e.printStackTrace();
            valida=0;
        }
        return valida;
    }

    @Override
    public reporte_evento trae_reporte_evento_abierto(reporte_evento a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public reporte_evento trae_reporte_evento_cerrado(reporte_evento a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int actualizareporte_evento_asigna(int id_reporte, String correo_asignado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public int verifica_si_hay_de_mantenimiento(int id_reporte_evento) {
        int valida=0;
        try{
            conexion_base conecta=new conexion_base();
            conex=conecta.getConex();
            sta=conex.prepareCall("call sp_verifica_reporte_evento_existe_mantenimiento(?)");
            sta.setInt(1, id_reporte_evento);
            resul=sta.executeQuery();
            if(resul.next()){
                valida=resul.getInt(1);
            }
            conex.close();
        }
        catch(Exception e){
            e.printStackTrace();
            valida=0;
        }
        return valida;
    }

    @Override
    public int actualizareporte_evento_cerrar(int id_reporte) {
        int valida=0;
        try{
            conexion_base conecta=new conexion_base();
            conex=conecta.getConex();
            sta=conex.prepareCall(cerrar_reporte);
            sta.setInt(1, id_reporte);
            resul=sta.executeQuery();
            if(resul.next()){
                valida=resul.getInt(1);
            }
            conex.close();
        }
        catch(Exception e){
            e.printStackTrace();
            valida=0;
        }
        return  valida;
    }

    @Override
    public int borrareporte_evento(int id_reporte) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<reporte_evento> trae_reportes_evento_abiertos_sin_asignar() {
        ArrayList<reporte_evento> lista=new ArrayList<reporte_evento>();
        try{
            conexion_base conecta=new conexion_base();
            conex=conecta.getConex();
            sta=conex.prepareCall(trae_reportes_evento_abiertos_sin_asignar);
            resul=sta.executeQuery();
            while(resul.next()){
                lista.add(new reporte_evento(resul.getInt(1), resul.getDate(2), resul.getInt(3), resul.getString(4), resul.getString(5), resul.getString(6), resul.getString(7)));
            }
            conex.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public ArrayList<reporte_evento> trae_reportes_evento_abiertos_asignados() {
        ArrayList<reporte_evento> lista=new ArrayList<reporte_evento>();
        try{
            conexion_base conecta=new conexion_base();
            conex=conecta.getConex();
            sta=conex.prepareCall(trae_reportes_evento_abiertos_asignados);
            resul=sta.executeQuery();
            while(resul.next()){
                lista.add(new reporte_evento(resul.getInt(1), resul.getDate(2), resul.getInt(3), resul.getString(4), resul.getString(5), resul.getString(6), resul.getString(7)));
            }
            conex.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return lista;
    }
    
    @Override
    public ArrayList<reporte_evento> trae_reportes_evento_cerrados_resueltos() {
        ArrayList<reporte_evento> lista=new ArrayList<reporte_evento>();
        try{
            conexion_base conecta=new conexion_base();
            conex=conecta.getConex();
            sta=conex.prepareCall(trae_reportes_evento_cerrados);
            resul=sta.executeQuery();
            while(resul.next()){
                lista.add(new reporte_evento(resul.getInt(1), resul.getDate(2), resul.getInt(3), resul.getString(4), resul.getString(5), resul.getString(6), resul.getString(7)));
            }
            conex.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public ArrayList<reporte_evento> trae_reportes_evento_sin_responder_ingeniero(String correo_inge) {
        ArrayList<reporte_evento> lista=new ArrayList<reporte_evento>();
        try{
            conexion_base conecta=new conexion_base();
            conex=conecta.getConex();
            sta=conex.prepareCall(trae_reportes_evento_abiertos_sin_responder_ingeniero);
            sta.setString(1, correo_inge);
            resul=sta.executeQuery();
            while(resul.next()){
                lista.add(new reporte_evento(resul.getInt(1), resul.getDate(2), resul.getInt(3), resul.getString(4), resul.getString(5), resul.getString(6), resul.getString(7)));
            }
            conex.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return lista;
    }
    
    @Override
    public ArrayList<reporte_evento> trae_reportes_evento_respondidos_ingeniero(String correo_inge) {
        ArrayList<reporte_evento> lista=new ArrayList<reporte_evento>();
        try{
            conexion_base conecta=new conexion_base();
            conex=conecta.getConex();
            sta=conex.prepareCall(trae_reportes_evento_abiertos_respondidos_ingeniero);
            sta.setString(1, correo_inge);
            resul=sta.executeQuery();
            while(resul.next()){
                lista.add(new reporte_evento(resul.getInt(1), resul.getDate(2), resul.getInt(3), resul.getString(4), resul.getString(5), resul.getString(6), resul.getString(7)));
            }
            conex.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return lista;
    }
    
    @Override
    public reporte_evento trae_reporte_evento(int id) {
        reporte_evento repor=null;
        try{
            conexion_base conecta=new conexion_base();
            conex=conecta.getConex();
            sta=conex.prepareCall("select angel.reporte_evento.* from angel.reporte_evento where binary angel.reporte_evento.id_repor_evento=?;");
            sta.setInt(1, id);
            resul=sta.executeQuery();
            if(resul.next()){
                repor=new reporte_evento(resul.getInt(1), resul.getDate(2), resul.getInt(3), resul.getString(4), resul.getString(5), resul.getString(6), resul.getString(7));
            }
            conex.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return repor;
    }
}