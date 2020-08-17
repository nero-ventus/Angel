package com.angel.impdao;

import com.angel.bd.conexion_base;
import com.angel.dao.Icodigo_ventadao;
import com.angel.modelo.codigo_venta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class impcodigo_venta implements Icodigo_ventadao{
    private final String registra="call sp_codigo_venta(0,?,2)";
    private ResultSet resul;
    private Connection conex;
    private PreparedStatement sta;
    @Override
    public int altacodigo_venta(codigo_venta a) {
        int validado=0;
        try{
            conexion_base conecta=new conexion_base();
            conex=conecta.getConex();
            sta=conex.prepareCall(registra);
            sta.setString(1, a.getCodigo());
            resul=sta.executeQuery();
            if(resul.next()){
                if(resul.getInt(1)==1){
                    validado=1;
                }
            }
            conex.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return validado;
    }

    @Override
    public codigo_venta traecodigo_venta(String codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizacodigo_venta(codigo_venta a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void borracodigo_venta(String codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}