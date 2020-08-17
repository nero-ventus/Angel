/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.angel.impdao;

import com.angel.bd.conexion_base;
import com.angel.dao.Iinfantedao;
import com.angel.modelo.infante;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author devil
 */
public class impinfante implements Iinfantedao{
    Connection conex=null;
    PreparedStatement sta=null;
    ResultSet resul=null;
    private final String registra1="call sp_infante(0,?,?,?,?,?,?,?,?,?,0)";
    private final String registra2="call sp_infante_s(?,?)";
    private final String llamar="call sp_getinfantes(?)";
    private final String actualiza1="call sp_infante(1,?,?,?,?,?,?,?,?,?,?)";
    private final String elimina_lazos="call sp_deleterela_afec_infan(?)";
    private final String elimina_infante="call sp_deleteinfan(?)";
    private final String traeuno="call sp_getinfante(?,?)";
    @Override
    public int altainfante(infante a, String correo, String id_dispositivo, ArrayList afecciones) {
        int valida=0;
        int id=0;
        try{
            conexion_base conecta=new conexion_base();
            conex=conecta.getConex();
            sta=conex.prepareCall(registra1);
            sta.setString(1, a.getNombre());
            sta.setString(2, a.getApellido_p());
            sta.setString(3, a.getApellido_m());
            sta.setInt(4, a.getPeso());
            sta.setInt(5, a.getAltura());
            sta.setInt(6, a.getSexo());
            sta.setDate(7, a.getFecha_naci());
            sta.setString(8, correo);
            sta.setString(9, id_dispositivo);
            resul=sta.executeQuery();
            if(resul.next()){
                id=resul.getInt(1);
                for(int i=0;i<afecciones.size();i++){
                    sta=conex.prepareCall(registra2);
                    sta.setInt(1, id);
                    sta.setInt(2, (int)(afecciones.get(i)));
                    sta.executeQuery();
                }
                valida=1;
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
    public infante traeinfante(int id_infante, String correo) {
        infante infan=null;
        try{
            conexion_base conecta=new conexion_base();
            conex=conecta.getConex();
            sta=conex.prepareCall(traeuno);
            sta.setInt(1, id_infante);
            sta.setString(2, correo);
            resul=sta.executeQuery();
            if(resul.next()){
                infan=new infante(resul.getInt(1), resul.getString(2), resul.getString(3), resul.getString(4), resul.getInt(5), resul.getInt(6), resul.getInt(7), resul.getDate(8));
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return infan;
    }

    @Override
    public int actualizainfante(infante a,String id_dispositivo,ArrayList afecciones) {
        int valida=0;
        try{
            conexion_base conecta=new conexion_base();
            conex=conecta.getConex();
            sta=conex.prepareCall("");
            sta=conex.prepareCall(actualiza1);
            sta.setString(1, a.getNombre());
            sta.setString(2, a.getApellido_p());
            sta.setString(3, a.getApellido_m());
            sta.setInt(4, a.getPeso());
            sta.setInt(5, a.getAltura());
            sta.setInt(6, a.getSexo());
            sta.setDate(7, a.getFecha_naci());
            sta.setString(8, "");
            sta.setString(9, id_dispositivo);
            sta.setInt(10, a.getId_infante());
            resul=sta.executeQuery();
            if(resul.next()){
                sta=conex.prepareCall(elimina_lazos);
                sta.setInt(1, a.getId_infante());
                sta.executeQuery();
                for(int i=0;i<afecciones.size();i++){
                    sta=conex.prepareCall(registra2);
                    sta.setInt(1, a.getId_infante());
                    sta.setInt(2, (int)(afecciones.get(i)));
                    sta.executeQuery();
                }
                valida=1;
            }
            conex.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
        return valida;
    }

    @Override
    public int borrainfante(int id_infante) {
        int valida=0;
        try{
            conexion_base coneta=new conexion_base();
            conex=coneta.getConex();
            sta=conex.prepareCall(elimina_infante);
            sta.setInt(1, id_infante);
            resul=sta.executeQuery();
            if(resul.next()){
                valida=resul.getInt(1);
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return valida;
    }

    @Override
    public ArrayList<infante> treinfantes(String correo) {
        ArrayList<infante> lista=new ArrayList<>();
        try{
            conexion_base conecta=new conexion_base();
            conex=conecta.getConex();
            sta=conex.prepareCall(llamar);
            sta.setString(1, correo);
            resul=sta.executeQuery();
            while(resul.next()){
                lista.add(new infante(resul.getInt(1), resul.getString(2), resul.getString(3), resul.getString(4), resul.getInt(5), resul.getInt(6), resul.getInt(7), resul.getDate(8)));
            }
            conex.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return lista;
    }
}