/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.angel.api;

import com.angel.dao.Iconfig_lexternadao;
import com.angel.impdao.impconfig_lexterna;
import com.angel.modelo.config_lexterna;
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
@Path("configex")
public class ws_configex {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{correo}")
    public Response getconfigex(@PathParam("correo")String correo){
        String correo_esapi=ESAPI.encoder().encodeForHTML(correo);
        Iconfig_lexternadao controla_configex=new impconfig_lexterna();
        config_lexterna config=controla_configex.traeconfig_lexterna(correo_esapi);
        Gson tranforma=new Gson();
        String json=tranforma.toJson(config);
        return Response.ok(json).build();
    }
}
