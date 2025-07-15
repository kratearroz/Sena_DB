/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectarBD {

    private static final String URL = "jdbc:mysql://127.0.0.1:3306/senadb?useSSL=false&serverTimezone=UTC";
    private static final String USUARIO = "root";
    private static final String CONTRASENA = "12345";

    public static Connection obtenerConexion() {
        Connection conexion = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
        } catch (ClassNotFoundException e) {
            System.out.println("❌ Driver JDBC no encontrado: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("❌ Error al conectar con la base de datos: " + e.getMessage());
        }

        return conexion;
    }
}
