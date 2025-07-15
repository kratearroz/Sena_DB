package Dao;

import Modelo.ObjetoDeTrueque;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ObjetoDeTruequeDAO {

    public boolean insertarObjeto(ObjetoDeTrueque obj) {
        String sql = "INSERT INTO objeto_de_trueque (id_objeto, nombre, Descripcion, valor_estimado, id_transaccion) VALUES (?, ?, ?, ?, ?)";

        try (
            Connection con = ConectarBD.obtenerConexion();
            PreparedStatement ps = con.prepareStatement(sql)
        ) {
            ps.setString(1, obj.getIdObjeto());
            ps.setString(2, obj.getNombre());
            ps.setString(3, obj.getDescripcion());
            ps.setInt(4, obj.getValorEstimado());
            ps.setString(5, obj.getIdTransaccion());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("❌ Error al insertar objeto: " + e.getMessage());
            return false;
        }
    }

    public List<ObjetoDeTrueque> listarObjetos() {
        List<ObjetoDeTrueque> lista = new ArrayList<>();
        String sql = "SELECT * FROM objeto_de_trueque";

        try (
            Connection con = ConectarBD.obtenerConexion();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()
        ) {
            while (rs.next()) {
                ObjetoDeTrueque obj = new ObjetoDeTrueque();
                obj.setIdObjeto(rs.getString("id_objeto"));
                obj.setNombre(rs.getString("nombre"));
                obj.setDescripcion(rs.getString("Descripcion"));
                obj.setValorEstimado(rs.getInt("valor_estimado"));
                obj.setIdTransaccion(rs.getString("id_transaccion"));

                lista.add(obj);
            }
        } catch (SQLException e) {
            System.out.println("❌ Error al consultar objetos: " + e.getMessage());
        }

        return lista;
    }

    public boolean actualizarObjeto(ObjetoDeTrueque obj) {
        String sql = "UPDATE objeto_de_trueque SET nombre = ?, Descripcion = ?, valor_estimado = ?, id_transaccion = ? WHERE id_objeto = ?";

        try (
            Connection con = ConectarBD.obtenerConexion();
            PreparedStatement ps = con.prepareStatement(sql)
        ) {
            ps.setString(1, obj.getNombre());
            ps.setString(2, obj.getDescripcion());
            ps.setInt(3, obj.getValorEstimado());
            ps.setString(4, obj.getIdTransaccion());
            ps.setString(5, obj.getIdObjeto());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("❌ Error al actualizar objeto: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminarObjeto(String idObjeto) {
        String sql = "DELETE FROM objeto_de_trueque WHERE id_objeto = ?";

        try (
            Connection con = ConectarBD.obtenerConexion();
            PreparedStatement ps = con.prepareStatement(sql)
        ) {
            ps.setString(1, idObjeto);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("❌ Error al eliminar objeto: " + e.getMessage());
            return false;
        }
    }
}


