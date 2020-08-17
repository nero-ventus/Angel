/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.angel.api;

import com.angel.dao.Idispositivodao;
import com.angel.impdao.impdispositivo;
import com.angel.modelo.dispositivo;
import com.google.gson.Gson;
import java.util.ArrayList;
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
@Path("dispo")
public class ws_dispositivos {
    @GET
    @Path("/{correo}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getdispos(@PathParam("correo") String correo){
        Idispositivodao controla_dispos=new impdispositivo();
        ArrayList<dispositivo> lista_dispos=controla_dispos.tredispositivosOcupados(ESAPI.encoder().encodeForHTML(correo));
        Gson transforma=new Gson();
        String json=transforma.toJson(lista_dispos);
        return Response.ok(json).build();
    }
}
