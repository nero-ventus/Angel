/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.angel.impdao;

import com.angel.bd.conexion_base;
import com.angel.dao.Igerentedao;
import com.angel.modelo.ingeniero;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author devil
 */
public class impgerente implements Igerentedao {

    Connection conex = null;
    PreparedStatement sta = null;
    ResultSet resul = null;
    private final String registra = "call sp_registra_gerente(?,?,?,?);";
    private final String trae = "call sp_trae_gerente(?,?);";
    private final String registra_solucion = "call sp_cierra_reporte_mantenimiento(?,?);";

    @Override
    public int altagerente(ingeniero a) {
        int valida = 0;
        try {
            conexion_base conecta = new conexion_base();
            conex = conecta.getConex();
            sta = conex.prepareCall(registra);
            sta.setString(1, a.getCorreo());
            sta.setString(2, a.getContra());
            sta.setString(3, a.getNombre());
            sta.setString(4, a.getApellidos());
            resul = sta.executeQuery();
            if (resul.next()) {
                valida = resul.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            valida = 0;
        }
        return valida;
    }

    @Override
    public ingeniero traegerente(ingeniero a) {
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
    public int actualizagerente(String correo_gerente, ingeniero a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int borragerente(String correo_gerente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int subir_solucion(String solucion, int id_reporte_e) {
        int valida = 0;
        try {
            conexion_base conecta = new conexion_base();
            conex = conecta.getConex();
            sta = conex.prepareCall(registra_solucion);
            sta.setInt(1, id_reporte_e);
            sta.setString(2, solucion);
            resul = sta.executeQuery();
            if (resul.next()) {
                valida = resul.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            valida = 0;
        }
        return valida;
    }

}
