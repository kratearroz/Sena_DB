/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dbproyecto;

import Controlador.ControladorVistaUsuarioAdminAgregar;
import Controlador.ControladorVistaUsuarioAdminConsultar;
import Controlador.ControladorVistaUsuarioAdminModificar;

/**
 *
 * @author pc
 */
public class DBProyecto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ControladorVistaUsuarioAdminModificar control=new ControladorVistaUsuarioAdminModificar();
        ControladorVistaUsuarioAdminConsultar control1=new ControladorVistaUsuarioAdminConsultar();
        ControladorVistaUsuarioAdminAgregar control2=new ControladorVistaUsuarioAdminAgregar();
    }
    
}
