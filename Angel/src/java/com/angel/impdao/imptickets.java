/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.angel.impdao;

import com.angel.bd.conexion_base;
import com.angel.dao.Iticketsdao;
import com.angel.modelo.tickets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Profesor
 */
public class imptickets implements Iticketsdao{
    Connection conex=null;
    PreparedStatement sta=null;
    ResultSet resul=null;
    private final String registra="call sp_registra_ticket(?,?,?);";
    private final String trae_uno="call sp_trae_ticket(?);";
    private final String actualiza_estado="call sp_actualiza_ticket_estado(?);";
    private final String actualiza="call sp_responde_ticket(?,?,?);";
    private final String trae_varios="call sp_trae_tickets(?);";
    @Override
    public int altaticket(tickets a) {
        int valida=0;
        try{
            conexion_base conecta=new conexion_base();
            conex=conecta.getConex();
            sta=conex.prepareCall(registra);
            sta.setInt(1, a.getId_usuario());
            sta.setInt(2, a.getModulo());
            sta.setString(3, a.getPregunta());
            resul=sta.executeQuery();
            if(resul.next()){
                valida=resul.getInt(1);
                conex.close();
            }
        }
        catch(Exception e){
            e.printStackTrace();
            valida=0;
        }
        return valida;    
    }

    @Override
    public tickets traeticket(int id_ticket) {
        tickets vessel=null;
        try{
            conexion_base conecta=new conexion_base();
            conex=conecta.getConex();
            sta=conex.prepareCall(trae_uno);
            sta.setInt(1, id_ticket);
            resul=sta.executeQuery();
            if(resul.next()){
                vessel=new tickets(resul.getInt(1), resul.getInt(2), resul.getString(3), resul.getInt(4), resul.getInt(5), resul.getString(6), resul.getString(7));
                conex.close();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return vessel;
    }

    @Override
    public int actualizaticketestado(int modulo) {
        int valida=0;
        try{
            conexion_base conecta=new conexion_base();
            conex=conecta.getConex();
            sta=conex.prepareCall(actualiza_estado);
            sta.setInt(1, modulo);
            resul=sta.executeQuery();
            if(resul.next()){
                valida=resul.getInt(1);
                conex.close();
            }
        }
        catch(Exception e){
            e.printStackTrace();
            valida=0;
        }
        return valida;
    }

    @Override
    public int actualizaticket(int id_ticket, String correo_admi, String respuesta) {
        int valida=0;
        try{
            conexion_base conecta=new conexion_base();
            conex=conecta.getConex();
            sta=conex.prepareCall(actualiza);
            sta.setInt(1, id_ticket);
            sta.setString(2, correo_admi);
            sta.setString(3, respuesta);
            resul=sta.executeQuery();
            if(resul.next()){
                valida=resul.getInt(1);
                conex.close();
            }
        }
        catch(Exception e){
            e.printStackTrace();
            valida=0;
        }
        return valida;    
    }

    @Override
    public int borratickets(int id_ticket) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<tickets> traeTickets(int modulou) {
        ArrayList<tickets> lista_tickets=new ArrayList<>();
        try{
            conexion_base conecta=new conexion_base();
            conex=conecta.getConex();
            sta=conex.prepareCall(trae_varios);
            sta.setInt(1, modulou);
            resul=sta.executeQuery();
            while(resul.next()){
                lista_tickets.add(new tickets(resul.getInt(1), resul.getInt(2), resul.getString(3), resul.getInt(4), resul.getInt(5), resul.getString(6), resul.getString(7)));
            }
            conex.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return lista_tickets;
    }
    
}