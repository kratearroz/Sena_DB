/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Dao.UsuarioDAO;
import Modelo.Usuario;
import Modelo.Validaciones;
import Vista.UsuarioAdmin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author pc
 */
public class ControladorVistaUsuarioAdminAgregar implements ActionListener {

    UsuarioAdmin vis;
    UsuarioDAO mod1;
    Usuario mod;

    public ControladorVistaUsuarioAdminAgregar() {
        vis = UsuarioAdmin.getInstancia();
        vis.setVisible(true);
        vis.getBotonAgregar().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vis.getBotonAgregar()) {
            boolean bandera = false;
            String texto = "";
            String cc = vis.getTxtCCAgreUsu().getText();
            if (!Validaciones.soloNumero(cc)) {
                bandera = true;
                texto += " Error: CC no es valido ";
            }
            String nombre = vis.getTxtNombreAgreUsu().getText();
            String correo = vis.getTxtCorreoAgreUsu().getText();
            if (!Validaciones.soloCorreo(correo)) {
                bandera = true;
                texto += " Error: Correo no es valido ";
            }
            String contraseña = vis.getTxtContraseñaAgreUsu().getText();
            if (cc.equals("") || nombre.equals("") || correo.equals("") || contraseña.equals("")) {
                bandera = true;
                texto += " Error: Hay espacios vacios";
            }
            if (bandera == false) {
                mod = new Usuario(cc, contraseña, correo, nombre);
                mod1 = new UsuarioDAO();
                mod1.insertarUsuario(mod);
            }
            else{
                JOptionPane.showMessageDialog(null,texto,"Advertencia",1);
            }

        }
    }

}
