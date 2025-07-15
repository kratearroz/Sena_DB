package dao;

import Dao.ConectarBD;
import Modelo.ArticuloVenta;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArticuloVentaDAO {

    public boolean insertarArticulo(ArticuloVenta art) {
        String sql = "INSERT INTO articulo_venta (id_objeto, nombre, Descripcion, valor_estimado) VALUES (?, ?, ?, ?)";
        Connection con = ConectarBD.obtenerConexion();
        try (
            
            PreparedStatement ps = con.prepareStatement(sql)
        ) {
            ps.setString(1, art.getIdObjeto());
            ps.setString(2, art.getNombre());
            ps.setString(3, art.getDescripcion());
            ps.setInt(4, art.getValorEstimado());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("❌ Error al insertar artículo: " + e.getMessage());
            return false;
        }
    }

    public List<ArticuloVenta> listarArticulos() {
        List<ArticuloVenta> lista = new ArrayList<>();
        String sql = "SELECT * FROM articulo_venta";

        try (
            Connection con = ConectarBD.obtenerConexion();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()
        ) {
            while (rs.next()) {
                ArticuloVenta art = new ArticuloVenta();
                art.setIdObjeto(rs.getString("id_objeto"));
                art.setNombre(rs.getString("nombre"));
                art.setDescripcion(rs.getString("Descripcion"));
                art.setValorEstimado(rs.getInt("valor_estimado"));

                lista.add(art);
            }
        } catch (SQLException e) {
            System.out.println("❌ Error al consultar artículos: " + e.getMessage());
        }

        return lista;
    }

    public boolean actualizarArticulo(ArticuloVenta art) {
        String sql = "UPDATE articulo_venta SET nombre = ?, Descripcion = ?, valor_estimado = ? WHERE id_objeto = ?";

        try (
            Connection con = ConectarBD.obtenerConexion();
            PreparedStatement ps = con.prepareStatement(sql)
        ) {
            ps.setString(1, art.getNombre());
            ps.setString(2, art.getDescripcion());
            ps.setInt(3, art.getValorEstimado());
            ps.setString(4, art.getIdObjeto());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("❌ Error al actualizar artículo: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminarArticulo(String idObjeto) {
        String sql = "DELETE FROM articulo_venta WHERE id_objeto = ?";

        try (
            Connection con = ConectarBD.obtenerConexion();
            PreparedStatement ps = con.prepareStatement(sql)
        ) {
            ps.setString(1, idObjeto);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("❌ Error al eliminar artículo: " + e.getMessage());
            return false;
        }
    }
}

