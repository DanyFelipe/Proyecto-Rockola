/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restful.resource;

import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import restful.Model.CancionModel;
import restful.service.CancionService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;

@Path("canciones")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CancionResource {

    CancionService servicio = new CancionService();

    @GET
    public ArrayList<CancionModel> getClientes() {

        return servicio.getClientes();
    }

    @Path("/{idCancion}")
    @GET
    public CancionModel getCliente(@PathParam("idCancion") int id) {

        return servicio.getCliente(id);
    }

    @POST
    public CancionModel addCliente(String JSON) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        CancionModel cliente = gson.fromJson(JSON, CancionModel.class);
        return servicio.addCliente(cliente);
    }

    @DELETE
    @Path("/{idCancion}")
    public String delCliente(@PathParam("idCancion") int id) {

        return servicio.delCliente(id);

    }

    @PUT
    public CancionModel updateCliente(String JSON) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        CancionModel cliente = gson.fromJson(JSON, CancionModel.class);
        return servicio.updateCliente(cliente);
    }

}
