/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

/**
 *
 * @author pc
 */

import Modelo.Pago;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
public class PagoDAO {

    public boolean insertarPago(Pago pago) {
        String sql = "INSERT INTO pago (idPago, valor_pagado) VALUES (?, ?)";
        Connection con =(Connection) ConectarBD.obtenerConexion();
        try (
            
            PreparedStatement ps = con.prepareStatement(sql)
        ) {
            ps.setString(1, pago.getIdPago());
            ps.setInt(2, pago.getValor_pagado());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("❌ Error al insertar pago: " + e.getMessage());
        }

        return false;
    }

    public List<Pago> listarPagos() {
        List<Pago> lista = new ArrayList<>();
        String sql = "SELECT * FROM pago";

        try (
            Connection con = ConectarBD.obtenerConexion();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()
        ) {
            while (rs.next()) {
                Pago pago = new Pago();
                pago.setIdPago(rs.getString("idPago"));
                pago.setValor_pagado(rs.getInt("valor_pagado"));
                lista.add(pago);
            }
        } catch (SQLException e) {
            System.out.println("❌ Error al consultar pagos: " + e.getMessage());
        }

        return lista;
    }

    public boolean actualizarPago(Pago pago) {
        String sql = "UPDATE pago SET valor_pagado = ? WHERE idPago = ?";

        try (
            Connection con = ConectarBD.obtenerConexion();
            PreparedStatement ps = con.prepareStatement(sql)
        ) {
            ps.setInt(1, pago.getValor_pagado());
            ps.setString(2, pago.getIdPago());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("❌ Error al actualizar pago: " + e.getMessage());
        }

        return false;
    }

    public boolean eliminarPago(String idPago) {
        String sql = "DELETE FROM pago WHERE idPago = ?";

        try (
            Connection con = ConectarBD.obtenerConexion();
            PreparedStatement ps = con.prepareStatement(sql)
        ) {
            ps.setString(1, idPago);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("❌ Error al eliminar pago: " + e.getMessage());
        }

        return false;
    }
}

