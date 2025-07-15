package Dao;

import Modelo.Transaccion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import dao.ConectarBD;

public class TransaccionDAO {

    public boolean insertarTransaccion(Transaccion tx) {
        String sql = "INSERT INTO transaccion (id_transaccion, tipo_transaccion, fecha, cc_ciudadania, id_pago) VALUES (?, ?, ?, ?, ?)";
        Connection con =(Connection) ConectarBD.obtenerConexion();
        try (
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, tx.getId_transaccion());
            ps.setString(2, tx.getTipo_transaccion());
            ps.setDate(3, tx.getFecha());
            ps.setString(4, tx.getCc_ciudadania());
            ps.setString(5, tx.getId_pago());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("❌ Error al insertar transacción: " + e.getMessage());
            return false;
        }
    }

    public List<Transaccion> listarTransacciones() {
        List<Transaccion> lista = new ArrayList<>();
        String sql = "SELECT * FROM transaccion";

        try (
                Connection con = ConectarBD.obtenerConexion(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Transaccion tx = new Transaccion();
                tx.setId_transaccion(rs.getString("id_transaccion"));
                tx.setTipo_transaccion(rs.getString("tipo_transaccion"));
                tx.setFecha(rs.getDate("fecha"));
                tx.setCc_ciudadania(rs.getString("cc_ciudadania"));
                tx.setId_pago(rs.getString("id_pago"));

                lista.add(tx);
            }
        } catch (SQLException e) {
            System.out.println("❌ Error al consultar transacciones: " + e.getMessage());
        }

        return lista;
    }

    public boolean actualizarTransaccion(Transaccion tx) {
        String sql = "UPDATE transaccion SET tipo_transaccion = ?, fecha = ?, cc_ciudadania = ?, id_pago = ? WHERE id_transaccion = ?";

        try (
                Connection con = ConectarBD.obtenerConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, tx.getTipo_transaccion());
            ps.setDate(2, tx.getFecha());
            ps.setString(3, tx.getCc_ciudadania());
            ps.setString(4, tx.getId_pago());
            ps.setString(5, tx.getId_transaccion());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("❌ Error al actualizar transacción: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminarTransaccion(String idTransaccion) {
        String sql = "DELETE FROM transaccion WHERE id_transaccion = ?";

        try (
                Connection con = ConectarBD.obtenerConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, idTransaccion);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("❌ Error al eliminar transacción: " + e.getMessage());
            return false;
        }
    }
}
