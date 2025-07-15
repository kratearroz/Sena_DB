/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Modelo.Usuario;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

/**
 *
 * @author pc
 */
public class UsuarioDAO {

    public void insertarUsuario(Usuario user) {

        String sql = "INSERT INTO usuario(id_cc,contraseña,correo,nombre) VALUES(?,?,?,?)";
        Connection con = ConectarBD.obtenerConexion();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user.getId_cc());
            ps.setString(2, user.getContraseña());
            ps.setString(3, user.getCorreo());
            ps.setString(4, user.getNombre());
            int filas = ps.executeUpdate();
            if (filas > 0) {
                System.out.println("✅ Usuario insertado correctamente");

            }
        } catch (SQLException e) {
            String erro=e.toString();
            if (erro.equals("java.sql.SQLIntegrityConstraintViolationException: Duplicate entry '1014' for key 'usuario.PRIMARY'")) {
                JOptionPane.showMessageDialog(null, "Error: ya existe el usuario");
            } else {
                JOptionPane.showMessageDialog(null, "Error: " + e);
                System.out.println(e);
            }

        }
    }

    public List<Usuario> listarUsuarios() {
        List<Usuario> lista = new ArrayList<>();
        String sql = "SELECT * FROM usuario";

        try (
                Connection con = ConectarBD.obtenerConexion(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Usuario user = new Usuario();
                user.setId_cc(rs.getString("id_cc"));
                user.setContraseña(rs.getString("contraseña"));
                user.setCorreo(rs.getString("correo"));
                user.setNombre(rs.getString("nombre"));

                lista.add(user);
            }

        } catch (SQLException e) {
            System.out.println("❌ Error al consultar usuarios: " + e.getMessage());
        }

        return lista;
    }

    public boolean actualizarUsuario(Usuario user) {
        String sql = "UPDATE usuario SET contraseña = ?, correo = ?, nombre = ? WHERE id_cc = ?";

        try (
                Connection con = ConectarBD.obtenerConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            if (con == null) {
                System.out.println("❌ No hay conexión a la base de datos");
                return false;
            }

            ps.setString(1, user.getContraseña());
            ps.setString(2, user.getCorreo());
            ps.setString(3, user.getNombre());
            ps.setString(4, user.getId_cc());

            int filas = ps.executeUpdate();
            if (filas > 0) {
                System.out.println("✅ Usuario actualizado correctamente");
                return true;
            } else {
                System.out.println("⚠️ No se encontró el usuario con id_cc = " + user.getId_cc());
            }

        } catch (SQLException e) {
            System.out.println("❌ Error al actualizar usuario: " + e.getMessage());
        }

        return false;
    }

    public boolean eliminarUsuario(String id_cc) {
        String sql = "DELETE FROM usuario WHERE id_cc = ?";

        try (
                Connection con = ConectarBD.obtenerConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            if (con == null) {
                System.out.println("❌ No hay conexión a la base de datos");
                return false;
            }

            ps.setString(1, id_cc);

            int filas = ps.executeUpdate();
            if (filas > 0) {
                System.out.println("🗑️ Usuario eliminado correctamente");
                return true;
            } else {
                System.out.println("⚠️ No se encontró el usuario con id_cc = " + id_cc);
            }

        } catch (SQLException e) {
            System.out.println("❌ Error al eliminar usuario: " + e.getMessage());
        }

        return false;
    }
}
