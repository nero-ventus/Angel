package com.angel.api;

import com.angel.dao.Iusuariodao;
import com.angel.impdao.impusuario;
import com.angel.modelo.cuenta_usuario;
import com.angel.modelo.usuario;
import com.google.gson.Gson;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.owasp.esapi.ESAPI;

/**
 *
 * @author devil
 */
@Path("iniciar")
public class ws_inicia {
    @GET
    @Path("/{correo}/{contra}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getrespuesta(@PathParam("correo") String correo, @PathParam("contra") String contra){
        Iusuariodao user=new impusuario();
        usuario usua=null;
        cuenta_usuario cuenta=null;
        int valida=0;
        int acceso=0;
        String correo_1=ESAPI.encoder().encodeForHTML(correo);
        String contra_1=ESAPI.encoder().encodeForHTML(contra);
        try {
            cuenta=new cuenta_usuario(correo_1, contra_1, 0, "0");
            valida=1;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        if(valida==1){
            usua=user.traeusuario(cuenta);
            if(!(usua==null)){
                System.out.println("Accedo concedido");
                acceso=1;
            }
            else{
                System.out.println("Acceso denegado");
                acceso=0;
            }
        }
        return Response.ok("{\"acceso\":"+acceso+"}").build();
    }
}