/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.angel.impdao;

import com.angel.bd.conexion_base;
import com.angel.dao.Ireporte_mantenimientodao;
import com.angel.modelo.reporte_mantenimiento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Jesus Abraham
 */
public class impreporte_mantenimiento implements Ireporte_mantenimientodao {

    Connection conex = null;
    PreparedStatement sta = null;
    ResultSet resul = null;
    private final String registra = "call sp_registra_reporte_mantenimiento(?,?,?,?);";
    private final String registra_sin_asignar = "call sp_registra_reporte_mantenimiento_sin_asignar(?,?,?);";
    private final String trae_reportes_mantenimiento_abiertos_sin_asignar = "call sp_trae_reportes_mantenimiento_abiertos_sin_asignar();";
    private final String trae_reportes_mantenimiento_abiertos_asignados = "call sp_trae_reportes_mantenimiento_abiertos_asignados();";
    private final String trae_reportes_mantenimiento_cerrados = "call sp_trae_reportes_mantenimiento_cerrados_solucionados();";
    private final String registra_solucion = "call sp_cierra_reporte_mantenimiento(?,?);";
    private final String registra_solucion_especial = "call sp_soluciona_especial(?,?);";
    private final String asignacion_programmer = "call sp_asigna_programador(?,?);";

    @Override
    public int altareporte_mantenimiento(reporte_mantenimiento a) {
        int valida = 0;
        try {
            conexion_base conecta = new conexion_base();
            conex = conecta.getConex();
            sta = conex.prepareCall(registra);
            sta.setDate(1, a.getFecha());
            sta.setString(2, a.getDescripcion());
            sta.setString(3, a.getTipo());
            sta.setString(4, a.getCorreo_gere());
            resul = sta.executeQuery();
            if (resul.next()) {
                valida = resul.getByte(1);
            }
            conex.close();
        } catch (Exception e) {
            e.printStackTrace();
            valida = 0;
        }
        return valida;

    }

    @Override
    public ArrayList<reporte_mantenimiento> trae_reportes_mantenimiento_abiertos_sin_asignar() {
        ArrayList<reporte_mantenimiento> lista = new ArrayList<reporte_mantenimiento>();
        try {
            conexion_base conecta = new conexion_base();
            conex = conecta.getConex();
            sta = conex.prepareCall(trae_reportes_mantenimiento_abiertos_sin_asignar);
            resul = sta.executeQuery();
            while (resul.next()) {
                lista.add(new reporte_mantenimiento(resul.getInt(1), resul.getDate(2), resul.getInt(3), resul.getString(4), resul.getString(5), resul.getString(6), resul.getString(7)));
            }
            conex.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public ArrayList<reporte_mantenimiento> trae_reportes_mantenimiento_abiertos_asignados() {
        ArrayList<reporte_mantenimiento> lista = new ArrayList<reporte_mantenimiento>();
        try {
            conexion_base conecta = new conexion_base();
            conex = conecta.getConex();
            sta = conex.prepareCall(trae_reportes_mantenimiento_abiertos_asignados);
            resul = sta.executeQuery();
            while (resul.next()) {
                lista.add(new reporte_mantenimiento(resul.getInt(1), resul.getDate(2), resul.getInt(3), resul.getString(4), resul.getString(5), resul.getString(6), resul.getString(7)));
            }
            conex.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public ArrayList<reporte_mantenimiento> trae_reportes_mantenimiento_cerrados_resueltos() {
        ArrayList<reporte_mantenimiento> lista = new ArrayList<reporte_mantenimiento>();
        try {
            conexion_base conecta = new conexion_base();
            conex = conecta.getConex();
            sta = conex.prepareCall(trae_reportes_mantenimiento_cerrados);
            resul = sta.executeQuery();
            while (resul.next()) {
                lista.add(new reporte_mantenimiento(resul.getInt(1), resul.getDate(2), resul.getInt(3), resul.getString(4), resul.getString(5), resul.getString(6), resul.getString(7)));
            }
            conex.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

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

    @Override
    public int asigna_programador(int id_reporte, String correo) {
        int valida = 0;
        try {
            conexion_base conecta = new conexion_base();
            conex = conecta.getConex();
            sta = conex.prepareCall(asignacion_programmer);
            sta.setInt(1, id_reporte);
            sta.setString(2, correo);
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
    public int registra_reporte_mantenimiento_sin_asignar(reporte_mantenimiento a) {
        int valida = 0;
        try {
            conexion_base conecta = new conexion_base();
            conex = conecta.getConex();
            sta = conex.prepareCall(registra_sin_asignar);
            sta.setDate(1, a.getFecha());
            sta.setString(2, a.getDescripcion());
            sta.setString(3, a.getTipo());
            resul = sta.executeQuery();
            if (resul.next()) {
                valida = resul.getByte(1);
            }
            conex.close();
        } catch (Exception e) {
            e.printStackTrace();
            valida = 0;
        }
        return valida;
    }
    
    @Override
    public int registra_reporte_evento_to_mantenimiento_sin_asignar(reporte_mantenimiento a,int id_repor_evento) {
        int valida = 0;
        try {
            conexion_base conecta = new conexion_base();
            conex = conecta.getConex();
            sta = conex.prepareCall("call sp_registra_reporte_evento_to_mantenimiento(?,?,?,?)");
            sta.setDate(1, a.getFecha());
            sta.setString(2, a.getDescripcion());
            sta.setString(3, a.getTipo());
            sta.setInt(4, id_repor_evento);
            resul = sta.executeQuery();
            if(resul.next()){
                valida = resul.getInt(1);
            }
            conex.close();
        } catch (Exception e) {
            e.printStackTrace();
            valida = 0;
        }
        return valida;
    }

    @Override
    public int actualizareporte_mantenimiento_especial(int id_reporte, String solucion) {
        int valida = 0;
        try {
            conexion_base conecta = new conexion_base();
            conex = conecta.getConex();
            sta = conex.prepareCall(registra_solucion_especial);
            sta.setInt(1, id_reporte);
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
