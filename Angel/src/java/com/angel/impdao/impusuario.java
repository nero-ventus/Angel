package com.angel.impdao;
import com.angel.bd.conexion_base;
import com.angel.dao.Iinfantedao;
import com.angel.dao.Iusuariodao;
import com.angel.modelo.cuenta_usuario;
import com.angel.modelo.direccion;
import com.angel.modelo.infante;
import com.angel.modelo.usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
@WebService(serviceName = "manejo_usuario")
public class impusuario implements Iusuariodao{
    private final String c_registro="call sp_usuario(0,?,?,?,?,?,?,?,?,?,?,'0')";
    private final String c_getusuario="call sp_getusuario(?,?)";
    private final String c_actualiza="call sp_usuario(1,?,?,?,?,?,?,?,?,?,?,?)";
    private final String elimina_usuario="call sp_delete_usuario(?)";
    Connection conex=null;
    PreparedStatement sta=null;
    ResultSet resul=null;
    @Override @WebMethod(operationName = "registar_usuario")
    public int altausuario(@WebParam(name = "user")usuario a,@WebParam(name = "datos_cuenta") cuenta_usuario b,@WebParam(name = "datos_direc") direccion c) {
        conexion_base conecta=new conexion_base();
        conex=conecta.getConex();
        int valida=0;
        try{
            sta=conex.prepareCall(c_registro);
            sta.setString(1, a.getNombre());
            sta.setString(2, a.getApellido_p());
            sta.setString(3, a.getApellido_m());
            sta.setString(4, a.getCorreo());
            sta.setString(5, b.getContra());
            sta.setString(6, b.getCodigo());
            sta.setInt(7, c.getN_exterior());
            sta.setString(8, c.getCalle());
            sta.setString(9, c.getMunicipio());
            sta.setInt(10, c.getId_estado());
            resul=sta.executeQuery();
            if(resul.next()){
                valida=resul.getInt(1);
            }
            conex.close();
        }
        catch(Exception e){
            System.out.println("El error es: "+e.getMessage());
        }
        return valida;
    }

    @Override @WebMethod(operationName = "consultar_usuario")
    public usuario traeusuario(@WebParam(name = "datos_cuenta")cuenta_usuario cuenta) {
        conexion_base conecta=new conexion_base();
        conex=conecta.getConex();
        usuario usua=null;
        int valida=0;
        try{
            sta=conex.prepareCall(c_getusuario);
            sta.setString(1, cuenta.getCorreo());
            sta.setString(2, cuenta.getContra());
            resul=sta.executeQuery();
            if(resul.next()){
                usua=new usuario(resul.getInt(1), resul.getString(2), resul.getString(3), resul.getString(4), resul.getInt(5), resul.getString(6));
            }
            conex.close();
        }
        catch(Exception e){
            System.out.println("El error es: "+e.getMessage()+e.getCause());
        }
        return usua;
    }

    @Override @WebMethod(operationName = "actualizar_usuario")
    public int actualizausuario(@WebParam(name = "user")usuario a,@WebParam(name = "datos_cuenta")cuenta_usuario b, @WebParam(name = "datos_direc")direccion c,@WebParam(name = "Correo original")String correoo) {
        int validado=0;
        conexion_base conecta=new conexion_base();
        try{
            conex=conecta.getConex();
            sta=conex.prepareCall(c_actualiza);
            sta.setString(1, a.getNombre());
            sta.setString(2, a.getApellido_p());
            sta.setString(3, a.getApellido_m());
            sta.setString(4, a.getCorreo());
            sta.setString(5, b.getContra());
            sta.setString(6, "nada");
            sta.setInt(7, c.getN_exterior());
            sta.setString(8, c.getCalle());
            sta.setString(9, c.getMunicipio());
            sta.setInt(10, c.getId_estado());
            sta.setString(11, correoo);
            resul=sta.executeQuery();
            if(resul.next()){
                validado=resul.getInt(1);
            }
            conex.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return validado;
    }

    @Override @WebMethod(operationName = "eliminar_usuario")
    public int borrausuario(@WebParam(name = "correo")String correo) {
        int valida=0;
        try{
            conexion_base conecta=new conexion_base();
            conex=conecta.getConex();
            Iinfantedao controla_infan=new impinfante();
            ArrayList<infante> lista_infantes=controla_infan.treinfantes(correo);
            for (int i=0;i<lista_infantes.size();i++){
                controla_infan.borrainfante(lista_infantes.get(i).getId_infante());
            }
            sta=conex.prepareCall(elimina_usuario);
            sta.setString(1, correo);
            resul=sta.executeQuery();
            if(resul.next()){
                valida=resul.getInt(1);
            }
            conex.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return valida;
    }
}