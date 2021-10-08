/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restful;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author GAMER
 */
@Path("usuario")
public class Recurso {
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getXml() {
        //TODO return proper representation object
        return "HOLA - API USUARIO";
    }
    
    @GET
    @Path("otro")
    @Produces(MediaType.TEXT_PLAIN)
    public String saludar() {
        //TODO return proper representation object
        return "HOLA - API USUARIO, OTRO";
    }
}