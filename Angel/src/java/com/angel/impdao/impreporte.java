/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.angel.impdao;

import com.angel.bd.conexion_base;
import com.angel.dao.Ireportedao;
import com.angel.modelo.infante;
import com.angel.modelo.reporte;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Profesor
 */
public class impreporte implements Ireportedao{
    Connection conex=null;
    PreparedStatement sta=null;
    ResultSet resul=null;
    private final String trae_varios="call sp_trae_reportes(?);";
    private final String trae_uno="call sp_trae_reporte(?)";
    private final String registra="call sp_registra_reporte(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    @Override
    public int altareporte(reporte a, int id_infante) {
        int valida=0;
        try{
            conexion_base conecta=new conexion_base();
            conex=conecta.getConex();
            sta=conex.prepareCall(registra);
            sta.setDate(1, a.getFecha());
            sta.setInt(2, id_infante);
            sta.setInt(3, a.getTalla());
            sta.setInt(4, a.getPeso());
            sta.setDouble(5, a.getTemperatura());
            sta.setInt(6, a.getFrecuencia_cardiaca());
            sta.setInt(7, a.getId_colo_piel());
            sta.setInt(8, a.getId_cansa());
            sta.setInt(9, a.getId_dolor_g());
            sta.setInt(10, a.getId_flema());
            sta.setInt(11, a.getId_escuri_n());
            sta.setInt(12, a.getId_dolor_ab());
            sta.setInt(13, a.getId_nauseas());
            sta.setInt(14, a.getId_vomito());
            sta.setInt(15, a.getId_dolor_ca());
            sta.setInt(16, a.getId_diarrea());
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
    public reporte traereporte(int id_reporte) {
        reporte repor=null;
        try{
            conexion_base conecta=new conexion_base();
            conex=conecta.getConex();
            sta=conex.prepareCall(trae_uno);
            sta.setInt(1, id_reporte);
            resul=sta.executeQuery();
            if(resul.next()){
                repor=new reporte(resul.getInt(1), resul.getDate(2), resul.getInt(3), resul.getInt(4), resul.getInt(5), resul.getDouble(6), resul.getInt(7), resul.getInt(8), resul.getInt(9), resul.getInt(10), resul.getInt(11), resul.getInt(12), resul.getInt(13), resul.getInt(14), resul.getInt(15), resul.getInt(16), resul.getInt(17));
                conex.close();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return repor;
    }

    @Override
    public int actualizareporte(reporte a, infante b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int borrareporte(int id_reporte) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<reporte> trereportes(int id) {
        ArrayList<reporte> lista_reportes=new ArrayList<>();
        try{
            conexion_base conecta=new conexion_base();
            conex=conecta.getConex();
            sta=conex.prepareCall(trae_varios);
            sta.setInt(1, id);
            resul=sta.executeQuery();
            while(resul.next()){
                lista_reportes.add(new reporte(resul.getInt(1), resul.getDate(2), resul.getInt(3), resul.getInt(4), resul.getInt(5), resul.getInt(6), resul.getInt(7), resul.getInt(8), resul.getInt(9), resul.getInt(10), resul.getInt(11), resul.getInt(12), resul.getInt(13), resul.getInt(14), resul.getInt(15), resul.getInt(16), resul.getInt(17)));
            }
            conex.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return lista_reportes;
    }
    
}