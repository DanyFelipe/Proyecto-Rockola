
package restful.service;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import restful.Model.ArtistaModel;
import restful.Model.Conexion;

public class ArtistaService {
    
    public ArrayList<ArtistaModel> getArtistas() {
        ArrayList<ArtistaModel> lista = new ArrayList<>();
        Conexion conn = new Conexion();
        String sql = "SELECT * FROM Artistas";

        try {
            Statement stm = conn.getCon().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                ArtistaModel artista = new ArtistaModel();
                //artista.setIdArtista(rs.getInt("idArtista"));
                artista.setNombre(rs.getString("nombre"));
                lista.add(artista);
            }
        } catch (SQLException e) {
        }

        return lista;
    }
    
    public ArtistaModel getArtista(int id) {
        ArtistaModel artista = new ArtistaModel();
        Conexion conex = new Conexion();
        String Sql = "SELECT * FROM Artistas WHERE idArtista = ?";

        try {

            PreparedStatement pstm = conex.getCon().prepareStatement(Sql);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {

                artista.setIdArtista(rs.getInt("idArtista"));
                artista.setNombre(rs.getString("nombre"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return artista;
    }
    
    public ArtistaModel addArtista(ArtistaModel artista) {
        Conexion conex = new Conexion();
        String Sql = "INSERT INTO Artistas (nombre)";
        Sql = Sql + "values (?)";

        try {
            PreparedStatement pstm = conex.getCon().prepareStatement(Sql);
            pstm.setString(2, artista.getNombre());
            pstm.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
        return artista;
    }
    
    public ArtistaModel updateArtista(ArtistaModel artista) {
        Conexion conn = new Conexion();
        String sql = "UPDATE Artistas SET nombre=? WHERE idArtista= ?";
        try {
            PreparedStatement pstm = conn.getCon().prepareStatement(sql);
            pstm.setInt(1, artista.getIdArtista());
            pstm.setString(2, artista.getNombre());
            pstm.executeUpdate();
        } catch (SQLException excepcion) {
            System.out.println("Ha ocurrido un error al eliminar  " + excepcion.getMessage());
            return null;
        }
        return artista;
    }
    
    public String delArtista(int id) {
        Conexion conn = new Conexion();

        String sql = "DELETE FROM Artistas WHERE idArtista= ?";
        try {
            PreparedStatement pstm = conn.getCon().prepareStatement(sql);
            pstm.setInt(1, id);
            pstm.executeUpdate();
        } catch (SQLException excepcion) {
            System.out.println("Ha ocurrido un error al eliminar  " + excepcion.getMessage());
            return "{\"Accion\":\"Error\"}";
        }
        return "{\"Accion\":\"Registro Borrado\"}";
    }
}
