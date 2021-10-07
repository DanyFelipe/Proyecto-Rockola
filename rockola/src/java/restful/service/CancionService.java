package restful.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import restful.Model.CancionModel;
import restful.Model.Conexion;
public class CancionService {

    public ArrayList<CancionModel> getClientes() {
        ArrayList<CancionModel> lista = new ArrayList<>();
        Conexion conn = new Conexion();
        String sql = "SELECT * FROM Canciones";

        try {
            Statement stm = conn.getCon().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                CancionModel cliente = new CancionModel();
                cliente.setIdCancion(rs.getInt("idCancion"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setGeneros(rs.getString("generos"));
                cliente.setCreated_at(rs.getString("created_at"));
                cliente.setArtista(rs.getString("artista"));
                lista.add(cliente);
            }
        } catch (SQLException e) {
        }

        return lista;
    }

    public CancionModel getCliente(int id) {
        CancionModel cliente = new CancionModel();
        Conexion conex = new Conexion();
        String Sql = "SELECT * FROM Canciones WHERE idCancion = ?";

        try {

            PreparedStatement pstm = conex.getCon().prepareStatement(Sql);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {

                cliente.setIdCancion(rs.getInt("idCancion"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setGeneros(rs.getString("generos"));
                cliente.setCreated_at(rs.getString("created_at"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return cliente;
    }

    public CancionModel addCliente(CancionModel cliente) {
        Conexion conex = new Conexion();
        String Sql = "INSERT INTO Canciones(idCancion,nombre,generos,artista)";
        Sql = Sql + "values (?,?,?)";

        try {
            PreparedStatement pstm = conex.getCon().prepareStatement(Sql);
            pstm.setInt(1, cliente.getIdCancion());
            pstm.setString(2, cliente.getNombre());
            pstm.setString(3, cliente.getGeneros());
            pstm.setString(4, cliente.getArtista());
            pstm.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
        return cliente;
    }

    public CancionModel updateCliente(CancionModel cliente) {
        Conexion conn = new Conexion();
        String sql = "UPDATE Canciones SET nombre=?,generos=?,artista=? WHERE idArtista= ?";
        try {
            PreparedStatement pstm = conn.getCon().prepareStatement(sql);
            pstm.setString(1, cliente.getNombre());
            pstm.setString(2, cliente.getGeneros());
            pstm.setString(3, cliente.getArtista());
            pstm.setInt(4, cliente.getIdCancion());
            pstm.executeUpdate();
        } catch (SQLException excepcion) {
            System.out.println("Ha ocurrido un error al eliminar  " + excepcion.getMessage());
            return null;
        }
        return cliente;
    }

    public String delCliente(int id) {
        Conexion conn = new Conexion();

        String sql = "DELETE FROM Canciones WHERE idCancion= ?";
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
