
package restful.Model;
import java.util.ArrayList;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CancionModel {
    private int idCancion;
    private String nombre;
    private String generos;
    private String created_at;
    private String artista;

    public CancionModel(int idCancion, String nombre, String generos, String created_at, int idArtista, String artista) {
        this.idCancion = idCancion;
        this.nombre = nombre;
        this.generos = generos;
        this.created_at = created_at;
        this.artista = artista;
    }

    public CancionModel() {
    }

    public int getIdCancion() {
        return idCancion;
    }

    public void setIdCancion(int idCancion) {
        this.idCancion = idCancion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGeneros() {
        return generos;
    }

    public void setGeneros(String generos) {
        this.generos = generos;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    
}

