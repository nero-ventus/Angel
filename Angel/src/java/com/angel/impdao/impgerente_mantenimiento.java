/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.angel.impdao;

import com.angel.bd.conexion_base;
import com.angel.dao.Igerente_mantenimientodao;
import com.angel.modelo.gerente_mantenimiento;
import com.angel.modelo.programador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class impgerente_mantenimiento implements Igerente_mantenimientodao {

    Connection conex = null;
    PreparedStatement sta = null;
    ResultSet resul = null;
    final String registra = "call sp_registra_gerente_mantenimiento(?,?,?,?);";
    final String trae = "call sp_trae_gerente_mantenimiento(?,?);";
    private final String registra_solucion = "call sp_cierra_reporte_mantenimiento(?,?);";
    private final String trae_programadores = "call sp_trae_programadores();";

    @Override
    public int altagerente_mantenimiento(gerente_mantenimiento a) {
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
    public gerente_mantenimiento traegerente_mantenimiento(gerente_mantenimiento a) {
        gerente_mantenimiento geren = null;
        try {
            conexion_base conecta = new conexion_base();
            conex = conecta.getConex();
            sta = conex.prepareCall(trae);
            sta.setString(1, a.getCorreo());
            sta.setString(2, a.getContra());
            resul = sta.executeQuery();
            if (resul.next()) {
                System.out.println("a");
                geren = new gerente_mantenimiento(resul.getString(1), resul.getString(2), resul.getString(3), resul.getString(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
            geren = null;
        }
        return geren;
    }

    @Override
    public int actualizagerente_mantenimiento(String correo_gerente_mantenimiento, gerente_mantenimiento a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int borragerente_mantenimiento(String correo_gerente_mantenimiento) {
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

    @Override
    public ArrayList<programador> trae_programadores() {
        ArrayList<programador> lista_programador = new ArrayList<programador>();
        try {
            conexion_base conecta = new conexion_base();
            conex = conecta.getConex();
            sta = conex.prepareCall(trae_programadores);
            resul = sta.executeQuery();
            while (resul.next()) {
                lista_programador.add(new programador(resul.getString(1), resul.getString(2), resul.getString(3), resul.getString(4)));
            }
            conex.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista_programador;
    }

}
