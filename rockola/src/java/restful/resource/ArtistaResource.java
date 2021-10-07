
package restful.resource;
import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import restful.Model.ArtistaModel;
import restful.service.ArtistaService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;

@Path("artistas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ArtistaResource {
    
    ArtistaService servicio = new ArtistaService();

    @GET
    public ArrayList<ArtistaModel> getArtistas() {

        return servicio.getArtistas();
    }
    
    @Path("/{idArtista}")
    @GET
    public ArtistaModel getArtista(@PathParam("idArtista") int id) {

        return servicio.getArtista(id);
    }
    
    @POST
    public ArtistaModel addArtista(String JSON) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        ArtistaModel artista = gson.fromJson(JSON, ArtistaModel.class);
        return servicio.addArtista(artista);
    }
    
    @DELETE
    @Path("/{idArtista}")
    public String delArtista(@PathParam("idArtista") int id) {

        return servicio.delArtista(id);
    }
    
    @PUT
    public ArtistaModel updateArtista(String JSON) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        ArtistaModel artista = gson.fromJson(JSON, ArtistaModel.class);
        return servicio.updateArtista(artista);
    }
}
