/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.angel.impdao;

/**
 *
 * @author Jesus Abraham
 */
import com.angel.bd.conexion_base;
import com.angel.dao.Iprogramadordao;
import com.angel.modelo.programador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class impprogramador implements Iprogramadordao {

    Connection conex = null;
    PreparedStatement sta = null;
    ResultSet resul = null;
    final String registra = "call sp_registra_programador(?,?,?,?);";
    final String trae = "call sp_trae_programador(?,?);";
    private final String registra_solucion = "call sp_cierra_reporte_mantenimiento(?,?);";
 
    @Override
    public int altaprogramador(programador a) {
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
    public programador traeprogramador(programador a) {
        programador program = null;
        try {
            conexion_base conecta = new conexion_base();
            conex = conecta.getConex();
            sta = conex.prepareCall(trae);
            sta.setString(1, a.getCorreo());
            sta.setString(2, a.getContra());
            resul = sta.executeQuery();
            if (resul.next()) {
                System.out.println("a");
                program = new programador(resul.getString(1), resul.getString(2), resul.getString(3), resul.getString(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
            program = null;
        }
        return program;
    }

    @Override
    public int actualizaprogramador(String correo_programador, programador a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int borraprogramador(String correo_programador) {
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
    } //To change body of generated methods, choose Tools | Templates.
}