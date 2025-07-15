/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Modelo.ArticuloTransaccion;
import Modelo.ArticuloVenta;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArticuloTransaccionDAO {

    public boolean insertarRelacion(ArticuloTransaccion at) {
        String sql = "INSERT INTO articulo_transaccion (id_transaccion, id_objeto) VALUES (?, ?)";

        try (
            Connection con = ConectarBD.obtenerConexion();
            PreparedStatement ps = con.prepareStatement(sql)
        ) {
            ps.setString(1, at.getIdTransaccion());
            ps.setString(2, at.getIdObjeto());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("❌ Error al insertar relación: " + e.getMessage());
        }

        return false;
    }

    public boolean eliminarRelacion(String idTransaccion, String idObjeto) {
        String sql = "DELETE FROM articulo_transaccion WHERE id_transaccion = ? AND id_objeto = ?";

        try (
            Connection con = ConectarBD.obtenerConexion();
            PreparedStatement ps = con.prepareStatement(sql)
        ) {
            ps.setString(1, idTransaccion);
            ps.setString(2, idObjeto);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("❌ Error al eliminar relación: " + e.getMessage());
        }

        return false;
    }

    public List<ArticuloVenta> listarArticulosPorTransaccion(String idTransaccion) {
        List<ArticuloVenta> lista = new ArrayList<>();
        String sql = """
            SELECT av.* FROM articulo_venta av
            JOIN articulo_transaccion at ON av.id_objeto = at.id_objeto
            WHERE at.id_transaccion = ?
        """;

        try (
            Connection con = ConectarBD.obtenerConexion();
            PreparedStatement ps = con.prepareStatement(sql)
        ) {
            ps.setString(1, idTransaccion);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ArticuloVenta art = new ArticuloVenta();
                art.setIdObjeto(rs.getString("id_objeto"));
                art.setNombre(rs.getString("nombre"));
                art.setDescripcion(rs.getString("Descripcion"));
                art.setValorEstimado(rs.getInt("valor_estimado"));

                lista.add(art);
            }

        } catch (SQLException e) {
            System.out.println("❌ Error al listar artículos por transacción: " + e.getMessage());
        }

        return lista;
    }
}

